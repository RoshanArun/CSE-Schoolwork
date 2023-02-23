package HW3;

/**
 * Homework 03 Listeners
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - container for the order objects
 */

public class OrderContainer {
	public static Order[] order = new Order[100];
	private static int position = 0;

	/**
	 * @param s
	 */
	// adds a order to array
	public static void addOrder(Order s) {
		if (position <= 99) {
			order[position] = s;
			position++;
		}
	}

	// gets the order
	public static Order getOrder(int index) {
		if (position <= 100)
			return order[index];
		return null;
	}

	// returns position
	public static int getPosition() {
		return position;
	}

}
