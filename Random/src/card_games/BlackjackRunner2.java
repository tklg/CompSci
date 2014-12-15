/*
 * BlackjackRunner2.java
 * http://villa7.github.io
 *
 * Copyright (C) 2014-2014 Theodore Kluge
 */

package card_games;

import java.util.*;
import villa7.Print;

public class BlackjackRunner2 {
	
	private static double ver = 1.1;
	
	private static Bjp player[];
	private static Bjd dealer;

	private static final int MIN_PLAYERS = 1, MAX_PLAYERS = 6;
	private static int computerCard, userCard, aiCard;
	private static int numPlayers = 0;
	private static Print p = new Print();
	private static Hand hand = new Hand();
	private static Scanner s = new Scanner(System.in);
	//private static String[] players;
	private static ArrayList<String> pWin = new ArrayList<String>();
	private static ArrayList<String> winners = new ArrayList<String>();

	private static boolean playerTurn = true, computerTurn = true;
	private static boolean running = true;
	/*private static boolean[] isFirstTurn, isAIFT;*/
	
	/*private static int userTotal[],
					   aiTotal[],
					   computerTotal;*/
	
	public static void main(String[] args) {
		
		p.nl("BlackjackGame v" + ver);
		p.nl();
		do {
			p.nl("Number of players ("+MIN_PLAYERS+" - "+MAX_PLAYERS+"):");
			numPlayers = s.nextInt();
		} while (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS);

		//players = new String[numPlayers];
		player = new Bjp[numPlayers];

		for (int i = 0; i < player.length; i++) {
			p.nl("Enter name of player " + (i + 1));
			String n = s.next();
			//p.nl(i);
			if (n.equalsIgnoreCase("AI") || n.equalsIgnoreCase("BOT")) {
				for (int c = i; c < player.length; c++) {
					p.nl("Creating AI: 'AI:" + (c + 1) + "'");
					player[c] = new Bjp("AI:" + (c + 1), true);
				}
				i = player.length;
			} else {
				player[i] = new Bjp(n);
			}
		}
		
		while (running) {
			hand.newDeck(52);
			hand.newUsedDeck(52);
			dealer = new Bjd("Dealer");
			
			if (playBlackjack()) {
				int tmp = 0;
				for (int i = 0; i < player.length; i++) {
					if (player[i].isWinner()) {
						if (player[i].getTotal() >= tmp) {
							if (player[i].getTotal() == tmp) {
								winners.add(player[i].getName());
								tmp = player[i].getTotal();
							} else {
								winners.clear();
								winners.add(player[i].getName());
								tmp = player[i].getTotal();
							}
						}
					}
				}
				p.nl();
				if (winners.size() > 1)
					p.nl("Overall winners:");
				else
					p.nl("Overall winner:");
				
				for (String s : winners) {
					p.nl(s);
				}
				
			} else {
				p.nl("Dealer wins.");
			}
			p.nbsp(3);
			break; //remove when reset all values for new game
		}
	}
	
