package diaBox;

import javax.swing.*;
public class MultiplyTwo {
	public static void main(String[] args) {
		String numStr[] = {"",""}, result;
		int num[] = {0,0}, again;
		do {
			numStr[0] = JOptionPane.showInputDialog("Enter an integer: ");
			try {
				num[0] = Math.abs(Integer.parseInt(numStr[0]));
				numStr[1] = JOptionPane.showInputDialog("Enter another integer: ");
				try {
					num[1] = Math.abs(Integer.parseInt(numStr[1]));
					num[1] = Integer.parseInt(numStr[1]);
					result = "The sum of " + num[0] + " and " + num[1] + " is " + (num[0] + num[1])
							+ "\nand the product is " + (num[0] * num[1]);
				} catch (NumberFormatException e) {
					System.err.println("Error: " + e);
					result = (numStr[1] + " is not a number.");
				}
			} catch (NumberFormatException e) {
				System.err.println("Error: " + e);
				result = (numStr[0] + " is not a number.");
			}
			JOptionPane.showMessageDialog(null, result);
			again = JOptionPane.showConfirmDialog(null, "Do another?");
		} while (again == JOptionPane.YES_OPTION);
	}
}