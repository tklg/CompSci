package pack;

import java.util.Scanner;

public class P117_2_2 {
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		System.out.println("Enter 3 ints plox");
		int a = sc.nextInt(),
			b = sc.nextInt(),
			c = sc.nextInt();
		
		double avg = (a + b + c) / 3;
		System.out.println("Average is " + avg);
	}
}
