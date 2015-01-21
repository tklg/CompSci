package diaBox;

import javax.swing.*;
public class SquareRoots {
	public static void main(String[] args) {
		String numStr, result;
		double num = 0;
		int again;
		do {
			numStr = JOptionPane.showInputDialog("Enter an integer: ");
			try {
				num = Math.abs(Integer.parseInt(numStr));
				result = "The square root of " + num + " is " + Math.sqrt(num);
			} catch (NumberFormatException e) {
				System.err.println("Error: " + e);
				result = (numStr + " is not a number.");
			}
			JOptionPane.showMessageDialog(null, result);
			again = JOptionPane.showConfirmDialog(null, "Do more?");
		} while (again == JOptionPane.YES_OPTION);
	}
}