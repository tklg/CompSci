package arrays;
import java.util.*;
import villa7.*;
public class Guests {
	public static void main(String[] args) {
		bla();
		blaInt();
		String[] guests = {
				"Paul",
				"Wendy",
				"Jared",
				"Eric",
				"Ayame",
				"Ian",
				"Isobel",
				"Hakem"
		};
		String name;
		boolean found = false;
		p.nl("Enter a name:");
		name = new Scanner(System.in).nextLine();
		
		for (String g : guests) if (name.equals(g)) found = true;
		
		p.nl(name + (found ? " is on the guest list." : " is not on the guest list."));
	}
	
	private static void bla() {
		String a = "A";
		String b = "B";	
		p.nl(a + b);
		String tmp = a;
		a = b;
		b = tmp;
		p.nl(a + b);
		p.nl(a == b || a.equals(b));
	}
	private static void blaInt() {
		int a = 1;
		int b = 2;	
		p.nl("" + a + b);
		int tmp = a;
		a = b;
		b = tmp;
		p.nl("" + a + b);
		p.nl(a == b);
	}
}
