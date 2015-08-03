/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.awt.Color;

/**
 *
 * @author JakeYang
 */
public class Ball {

    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double radius;
    private double deltaT;
    private Color colour;

    public void setpX(double positionX) {
        this.positionX = positionX;
    }

    public double getpX() {
        return positionX;
    }

    public void setpY(double positionY) {
        this.positionY = positionY;
    }

    public double getpY() {
        return positionY;
    }

    public void setvX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getvX() {
        return velocityX;
    }

    public void setvY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getvY() {
        return velocityY;

    }

    public void setradius(double radius) {
        this.radius = radius;
    }

    public double getradius() {
        return radius;
    }

    public void setdeltaT(double deltaT) {
        this.deltaT = deltaT;
    }

    public double getdeltaT() {
        return radius;
    }

    public void setcolor(Color colour) {
        this.colour = colour;
    }

    public Color getcolor() {
        return colour;
    }

    public void move() {
        positionX += velocityX * deltaT;
        positionY += velocityY * deltaT;
    }

    @Override
    public String toString() {
        return "postion(" + positionX + positionY + "),velocity(" + velocityX + velocityY + "),deltaT(" + deltaT + "),radius(" + radius + ")";
    }

    public static void main(String[] args) {
        int interation = -1;
        Ball ball = new Ball();
        ball.setpX(16 + 480 * Math.random());
        ball.setpY(16 + 480 * Math.random());
        ball.setvX(10 + 5 * Math.random());
        ball.setvY(10 + 5 * Math.random());
        ball.setcolor(Color.getHSBColor((float) Math.random(), 1.0f, 1.0f));
        ball.setradius(20);
        ball.setdeltaT(1.0f);
        while (interation++ < 100) {
            System.out.println(ball);
            ball.move();
        }
    }

}
