/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author JakeYang
 */
public class Sierpinski extends JFrame {

    private static final int WINDOW_SIZE = 450;
    private static final int THRESHOLD = 10;
    private static int p1X, p1Y, p2X, p2Y, p3X, p3Y;

    public Sierpinski() {
        super("sierpinski");
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Point getMiddle(Point p1, Point p2) {
        return new Point((int) (p1.getX() + p2.getX()) / 2, (int) (p1.getY() + p2.getY()) / 2);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        p1X = (int) getWidth() / 2;
        p1Y = 40;
        p2X = 20;
        p2Y = (int) getHeight() - 20;
        p3X = (int) getWidth() - 20;
        p3Y = (int) getHeight() - 20;
        g.setColor(Color.red);
        sierpinskiDraw(new Point(p1X, p1Y), new Point(p2X, p2Y), new Point(p3X, p3Y), g);
        
    }

    public static void main(String[] args) {
        Sierpinski sierpinski = new Sierpinski();
        sierpinski.setVisible(true);
        
    }

    private void sierpinskiDraw(Point point1, Point point2, Point point3, Graphics g) {
        if (point1.distance(point2) < THRESHOLD && point2.distance(point3) < THRESHOLD && point1.distance(point3) < THRESHOLD) {
            return;
        }
        g.drawLine((int) point1.getX(), (int) point1.getY(), (int) point2.getX(), (int) point2.getY());

        g.drawLine((int) point2.getX(), (int) point2.getY(), (int) point3.getX(), (int) point3.getY());
        g.drawLine((int) point3.getX(), (int) point3.getY(), (int) point1.getX(), (int) point1.getY());

        Point m12 = getMiddle(point1, point2);
        Point m23 = getMiddle(point2, point3);
        Point m31 = getMiddle(point3, point1);

        sierpinskiDraw(point1, m12, m31, g);
        sierpinskiDraw(point2, m23, m12, g);
        sierpinskiDraw(point3, m31, m23, g);
        
        try {
            sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sierpinski.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
