package bookmark;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookmarkService;
import bean.Bookmark;

/**
 * Servlet implementation class ListBookmark
 */
@WebServlet("/ListBookmark")
public class ListBookmark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBookmark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html;charset=UTF-8");
		
		BookmarkService bookmarkService = (BookmarkService) getServletContext().getAttribute("bookmarkService");
		Iterator<Bookmark> bookmarkIterator = bookmarkService.getBookmarks().iterator();
		PrintWriter out = response.getWriter();
		out.println("<table>");
		out.println("<tr><td style=\"background-color: rgb(51, 255, 255);\">分类</td></tr>");
		
		while (bookmarkIterator.hasNext()) {
			Bookmark bookmark = bookmarkIterator.next();
			out.println("<tr>");
			out.println("<td><a href=\"http://" + bookmark.getUrl() + "\">" + bookmark.getTitle() + "</a></td>");
			out.println("<td>" + bookmark.getCategory() + "</td>");
			
			out.println("</tr>");
			
		}
		out.println("</table>");
		out.println("<a href=\"" + request.getContextPath() + "/addBookmark.html\">添加书签</a>");
		
		String form = "<form action=\"bookmark\" method=\"post\">	网 址 http://<input name=\"url\" type=\"text\"></input><br> 		网页名称： <input name=\"title\" type=\"text\"></input><br>		 分 类：<select name=\"category\" size=\"4\" multiple=\"multiple\">			<option value=\"程序设计\">程序设计</option>			<option value=\"淫秽小说\">淫秽小说</option>			<option value=\"经典小说\">经典小说</option>			<option value=\"烹饪食谱\">烹饪食谱</option>		</select><br>		添加分类：<input name=\"newCategory\" type=\"text\"></input>		<input type=\"submit\" value=\"送出\"></input><br>	</form>";
		out.println(form);
		out.close();*/
		response.sendRedirect("page/listBookmark.jsp");
	}

}
