package stevenssummer;

import java.awt.Color;
import java.awt.Graphics;

public class Missile {

	private double xpos, ypos;
	private double deltaX, deltaY;
	private Color color;
	private int diameter = 5;
	
	public Missile(double x, double y, double dx, double dy) {
		xpos = x;
		ypos = y;
		deltaX = dx;
		deltaY = dy;
		color = Color.WHITE;
	}
	
	public void move() {
		xpos += deltaX;
		ypos += deltaY;
	}
	
	public void paint(Graphics g) {
		Color prevColor = g.getColor(); //get current color
		g.setColor(color); //set color
		g.fillOval((int)xpos, (int)ypos, diameter, diameter);
		g.setColor(prevColor);
	}
	
	public double getCenterX() {
		return xpos + (diameter / 2);
	}
	public double getCenterY() {
		return ypos + (diameter / 2);
	}
	
}
