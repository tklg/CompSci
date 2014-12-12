package stevenssummer;

import java.awt.BasicStroke;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

public class Game extends Frame {
	private static final long serialVersionUID = 1L;

// instance variables: list of all Asteroids, list of all Missiles, gun, etc.
    // ... instance variable declarations will go here
    private Image buffer;             // buffer for "double buffering" to eliminate flicker
    private Graphics bufferGC;        // graphics context for double buffering
    private ArrayList <Asteroid> allAsteroids;
    private Gun gun;
    private ArrayList <Missile> allMissiles;
    private ArrayList <Explosion> allExplosions;
    private Healthbar hb;
    
// constant values that govern game appearance & behavior
    private final int GAME_X_POSITION = 100;                    // screen position of ...
    private final int GAME_Y_POSITION = 100;                    //    upper left corner of game window
    private final String GAME_TITLE = "Asteroids Video Game";   // title of game window
    public final int GAME_WIDTH = 1000;                         // game width in pixels
    public final int GAME_HEIGHT = 700;                        // game height in pixels
    private final Color COLOR_BACKGROUND = Color.BLACK;         // color of the sky
    private final int PAUSE_TIME = 20; // fps
    private final double aChancePercentage = 3.0;
    private final int ASTEROID_DIAMETER = 40;
    private final int EXPLOSION_DIAMETER = 20;
    private static boolean CHEATMODE = false;
    public boolean hasLost = false;
    
    public int score = 0;


    public static void main(String[] args) {
        Game gameObject = new Game();
        gameObject.runGame();
    }

    
    public Game() {
        this.setLocation(GAME_X_POSITION, GAME_Y_POSITION);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setTitle(GAME_TITLE);
        this.addWindowListener(new HandleEvents());
        allAsteroids = new ArrayList<Asteroid>();
        allMissiles = new ArrayList<Missile>();
        allExplosions = new ArrayList<Explosion>();
        gun = new Gun(GAME_WIDTH / 2, GAME_HEIGHT);
        hb = new Healthbar(100, 50, GAME_WIDTH - 100, 50);
        addKeyListener(new KeyPress());
    }

    
    public void runGame() {
        createSky();
        this.setVisible(true);
    // these lines must come after window is visible
		buffer = createImage(this.getSize().width, this.getSize().height);
		bufferGC = buffer.getGraphics();
    //  main logic of the game
 		
        while (!hasLost) { 
        	createNewAsteroid();    // maybe create new Asteroid
            move();                 // move all objects
            repaint();              // paint all objects
            pause(PAUSE_TIME);      // sleep for 1/20th of a second
            interact();             // make objects interact
        }
    }


