package HW1;

/**
 * Homework 01 Polymorphism
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - subclass of order, specific constructor and
 *         computation of cost
 */
public class CancelledOrder extends Order1 {
	// instance variables
	private String cancelledDate;
	private String cancelledReason;

	// constructor
	public CancelledOrder(String name, int num, double price, String date, String reason) {
		super(name, num, price);
		cancelledDate = date;
		cancelledReason = reason;
	}

	// computes total cost
	public void computeTotalCost() {
		totalCost = ((unitPrice * quantity) * .02);
	}

	/**
	 * @return String
	 */
	// to string method
	public String toString() {
		return "\n***Cancelled Order" + "\nProduct Name: " + productName + "\nQuantity: " + quantity + "\nUnit Price: "
				+ unitPrice + "\nTotal Cost: " + totalCost + "\nCancel Date: " + cancelledDate + "\nCancel Reason: "
				+ cancelledReason;
	}
}
