package methodpractice;
import java.util.*;
import villa7.Print;
public class Pig {
	
	public static Print p = new Print();
	public static Scanner s = new Scanner(System.in);
	public static PairOfDice pair = new PairOfDice();
	public static boolean playerTurn = true,
						  computerTurn = false;
	public static int playerScore = 0,
					  computerScore = 0,
					  roundTotal = 0,
					  roundCur = 0;
	public static final int GOAL = 100;
	
	public static void main(String[] args) {
		p.ne("-=< GAME OF PIG >=-");
		p.nl();
		if (playPig()) {
			p.nl();
			p.nl("Player wins!");
		} else {
			p.nl();
			p.nl("Computer wins.");
		}
		
	}
	private static boolean playPig() {
		while(true) {
			playerTurn = true;
			computerTurn = true;
			roundTotal = 0;
			roundCur = 0;
			
			do {
				p.nl("Player's turn.");
				p.nl("Player has " + playerScore + " points. (" + roundCur + " points current round)");
				p.nl("ROLL? y/n");
				if (s.next().equalsIgnoreCase("Y")) {
					int r1 = pair.roll(1);
					int r2 = pair.roll(2);
					
					roundTotal += (r1 + r2);
					if (r1 == 1 && r2 == 1) {
						roundTotal = 0;
						roundCur = 0;
						playerScore = 0;
						playerTurn = false;
						p.nl("You rolled 2 1s.");
						p.nl("You lose all points.");
					} else if (r1 == 1 || r2 == 1) {
						roundTotal = 0;
						roundCur = 0;
						playerTurn = false;
						p.nl("You rolled a " + r1 + " and a " + r2);
						p.nl("You lose this turn's points.");
					} else {
						roundCur += roundTotal;
						p.nl("GAINED " + roundTotal + " points.");
					}
				} else {
					playerScore += roundCur;
					playerTurn = false;
				}
			} while (playerTurn);
			
			if (playerScore > GOAL) {
				return true;
			} else if (computerScore > GOAL) {
				return false;
			} else {
				p.nl();
			}
			
			roundTotal = 0;
			roundCur = 0;
			do {
				p.nl("Computer's turn.");
				p.nl("Computer has " + computerScore + " points.  (" + roundCur + " points current round)");
				
				if (roundTotal < 20) { //roll
					p.nl("Computer rolls.");
					int r1 = pair.roll(1);
					int r2 = pair.roll(2);
					
					roundTotal += (r1 + r2);
					if (r1 == 1 && r2 == 1) {
						roundTotal = 0;
						roundCur = 0;
						computerScore = 0;
						computerTurn = false;
						p.nl("Computer rolled 2 1s.");
						p.nl("Computer loses all points.");
					} else if (r1 == 1 || r2 == 1) {
						roundTotal = 0;
						roundCur = 0;
						computerTurn = false;
						p.nl("Computer rolled a " + r1 + " and a " + r2);
						p.nl("Computer loses this turn's points.");
					} else {
						roundCur += roundTotal;
						p.nl("Computer gains " + roundTotal + " points.");
					}
				} else {
					computerScore += roundCur;
					computerTurn = false;
				}
			} while (computerTurn);
			
			if (playerScore > GOAL) {
				return true;
			} else if (computerScore > GOAL) {
				return false;
			} else {
				p.nl();
			}
		}
	}	
}
