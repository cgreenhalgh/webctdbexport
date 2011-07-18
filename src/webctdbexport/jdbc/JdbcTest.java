/**
 * 
 */
package webctdbexport.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import java.util.logging.Level;

import webctdbexport.utils.DbUtils;
import webctdbexport.utils.MoodleRepository;

/** Try direct JDBC.
 * 
 * @author cmg
 *
 */
public class JdbcTest {
	static Logger logger = Logger.getLogger(JdbcTest.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=1) {
			logger.log(Level.SEVERE, "Usage: <jdbc.properties>");
			System.exit(-1);
		}
		Connection conn = JdbcUtils.getConnection(args[0]);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("SELECT lc.id, lc.name, lc.TYPE_CODE FROM LEARNING_CONTEXT lc WHERE lc.TYPE_CODE = ?", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1, DbUtils.LC_INSTITUTION);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BigDecimal id = rs.getBigDecimal(1);
				String name = rs.getString(2);
				String typeCode = rs.getString(3);
				System.out.println("Found "+typeCode+" "+id+": "+name);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
		}
		finally {
			if (rs!=null)
				try { rs.close(); } catch (Throwable ignore) {}
			if (stmt!=null)
				try { stmt.close(); } catch (Throwable ignore) {}
			try { conn.close(); } catch (Throwable ignore) {}
		}
	}

}
