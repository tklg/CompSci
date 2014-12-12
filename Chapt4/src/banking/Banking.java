package banking;
import villa7.Print;

public class Banking {
	private static Print p = new Print();
	
	public static void main (String args[]) {
		Account acct1 = new Account ("Ted Murphy", 72354, 102.56);
		Account acct2 = new Account ("Anita Gomez", 69713, 40.00);
		Account acct3 = new Account ("Sanchit Reddy", 93757, 759.32);
		
		acct1.deposit(25.85);
		
		double gomezBalance = acct2.deposit (500.00);
		p.nl("Gomez balance after deposit: " + gomezBalance);
		p.nl("Gomez balance after withdrawl: " + acct2.withdraw (430.75, 1.50));
		
		acct3.withdraw(800.00, 0.0); //exceeds balance
		acct1.addInterest();
		acct2.addInterest();
		acct3.addInterest();
		
		p.nl();
		p.nl(acct1.toString());
		p.nl(acct2.toString());
		p.nl(acct3.toString());
		
	}
}
