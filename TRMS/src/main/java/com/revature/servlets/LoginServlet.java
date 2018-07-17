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

		HttpSession check = request.getSession(false);
		if(check == null) {
			check = request.getSession();
		}
		if(check.getAttribute("email") != null) {
			System.out.println("Redirecting");
			UserDAOImpl udi = new UserDAOImpl(arr);
			int userType = 1;
			try {
				userType = udi.getUserTitle((String) check.getAttribute("email"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(userType == 1) {
				response.sendRedirect(request.getContextPath() + "/dashboard");
			} else {
				response.sendRedirect(request.getContextPath() + "/superdash");
			}
			
		} else {
			System.out.println("Logged out");
			boolean successful = true;
			try {
				successful = cred.loginVerification(email, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String loginButt = request.getParameter("login");
			System.out.println("Button 1 - " + loginButt);
			if(loginButt != null) 
			{
				if(successful == true) 
				{
					/*HttpSession sesh = request.getSession(false);
                	String email1 = (String) sesh.getAttribute("email");*/
					HttpSession sesh= request.getSession(true);
					sesh.setAttribute("email", email);
					
					UserDAOImpl udi = new UserDAOImpl(arr);
					int userType = 1;
					try {
						userType = udi.getUserTitle((String) sesh.getAttribute("email"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(userType == 1) {
						response.sendRedirect(request.getContextPath() + "/dashboard");
					} else {
						response.sendRedirect(request.getContextPath() + "/superdash");
					}
				} 
				else 
				{
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.write("<script type=\"text/javascript\" >" + 
							"alert('Username or Password is incorrect')" + 
							"</script>");
					pw.flush();
					request.getRequestDispatcher("/login.html").include(request, response);
				}
			}
			String signupButt = request.getParameter("signup");
			System.out.println("Button 2 -" + signupButt);
			if(signupButt != null) {
				response.sendRedirect(request.getContextPath() + "/register");
			}
		}
	}
}
