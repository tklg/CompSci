package labs_ch4;
import java.util.*;
import villa7.Print;

public class Band {
	private static BandBooster bb[] = new BandBooster[2];
	private static Scanner s = new Scanner(System.in);
	private static Print p = new Print();
	private static final int WEEKS = 3;
	
	public static void main(String[] args) {
		p.nl("Enter the name of the first member:");
		bb[0] = new BandBooster(s.next());
		p.nl("Enter the name of the second member:");
		bb[1] = new BandBooster(s.next());
		
		for(int i = 0; i < WEEKS; i++) {
			p.nl("WEEK " + (i + 1) + ":");
			for(int c = 0; c < bb.length; c++) {
				p.nl("Enter the number of boxes sold by " + bb[c].getName() + " this week:");
				bb[c].updateSales(s.nextInt());
			}
			p.nl();
		}
		
		p.nl("Total Sales by each member:");
		for (int i = 0; i < bb.length; i++) {
			p.nl("Name: " + bb[i].toString());
		}
	}
}
