package tempconv;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TemperatureConverter {
	
	private final int WIDTH = 300,
					  HEIGHT = 100;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel inputLabel,
				   outputLabel,
				   resultLabel;
	private JTextField fTemp;
	private JTextField cTemp;
	private JButton switchMode;
	
	private boolean FtoC = true;
	
	public TemperatureConverter() {
		frame = new JFrame("Temperature Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		switchMode = new JButton("Switch mode");
		switchMode.addActionListener(new ButtonListener());

			inputLabel = new JLabel("Enter temp in Farenheight:");
			outputLabel = new JLabel("Temp in Celsius:");
			resultLabel = new JLabel("---");
			
			fTemp = new JTextField(5);
			cTemp = new JTextField(5);
			fTemp.addActionListener(new TempListener());
			
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			panel.setBackground(Color.GRAY);
			panel.add(inputLabel);
			panel.add(fTemp);
			panel.add(outputLabel);
			panel.add(resultLabel);

		panel.add(switchMode);
		frame.getContentPane().add(panel);
	}
	
	public void display() {
		frame.pack();
		frame.setVisible(true);
	}
	
	private class TempListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double f,
				c;
			
			if (FtoC) {
				String text = fTemp.getText();
				
				f = Integer.parseInt(text);
				c = (f - 32) * 5 / 9;
				
				resultLabel.setText(Double.toString(c) + "°");
			} else {
				String text = cTemp.getText();
				
				c = Integer.parseInt(text);
				f = c * 9 / 5 + 32;
				
				resultLabel.setText(Double.toString(f) + "°");
			}
		}
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (FtoC) {
				FtoC = false;
				inputLabel.setText("Enter temp in Celsius:");
				outputLabel.setText("Temp in Farenheight:");
				resultLabel.setText("---");
				
				//fTemp = new JTextField(5);
				fTemp.addActionListener(new TempListener());
				panel.add(fTemp);
				panel.remove(cTemp);
				panel.remove(outputLabel);
			} else {
				FtoC = true;
				inputLabel.setText("Enter temp in Farenheight:");
				outputLabel.setText("Temp in Celsius:");
				resultLabel.setText("---");
				
				//cTemp = new JTextField(5);
				cTemp.addActionListener(new TempListener());
				panel.add(cTemp);
				panel.remove(fTemp);
				panel.remove(outputLabel);
			}
			//repaint();
			
			display();
			
		}
	}
}
