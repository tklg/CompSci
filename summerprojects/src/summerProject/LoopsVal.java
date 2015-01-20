package summerProject;

public class LoopsVal {
	
	public static void main(String[] args) {
		
		int[] t = {0,0,0,0,0};
		
		//loop 1
		int total1 = 0;
		for (int i = 1; i <= 10; i++) {
			total1++;
			t[0] = total1;
		}
		//loop 2
		int total2 = 1;
		for (int count = 1; count <= 10; count++) {
			total2 = total2 * 2;
			t[1] = total2;
		}
		//loop 3
		int total3 = 0;
		for (int i = 10; i <= 15; i++) {
			total3 += i;
			t[2] = total3;
		}
		//loop 4
		int total4 = 50;
		for (int i = 1; i <= 10; i++) {
			total4 += i;
			t[3] = total4;
		}
		//loop 5
		int total5 = 1;
		for (int icnt = 1; icnt <= 8; ++icnt) {
			total5 = total5 * icnt;
			t[4] = total5;
		}
		FirstHundred.print("Loop 1 total: " + t[0]);
		FirstHundred.print("Loop 2 total: " + t[1]);
		FirstHundred.print("Loop 3 total: " + t[2]);
		FirstHundred.print("Loop 4 total: " + t[3]);
		FirstHundred.print("Loop 5 total: " + t[4]);
	}
}
