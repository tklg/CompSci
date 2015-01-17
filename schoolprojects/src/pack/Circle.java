package pack;

import java.util.Scanner;

//**********************************************************
//Circle.java
//
//Print the area of a circle with two different radii
//**********************************************************

public class Circle {
	public static final double PI = Math.PI;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int radius = 0;
		System.out.println("give radius plox");
		radius = scan.nextInt();
		
		double[] circ = {getCircumference(radius), 0};
		double[] area = {PI * Math.pow(radius, 2), 0};
		System.out.println("The area of a circle with radius " + radius + " is " + area[0]);
		System.out.println("And the circumference is " + circ[0]);
		radius += radius;
		circ[1] = getCircumference(radius);
		area[1] = PI * Math.pow(radius, 2);
		System.out.println("The area of a circle with radius " + radius + " is " + area[1]);
		System.out.println("And the circumference is " + circ[1]);
		double areaRatio = area[1] / area[0];
		double circRatio = circ[1] / circ[0];
		System.out.println(areaRatio);
		System.out.println(circRatio);
		
	}
	
	private static double getCircumference(double rad) {
		return (2 * PI * rad);
	}
}

