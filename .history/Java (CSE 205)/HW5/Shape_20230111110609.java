package HW5;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Homework 05 Paint App
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - Shape class, abstract class for other shapes
 */

public abstract class Shape extends Main {
	private int x;
	private int y;
	private int width;
	private int height;
	Main main = new Main();
	Color color = Main.test;

	public Shape(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public abstract void draw(Graphics g);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Color setColor(Color color) {
		this.color = color;
		return color;
	}

	public Color getColor() {
		return color;
	}

}