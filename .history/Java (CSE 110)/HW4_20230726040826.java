// ------------------------------------------------------------
// STUDENT NAME: Roshan Arun
// FILENAME: HW4.java
// DESCRIPTION: Generate math problems for the user using the random method
// FOR: CSE 110 - Homework #4
// TIME SPENT: 45 minutes
// DATE: 10/05/2021
//-------------------------------------------------------------

import java.util.Scanner;
import java.util.Random;

public class HW4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long seed = 1;
		int problems;
		int ans = 1;
		int right = 0;
		int issue = 0;
		System.out.print("Enter a seed for the random number generator. ");
		seed = scan.nextLong();
		Random rng = new Random(seed);

		System.out.print("How many multiplication problems would you like (1 to 10)? ");
		problems = scan.nextInt();

		for (int i = 1; i <= problems; i++) {
			int digit1 = rng.nextInt(13) + 1;
			int digit2 = rng.nextInt(13) + 1;
			System.out.print("\nProblem " + i + ":" + " what is " + digit1 + " * " + digit2 + "? ");
			int wrong = 0;

			while (wrong < 3) {
				ans = scan.nextInt();

				System.out.println("Your Answer --> " + ans);

				if (ans == digit1 * digit2) {
					System.out.println(ans + " is correct.");
					wrong = 3;
					right = right + 1;

				} else if (ans != digit1 * digit2) {
					System.out.println(ans + " is incorrect.");
					wrong = wrong + 1;
					issue = issue + 1;

					if (wrong == 3) {
						System.out.println("The correct answer is " + digit1 * digit2 + ".");
					}
				}
			}
		}
		System.out.println("\nyou gave " + right + " correct answers and " + issue + " incorrect answers.");
		scan.close();
	}
}