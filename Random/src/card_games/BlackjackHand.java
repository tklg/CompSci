package card_games;

import java.util.Vector;

public class BlackjackHand {

	private Vector<BlackjackCard> hand; //the hand containing cards
	
	public BlackjackHand() {
		hand = new Vector<BlackjackCard>();
	}
	
	public void clearHand() {
		hand.removeAllElements();
	}
	
	public void addCard(BlackjackCard card) {
		if (card != null) {
			hand.addElement(card);
		}
	}
	
	public void removeCard(int pos) {
		if (pos >= 0 && pos < hand.size()) {
			hand.removeElementAt(pos);
		}
	}
	
	public void removeCard(BlackjackCard card) {
		hand.removeElement(card);
	}
	
	public int getNumCards() {
		return hand.size();
	}
	
	public BlackjackCard getCard(int pos) {
		if (pos >= 0 && pos < hand.size()) {
			return (BlackjackCard)hand.elementAt(pos);
		} else {
			return null;
		}
	}
	
	public void sortBySuit() {
		Vector<BlackjackCard> tempHand = new Vector<BlackjackCard>();
		while (hand.size() > 0) {
	         int pos = 0;  // Position of minimal card.
	         BlackjackCard c = (BlackjackCard)hand.elementAt(0);
	         for (int i = 1; i < hand.size(); i++) {
	        	 BlackjackCard c1 = (BlackjackCard)hand.elementAt(i);
	            if ( c1.getSuit() < c.getSuit() ||
	                    (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
	                pos = i;
	                c = c1;
	            }
	         }
	         hand.removeElementAt(pos);
	         tempHand.addElement(c);
	      }
	      hand = tempHand;
	}
	
	public void sortByValue() {
        // Sorts the cards in the hand so that cards of the same value are
        // grouped together.  Cards with the same value are sorted by suit.
        // Note that aces are considered to have the lowest value, 1.
     Vector<BlackjackCard> tempHand = new Vector<BlackjackCard>();
     while (hand.size() > 0) {
        int pos = 0;  // Position of minimal card.
        BlackjackCard c = (BlackjackCard)hand.elementAt(0);  // Minumal card.
        for (int i = 1; i < hand.size(); i++) {
        	BlackjackCard c1 = (BlackjackCard)hand.elementAt(i);
           if ( c1.getValue() < c.getValue() ||
                   (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
               pos = i;
               c = c1;
           }
        }
        hand.removeElementAt(pos);
        tempHand.addElement(c);
     }
     hand = tempHand;
  }
	
	public int getBlackjackValue() {
		int val = 0;
		int cards = getNumCards();
		boolean isAce = false;
		
		for (int i = 0; i < cards; i++) {
			BlackjackCard card;
			int cVal;
			
			card = getCard(i);
			cVal = card.getValue();
			
			if (cVal > 10) {
                cVal = 10;   // For jack/queen/king
            }
            if (cVal == 1) {
                isAce = true; //there is an ace
            }
            val += cVal;
		}
		
		if ( isAce == true  &&  val + 10 <= 21 )
            val += 10;

        return val;    
	}
	
}
