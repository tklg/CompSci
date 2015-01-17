package pack;

//*******************************************************************
//PlusTest.java
//
//Demonstrate the different behaviors of the + operator
//*******************************************************************
public class PlusTest {
	public static void main (String[] args) {
		System.out.println ("This is a long string that is the " +
		"concatenation of two shorter strings.");
		System.out.println ("The first computer was invented about " + 55 +
		" years ago.");
		System.out.println ("8 plus 5 is " + 8 + 5);
		System.out.println ("8 plus 5 is " + (8 + 5));
		System.out.println (8 + 5 + " equals 8 plus 5.");
		
		System.out.println();
		System.out.println("also");
		System.out.println("Ten robins plus " + 1 + 3 + " canaries is " + (10 + 13) + " birds.");
		
	}
	
	/*
	 * 3rd line: The 8 and 5 were read as strings because the first operand was a string
	 * 4th line: the 8 and 5 were read first because they were in (), :. they were read as integers
	 * 5th line: The 8 and 5 were the first 2 operands, :. they were read as integers
	 * 
	 * To fix the spacing issue in the 2nd sentence, add spaces where spaces need to go
	 */
}

