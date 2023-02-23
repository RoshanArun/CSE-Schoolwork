package HW5;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Homework 05 Paint App
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - Arc class, creates an arc
 */
// constructor

public class Arc extends Shape {
    public Arc(int x, int y, int width, int height, Color color, int Start, int arc) {
        super(x, y, width, height, color);
    }

    public void draw(Graphics g) {
        double anglelnRadians = Math.atan2(-getY(), getX());
        double length = Math.toDegrees(anglelnRadians);
        g.setColor(g.getColor());
        g.fillArc(getX(), getY(), getWidth(), getHeight(), (int) anglelnRadians, (int) length);
    }
}