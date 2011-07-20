/**
 * 
 */
package webctdbexport.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import webctdbexport.test.TestRepository;
import webctdbexport.utils.MoodleRepository;

/**
 * @author cmg
 *
 */
public class DumpUtils {
	public static final String DONE = "done";
	static Logger logger = Logger.getLogger(DumpUtils.class.getName());
	/** write a get_listing-type response to dist, also HTML version */
	public static void writeResponse(JSONObject listing, File dir) throws JSONException, IOException {
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
		pw.println("<p><a href=\"permissions.html\">permissions</a></p>");
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
					pw.println("<li><a href=\""+relativePath+url+"/file.html\">"+title+"</a> (file"+(size>=0 ? ", "+size+" bytes" : "")+", "+webcttype+")"+(description!=null ? "<br>"+description : "")+"</li>");
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
		pw.println("</body></html>");
		pw.close();
	}
	public static void addItems(List<JSONObject> items, JSONObject listing, String path2) throws JSONException {
		JSONArray list = listing.getJSONArray(MoodleRepository.LIST);
		if (list!=null) {
			for (int li=0; li<list.length(); li++) 
				items.add(li, list.getJSONObject(li));
		}
		// "done" marker
		if (path2!=null) {
			JSONObject done = new JSONObject();
			done.put(DONE, path2);
			items.add(list.length(), done);
		}
	}
	public static String getDone(JSONObject object) throws JSONException {
		if (object.has(DONE))
			return object.getString(DONE);
		return null;
	}
	/** write a get_permissions-type response to dist, also HTML version */
	public static void writePermissions(JSONObject permissions, File dir) throws JSONException, IOException {
		File file = new File(dir, "permissions.json");
		Writer fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		permissions.write(fw);
		fw.close();
		logger.log(Level.FINE, "Wrote "+file);
				
		file = new File(dir, "permissions.html");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")));
		pw.println("<html><head>");
		pw.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		String name = "Permissions";
		pw.println("<title>"+name+"</title>");
		pw.println("</head><body>");
		pw.println("<h1>"+name+"</h1>");
		pw.println("<ul>");
		Iterator keys = permissions.sortedKeys();
		while(keys.hasNext()) {
			String key = (String)keys.next();
			JSONArray roles = permissions.getJSONArray(key);
			pw.print("<li>"+key+": ");
			for (int i=0; i<roles.length(); i++) {
				if (i>0)
					pw.print(", ");
				pw.print(roles.getString(i));
			}
			pw.println("</li>");
		}
		pw.println("</ul>");
		pw.println("</body></html>");
		pw.close();
	}
	public static void writeFileInfo(JSONObject fileInfo, File itemdir,
			File filedir) throws JSONException, IOException {
		File file = new File(itemdir, "file.json");
		Writer fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		fileInfo.write(fw);
		fw.close();
		logger.log(Level.FINE, "Wrote "+file);
				
		file = new File(itemdir, "file.html");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")));
		pw.println("<html><head>");
		pw.println("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		String name = fileInfo.getString("filename");
		pw.println("<title>"+name+"</title>");
		pw.println("</head><body>");
		pw.println("<h1>"+name+"</h1>");
		pw.println("<p>Filename: "+fileInfo.getString("filename")+"</p>");
		if (fileInfo.has("length"))
			pw.println("<p>Length: "+fileInfo.getLong("length")+" bytes</p>");
		if (fileInfo.has("mimetype"))
			pw.println("<p>Mimetype: "+fileInfo.getString("mimetype")+"</p>");
		if (fileInfo.has("sha1hash"))
			pw.println("<p>sha1hash: "+fileInfo.getString("sha1hash")+"</p>");
		if (fileInfo.has("path")) {
			File p = new File(filedir, fileInfo.getString("path"));
			pw.println("<p>path: <a href=\""+p.getCanonicalPath()+"\">"+fileInfo.getString("path")+"</a></p>");
		}		
		pw.close();
	}
}
