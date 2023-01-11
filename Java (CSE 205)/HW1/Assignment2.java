package HW1;

/**
 * Homework 01 Polymorphism
 * Student ID # 1221911327
 * @author Roshan Arun
 * Lecture Time - 10:30-11:45
 * Class Description - this is the main method class, in this class all the order classes are tested
 */

import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args) {
		// variables that need to be created
		Order1[] empty = new Order1[100];

		Scanner scan = new Scanner(System.in);
		Scanner test = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		char choice = ' ';
		int i = 0;

		do {
			// choice list
			System.out.println("\n***Choice Action");
			System.out.println("A) Add an Order");
			System.out.println("B) Compute Total Costs");
			System.out.println("C) Search for an Order");
			System.out.println("D) List Orders");
			System.out.println("E) Quit");
			System.out.println("\nWhat action would you like to perform?");

			choice = scan.next().toLowerCase().charAt(0);

			switch (choice) {
				case 'a':

					String name = " ";
					String num = " ";
					String pri = " ";
					String sName = " ";
					String refund = " ";

					String choice2 = "";

					System.out.println("Please enter the type of order (Cancelled, Shipped, New):");
					choice2 = test.nextLine().toLowerCase();

					// input information for a new order
					if (choice2.equals("new")) {
						System.out.print("Product Name: ");
						name = test.nextLine();

						System.out.print("Quantity: ");
						num = test.nextLine();
						int number2 = Integer.parseInt(num);

						System.out.print("Unit Price: ");
						pri = test.nextLine();
						double price2 = Double.parseDouble(pri);

						System.out.print("Sales Name: ");
						sName = test.nextLine();

						System.out.print("Refund Status: ");
						refund = test.nextLine();
						boolean bool = Boolean.parseBoolean(refund);

						empty[i] = new NewOrder(name, number2, price2, sName, bool);
						i++;

						// input information for a shipped order
					} else if (choice2.equals("shipped")) {
						System.out.print("Product Name: ");
						name = test.nextLine();

						System.out.print("Quantity: ");
						num = test.nextLine();
						int number = Integer.parseInt(num);

						System.out.print("Unit Price: ");
						pri = test.nextLine();
						double price = Double.parseDouble(pri);

						System.out.print("Address: ");
						sName = test.nextLine();

						System.out.print("Way Of Shipping: ");
						refund = test.nextLine();

						empty[i] = new ShippedOrder(name, number, price, sName, refund);
						i++;

						// input information for a cancelled order
					} else if (choice2.equals("cancelled")) {
						System.out.print("Product Name: ");
						name = test.nextLine();

						System.out.print("Quantity: ");
						num = test.nextLine();
						int number = Integer.parseInt(num);

						System.out.print("Unit Price: ");
						pri = test.nextLine();
						double price = Double.parseDouble(pri);

						System.out.print("Date: ");
						sName = test.nextLine();

						System.out.print("Reason for Cancelling: ");
						refund = test.nextLine();

						empty[i] = new CancelledOrder(name, number, price, sName, refund);
						i++;
					}
					break;

				// computes total cost of all objects
				case 'b':
					for (int j = 0; j < i; j++) {
						empty[j].computeTotalCost();
					}
					System.out.println("Total costs computed.");
					break;

				// searches for a specific product in the array
				case 'c':
					String search = " ";
					System.out.println("Please enter a product name to search: ");
					search = test.nextLine();

					int one = 0;
					for (int j = 0; j < i; j++) {
						if (search.equals(empty[j].getProductName())) {
							one = 1;
						} else {
							one = 0;
						}
					}

					if (one == 1) {
						System.out.println("Product Found!");
					} else {
						System.out.println("Product not found.");
					}
					break;

				// lists all objects and their information in the array
				case 'd':
					for (int j = 0; j < i; j++) {
						System.out.println(empty[j].toString());
					}

					if (i == 0) {
						System.out.println("No orders");
					}
					break;

				// quits the program
				case 'e':

					break;

				// prints unknown action is the action is not recognized
				default:
					System.out.println("Unknown action");
					break;
			}
		} while (choice != 'e');
		scan.close();
		scan2.close();
		test.close();
	}
}
