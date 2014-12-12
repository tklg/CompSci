/*
 * BlackjackDeck.java
 * http://villa7.github.io
 *
 * Copyright (C) 2014-2014 Theodore Kluge
 */

package card_games;

import java.util.ArrayList;
import villa7.Print;

public class Deck {
	
	private Print p = new Print();
	private int numCards = 52; //default to 4 of each card, minus 2 jokers - standard deck
	
	private static Card card;
	private static Card card_used;
	
	private ArrayList<String> cardList = new ArrayList<String>();
	
	private ArrayList<ArrayList<Integer>> cardListVal_suit = new ArrayList<ArrayList<Integer>>(); //multidimensionsal arraylist
	private ArrayList<Integer> cardListVal_value;
	
	private ArrayList<String> cardUsedList = new ArrayList<String>();
	
	private ArrayList<ArrayList<Integer>> cardUsedListVal_suit = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> cardUsedListVal_value;
	
	public Deck(int c) {
		numCards = c;
		while (numCards % 4 != 0) {
			numCards++;
		}
		//p.ne("Number of cards set to " + numCards);
	}
	public Deck() {
		//uses default of 52 cards
	}
	
	public void generateNewDeck() {
		for (int suit = 0; suit < 4; suit++) {
			cardListVal_value = new ArrayList<Integer>();
			
			for (int val = 1; val <= (numCards / 4); val++) {
				card = new Card(suit, val);
				cardList.add(card.getCardName());
				cardListVal_value.add(val); //add 1 of each value of card to a suit
			}
			cardListVal_suit.add(cardListVal_value); //1 - 13 add each group of 13 cards to the deck
		}
		return;
	}
	
	public void generateBlankDeck() {
		for (int suit = 0; suit < 4; suit++) {
			cardUsedListVal_value = new ArrayList<Integer>();
			
			for (int val = 1; val <= (numCards / 4); val++) {
				card_used = new Card(suit, 0);
				cardUsedList.add(card_used.getCardName());
				cardUsedListVal_value.add(0); //add 1 of each value of card to a suit
			}
			cardUsedListVal_suit.add(cardUsedListVal_value); //1 - 13 add each group of 13 cards to the deck
		}
	}
	
	public void getCardsInDeck() {
		for (String s : cardList) {
			p.nl(s);
		}
		return;
	}
	
	public void getUsedCardsInDeck() {
		for (String s : cardUsedList) {
			p.nl(s);
		}
		return;
	}
	
	public void getCardsOfType(int val, int suit) {
		p.nl(cardListVal_suit.get(suit).get(val - 1).toString());
		return;
	}
	public void getUsedCardsOfType(int val, int suit) {
		p.nl(cardUsedListVal_suit.get(suit).get(val - 1).toString());
		return;
	}
	
	public void removeFromDeck(int val, int suit) {
		cardListVal_suit.get(suit).set(val - 1, 0); //set the value of the card at the selected value in the selected suit to 0, removing it from the deck
		Card tCard = new Card(suit, val);
		//p.nl("Removed card: " + tCard.getCardName());
		return;
	}
	
	public void addToDeck(int val, int suit) {
		cardUsedListVal_suit.get(suit).set(val - 1, val);
		Card tCard = new Card(suit, val);
		//p.nl("Added card '" + tCard.getCardName() + "' to used cards");
		return;
	}
	
	public void getRandomCard(int suit, int val) {
		cardListVal_suit.get(suit).get(val);
		return;
	}
	
	public void getAllCardsFromArrayList() {
		p.nl(cardListVal_suit.toString());
		return;
	}
	public void getAllUsedCardsFromArrayList() {
		p.nl(cardUsedListVal_suit.toString());
		return;
	}
}
