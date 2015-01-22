package login;

public class User {
	
	private String name,
				   pass;
	private int accessLevel;
	private String div = TextDatabase.divider;
	
	public User(String name, String pass, int accessLevel) {
		this.name = name;
		this.pass = pass;
		this.accessLevel = accessLevel;
	}
	public User(String name, String pass, String accessLevel) {
		this.name = name;
		this.pass = pass;
		try {
			this.accessLevel = Integer.parseInt(accessLevel);
		} catch (Exception e) {
			System.err.println("Error: " + e);
			this.accessLevel = 0;
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setAccess(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void remove() {
		this.name = null;
		this.pass = null;
		this.accessLevel = -1;
	}
	public String toString() {
		return name + div + pass + div + accessLevel; 
	}
}
