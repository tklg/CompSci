package card_games;

public class BlackjackDeck {
	
	private BlackjackCard[] deck;
	private int numUsedCards;
	
	public BlackjackDeck() {
		deck = new BlackjackCard[52];
		int cc = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				deck[cc] = new BlackjackCard(value, suit);
				cc++;
			}
		}
		numUsedCards = 0;
	}
	
	public BlackjackCard drawCard() {
		if (numUsedCards == 52) { //if the deck is untouched
			shuffle();
		}
		numUsedCards++;
		return deck[numUsedCards - 1];
	}
	
	public int remainingCards() {
		return 52 - numUsedCards;
	}
	
	public void shuffle() {
		for (int i = 51; i > 0; i--) {
			int rand = (int)Math.random() * (i + 1);
			BlackjackCard tempCard = deck[i]; //set a temporary card
			deck[i] = deck[rand]; //move some card around in the deck
			deck[rand] = tempCard; //set the original moved card to the temp card
		}
	}

}
