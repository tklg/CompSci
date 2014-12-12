package pushcounter;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PushCounter extends JApplet {

	private int APPLET_WIDTH = 300,
				APPLET_HEIGHT = 35;
	private int pushes;
	private JLabel label;
	private JButton push;
	
	public void init() {
		pushes = 0;
		
		push = new JButton ("Push me");
		push.addActionListener(new ButtonListener());
		
		label = new JLabel("Pushes: " + Integer.toString(pushes));
		
		Container cp = getContentPane();
		cp.setBackground(Color.gray);
		cp.setLayout(new FlowLayout());
		cp.add(push);
		cp.add(label);
		
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pushes++;
			label.setText("Pushes: " + Integer.toString(pushes));
			repaint();
			
		}
	}
}
