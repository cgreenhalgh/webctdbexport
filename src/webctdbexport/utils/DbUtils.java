/**
 * 
 */
package webctdbexport.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import webctdbexport.db.CmsCeSubtype;
import webctdbexport.db.CmsContentEntry;
import webctdbexport.db.CmsFileContent;
import webctdbexport.db.CmsLink;
import webctdbexport.db.CmsLinkOrder;
import webctdbexport.db.CmsLinkType;
import webctdbexport.db.CmsMimetype;
import webctdbexport.db.CoContentpage;
import webctdbexport.db.CoHeaderfooter;
import webctdbexport.db.CoOrganizerlink;
import webctdbexport.db.CoOrganizerpage;
import webctdbexport.db.CoResourcelink;
import webctdbexport.db.CoTemplate;
import webctdbexport.db.CoTemplateRootOrganizer;
import webctdbexport.db.CoToc;
import webctdbexport.db.CoUrl;
import webctdbexport.db.LearningContext;
import webctdbexport.db.Member;
import webctdbexport.db.Person;
import webctdbexport.db.Role;
import webctdbexport.db.RoleDefinition;
import webctdbexport.db.SimpleFile;

/**
 * @author cmg
 *
 */
public class DbUtils {
	static Logger logger = Logger.getLogger(DbUtils.class.getName());
	private static SessionFactory sf;
	public synchronized static SessionFactory getSessionFactory() {
		if (sf!=null)
			return sf;
	    sf = new Configuration()
        .configure() // configures settings from hibernate.cfg.xml
        .buildSessionFactory();
	    return sf;
	}
	public static Session getSession() {
		SessionFactory sf = getSessionFactory();
	    Session s = sf.openSession();
	    s.setDefaultReadOnly(true);
	    return s;
	}
	public static Person getPersonByWebctId(Session s, String webctId) {
		return (Person)s.createQuery("from Person as p where p.webctId=?").setString(0, webctId).uniqueResult();
	}
	public static RoleDefinition getRoleDefinitionForSectionDesigner(Session s) {
		RoleDefinition rd = (RoleDefinition)s.createQuery("from RoleDefinition as rd where rd.name='SDES'").uniqueResult();
		if (rd==null) {
			logger.log(Level.WARNING, "Could not find RoleDefinition for SDES");
		}
		return rd;
	}
	public static List<LearningContext> getLearningContextsForPersonAsRole(Session s, Person p, RoleDefinition rd) {
		List ms = getMembersForPerson(s, p);
		List<LearningContext> lcs = new LinkedList<LearningContext>();
		for (Object mo : ms) {
			Member m = (Member)mo;
			Role r = (Role)s.createQuery("from Role as r where r.member=? and r.roleDefinition=?").setEntity(0, m).setEntity(1,rd).uniqueResult();
			if (r==null) {
				//logger.log(Level.WARNING, "Could not file Role for Member "+m.getId());
				continue;
			}
			if (r.getRoleDefinition().getId().equals(rd.getId())) {
				LearningContext lc = m.getLearningContext();
				lcs.add(lc);
			}			
		}
		return lcs;
	}
	public static List getMembersForPerson(Session s, Person p) {
		return s.createQuery("from Member as m where m.person=?").setEntity(0, p).list();
	}
	public static void dumpHomefolder(Session s, Person p, File dir) {
		// no FK info here
		BigDecimal homefolderId = p.getHomefolderId();
		CmsContentEntry ce = (CmsContentEntry)s.createQuery("from CmsContentEntry as ce where ce.id=?").setBigDecimal(0, homefolderId).uniqueResult();
		dumpCmsContentEntry(s, ce, dir);
	}
	public static void dumpHomefolder(Session s, LearningContext lc, File dir) {
		// ORM has mapped homefolderId to this via FK info
		CmsContentEntry ce = lc.getCmsContentEntry();
		if (ce!=null)
			dumpCmsContentEntry(s, ce, dir);
	}
	public static final String ORGANIZER_PAGE_TYPE = "ORGANIZER_PAGE_TYPE/Default";
	public static final String PAGE_TYPE = "PAGE_TYPE/Default";
	public static String getTypename(CmsContentEntry ce) {
		CmsCeSubtype subtype = ce.getCmsCeSubtype();
		String typename=(subtype!=null ? subtype.getCmsCeType().getName()+"/"+subtype.getId().getName() : "unknown/null");
		return typename;
	}
	private static void dumpCmsContentEntry(Session s, CmsContentEntry ce,
			File dir) {
		String typename= getTypename(ce);
		logger.info(ce.getId()+" '"+ce.getName()+"', type="+typename);

		String name = ce.getName();

		if (ORGANIZER_PAGE_TYPE.equals(typename)) {
			dumpOrganizerPage(s, ce, name, dir);
			return;
		}
		
		String filename = getSafeName(name);
		
		Set<CmsContentEntry> children = ce.getCmsContentEntriesForParentId();
		CmsFileContent fc = ce.getCmsFileContent();
		if (fc!=null) {
			CmsMimetype mimeType = fc.getCmsMimetype();
			String extension = mimeType!=null ? "."+mimeType.getExtension() : "";
			
			logger.info("  content "+fc.getId()+", "+(mimeType!=null ? mimeType.getMimetype()+", "+mimeType.getExtension()+" ("+mimeType.getName()+")" : "no mime type"));
			File f = new File(dir, filename); // already include extension(s)?! +extension);
			dumpCmsFileContent(fc, f);
			// in generated classes, but no use
//			Set<SimpleFile> sfs = fc.getSimpleFiles();
//			for(SimpleFile sf : sfs)
//				logger.info(prefix.toString()+"    simple file "+sf.getId()+", "+sf.getName());
		}
		Set<CmsLink> links = ce.getCmsLinksForLeftobjectId();
		//if (fc==null || children.size()>0 || links.size()>0) {
			// placeholder/index
			File f = new File(dir, filename+".html");
			File subdir = new File(dir, filename);
			try {
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
				pw.println("<html><head>");
				pw.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				pw.println("<title>"+filename+"</title>");
				pw.println("</head><body>");
				pw.println("<h1>"+filename+"</h1>");
				pw.println("<ul>");
				pw.println("<li>Name: "+ce.getName()+"</li>");
				String description = getDescription(ce); 
				pw.println("<li>Description: "+description+"</li>");
				pw.println("<li>ID: "+ce.getId()+"</li>");
				pw.println("<li>type: "+typename+"</li>");
				CmsCeSubtype subtype = ce.getCmsCeSubtype();
				Set<CmsMimetype> mimetypes = subtype.getCmsMimetypes();
				for (CmsMimetype mimetype : mimetypes) {
					pw.println("<li>subtype mimetype extension:" +mimetype.getExtension()+"</li>");
				}
				pw.println("<li>DeletedFlag: "+ce.getDeletedFlag()+"</li>");
				if (fc!=null) {
					CmsMimetype mimeType = fc.getCmsMimetype();
					pw.println("<li>Content mimeType extension: "+(mimeType!=null ? mimeType.getExtension() : "null")+"</li>");
				}				
				if (links.size()>0) {
					pw.println("<li>Links:</li><ul>");
					for(CmsLink link : links) {
						CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
						CmsLinkType linkType = link.getCmsLinkType();
						String linkTypeName = linkType!=null ? linkType.getName() : "unknown";
						String linkName = child!=null ? child.getName() : link.getName();
						//CoResourcelink linkResource = link.getCoResourcelink();
						// TODO: file extension?!
						String childFilename = getSafeName(linkName);
						CoOrganizerlink orgLink = link.getCoOrganizerlink();
						if (orgLink!=null) {
							if (orgLink.getLinkname()!=null)
									linkName = orgLink.getLinkname();
							pw.println("<li><a href=\""+filename+"/"+childFilename+"\">"+linkName+"</a> ("+child.getId()+") - "+link.getCmsLinkType().getName()+" at "+orgLink.getPosition()+", "+getText(orgLink.getLongDescription()));							
						}
						else {
							CmsLinkOrder linkOrder = link.getCmsLinkOrder();
							double displayOrder = linkOrder!=null ? linkOrder.getDisplayOrder() : 0;
							pw.println("<li><a href=\""+filename+"/"+childFilename+"\">"+linkName+"</a> ("+child.getId()+") - "+link.getCmsLinkType().getName()+" at "+displayOrder);
						}
					}
					pw.println("</ul>");
				}
				CoUrl url = ce.getCoUrl();
				if (url!=null)
					pw.println("<li>URL: "+url.getLink()+"</li>");
				CoOrganizerpage org = ce.getCoOrganizerpage();
				if (org!=null) {
					pw.println("<li>Organizer: "+org+"</li>");
					pw.println("<ul>");
					Set<CoHeaderfooter> hfs = org.getCoHeaderfooters();
					for (CoHeaderfooter hf : hfs) {
						pw.println("<li>CoHeaderfooter "+getText(hf.getHdFtText())+"</li>");
					}
					pw.println("</ul>");					
					pw.println("<ul>");
					Set<CoTemplateRootOrganizer> tros = org.getCoTemplateRootOrganizers();
					for (CoTemplateRootOrganizer tro : tros) {
						CoTemplate t = tro.getCoTemplate();
						if (t!=null) {
							pw.println("<li>CoTemplateRootOrganizer "+tro.getId()+"</li>");
						}
					}
					pw.println("</ul>");
				}
				Set<CoOrganizerlink> orglinks = ce.getCoOrganizerlinks();
				if (orglinks.size()>0) {
					pw.println("<li>OrganizerLinks:</li><ul>");
					for(CoOrganizerlink link : orglinks) {
						pw.println("<li>"+link.getLinkname()+" ["+link.getPosition()+"] "+link.getCmsContentEntry().getName()+"</li>");
					}
					pw.println("</ul>");

				}
				CoContentpage cp = ce.getCoContentpage();
				if (cp!=null) {
					pw.println("<li>ContentPage: "+cp+"</li>");
				}
				
				CoToc toc = ce.getCoToc();
				if (toc!=null)
					pw.println("<li>TOC: "+toc+"</li>");
				pw.println("</ul>");

				if (children.size()>0) {
					pw.println("<p>Children:</p>");
					pw.println("<ul>");
					for (CmsContentEntry child : children) {
						// TODO link
						String childFilename = getSafeName(child.getName());
						pw.println("<li><a href=\""+filename+"/"+childFilename+"\">"+child.getName()+"</a> ("+child.getId()+") - "+getDescription(child)+"</li>");
					}
					pw.println("</ul>");
				}
				
				pw.println("</body></html>");
				pw.close();
			}
			catch (Exception e) {
				logger.log(Level.WARNING, "Error writing non-content file placeholder");
			}
			if (children.size()>0 || links.size()>1 || (links.size()==1 && !"PAGE_TYPE/Default".equals(typename))) {
				subdir.mkdir();
				for (CmsContentEntry child : children) {
					dumpCmsContentEntry(s, child, subdir);
				}
				for(CmsLink link : links) {
					CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
					dumpCmsContentEntry(s, child, subdir);
				}
			}
		//}
	}
	private static void dumpCmsFileContent(CmsFileContent fc, File f) {
		Blob blob = fc.getContent();
		try {
			logger.info("    blob "+blob.length()+" bytes -> "+f);
			OutputStream os = new FileOutputStream(f);
			InputStream is = blob.getBinaryStream();
			int cnt = 0;
			byte buf[] = new byte[100000];
			while(true) {
				int n = is.read(buf);
				if (n<0)
					break;
				os.write(buf, 0, n);
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
		} catch (Exception e) {
			logger.log(Level.WARNING, "Could not write blob to "+f, e);
		}
	}
	private static void dumpOrganizerPage(Session s, CmsContentEntry ce, String name,
			File dir) {
		//String name = ce.getName();
		String filename = getSafeName(name);

		File subdir = new File(dir, filename);
		File index = new File(subdir, "index.html");
		subdir.mkdir();

		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(index), "UTF-8"));
			pw.println("<html><head>");
			pw.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
			pw.println("<title>"+name+"</title>");
			pw.println("</head><body>");
			pw.println("<h1>"+name+"</h1>");
			pw.println("<ul>");

