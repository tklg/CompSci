package labs_ch3;
import villa7.Print;

import java.util.*;

public class Dice {
	
	private static Print p = new Print();
	private static Scanner sc = new Scanner(System.in);
	private static Random rand = new Random();
	private static ArrayList<Integer> diceVal = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		while (true) {
			p.nl("Enter number of dice to roll: ");
			int numDice = sc.nextInt();
			if (numDice == 0) {
				break;
			}
			int total = 0;
			p.nl("Rolling " + numDice + " dice...");
			
			for (int i = 0; i < numDice; i++) {
				diceVal.add((int)Math.round(rand.nextDouble() * 5 + 1));
			}
			
			for (Integer i : diceVal) {
				p.l(i + " ");
				total += i;
			}
			p.nl();
			p.nl("The total is " + total);
			p.nl();
			diceVal.clear();
		}
	}

}
