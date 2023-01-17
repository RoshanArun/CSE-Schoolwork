package edu.ser222.m01_02;

import java.lang.Object;
import java.awt.geom.Point2D;

public class point2DTesting {

	// Main Method
	public static void main(String args[]) {

		// Create a point2D object
		Point2D point2d_1 = new Point2D(0, 5);

		double x, y;

		// get the coordinates of the point
		x = point2d_1.getX();
		y = point2d_1.getY();

		// display the coordinates of the point
		System.out.println("x coordinate = " + x + ", y coordinate = " + y);

		// print its distance from origin
		System.out.println("distance from origin = " + point2d_1.distance(0, 0));
	}
}