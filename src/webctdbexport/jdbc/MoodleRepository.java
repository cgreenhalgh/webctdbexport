/**
 * 
 */
package webctdbexport.jdbc;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.hibernate.Query;
//import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import webctdbexport.jdbc.model.LearningContext;
import webctdbexport.utils.DbUtils;

//import webctdbexport.db.CmsContentEntry;
//import webctdbexport.db.CmsFileContent;
//import webctdbexport.db.CmsLink;
//import webctdbexport.db.CoOrganizerlink;
//import webctdbexport.db.CoUrl;
//import webctdbexport.db.LearningContext;
//import webctdbexport.db.Person;

/** Helper methods for implementing Moodle 2 Repository API over WebCT-DB.
 * JDBC-only version
 * 
 * @author cmg
 *
 */
public class MoodleRepository {
	static Logger logger = Logger.getLogger(MoodleRepository.class.getName());
	public static final String PATH = "path";
	public static final String TITLE = "title";
	public static final String SIZE = "size";
	//public static final String URL = "url";
	public static final String SOURCE = "source";
	public static final String NAME = "name";
	public static final String LIST = "list";
	private static final String PERSON_TYPE = "p";
	private static final String LC_TYPE = "lc";
	private static final String FC_TYPE = "fc";
	private static final String CE_TYPE = "ce";
	private static final String CHILDREN = "children";
	public static final String DESCRIPTION = "description";
	public static final String WEBCT_TYPE = "webcttype";
	private static JSONObject getListingObject() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("dynload", true);
		obj.put("nologin", true);
		obj.put("nosearch", true);
		return obj;
	}
	private static JSONObject getFileObject(String title, String description, String webctType, long lastModified, long size, String url) throws JSONException {
		JSONObject fileobj = new JSONObject();
		fileobj.put(TITLE, title);
		if (description!=null)
			fileobj.put(DESCRIPTION, description);
		if (webctType!=null)
			fileobj.put(WEBCT_TYPE, webctType);
//		if (lastModified!=0)
//			fileobj.put(DATE, format?);
		fileobj.put(SIZE, size);
//		fileobj.put(URL, url);
		fileobj.put(SOURCE, url);
		return fileobj;
	}
	private static JSONObject getLinkObject(String title, String description, String webctType, long lastModified, long size, String url) throws JSONException {
		JSONObject fileobj = new JSONObject();
		fileobj.put(TITLE, title);
		if (description!=null)
			fileobj.put(DESCRIPTION, description);
		if (webctType!=null)
			fileobj.put(WEBCT_TYPE, webctType);
//		if (lastModified!=0)
//			fileobj.put(DATE, format?);
		fileobj.put(SIZE, size);
		fileobj.put(SOURCE, url);
		return fileobj;
	}
	private static JSONObject getFolderObject(String title, String description, String webctType, String path, long lastModified) throws JSONException {
		JSONObject fileobj = new JSONObject();
		fileobj.put(TITLE, title);
		if (description!=null)
			fileobj.put(DESCRIPTION, description);
		if (webctType!=null)
			fileobj.put(WEBCT_TYPE, webctType);
//		if (lastModified!=0)
//			fileobj.put(DATE, format?);
		fileobj.put(SIZE, 0);
		fileobj.put(PATH, path);
		fileobj.put(CHILDREN, new JSONArray());
		return fileobj;
	}
	
