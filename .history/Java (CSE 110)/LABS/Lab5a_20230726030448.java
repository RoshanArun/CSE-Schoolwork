package LABS;

//-----------------------------------------------------------
// AUTHOR: Roshan Arun 
// FILENAME: Lab5a.java 
// SPECIFICATION: This assignment is to debug a program that gives multiple options, and does something based on input
// FOR: CSE 110 - Lab #5
// TIME SPENT: 30 minutes 
//-----------------------------------------------------------
import java.util.Scanner;

public class Lab5a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char choice;
		do {
			System.out.println("Please choose from following menu:"
					+ "\na) Print a sentence word by word and then backwards."
					+ "\nb) Operations on a proper name."
					+ "\nc) Makes the first and third word of a given sentence uppercase."
					+ "\nq) Quit.");
			// Use scanner to collect user input
			choice = in.nextLine().charAt(0);
			switch (choice) {
				case 'a': {
					// TODO:Fix Task 1 - takes input sentence, prints it word by word and then
					// prints it backwards
					System.out.print("Please enter a sentence: ");
					String userSentence = in.nextLine();
					String test[] = userSentence.split(" ");
					int numOfWords = test.length;
					System.out.println("There are " + numOfWords + " words in the sentence");

					String tempString;
					String finalString = "";
					for (int i = 0; i < numOfWords; i++) {
						tempString = test[i];
						System.out.println("Word " + i + ": " + tempString);
						finalString = finalString + " " + test[numOfWords - 1 - i];
					}

					System.out.println("The sentence backwards is: " + finalString + "\n");
					break;
				}
				case 'b': {
					// TODO: operations on a proper name
					int characterCount = 0;
					String properName = "";
					String firstName = "";
					String middleName = "";
					String lastName = "";
					char firstInitial = '?';
					char middleInitial = '?';
					String lastNameFirst = "";
					String shortForm = "";
					int indexOfFirstSpace = 0;
					int indexOfLastSpace = 0;

					// collect input
					System.out.print("Enter a proper name consisting of a first, middle, and last name: ");
					properName = in.nextLine();

					// compute required values
					indexOfFirstSpace = properName.indexOf(" ");
					indexOfLastSpace = properName.lastIndexOf(" ");
					firstName = properName.substring(0, indexOfFirstSpace);
					firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase(); // first
																												// letter
																												// of
																												// name
																												// to
																												// uppercase
																												// (do
																												// this
																												// to
																												// all
																												// three
																												// names)
					middleName = properName.substring(indexOfFirstSpace + 1, indexOfFirstSpace + 2).toUpperCase()
							+ properName.substring(indexOfFirstSpace + 2, indexOfLastSpace).toLowerCase();
					lastName = properName.substring(indexOfLastSpace + 1, indexOfLastSpace + 2).toUpperCase()
							+ properName.substring(indexOfLastSpace + 1, properName.length()).toLowerCase();
					characterCount = firstName.length() + middleName.length() + lastName.length();
					firstInitial = firstName.charAt(0);
					middleInitial = middleName.charAt(0);
					lastNameFirst = lastName + ", " + firstName + " " + middleName;
					shortForm = firstInitial + ". " + middleInitial + ". " + lastName;

					// output results
					System.out.println();
					System.out.println("Total characters    : " + characterCount);
					System.out.println("First name          : " + firstName);
					System.out.println("Middle name         : " + middleName);
					System.out.println("Last name           : " + lastName);
					System.out.println("First initial       : " + firstInitial);
					System.out.println("Middle initial      ; " + middleInitial);
					System.out.println("Last name first     : " + lastNameFirst);
					System.out.println("Short form          : " + shortForm);
					System.out.println();
					break;
				}
				case 'c': {
					// TODO: Task 3 - takes a given sentence and makes the first and third word in
					// it uppercase
					String givenSentence = "this is the given sentence";
					String finalSentence = "";
					System.out.println("\n" + givenSentence);
					String[] newSplStrings = givenSentence.split(" ");
					for (int j = 0; j < newSplStrings.length; j++) {
						if (j % 2 == 0 && j < 3)
							newSplStrings[j] = newSplStrings[j].toUpperCase();
						finalSentence = finalSentence + newSplStrings[j] + " ";
					}
					System.out.println(finalSentence + "\n");
					break;
				}
			}
		} while (choice == 'a' || choice == 'b' || choice == 'c'); // a or b or c
		in.close();
	}
}
