/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JakeYang
 */
public class BouncingBalls extends JPanel implements Runnable {

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HIGHT = 600;
    private static final int NUMBER_OF_BALLS = 1;

    private final List<Ball> balls;
    private Thread thread;
    private boolean isRunning;

    public BouncingBalls() {
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HIGHT));
        balls = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            Ball ball = new Ball();
            ball.setpX(20 + Math.random() * ((580 - 20) + 1));
            ball.setpY(20 + Math.random() * ((580 - 20) + 1));

            ball.setvX(1 + Math.random() * ((15 - 1) + 1));
            ball.setvY(1 + Math.random() * ((15 - 1) + 1));
            ball.setcolor(Color.getHSBColor((float) Math.random(), 1.0f, 1.0f));
            ball.setradius(10 + Math.random() * ((20 - 10) + 1));
            ball.setdeltaT(1.0f);
            balls.add(ball);
        }
    }

    public static void main(String[] args) {
        //set the frame
        JFrame frame = new JFrame("Week 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BouncingBalls bouncingBalls = new BouncingBalls();
        frame.setContentPane(bouncingBalls);
        frame.pack();
        //Toolkit toolkit = Toolkit.getDefaultToolkit();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        bouncingBalls.start();
    }

    public void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());

        for (Ball ball : balls) {
            g.setColor(ball.getcolor());
            g.fillOval((int) (ball.getpX() - ball.getradius()), (int) (ball.getpY() - ball.getradius()), (int) (ball.getradius() * 2), (int) (ball.getradius() * 2));

        }
    }
    @Override
    public void run() {
        while (isRunning) {
            repaint();
            for (Ball ball : balls) {
                if (((ball.getpX()) > (getWidth() - ball.getradius())) || ((ball.getpX() + ball.getdeltaT() * ball.getpX()) < ball.getradius())) {
                    ball.setvX(ball.getvX() * -1.0);
                    ball.setcolor(Color.getHSBColor((float) Math.random(), 1.0f, 1.0f));
                    System.out.println(ball.getvX());
                    System.out.println(ball.getvY());
                    
                }
            }
            for (Ball ball : balls) {
                if (((ball.getpY()) > (getHeight() - ball.getradius())) || ((ball.getpY() + ball.getdeltaT() * ball.getpY()) < ball.getradius())) {
                    ball.setvY(ball.getvY() * -1.0);
                    ball.setcolor(Color.getHSBColor((float) Math.random(), 1.0f, 1.0f));

                }
            }
            for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                for (int j = i + 1; j < NUMBER_OF_BALLS; j++) {
                    Ball ball1 = balls.get(i);
                    Ball ball2 = balls.get(j);
                    double deltalX = (ball1.getpX() + ball1.getdeltaT() * ball1.getvX()) - (ball2.getpX() + ball2.getdeltaT() * ball2.getvX());
                    double deltalY = (ball1.getpY() + ball1.getdeltaT() * ball1.getvY()) - (ball2.getpY() + ball2.getdeltaT() * ball2.getvY());
                    if ((Math.sqrt(Math.pow(deltalX, 2) + Math.pow(deltalY, 2))) <= (ball1.getradius() + ball2.getradius())) {
                        double tempX = ball1.getvX();
                        double tempY = ball1.getvY();
                        double tempT = ball1.getdeltaT();

                        ball1.setvX(ball2.getvX());
                        ball1.setvY(ball2.getvY());
                        ball1.setdeltaT(ball2.getdeltaT());

                        ball2.setvX(tempX);
                        ball2.setvY(tempY);
                        ball2.setdeltaT(tempT);
                        break;
                    }
                   
                }
               
            }

            for (Ball ball : balls) {
                ball.move();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(BouncingBalls.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
