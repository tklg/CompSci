package coin;
import villa7.Print;

public class CountFlips {
	
	private static Print p = new Print();
	private static Coin c = new Coin();
	private static BiasedCoin bc = new BiasedCoin();
	
	public static void main(String[] args) {
		final int NUM_FLIPS = 1000;
		int heads = 0,
			tails = 0;
		
		for (int co = 1; co <= NUM_FLIPS; co++) {
			c.flip();
			
			if(c.isHeads()) {
				heads++;
			} else {
				tails++;
			}
		}
		p.nl("The number of flips: " + NUM_FLIPS);
		p.nl("The number of heads: " + heads);
		p.nl("The number of tails: " + tails);
	}
}
