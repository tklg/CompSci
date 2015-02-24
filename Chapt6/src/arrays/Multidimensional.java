package arrays;

import villa7.*;

public class Multidimensional {

	private static int[][] array = new int[3][10];
	
	public static void main(String[] args) {
		for (int i = 0; i < array.length; i++) {
			for (int c = 0; c < array[i].length; c++) {
				array[i][c] = (int)(Math.round(Math.random() * 100));
			}
		}
		
		p.nl(arr.format(array));		
	}
}
