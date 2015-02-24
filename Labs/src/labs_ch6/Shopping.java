package labs_ch6;
import villa7.*;

import java.text.NumberFormat;
import java.util.*;


public class Shopping {
	
	private static Scanner sc = new Scanner(System.in);
	private static ShoppingCart cart = new ShoppingCart();
	private static NumberFormat fmt = NumberFormat.getCurrencyInstance();
	private static double tPrice = 0;
	
	public static void main(String[] args) {
		
		while (true) {
			
			p.nl("Enter name of item:");
			String name = sc.next();
			if (name.equalsIgnoreCase("done")) {
				break;
			}
			p.nl("Enter price of item:");
			double price = sc.nextDouble();
			p.nl("Enter quantity of item:");
			int num = sc.nextInt();
			
			cart.addToCart(name, price, num);
			tPrice += price * num;
			p.nl("Added " + num + " of " + name + " for " + fmt.format(price));
			p.nl(cart.toString());
		}
		
		p.nl("------------------------------------");
		p.nl(cart.toString());
		p.nl("Please pay " + fmt.format(tPrice));
		
	}
}
