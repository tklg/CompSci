package arrays;
import cs1.*;
import villa7.*;

public class IntCount {
	
	private static final int LIM = 50;
	
	public static void main(String[] args) {
		p.nl("Give numbers pls");
		
		String nums[] = kb.readString().trim().split(" ");
		
		int numS[] = new int[LIM];
		boolean got[] = new boolean[LIM];
		int numCount[] = new int[LIM];
		
		for (int i = 0; i < LIM - 1; i++) {
			int tmp = Integer.parseInt(nums[i]);
			numS[i] = tmp;
			if (i == tmp) got[i] = true; 
		}
		
		for (int i = 0; i < got.length; i++) {
			if (got[i]) {
				p.nl(numS[i]);
			}
		}
		
	}

}
