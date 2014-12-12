package labs_ch2;


//FILE: Trace.java
// PURPOSE: An exercise in tracing a program and understanding
// assignment statements and expressions.
import java.util.Scanner;

public class Trace {
	public static double[] a;
	
	public static void main (String[] args) {
		int one, two, three;
		double what;
		Scanner scan = new Scanner(System.in);
		System.out.print ("Enter two integers: ");
		one = scan.nextInt();
		two = scan.nextInt();
		a[0]=one;
		a[1]=two;
		
		System.out.print("Enter a floating point number: ");
		what = scan.nextDouble();
		a[2]=what;
		three = 4 * one + 5 * two;
		a[3]=three;
		two = 2 * one;
		a[4]=two;
		System.out.println ("one " + two + ":" + three);
		one = 46 / 5 * 2 + 19 % 4;
		a[5]=one;
		three = one + two;
		a[6]=three;
		what = (what + 2.5) / 2;
		a[7]=what;
		System.out.println (what + " is what!");
		System.out.println(a);
	}
}
