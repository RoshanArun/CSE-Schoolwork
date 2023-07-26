package LAB;

// AUTHOR: Roshan arun 
// FILENAME: Lab1.java
// SPECIFICATION: Takes three user input numbers, and return the average 
// FOR: CSE 110- Lab #1
// TIME SPENT: 10 minutes
import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create a Scanner object to get input from the keyboard
		Scanner scan = new Scanner(System.in);

		// declare variables
		int testOne;
		int testTwo;
		int testThree;
		double avgScore;
		final int NUM_TESTS = 3;

		// get the input
		System.out.println("Enter the score on the first test: ");
		testOne = scan.nextInt();

		System.out.println("Enter the score on the second test: ");
		testTwo = scan.nextInt();

		System.out.println("Enter the score on the third test: ");
		testThree = scan.nextInt();

		// calculate the average
		avgScore = (double) (testOne + testTwo + testThree) / NUM_TESTS;

		// display the results
		System.out.println("Your average score is: " + avgScore);

		// free up used resources
		scan.close();
	}

}