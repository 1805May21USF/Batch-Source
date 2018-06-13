
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OngetParameterValues extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		String[] values = req.getParameterValues("habits");
		pw.println("Selected Values...");
		for (int i = 0; i < values.length; i++) {
			pw.println("<li>" + values[i] + "</li>");
		}
		pw.close();
	}
}