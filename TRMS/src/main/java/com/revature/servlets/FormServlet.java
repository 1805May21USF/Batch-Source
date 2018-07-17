package com.revature.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.GetInfo;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		HttpSession check = request.getSession(false);
		if(check == null) {
			check = request.getSession();
		}
		if(check.getAttribute("email") != null) {
			request.getRequestDispatcher("form.html").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
        


	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
		
		System.out.println("In doPost of form Servlet");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String amt = request.getParameter("amt");
		String loc = request.getParameter("loc");
		String desc = request.getParameter("desc");
		String typeOfEvent = request.getParameter("type");
		System.out.println(typeOfEvent);
		String justification = request.getParameter("work-just");
		System.out.println(amt);
		double amount = Double.parseDouble(amt);
		
		date += ":" + time;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
		//System.out.println(date);
		Date d = null;
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp ts = new Timestamp(d.getTime());
		GetInfo gI = new GetInfo(arr);
		gI.submitForm(loc, email, amount, ts, desc, typeOfEvent, justification);
	


	}

}