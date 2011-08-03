/**
 * 
 */
package webctdbexport.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.hibernate.Query;
//import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import webctdbexport.jdbc.model.AccessControlEntry;
import webctdbexport.jdbc.model.AccessControlPermissionSet;
import webctdbexport.jdbc.model.CmsContentEntry;
import webctdbexport.jdbc.model.CmsFileContent;
import webctdbexport.jdbc.model.CmsLink;
import webctdbexport.jdbc.model.CmsMimetype;
import webctdbexport.jdbc.model.CoOrganizerlink;
import webctdbexport.jdbc.model.CoUrl;
import webctdbexport.jdbc.model.LearningContext;
import webctdbexport.jdbc.model.LearningContextComparator;
import webctdbexport.jdbc.model.Member;
import webctdbexport.jdbc.model.OrganizerlinkComparator;
import webctdbexport.jdbc.model.Person;
import webctdbexport.jdbc.model.Role;
import webctdbexport.jdbc.model.RoleDefinition;
import webctdbexport.utils.DbUtils;
import webctdbexport.utils.JSONObjectTitleComparator;

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
	private static final String SECTION = "Section";
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
	
	/** get_listing response for a user, i.e. modules and person 
	 * @param showLinks 
	 * @param showFiles 
	 * @param extralcs 
	 * @throws JSONException 
	 * @throws SQLException */
	public static JSONObject getListingForUser(Connection conn, String username, boolean showFiles, boolean showLinks, Set<String> extralcs) throws JSONException, SQLException {
		JSONObject userobj = getListingObject();
		JSONArray path = new JSONArray();
		userobj.put(PATH, path);
		
		String root = "/";
		if (username.length()>=3) 
			root = "/user/"+username.substring(0,2)+"/"+username.substring(0,3)+"/"+username+"/";
		path.put(getPathObject("WebCT ("+username+")", root));
		
		JSONArray list = new JSONArray();
		userobj.put(LIST, list);

		// person for username?
		Person p = getPersonByWebctId(conn, username);
		if (p==null) {
			logger.log(Level.WARNING, "Could not find Person "+username);
			return userobj;
		}
		if (showFiles) {
			if (p.getHomefolderId()!=null)
				list.put(getFolderObject(username, null, "HomeFolder", root+getFilename(p)+"/", 0));
		}
		// LCs
		// clone extras first
		List<LearningContext> lcs = getLearningContextsForPersonAsRole(conn, p, getRoleDefinitionForSectionDesigner(conn), SECTION);
		if (extralcs!=null) {
			// extras?
			Iterator<String> elci = extralcs.iterator();
			while (elci.hasNext()) {
				String extralc = elci.next();				
				Object pathel = getPathElementObject(conn, extralc);
				if (pathel instanceof LearningContext) {
					LearningContext lc = (LearningContext)pathel;
					boolean found = false;
					for (int i=0; !found && i<lcs.size(); i++) {
						if (lc.getId().equals(lcs.get(i).getId()))
							found = true;
					}
					if (!found)
						lcs.add(lc);
				}
				else {
					logger.log(Level.SEVERE,"Could not find extra permission context "+extralc+" (for "+username+")");
				}
			}			
		}
		Collections.sort(lcs, new LearningContextComparator());
		
		for (LearningContext lc : lcs) {
			String fullPath = getLearningContextPath(conn, lc);
			String parentName = "";
			if (lc.getParentId()!=null) {
				LearningContext lcp = getLearningContext(conn, lc.getParentId());
				if(lcp!=null)
					parentName = lcp.getName()+" - ";
			}
			list.put(getFolderObject(parentName+lc.getName(), getDescription(conn, lc), lc.getTypeCode(), "/"+fullPath, 0));
		}
		
		return userobj;
	}
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
	private static String getDescription(Connection conn, CmsContentEntry ce) throws SQLException {
		if (ce==null)
			return null;
		PreparedStatement stmt = conn.prepareStatement("SELECT ce.description FROM CMS_CONTENT_ENTRY ce WHERE ce.id = ?");
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, ce.getId());
			rs = stmt.executeQuery();
			if (!rs.next()) {
				logger.log(Level.WARNING,"No description for CmsContentEntry "+ce.getId());
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
	private static String getFilename(Person p) {
//		String username = p.getWebctId();
//		if (username.length()<3)
			return PERSON_TYPE+p.getId();
//		return "user/"+username.substring(0,2)+"/"+username.substring(0,3)+"/"+username+"/"+PERSON_TYPE+p.getId();
	}
	private static String getFilename(LearningContext lc) {
		return LC_TYPE+lc.getId();
	}
	private static String getFilename(CmsFileContent fc) {
		return FC_TYPE+fc.getId();
	}
	/** get_listing for a path, i.e. person, learning context, content entry, ... 
	 * @param showLinks 
	 * @param showFiles 
	 * @throws JSONException 
	 * @throws UnsupportedEncodingException 
	 * @throws SQLException */
	public static JSONObject getListingForPath(Connection conn, String path, boolean showFiles, boolean showLinks) throws JSONException, UnsupportedEncodingException, SQLException {
		JSONObject listing = getListingObject();
		JSONArray patharr = new JSONArray();
		listing.put(PATH, patharr);

		String root = "/";
		patharr.put(getPathObject("WebCT", root));

		String elements [] = path.split("/");
		StringBuffer pathbuf = new StringBuffer();
		pathbuf.append("/");
		for (int ei=0; ei<elements.length; ei++) {
			String filename = elements[ei];
			if (filename.length()==0)
				continue;
			pathbuf.append(filename);
			pathbuf.append("/");
			if (ei<5 && "user".equals(elements[1])) {
				// skip []/user/ps/psz/pszcmg/
				continue;
			}
			//logger.log(Level.INFO, "Path element "+ei+": "+filename);
			Object pathel = getPathElementObject(conn, filename);
			String name = getPathElementName(pathel);
			JSONObject pathobj = new JSONObject();
			pathobj.put(NAME, name!=null ? name : "null");
			pathobj.put(PATH, pathbuf.toString());
			patharr.put(pathobj);
		}
		if (elements.length==0) {
			logger.log(Level.WARNING, "path is empty ("+path+")");
			return listing;
		}
		
		JSONArray list = new JSONArray();

		String filename = elements[elements.length-1];
		Object pathel = getPathElementObject(conn, filename);
		CmsContentEntry ce = getPathElementContentEntry(conn, pathel);
		if (ce!=null) {
			listing.put(MoodleRepository.WEBCT_TYPE, getTypename(ce));
			list = getChildren(conn, ce, path, showFiles, showLinks);
		}
		
		if (pathel instanceof LearningContext) {
			LearningContext lc = (LearningContext)pathel;
			if (lc.getTypeCode()!=null)
				listing.put(MoodleRepository.WEBCT_TYPE, lc.getTypeCode());
			List<LearningContext> lcs = getLearningContexts(conn, lc);
//			List<LearningContext> lcs = new LinkedList<LearningContext>();
//			for (LearningContext child : children) {
//				lcs.add(child);
//			}
			Collections.sort(lcs, new LearningContextComparator());
//
			for (LearningContext child : lcs) {
				String childTypeCode = child.getTypeCode();
				list.put(getFolderObject(child.getName(), getDescription(conn, child), childTypeCode, path+getFilename(child)+"/", 0));
			}
		}
		
		listing.put(LIST, list);
		
		return listing;
	}
	/** get permissions (e.g. learning context memberships) for a path, i.e. learning context, content entry, ... 
	 * @throws JSONException 
	 * @throws UnsupportedEncodingException 
	 * @throws SQLException */
	public static JSONObject getPermissionsForPath(Connection conn, String path) throws JSONException, UnsupportedEncodingException, SQLException {
		JSONObject permissions = new JSONObject();

		String elements [] = path.split("/");
		if (elements.length==0) {
			logger.log(Level.WARNING, "path is empty ("+path+")");
			return permissions;
		}
		
		String filename = elements[elements.length-1];
		Object pathel = getPathElementObject(conn, filename);

		if (pathel instanceof LearningContext) {
			LearningContext lc = (LearningContext)pathel;
			List<Member> members = getMembers(conn, lc);
			if (members.size()==0)
				return null; // no members => no permissions
			for (Member m : members) {
				Person p = getPerson(conn, m);
				if (p==null) {
					logger.log(Level.WARNING,"Could not find Person "+m.getPersonId());
					continue;
				}
				JSONArray roleArray = new JSONArray();
				List<Role> roles = getRoles(conn, m);
				for (Role r : roles) {
					RoleDefinition rd = getRoleDefinition(conn, r);
					if(rd!=null)
						roleArray.put(rd.getName());
					else
						logger.log(Level.WARNING, "COuld not find RoleDefinition "+r.getRoleDefinitionId());
				}
				permissions.put(p.getWebctId(), roleArray);
			}
		}
		else if (pathel instanceof Person) {
			Person p = (Person)pathel;
			JSONArray roleArray = new JSONArray();
			roleArray.put(SDES);
			permissions.put(p.getWebctId(), roleArray);
		}
		else
			return null; // no permissions
		
//		CmsContentEntry ce = getPathElementContentEntry(conn, pathel);
//		if(ce!=null && ce.getAclId()!=null) {
//			List<AccessControlEntry> aces = getAccessControlEntries(conn, ce.getAclId());
//			for (AccessControlEntry ace : aces) {
//				if (getAclRead(conn, ace)) {
//					// An ACE links to a DirectoryObject, from there... don't know!
//					Person p = ??
//					if (p==null) {
//						logger.log(Level.WARNING,"Could not find Person "+ace.getGranteeId()+" in ACE");
//						continue;
//					}
//					logger.log(Level.INFO, "ACL ok for "+p.getWebctId()+" on "+ce.getName());
//					JSONArray arr = null;
//					if (permissions.has(p.getWebctId())) {
//						arr = permissions.getJSONArray(p.getWebctId());
//					}
//					else
//					{
//						arr = new JSONArray();
//						permissions.put(p.getWebctId(), arr);
//					}
//					arr.put("READ");
//				}
//			}
//		}

		return permissions;
	}
	private static Object getPathElementObject(Connection conn, String filename) throws SQLException {
		String type = getFilenameType(filename);
		BigDecimal id = getFilenameId(filename);
		if (id==null)
			return null;
		
		if (PERSON_TYPE.equals(type)) {
			Person p = getPerson(conn, id);
			if (p==null) {
				logger.log(Level.WARNING, "Could not find Person "+id);
				return null;
			}
			return p;
		}
		else 
			if (LC_TYPE.equals(type)) {
				LearningContext lc = getLearningContext(conn, id);
				if (lc==null) {
					logger.log(Level.WARNING, "Could not file LearningContext "+id);
					return null;
				}
				return lc;
			}
			else if (CE_TYPE.equals(type)) {
				CmsContentEntry ce = getCmsContentEntry(conn, id);
				if (ce==null) {
					logger.log(Level.WARNING, "Could not file CmsContentEntry "+id);
					return null;
				}
				return ce;
			}
		else if (FC_TYPE.equals(type)) {
			CmsFileContent fc = getCmsFileContent(conn, id);
			if (fc==null) {
				logger.log(Level.WARNING, "Could not file CmsFileContent "+id);
				return null;
			}
			return fc;
		}
		logger.log(Level.WARNING, "Unknown path element type "+filename);
		return null;
	}
	private static CmsContentEntry getPathElementContentEntry(Connection conn, Object pathElementObject) throws SQLException {
		if (pathElementObject==null)
			return null;
		if (pathElementObject instanceof Person) {
			Person p = (Person)pathElementObject;
			BigDecimal folderId = p.getHomefolderId();
			CmsContentEntry ce = getCmsContentEntry(conn, folderId);
			return ce;
		}
		else 
		if (pathElementObject instanceof LearningContext) {
			LearningContext lc = (LearningContext)pathElementObject;
			String lcTypeCode = lc.getTypeCode();
			// top-level
			if (DbUtils.LC_INSTITUTION.equals(lcTypeCode))
				return null;
			// next level - year, school, etc.
			if (DbUtils.LC_COURSE.equals(lcTypeCode))
				return null;
			//|| DbUtils.LC_
			CmsContentEntry ce = getCmsContentEntry(conn, lc);
			if (ce==null) {
				logger.log(Level.WARNING, "LearningContext "+lc.getId()+" had no CmsContentEntry");
				return null;				
			}
			logger.log(Level.INFO, "LearningContext CmsContentEntry is type "+getTypename(ce));
			return ce;
		}
		else if (pathElementObject instanceof CmsContentEntry) {
			CmsContentEntry ce = (CmsContentEntry)pathElementObject;
			return ce;
		}
		else {
			logger.log(Level.WARNING, "pathElementObject of unsupported type "+pathElementObject.getClass());
			return null;
		}
	}
	private static String getPathElementName(Object pathElementObject) {
		if (pathElementObject instanceof Person) {
			Person p = (Person)pathElementObject;
			return p.getWebctId();
		}
		else 
		if (pathElementObject instanceof LearningContext) {
			LearningContext lc = (LearningContext)pathElementObject;
			return lc.getName();
		}
		else if (pathElementObject instanceof CmsContentEntry) {
			CmsContentEntry ce = (CmsContentEntry)pathElementObject;
			return ce.getName();
		}
		else {
			if (pathElementObject!=null)
				logger.log(Level.WARNING, "pathElementName of unsupported type "+pathElementObject.getClass());
			return null;
		}
	
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
	private static JSONArray getChildren(Connection conn, CmsContentEntry ce, String path, boolean showFiles, boolean showLinks) throws JSONException, UnsupportedEncodingException, SQLException {
		JSONArray list = new JSONArray();
		String typename = getTypename(ce);
		// other special cases...
		// - learning context -> Container/LcHomeFolder -> Container/RepositoryFolder -> Template/Default [files] 
		//    -> ORGANIZER_PAGE_TYPE/Default -> ContentFile/... | PAGE_TYPE/Default | URL_TYPE/Default
		//    |  WebLinkContainer/Default -> WEBLINKSCATEGORY/Default -> URL_TYPE/Default
		//    |  Folder/Default
		// TODO
		if (DbUtils.LC_HOME_FOLDER_TYPE.equals(typename)) {
			List<CmsContentEntry> children = getCmsContentEntriesForParentId(conn, ce);
			if (children.size()==1) {
				ce = children.get(0);
				typename = getTypename(ce);
			}
			if (DbUtils.REPOSITORY_FOLDER_TYPE.equals(typename)) {
				children = getCmsContentEntriesForParentId(conn, ce);
				if (children.size()==1) {
					CmsContentEntry filesce = children.get(0);
					String filesTypename = getTypename(filesce);
					if (DbUtils.TEMPLATE_TYPE.equals(filesTypename)) {
						if (showFiles)
							list.put(getItem(conn, filesce, "Files", null, path));
						// just what we expected
						// look for ORGANIZER_PAGE_TYPE/Default and WebLinkContainer/Default 
						{
							//ce.getCmsContentEntryByParentId()
							//ce.getCmsCeSubtype().getCmsCeType().getName()
							List ces = getCmsContentEntriesForParentIdAndCeTypeName(conn, filesce, "ORGANIZER_PAGE_TYPE");
							for (Object ceo : ces) {
								CmsContentEntry orgce = (CmsContentEntry)ceo;
								list.put(getItem(conn, orgce, "Home Page", orgce.getName(), path));							
							}
						}
						if (showLinks) {
							List ces = getCmsContentEntriesForParentIdAndCeTypeName(conn, filesce, "WebLinkContainer");
							for (Object ceo : ces) {
								CmsContentEntry orgce = (CmsContentEntry)ceo;
								list.put(getItem(conn, orgce, "Links", orgce.getName(), path));							
							}							
						}
						return list;
					}
				}
			}
		}
		if (DbUtils.ORGANIZER_PAGE_TYPE.equals(typename)) {

			List<CmsLink> links = getCmsLinksForLeftobjectId(conn, ce);
//			List<CmsLink> links = new ArrayList<CmsLink>();
//			links.addAll(linkset);
			for (CmsLink link : links) {
				// cache CoOrganizerlink for sort and later
				CoOrganizerlink orgLink = getCoOrganizerlink(conn, link);
				link.setCoOrganizerlink(orgLink);
			}
			Collections.sort(links, new OrganizerlinkComparator());
			
			for(CmsLink link : links) {
				CmsContentEntry child = getCmsContentEntryByRightobjectId(conn, link);
				// default name/desc from linked item
				String linkName = child.getName();
				String linkDesc = getDescription(conn, child);//DbUtils.getText(child.getDescription());
				// already cached
				CoOrganizerlink orgLink = link.getCoOrganizerlink();
				if (orgLink!=null) {
					// should be! - override?!
					if (orgLink.getLinkname()!=null)
						linkName = orgLink.getLinkname();
					if (orgLink.getLongDescription()!=null)
						linkDesc = orgLink.getLongDescription();
				}
				if (include(conn, child, showFiles, showLinks))
					list.put(getItem(conn, child, linkName, linkDesc, path));
			}
		}
		else if (DbUtils.TEMPLATE_TYPE.equals(typename)) {
			// filter for files only
			List<CmsContentEntry> children = getCmsContentEntriesForParentId(conn, ce);
			for (CmsContentEntry child : children) {
				String childTypename = getTypename(child);
				if (DbUtils.FOLDER_TYPE.equals(childTypename) || DbUtils.TEMPLATE_PUBLIC_AREA.equals(childTypename) || getCmsFileContent(conn, child)!=null) {
					if (include(conn, child, showFiles, showLinks))
						list.put(getItem(conn, child, path));
				}
				else
					logger.fine("Skipping item type "+childTypename+" under "+DbUtils.TEMPLATE_TYPE);
			}
			list = sortChildren(list);
			
		} 
		else {
			// children...
			List<CmsContentEntry> children = getCmsContentEntriesForParentId(conn, ce);
			for (CmsContentEntry child : children) {
				if (include(conn, child, showFiles, showLinks))
					list.put(getItem(conn, child, path));
			}
			list = sortChildren(list);
		}
		return list;
	}
	private static boolean include(Connection conn, CmsContentEntry ce, boolean showFiles,
			boolean showLinks) throws SQLException {
		if (ce.getFileContentId()!=null) {
			return showFiles;
		}
		String typename = getTypename(ce);
		if (DbUtils.PAGE_TYPE.equals(typename)) {
			// Page Type = link
			// TODO
			List<CmsLink> links = getCmsLinksForLeftobjectId(conn, ce);
			if (links.size()>0) {
				if (links.size()>1) {
					logger.log(Level.WARNING, "PAGE_TYPE with "+links.size()+" links! - only using first");					
				}
				CmsLink link = links.iterator().next();
				CmsContentEntry child = getCmsContentEntryByRightobjectId(conn, link);
				if (child!=null)
					return include(conn, child, showFiles, showLinks);
				logger.log(Level.WARNING,"PAGE_TYPE with link without child");
			}
		}
		if (DbUtils.URL_TYPE.equals(typename)) {
			return showLinks;
		}
		// yes?
		return true;
	}
	/** get file/folder JSONObject for this entry 
	 * @throws JSONException 
	 * @throws UnsupportedEncodingException 
	 * @throws SQLException */
	private static JSONObject getItem(Connection conn, CmsContentEntry ce,
			String parentPath) throws JSONException, UnsupportedEncodingException, SQLException {
		String name = ce.getName();
		String description = getDescription(conn, ce);
		return getItem(conn, ce, name, description, parentPath);
	}
	private static JSONObject getItem(Connection conn, CmsContentEntry firstCe, String name, String description,
			String parentPath) throws JSONException, UnsupportedEncodingException, SQLException {
		CmsContentEntry ce = followLinks(conn, firstCe);
		return getItem(conn, ce, name, description, parentPath, firstCe);
	}
	private static CmsContentEntry followLinks(Connection conn, CmsContentEntry ce) throws SQLException {
		// stop at link
		CoUrl url = getCoUrl(conn, ce);
		if (url!=null && url.getLink()!=null) {
			return ce;
		}
		// stop at file
		CmsFileContent fc = getCmsFileContent(conn, ce);
		if (fc!=null) {
			return ce;
		}
		String typename = getTypename(ce);
		if (DbUtils.PAGE_TYPE.equals(typename)) {
			// Page Type = link
			List<CmsLink> links = getCmsLinksForLeftobjectId(conn, ce);
			if (links.size()>0) {
				if (links.size()>1) {
					logger.log(Level.WARNING, "PAGE_TYPE with "+links.size()+" links! - only using first");					
				}
				CmsLink link = links.iterator().next();
				CmsContentEntry child = getCmsContentEntryByRightobjectId(conn, link);
				if (child!=null)
					return followLinks(conn, child);
			}
			return ce;
		} 
		return ce;
	}
	private static JSONObject getItem(Connection conn, CmsContentEntry ce, String name, String description,
			String parentPath, CmsContentEntry firstCe) throws JSONException, UnsupportedEncodingException, SQLException {
		// CMS links already followed

		String typename = getTypename(ce);
		// TODO
		CoUrl url = getCoUrl(conn, ce);
		if (url!=null && url.getLink()!=null) {
			return getLinkObject(name, description, typename, 0, 0, url.getLink());
		}
		
		CmsFileContent fc = getCmsFileContent(conn, ce);
		if (fc!=null) {
			String filename = getFilename(firstCe);
			// fcNNN/actual-file-name??
			long len = 0;
			try {
//				Blob blob = fc.getContent();
				len =  getContentLength(conn, fc);
//				//blob.free();
			}
			catch (Exception e) {
				logger.log(Level.WARNING, "Could not get length of FileContent "+fc.getId(), e);
			}
			return getFileObject(name, description, typename, 0, len, parentPath+filename);
		}
		else {
			if (DbUtils.PAGE_TYPE.equals(typename)) {
				return getFileObject(name, description, typename, 0, 0, parentPath+getFilename(ce)+".error");

			} else {
				// Organizer 
				// other folder type
				String filename = getFilename(ce);
				String path = parentPath+filename+"/";
				JSONObject folderobj = getFolderObject(name, description, typename, path, 0);
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
		if (i>=filename.length())
			return null;
		return new BigDecimal(filename.substring(i));
	}
	private static String getFilenameType(String filename) {
		int i=0;
		while(i<filename.length() && !Character.isDigit(filename.charAt(i)))
			i++;
		return filename.substring(0, i);
	}
//	/** internal get_file for 'url' returned from getListingForPath 
//	 * @throws SQLException */
//	public static File getTmpFile(Connection conn, String url, File tmpdir) throws IOException, SQLException {
//		CmsFileContent fc = getFileContent(conn, url);
//		if (fc==null)
//			return null;
//		
//		int ix = url.lastIndexOf("/");
//		if (ix>0)
//			url = url.substring(ix+1);
//		File file = File.createTempFile("file", ".bin", tmpdir);
//		//file.getParentFile().mkdirs();
//		long len = 0;
//		logger.info("Download "+file);
//		dumpCmsFileContent(conn, fc, file);
//		return file;
//	}
	/** get_file (sort-of) to get file information:
	 * sha1hash, length, mimetype, path, filename, webcttype 
	 * @param outputdir 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws JSONException */
	public static JSONObject getFileInfo(Connection conn, String url, File cachedir, File outputdir) throws IOException, SQLException, JSONException {
		if (url.startsWith("http"))
			// external URL...
			return null;
		JSONObject info = new JSONObject();
		// path should end with ceNNN
		String pathElements[] = url.split("/");
		String cename = pathElements[pathElements.length-1];
		Object pathobj = getPathElementObject(conn, cename);
		if (!(pathobj instanceof CmsContentEntry)) 
			throw new IOException("getFile for non-CmsContentEntry "+url);
		CmsContentEntry initialce = (CmsContentEntry)pathobj;
		CmsContentEntry ce = followLinks(conn, initialce);
		info.put("filename", ce.getName());
		info.put("webcttype", getTypename(ce));
		info.put("webctpath", getFullPath(conn, ce));
		info.put("cachets", System.currentTimeMillis());
		if (initialce!=ce) {
			String cachePath = getCachePath(conn, ce);
			info.put("linkto", cachePath);
			try {
				File linktofile = new File(outputdir.getPath()+cachePath+"/file.json");
				if (linktofile.exists()) {
					Reader r= new InputStreamReader(new FileInputStream(linktofile), "UTF-8");
					JSONObject linkinfo = new JSONObject(new JSONTokener(r));
					r.close();
					linkinfo.put("cachets", System.currentTimeMillis());
					logger.log(Level.INFO, "Reuse "+linktofile+" for "+info.getString("webctpath"));
					return linkinfo;
				}
				logger.log(Level.INFO, "Linkto file does not exist (yet): "+linktofile);
			}
			catch (Exception e) {
				logger.log(Level.WARNING, "Problem trying to re-use linkto file "+cachePath, e);
			}
		}		
		CmsFileContent fc = getCmsFileContent(conn, ce);
		info.put("filecontentid", ce.getId().longValue());
		long length = getContentLength(conn, fc);
		info.put("length", length);
		CmsMimetype mimetype = getMimetype(conn, fc);
		if (mimetype!=null) {
			info.put("mimetype", mimetype.getMimetype());
		}
		String characterSet = fc.getCharacterSet();
		if (characterSet!=null && (mimetype==null || !mimetype.isBinary()))
			info.put("encoding", characterSet);
		info.put("lastmodifiedts", fc.getLastModifyTs());
		

		File tmpdir = new File(cachedir, "tmp");
		tmpdir.mkdir();
		File tmpfile = File.createTempFile("download-", ".bin", tmpdir);
		String digest = dumpAndDigestCmsFileContent(conn, fc, tmpfile);

		if (digest!=null) {
			info.put("sha1hash", digest);
			File sha1dir = new File(new File(cachedir, digest.substring(0,2)), digest.substring(2,4));
			sha1dir.mkdirs();
			File sha1file = new File(sha1dir, digest);	
			if (sha1file.exists()) {
				logger.log(Level.INFO, "File already exists: "+sha1file);
				tmpfile.delete();
			}
			else {
				tmpfile.renameTo(sha1file);
				logger.log(Level.INFO, "Downloaded new file "+sha1file+" ("+length+" bytes)");
			}
			info.put("path", "/"+digest.substring(0,2)+"/"+digest.substring(2,4)+"/"+digest);
		}
		
		return info;
	}
	private static String getCachePath(Connection conn, CmsContentEntry ce) throws SQLException {
		String path = "";
		// build path backwards to Institution
		while(ce!=null) {
			// skip a Repository
			String typename = getTypename(ce);
			//path = "["+typename+"]"+path;
			if (DbUtils.REPOSITORY_FOLDER_TYPE.equals(typename))// || DbUtils.TEMPLATE_PUBLIC_AREA.equals(typename))
				;
			else if (DbUtils.LC_HOME_FOLDER_TYPE.equals(typename)) {
				// jump across to LearningContext?
				LearningContext lc = getLearningContext(conn, ce);
				if (lc!=null)
					return "/"+getLearningContextPath(conn, lc)+path;		
				return null;
			}
			else {
				if (path.length()>0)
					path = "/"+path;
				path = getFilename(ce)+path;
			}
			ce = getCmsContentEntryByParentId(conn, ce);
		}		
		logger.log(Level.WARNING, "Did not find LearningContext for CmsContentEntry "+path);
		return null;
	}
	private static String getFullPath(Connection conn, CmsContentEntry ce) throws SQLException {
		String path = "";
		// build path backwards to Institution
		while(ce!=null) {
			path = "/"+ce.getName()+path;
			ce = getCmsContentEntryByParentId(conn, ce);
		}		
		return path;
	}
	private static String convertToHex(byte[] data) { 
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			buf.append(nibbleToHex((data[i]>>4)&0xf));
			buf.append(nibbleToHex((data[i])&0xf));
		}
		return buf.toString();
	}
	private static char nibbleToHex(int n) {
		if (n<10)
			return (char)('0'+n);
		return (char)('a'+n-10);
	} 
	 
//	public static CmsFileContent getFileContent(Connection conn, String url) throws IOException, SQLException {
//		if (url.startsWith("http"))
//			// external URL...
//			return null;
//		int ix= url.lastIndexOf("/");
//		if (ix<0 || ix>=url.length()-1) {
//			throw new IOException("getFile for invalid file url "+url);
//		}
//		String pathElements[] = url.split("/");
//		String filename = pathElements[pathElements.length-2];
//		Object pathobj = getPathElementObject(conn, filename);
//		if (!(pathobj instanceof CmsFileContent)) 
//			throw new IOException("getFile for non-CmsFileContent "+url);
//		CmsFileContent fc = (CmsFileContent)pathobj;
//		return fc;
//	}
	private static List<LearningContext> getLearningContextsOfType(Connection conn,
			String lcTypeCode) throws SQLException {
		List<LearningContext> lcs = new LinkedList<LearningContext>();
		PreparedStatement stmt = conn.prepareStatement("SELECT lc.id, lc.name, lc.TYPE_CODE, lc.PARENT_ID FROM LEARNING_CONTEXT lc WHERE lc.TYPE_CODE = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setString(1, lcTypeCode);
			rs = stmt.executeQuery();
			while(rs.next()) {
				LearningContext lc = new LearningContext(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
				lcs.add(lc);
			//System.out.println("Found "+typeCode+" "+id+": "+name);
			}				
		}
		finally {
			tidy(rs, stmt);
		}
		return lcs;
	}
	private static LearningContext getLearningContext(Connection conn,
			BigDecimal id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT lc.id, lc.name, lc.TYPE_CODE, lc.PARENT_ID FROM LEARNING_CONTEXT lc WHERE lc.id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				LearningContext lc = new LearningContext(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
				return lc;
			}		
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static String getLearningContextPath(Connection conn,
			LearningContext lc) throws SQLException {
		String path = "";
		// build path backwards to Institution
		while(lc!=null) {
			path = getFilename(lc)+"/"+path;
			if (DbUtils.LC_INSTITUTION.equals(lc.getTypeCode())) 
				break;
			lc = getLearningContext(conn, lc.getParentId());
		}		
		return /*"/"+*/path;
	}
	/** children 
	 * @throws SQLException */
	private static List<LearningContext> getLearningContexts(Connection conn,
			LearningContext lc) throws SQLException {
		List<LearningContext> lcs = new LinkedList<LearningContext>();
		PreparedStatement stmt = conn.prepareStatement("SELECT lc.id, lc.name, lc.TYPE_CODE, lc.PARENT_ID FROM LEARNING_CONTEXT lc WHERE lc.PARENT_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, lc.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				LearningContext child = new LearningContext(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
				lcs.add(child);
			//System.out.println("Found "+typeCode+" "+id+": "+name);
			}				
		}
		finally {
			tidy(rs, stmt);
		}
		return lcs;
	}
	private static String getTypename(CmsContentEntry ce) {
		return ""+ce.getCeTypeName()+"/"+ce.getCeSubtypeName();
	}
	private static final String CE_FIELDS = "ce.ID, ce.NAME, ce.CE_TYPE_NAME, ce.CE_SUBTYPE_NAME, ce.ACL_ID, ce.LASTMODIFY_TS, ce.FILESIZE, ce.FILE_CONTENT_ID, ce.PARENT_ID";
	private static CmsContentEntry getCmsContentEntry(ResultSet rs) throws SQLException {
		return new CmsContentEntry(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5), rs.getLong(6), rs.getLong(7), rs.getBigDecimal(8), rs.getBigDecimal(9));
	}
	private static CmsContentEntry getCmsContentEntry(Connection conn, LearningContext lc) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT lc.HOMEFOLDER_ID FROM LEARNING_CONTEXT lc WHERE lc.id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, lc.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return getCmsContentEntry(conn, rs.getBigDecimal(1));
			}		
			logger.log(Level.WARNING, "Could not find LearningContext "+lc.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static LearningContext getLearningContext(Connection conn, CmsContentEntry ce) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT lc.ID FROM LEARNING_CONTEXT lc WHERE lc.HOMEFOLDER_ID  = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, ce.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return getLearningContext(conn, rs.getBigDecimal(1));
			}		
			logger.log(Level.WARNING, "Could not find LearningContext for HomefolderId "+ce.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static CmsContentEntry getCmsContentEntry(Connection conn,
			BigDecimal id) throws SQLException {
		if (id==null)
			return null;
		PreparedStatement stmt = conn.prepareStatement("SELECT "+CE_FIELDS+" FROM CMS_CONTENT_ENTRY ce WHERE ce.id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return getCmsContentEntry(rs);
			}		
			logger.log(Level.WARNING, "Could not find CmsContentEntry "+id);
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static List<CmsContentEntry> getCmsContentEntriesForParentId(Connection conn, 
			CmsContentEntry ce) throws SQLException {
		List<CmsContentEntry> ces = new LinkedList<CmsContentEntry>();
		PreparedStatement stmt = conn.prepareStatement("SELECT "+CE_FIELDS+" FROM CMS_CONTENT_ENTRY ce WHERE ce.PARENT_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, ce.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				ces.add(getCmsContentEntry(rs));
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return ces;
	}
	private static CmsContentEntry getCmsContentEntryByParentId(Connection conn, 
			CmsContentEntry ce) throws SQLException {
		return getCmsContentEntry(conn, ce.getParentId());
	}
	private static List<CmsContentEntry> getCmsContentEntriesForParentIdAndCeTypeName(Connection conn, 
			CmsContentEntry ce, String ceType) throws SQLException {
		List<CmsContentEntry> ces = new LinkedList<CmsContentEntry>();
		PreparedStatement stmt = conn.prepareStatement("SELECT "+CE_FIELDS+" FROM CMS_CONTENT_ENTRY ce WHERE ce.PARENT_ID = ? AND ce.CE_TYPE_NAME = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, ce.getId());
			stmt.setString(2, ceType);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ces.add(getCmsContentEntry(rs));
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return ces;
	}
	private static CoUrl getCoUrl(Connection conn, CmsContentEntry ce) throws SQLException {
		if (ce==null)
			return null;
		PreparedStatement stmt = conn.prepareStatement("SELECT url.ID, url.LINK, url.OPENINNEWWINDOWFLAG FROM CO_URL url WHERE url.id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, ce.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new CoUrl(rs.getBigDecimal(1), rs.getString(2), rs.getInt(3)!=0);
			}		
			//logger.log(Level.WARNING, "Could not CoUrl "+ce.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static CmsFileContent getCmsFileContent(Connection conn,
			BigDecimal id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT fc.ID, fc.LASTMODIFY_TS, fc.MIMETYPE_ID, fc.CHARACTER_SET FROM CMS_FILE_CONTENT fc WHERE fc.id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new CmsFileContent(rs.getBigDecimal(1), rs.getLong(2), rs.getBigDecimal(3), rs.getString(4));
			}		
			//logger.log(Level.WARNING, "Could not CmsFileContent "+ce.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static CmsFileContent getCmsFileContent(Connection conn,
			CmsContentEntry ce) throws SQLException {
		if (ce==null || ce.getFileContentId()==null)
			return null;
		return getCmsFileContent(conn, ce.getFileContentId());
	}
	private static long getContentLength(Connection conn, CmsFileContent fc) throws SQLException {
		if (fc==null)
			return 0;
		PreparedStatement stmt = conn.prepareStatement("SELECT fc.CONTENT FROM CMS_FILE_CONTENT fc WHERE fc.id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, fc.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				Blob blob = rs.getBlob(1);
				if (blob!=null) {
					long len = blob.length();
					try {
						blob.free();
					}
					catch (Throwable ignore) {}
					return len;
				}
			}		
			logger.log(Level.WARNING, "Could not CmsFileContent length for "+fc.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return 0;
	}
	private static String dumpAndDigestCmsFileContent(Connection conn, CmsFileContent fc, File f) throws SQLException {
		if (fc==null)
			return null;
		PreparedStatement stmt = conn.prepareStatement("SELECT fc.CONTENT FROM CMS_FILE_CONTENT fc WHERE fc.id = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, fc.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				Blob blob = rs.getBlob(1);
				if (blob!=null) {
					try {
						if (f.exists() && f.isFile() && f.length()==blob.length()) {
							logger.log(Level.WARNING, "File already existed - deleting: "+f);
							f.delete();
						}
						MessageDigest md;
						md = MessageDigest.getInstance("SHA-1");

						logger.info("    blob "+blob.length()+" bytes -> "+f);
						OutputStream os = new FileOutputStream(f);
						InputStream is = blob.getBinaryStream();
						int cnt = 0;
						byte buf[] = new byte[1280000];
						while(true) {
							int n = is.read(buf);
							if (n<0)
								break;
							os.write(buf, 0, n);
							md.update(buf, 0, n);
							cnt += n;
						}
						if (cnt<blob.length()) {
							logger.log(Level.WARNING, "Wrote only "+cnt+"/"+blob.length()+" bytes to "+f);
						}
						os.close();
						try {
							is.close();
						}
						catch(Exception e) {
						}			
						byte sha1hash[] = md.digest();
						return convertToHex(sha1hash);

					} catch (Exception e) {
						logger.log(Level.WARNING, "Could not write blob to "+f, e);
					}
					finally {
						try {
							blob.free();
						} catch (SQLException e) {}
					}
					return null;
				}
			}		
			logger.log(Level.WARNING, "Could not CmsFileContent content for "+fc.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static CmsContentEntry getCmsContentEntryByRightobjectId(
			Connection conn, CmsLink link) throws SQLException {
		if (link==null || link.getRightobjectId()==null)
			return null;
		return getCmsContentEntry(conn, link.getRightobjectId());
	}
	private static List<CmsLink> getCmsLinksForLeftobjectId(Connection conn,
			CmsContentEntry ce) throws SQLException {
		List<CmsLink> links = new LinkedList<CmsLink>();
		PreparedStatement stmt = conn.prepareStatement("SELECT link.ID, link.LINK_TYPE_ID, link.LEFTOBJECT_ID, link.RIGHTOBJECT_ID, link.NAME FROM CMS_LINK link WHERE link.LEFTOBJECT_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, ce.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				links.add(new CmsLink(rs.getBigDecimal(1), rs.getBigDecimal(2), rs.getBigDecimal(3), rs.getBigDecimal(4), rs.getString(5)));
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return links;
	}
	private static CoOrganizerlink getCoOrganizerlink(Connection conn, CmsLink link) throws SQLException {
		if (link==null)
			return null;
		PreparedStatement stmt = conn.prepareStatement("SELECT col.ID, col.POSITION, col.OPENINNEWWINDOW, col.LONG_DESCRIPTION, col.LINKNAME FROM CO_ORGANIZERLINK col WHERE col.ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, link.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				// 4 is clob - get as string?!
				return new CoOrganizerlink(rs.getBigDecimal(1), rs.getFloat(2), rs.getInt(3)!=0, rs.getString(4), rs.getString(5));
			}		
			//logger.log(Level.WARNING, "Could not CoUrl "+ce.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static List<Member> getMembers(Connection conn, LearningContext lc) throws SQLException {
		List<Member> members = new LinkedList<Member>();
		PreparedStatement stmt = conn.prepareStatement("SELECT m.ID, m.PERSON_ID, m.LEARNING_CONTEXT_ID, m.STATUS_FLAG, m.DELETE_STATUS FROM MEMBER m WHERE m.LEARNING_CONTEXT_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, lc.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				Member m = new Member(rs.getBigDecimal(1), rs.getBigDecimal(2), rs.getBigDecimal(3), rs.getInt(4)!=0, rs.getInt(5)!=0);
				members.add(m);
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return members;
	}
	private static List<Member> getMembers(Connection conn, Person p) throws SQLException {
		List<Member> members = new LinkedList<Member>();
		PreparedStatement stmt = conn.prepareStatement("SELECT m.ID, m.PERSON_ID, m.LEARNING_CONTEXT_ID, m.STATUS_FLAG, m.DELETE_STATUS FROM MEMBER m WHERE m.PERSON_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, p.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				Member m = new Member(rs.getBigDecimal(1), rs.getBigDecimal(2), rs.getBigDecimal(3), rs.getInt(4)!=0, rs.getInt(5)!=0);
				members.add(m);
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return members;
	}
	private static List<Role> getRoles(Connection conn, Member m) throws SQLException {
		List<Role> roles = new LinkedList<Role>();
		PreparedStatement stmt = conn.prepareStatement("SELECT r.ID, r.MEMBER_ID, r.ROLE_DEFINITION_ID, r.DELETE_STATUS, r.ROLE_STATUS FROM ROLE r WHERE r.MEMBER_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, m.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				Role r = new Role(rs.getBigDecimal(1), rs.getBigDecimal(2), rs.getBigDecimal(3), rs.getInt(4)!=0, rs.getInt(5)!=0);
				roles.add(r);
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return roles;
	}
	
	/** person cache */
	private static Map<BigDecimal,Person> personCache = new HashMap<BigDecimal,Person>();
	synchronized static Person getPerson(Connection conn, BigDecimal id) throws SQLException {
		if (id==null)
			return null;
		// fetch on-demand
		if (personCache.containsKey(id))
			return personCache.get(id);
		PreparedStatement stmt = conn.prepareStatement("SELECT p.ID, p.LEARNING_CONTEXT_ID, p.ACTIVESTATUS, p.DEMOUSER, p.REMOTE_USERID, p.WEBCT_ID, p.SOURCEDID_SOURCE, p.DELETESTATUS, p.HOMEFOLDER_ID FROM PERSON p WHERE p.ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Person p = new Person(rs.getBigDecimal(1), rs.getBigDecimal(2), rs.getInt(3)!=0, rs.getInt(4)!=0, rs.getString(5), rs.getString(6), rs.getString(7), rs.getBigDecimal(8), rs.getBigDecimal(9));
				personCache.put(p.getId(), p);
				return p;
			}		
			//logger.log(Level.WARNING, "Could not CoUrl "+ce.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static Person getPerson(Connection conn, Member m) throws SQLException {
		if (m==null)
			return null;
		return getPerson(conn, m.getPersonId());
	}
	public static Person getPersonByWebctId(Connection conn, String username) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT p.ID FROM PERSON p WHERE p.WEBCT_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return getPerson(conn, rs.getBigDecimal(1));
			}		
			//logger.log(Level.WARNING, "Could not CoUrl "+ce.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	public static List<BigDecimal> getPersonIds(Connection conn) throws SQLException {
		List<BigDecimal> pids = new LinkedList<BigDecimal>();
		// active , not demo
		PreparedStatement stmt = conn.prepareStatement("SELECT p.ID FROM PERSON p WHERE p.ACTIVESTATUS = 1 AND p.DEMOUSER = 0", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			while(rs.next()) {
				pids.add(rs.getBigDecimal(1));
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return pids;
	}
	private static List<LearningContext> getLearningContextsForPersonAsRole(
			Connection conn, Person p, RoleDefinition rd, String lcTypeCode) throws SQLException {
		List<Member> members = getMembers(conn, p);
		LinkedList<LearningContext> lcs = new LinkedList<LearningContext>();
		
		for (Member m : members) {
			LearningContext lc = getLearningContext(conn, m.getLearningContextId());
			if (lcTypeCode!=null && !lcTypeCode.equals(lc.getTypeCode()))
				// exclude on type code
				continue;
			List<Role> rs = getRoles(conn, m);
			boolean include = false;
			for (Role r: rs) {
				if (r.getRoleDefinitionId().equals(rd.getId()))
					include = true;
			}
			if (include) {
				lcs.add(lc);
			}
		}
		return lcs;
	}
	/** cache RoleDefinitions */
	private static Map<BigDecimal, RoleDefinition> roleDefinitionCache = null;
	private static synchronized RoleDefinition getRoleDefinition(Connection conn, BigDecimal id) throws SQLException {
		if (roleDefinitionCache!=null)
			return roleDefinitionCache.get(id);
		roleDefinitionCache = 	new HashMap<BigDecimal, RoleDefinition>();
		// pre-fetch all
		PreparedStatement stmt = conn.prepareStatement("SELECT rd.ID, rd.NAME FROM ROLE_DEFINITION rd", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			while(rs.next()) {
				RoleDefinition rd = new RoleDefinition(rs.getBigDecimal(1), rs.getString(2));
				roleDefinitionCache.put(rd.getId(), rd);
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return roleDefinitionCache.get(id);
	}
	private static RoleDefinition getRoleDefinition(Connection conn, Role r) throws SQLException {
		return getRoleDefinition(conn, r.getRoleDefinitionId());
	}
	/** section designer role */
	public static final String SDES = "SDES";
	private static RoleDefinition getRoleDefinitionForSectionDesigner(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT rd.ID FROM ROLE_DEFINITION rd WHERE rd.NAME = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setString(1, SDES);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return getRoleDefinition(conn, rs.getBigDecimal(1));
			}
			logger.log(Level.WARNING,"Could not find RoleDefinition for section designer");
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	private static List<AccessControlEntry> getAccessControlEntries(Connection conn, BigDecimal aclId) throws SQLException {
		List<AccessControlEntry> members = new LinkedList<AccessControlEntry>();
		PreparedStatement stmt = conn.prepareStatement("SELECT m.ID, m.ACL_ID, m.GRANTEE_ID, m.PERMISSION_SET_ID FROM ACCESS_CONTROL_ENTRY m WHERE m.ACL_ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, aclId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				AccessControlEntry m = new AccessControlEntry(rs.getBigDecimal(1), rs.getBigDecimal(2), rs.getBigDecimal(3), rs.getBigDecimal(4));
				members.add(m);
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return members;
	}
	/** cache AccessControlPermissionSets */
	private static Map<BigDecimal, AccessControlPermissionSet> accessControlPermissionSetCache = null;
	private static synchronized AccessControlPermissionSet getAccessControlPermissionSet(Connection conn, BigDecimal id) throws SQLException {
		if (accessControlPermissionSetCache!=null)
			return accessControlPermissionSetCache.get(id);
		accessControlPermissionSetCache = 	new HashMap<BigDecimal, AccessControlPermissionSet>();
		// pre-fetch all
		PreparedStatement stmt = conn.prepareStatement("SELECT rd.ID, rd.NAME, rd.ACL_READ FROM ACCESS_CONTROL_PERMISSION_SET rd", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			while(rs.next()) {
				AccessControlPermissionSet rd = new AccessControlPermissionSet(rs.getBigDecimal(1), rs.getString(2), rs.getInt(3)!=0);
				accessControlPermissionSetCache.put(rd.getId(), rd);
			}
		}
		finally {
			tidy(rs, stmt);
		}
		return accessControlPermissionSetCache.get(id);
	}
	private static AccessControlPermissionSet getAccessControlPermissionSet(Connection conn, AccessControlEntry e) throws SQLException {
		return getAccessControlPermissionSet(conn, e.getPermissionSetId());
	}
	private static boolean getAclRead(Connection conn, AccessControlEntry e) throws SQLException {
		if(e==null)
			return false;
		AccessControlPermissionSet p = getAccessControlPermissionSet(conn, e.getPermissionSetId());
		if (p==null)
			return false;
		return p.isAclRead();
	}
	/** person cache */
	private static Map<BigDecimal,CmsMimetype> mimetypeCache = new HashMap<BigDecimal,CmsMimetype>();
	synchronized static CmsMimetype getMimetype(Connection conn, CmsFileContent fc) throws SQLException {
		if (fc==null || fc.getMimetypeId()==null)
			return null;
		// fetch on-demand
		if (mimetypeCache.containsKey(fc.getMimetypeId()))
			return mimetypeCache.get(fc.getMimetypeId());
		PreparedStatement stmt = conn.prepareStatement("SELECT p.ID, p.MIMETYPE, p.BINARY FROM CMS_MIMETYPE p WHERE p.ID = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = null;
		try {
			stmt.setBigDecimal(1, fc.getMimetypeId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				CmsMimetype mt = new CmsMimetype(rs.getBigDecimal(1), rs.getString(2), rs.getBoolean(3));
				mimetypeCache.put(mt.getId(), mt);
				return mt;
			}		
			//logger.log(Level.WARNING, "Could not CoUrl "+ce.getId());
		}
		finally {
			tidy(rs, stmt);
		}
		return null;
	}
	static void tidy(ResultSet rs, PreparedStatement stmt) {
		if (rs!=null)
			try { rs.close(); } catch (Throwable ignore) {}
		if (stmt!=null)
			try { stmt.close(); } catch (Throwable ignore) {}		
	}
}
