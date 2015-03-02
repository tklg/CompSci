package elevens_1_3;

public class Part3_Questions {
	
	public static void main(String[] args) {
		int[] a = {1, 2,3, 4},
			  b = {1, 2, 3, 4},
			  c = {4, 2, 54, 1};
		
		boolean d = arePermutations(a, b);
		boolean e = arePermutations(a, c);
		
		System.out.println(d + " .. " + e);
	}
	
	public static String flip() {
		int rnd = (int) Math.round(Math.random() * 2);
		switch(rnd) {
			case 0: return "Heads";
			case 1: return "Heads";
			case 2: return "Tails";
		}
		return null;
	}
	
	public static boolean arePermutations(int[] a, int[] b) {
		if (a.length == b.length) {
			
			int[] c;
			int[] d;
			//sort a
			for (int index = 1; index < a.length; index++) {
				int key = a[index];
				int position = index;
				while (position > 0 && a[position - 1] > key) {
					a[position] = a[position - 1];
					position--;
				}
				a[position] = key;
			}
			//sort b
			for (int i = 1; i < b.length; i++) {
				int k = b[i];
				int p = i;
				while (p > 0 && b[p - 1] > k) {
					b[p] = b[p - 1];
					p--;
				}
				b[p] = k;
			}
			boolean is = true;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) is = false;
			}
			return is;
		} else {
			return false;
		}
	}
	
	/*
	 * Question 3
	 * 2, 3
	 * 2 swaps 2 and 3
	 * 3 swaps 1 and 4
	 * changing 1,2,3,4
	 * to       4,3,2,1
	 */
}
