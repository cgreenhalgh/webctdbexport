/**
 * 
 */
package webctdbexport.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import webctdbexport.tools.DumpUtils;
import webctdbexport.utils.DbUtils;
import webctdbexport.utils.MoodleRepository;

/** Test Moodle Repository mapping (webctdbexport.utils.MoodleRepository).
 * 
 * @author cmg
 *
 */
public class TestRepository {
	private static final long MAX_FILE_SIZE = 500000000;
	static Logger logger = Logger.getLogger(TestRepository.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length==0) {
			System.err.println("Usage: username");
			System.exit(-1);
		}
		for (int ai=0; ai<args.length; ai++) {
			dumpUser(args[ai]);
		}
	}

	private static void dumpUser(String username) {
	    Session s = null;
		try {
			System.out.println("Dump for user "+username);
			s = DbUtils.getSession();
			File dir = new File("tmp."+username);
			dir.mkdirs();
			System.out.println("Write to "+dir);
			JSONObject listing = MoodleRepository.getListingForUser(s, username, true, true);

			DumpUtils.writeResponse(listing, dir, false);

			List<JSONObject> items = new LinkedList<JSONObject>();
			{
				JSONArray list = listing.getJSONArray(MoodleRepository.LIST);
				if (list!=null) {
					for (int li=0; li<list.length(); li++) 
						items.add(list.getJSONObject(li));
				}
			}			
			s.close();
			s = null;
			while(items.size()>0) {
				s = DbUtils.getSession();
				JSONObject item = items.remove(0);
				if (item.has(MoodleRepository.SOURCE)) {
					String url = item.getString(MoodleRepository.SOURCE);
					long size = -1;
					if (item.has(MoodleRepository.SIZE)) {
						size = item.getLong(MoodleRepository.SIZE);
					}
					if (size>MAX_FILE_SIZE) {
						System.out.println("Skip large file "+item.getString(MoodleRepository.TITLE)+" source="+url+", "+size+" bytes");
					} 
					else {
						System.out.println("dump file "+item.getString(MoodleRepository.TITLE)+" source="+url);
						MoodleRepository.getFile(s, url, dir);
					}
				}				
				else if(item.has(MoodleRepository.PATH)) {
					String title = item.getString(MoodleRepository.TITLE);
					String path = item.getString(MoodleRepository.PATH);
					System.out.println("dump folder "+title+" path="+path);
					JSONObject itemlisting = MoodleRepository.getListingForPath(s, path, true, true);
					File itemdir = new File(dir+path);
					itemdir.mkdirs();
					DumpUtils.writeResponse(itemlisting, itemdir, false);
					if (itemlisting.has(MoodleRepository.LIST)) {
						JSONArray list = itemlisting.getJSONArray(MoodleRepository.LIST);
						if (list!=null) {
							for (int li=0; li<list.length(); li++) 
								items.add(list.getJSONObject(li));
						}
					}
				}				
				// TODO ...
				s.close();
				s= null;
			}
			
			// TODO Auto-generated method stub
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Dumping "+username, e);
		}
		finally {
			if (s!=null) 
				try {
					s.close();
				} catch (Exception e) {/*ignore*/}
		}
	}


}
