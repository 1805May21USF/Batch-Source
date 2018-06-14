package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.revature.beans.User;
import com.revature.service.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet for Dashboard.
 * @author Marcus Aderele
 *
 */

public class DashboardServlet extends HttpServlet{
	
//	String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
//	Credentials cred = new Credentials(arr);
//	Gson gson = new Gson();
//	JSONObject json = new JSONObject();
//	GetInfo gI = new GetInfo(arr);
//	
	private static final long serialVersionUID = 2L;
	
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doGet of Dashboard Servlet");
        request.getRequestDispatcher("dashboard.html").forward(request, response);
//		String email = request.getParameter("email");
//		User user = gI.getUser(email);
//		String result = gson.toJson(user);
		//response.getWriter().write(result);
		//PrintWriter pw = response.getWriter().write(result);
		//pw.flush();
	}
	
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		System.out.println("In doPost of Dashboard Servlet");
		
	}
	
	

}
