package arrays;

import java.util.ArrayList;
import villa7.*;

public class Beatles {

	public static void main(String[] args) {
		ArrayList<String> band = new ArrayList<String>();
		band.add("Paul");
		band.add("Pete");
		band.add("John");
		band.add("George");
		
		p.nl(band.toString());
		int loc = band.indexOf("Pete");
		band.remove(loc);
		
		p.nl(band.toString());
		p.nl("At index 1: " + band.get(1));
		
		band.add(2, "Ringo");
		
		p.nl(band.toString());
		p.nl("Size of the band: " + band.size());
	}
}
