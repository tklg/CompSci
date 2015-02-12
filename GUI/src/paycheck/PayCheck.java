package paycheck;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import villa7.*;

public class PayCheck extends JApplet {

	private int APPLET_WIDTH = 500,
				APPLET_HEIGHT = 35,
				hPay = 0,
				tDelay = 300;
	private int hours;
	private double pay;
	private JLabel timeLabel, payLabel;
	private JButton pushInc, pushDec, pushEnt;
	
	public void init() {
		
		String hPayS = JOptionPane.showInputDialog("Enter hourly pay:");
		hPay = Integer.parseInt(hPayS);
		
		hours = 0;
		
		pushInc = new JButton ("Add 1 hour");
		pushDec = new JButton ("Remove 1 hour");
		pushEnt = new JButton ("Enter");
		pushInc.addActionListener(new ButtonListenerInc());
		pushDec.addActionListener(new ButtonListenerDec());
		pushEnt.addActionListener(new ButtonListenerEnt());
		
		timeLabel = new JLabel("Hours: " + Integer.toString(hours));
		payLabel = new JLabel("Pay: " + pay);
		
		Container cp = getContentPane();
		cp.setBackground(CColor.obscure_color);
		cp.setLayout(new FlowLayout());
		cp.add(pushInc);
		cp.add(pushDec);
		cp.add(timeLabel);
		cp.add(pushEnt);
		cp.add(payLabel);
		
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}
	
	private class ButtonListenerInc implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			hours++;
			timeLabel.setText("Hours: " + Integer.toString(hours));
			repaint();
		}
	}
	private class ButtonListenerDec implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (hours > 0) {
				hours--;
				timeLabel.setText("Hours: " + Integer.toString(hours));
				repaint();
			}
		}
	}
	private class ButtonListenerEnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (hours > 40) {
				pay = (((hours - 40) * 1.5) * hPay) + (40 * hPay); 
			} else {
				pay = (hours * hPay);
			}
			payLabel.setText("Hours: " + pay);
			repaint();
		}
	}
}
