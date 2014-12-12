package pack;

import java.text.DecimalFormat;
import java.util.Scanner;
import villa7.Print;

public class P117_2_5_9 {
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		Print p = new Print();
		DecimalFormat df = new DecimalFormat("#.####");
		boolean canRun = true;
		
		while(canRun) {
			p.l("\nEnter question number (int): "); //2.5 - 2.9 (1 - 5)
			int qNum = sc.nextInt();
			//double qNum = sc.nextDouble();
			//qNum = Math.round(qNum);
			//qNum = (int)qNum;
			p.l("\n");
			
			switch(qNum) {
				case 1: //2.5
					p.l("Enter miles to convert: ");
					final double KM_CONV = 1.60935;
					int miles = sc.nextInt();
					p.nl("Km: " + (miles * KM_CONV));
					break;
					
				case 2: //2.6
					p.l("Enter time value: (h m s): ");
					int h = sc.nextInt(),
						m = sc.nextInt(),
						s = sc.nextInt();
					s += (m * 60);
					s += (h * Math.pow(60, 2));
					p.nl("Time in seconds: " + s);
					break;
					
				case 3: //2.7
					p.l("Enter time value: (s): ");
					int sec = sc.nextInt();
					int min = 0,
						hou = 0;
					
					min = sec / 60;
					sec -= min * 60;
					
					hou = min / 60;
					min -= hou * 60;
					
					/*min = sec % 60;
					hou = min % 12;
					ffff*/
					
					p.nl(hou + ":" + min + ":" + sec);
					break;
					
				case 4: //2.8
					p.l("Enter a point (x y): ");
					double x = sc.nextDouble(),
						   y = sc.nextDouble();
					p.l("Enter another point (x y): ");
					double x2 = sc.nextDouble(),
						   y2 = sc.nextDouble();
					double dist = Math.abs(Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2)));
					p.nl("Distance: " + dist);
					break;
					
				case 5: //2.9
					p.l("Give radius of sphere: ");
					double rad = sc.nextDouble();
					double vol, surfaceArea;
					
					vol = (4/3) * Math.PI * Math.pow(rad, 3);
					surfaceArea = 4 * Math.PI * Math.pow(rad, 2);
					
					p.nl("Volume: " + df.format(vol) + " units");
					p.nl("Surface Area: " + df.format(surfaceArea) + " units");
					break;
					
				case 0: //End program
					p.l("Terminating...");
					canRun = false;
					break;
					
				default: //user entered a number >5 or <0
					p.l("Invalid problem number, please enter a value from 1 - 5.\nEnter 0 to exit.\n");
					break;
			}
		}
	}
}
