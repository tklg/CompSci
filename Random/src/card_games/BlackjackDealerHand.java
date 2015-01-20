package card_games;

public class BlackjackDealerHand extends BlackjackHand {

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
