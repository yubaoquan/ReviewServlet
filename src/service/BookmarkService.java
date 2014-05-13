package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import bean.Bookmark;

public class BookmarkService {

	private String filename;
	private List<Bookmark> bookmarks;
	private List<String> categories;

	public BookmarkService(String filename) {
		this.filename = filename;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			bookmarks = new LinkedList<>();
			categories = new LinkedList<>();
			String input = null;
			while ((input = reader.readLine()) != null) {
				String[] tokens = input.split(",");
				System.out.println("BookmarkService: " + tokens[0] + ", " + tokens[1] + "," + tokens[2]);
				Bookmark bookmark = new Bookmark(tokens[0], tokens[1], tokens[2]);
				bookmarks.add(bookmark);
				if (!categories.contains(tokens[2])) {
					categories.add(tokens[2]);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public List<String> getCategories() {
		return categories;
	}

	public List<Bookmark> addBookmark(Bookmark bookmark) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, true), "UTF-8"));
			writer.write(bookmark.getUrl() + "," + bookmark.getTitle() + "," + bookmark.getCategory() + System.getProperty("line.separator"));
			this.getBookmarks().add(bookmark);
			if (!categories.contains(bookmark.getCategory())) {
				categories.add(bookmark.getCategory());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return this.getBookmarks();
	}
}
