/**
 * 
 */
package webctdbexport.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/** search for a learning context by name
 * @author cmg
 *
 */
public class FindLearningContext {
	static Logger logger = Logger.getLogger(FindLearningContext.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length<1 || args.length>3) {
			System.err.println("Usage: <jdbc.properties> <section-name-pattern> [<course-name-pattern>]");
			System.exit(-1);			
		}
		Connection conn = JdbcUtils.getConnection(args[0]);
		
		try {
			String sectionName = (args.length>1 ? args[1] : "%"), courseName = (args.length>2 ? args[2] : "%");
			if (args.length==1) {
				// prompt
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Section name pattern?");
				sectionName = br.readLine();
				if (sectionName==null)
					System.exit(0);
				System.out.println("Course name pattern? (default: %)");
				courseName = br.readLine();
				if (courseName==null || courseName.length()==0)
					courseName = "%";				
			}
			logger.log(Level.INFO, "Search for Section(s) '"+sectionName+"' in Course(s) '"+courseName+"'");
			PreparedStatement stmt = conn.prepareStatement("SELECT lc.ID, lc.NAME, lcp.ID, lcp.NAME FROM LEARNING_CONTEXT lc INNER JOIN LEARNING_CONTEXT lcp ON lc.PARENT_ID = lcp.ID WHERE lc.TYPE_CODE = 'Section' AND lc.NAME LIKE ? AND lcp.NAME LIKE ?");
			ResultSet rs = null;
			try {
				stmt.setString(1, sectionName);
				stmt.setString(2, courseName);
				rs = stmt.executeQuery();
				while(rs.next()) {
					BigDecimal lcid = rs.getBigDecimal(1);
					String lcSectionName = rs.getString(2);
					String lcCourseName = rs.getString(4);
					System.out.println("lc"+lcid+": "+lcCourseName+" - "+lcSectionName);
				}
			}
			finally {
				MoodleRepository.tidy(rs, stmt);
			}
			System.out.println("Done");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
		}
		finally {
			try { conn.close(); } catch (Throwable ignore) {}
		}
	}

}
