package arrays;

import java.util.ArrayList;

import villa7.*;

public class Sound {
	public static int samples[] = {
		0,0,0,0,-14,0,-35,-39,0,-7,16,32,37,29,0,0
	};
	public static boolean found0 = false;
	
	public static void main(String[] args) {
		for (int s : samples) {
			p.l(s + " ");
		}
		p.nl();
		trimSilenceFromBeginning();
		for (int s : samples) {
			p.l(s + " ");
		}
		p.nl();
		for (int s : samples) {
			p.l(s + " ");
		}
	}
	
	public static void trimSilenceFromBeginning() {
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		for(int s : samples) {
			if (!found0) {
				if (s == 0) {
					
				} else {
					s2.add(s);
					found0 = true;
				}
			} else {
				s2.add(s);
			}
		}
		int i = 0;
		int sa[] = new int[s2.size()];
		for (Integer s : s2) {
			sa[i] = s;
			i++;
		}
		samples = sa;
	}
	

}
