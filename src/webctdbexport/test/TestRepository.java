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

import webctdbexport.utils.DbUtils;
import webctdbexport.utils.MoodleRepository;

/** Test Moodle Repository mapping (webctdbexport.utils.MoodleRepository).
 * 
 * @author cmg
 *
 */
public class TestRepository {
	private static final long MAX_FILE_SIZE = 5000000;
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

			writeResponse(listing, dir);

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

	private static void writeResponse(JSONObject listing, File dir) throws JSONException, IOException {
		File file = new File(dir, "get_listing.json");
		Writer fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		listing.write(fw);
		fw.close();
		logger.log(Level.FINE, "Wrote "+file);
		file = new File(dir, "index.html");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")));
		pw.println("<html><head>");
		pw.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		String name = "undefined";
		String relativePath = ".";
		JSONArray path = listing.getJSONArray(MoodleRepository.PATH);
		if (path.length()>0) {
			StringBuffer namebuf = new StringBuffer();
			for (int pi=0; pi<path.length(); pi++) {
				JSONObject pathel = path.getJSONObject(pi);
				name = pathel.getString(MoodleRepository.NAME);
				if (namebuf.length()>0)
					namebuf.append(" : ");
				namebuf.append(name);
			}
			name = namebuf.toString();

			// final path
			JSONObject pathel = path.getJSONObject(path.length()-1);
			String filepath = pathel.getString(MoodleRepository.PATH);
			StringBuffer rpbuf = new StringBuffer();
			for (int ci=0; ci<filepath.length()-1; ci++) {
				if (filepath.charAt(ci)=='/') {
					if (rpbuf.length()>0)
						rpbuf.append("/");
					rpbuf.append("..");
				}
			}
			if (rpbuf.length()==0)
				rpbuf.append(".");
			relativePath = rpbuf.toString();
		}
		pw.println("<title>"+name+"</title>");
		pw.println("</head><body>");
		pw.println("<h1>"+name+"</h1>");
		pw.println("<ul>");
		JSONArray list = listing.getJSONArray(MoodleRepository.LIST);
		for (int li=0; li<list.length(); li++) {
			JSONObject item = list.getJSONObject(li);
			String title = item.getString(MoodleRepository.TITLE);
			String description = null;
			if (item.has(MoodleRepository.DESCRIPTION))
				description = item.getString(MoodleRepository.DESCRIPTION);
			String webcttype = null;
			if (item.has(MoodleRepository.WEBCT_TYPE))
				webcttype = item.getString(MoodleRepository.WEBCT_TYPE);
			if (item.has(MoodleRepository.PATH)) {
				pw.println("<li><a href=\""+relativePath+item.getString(MoodleRepository.PATH)+"index.html\">"+title+"</a> (folder, "+webcttype+")"+(description!=null ? "<br>"+description : "")+"</li>");
			}
			else if (item.has(MoodleRepository.SOURCE)) {
				long size = -1;
				if (item.has(MoodleRepository.SIZE)) {
					size = item.getLong(MoodleRepository.SIZE);
				}
				String url = item.getString(MoodleRepository.SOURCE);
				if (url.startsWith("http"))
					// link
					pw.println("<li><a href=\""+url+"\">"+title+"</a> (link, "+webcttype+")"+(description!=null ? "<br>"+description : "")+"</li>");
				else
					pw.println("<li><a href=\""+relativePath+url+"\">"+title+"</a> (file"+(size>=0 ? ", "+size+" bytes" : "")+", "+webcttype+")"+(description!=null ? "<br>"+description : "")+"</li>");
			}
//			else if (item.has(MoodleRepository.URL)) {
//				String url = item.getString(MoodleRepository.URL);
//				// link
//				pw.println("<li><a href=\""+url+"\">"+title+"</a> (link, "+webcttype+")"+(description!=null ? "<br>"+description : "")+"</li>");
//			}
			else {
				pw.println("<li>"+title+" ("+webcttype+")"+(description!=null ? "<br>"+description : "")+"</li>");				
			}
		}
		pw.println("</ul>");
		pw.close();
	}

}
