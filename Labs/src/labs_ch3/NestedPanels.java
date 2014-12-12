package labs_ch3;

//********************************************************************
//NestedPanels.java Author: Lewis/Loftus
//
//Demonstrates a basic component hierarchy.
//********************************************************************

import java.awt.*;
import javax.swing.*;
public class NestedPanels {

//-----------------------------------------------------------------
// Presents two colored panels nested within a third.
//-----------------------------------------------------------------

	public static void main (String[] args) {
	
		JFrame frame = new JFrame ("Nested Panels");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JPanel subPanel0 = new JPanel();
		subPanel0.setPreferredSize (new Dimension(320, 20));
		subPanel0.setBackground (Color.BLUE);
		JLabel label0 = new JLabel ("My Panels");
		label0.setForeground(Color.WHITE);
		subPanel0.add (label0);
		
		// Set up first subpanel
		JPanel subPanel1 = new JPanel();
		subPanel1.setPreferredSize (new Dimension(150, 100));
		subPanel1.setBackground (Color.green);
		JLabel label1 = new JLabel ("One");
		subPanel1.add (label1);
		
		// Set up second subpanel
		JPanel subPanel2 = new JPanel();
		subPanel2.setPreferredSize (new Dimension(150, 100));
		subPanel2.setBackground (Color.red);
		JLabel label2 = new JLabel ("Two");
		subPanel2.add (label2);
		
		// Set up third subpanel
				JPanel subPanel3 = new JPanel();
				subPanel3.setPreferredSize (new Dimension(300, 100));
				subPanel3.setBackground (Color.ORANGE);
				JLabel label3 = new JLabel ("Three");
				subPanel3.add (label3);
		
		// Set up primary panel
		JPanel primary = new JPanel();
		primary.setBackground (Color.blue);
		primary.setPreferredSize( new Dimension (320, 260));
		primary.add(subPanel0);
		primary.add (subPanel1);
		primary.add (subPanel2);
		primary.add(subPanel3);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}
