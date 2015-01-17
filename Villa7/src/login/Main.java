package login;

import functions.*;
import java.util.*;

public class Main {
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
			String in = entCom().toLowerCase();
			switch (in) {
			case "add":
				p.nl("Set a username:");
				String uName = entCom().replace("_", "")
						 .replace(".", "")
						 .replace("-", "")
						 .replace(" ", "");
				addUser(uName);
				p.nl();
				p.nl("Set a password:");
				String uPass = entCom().replace("_", "")
				 		 .replace(".", "")
				 		 .replace("-", "")
				 		 .replace(" ", "");
				addPass(uPass);
				userList.add(uName + " ||| " + SHA2.hash(uPass, PASS_SALT));
				p.nl();
				break;
			case "remove":
				p.nl("Enter a user to remove: ");
				String remName = entCom().replace("_", "")
						 .replace(".", "")
						 .replace("-", "")
						 .replace(" ", "");
				p.nl("Enter that user's password:");
				String remPass = entCom().replace("_", "")
						 .replace(".", "")
						 .replace("-", "")
						 .replace(" ", "");
				if (removeUser(remName, remPass)) {
					p.nl("Removed user: " + remName);
					userList = db.readFile(); //refresh user list
				} else {
					p.ne("Failed to remove user: " + remName);
				}
				break;
			case "login":
				p.nl("Username: ");
				String name = entCom();
				if (checkUser(name)) {
					p.nl();
					p.nl("Password: ");
					String pass = entCom();
					if (checkPass(pass)) {
						userName = name;
						p.nl("Welcome, " + userName);
						logged = true;
					} else {
						p.ne("Incorrect password.");
					}
				} else {
					p.ne("Invalid username.");
				}
				p.nl();
				break;
			case "logout":
				p.nl("Good bye, " + userName);
				logged = false;
				userName = null;
				p.nl();
				break;
			case "users":
				for (String user : userList) {
					p.nl(user.split("\\|\\|\\|")[0]);
				}
				p.nl();
				break;
			case "exit":
				running = false;
				break;
			default:
				p.nl("Enter a valid command");
				p.nl();
			}
		}
		
	}
	private static void addUser(String user) {
		db.writeFile(user, true, false);
	}
	private static void addPass(String pass) {
		db.writeFile(SHA2.hash(pass, PASS_SALT), false, true);
	}
	private static boolean removeUser(String user, String pass) {
		if (checkUser(user)) {
			if (checkPass(pass)) {
				return db.removeLineFromFile(user + " ||| " + SHA2.hash(pass, PASS_SALT));
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
		return validUsers.contains(user.replace("_", "")
				 .replace(".", "")
				 .replace("-", "")
				 .replace(" ", ""));
	}
	private static boolean checkPass(String pass) {
		validPass.clear();
		for (int i = 1; i < userList.size(); i++) {
			validPass.add(userList.get(i).split("\\|\\|\\|")[1].trim());
		}
		return validPass.contains(SHA2.hash(pass.replace("_", "")
				 .replace(".", "")
				 .replace("-", "")
				 .replace(" ", ""), PASS_SALT));
	}
	private static String entCom() {
		p.l("> ");
		return sc.next();
	}
}
