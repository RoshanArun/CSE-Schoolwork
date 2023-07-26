package Labs;
//-----------------------------------------------------------

// AUTHOR: Roshan Arun 
// FILENAME: Lab4.java 
// SPECIFICATION: This assignment gets the sum of integers, the factorial of a given number and the first digit of a given number while utilize loops, and a switch statement. The numbers are all user inputs. 
// FOR: CSE 110 - Lab #4
// TIME SPENT: 30 minutes 
//-----------------------------------------------------------

import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		char choice = 'q';

		do {
			System.out.println("Please choose from the following menu:");
			System.out.println("a) Calculate the sum of the integers from m to n.");
			System.out.println("b) Calculate the factorial of a given number.");
			System.out.println("c) Display the first digit of a given number.");
			System.out.println("q) Quit.");
			choice = scan.next().charAt(0);

			switch (choice) {
				case 'a':
					int m, n, sum = 0;

					System.out.print("Enter the starting number: ");
					m = scan.nextInt();

					System.out.print("Enter the ending number: ");
					n = scan.nextInt();
					int count = m;

					while (count <= n) {
						sum = sum + count;
						count++;
					}

					System.out.println("");
					System.out.println("The sum of integers from " + m + " to " + n + " is: " + sum);
					System.out.println("");
					break;

				case 'b':
					n = 0;
					int fact = 1;

					System.out.print("Enter the number: ");
					n = scan.nextInt();
					int count2 = fact;

					while (count2 <= n) {
						fact = fact * count2;
						count2++;
					}

					System.out.println("");
					System.out.println("The factorial of " + n + " is " + fact);
					System.out.println("");
					break;

				case 'c':
					int number = 0;
					int remainder = 1;

					System.out.print("Enter the number: ");
					number = scan.nextInt();
					while (number != 0) {
						remainder = number % 10;
						number = number / 10;
					}

					System.out.println("");
					System.out.println("The 1st integer of this number is " + remainder);
					System.out.println("");
					break;
				default:
					break;
			}
		} while (choice != 'q');
		scan.close();
	}
}
