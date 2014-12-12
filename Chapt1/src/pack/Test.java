package pack;

public class Test {
	public static void main(String[] args) {
		System.out.println("An Emergency Broadcast");
	}
}

//1 - returns 'Source not found' because changing the class name without the filename is bad
//2 - no error - 'emergency' is part of a string and does not change the program execution
//3 - ClassLoader.defineClass complains because there is an error in the string function
//4 - same problem as 3
//5 - returns no errors, but does not run because man() is never called
//6 - System.out.bogus() is undefined
//7 - classloader complains because of incorrectly formatted line
//8 - class Test is never finished
