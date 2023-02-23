
// ------------------------------------------------------------
// AUTHOR: Roshan Arun 
// FILENAME: Lab5.java
// SPECIFICATION: Take user input to print a series of consecutive numbers, as well as a right triangle, length is decided by user input
// FOR: CSE 110- Lab #5 
// TIME SPENT: 30 minutes
//-------------------------------------------------------------
import java.util.Scanner;

public class Lab5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		char choice = ' ';

		do {
			System.out.println("Please choose from the following menu:");
			System.out.println("a) Print through all integer numbers between two given integers.");
			System.out.println("b) Generate a right triangular pattern of stars.");
			System.out.println("q) Quit.");

			choice = scan.next().charAt(0);

			switch (choice) {
				case 'a':
					int start = 0;
					int end = 0;
					int count = 0;

					System.out.print("Enter the start number: ");
					start = scan.nextInt();

					System.out.print("Enter the end number: ");
					end = scan.nextInt();
					System.out.println("\n");

					for (count = start; count <= end; count++) {
						System.out.print(count + " ");
					}
					System.out.println("\n\n");
					break;

				case 'b':
					int height = 0;
					System.out.print("Enter the height: ");
					height = scan.nextInt();
					System.out.println("");

					for (int i = 0; i <= height; i++) {
						for (int j = 0; j < i; j++) {
							System.out.print("*");
						}
						System.out.println("");

					}
					System.out.println("\n");

					break;

				case 'q':

					break;

				default:

					break;
			}
		} while (choice != 'q');
		scan.close();
	}
}