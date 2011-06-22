/**
 * 
 */
package webctdbexport.test;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import webctdbexport.db.LearningContext;
import webctdbexport.db.Person;
import webctdbexport.db.RoleDefinition;
import webctdbexport.utils.DbUtils;
/**
 * @author cmg
 *
 */
public class Test1 {
	static Logger logger = Logger.getLogger(Test1.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    Session s = DbUtils.getSession();
		    Person p = DbUtils.getPersonByWebctId(s, "pszcmg");
		    File outdir = new File("tmp");
		    outdir.mkdirs();
		    if (p!=null)
		    	System.out.println("Found person "+p.getId());
		    RoleDefinition sdes = DbUtils.getRoleDefinitionForSectionDesigner(s);
		    List<LearningContext> lcs = DbUtils.getLearningContextsForPersonAsRole(s, p, sdes);
		    logger.info("LearningContexts as SDES:");
		    for (LearningContext lc : lcs)
		    	logger.info("  "+lc.getId()+": "+lc.getName());

		    logger.info("Homefolder for "+p.getId());
		    File dir = new File(outdir, DbUtils.getSafeName(p.getWebctId()));
		    dir.mkdir();
		    //DbUtils.dumpHomefolder(s, p, dir);
		    for (LearningContext lc : lcs) {
		    	logger.info("Homefolder for "+lc.getId()+": "+lc.getName());
			    dir = new File(outdir, DbUtils.getSafeName(lc.getName()));
			    dir.mkdir();
		    	DbUtils.dumpHomefolder(s, lc, dir);
		    }
		    s.close();
		}
		catch (Exception e) {
			logger.log(Level.WARNING, "Error", e);
		}
	}

}
