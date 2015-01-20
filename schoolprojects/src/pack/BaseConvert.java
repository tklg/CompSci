package pack;

import java.util.Scanner;
import villa7.Print;

public class BaseConvert {
	
	private static Scanner sc = new Scanner(System.in);
	private static Print p = new Print();
	private static double[] rem = {0,0,0,0};
	private static double[] quot = {0,0,0,0};

	public static void main(String[] args) {
		
		p.nl("Enter a base10 number and a number from 2 - 9");
		
		final int LIMIT = 4;
		
		int num = sc.nextInt();
		int base = sc.nextInt();
		double maxNumber = Math.pow(base,  LIMIT) - 1;
		
		rem[0] = num % base;
		quot[0] = num / base;
		
		for (int i = 1; i < LIMIT; i++) {
			rem[i] = quot[i-1] % base;
			quot[i] = quot[i-1] / base;
		}
		
			p.l("Number: " );
		for (int x = LIMIT - 1; x >= 0; x--) {
			p.il((int)rem[x]);
		}
	
		p.nl("\nMax number: " + maxNumber);
	}

}
