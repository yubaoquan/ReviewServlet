package chat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

/**
 * Servlet implementation class ChatLogin
 */
@WebServlet("/chat/ChatLogin")
public class ChatLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatLogin() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println("username: " + username);
		User user = new User();
		user.setUsername(username);
		ServletContext context = request.getServletContext();
		Set<User> onlineUsers = (HashSet<User>)context.getAttribute("onlineUsers");
		if (onlineUsers == null) {
			onlineUsers = new HashSet<User>();
		}
		onlineUsers.add(user);
		context.setAttribute("onlineUsers", onlineUsers);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		response.sendRedirect("../chat/mainRoom.jsp");
	}

}
