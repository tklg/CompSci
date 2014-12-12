package labs_ch3;
import java.util.*;
import villa7.Print;

public class Cards {
	
	private static Print p = new Print();
	
	private enum Rank {ace, two, three, four, five, six, seven, eight, nine, ten, jack, queen, king};
	
	static Rank highCard = Rank.ace,
		 faceCard = Rank.king,
		 card1 = Rank.two,
		 card2 = Rank.three;
	
	static int card1Val = card1.ordinal() + 1,
			   card2Val = card2.ordinal() + 1;
		
	
	public static void main(String[] args) {
		p.nl("A blackjack hand: ace and " + faceCard);
		p.nl();
		p.nl("A two card hand: " + card1 + " + " + card2);
		p.nl("Hand value: " + (card1Val + card2Val));
	}
}