	private static boolean playBlackjack() {
		for (int i = 0; i < numPlayers; i++) {
			//p.nl("Set playerFirstTurn of player " + (i+1) + " (" + player[i].getName() + ") to true.");
			player[i].setFirstTurn(true);
		}
		
		//draw 2 cards to start
		for (int i = 0; i < player.length; i++) {	
			player[i].addTotal(hand.drawRandomCard());
			player[i].addTotal(hand.drawRandomCard());
		}

		dealer.addTotal(hand.drawRandomCard());
		p.nl("The dealer has a " + dealer.getTotal() + " and an unknown card.");
		dealer.addTotal(hand.drawRandomCard());
		
		while(true) {
			
			for (int i = 0; i < numPlayers; i++) {
				p.nbsp(1);
				p.nl("Player " + (i + 1) + " (" + player[i].getName() + "'s) turn:");
				playerTurn = true;
				while (playerTurn) {
					if (!player[i].isAI()) { //player is a human
						while (player[i].getTotal() > 21 && player[i].isFirstTurn()) {
							//playerTurn = false;
							//p.nl("Sorry, redrawing...");
							player[i].setTotal(0);
							player[i].addTotal(hand.drawRandomCard());
							player[i].addTotal(hand.drawRandomCard());
						}
						p.nl("Your cards add up to " + player[i].getTotal());
						
						p.nl("Enter an action: [hit | stand]");
						String userAction = player[i].getAction();
						
						if(userAction.equalsIgnoreCase("quit")) {
							running = false;
							return false;
						} else if (userAction.equalsIgnoreCase("hit")) {
							userCard = hand.drawRandomCard();
							p.nl("You hit.");
							p.nl("You drew a " + userCard);
							player[i].addTotal(userCard);
							p.nl("Your total is " + player[i].getTotal());
							if (player[i].getTotal() > 21) {
								p.nl("You lose.");
								playerTurn = false;
							}
						} else if (userAction.equalsIgnoreCase("stand")) {
							p.nl("You stand.");
							playerTurn = false;
						} else {
							p.nl("Please enter a valid action. [hit | stand]");
						}
						player[i].setFirstTurn(false);
					} else { //player is an AI
						while (player[i].getTotal() > 21 && player[i].isFirstTurn()) {
							player[i].setTotal(0);
							player[i].addTotal(hand.drawRandomCard());
							player[i].addTotal(hand.drawRandomCard());
						}
						if (player[i].getTotal() < 17) { //AI uses the dealer's logic
							aiCard = hand.drawRandomCard();
							p.nl("AI #" + (i+1) + " drew " + aiCard);
							player[i].addTotal(aiCard);
							p.nl("AI #" + (i+1) + " has a total of " + player[i].getTotal());
							if (player[i].getTotal() > 21) {
								p.nl("AI #" + (i+1) + " loses.");
								playerTurn = false;
							}
						} else {
							p.nl("AI #" + (i+1) + " stands.");
							playerTurn = false;
						}
						player[i].setFirstTurn(false);
					}
				}
			}
			
			while (computerTurn) {
				p.nbsp(1);
				if (dealer.getTotal() == 21) { //if dealer has 21, he wins
					for (int i = 0; i < player.length; i++) {
						if (player[i].getTotal() == 21) { //unless player also has 21
							addWinner(i);
						}
					}
					if (pWin.size() > 0) { //if there is at least one winner
						computerTurn = false;
						p.nl("There are " + pWin.size() + " potential winners.");
						return true;
					} else {
						return false;
					}
				} else if (dealer.getTotal() < 17) { //if dealer has <17, he draws more
					computerCard = hand.drawRandomCard();
					p.nl("Dealer drew " + computerCard);
					dealer.addTotal(computerCard);
					p.nl("Dealer has " + dealer.getTotal());
				} else {
					if (dealer.getTotal() > 21) {
						p.nl("Dealer loses.");
						computerTurn = false;
						for (int i = 0; i < player.length; i++) {
							if (player[i].getTotal() < 22) {
								addWinner(i);
							}
						}
						if (pWin.size() > 0) {
							p.nl("There are " + pWin.size() + " potential winners.");
						}
						return true;
					} else {
						p.nl("Dealer stands."); //if dealer has >17 he stands
						computerTurn = false;
						for (int i = 0; i < player.length; i++) {
							if (player[i].getTotal() > dealer.getTotal() && player[i].getTotal() < 22) {
								addWinner(i);
							}
						}
						if (pWin.size() > 0) {
							p.nl("There are " + pWin.size() + " potential winners.");
							return true;
						} else {
							return false;
						}
					}
				}
			}
			
			//win logic
			if (dealer.getTotal() > 21) { //if dealer has >21 he loses
				p.nl("Dealer loses");
				for (int i = 0; i < player.length; i++) {
					if (player[i].getTotal() < 22)
						addWinner(i);
				}
				if (pWin.size() > 0) {
					p.nl("There are " + pWin.size() + " potential winners.");
				}
				return true;
			} else {
				return false;
			}
		}
	}
	private static void addWinner(int i) {
		p.nl("Checking total of p" + (i+1) + " (" + player[i].getName() + "): " + player[i].getTotal());
		pWin.add(player[i].getName());
		player[i].isWinner(true);
	}
}
