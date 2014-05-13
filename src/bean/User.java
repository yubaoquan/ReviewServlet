package bean;

public class User {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(Object o) {
		if (o instanceof User) {
			User userB = (User)o;
			if (userB.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
