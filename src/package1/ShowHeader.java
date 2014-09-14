package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHeader extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet ShowHeader</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet ShowHeader at " + request.getContextPath() + "</h1>");
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String param = (String) e.nextElement();
			out.println(param + ": " + request.getHeader(param) + "<br>");
			
		}
		out.println("request uri: " + request.getRequestURI() + "<br>");
		out.println("request url: " + request.getRequestURL() + "<br>");
		out.println("</body>");
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
}
