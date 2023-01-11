package HW1;

/**
 * Homework 01 Polymorphism
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - subclass of order, specific constructor and cost
 *         computations
 */
public class NewOrder extends Order1 {
	// instance varibles
	private String salesName;
	private boolean refundableStatus;

	// constructor
	public NewOrder(String name, int num, double price, String sName, boolean refund) {
		super(name, num, price);
		refundableStatus = refund;
		salesName = sName;
	}

	// computes total cost of a new order
	public void computeTotalCost() {
		totalCost = totalCost + (unitPrice * quantity);
		if (refundableStatus == true) {
			totalCost = totalCost + (totalCost * .106);
		} else {
			totalCost = totalCost + (totalCost * .086);
		}
	}

	// to string method
	public String toString() {
		return "\n***New Order" + "\nProduct Name: " + productName + "\nQuantity: " + quantity + "\nUnit Price: "
				+ unitPrice + "\nTotal Cost: " + totalCost + "\nSales Name: " + salesName + "\nRefund Status: "
				+ refundableStatus;
	}
}
