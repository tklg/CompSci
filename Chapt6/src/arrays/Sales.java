package arrays;
import villa7.*;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.Scanner;

public class Sales {
	private static NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public static void main(String[] args) {
		p.nl("Enter the number of salespeople");
		
		Scanner scan = new Scanner(System.in);
		int SALESPEOPLE = scan.nextInt();
		int[] sales = new int[SALESPEOPLE];
		int sum;
		for (int i = 0; i < sales.length; i++) {
			System.out.print("Enter sales for salesperson " + (i+1) + ": ");
			sales[i] = scan.nextInt();
		}
		System.out.println("\nSalesperson Sales");
		System.out.println("------------------");
		sum = 0;
		int gs = 0,
			ls = 0;
		int gsID = 0,
			lsID = 0;
		boolean first = true;
		for (int i = 0; i < sales.length; i++) {
			System.out.println((i+1) + ": " + sales[i]);
			sum += sales[i];
			if (sales[i] > gs) {
				gs = sales[i];
				gsID = i;
			}
		}
		for (int i = 0; i < sales.length; i++) {
			if ((sales[i] < gs && first) || sales[i] < ls) {
				ls = sales[i];
				lsID = i;
				first = false;
			}
		}
		System.out.println("\nTotal sales: " + sum);
		p.nl("Average sales: " + ((double)sum / sales.length));
		p.nl("Highest sale made by Salesperson " + (gsID+1) + " with " + fmt.format(gs));
		p.nl("Lowest sale made by Salesperson " + (lsID+1) + " with " + fmt.format(ls));
		
		p.nl();
		p.nl("Enter a minimum value");
		int minReq = scan.nextInt();
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] > minReq) {
				p.nl("Exceeded by salesperson " + (i+1) + " with " + fmt.format(sales[i]));
			}
		}
		
	}
}
