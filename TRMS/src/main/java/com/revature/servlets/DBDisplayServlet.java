package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.revature.beans.Reimbursements;
import com.revature.beans.User;
import com.revature.daoimpl.ReimbursementsDAOimpl;
import com.revature.service.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.revature.beans.User;

/**
 * Servlet implementation class DBDisplayServlet
 */
public class DBDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesh = request.getSession(false);
		String email = (String) sesh.getAttribute("email");
		System.out.println("DisplayServlet");

		String[] arr = getServletContext().getInitParameter("dbInfo").split(",");
		//Credentials cred = new Credentials(arr);
		GetInfo gI = new GetInfo(arr);
		Gson gson = new Gson();

		//String email = "bruh@gmail.com";
		System.out.println(email);
		User user = gI.getUser(email);

		ReimbursementsDAOimpl rdi = new ReimbursementsDAOimpl(arr);
		List<Reimbursements> rList = new ArrayList<Reimbursements>();
		try {
			rList = rdi.retrieveUserReimbursements(user.getUserId());
			for(Reimbursements r : rList) {
				System.out.println(r.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String jsonMan = "[";

		for(int i = 0; i < rList.size(); i++ ) {
			Reimbursements r = rList.get(i);
			String coverage = "";
			try {
				coverage  = rdi.getCoverageType(r.getcId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Timestamp ts = r.getStartDate();
			String info = "{\"rid\":" + r.getrId() + ","
					+ "\"type\":" + "\""+ coverage + "\"" + "," 
					+ "\"startdate\":" +"\"" + ts.toString().replace(":00.0", "") + "\"" + ","
					+ "\"amount\":" + r.getAmount() + ","
					+ "\"status\":" + "\"" + r.getStatus() + "\"" + "}";
			if((i+1) != rList.size()) {
				info += ",";
			}
			jsonMan += info;
		}
		jsonMan += "]";
		System.out.println(jsonMan);
		String resultArray = gson.toJson(rList);		
		PrintWriter pw = response.getWriter();
		pw.write(jsonMan);
		//pw.flush();
		response.flushBuffer();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
