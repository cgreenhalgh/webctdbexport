/**
 * 
 */
package webctdbexport.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import webctdbexport.db.CmsContentEntry;
import webctdbexport.db.CmsFileContent;
import webctdbexport.db.CmsLink;
import webctdbexport.db.LearningContext;
import webctdbexport.db.Person;

/** Helper methods for implementing Moodle 2 Repository API over WebCT-DB.
 * 
 * @author cmg
 *
 */
public class MoodleRepository {
	static Logger logger = Logger.getLogger(MoodleRepository.class.getName());
	public static final String PATH = "path";
	public static final String TITLE = "title";
	private static final String SIZE = "size";
	public static final String URL = "url";
	private static final String NAME = "name";
	public static final String LIST = "list";
	private static final String PERSON_TYPE = "p";
	private static final String LC_TYPE = "lc";
	private static final String FC_TYPE = "fc";
	private static final String CE_TYPE = "ce";
	private static final String CHILDREN = "children";
	private static JSONObject getListingObject() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("dynload", true);
		obj.put("nologin", true);
		obj.put("nosearch", true);
		return obj;
	}
	private static JSONObject getFileObject(String title, long lastModified, long size, String url) throws JSONException {
		JSONObject fileobj = new JSONObject();
		fileobj.put(TITLE, title);
//		if (lastModified!=0)
//			fileobj.put(DATE, format?);
		fileobj.put(SIZE, size);
		fileobj.put(URL, url);
		return fileobj;
	}
	private static JSONObject getFolderObject(String title, String path, long lastModified) throws JSONException {
		JSONObject fileobj = new JSONObject();
		fileobj.put(TITLE, title);
//		if (lastModified!=0)
//			fileobj.put(DATE, format?);
		fileobj.put(SIZE, 0);
		fileobj.put(PATH, path);
		return fileobj;
	}
	
	/** get_listing response for a user, i.e. modules and person 
	 * @throws JSONException */
	public static JSONObject getListingForUser(Session s, String username) throws JSONException {
		JSONObject userobj = getListingObject();
		JSONArray path = new JSONArray();
		userobj.put(PATH, path);
		
		String root = "/";
		path.put(getPathObject(root, root));
		
		JSONArray list = new JSONArray();
		userobj.put(LIST, list);

		// person for username?
		Person p = DbUtils.getPersonByWebctId(s, username);
		if (p==null) {
			logger.log(Level.WARNING, "Could not find Person "+username);
			return userobj;
		}
		list.put(getFolderObject(username, root+getFilename(p)+"/", 0));
		// LCs
		List<LearningContext> lcs = DbUtils.getLearningContextsForPersonAsRole(s, p, DbUtils.getRoleDefinitionForSectionDesigner(s));
		Collections.sort(lcs, new LearningContextComparator());
		for (LearningContext lc : lcs) {
			list.put(getFolderObject(lc.getName(), root+getFilename(lc)+"/", 0));
		}
		
		return userobj;
	}
	private static JSONObject getPathObject(String  name, String path) throws JSONException {
		JSONObject pathobj = new JSONObject();
		pathobj.put(NAME, name);
		pathobj.put(PATH, path);
		return pathobj;
	}
	private static String getFilename(Person p) {
		return PERSON_TYPE+p.getId();
	}
	private static String getFilename(LearningContext lc) {
		return LC_TYPE+lc.getId();
	}
	private static String getFilename(CmsFileContent fc) {
		return FC_TYPE+fc.getId();
	}
	/** get_listing for a path, i.e. person, learning context, content entry, ... 
	 * @throws JSONException */
	public static JSONObject getListingForPath(Session s, String path) throws JSONException {
		JSONObject listing = getListingObject();
		JSONArray patharr = new JSONArray();
		listing.put(PATH, patharr);

		String root = "/";
		patharr.put(getPathObject(root, root));

		String elements [] = path.split("/");
		for (int ei=0; ei<elements.length; ei++) {
			logger.log(Level.INFO, "Path element "+ei+": "+elements[ei]);
			// TODO ...
		}
		if (elements.length==0) {
			logger.log(Level.WARNING, "path is empty ("+path+")");
			return listing;
		}
		
		JSONArray list = new JSONArray();

		String filename = elements[elements.length-1];
		String type = getFilenameType(filename);
		BigDecimal id = getFilenameId(filename);
		
		if (PERSON_TYPE.equals(type)) {
			Person p = (Person)s.createQuery("from Person as p where p.id=?").setBigDecimal(0, id).uniqueResult();
			if (p==null) {
				logger.log(Level.WARNING, "Could not file Person "+id);
				return listing;
			}
			BigDecimal folderId = p.getHomefolderId();
			CmsContentEntry ce = (CmsContentEntry)s.createQuery("from CmsContentEntry as ce where ce.id=?").setBigDecimal(0, folderId).uniqueResult();
			list = getChildren(s, ce, path);
		}
		else if (LC_TYPE.equals(type)) {
			LearningContext lc = (LearningContext)s.createQuery("from LearningContext as lc where lc.id=?").setBigDecimal(0, id).uniqueResult();
			if (lc==null) {
				logger.log(Level.WARNING, "Could not file LearningContext "+id);
				return listing;
			}
			CmsContentEntry ce = lc.getCmsContentEntry();
			if (ce==null) {
				logger.log(Level.WARNING, "LearningContext "+id+" had no CmsContentEntry");
				return listing;				
			}
			list = getChildren(s, lc.getCmsContentEntry(), path);			
		}
		else if (CE_TYPE.equals(type)) {
			CmsContentEntry ce = (CmsContentEntry)s.createQuery("from CmsContentEntry as ce where ce.id=?").setBigDecimal(0, id).uniqueResult();
			if (ce==null) {
				logger.log(Level.WARNING, "Could not file CmsContentEntry "+id);
				return listing;
			}
			list = getChildren(s, ce, path);			
		}
		
		listing.put(LIST, sortChildren(list));
		
		return listing;
	}
	private static JSONArray sortChildren(JSONArray list) throws JSONException {
		Vector<JSONObject> items = new Vector<JSONObject>();
		for (int li=0; li<list.length(); li++)
			items.add(list.getJSONObject(li));
		Collections.sort(items, new JSONObjectTitleComparator());
		JSONArray children = new JSONArray();
		for (JSONObject o : items) 
			children.put(o);
		return children;
	}
	private static JSONArray getChildren(Session s, CmsContentEntry ce, String path) throws JSONException {
		JSONArray list = new JSONArray();
		String typename = DbUtils.getTypename(ce);
		if (DbUtils.ORGANIZER_PAGE_TYPE.equals(typename)) {
			// TODO ...
		}
		else {
			// children...
			Set<CmsContentEntry> children = ce.getCmsContentEntriesForParentId();
			for (CmsContentEntry child : children) {
				list.put(getItem(s, child, path));
			}
		}
		return list;
	}
	/** get file/folder JSONObject for this entry 
	 * @throws JSONException */
	private static JSONObject getItem(Session s, CmsContentEntry ce,
			String parentPath) throws JSONException {
		String name = ce.getName();
		return getItem(s, ce, name, parentPath);
	}
	private static JSONObject getItem(Session s, CmsContentEntry ce, String name,
			String parentPath) throws JSONException {
		CmsFileContent fc = ce.getCmsFileContent();
		if (fc!=null) {
			String filename = getFilename(fc);
			// fcNNN/actual-file-name??
			long len = 0;
			try {
				len =  fc.getContent().length();
			}
			catch (Exception e) {
				logger.log(Level.WARNING, "Could not get length of FileContent "+fc.getId(), e);
			}
			return getFileObject(name, 0, len, parentPath+filename+"/"+ce.getName());
		}
		else {
			String typename = DbUtils.getTypename(ce);
			if (DbUtils.PAGE_TYPE.equals(typename)) {
				// Page Type = link
				Set<CmsLink> links = ce.getCmsLinksForLeftobjectId();
				if (links.size()>0) {
					if (links.size()>1) {
						logger.log(Level.WARNING, "PAGE_TYPE with "+links.size()+" links! - only using first");					
					}
					CmsLink link = links.iterator().next();
					CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
					if (child!=null)
						return getItem(s, child, name, parentPath);
					logger.log(Level.WARNING,"PAGE_TYPE with link without child");
				}
				return getFileObject(name, 0, 0, parentPath+getFilename(ce)+".error");

			} else {
				// Organizer 
				// other folder type
				String filename = getFilename(ce);
				String path = parentPath+filename+"/";
				JSONObject folderobj = getFolderObject(name, path, 0);
				//folderobj.put(CHILDREN, getChildren(s, ce, path));
				return folderobj;
			}
		}
	}
	private static String getFilename(CmsContentEntry ce) {
		return CE_TYPE+ce.getId();
	}
	private static BigDecimal getFilenameId(String filename) {
		int i=0;
		while(i<filename.length() && !Character.isDigit(filename.charAt(i)))
			i++;
		return new BigDecimal(filename.substring(i));
	}
	private static String getFilenameType(String filename) {
		int i=0;
		while(i<filename.length() && !Character.isDigit(filename.charAt(i)))
			i++;
		return filename.substring(0, i);
	}
}
