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
import java.sql.SQLException;
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
import webctdbexport.db.CmsMimetype;
import webctdbexport.db.CoContentpage;
import webctdbexport.db.CoOrganizerlink;
import webctdbexport.db.CoOrganizerpage;
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
	private static void dumpCmsContentEntry(Session s, CmsContentEntry ce,
			File dir) {
		CmsCeSubtype subtype = ce.getCmsCeSubtype();
		logger.info(ce.getId()+" '"+ce.getName()+"', type="+(subtype!=null ? subtype.getCmsCeType().getName() : "unknown")+", subtype="+(subtype!=null ? subtype.getId().getName() : "null"));

		String name = ce.getName();
		String filename = getSafeName(name);
		
		Set<CmsContentEntry> children = ce.getCmsContentEntriesForParentId();
		CmsFileContent fc = ce.getCmsFileContent();
		if (fc!=null) {
			CmsMimetype mimeType = fc.getCmsMimetype();
			String extension = mimeType!=null ? "."+mimeType.getExtension() : "";
			
			logger.info("  content "+fc.getId()+", "+(mimeType!=null ? mimeType.getMimetype()+", "+mimeType.getExtension()+" ("+mimeType.getName()+")" : "no mime type"));
			Blob blob = fc.getContent();
			File f = new File(dir, filename+extension);
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
			// in generated classes, but no use
//			Set<SimpleFile> sfs = fc.getSimpleFiles();
//			for(SimpleFile sf : sfs)
//				logger.info(prefix.toString()+"    simple file "+sf.getId()+", "+sf.getName());
		}
		if (fc==null || children.size()>0) {
			// placeholder/index
			File f = new File(dir, filename+".html");
			File subdir = new File(dir, filename);
			try {
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
				pw.println("<html><head>");
				pw.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				pw.println("<title>"+filename+"</title>");
				pw.println("</head><body>");
				pw.println("<title>"+filename+"</title>");
				pw.println("<ul>");
				pw.println("<li>ID: "+ce.getId()+"</li>");
				pw.println("<li>type: "+(subtype!=null ? subtype.getCmsCeType().getName() : "null/unknown")+"</li>");
				pw.println("<li>subtype: "+(subtype!=null ? subtype.getId().getName() : "null")+"</li>");
				
				Set<CmsLink> links = ce.getCmsLinksForLeftobjectId();
				if (links.size()>0) {
					pw.println("<li>Links:</li><ul>");
					for(CmsLink link : links) {
						pw.println("<li>"+link.getName()+" -> "+link.getCmsContentEntryByRightobjectId().getId()+" ("+link.getCmsLinkType().getName()+")");
					}
					pw.println("</ul>");
				}
				CoUrl url = ce.getCoUrl();
				if (url!=null)
					pw.println("<li>URL: "+url.getLink()+"</li>");
				CoOrganizerpage org = ce.getCoOrganizerpage();
				if (org!=null) 
					pw.println("<li>Organizer: "+org+"</li>");
				Set<CoOrganizerlink> orglinks = ce.getCoOrganizerlinks();
				if (orglinks.size()>0) {
					pw.println("<li>OrganizerLinks:</li><ul>");
					for(CoOrganizerlink link : orglinks) {
						pw.println("<li>"+link.getLinkname()+" ["+link.getPosition()+"] "+link.getCmsContentEntry().getName()+"</li>");
					}
					pw.println("</ul>");

				}
				CoContentpage cp = ce.getCoContentpage();
				if (cp!=null)
					pw.println("<li>ContentPage: "+cp+"</li>");
				CoToc toc = ce.getCoToc();
				if (toc!=null)
					pw.println("<li>TOC: "+toc+"</li>");
				pw.println("</ul>");

				if (children.size()>0) {
					pw.println("<p>Children:</p>");
					pw.println("<ul>");
					for (CmsContentEntry child : children) {
						// TODO link
						pw.println("<li>"+child.getName()+" ("+child.getId()+") - "+child.getDescription()+"</li>");
					}
					pw.println("</ul>");
				}
				
				pw.println("</body></html>");
				pw.close();
			}
			catch (Exception e) {
				logger.log(Level.WARNING, "Error writing non-content file placeholder");
			}
			if (children.size()>0) {
				subdir.mkdir();
				for (CmsContentEntry child : children) {
					dumpCmsContentEntry(s, child, subdir);
				}
			}
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
