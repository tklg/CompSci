package pack;

import java.util.Scanner;

public class P117_2_3 {
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		System.out.println("Enter 2 flops plox");
		
		double a = sc.nextDouble(),
		b = sc.nextDouble();
		
		double sum = a + b,
		diff = Math.abs(a - b),
		prod = a * b;
		
		System.out.println("sum: " + sum);
		System.out.println("diff: " + diff);
		System.out.println("prod: " + prod);		
	}
}