//	/** get_listing response for a user, i.e. modules and person 
//	 * @param showLinks 
//	 * @param showFiles 
//	 * @throws JSONException */
//	public static JSONObject getListingForUser(Session s, String username, boolean showFiles, boolean showLinks) throws JSONException {
//		JSONObject userobj = getListingObject();
//		JSONArray path = new JSONArray();
//		userobj.put(PATH, path);
//		
//		String root = "/";
//		path.put(getPathObject("WebCT", root));
//		
//		JSONArray list = new JSONArray();
//		userobj.put(LIST, list);
//
//		// person for username?
//		Person p = DbUtils.getPersonByWebctId(s, username);
//		if (p==null) {
//			logger.log(Level.WARNING, "Could not find Person "+username);
//			return userobj;
//		}
//		if (showFiles) {
//			list.put(getFolderObject(username, null, "Person folder", root+getFilename(p)+"/", 0));
//		}
//		// LCs
//		List<LearningContext> lcs = DbUtils.getLearningContextsForPersonAsRole(s, p, DbUtils.getRoleDefinitionForSectionDesigner(s));
//		Collections.sort(lcs, new LearningContextComparator());
//		for (LearningContext lc : lcs) {
//			list.put(getFolderObject(lc.getName(), DbUtils.getDescription(lc), lc.getLcType().getTypeCode(), root+getFilename(lc)+"/", 0));
//		}
//		
//		return userobj;
//	}
	/** get_listing response for a whole DB, i.e. institutions.
	 * @param showLinks 
	 * @param showFiles 
	 * @throws JSONException 
	 * @throws SQLException */
	public static JSONObject getListingForRoot(Connection conn) throws JSONException, SQLException {
		JSONObject userobj = getListingObject();
		JSONArray path = new JSONArray();
		userobj.put(PATH, path);
		
		String root = "/";
		
		path.put(getPathObject("WebCT", root));
		
		JSONArray list = new JSONArray();
		userobj.put(LIST, list);

		List<LearningContext> institutions = getLearningContextsOfType(conn, DbUtils.LC_INSTITUTION);
		for (LearningContext lc : institutions) {
			logger.log(Level.INFO, "Institution: "+lc.getId()+" "+lc.getName());
			list.put(getFolderObject(lc.getName(), getDescription(conn, lc), lc.getTypeCode(), root+getFilename(lc)+"/", 0));
		}
		
		return userobj;
	}
	private static String getDescription(Connection conn, LearningContext lc) throws SQLException {
		if (lc==null)
			return null;
		PreparedStatement stmt = conn.prepareStatement("SELECT lc.description FROM LEARNING_CONTEXT lc WHERE lc.id = ?");
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, lc.getId());
			rs = stmt.executeQuery();
			if (!rs.next()) {
				logger.log(Level.WARNING,"No description for LearningContext "+lc.getId());
			} else {
				return rs.getString(1);
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static JSONObject getPathObject(String  name, String path) throws JSONException {
		JSONObject pathobj = new JSONObject();
		pathobj.put(NAME, name);
		pathobj.put(PATH, path);
		return pathobj;
	}
//	private static String getFilename(Person p) {
//		return PERSON_TYPE+p.getId();
//	}
	private static String getFilename(LearningContext lc) {
		return LC_TYPE+lc.getId();
	}
//	private static String getFilename(CmsFileContent fc) {
//		return FC_TYPE+fc.getId();
//	}
//	/** get_listing for a path, i.e. person, learning context, content entry, ... 
//	 * @param showLinks 
//	 * @param showFiles 
//	 * @throws JSONException 
//	 * @throws UnsupportedEncodingException */
//	public static JSONObject getListingForPath(Session s, String path, boolean showFiles, boolean showLinks) throws JSONException, UnsupportedEncodingException {
//		JSONObject listing = getListingObject();
//		JSONArray patharr = new JSONArray();
//		listing.put(PATH, patharr);
//
//		String root = "/";
//		patharr.put(getPathObject("WebCT", root));
//
//		String elements [] = path.split("/");
//		StringBuffer pathbuf = new StringBuffer();
//		pathbuf.append("/");
//		for (int ei=0; ei<elements.length; ei++) {
//			String filename = elements[ei];
//			if (filename.length()==0)
//				continue;
//			logger.log(Level.INFO, "Path element "+ei+": "+filename);
//			Object pathel = getPathElementObject(s, filename);
//			String name = getPathElementName(pathel);
//			pathbuf.append(filename);
//			pathbuf.append("/");
//			JSONObject pathobj = new JSONObject();
//			pathobj.put(NAME, name!=null ? name : "null");
//			pathobj.put(PATH, pathbuf.toString());
//			patharr.put(pathobj);
//		}
//		if (elements.length==0) {
//			logger.log(Level.WARNING, "path is empty ("+path+")");
//			return listing;
//		}
//		
//		JSONArray list = new JSONArray();
//
//		String filename = elements[elements.length-1];
//		Object pathel = getPathElementObject(s, filename);
//		CmsContentEntry ce = getPathElementContentEntry(s, pathel);
//		if (ce!=null)
//			list = getChildren(s, ce, path, showFiles, showLinks);
//
//		if (pathel instanceof LearningContext) {
//			LearningContext lc = (LearningContext)pathel;
//			Set<LearningContext> children = lc.getLearningContexts();
//			List<LearningContext> lcs = new LinkedList<LearningContext>();
//			for (LearningContext child : children) {
//				lcs.add(child);
//			}
//			Collections.sort(lcs, new LearningContextComparator());
//
//			for (LearningContext child : lcs) {
//				String childTypeCode = child.getLcType().getTypeCode();
//				list.put(getFolderObject(child.getName(), DbUtils.getDescription(child), childTypeCode, path+getFilename(child)+"/", 0));
//			}
//		}
//		
//		listing.put(LIST, list);
//		
//		return listing;
//	}
//	private static Object getPathElementObject(Session s, String filename) {
//		String type = getFilenameType(filename);
//		BigDecimal id = getFilenameId(filename);
//		
//		if (PERSON_TYPE.equals(type)) {
//			Person p = (Person)s.createQuery("from Person as p where p.id=?").setBigDecimal(0, id).uniqueResult();
//			if (p==null) {
//				logger.log(Level.WARNING, "Could not find Person "+id);
//				return null;
//			}
//			return p;
//		}
//		else if (LC_TYPE.equals(type)) {
//			LearningContext lc = (LearningContext)s.createQuery("from LearningContext as lc where lc.id=?").setBigDecimal(0, id).uniqueResult();
//			if (lc==null) {
//				logger.log(Level.WARNING, "Could not file LearningContext "+id);
//				return null;
//			}
//			return lc;
//		}
//		else if (CE_TYPE.equals(type)) {
//			CmsContentEntry ce = (CmsContentEntry)s.createQuery("from CmsContentEntry as ce where ce.id=?").setBigDecimal(0, id).uniqueResult();
//			if (ce==null) {
//				logger.log(Level.WARNING, "Could not file CmsContentEntry "+id);
//				return null;
//			}
//			return ce;
//		}
//		else if (FC_TYPE.equals(type)) {
//			CmsFileContent fc = (CmsFileContent)s.createQuery("from CmsFileContent as fc where fc.id=?").setBigDecimal(0, id).uniqueResult();
//			if (fc==null) {
//				logger.log(Level.WARNING, "Could not file CmsFileContent "+id);
//				return null;
//			}
//			return fc;
//		}
//		logger.log(Level.WARNING, "Unknown path element type "+filename);
//		return null;
//	}
//	private static CmsContentEntry getPathElementContentEntry(Session s, Object pathElementObject) {
//		if (pathElementObject==null)
//			return null;
//		if (pathElementObject instanceof Person) {
//			Person p = (Person)pathElementObject;
//			BigDecimal folderId = p.getHomefolderId();
//			CmsContentEntry ce = (CmsContentEntry)s.createQuery("from CmsContentEntry as ce where ce.id=?").setBigDecimal(0, folderId).uniqueResult();
//			return ce;
//		}
//		else if (pathElementObject instanceof LearningContext) {
//			LearningContext lc = (LearningContext)pathElementObject;
//			String lcTypeCode = lc.getLcType().getTypeCode();
//			// top-level
//			if (DbUtils.LC_INSTITUTION.equals(lcTypeCode))
//				return null;
//			// next level - year, school, etc.
//			if (DbUtils.LC_COURSE.equals(lcTypeCode))
//				return null;
//			//|| DbUtils.LC_
//			CmsContentEntry ce = lc.getCmsContentEntry();
//			if (ce==null) {
//				logger.log(Level.WARNING, "LearningContext "+lc.getId()+" had no CmsContentEntry");
//				return null;				
//			}
//			logger.log(Level.INFO, "LearningContext CmsContentEntry is type "+DbUtils.getTypename(ce));
//			return ce;
//		}
//		else if (pathElementObject instanceof CmsContentEntry) {
//			CmsContentEntry ce = (CmsContentEntry)pathElementObject;
//			return ce;
//		}
//		else {
//			logger.log(Level.WARNING, "pathElementObject of unsupported type "+pathElementObject.getClass());
//			return null;
//		}
//	}
//	private static String getPathElementName(Object pathElementObject) {
//		if (pathElementObject instanceof Person) {
//			Person p = (Person)pathElementObject;
//			return p.getWebctId();
//		}
//		else if (pathElementObject instanceof LearningContext) {
//			LearningContext lc = (LearningContext)pathElementObject;
//			return lc.getName();
//		}
//		else if (pathElementObject instanceof CmsContentEntry) {
//			CmsContentEntry ce = (CmsContentEntry)pathElementObject;
//			return ce.getName();
//		}
//		else {
//			if (pathElementObject!=null)
//				logger.log(Level.WARNING, "pathElementName of unsupported type "+pathElementObject.getClass());
//			return null;
//		}
//	
//	}
//	private static JSONArray sortChildren(JSONArray list) throws JSONException {
//		Vector<JSONObject> items = new Vector<JSONObject>();
//		for (int li=0; li<list.length(); li++)
//			items.add(list.getJSONObject(li));
//		Collections.sort(items, new JSONObjectTitleComparator());
//		JSONArray children = new JSONArray();
//		for (JSONObject o : items) 
//			children.put(o);
//		return children;
//	}
//	private static JSONArray getChildren(Session s, CmsContentEntry ce, String path, boolean showFiles, boolean showLinks) throws JSONException, UnsupportedEncodingException {
//		JSONArray list = new JSONArray();
//		String typename = DbUtils.getTypename(ce);
//		// other special cases...
//		// - learning context -> Container/LcHomeFolder -> Container/RepositoryFolder -> Template/Default [files] 
//		//    -> ORGANIZER_PAGE_TYPE/Default -> ContentFile/... | PAGE_TYPE/Default | URL_TYPE/Default
//		//    |  WebLinkContainer/Default -> WEBLINKSCATEGORY/Default -> URL_TYPE/Default
//		//    |  Folder/Default
//		// TODO
//		if (DbUtils.LC_HOME_FOLDER_TYPE.equals(typename)) {
//			Set<CmsContentEntry> children = ce.getCmsContentEntriesForParentId();
//			if (children.size()==1) {
//				ce = children.iterator().next();
//				typename = DbUtils.getTypename(ce);
//			}
//			if (DbUtils.REPOSITORY_FOLDER_TYPE.equals(typename)) {
//				children = ce.getCmsContentEntriesForParentId();
//				if (children.size()==1) {
//					CmsContentEntry filesce = children.iterator().next();
//					String filesTypename = DbUtils.getTypename(filesce);
//					if (DbUtils.TEMPLATE_TYPE.equals(filesTypename)) {
//						if (showFiles)
//							list.put(getItem(s, filesce, "Files", null, path));
//						// just what we expected
//						// look for ORGANIZER_PAGE_TYPE/Default and WebLinkContainer/Default 
//						{
//							//ce.getCmsContentEntryByParentId()
//							//ce.getCmsCeSubtype().getCmsCeType().getName()
//							Query q = s.createQuery("from CmsContentEntry as ce where ce.cmsContentEntryByParentId=? and ce.cmsCeSubtype.cmsCeType.name='ORGANIZER_PAGE_TYPE'").setEntity(0, filesce);
//							List ces = q.list();
//							for (Object ceo : ces) {
//								CmsContentEntry orgce = (CmsContentEntry)ceo;
//								list.put(getItem(s, orgce, "Home Page", orgce.getName(), path));							
//							}
//						}
//						if (showLinks) {
//							Query q = s.createQuery("from CmsContentEntry as ce where ce.cmsContentEntryByParentId=? and ce.cmsCeSubtype.cmsCeType.name='WebLinkContainer'").setEntity(0, filesce);
//							List ces = q.list();
//							for (Object ceo : ces) {
//								CmsContentEntry orgce = (CmsContentEntry)ceo;
//								list.put(getItem(s, orgce, "Links", orgce.getName(), path));							
//							}							
//						}
//						return list;
//					}
//				}
//			}
//		}
//		if (DbUtils.ORGANIZER_PAGE_TYPE.equals(typename)) {
//
//			Set<CmsLink> linkset = ce.getCmsLinksForLeftobjectId();
//			List<CmsLink> links = new ArrayList<CmsLink>();
//			links.addAll(linkset);
//			Collections.sort(links, new OrganizerlinkComparator());
//			
//			for(CmsLink link : links) {
//				CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
//				// default name/desc from linked item
//				String linkName = child.getName();
//				String linkDesc = DbUtils.getText(child.getDescription());
//				CoOrganizerlink orgLink = link.getCoOrganizerlink();
//				if (orgLink!=null) {
//					// should be! - override?!
//					if (orgLink.getLinkname()!=null)
//						linkName = orgLink.getLinkname();
//					if (orgLink.getLongDescription()!=null)
//						linkDesc = DbUtils.getText(orgLink.getLongDescription());
//				}
//				if (include(child, showFiles, showLinks))
//					list.put(getItem(s, child, linkName, linkDesc, path));
//			}
//		}
//		else if (DbUtils.TEMPLATE_TYPE.equals(typename)) {
//			// filter for files only
//			Set<CmsContentEntry> children = ce.getCmsContentEntriesForParentId();
//			for (CmsContentEntry child : children) {
//				String childTypename = DbUtils.getTypename(child);
//				if (DbUtils.FOLDER_TYPE.equals(childTypename) || child.getCmsFileContent()!=null) {
//					if (include(child, showFiles, showLinks))
//						list.put(getItem(s, child, path));
//				}
//				else
//					logger.fine("Skipping item type "+childTypename+" under "+DbUtils.TEMPLATE_TYPE);
//			}
//			list = sortChildren(list);
//			
//		} else {
//			// children...
//			Set<CmsContentEntry> children = ce.getCmsContentEntriesForParentId();
//			for (CmsContentEntry child : children) {
//				if (include(child, showFiles, showLinks))
//					list.put(getItem(s, child, path));
//			}
//			list = sortChildren(list);
//		}
//		return list;
//	}
//	private static boolean include(CmsContentEntry ce, boolean showFiles,
//			boolean showLinks) {
//		if (ce.getCmsFileContent()!=null) {
//			return showFiles;
//		}
//		String typename = DbUtils.getTypename(ce);
//		if (DbUtils.PAGE_TYPE.equals(typename)) {
//			// Page Type = link
//			Set<CmsLink> links = ce.getCmsLinksForLeftobjectId();
//			if (links.size()>0) {
//				if (links.size()>1) {
//					logger.log(Level.WARNING, "PAGE_TYPE with "+links.size()+" links! - only using first");					
//				}
//				CmsLink link = links.iterator().next();
//				CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
//				if (child!=null)
//					return include(child, showFiles, showLinks);
//				logger.log(Level.WARNING,"PAGE_TYPE with link without child");
//			}
//		}
//		if (DbUtils.URL_TYPE.equals(typename)) {
//			return showLinks;
//		}
//		// yes?
//		return true;
//	}
//	/** get file/folder JSONObject for this entry 
//	 * @throws JSONException 
//	 * @throws UnsupportedEncodingException */
//	private static JSONObject getItem(Session s, CmsContentEntry ce,
//			String parentPath) throws JSONException, UnsupportedEncodingException {
//		String name = ce.getName();
//		String description = DbUtils.getDescription(ce);
//		return getItem(s, ce, name, description, parentPath);
//	}
//	private static JSONObject getItem(Session s, CmsContentEntry ce, String name, String description,
//			String parentPath) throws JSONException, UnsupportedEncodingException {
//		String typename = DbUtils.getTypename(ce);
//		CoUrl url = ce.getCoUrl();
//		if (url!=null && url.getLink()!=null) {
//			return getLinkObject(name, description, typename, 0, 0, url.getLink());
//		}
//		CmsFileContent fc = ce.getCmsFileContent();
//		if (fc!=null) {
//			String filename = getFilename(fc);
//			// fcNNN/actual-file-name??
//			long len = 0;
//			try {
//				Blob blob = fc.getContent();
//				len =  blob.length();
//				//blob.free();
//			}
//			catch (Exception e) {
//				logger.log(Level.WARNING, "Could not get length of FileContent "+fc.getId(), e);
//			}
//			return getFileObject(name, description, typename, 0, len, parentPath+filename+"/"+URLEncoder.encode(ce.getName(), "UTF-8"));
//		}
//		else {
//			if (DbUtils.PAGE_TYPE.equals(typename)) {
//				// Page Type = link
//				Set<CmsLink> links = ce.getCmsLinksForLeftobjectId();
//				if (links.size()>0) {
//					if (links.size()>1) {
//						logger.log(Level.WARNING, "PAGE_TYPE with "+links.size()+" links! - only using first");					
//					}
//					CmsLink link = links.iterator().next();
//					CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
//					if (child!=null)
//						return getItem(s, child, name, description, parentPath);
//					logger.log(Level.WARNING,"PAGE_TYPE with link without child");
//				}
//				return getFileObject(name, description, typename, 0, 0, parentPath+getFilename(ce)+".error");
//
//			} else {
//				// Organizer 
//				// other folder type
//				String filename = getFilename(ce);
//				String path = parentPath+filename+"/";
//				JSONObject folderobj = getFolderObject(name, description, typename, path, 0);
//				//folderobj.put(CHILDREN, getChildren(s, ce, path));
//				return folderobj;
//			}
//		}
//	}
//	private static String getFilename(CmsContentEntry ce) {
//		return CE_TYPE+ce.getId();
//	}
//	private static BigDecimal getFilenameId(String filename) {
//		int i=0;
//		while(i<filename.length() && !Character.isDigit(filename.charAt(i)))
//			i++;
//		return new BigDecimal(filename.substring(i));
//	}
//	private static String getFilenameType(String filename) {
//		int i=0;
//		while(i<filename.length() && !Character.isDigit(filename.charAt(i)))
//			i++;
//		return filename.substring(0, i);
//	}
//	/** get_file for 'url' returned from getListingForPath 
//	 * @throws SQLException */
//	public static File getFile(Session s, String url, File tmpdir) throws IOException, SQLException {
//		CmsFileContent fc = getFileContent(s, url);
//		if (fc==null)
//			return null;
//		
//		File file = new File(tmpdir, url);
//		file.getParentFile().mkdirs();
//		long len = 0;
//		logger.info("Download "+file);
//		DbUtils.dumpCmsFileContent(fc, file);
//		return file;
//	}
//	public static CmsFileContent getFileContent(Session s, String url) throws IOException {
//		if (url.startsWith("http"))
//			// external URL...
//			return null;
//		int ix= url.lastIndexOf("/");
//		if (ix<0 || ix>=url.length()-1) {
//			throw new IOException("getFile for invalid file url "+url);
//		}
//		String pathElements[] = url.split("/");
//		String filename = pathElements[pathElements.length-2];
//		Object pathobj = getPathElementObject(s, filename);
//		if (!(pathobj instanceof CmsFileContent)) 
//			throw new IOException("getFile for non-CmsFileContent "+url);
//		CmsFileContent fc = (CmsFileContent)pathobj;
//		return fc;
//	}
	private static List<LearningContext> getLearningContextsOfType(Connection conn,
			String lcTypeCode) throws SQLException {
		List<LearningContext> lcs = new LinkedList<LearningContext>();
		PreparedStatement stmt = conn.prepareStatement("SELECT lc.id, lc.name, lc.TYPE_CODE FROM LEARNING_CONTEXT lc WHERE lc.TYPE_CODE = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setString(1, lcTypeCode);
			rs = stmt.executeQuery();
			while(rs.next()) {
				LearningContext lc = new LearningContext(rs.getBigDecimal(1), rs.getString(2), rs.getString(3));
				lcs.add(lc);
			//System.out.println("Found "+typeCode+" "+id+": "+name);
			}				
		}
		finally {
			tidy(rs, stmt);
		}
		return lcs;
	}
	private static void tidy(ResultSet rs, PreparedStatement stmt) {
		if (rs!=null)
			try { rs.close(); } catch (Throwable ignore) {}
		if (stmt!=null)
			try { stmt.close(); } catch (Throwable ignore) {}		
	}
}
