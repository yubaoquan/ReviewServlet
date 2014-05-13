package bookmark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import service.BookmarkService;
import bean.Bookmark;

public class BookmarkInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("This is listener!");
		ServletContext context = sce.getServletContext();
		String bookmarkFile = context.getInitParameter("BOOKMARK");
		System.out.println(bookmarkFile);
		BookmarkService bookmarkService = new BookmarkService(this.getClass().getClassLoader().
				getResource("../.." + bookmarkFile).
				getFile());
		context.setAttribute("bookmarkService", bookmarkService);

	}

}
