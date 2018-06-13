package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet of Login Servlet");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost of LoginServlet");
		// You can book mark this page and go to it because it is a Redirect
		// response.sendRedirect("home");
		System.out.println("User... " + request.getParameter("username"));
		System.out.println("Pass... " + request.getParameter("password"));
		try {
			Employee emp = new EmployeeDAOImpl().employeeLogin(request.getParameter("username"),
					request.getParameter("password"));
			if (emp.getId() != 0) {
				request.getRequestDispatcher("/home").forward(request, response);
			}
		} catch (SQLException e) {
			PrintWriter pw = response.getWriter();
			pw.print("Username and password doesn't match!");
			request.getRequestDispatcher("/login").include(request, response);
			pw.close();
		}
	}

}
