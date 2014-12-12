package pack;

//*******************************************************************//
//					  File Name: Countdown.java						 //
//					   Creator: Theodore Kluge						 //
//	Purpose: Demonstrates the difference between print and println	 //
//*******************************************************************//

public class Countdown {

	public static void main(String[] args) {
	
		pr("Three... ", false);
		pr("Two... ", false);
		pr("One... ", false);
		pr("Zero... ", false);
		
		pr("Liftoff!", true);
		pr("Houston, we have a problem.", true);
		
	}
	
	private static void pr(String a, Boolean b) {
		if (b) {
			System.out.println(a);			
		} else {
			System.out.print(a);
		}
	}
}
