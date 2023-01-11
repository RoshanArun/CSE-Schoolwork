package HW5;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Homework 05 Paint App
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description -Cirlce class, creates a circle
 */

// constructor

public class Circ extends Shape {
    public Circ(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public void draw(Graphics g) {
        g.setColor(g.getColor());
        g.fillOval(getX(), getY(), getWidth(), getWidth());
    }
}
