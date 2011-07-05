/**
 * 
 */
package webctdbexport.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONException;
import org.json.JSONObject;

import webctdbexport.db.CmsFileContent;
import webctdbexport.test.TestRepository;
import webctdbexport.utils.DbUtils;
import webctdbexport.utils.MoodleRepository;

/** get_file servlet
 * 
 * @author cmg
 *
 */
public class GetFileServlet extends HttpServlet {
	static Logger logger = Logger.getLogger(GetFileServlet.class.getName());

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getPathInfo();
		logger.log(Level.INFO, "GetFileServlet path="+path);

		Session s = DbUtils.getSession();
		try {
			CmsFileContent fc = MoodleRepository.getFileContent(s, path);
			if (fc==null) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "no file content for "+path);
				return;
			}
			String mimetype = fc.getCmsMimetype()!=null ? fc.getCmsMimetype().getMimetype() : "application/binary";
			String charset = fc.getCmsCeCharset()!=null ? fc.getCmsCeCharset().getCharacterSet() : null;
			resp.setContentType(mimetype+(charset!=null ? "; charset="+charset : ""));
			resp.setContentLength((int)fc.getContent().length());
			InputStream is = fc.getContent().getBinaryStream();
			OutputStream os = resp.getOutputStream();
			byte buf[] = new byte[200000];
			while (true) {
				int cnt = is.read(buf);
				if (cnt<0)
					break;
				os.write(buf, 0, cnt);				
			}
			os.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "getting file "+path, e);
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "getting file "+path+": "+e);
			return;
		}
		finally {
			s.close();
		}
	}
	
}
