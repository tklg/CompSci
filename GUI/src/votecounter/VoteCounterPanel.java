package votecounter;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class VoteCounterPanel extends JPanel {
	private int votesJoe,
				votesSam;
	private JButton joe,
					sam;
	private JLabel lJoe,
				   lSam;
	private final int MAX = 16777215;
	private int CC = 0;
	
	public VoteCounterPanel() {
		votesJoe = 0;
		votesSam = 0;
		
		joe = new JButton("Vote for Joe");
		sam = new JButton("Vote for Sam");
		joe.addActionListener(new BLJ());
		sam.addActionListener(new BLS());
		
		lJoe = new JLabel("Votes for Joe: " + votesJoe);
		lSam = new JLabel("Votes for Sam: " + votesSam);
		
		add(joe);
		add(sam);
		add(lJoe);
		add(lSam);
		
		setPreferredSize(new Dimension(600, 40));
		CC = new Random().nextInt(MAX);
		setBackground(new Color(CC));
	}
	
	private class BLJ implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			votesJoe++;
			if (CC <= MAX)
				CC += 10000;
			lJoe.setText("Votes for Joe: " + votesJoe);
			setBackground(new Color(CC));
		}
	}
	private class BLS implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			votesSam++;
			if (CC >= 0)
				CC -= 10000;
			lSam.setText("Votes for Sam: " + votesSam);
			setBackground(new Color(CC));
		}
	}
}
