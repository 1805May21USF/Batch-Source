package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.service.GetInfo;

/**
 * Servlet implementation class SuperDashServlet
 */
public class SuperDashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
		//String email = (String) sesh.getAttribute("email");
    	if(sesh == null) {
    		sesh = request.getSession();
    	}
    	
    	String[] arr = getServletContext().getInitParameter("dbInfo").split(",");

    	
    	UserDAOImpl ui = new UserDAOImpl(arr);
    	
  
    	
    	
    	if(sesh.getAttribute("email") == null) {
    		response.sendRedirect(request.getContextPath() + "/login");
    	} else  {
    		int temp = 1;
    		try {
				temp = ui.getUserTitle((String) sesh.getAttribute("email"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		if(temp == 1) {
    			response.sendRedirect(request.getContextPath() + "/dashboard");
    		} else {
    			request.getRequestDispatcher("superdash.html").forward(request, response);
    		}
    	}
    	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
