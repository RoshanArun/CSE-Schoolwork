package LAB;

/*-------------------------------------------------------------------------
 // AUTHOR: Roshan Arun 
 // FILENAME: Lab2.java
 // SPECIFICATION: Gather a first and last name from a user, then return their full name capitalized, as well as the name length, and strings comparison methods.
 // FOR: CSE 110- Lab #2
 // TIME SPENT: 20 minutes
 //-----------------------------------------------------------*/
import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// declare varibles of different types:
		String firstName = "";
		String lastName = "";
		String fullName = "";
		int nameLength = 0;
		Scanner scan = new Scanner(System.in);

		// Use Scanner to ask the user for first name
		System.out.println("Enter your first name: ");
		firstName = scan.nextLine();

		// Use Scanner to ask the user for last name
		System.out.println("Enter your last name: ");
		lastName = scan.nextLine();

		// Add firstName to lastName variables using "+" sign, don't forget the space
		// Store result in fullName variable
		fullName = firstName + " " + lastName;

		// convert fullName variable to upper case
		fullName = fullName.toUpperCase();

		// Find the length of fullName and store it in nameLength variable
		nameLength = fullName.length();

		// Print fullName, should be all upper case
		System.out.println("Full name (in capitals): " + fullName);

		// Print nameLength, this should be number of characters in "fullName" variable,
		// including space
		System.out.println("Length of full name: " + nameLength);

		// Define two String variables, title1 and title2 using String constructor to
		// initialize them
		String title1 = new String("cse110");
		String title2 = "cse110";

		// Compare the two strings and print which one of the two ways works
		if (title1 == title2) {
			System.out.println("String comparison using \"==\" sign works");
		} else {
			System.out.println("String comparison using \"==\" sign does NOT work");
		}

		if (title1.equals(title2)) {
			System.out.println("String comparison using \"equals\" method works");
		} else {
			System.out.println("String comparison using \"equals\" method does NOT work");
		}

		scan.close();
	}
}
