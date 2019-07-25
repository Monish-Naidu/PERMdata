package perm.servlet;

import perm.dao.SOCSystemDao;
import perm.model.SOCSystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * FindUsers is the primary entry point into the application.
 * 
 * Note the logic for doGet() and doPost() are almost identical. However, there is a difference:
 * doGet() handles the http GET request. This method is called when you put in the /findusers
 * URL in the browser.
 * doPost() handles the http POST request. This method is called after you click the submit button.
 * 
 * To run:
 * 1. Run the SQL script to recreate your database schema: http://goo.gl/86a11H.
 * 2. Insert test data. You can do this by running blog.tools.Inserter (right click,
 *    Run As > JavaApplication.
 *    Notice that this is similar to Runner.java in our JDBC example.
 * 3. Run the Tomcat server at localhost.
 * 4. Point your browser to http://localhost:8080/BlogApplication/findusers.
 */
@WebServlet("/findsocsystem")
public class FindSocSystem extends HttpServlet {
	
	protected SOCSystemDao socSystemDao;
	
	@Override
	public void init() throws ServletException {
		socSystemDao = SOCSystemDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<SOCSystem> socSystems = new ArrayList<SOCSystem>();
        
        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String prevailingWageSocTitle = req.getParameter("prevailingwagesoctitle");
        if (prevailingWageSocTitle == null || prevailingWageSocTitle.trim().isEmpty()) {
            messages.put("success", "Please enter a valid soc title.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	socSystems = socSystemDao.getSOCSystemFromSOCTitle(prevailingWageSocTitle);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + prevailingWageSocTitle);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousSocCode", prevailingWageSocTitle);
        }
        req.setAttribute("socSystems", socSystems);
        
        req.getRequestDispatcher("/FindSocSystem.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<SOCSystem> socSystems = new ArrayList<SOCSystem>();
        
        // Retrieve and validate name.
        // firstname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String socTitle = req.getParameter("prevailingwagesoctitle");
        if (socTitle == null || socTitle.trim().isEmpty()) {
            messages.put("success", "Please enter a soc Title.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
        		socSystems = socSystemDao.getSOCSystemFromSOCTitle(socTitle);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + socTitle);
        }
        req.setAttribute("socSystems", socSystems);
        
        req.getRequestDispatcher("/FindSocSystems.jsp").forward(req, resp);
    }
}