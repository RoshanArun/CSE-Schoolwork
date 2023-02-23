
// STUDENT NAME: Roshan arun 
// FILENAME: HW1.java
// SPECIFICATION: Write a program that asks for 3 user inputs, and computes the present value of an annuity for the values. 
// FOR: CSE 110- Homework Assignment #1
// TIME SPENT: 20 minutes
// DATE: 9/12/2021
import java.util.Scanner;

public class HW1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create a Scanner object to get input from the keyboard
		Scanner scan = new Scanner(System.in);

		// declare variables
		double pmt;
		double i;
		double n;
		double pvann;

		// get the user input
		System.out.println("Enter the periodic payment (PMT): ");
		pmt = scan.nextDouble();

		System.out.println("Enter the interest rate (i): ");
		i = scan.nextDouble();

		System.out.println("Enter the number of payments (n): ");
		n = scan.nextDouble();

		// calculate annuity\
		pvann = pmt * (1 + (1 - (Math.pow((1 + i), -n))) / i);

		System.out.println(pvann);
		scan.close();
	}
}
