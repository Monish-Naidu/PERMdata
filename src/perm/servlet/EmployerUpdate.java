package perm.servlet;

import perm.dao.*;
import perm.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/employerupdate")
public class EmployerUpdate extends HttpServlet {
	
	protected EmployerDao EmployerDao;
	
	@Override
	public void init() throws ServletException {
		EmployerDao = BlogUsersDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing message
		// s.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String employerName = req.getParameter("employername");
        if (employerName == null || employerName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		Employer employer = EmployerDao.getEmployerByName(employerName);
        		if(employer == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		req.setAttribute("agentDao", employer);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/EmployerUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String name = req.getParameter("employername");
        if (name == null || name.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {

        		Employer employer = EmployerDao.getEmployerByName(name);
        		if(employer == null) {
        			messages.put("success", "UserName does not exist. No update to perform.");
        		} else {

					int numOfEmployee = Integer.parseInt(req.getParameter("NumOfEmployee"));


					try {

						employer = employerDao.updateEmployer(employer,numOfEmployee);
						messages.put("success", "Successfully created " + name);
					} catch (SQLException e) {
						e.printStackTrace();
						throw new IOException(e);
					}
        		}
        		req.setAttribute("agentDao", employer);

        }
        
        req.getRequestDispatcher("/EmployerUpdate.jsp").forward(req, resp);
    }
}
