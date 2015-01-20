package lock;
import villa7.*;
import java.util.*;

public class Unlocker {

	private static Print p = new Print();
	private static Scanner sc = new Scanner(System.in);
	
	static int numUsers = 1;
	static ArrayList<String> userList = new ArrayList<String>();
	//static ArrayList<Coin> coinList = new ArrayList<Coin>();
	static boolean running = true, using = true;
	
	public static void main(String[] args) {
		//p.nl("Enter number of users: ");
		//numUsers = sc.nextInt();
		Coin coin[] = new Coin[numUsers];
		p.nl("--= USER SETUP =--");
		for (int i = 0; i < numUsers; i++) {
			p.nl("Set username:");
			userList.add(sc.next());
			p.nl("Set password:");
			coin[i] = new Coin(sc.next());
		}
		
		p.nl("--= USER LOGIN =--");
		while(running) {
			p.nl("Enter username:");
			String input = sc.next();
			if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
				running = false;
			}
			if (userList.contains(input)) {
				int ind = userList.indexOf(input);
				if (coin[ind].locked()) {
					p.nl("Enter password:");
					if (coin[ind].unlock(sc.next())) {
						if (!coin[ind].locked()) {
							coin[ind].flip();
							p.nl("Flipping coin:");
							p.nl(coin[ind].toString());
							while(using) {
								String next = sc.next();
								if (next.equals("logout")) {
									coin[ind].lock();
									using = false;
								} else {
									p.nl("enter options: [logout]");
								}
							}
						}
					} else {
						p.ne("Incorrect password.");
					}
				}
			} else {
				p.ne("Invalid username.");
			}
		}
	}
	
	public void addUser() {
		
	}
	
}
