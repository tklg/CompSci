package diaBox;

import javax.swing.*;
public class EvenOdd {
	public static void main(String[] args) {
		String numStr, result;
		int num, again;
		do {
			numStr = JOptionPane.showInputDialog("Enter an integer: ");
			num = Integer.parseInt(numStr);
			result = "That number is " + ((num % 2 == 0) ? "even" : "odd");
			JOptionPane.showMessageDialog(null, result);
			again = JOptionPane.showConfirmDialog(null, "Do another?");
		} while (again == JOptionPane.YES_OPTION);
	}
}