package labs_ch6;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import villa7.*;

public class Shop {
	
	public static ArrayList<Item> cart = new ArrayList<Item>();
	private static NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public static void main(String[] args) {
		Item item;
		String itemName;
		double itemPrice;
		int quantity;
		Scanner scan = new Scanner(System.in);
		String keepShopping = "y";
		do {
			System.out.print("Enter the name of the item: ");
			itemName = scan.next();
			System.out.print("Enter the unit price: ");
			itemPrice = scan.nextDouble();
			System.out.print("Enter the quantity: ");
			quantity = scan.nextInt();
			
			cart.add(new Item(itemName, itemPrice, quantity));
			
			System.out.print("Continue shopping (y/n)? ");
			keepShopping = scan.next();
		} while (keepShopping.equalsIgnoreCase("y"));
		
		//print arraylist contents 
		
		p.nl();
		int tPrice = 0;
		for (Item i : cart) {
			p.nl(i.getName());
			tPrice += i.getPrice() * i.getQuantity();
		}
		p.nl(fmt.format(tPrice));
	}
}
