package summerProject;

public class Counters {
	
	public static void main(String[] args) {
		
	int c[] = {0,0,0,0,0,0};
		
	for (int i = 1; i <= 20; i++) {
		c[0]++;
	}
	for (int icount = 1; icount <= 20; icount += 2) {
		c[1]++;
	}
	for (int j = 1; j <= 100; j += 5) {
		c[2]++;
	}
	for (int icount = 20; icount >= 1; icount--) {
		c[3]++;
	}
	for (int icount = 20; icount >= 1; icount -= 2) {
		c[4]++;
	}
	for (double xcnt = 20.0; xcnt >= 9.5; xcnt -= 0.05) {
		c[5]++;
	}
	
	FirstHundred.print("C1 fires " + c[0] + " times.");
	FirstHundred.print("C2 fires " + c[1] + " times.");
	FirstHundred.print("C3 fires " + c[2] + " times.");
	FirstHundred.print("C4 fires " + c[3] + " times.");
	FirstHundred.print("C5 fires " + c[4] + " times.");
	FirstHundred.print("C6 fires " + c[5] + " times.");
		
	}
}
