package stevenssummer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Gun {

	private int xOrigin;
	private int yOrigin;
	private double angle; //radians
	private int gunLength; //px
	private Color color;
	private double d30 = 0.423598776;
	
	public Gun(int x, int y) {
		xOrigin = x;
		yOrigin = y;
		angle = -1 * Math.PI / 2;
		gunLength = 50;
		color = Color.LIGHT_GRAY;
	}
	
	public void moveLeft() {
		if (angle > (-1 * Math.PI) + d30) {
			angle -= 0.1; //add .1 to radians
			Game.print("Moved gun left");
		}
	}
	
	public void moveRight() {
		if (angle < (0 - d30)) {
			angle += 0.1;
			Game.print("Moved gun right");
		}
	}
	
	public Missile shoot() {
		return new Missile((int) (xOrigin + gunLength * Math.cos(angle)), 
				(int) (yOrigin + gunLength * Math.sin(angle)), 
				10 * Math.cos(angle), 
				10 * Math.sin(angle));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Color prevColor = g2.getColor(); //get current color
		g2.setColor(color); //set color
		g2.setStroke(new BasicStroke(20)); //width
		g2.drawLine(xOrigin, 
				yOrigin, 
				(int) (xOrigin + gunLength * Math.cos(angle)), 
				(int) (yOrigin + gunLength * Math.sin(angle)));
		g2.setColor(prevColor);
	}	
}
