package bmi;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.color.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
public class BmiPanel extends JPanel {
	private int WIDTH = 300;
	private int HEIGHT = 140;
	private final int MAX = 16777215;
	private JLabel heightLabel, weightLabel, bmiLabel, resultLabel;
	private JTextField height, weight;
	private JButton calculate;
	public BmiPanel() {
		heightLabel = new JLabel("Your height in inches: ");
		weightLabel = new JLabel("Your weight in pounds: ");
		
		bmiLabel = new JLabel("This is your BMI");
		resultLabel = new JLabel();
		
		height = new JTextField();
		weight = new JTextField();
		
		calculate = new JButton("Calculate BMI");
		calculate.addActionListener(new bmiListener());
		
		add(heightLabel);
		add(height);
		height.setBackground(new Color(new Random().nextInt(MAX)));
		//height.setForeground(new Color(new Random().nextInt(MAX)));
		add(weightLabel);
		weight.setBackground(new Color(new Random().nextInt(MAX)));
		add(weight);
		add(calculate);
		calculate.setBackground(new Color(new Random().nextInt(MAX)));
		add(bmiLabel);
		add(resultLabel);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(new Random().nextInt(MAX)));
		//setBorder(new BevelBorder(HEIGHT, preserveBackgroundColor, preserveBackgroundColor));
		
	}
	private class bmiListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String heightText, weightText;
			int heightVal = 0, weightVal = 0;
			double bmi;
			
			heightText = height.getText();
			weightText = weight.getText();
			
			try {
				heightVal = Integer.parseInt(heightText);
				weightVal = Integer.parseInt(weightText);
				bmi = 703 * weightVal / Math.pow(heightVal, 2);
				resultLabel.setText(Double.toString(bmi));
				System.out.println("BMI: " + bmi);
			} catch (Exception e) {
				System.err.println("Error: " + e);
				resultLabel.setText("Please enter numbers.");
			}
		}
	}
}
