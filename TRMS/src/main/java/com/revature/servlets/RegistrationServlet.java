package com.revature.servlets;
import java.io.IOException;
import com.revature.service.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for new user registration form.
 * @author Marcus Aderele
 *
 */

public class RegistrationServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	//HTML file names
	private final static String REG_HTML_NAME = "register.html";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
        request.getRequestDispatcher("register.html").forward(request, response);

	}
	
	//servlet to process user entered info and create a user in the database
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
		Credentials cred = new Credentials(arr);
		
		System.out.println("In doPost of Registration Servlet");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(fname + lname + email + password);
		response.setContentType("text/html");
		boolean successful = cred.register(fname, lname, email, password);
		
		if (successful == true)
		{
			response.sendRedirect(request.getContextPath() + "/login");
			//request.getRequestDispatcher("login.html").forward(request, response);
		}
	
		
	}


}
