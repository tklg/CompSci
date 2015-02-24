package labs_ch6;

import java.text.NumberFormat;
public class Item {
	private String name;
	private double price;
	private int quantity;
	public Item(String itemName, double itemPrice, int numPurchased) {
		name = itemName;
		price = itemPrice;
		quantity = numPurchased;
	}
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String item;
		if (name.length() >= 8) {
			item = name + "\t";
		}
		else {
			item = name + "\t\t";
		}
		return (item + " " + fmt.format(price) + "\t\t" + quantity + "\t\t" + fmt.format(price * quantity));

	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
}
	
