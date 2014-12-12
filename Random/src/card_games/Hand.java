/*
 * BlackjackHand.java
 * http://villa7.github.io
 *
 * Copyright (C) 2014-2014 Theodore Kluge
 */

package card_games;

import java.util.Random;

public class Hand {
	
	private Random rand = new Random();
	private static Deck deck;
	private static Deck usedDeck;

	public Hand() {

	}
	
	public int drawRandomCard() {
		
		double r1, r2;
		int rSuit, rValue;
		
		r1 = rand.nextDouble();
		r2 = rand.nextDouble();
		rSuit = (int)Math.round(r1 * 3);
		rValue = (int)Math.round(r2 * 12) + 1;
		
		int cVal = 0;
		//This should prevent any card with value 0 from being drawn
		do {
			cVal = getDrawnCard(rValue, rSuit);
		} while (cVal == 0);
		return cVal;
		
	}
	public int drawCard(int rValue, int rSuit) {
		deck.getCardsOfType(rValue, rSuit);
		return getDrawnCard(rValue, rSuit);
	}
	
	public void newDeck(int numCards) {
		deck = new Deck(numCards);
		deck.generateNewDeck();
	}
	public void newUsedDeck(int numCards) {
		usedDeck = new Deck(numCards);
		usedDeck.generateBlankDeck();
	}
	public static int getDrawnCard(int rValue, int rSuit) {
		deck.removeFromDeck(rValue, rSuit);
		usedDeck.addToDeck(rValue, rSuit);
		return rValue;
	}
	
}
