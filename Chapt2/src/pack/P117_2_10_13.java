package pack;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Random;

import villa7.Print;

public class P117_2_10_13 {

	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		Print p = new Print();
		DecimalFormat df3 = new DecimalFormat("#.###");
		//DecimalFormat df2 = new DecimalFormat("#.##");
		NumberFormat df2 = NumberFormat.getCurrencyInstance();
		boolean canRun = true;
		
		while(canRun) {
			p.l("\nEnter question number (1 - 4): "); //2.10 - 2.13 (1 - 4)
			int qNum = sc.nextInt();
			p.nl("");
			
			switch(qNum) {
				case 1: //2.10
					p.l("Enter lengths of 3 sides of triangle ABC, separated by spaces: ");
					double a = Math.abs(sc.nextDouble()),
						   b = Math.abs(sc.nextDouble()),
						   c = Math.abs(sc.nextDouble());
					double perim = (a + b + c) / 2;
					
					double areaTri = Math.sqrt(perim * (perim - a) * (perim - b) * (perim - c));
					
					p.nl("Area of triangle: " + df3.format(areaTri));
					break;
					
				case 2: //2.11
					p.l("Enter the odometer readings from the beginning of the trip:");
					double odoA = sc.nextDouble();
					p.l("Enter the odometer reading from the end of the trip: ");
					double odoB = sc.nextDouble(),
						   totalMiles = odoB - odoA;
					if (totalMiles < 0) {
						p.nl("Are you really sure you went negative distance?");
					}
					p.l("Enter the gallons of gas used: ");
					double gasUsed = sc.nextDouble();
					double mpg = gasUsed / totalMiles;
					p.nl("Miles per gallon: " + mpg);
					break;
					
				case 3: //2.12
					double valQ = 0.25,
						   valD = 0.10,
						   valN = 0.05,
						   valP = 0.01;
					p.l("Enter number of quarters: ");
					int numQ = sc.nextInt();
					p.l("Dimes? ");
					int numD = sc.nextInt();
					p.l("Nickels? ");
					int numN = sc.nextInt();
					p.l("Pennies? ");
					int numP = sc.nextInt();
					
					double totalVal = ((valQ * numQ) + (valD * numD) + (valN * numN) + (valP * numP));
					
					p.nl("The total value is " + df2.format(totalVal));
					break;
				
				case 4: //2.13
					p.nl("Generating phone number: ");
					Random rand = new Random();

					int firstNum_1 = (int)Math.round(rand.nextDouble() * 6 + 1),
						secondNum_1 = (int)Math.round(rand.nextDouble() * 7),
						thirdNum_1 = (int)Math.round(rand.nextDouble() * 7);
					int fstNum_2 = (int)Math.round(rand.nextDouble() * 742);
					int fstNum_3 = (int)Math.round(rand.nextDouble() * 9999);

					if (fstNum_2 < 100) {
						fstNum_2 += 100;
					}
					if (fstNum_3 < 100) {
						fstNum_3 += 100;
					}
					p.nl("(" + firstNum_1 + secondNum_1 + thirdNum_1 + ")-" + fstNum_2 + "-"+ fstNum_3);
					break;
					
				case 0: //End program
					p.l("Terminating...");
					canRun = false;
					break;
					
				default: //user entered a number >4 or <0
					p.l("Invalid problem number, please enter a value from 1 - 4.\nEnter 0 to exit.\n");
					break;
			}
		}
	}
}
