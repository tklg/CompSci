package coin;

import villa7.Print;

//********************************************************************
//Runs.java
//
//Finds the length of the longest run of heads in 100 flips of a coin.
//********************************************************************

public class Runs {
	
	private static Print p = new Print();
	private static Coin c = new Coin();

	public static void main (String[] args) {
		
		final int FLIPS = 100; // number of coin flips
		int currentRun = 0; // length of the current run of HEADS
		int maxRun = 0; // length of the maximum run so far
		// Create a coin object, call it c
		// Flip the coin FLIPS times
		for (int i = 0; i < FLIPS; i++) {
			c.flip();
			if (c.toString().equals("Heads")) { //coin is heads, so
				currentRun++; //add 1 to the current streak of heads
			} else { // if coin is tails, streak is over, so
				if (currentRun > maxRun) { //if current streak is greater then greatest streak, update maxRun
					maxRun = currentRun;
				}
				currentRun = 0; //set current streak to 0 because it ended
			}
		 }
		p.nl("The coin was flipped " + FLIPS + " times, and");
		p.nl("The longest run of HEADS was " + maxRun);
	}
}
