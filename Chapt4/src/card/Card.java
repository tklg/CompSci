package card;

/*
 * http://www.pagat.com/banking/blackjack.html <- rules
 * http://math.hws.edu/eck/cs124/javanotes4/c5/ex-5-5-answer.html <- example
 */

public class Card {
	
	private int suit,
				value;
	
	public Card(int suit, int value) { //generate a named card with the given suit and value
		this.suit = suit;
		this.value = value;
	}
	
	private String getSuit() {
		switch(suit) {
			case 0: return "Hearts";
			case 1: return "Spades";
			case 2: return "Diamonds";
			case 3: return "Clubs";
			default: return "<Unknown>";
		}
	}
	
	private String getValue() {
		switch(value) {
		case 0: return "0";
		case 1: return "Ace";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";
		default: return "<Unknown>";
		}
	}
	
	public String getCardName() {
		return getValue() + " of " + getSuit();
	}
	
}
