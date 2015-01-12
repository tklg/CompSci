package elevens;

import java.util.List;
import java.util.ArrayList;
import villa7.Print;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {
	private Print p = new Print();
	/**
	 * cards contains all the cards in the deck.
	 */
	private ArrayList<Card> deck;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		deck = new ArrayList<Card>();
		p.nl("Creating deck:");
		for (int i = 0; i < suits.length; i++) {
			for (int c = 0; c < ranks.length; c++) {
				deck.add(new Card(ranks[c], suits[i], values[c]));
				p.nl("Adding card: " + ranks[c] + " of " + suits[i]);
			}
		}
		size = deck.size();
		shuffle();
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		if (deck.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return deck.size();
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		Card temp = deck.get(size);
		p.nl("Temp card: " + deck.get(size).toString());
		size--;
		p.nl("removed card.");
		return temp;
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		p.nl("Tostring");
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int i = size - 1; i >= 0; i--) {
			rtn = rtn + deck.get(i);
			if (i != 0) {
				rtn = rtn + ", ";
			}
			if ((size - i) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int i = deck.size() - 1; i >= size; i--) {
			rtn = rtn + deck.get(i);
			if (i != size) {
				rtn = rtn + ", ";
			}
			if ((i - deck.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
