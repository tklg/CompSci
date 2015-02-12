package arrays;

import villa7.*;

public class Multidimensional {

	private static int[][] array = new int[3][10];
	
	public static void main(String[] args) {
		for (int[] a : array) {
			for (int b : array[0]) {
				b = (Math.round(Math.random() * 100));
			}
		}
		
		p.nl(arr.format(array));		
	}
}
