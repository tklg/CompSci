package labs_ch3;
import java.util.*;
import villa7.Print;

public class IntWrapper {
	
	private static Print p = new Print();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		p.nl("---  IntWrapper  ---");
		p.nl("Enter an integer:");
		int _int = sc.nextInt();
		
		p.nl("Binary: " + Integer.toBinaryString(_int));
		p.nl("Octal: " + Integer.toOctalString(_int));
		p.nl("Hexadecimal: " + Integer.toHexString(_int).toUpperCase());
		p.nl();
		p.nl("Max value: " + Integer.MAX_VALUE);
		p.nl("Min value: " + Integer.MIN_VALUE);
		p.nl();
		
		p.nl("Enter 2 integers: ");
		String _i1 = sc.next(),
			   _i2 = sc.next();
		
		int _i3 = Integer.parseInt(_i1) + Integer.parseInt(_i2);
		p.nl("Total: " + _i3);	
		
	}
	
}