    private void createSky() {
        this.setBackground(COLOR_BACKGROUND);
    }
    
    
    private void createNewAsteroid() {
    	
    	if (Math.random() < (aChancePercentage / 100)) { //4% chance, every 1/20 second
	    	int xpos = 0;
	    	int aSize = 0;
	    	int r = (int)Math.round(Math.random() * 255);
	    	int g = (int)Math.round(Math.random() * 255);
	    	int b = (int)Math.round(Math.random() * 255);
	    	double deltaX = Math.floor(Math.random() * 3) - 1.5;
	    	double deltaY = Math.floor(Math.random() * 4) + 1;
	    	Color cc = new Color(r,g,b);
	    	
	    	while(aSize < 50) {
	        	print("failed with aSize " + aSize); //print if asteroid too small
	    		double rand = Math.random(); //generate random
	        	aSize = (int)Math.round(rand * 100);
	    	}
	    	while(xpos < 50 || xpos > (GAME_WIDTH - 50)) {
	    		//print("failed with xpos " + xpos);
	    		double rand = Math.random(); //generate random
	        	xpos = (int)Math.round(rand * GAME_WIDTH);
	    	}
	    	
	        Asteroid a = new Asteroid(xpos, 0.0, ASTEROID_DIAMETER, cc, deltaX, deltaY);
	        print("creating asteroid");
	        allAsteroids.add(a);
    	} else {
    		
    	}
    }
    
    
    private void move() {
    	for (int i = 0; i < allAsteroids.size(); i++) { //one type of for loop
    		allAsteroids.get(i).move();
    	}
    	
    	for (Missile m : allMissiles) {
    		m.move();
    	}
    }
    
    
// this is called by repaint() ... implements double buffering
    public void update(Graphics g) {
    // clear buffer
        bufferGC.setColor(COLOR_BACKGROUND);
        bufferGC.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

    // paint all objects into buffer, not yet onto screen
        paint(bufferGC);

    // paint buffer on screen in single operation
        g.drawImage(buffer, 0, 0, this); 
    }
    
    
    public void paint(Graphics g) {
    	for (Asteroid a : allAsteroids) { //other type of for loop
    		a.paint(g);
    	}
    	for (Missile m : allMissiles) {
    		m.paint(g);
    	}
    	gun.paint(g);
    	for (Explosion e : allExplosions) {
    		e.paint(g);
    	}
    	hb.paint(g);
    	Color prevColor = g.getColor(); //get current color
		g.setColor(Color.WHITE); //set color
    	g.drawString("Score: " + score, 30, 55);
    	g.setColor(prevColor);
    	
    	Graphics2D g2 = (Graphics2D) g;
    	prevColor = g2.getColor();
    	g2.setColor(Color.DARK_GRAY);
    	g2.setStroke(new BasicStroke(10));
    	g.drawLine(0, GAME_HEIGHT-10, GAME_WIDTH, GAME_HEIGHT-10);
    	g2.fillOval((GAME_WIDTH / 2) - 30, GAME_HEIGHT - 30, 60, 60);
    	g2.setColor(prevColor);
    	
    	if (Healthbar.length <= 0) {
			hasLost = true;
    	}
    }
    
    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }
    
    private void interact() {
        Iterator<Asteroid> aIter = allAsteroids.iterator();
        while (aIter.hasNext()) {
        	
        	Asteroid a = (Asteroid) aIter.next();
        	double ax = a.getCenterX();
        	double ay = a.getCenterY();
        	Iterator<Missile> mIter = allMissiles.iterator();
        	
        	while (mIter.hasNext()) {
        		
        		Missile m = (Missile) mIter.next();
        		double mx = m.getCenterX();
        		double my = m.getCenterY();
        		
        		double distance = Math.sqrt((ax-mx) * (ax-mx) + (ay-my) * (ay-my));
        		if (distance <= ASTEROID_DIAMETER / 2) {
        			aIter.remove();
        			mIter.remove();
        			Explosion e = new Explosion(ax, ay, EXPLOSION_DIAMETER);
        			allExplosions.add(e);
        			score += 1;
        			print("score: " + score);
        			break;
        		}
        		if (mx > GAME_WIDTH || mx < 0 || my < 0) {
        			mIter.remove();
        			continue;
        		}
        	}
        	
        	if (ay > GAME_HEIGHT) {
        		aIter.remove();
        		Explosion e = new Explosion(ax, ay, EXPLOSION_DIAMETER * 2);
    			allExplosions.add(e);
    			//score -= 1;
    			//print("score: " + score);
    			hb.decrease();
    			continue;
        	}
        	if (ax > GAME_WIDTH + (ASTEROID_DIAMETER / 2) || ax < 0) {
        		aIter.remove();
        		print("removed asteroid");
        		continue;
        	}
        }
        
        Iterator<Explosion> eIter = allExplosions.iterator();
        while (eIter.hasNext()) {
        	Explosion e = (Explosion) eIter.next();
        	if (e.shouldDelete()) {
        		eIter.remove();
        	}
        }
    }
    
    public static void print(String m) {
    	System.out.println(m);
    }
    
    public static void cheaty() {
    	
    	if (!CHEATMODE) {
    		CHEATMODE = true;
    	} else {
    		CHEATMODE = false;
    	}
    	
    	while (CHEATMODE) {
    		
    	}
    }

    private class KeyPress extends KeyAdapter {
        private final char COMMA = ',';
        private final char PERIOD = '.';
        private final char SPACE = ' ';
        private final char LB = '[';
        private final char RB = ']';

        public void keyPressed (KeyEvent e) {
            int key = e.getKeyChar();
            switch (key) {
            case COMMA:
                gun.moveLeft();
                break;
            case PERIOD:
                gun.moveRight();
                break;
            case SPACE:
                Missile m = gun.shoot();
                allMissiles.add(m);
                break;
            case LB:
            	gun.moveLeft();
            	m = gun.shoot();
                allMissiles.add(m);
                break;
            case RB:
            	gun.moveRight();
            	m = gun.shoot();
                allMissiles.add(m);
                break;
            case 'q':
                System.exit(0);
                break;
            case 'p':
            	cheaty();
            	break;
            }
        }
    }  // end of KeyPress class
}  // end of Game class

class HandleEvents extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}  // end of HandleEvents class