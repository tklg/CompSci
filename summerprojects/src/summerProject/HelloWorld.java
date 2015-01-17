package summerProject;

public class HelloWorld {

	public static void main(String[] args) {
		/*
		 * 2.1 - Explain the following programming statement in terms of objects and the services they provide:
		 */
			System.out.println("I gotta be me!");
		
		/*
		 * System.out is an object that contains the methods print, println, and many others.
		 */
		
		/*
		 * 2.2 - What output is produced by the following code fragment? Explain.
		 */
			System.out.print("Here we go!");
			System.out.println("12345");
			System.out.print("Test this if you are not sure");
			System.out.print("Another.");
			System.out.println();
			System.out.println("All done.");
		
		/*
		 * Here we go!12345
		 * Test this if you are not sureAnother.
		 * All done.
		 * 
		 * Whenever print() is called, it prints the string.
		 * Whenever println() is called,  it prints the string and appends a \n to the end.
		 */
	}
	
}
