package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String[] types = request.getParameterValues("type");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>感谢</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("联系人： <a href=\"mailto:" + email + "\">" + user + "</a>");
		
		out.println("<br>喜爱的动物类型");
		out.println("<ul>");
		for (int i = 0; i < types.length; i ++) {
			out.println("<li>" + types[i] + "</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
}
