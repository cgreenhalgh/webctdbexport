/**
 * 
 */
package webctdbexport.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import webctdbexport.db.Person;

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
			 // A SessionFactory is set up once for an application
		    SessionFactory sf = new Configuration()
		            .configure() // configures settings from hibernate.cfg.xml
		            .buildSessionFactory();
		    Session s = sf.openSession();
		    s.setDefaultReadOnly(true);
		    Criteria cuser = s.createCriteria(Person.class).add(Restrictions.eq("webctId", "pszcmg"));
		    List users = cuser.list();
		    for (Object ouser : users) {
		    	System.out.println("Found "+ouser.getClass()+" "+ouser);
		    }
		    s.close();
		}
		catch (Exception e) {
			logger.log(Level.WARNING, "Error", e);
		}
	}

}
