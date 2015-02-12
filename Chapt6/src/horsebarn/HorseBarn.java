package horsebarn;

import java.util.ArrayList;

public class HorseBarn {
	private Horse[] spaces;
	public int findHorseSpace(String name) {
		for(int i = 0; i < spaces.length; i++) {
			if (spaces[i].getName().equalsIgnoreCase(name) && spaces[i] != null) {
				return i;
			}
		}
		return -1;
	}
	public void consolidate() {
		ArrayList<Horse> conHorse = new ArrayList<Horse>();
		int i = 0;
		for (Horse h : spaces) {
			if (h != null) conHorse.add(h);
			h = null;
		}
		for (Horse h : conHorse) {
			spaces[i] = h;
			i++;
		}
	}
}