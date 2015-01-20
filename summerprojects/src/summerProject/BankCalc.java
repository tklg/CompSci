package summerProject;

public class BankCalc {
	
	public static void main(String[] args) {
		
		double dep = 1000;
		double interest = 0.08;
		int dur = 10;
		
		for (int i = 1; i <= dur; i++) {

			dep += dep * interest;
			FirstHundred.print("Year " + i + " Total: " + dep);
		}
		
	}
}
