package stuff;
import villa7.Print;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
	
	private static Print p = new Print();
	private static Random rand = new Random();
	private static Scanner sc = new Scanner(System.in);
	
	private static String[] rps = {
			"rock",
			"paper",
			"scissor",
			"r",
			"p",
			"s"
	};
	private static boolean running = true;
	private static String ent;
	
	public static void main(String[] args) {
		while (running) {
			do {
				p.nl("Enter [rock | paper | scissor] or [quit]");
				p.l("> ");
				ent = sc.nextLine().toLowerCase();
				if (ent.equals("quit") || ent.equals("q")) {
					p.ne("Terminating...");
					running = false;
				}
			} while (!(ent.equals(rps[0]) || ent.equals(rps[1]) || ent.equals(rps[2]) || ent.equals(rps[3]) || ent.equals(rps[4]) || ent.equals(rps[5])) && running);
			
			switch(ent) { //set ent to the full name so the output doesnt print stuff like "r beats s"
				case "r": 
					ent = "rock";
					break;
				case "p":
					ent = "paper";
					break;
				case "s":
					ent = "scissor";
					break;
				default:
					break;
			}
			
			if (!running) {
				break;
			}
			//generate random rps
			double r = Math.round(rand.nextDouble() * 2); //0 - 2
			String comp = rps[(int)r];
			
			p.nl("Computer rolled " + comp);
			getOutcome(ent, comp);
		}
	}
	
	private static void getOutcome(String uRPS, String cRPS) {
		if (uRPS.equals(cRPS)) {
			p.nl(uRPS + " is equal to " + cRPS + ". Redo!");
		} else if (uRPS.equals("rock")) {
			if (cRPS.equals("scissor")) {
				p.nl("Player wins! (rock beats scissor)");
			} else {
				p.nl("Comptuer wins! (paper beats rock)");
			}
		} else {
			if (getNumVal(uRPS) > getNumVal(cRPS)) { //user > computer
				p.nl("Player wins! (" + uRPS + " beats " + cRPS + ")");
			} else {
				p.nl("Computer wins! (" + cRPS + " beats " + uRPS + ")");
			}
		}
		p.nl();
	}
	
	private static int getNumVal(String rps) {
		switch(rps) {
		case "rock":
			return 0;
		case "paper":
			return 1;
		case "scissor":
			return 2;
		default:
			p.e("getNumVal fail");
			return 3;
		}
	}
}
