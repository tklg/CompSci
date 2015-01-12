package labs_ch3_2;

import java.text.NumberFormat;
import java.util.Scanner;

public class Salary {
	
	private static Print p = new Print();
	private static Scanner sc;
	
	public static void main(String[] args) {
		
		double curSalary = 0,
			   raise = 0,
			   newSalary = 0;
		String rating;
		
		sc = new Scanner(System.in);
		
		p.l("Enter the current salary: ");
		
		curSalary = sc.nextDouble();
		
		do {
			
			p.l("Enter the performance rating (Excellent, good, or poor): ");
			
			rating = sc.next().toLowerCase();
			
			switch(rating) {
				case "excellent":
					raise = curSalary * 0.06;
					break;
				case "good":
					raise = curSalary * 0.04;
					break;
				case "poor":
					raise = curSalary * 0.015;
					break;
				default:
					p.nl("Invalid rating. Enter [Excellent | Good | Poor]");
					break;
			}
			
			/*if (rating.equals("Excellent")) {
				raise = curSalary * 0.06;
			} else if (rating.equals("good")) {
				raise = curSalary * 0.04;
			} else if (rating.equals("poor")) {
				raise = curSalary * 0.015;
			} else {
				p.nl("Invalid rating. Enter Excellent | Good | Poor");
			}*/
		} while (!rating.equals("excellent") && !rating.equals("good") && !rating.equals("poor"));
		
		newSalary = curSalary + raise;
		NumberFormat money = NumberFormat.getCurrencyInstance();
		p.nl();
		p.nl("Current salary: " + money.format(curSalary));
		p.nl("Amount of your raise: " + money.format(raise));
		p.nl("Your new salary: " + money.format(newSalary));
	}

}
