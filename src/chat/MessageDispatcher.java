package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import bean.User;

@WebServlet("/MessageDispatcher")
public class MessageDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessageDispatcher() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("root");
		Element onlineUsers = DocumentHelper.createElement("onlineUsers");
		Element offlineUsers = DocumentHelper.createElement("offlineUsers");
		Element messagesElement = DocumentHelper.createElement("messages");
		root.add(onlineUsers);
		root.add(offlineUsers);
		root.add(messagesElement);
		document.setRootElement(root);
		
		Set<User> users = (Set<User>)context.getAttribute("onlineUsers");
		if (users != null) {
			Iterator<User> iter = users.iterator();
			for (;iter.hasNext();) {
				User u = iter.next();
				Element user = DocumentHelper.createElement("user");
				user.setText(u.getUsername());
				onlineUsers.add(user);
			}
		}
		
		List<String> messages = (ArrayList<String>)context.getAttribute("messages");
		if (messages != null) {
			Iterator<String> msgIter = messages.iterator();
			for (;msgIter.hasNext();) {
				String msg = msgIter.next();
				Element msgElement = DocumentHelper.createElement("message");
				msgElement.setText(msg);
				messagesElement.add(msgElement);
			}
		}
		response.setCharacterEncoding( "UTF-8");
		response.setContentType("text/xml;");
		response.getWriter().write(document.asXML());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String decodedSentence = parseMessage(request);
		if (decodedSentence == null) {
			return;
		}
		List<String> messages = saveMessage(request, decodedSentence);
		sendMessagesToClient(response, messages);
		
	}

	private String parseMessage(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String sentence = request.getParameter("sentence");
		System.out.println("sentence: " + sentence);
		if (sentence == null || sentence.trim().length() == 0) {
			return null;
		}
		String decodedSentence = URLDecoder.decode(sentence, "UTF-8");
		System.out.println("decoded sentence: " + decodedSentence);
		return decodedSentence;
	}
	
	@SuppressWarnings("unchecked")
	private List<String> saveMessage(HttpServletRequest request, String decodedSentence) {
		ServletContext context = request.getServletContext();
		List<String> messages = (ArrayList<String>)context.getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList<String>();
		}
		messages.add(decodedSentence);
		if (messages.size() > 3) {
			messages.remove(0);
		}
		context.setAttribute("messages", messages);
		return messages;
	}

	private void sendMessagesToClient(HttpServletResponse response, List<String> messages) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		for (String string : messages) {
			out.println(string);
		}
		out.flush();
		out.close();
	}

}
