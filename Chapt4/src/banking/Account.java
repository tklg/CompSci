package banking;
import java.text.NumberFormat;
import villa7.Print;

public class Account {
	
	private Print p = new Print();
	
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	private final double RATE = 0.035; //interest 3.5%
	private int acctNumber;
	private double balance;
	private String name;
	
	//sets up account - defines owner, num, bal
	public Account (String owner, int account, double initial) {
		name = owner;
		acctNumber = account;
		balance = initial;
	}
	
	//validates transaction, deposits amt, returns new bal
	public double deposit (double amount) {
		if (amount < 0) {
			p.nl();
			p.nl("Error: Deposit amount is invalid.");
			p.nl(acctNumber + " " + fmt.format(amount));
		} else {
			balance += amount;
		}
		return balance;
	}
	
	//validates and withdraws amt, returns new bal
	public double withdraw (double amount, double fee) {
		amount += fee;
		
		if (amount < 0) {
			p.nl();
			p.nl("Error: Withdraw amount is invalid.");
			p.nl("Account: " + acctNumber);
			p.nl("Requested: " + fmt.format(amount));
		} else {
			if (amount > balance) {
				p.nl();
				p.nl("Error: insufficient funds");
				p.nl("Account: " + acctNumber);
				p.nl("Requested: " + fmt.format(amount));
				p.nl("Available: " + fmt.format(balance));				 
			} else {
				balance -= amount;
			}
		}
		return balance;
	}
	
	//adds interest, returns new bal
	public double addInterest() {
		balance += (balance * RATE);
		return balance;
	}
	//return curBal
	public double getBalance() {
		return balance;
	}
	//return account number
	public int getAccountNumber() {
		return acctNumber;
	}
	//return one line desc of acct as string
	public String toString() {
		return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
	}
}
