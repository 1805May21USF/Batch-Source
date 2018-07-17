package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.UserDAOImpl;



/**
 * Servlet for Dashboard.
 * @author Marcus Aderele
 *
 */

public class DashboardServlet extends HttpServlet{
	



	
	private static final long serialVersionUID = 3L;
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doGet of Dashboard Servlet");
		
		String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
		
		HttpSession sesh = request.getSession(false);
		//String email = (String) sesh.getAttribute("email");
    	if(sesh == null) {
    		sesh = request.getSession();
    	}
		
    	if(sesh.getAttribute("email") == null) {
    		PrintWriter pw = response.getWriter();
    		pw.write("<script>alert('You're not logged in');</script>");
    		response.sendRedirect(request.getContextPath() + "/login");
    	} else {
    		
    		UserDAOImpl udi = new UserDAOImpl(arr);
			int userType = 1;
			try {
				userType = udi.getUserTitle((String) sesh.getAttribute("email"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(userType == 1) {
				request.getRequestDispatcher("dashboard.html").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/superdash");
			}
    		
    	}
		
		
	}
	
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doPost of Dashboard Servlet");
		
	}
	
	

}
