package labs_ch6;

import java.text.NumberFormat;
public class ShoppingCart {
	private int itemCount;
	private double totalPrice;
	private int capacity;
	private Item[] cart;
	public ShoppingCart() {
		capacity = 5;
		itemCount = 0;
		totalPrice = 0.0;
		cart = new Item[capacity];
	}
	public void addToCart(String itemName, double price, int quantity) {
		cart[itemCount] = new Item(itemName, price, quantity);
		totalPrice += price * quantity;
		itemCount++;
		if (itemCount >= capacity) {
			increaseSize();
		}
	}
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String contents = "\nShopping Cart\n";
		contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
		for (int i = 0; i < itemCount; i++)
		contents += cart[i].toString() + "\n";
		contents += "\nTotal Price: " + fmt.format(totalPrice);
		contents += "\n";
		return contents;
	}
	private void increaseSize() {
		Item[] tCart = new Item[cart.length + 3];	
		for (int i = 0; i < cart.length; i++) {
			tCart[i] = cart[i];
		}
		cart = tCart;
	}
	public double totalPrice() {
		return totalPrice();
	}
}
