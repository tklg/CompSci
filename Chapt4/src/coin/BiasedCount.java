package coin;
import villa7.Print;
import java.util.*;

public class BiasedCount {
	
	private static Print p = new Print();
	private static BiasedCoin bcFair = new BiasedCoin();
	private static BiasedCoin bc2;
	private static BiasedCoin bc3;
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		p.nl("Enter bias values for the 2 coins ([double 0.0-1.0] [double 0.0-1.0]):");
		p.nl("(Higher values are bias to heads)");
		double b1 = s.nextDouble(),
			   b2 = s.nextDouble();
		
		bc2 = new BiasedCoin(b1);
		bc3 = new BiasedCoin(b2);
		
		final int NUM_FLIPS = 100;
		int[] heads = {0,0,0},
			tails = {0,0,0};
		
		for (int co = 0; co < NUM_FLIPS; co++) {
			bcFair.flip();
			
			if (bcFair.isHeads()) {
				heads[0]++;
			} else {
				tails[0]++;
			}
		}
		for (int co = 0; co < NUM_FLIPS; co++) {
			bc2.flip();
			
			if (bc2.isHeads()) {
				heads[1]++;
			} else {
				tails[1]++;
			}
		}
		for (int co = 0; co < NUM_FLIPS; co++) {
			bc3.flip();
			
			if (bc3.isHeads()) {
				heads[2]++;
			} else {
				tails[2]++;
			}
		}
		p.nl("The number of flips on the fair coin was: " + NUM_FLIPS);
		p.nl("Heads: " + heads[0]);
		p.nl("Tails: " + tails[0]);
		p.nl("The number of flips on the first biased coin was: " + NUM_FLIPS);
		p.nl("Heads: " + heads[1]);
		p.nl("Tails: " + tails[1]);
		p.nl("The number of flips on the second biased coin was: " + NUM_FLIPS);
		p.nl("Heads: " + heads[2]);
		p.nl("Tails: " + tails[2]);
	}
}
