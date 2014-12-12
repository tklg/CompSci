package labs_ch4;
import java.util.*;
import villa7.Print;

public class TestNames {
	
	private static int numNames = 2;
	private static Scanner s = new Scanner(System.in);
	private static Print p = new Print();
	private static String f[] = new String[numNames];
	private static String m[] = new String[numNames];
	private static String l[] = new String[numNames];
	private static Name n[] = new Name[numNames];
	
	public static void main(String[] args) {
		
		for (int i = 0; i < numNames; i++) {
			p.nl("Enter a name: (first middle last)");
			f[i] = s.next();
			m[i] = s.next();
			l[i] = s.next();
			p.nl();
		}
		
		for (int i = 0; i < numNames; i++) {
			n[i] = new Name(f[i],m[i],l[i]);
		}
		
		for (int i = 0; i < numNames; i++) {
			p.nl(n[i].firstMiddleLast());
			p.nl(n[i].lastFirstMiddle());
			p.nl("Initials: " + n[i].initials());
			p.nl("length: " + n[i].length() + " letters");
			p.nl();
		}
		
		if (numNames == 2) {
			if (n[0].equals(n[1])) {
				p.nl("These names are the same.");
			} else {
				p.nl("These names are different.");
			}
		}
	}

}
