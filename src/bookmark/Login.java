package bookmark;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "BookmarkLogin", urlPatterns = { "/BookmarkLogin" }, initParams = { @WebInitParam(name = "username", value = "admin"), @WebInitParam(name = "password", value = "") })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	/**
	 * @return 
	 * @throws ServletException 
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() throws ServletException {
		super.init();
		username = getInitParameter("username");
		password = getInitParameter("password");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (username == null || password == null) {
			response.sendRedirect("login.html");
			return;
		}
		if (username.equals(request.getParameter("username")) && password.equals(request.getParameter("password"))) {
			request.getSession().setAttribute("login", username);
			response.sendRedirect("ListBookmark");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
