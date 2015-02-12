package votecounter;

import javax.swing.JFrame;

public class VoteCounter {

	public static void main(String[] a) {
		JFrame fr = new JFrame("Vote Counter");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.getContentPane().add(new VoteCounterPanel());
		fr.pack();
		fr.setVisible(true);
	}
	
}
