/**
 * 
 */
package webctdbexport.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import webctdbexport.db.LearningContext;
import webctdbexport.jdbc.model.Person;
import webctdbexport.test.TestRepository;
import webctdbexport.tools.DumpUtils;
import webctdbexport.utils.DbUtils;
//import webctdbexport.utils.MoodleRepository;

/** Dump all users and their own file areas in whole database (and ALL contexts if all), 
 * avoiding unnecessary downloads if a prior dump is available.
 * 
 * @author cmg
 *
 */
public class DumpIncremental {
	private static final String DONE_FILE = "done.ts";
	static Logger logger = Logger.getLogger(DumpIncremental.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length<4) {
			System.err.println("Usage: <jdbc.properties> <outputdir> <filedir> <oldoutputdir> [usernames...]");
			System.exit(-1);
		}
		File outputdir = new File(args[1]);
		if (!outputdir.exists() || !outputdir.canWrite() || !outputdir.isDirectory()) {
			logger.log(Level.SEVERE, "Output directory does not exist or is not writable: "+outputdir);
			System.exit(-1);
		}
		File filedir = new File(args[2]);
		if (!filedir.exists() || !filedir.canWrite() || !filedir.isDirectory()) {
			logger.log(Level.SEVERE, "File directory does not exist or is not writable: "+filedir);
			System.exit(-1);
		}
		File oldoutputdir = new File(args[3]);
		if (oldoutputdir.exists()) {
			if (oldoutputdir.canRead() && oldoutputdir.isDirectory()) {
				logger.log(Level.INFO, "Attempting incremental dump based on "+oldoutputdir);
			}
			else {
				logger.log(Level.SEVERE, "Old output directory is not a directory or not readable: "+oldoutputdir);
				System.exit(-1);
			}
		}
		else {
			logger.log(Level.WARNING, "Doing non-incremental dump: oldoutputdir does not exist: "+oldoutputdir);
			oldoutputdir = null;
		}
		Connection conn = JdbcUtils.getConnection(args[0]);
		int returncode = 0;
		try {
			boolean dumpAll = true;
			logger.log(Level.INFO, "output folders to "+outputdir);
			List<BigDecimal> personIds = DumpUsers.getPersonIds(args, 4, conn);
			if (args.length>4) {
				dumpAll = false;
			}
			for (BigDecimal personId : personIds) {
				// no extrapermissions
				DumpUsers.dumpUser(conn, personId, outputdir, filedir, null, oldoutputdir);
			}
			logger.log(Level.INFO, "Done all users");
			
			if (dumpAll) 
			{
				DumpAll.dumpAll(conn, outputdir, filedir, oldoutputdir);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
			returncode = -2;
		}
		finally {
			try { conn.close(); } catch (Throwable ignore) {}
		}
		logger.log(Level.INFO,"Exiting with code "+returncode);
		System.exit(returncode);
	}	
}
