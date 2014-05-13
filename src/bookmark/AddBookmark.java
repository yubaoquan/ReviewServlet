package bookmark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookmarkService;
import bean.Bookmark;

public class AddBookmark extends HttpServlet {

	private String SUCCESS_VIEW = "/ListBookmark";
	private String ERROR_VIEW = "/error";

	public void addBookmark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost(request, response);
		System.out.println("This is not doPost!");
		request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getParameter("url").trim();
		String title = request.getParameter("title").trim();
		String category = request.getParameter("category");
		String newCategory = request.getParameter("newCategory").trim();

		List<String> errors = new ArrayList<>();
		if (url == null || url.length() == 0) {
			errors.add("网址不能为空");
		}
		if (title == null || title.length() == 0) {
			errors.add("请输入网页标题");
		}
		if ((category == null || category.length() == 0) && (newCategory == null || newCategory.length() == 0)) {
			errors.add("请设置网页分类");
		}

		if (errors.size() != 0) {
			request.setAttribute("errors", errors);
			System.out.println(ERROR_VIEW);
			request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
		} else {
			if (newCategory != null && newCategory.length() != 0) {
				category = newCategory;
			} else {
				category = category.trim();
			}
			System.out.println("category: " + category);
			Bookmark bookmark = new Bookmark(url, title, category);
			BookmarkService bookmarkService = (BookmarkService) getServletContext().getAttribute("bookmarkService");
			bookmarkService.addBookmark(bookmark);
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		}
	}

	public void addBookmarkToFile(Bookmark bookmark, String fileName) {
		System.out.println("Add to file!");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File(fileName), true));
			String record = bookmark.getUrl() + "," + bookmark.getTitle() + "," + bookmark.getCategory() + "\r\n";
			System.out.println("append: " + record);
			writer.write(record);
		} catch (IOException ex) {
			Logger.getLogger(BookmarkInitializer.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				writer.close();
			} catch (IOException ex) {
				Logger.getLogger(BookmarkInitializer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		String success = getInitParameter("SUCCESS");
		if (success != null) {
			SUCCESS_VIEW = success;
		}
		String error = getInitParameter("ERROR");
		if (error != null) {
			ERROR_VIEW = error;
		}
	}

}
