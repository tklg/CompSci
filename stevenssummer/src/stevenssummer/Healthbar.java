package stevenssummer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Healthbar {
	
	private int xorigin;
	private int yorigin;
	private int xend;
	private int yend;
	public static int length;
	private int lengthOriginal;
	private Color color;

	public Healthbar(int xo, int yo, int xe, int ye) {
		
		xorigin = xo;
		yorigin = yo;
		xend = xe;
		yend = ye;
		length = xe - xo;
		lengthOriginal = length;
		color = Color.green;
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Color prevColor = g2.getColor(); //get current color
		g2.setColor(color); //set color
		Stroke prevStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(10)); //width
		g2.drawLine(xorigin, 
				yorigin, 
				xend, 
				yend);
		g2.setColor(prevColor);
		g2.setStroke(prevStroke);
	}	
	
	public void decrease() {
		if (length > 0) {
		xend -= 10;
		length -= 10;
		}
		
		if (length <= (lengthOriginal / 10) * 5 && length > (lengthOriginal / 10) * 2) {
			color = Color.ORANGE;
		}
		if (length <= (lengthOriginal / 10) * 2) {
			color = Color.RED;
		}
		if (length <= 0) {
			color = new Color(0x0, 0x0, 0x0, 0);
		}
		
	}
	
}
