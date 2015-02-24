package elevens_1_3;
import villa7.Print;
public class DeckTester {

	private static Print p = new Print();
	private static Deck[] d = new Deck[3];
	private static String[] ranks = {
		"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"
	};
	private static String[] suits = {
		"Spades",
		"Clubs",
		"Hearts",
		"Diamonds"
	};
	private static int[] pointVal = {
		2,3,4,5,6,7,8,9,10,10,10,10,11
	};
	
	public static void main(String[] args) {
		for (int i = 0; i < d.length; i++) {
			d[i] = new Deck(ranks, suits, pointVal);
			p.nl("Size of deck " + i + ": " + d[i].size());
			p.nl("Deck " + (i+1) + ": " + d[i].toString());
			d[i].deal();
			p.nl("Deck " + (i+1) + ": " + d[i].toString());
			p.nl("Deck " + (i+1) + " isEmpty: " + d[i].isEmpty());
		}
		
		for (Deck deck : d) {
			//foreach
		}
	}
}
