package main.java;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Viewer")
public class Viewer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	String message2;
	public Viewer() {
		message2 = "Does this thing work?";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		// Setup the displayer
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//LET'S CODE!
		out.println("<html>");
		out.println("<FONT COLOR='green'>");
		out.println("<body background='"+ request.getContextPath() + "/image/FDR.jpg'>");
		out.print("<p>" + request.getContextPath() + "</p>");
		for(int i = 0; i<7; i++){
			out.print("<p>");
			out.print("message");
			out.print("</p>");
		}

		out.println("<h1>" + message2 + "</h1>");
		out.println("</body>");
		out.println("</FONT>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
