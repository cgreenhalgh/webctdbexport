/**
 * 
 */
package webctdbexport.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONException;
import org.json.JSONObject;

import webctdbexport.test.TestRepository;
import webctdbexport.utils.DbUtils;
import webctdbexport.utils.MoodleRepository;

/** get_listing servlet
 * 
 * @author cmg
 *
 */
public class GetListingServlet extends HttpServlet {
	static Logger logger = Logger.getLogger(GetListingServlet.class.getName());

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getPathInfo();
		String username = req.getParameter("username");
		String view = req.getParameter("view");
		boolean showFiles = !("links".equals(view));
		boolean showLinks = !("files".equals(view));
		logger.log(Level.INFO, "GetListingServlet path="+path+" username="+username);

		JSONObject listing = null;
		
		if (path.equals("/")) {
			if (username==null || username.length()==0) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "username not provided for root directory");
				return;
			}
			Session s = DbUtils.getSession();
			try {
				listing = MoodleRepository.getListingForUser(s, username, showFiles, showLinks);
			} catch (JSONException e) {
				logger.log(Level.SEVERE, "getting user listing", e);
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "getting user listing for "+username+": "+e);
				return;
			}
			finally {
				s.close();
			}
		}
		else {
			Session s = DbUtils.getSession();
			try {
				listing = MoodleRepository.getListingForPath(s, path, showFiles, showLinks);
			} catch (JSONException e) {
				logger.log(Level.SEVERE, "getting listing for "+path, e);
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "getting listing for "+path+": "+e);
				return;
			}
			finally {
				s.close();
			}
		}
		
		resp.setContentType("application/json; charset=UTF-8");
		Writer w = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream(), "UTF-8"));
		try {
			listing.write(w);
		} catch (JSONException e) {
			logger.log(Level.SEVERE, "Writing response", e);
		}
		w.close();
	}
	
}
