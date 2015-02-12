package login;

import functions.*;
import java.util.*;

public class Access {
	private static Print p = new Print();
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> userList, validUsers = new ArrayList<String>(), validPass = new ArrayList<String>();
	private static String dirName = "/userdata/",
				   fileName = "dataFile.txt",
				   tempFile = "tempFile.txt";
	private static TextDatabase db;
	private static boolean running = true,
						   logged = false;
	private static final String PASS_SALT = "SODIUMCHLORIDE";
	private static String commands = "[add | remove | login | logout | users | exit]";
	private static String userName = null;
	
	public Access() {
		//replace with the content of the main method to use this as a class to handle login/logout/add/rem from another class
		p.nl("Hello world!");
	}
	
	public static void main(String[] args) {
		db = new TextDatabase(dirName, fileName, tempFile);
		
		userList = db.readFile();
		
		while(running) {
			if (logged) {
				p.nl("[" + userName + "] Enter a command " + commands);
			} else {
				p.nl("Enter a command " + commands);
			}
			p.nl();
			String in = entCom().toLowerCase().trim();
			switch (in) {
			case "add":
				p.nl("Set a username:");
				String uName = sanit(entCom());
				if (!checkUser(uName)) {
					addUser(uName);
				} else {
					p.nl("That user already exists!");
					break;
				}
				p.nl();
				p.nl("Set a password:");
				String uPass = sanit(entCom());
				addPass(uPass);
				addAccessLevel(0);
				userList.add(uName + " ||| " + SHA2.hash(uPass, PASS_SALT) + " ||| " + 0);
				break;
			case "remove":
				p.nl("Enter a user to remove: ");
				String remName = sanit(entCom());
				p.nl("Enter that user's password:");
				String remPass = sanit(entCom());
				int acLvl = 0;
				if (removeUser(remName, remPass, acLvl)) {
					p.nl("Removed user: " + remName);
					userList = db.readFile(); //refresh user list
				} else {
					p.ne("Failed to remove user: " + remName);
				}
				break;
			case "login":
				if (!logged) {
					p.nl("Username: ");
					String name = entCom();
					if (checkUser(name)) {
						p.nl();
						p.nl("Password: ");
						String pass = entCom();
						if (checkPass(name, pass)) {
							userName = name;
							p.nl("Welcome, " + userName);
							logged = true;
						} else {
							p.ne("Incorrect password.");
						}
					} else {
						p.ne("Invalid username.");
					}
				} else {
					p.nl("You are already logged in.");
				}
				break;
			case "logout":
				p.nl("Good bye, " + userName);
				logged = false;
				userName = null;
				break;
			case "users":
			case "list":
				for (String user : userList) {
					p.nl(user.split("\\|\\|\\|")[0]);
				}
				break;
			case "exit":
			case "quit":
				running = false;
				break;
			case "refresh":
				userList = db.readFile();
				p.nl("Refreshed userList from file");
				break;
			default:
				p.nl("Enter a valid command");
			}
			p.nl();
		}
		
	}
	private static void addUser(String user) {
		db.writeFile(user, true, false);
	}
	private static void addPass(String pass) {
		db.writeFile(SHA2.hash(sanit(pass), PASS_SALT), false, true);
	}
	private static void addAccessLevel(int lvl) {
		db.writeFile(Integer.toString(lvl), false, true);
	}
	private static void setAccessLevel(String user, String pass) {
		
	}
	private static boolean removeUser(String user, String pass, int lvl) {
		if (checkUser(user)) {
			if (checkPass(user, pass)) {
				return db.removeLineFromFile(user + " ||| " + SHA2.hash(sanit(pass), PASS_SALT) + " ||| " + 0);
			} else {
				p.ne("Incorrect password.");
				return false;
			}
		} else {
			p.ne("User does not exist.");
			return false;
		}
	}
	private static boolean checkUser(String user) {
		validUsers.clear();
		for (int i = 1; i < userList.size(); i++) {
			validUsers.add(userList.get(i).split("\\|\\|\\|")[0].trim());
		}
		return validUsers.contains(sanit(user));
	}
	private static boolean checkPass(String user, String pass) {
		validUsers.clear();
		for (int i = 1; i < userList.size(); i++) {
			validUsers.add(userList.get(i).split("\\|\\|\\|")[0].trim());
		}
		validPass.clear();
		for (int i = 1; i < userList.size(); i++) {
			validPass.add(userList.get(i).split("\\|\\|\\|")[1].trim());
		}
		if (validPass.contains(SHA2.hash(sanit(pass), PASS_SALT))) {
			return validUsers.indexOf(user) == (validPass.indexOf(SHA2.hash(sanit(pass), PASS_SALT)));
		} else {
			return false;
		}
	}
	private static String entCom() {
		p.l("> ");
		return sc.next();
	}
	public boolean getState() {
		return logged;
	}
	private static String sanit(String s) {
		return s.replace("_", "")
				.replace(".", "")
				.replace("-", "")
				.replace(" ", "").trim();
	}
}
