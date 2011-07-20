/**
 * 
 */
package webctdbexport.jdbc;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import webctdbexport.db.LearningContext;
import webctdbexport.test.TestRepository;
import webctdbexport.tools.DumpUtils;
import webctdbexport.utils.DbUtils;
//import webctdbexport.utils.MoodleRepository;

/** Dump whole database ?!
 * 
 * @author cmg
 *
 */
public class DumpAll {
	private static final String DONE_FILE = "done.ts";
	static Logger logger = Logger.getLogger(DumpAll.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=3) {
			System.err.println("Usage: <jdbc.properties> <outputdir> <filedir");
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
		Connection conn = JdbcUtils.getConnection(args[0]);
		
		try {
			logger.log(Level.INFO, "output folders to "+outputdir);
			// institutions...
			JSONObject listing = MoodleRepository.getListingForRoot(conn);

			DumpUtils.writeResponse(listing, outputdir);
			{
				JSONObject permissions = MoodleRepository.getPermissionsForPath(conn, "/");
				DumpUtils.writePermissions(permissions, outputdir);
			}			
			List<JSONObject> items = new LinkedList<JSONObject>();
			DumpUtils.addItems(items, listing, "/");

			while(items.size()>0) {
				JSONObject item = items.remove(0);
				if (item.has(MoodleRepository.SOURCE)) {
					String url = item.getString(MoodleRepository.SOURCE);
					long size = -1;
					if (item.has(MoodleRepository.SIZE)) {
						size = item.getLong(MoodleRepository.SIZE);
					}
//					if (size>MAX_FILE_SIZE) {
//						System.out.println("Skip large file "+item.getString(MoodleRepository.TITLE)+" source="+url+", "+size+" bytes");
//					} 
//					else 
					{
						System.out.println("dump file "+item.getString(MoodleRepository.TITLE)+" source="+url);
						// TODO SHA-1 stuff
						MoodleRepository.getFile(conn, url, filedir);
					}
				}				
				else if(item.has(MoodleRepository.PATH)) {
					String path = item.getString(MoodleRepository.PATH);
					File itemdir = new File(outputdir+path);
					String title = item.getString(MoodleRepository.TITLE);
					File donefile = new File(itemdir, DONE_FILE);
					if (donefile.exists()) {
						System.out.println("Skip completed folder "+title+" path="+path);
					} else {
						System.out.println("dump folder "+title+" path="+path);
						// TODO fix me
						JSONObject itemlisting = MoodleRepository.getListingForPath(conn, path, true, true);
						itemdir.mkdirs();
						DumpUtils.writeResponse(itemlisting, itemdir);
						DumpUtils.addItems(items, itemlisting, path);
						JSONObject permissions = MoodleRepository.getPermissionsForPath(conn, path);
						DumpUtils.writePermissions(permissions, itemdir);
					}
				}			
				else if (item.has(DumpUtils.DONE)) {
					String path = item.getString(DumpUtils.DONE);
					File doneFile = new File(outputdir+path+DONE_FILE);
					System.out.println("Done "+path+" ("+doneFile+")");
					doneFile.createNewFile();
				}
			}

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
		}
		finally {
			try { conn.close(); } catch (Throwable ignore) {}
		}

	}

}
