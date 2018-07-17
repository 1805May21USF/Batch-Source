package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.revature.beans.Reimbursements;
import com.revature.beans.User;
import com.revature.daoimpl.ReimbursementsDAOimpl;
import com.revature.service.GetInfo;

/**
 * Servlet implementation class DBUserServlet
 */
public class DBUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet");
		
		String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
		GetInfo gI = new GetInfo(arr);
		Gson gson = new Gson();

		HttpSession sesh = request.getSession(false);
		String email = (String) sesh.getAttribute("email");
		//String email = request.getParameter("email");
        //String email = "bruh@gmail.com";
		User user = gI.getUser(email);
		String result = gson.toJson(user);

		
		
		System.out.println(result);
		//response.setContentType("application/javascript");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		//pw.flush();
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
