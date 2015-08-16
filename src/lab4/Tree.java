/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author JakeYang
 */
public class Tree {

    private static TurtlePanel turtlePanel;
    private static final int MAX_LEVEL = 5;

    public static void main(String[] args) {
        turtlePanel = new TurtlePanel();
        JFrame frame = new JFrame("Lab4");
        frame.setContentPane(turtlePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        init();
       // question4(6, MAX_LEVEL);
        question6(6, MAX_LEVEL);
        //question6(6, MAX_LEVEL);
        turtlePanel.repaint();
    }

    private static void init() {
        turtlePanel.home();
        turtlePanel.clear();
        turtlePanel.setTurtleIsVisible(false);
        turtlePanel.penUp();
        turtlePanel.turn(90);
        turtlePanel.back(10);
        turtlePanel.color(Color.red);
    }

    private static void question4(double size, int recursionLevel) {
        if (recursionLevel > 0) {
            turtlePanel.lineWidth(4 * recursionLevel);
            turtlePanel.penDown();
            turtlePanel.forward(size);
            for (int i = 0; i < 2; i++) {
                double height = 0.5 * Math.random() * size;
                turtlePanel.penUp();
                turtlePanel.back(height);
                int angle = 60 - (int) (Math.random() * 120);
                turtlePanel.turn(angle);
                turtlePanel.penDown();
                question4(size * recursionLevel / MAX_LEVEL, recursionLevel - 1);
                angle = (-1) * angle;
                turtlePanel.turn(angle);
                turtlePanel.forward(height);
            }
            turtlePanel.penUp();
            turtlePanel.back(size);
        }
    }

    private static void question5(double size, int recursionLevel) {
        if (recursionLevel > 0) {
            turtlePanel.lineWidth(4 * recursionLevel);
            turtlePanel.penDown();
            turtlePanel.forward(size);
            for (int i = 0; i < 3 *recursionLevel; i++) {
                double height = 0.5 * Math.random() * size;
                turtlePanel.penUp();
                turtlePanel.back(height);
                int angle = 60 - (int) (Math.random() * 120);
                turtlePanel.turn(angle);
                turtlePanel.penDown();
                question5(size * recursionLevel / MAX_LEVEL, recursionLevel - 1);
                angle = (-1) * angle;
                turtlePanel.turn(angle);
                turtlePanel.forward(height);
            }
            turtlePanel.penUp();
            turtlePanel.back(size);
        }
    }

    private static void question6(double size, int recursionLevel) {
        if (recursionLevel > 0) {
            turtlePanel.lineWidth(4 * recursionLevel);
            turtlePanel.color(new Color(recursionLevel * (255 / MAX_LEVEL), 80 + recursionLevel * (255 / (3 * MAX_LEVEL)), recursionLevel * (255 / (2 * MAX_LEVEL))));
            turtlePanel.penDown();
            turtlePanel.forward(size);
            for (int i = 0; i < 3 *recursionLevel ; i++) {
                double height = 0.5 * Math.random() * size;
                turtlePanel.penUp();
                turtlePanel.back(height);
                int angle = 60 - (int) (Math.random() * 120);
                turtlePanel.turn(angle);
                turtlePanel.penDown();
                question6(size * recursionLevel / MAX_LEVEL, recursionLevel - 1);
                angle = (-1) * angle;
                turtlePanel.turn(angle);
                turtlePanel.forward(height);
            }
            turtlePanel.penUp();
            turtlePanel.back(size);
        }
    }

}
