package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Reimbursements;
import com.revature.beans.User;
import com.revature.daoimpl.ReimbursementsDAOimpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.service.GetInfo;

/**
 * Servlet implementation class SuperDislayDBServlet
 */
public class SuperDislayDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesh = request.getSession(false);
		String email = (String) sesh.getAttribute("email");
		System.out.println("DisplayServlet");

		String[] arr = getServletContext().getInitParameter("dbInfo").split(",");

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

			//Credentials cred = new Credentials(arr);
			GetInfo gI = new GetInfo(arr);
			Gson gson = new Gson();

			User user = gI.getUser(email);

			ReimbursementsDAOimpl rdi = new ReimbursementsDAOimpl(arr);
			List<Reimbursements> rList = new ArrayList<Reimbursements>();
			try {
				rList = rdi.retrieveWorkerReimbursements(user.getUserId());
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
				
				
				
				String emailtemp = "";
				try {
					emailtemp = rdi.retrieveUserEmail(r.getUserId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				User u = gI.getUser(emailtemp);
				String name = u.getFirstName() + " " + u.getLastName();
				Timestamp ts = r.getStartDate();
				String info = "{\"name\":"+ "\"" + name +"\"" + ","
						+ "\"rid\":" + r.getrId() + ","
						+  "\"amount\":" + r.getAmount() + ","
						+ "\"startdate\":" +"\"" + ts.toString().replace(":00.0", "") + "\""
						+  "}";
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
