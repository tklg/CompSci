package labs_ch5;
import java.util.*;

public class GregorianCalendar {
	
	private static Scanner sc = new Scanner(System.in);
	private static Print p = new Print();
	private static boolean running = true;
	
	public static void main(String[] args) {
		while(running) {
			p.nl("Enter a year after 1582:");
			int year = sc.nextInt();
			
			if (year == 0) {
				p.ne("Terminating...");
				running = false;
			} else if (year < 1582) {
				p.ne("Invalid year entered, Gregorian calendar was not in effect yet.");
			} else if (year % 4 == 0) {
				if (year % 100 == 0 && year % 400 != 0) {
					p.nl(year + " is not a leap year.");
				} else {
					p.nl(year + " is a leap year.");
				}
			} else {
				p.nl(year + " is not a leap year.");
			}
		}
		
	}

}
