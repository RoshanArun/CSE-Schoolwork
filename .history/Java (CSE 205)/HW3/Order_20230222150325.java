package HW3;

/**
 * Homework 03 Listeners
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - Order class, constructor, and a few methods for
 *         the object
 */

public class Order {
	private String name;
	private int num;
	private double price;

	// constructor
	public Order(String n, int nn, double p) {
		name = n;
		num = nn;
		price = p;
	}

	/**
	 * @return String
	 */
	// simple return methods
	public String getName() {
		return name;
	}

	public int getQuan() {
		return num;
	}

	public double getPrice() {
		return price;
	}

	public String calc() {
		double num2 = getPrice() * getQuan();
		return String.valueOf(num2);
	}

	public String toString() {
		return "Name: " + getName() + "\nQuantity: " + getQuan() + "\nPrice: " + getPrice() + "\nTotal Cost: " + calc()
				+ "\n\n";
	}
}
