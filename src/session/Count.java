package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Count
 */
@WebServlet("/count")
public class Count extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Count() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int count = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("count") != null) {
			Integer c = (Integer) session.getAttribute("count");
			count = c.intValue() + 1;
		}
		session.setAttribute("count", new Integer(count));
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Count</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + "Servlet Count: " + count + "已登录</h1>");
		out.println("<a href=\"" + response.encodeURL("count") + "\">递增");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
