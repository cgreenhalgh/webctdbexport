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

import webctdbexport.utils.DbUtils;
import webctdbexport.utils.MoodleRepository;

/** Test Moodle Repository mapping (webctdbexport.utils.MoodleRepository).
 * 
 * @author cmg
 *
 */
public class TestRepository {
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
			JSONObject listing = MoodleRepository.getListingForUser(s, username);

			writeResponse(listing, dir);

			List<JSONObject> items = new LinkedList<JSONObject>();
			{
				JSONArray list = listing.getJSONArray(MoodleRepository.LIST);
				if (list!=null) {
					for (int li=0; li<list.length(); li++) 
						items.add(list.getJSONObject(li));
				}
			}			
			while(items.size()>0) {
				JSONObject item = items.remove(0);
				if (item.has(MoodleRepository.URL))
					System.out.println("dump file "+item.getString(MoodleRepository.TITLE)+" url="+item.getString(MoodleRepository.URL));
				else {
					String title = item.getString(MoodleRepository.TITLE);
					String path = item.getString(MoodleRepository.PATH);
					System.out.println("dump folder "+title+" path="+path);
					JSONObject itemlisting = MoodleRepository.getListingForPath(s, path);
					File itemdir = new File(dir+path);
					itemdir.mkdirs();
					writeResponse(itemlisting, itemdir);
					if (itemlisting.has(MoodleRepository.LIST)) {
						JSONArray list = itemlisting.getJSONArray(MoodleRepository.LIST);
						if (list!=null) {
							for (int li=0; li<list.length(); li++) 
								items.add(list.getJSONObject(li));
						}
					}
				}				
				// TODO ...
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

	private static void writeResponse(JSONObject listing, File dir) throws JSONException, IOException {
		File file = new File(dir, "get_listing.json");
		Writer fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		listing.write(fw);
		fw.close();
		logger.log(Level.FINE, "Wrote "+file);
	}

}
