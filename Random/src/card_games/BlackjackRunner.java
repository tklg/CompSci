/*
 * BlackjackRunner.java
 * http://villa7.github.io
 *
 * Copyright (C) 2014-2014 Theodore Kluge
 */

package card_games;

import java.util.*;
import villa7.Print;

public class BlackjackRunner {
	
	private static double ver = 1.0;
	
	private static int suit;
	private static int value;
	private static int computerCard, userCard;
	private static Print p = new Print();
	private static Hand hand = new Hand();
	private static Scanner s = new Scanner(System.in);

	private static boolean playerTurn = true;
	private static boolean running = true;
	private static boolean isFirstTurn = true;
	
	private static int userTotal = 0,
		computerTotal = 0;
	
	public static void main(String[] args) {
		
		p.nl("BlackjackGame v" + ver);
		p.nl();
		
		while (running) {
			hand.newDeck(52);
			hand.newUsedDeck(52);
			
			if (playBlackjack()) {
				p.nl("You win.");
				p.nl("You had a value of " + userTotal);
				p.nl("The dealer had a value of " + computerTotal);
			} else {
				p.nl("You lose.");
				p.nl("You had a value of " + userTotal);
				//p.nl("The dealer had a value of " + computerTotal);
			}
			p.nbsp(3);
		}
	}
	
	private static boolean playBlackjack() {
		userTotal = 0;
		computerTotal = 0;
		playerTurn = true;
		
		//draw 2 cards to start
		userTotal += hand.drawRandomCard();
		userTotal += hand.drawRandomCard();
		computerTotal += hand.drawRandomCard();
		p.nl("The dealer has a " + computerTotal + " and an unknown card.");
		computerTotal += hand.drawRandomCard();
		
		while(true) {
			
			while (playerTurn) {
				//p.nl("Your cards add up to " + userTotal);
				
				while (userTotal > 21 && isFirstTurn) {
					//playerTurn = false;
					//p.nl("Sorry, redrawing...");
					userTotal = 0;
					userTotal += hand.drawRandomCard();
					userTotal += hand.drawRandomCard();
				}
				p.nl("Your cards add up to " + userTotal);
				
				p.nl("Enter an action: [hit | stand]");
				String userAction = s.next();
				
				if(userAction.toLowerCase().equals("quit")) {
					running = false;
					return false;
				}
				
				if (userAction.equalsIgnoreCase("hit")) {
					userCard = hand.drawRandomCard();
					p.nl("You hit.");
					p.nl("You drew a " + userCard);
					userTotal += userCard;
					p.nl("Your total is " + userTotal);
					if (userTotal > 21) {
						return false;
					}
				} else if (userAction.equalsIgnoreCase("stand")) {
					p.nl("You stand.");
					playerTurn = false;
				} else {
					p.nl("Please enter a valid action. [hit | stand]");
				}
				isFirstTurn = false;
			}
			
			//Dumb AI
			if (computerTotal == 21) { //if computer has 21, he wins
				if (userTotal == 21) { //unless player also has 21
					return true;
				} else {
					return false;
				}
			} else if (computerTotal < 17) {
				computerCard = hand.drawRandomCard();
				p.nl("Dealer drew " + computerCard);
				computerTotal += computerCard;
			} else {
				p.nl("Dealer stands.");
				if (userTotal > computerTotal) {
					return true;
				} else {
					return false;
				}
			}
			
			//win logic
			if (computerTotal > 21) {
				return true;
			}	
		}
	}
}
