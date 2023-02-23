package HW1;

/**
 * Homework 01 Polymorphism
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - subclass of order, has a specific constructor and
 *         total cost
 */
public class ShippedOrder extends Order1 {
	// instance variables
	private String shippingAddress;
	private String wayOfShipping;
	private double shippingFee = 0;

	// constructor
	public ShippedOrder(String name, int num, double price, String address, String way) {
		super(name, num, price);
		shippingAddress = address;
		wayOfShipping = way;
	}

	// shipping fee function, calculates the shipping fee
	public void setShippingFee() {
		if (wayOfShipping.equals("Economy")) {
			shippingFee = (unitPrice * quantity) * .06;
		} else if (wayOfShipping.equals("Regular")) {
			shippingFee = (unitPrice * quantity) * .08;
		} else {
			shippingFee = (unitPrice * quantity) * .12;
		}
	}

	// calculatoes the total cost
	public void computeTotalCost() {
		setShippingFee();
		totalCost = (unitPrice * quantity);
		totalCost = totalCost + shippingFee;
	}

	/**
	 * @return String
	 */
	// tostring method
	public String toString() {
		return "\n***Shipped Order" + "\nProduct Name: " + productName + "\nQuantity: " + quantity + "\nUnit Price: "
				+ unitPrice + "\nTotal Cost: " + totalCost + "\nShipping Address: " + shippingAddress
				+ "\nShipping Way: " + wayOfShipping + "\nShipping Fee: " + shippingFee;
	}
}
