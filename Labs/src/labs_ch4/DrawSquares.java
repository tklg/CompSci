package labs_ch4;

import java.awt.Graphics;
import javax.swing.JApplet;
import java.util.*;

public class DrawSquares extends JApplet {
	public Square sq;
	private int numS = 5;
	private Scanner s = new Scanner(System.in);
	
	public void paint(Graphics g) {
		/*for (int i = 0; i < numS; i++) {
			sq = new Square();
			sq.draw(g);
		}*/
		sq = new Square();
		sq.draw(g);
		sq = new Square();
		sq.draw(g);
		sq = new Square();
		sq.draw(g);
		sq = new Square();
		sq.draw(g);
		sq = new Square();
		sq.draw(g);
	}
}
