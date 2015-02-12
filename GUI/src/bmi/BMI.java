package bmi;

import java.awt.GridLayout;
import javax.swing.JFrame;
public class BMI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("BMI Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BmiPanel panel = new BmiPanel();
		panel.setLayout(new GridLayout(0,1));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}

