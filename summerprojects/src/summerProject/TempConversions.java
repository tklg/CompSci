package summerProject;

import java.text.*;

public class TempConversions {
	
	public static void main(String[] args) {

		int temp = 20;
		double tempC = 0;
		DecimalFormat df = new DecimalFormat("#.##");
		
		for (int i = 1; i <= 20; i++) {
			tempC = ((5.0 / 9.0) * (temp - 32));
			print("At " + temp + "°F, it is " + df.format(tempC) + "°C.");
			temp += 3;
		}
	}
	
	public static void print(String m) { //laziness
		System.out.println(m);
	}
}
