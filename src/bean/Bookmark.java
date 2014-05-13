package bean;

public class Bookmark {

	private String url, title, category;

	public Bookmark(String url, String pageName, String category) {
		this.url = url;
		this.title = pageName;
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String pageName) {
		this.title = pageName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