			Set<CmsLink> linkset = ce.getCmsLinksForLeftobjectId();
			List<CmsLink> links = new ArrayList<CmsLink>();
			links.addAll(linkset);
			Collections.sort(links, new OrganizerlinkComparator());
			
			for(CmsLink link : links) {
				CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
				// default name/desc from linked item
				String linkName = child.getName();
				String linkDesc = getText(child.getDescription());
				CoOrganizerlink orgLink = link.getCoOrganizerlink();
				if (orgLink!=null) {
					// should be! - override?!
					if (orgLink.getLinkname()!=null)
						linkName = orgLink.getLinkname();
					if (orgLink.getLongDescription()!=null)
						linkDesc = getText(orgLink.getLongDescription());
				}
				
				String childPath = getFilePath(s, child, linkName, subdir);
				pw.println("<li><a href=\""+childPath+"\">"+linkName+"</a> "+(linkDesc!=null ? linkDesc : "")+"</li>");
				
				// debug
				pw.println("<ul>");
				pw.println("<li>Link: "+link.getId()+"</li>");
				pw.println("<li>ID: "+child.getId()+"</li>");
				pw.println("</ul>");
			}
			pw.println("</ul>");
			pw.println("</body></html>");
			pw.close();
		}
		catch (Exception e) {
			logger.log(Level.WARNING, "Error writing organizer page index");
		}
	}
	private static String getFilePath(Session s, CmsContentEntry ce,
			String name, File dumpDir) {
		CoUrl url = ce.getCoUrl();
		if (url!=null && url.getLink()!=null)
			return url.getLink();

		String filename = getSafeName(name);
		String typename= getTypename(ce);

		if (ORGANIZER_PAGE_TYPE.equals(typename)) {
			if (dumpDir!=null)
				dumpOrganizerPage(s, ce, name, dumpDir);
			return filename+"/index.html";
		}
		CmsFileContent fc = ce.getCmsFileContent();
		if (fc!=null) {
			// its a file
			CmsMimetype mimeType = fc.getCmsMimetype();
			CmsCeSubtype subtype = ce.getCmsCeSubtype();
			if (subtype!=null) {
				Set<CmsMimetype> mimeTypes = subtype.getCmsMimetypes();
				if(!mimeTypes.isEmpty()) {
					CmsMimetype entityMimeType = mimeTypes.iterator().next();
					if (mimeType!=null && !mimeType.getExtension().equals(entityMimeType.getExtension()))
						logger.info("File overriding content extension "+mimeType.getExtension()+" with entity type extension "+entityMimeType.getExtension());
					mimeType = entityMimeType;
				}
			}
			String extension = mimeType!=null ? "."+mimeType.getExtension() : "";
			if (dumpDir!=null) {
				File f = new File(dumpDir, filename+extension);
				dumpCmsFileContent(fc, f);
			}
			return filename+extension;
		}
		if (PAGE_TYPE.equals(typename)) {
			// probably a link
			Set<CmsLink> links = ce.getCmsLinksForLeftobjectId();
			if (links.size()>0) {
				if (links.size()>1) {
					logger.log(Level.WARNING, "PAGE_TYPE with "+links.size()+" links! - only using first");					
				}
				CmsLink link = links.iterator().next();
				CmsContentEntry child = link.getCmsContentEntryByRightobjectId();
				if (child!=null)
					return getFilePath(s, child, name, dumpDir);
				logger.log(Level.WARNING,"PAGE_TYPE with link without child");
			}
		}
		
		// default - debug?!
		if (dumpDir!=null)
			dumpCmsContentEntry(s, ce, dumpDir);
		return filename+".html";
	}
	private static String getDescription(CmsContentEntry ce) {
		return getText(ce.getDescription());
	}
	private static String getText(Clob desc) {
		if (desc==null)
			return null;
		try {
			if (desc.length()<=0)
				return "";
			return desc.getSubString(1, (int) desc.length());
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Getting text from Clob "+desc, e);
			return null;
		}
	}
	public static String getSafeName(String name) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<name.length(); i++) {
			char c= name.charAt(i);
			if (Character.isLetterOrDigit(c) || c=='.' || c=='-' || c=='_' || c=='(' || c==')' || c==' ')
				sb.append(c);
			else
				sb.append("_");
		}
		// TODO clash??
		return sb.toString();
	}
}
