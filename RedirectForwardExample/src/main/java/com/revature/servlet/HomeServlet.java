package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("doGet Home Servlet");
		request.getRequestDispatcher("home.html")
				.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("doPost of Home Servlet");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<h3> RollTide</h3>");
		pw.close();
	}

}
