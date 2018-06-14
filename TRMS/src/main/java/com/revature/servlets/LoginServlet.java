package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.Credentials;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
		//HTML file names
		private final static String LOGIN_HTML_NAME = "login.html";

		protected void doGet(HttpServletRequest request,
				HttpServletResponse response)
						throws ServletException, IOException {
			System.out.println("doGet of LoginServlet");
			request.getRequestDispatcher("login.html").forward(request, response);
		}

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response)
						throws ServletException, IOException {
			String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
			Credentials cred = new Credentials(arr);
			System.out.println("doPost of LoginServlet");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			

			boolean successful = true;
			try {
				successful = cred.loginVerification(email, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request.getRequestDispatcher("/dashboard.html").forward(request, response);
			response.setContentType("text/html");
			//response.sendRedirect(request.getContextPath() + "/dashboard");
			
			
			 if(successful == true) {
				 response.setContentType("text/html");
                 //request.getRequestDispatcher("dashboard.html").forward(request, response);
             }			
			String loginButt = request.getParameter("login");
			System.out.println(loginButt);
			if(loginButt != null) {
                if(successful == true) {
                	response.sendRedirect(request.getContextPath() + "/dashboard");
                } else {
                	PrintWriter pw = response.getWriter();
                	pw.println("<script>alert('User or Password is incorrect')</script>");
                	request.getRequestDispatcher("/login.html").forward(request, response);
                }
            }
            String signupButt = request.getParameter("signup");
            System.out.println(signupButt);
            if(signupButt != null) {
            	response.sendRedirect(request.getContextPath() + "/register");
                //request.getRequestDispatcher("signup.html").forward(request, response);
            }
			
			
		}

}
