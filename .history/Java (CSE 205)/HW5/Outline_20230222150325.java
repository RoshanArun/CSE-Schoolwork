package HW5;

import java.awt.Color;
import java.awt.Graphics;

public class Outline extends Shape {
	public Outline(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	/**
	 * @param g
	 */
	public void draw(Graphics g) {
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}
}
