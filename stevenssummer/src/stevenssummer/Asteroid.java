package stevenssummer;

import java.awt.Color;
import java.awt.Graphics;

public class Asteroid {
	
	private double xpos = 0.0; //pixels
	private double ypos = 0.0;
	private int diameter = 40;
	private Color color;
	private double deltaX; //change in X
	private double deltaY; //change in Y
	
	public Asteroid(double x, double y, int d, Color c, double dx, double dy) {	
		xpos = x; 
		ypos = y;
		diameter = d;
		color = c;
		deltaX = dx;
		deltaY = dy;
	}
	
	public void paint(Graphics g) {
		Color prevColor = g.getColor(); //get current color
		g.setColor(color); //set color
		g.fillOval((int)xpos - (diameter / 2), (int)ypos - (diameter / 2), diameter, diameter);
		g.setColor(prevColor); //reset color to original
		
	}
	
	public void move() {
		xpos += deltaX;
		ypos += deltaY;
	}
	
	public double getCenterX() {
		return xpos + (diameter / 2);
	}
	public double getCenterY() {
		return ypos + (diameter / 2);
	}

}
