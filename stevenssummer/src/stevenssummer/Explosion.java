package stevenssummer;

import java.awt.*;

public class Explosion {

    //private static String[] sound_effect = {"Boom!", "Pow!", "Slam!", "Crash!", "Bam!", "Splat!", "Ka-blam!"};
    private final int MAX_PAINTS = 10;
    private double xpos;
    private double ypos;
    private int radius;
    //private String sound;
    private Polygon shape;
    private int numTimesPainted;
    private boolean shouldDelete;
    
    
// produce a random number in the range [bottom, top) -- used below for random scaling
    private double scale(double bottom, double top) {
        return bottom + Math.random()*(top-bottom);
    }


/*
 *  Produce an "explosion" polygon.  First, 20 points around the circumference
 *  of a circle are produced.  The center of the circle is (xpos, ypos) and its
 *  radius is "radius".  The angle of each point is computed in "angle" and the
 *  coordinates of each point are (cos(angle)*radius, sin(angle)*radius).
 *  Next, each point is translated randomly by multiplying by "scale(0.75, 1.25)".
 *  Finally, even points are translated by multiplying by 1.3 (pushing the
 *  point away from the circle) while odd points are translated by multiplying
 *  by 0.7 (drawing the point into the circle).
 */
    public Explosion(double x, double y, int asteroidDiameter) {
        xpos = x;
        ypos = y;
        radius = asteroidDiameter * 3;
      
        //int index = (int)(Math.random() * sound_effect.length);
        //sound = new String(sound_effect[index]);

        shape = new Polygon();
        for (int i = 0; i < 20; i++) {
            double angle = i * Math.PI / 10;
            
            double xadjust = Math.cos(angle) * radius * scale(0.75, 1.25);
            double yadjust = Math.sin(angle) * radius * scale(0.75, 1.25);
            
            if (i % 2 == 0) {
                xadjust *= 1.3;
                yadjust *= 1.3;
            } else {
                xadjust *= 0.7;
                yadjust *= 0.7;
            }
            
            shape.addPoint((int)(xpos + xadjust), (int)(ypos + yadjust));
        }

        numTimesPainted = 0;
        shouldDelete = false;
    }
    
    
    public boolean shouldDelete() {
        return shouldDelete;
    }


/* paint explosion a total of MAX_PAINTS times then mark it for deletion */
    public void paint(Graphics g) {
    	
    	Graphics2D g2 = (Graphics2D) g;

        Color savedColor = g2.getColor();
        Font savedFont = g2.getFont();
        Stroke prevStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(5));

        g2.setColor(Color.ORANGE);
        g2.fillPolygon(shape);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(shape);

        g2.setColor(Color.YELLOW);
        //g2.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
        //g2.drawString(sound, (int)(xpos - 30), (int)ypos);
        
        g2.setColor(savedColor);
        g2.setFont(savedFont);
        g2.setStroke(prevStroke);
        
        if (++numTimesPainted >= MAX_PAINTS)
            shouldDelete = true;
    }

}