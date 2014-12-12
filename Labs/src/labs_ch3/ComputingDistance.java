package labs_ch3;

//*************************************************************

//Distance.java

//

//Computes the distance between two points

//*************************************************************

import java.util.Scanner;

import static java.lang.Math.*;

public class ComputingDistance {

	public static void main (String[] args) {
	
		double x1, y1, x2, y2; // coordinates of two points
		
		double distance; // distance between the points
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print ("Enter the coordinates of the first point (put a space between them): ");
		x1 = scan.nextDouble();
		y1 = scan.nextDouble();
		
		System.out.print ("Enter the coordinates of the second point: ");
		x2 = scan.nextDouble();
		y2 = scan.nextDouble();
		
		//Compute the distance (x1 – x2)^2 + (y1 – y2)^2
		
		distance = sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));
		
		//Print out the answer
		
		System.out.println("The distance is " + distance);
	
	}

}
