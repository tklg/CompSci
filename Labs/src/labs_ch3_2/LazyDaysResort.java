package labs_ch3_2;

import java.util.*;

public class LazyDaysResort {
	
	private static Print p = new Print();
	private static Scanner sc = new Scanner(System.in);
	private static boolean running = true;
	
	public static void main(String[] args) {
		
		while(running) {
			p.nl("Welcome to LazyDays Resort. Please enter the current temperature: ");
			double temp = sc.nextDouble();
			
			p.l("We reccomend that you ");
			
			if (temp == -100) {
				p.ne("Terminating...");
				running = false;
			}
			
			if (temp > 95 || temp < 20) {
				p.nl("visit our shops!");
			} else if (temp >= 80) {
				p.nl("go swimming!");
			} else if (temp >= 60 && temp < 80) {
				p.nl("play tennis!");
			} else if (temp >= 40 && temp < 60) {
				p.nl("play golf!");
			} else if (temp < 40) {
				p.nl("go skiing!");
			} else {
				p.nl("enter a valid temperature!");
			}
		}
	}

}
