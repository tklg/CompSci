package elevens;
import villa7.Print;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {
	public static Print p = new Print();
	public static Card c1,c2,c3;
	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		c1 = new Card("Six", "Hearts", 6);
		c2 = new Card("Seven", "Spades", 7);
		c3 = new Card("Six", "Hearts", 6);
		
		p.nl("rank c1: " + c1.rank());
		p.nl("suit c1: " + c1.suit());
		p.nl("val c1: " + c1.pointValue());
		p.nl("rank c2: " + c2.rank());
		p.nl("suit c2: " + c2.suit());
		p.nl("val c2: " + c2.pointValue());
		p.nl("rank c3: " + c3.rank());
		p.nl("suit c3: " + c3.suit());
		p.nl("val c3: " + c3.pointValue());
		
		p.nl("c1 == c3? " + c1.matches(c3));
		p.nl("c1 == c2? " + c1.matches(c2));
	}
}
