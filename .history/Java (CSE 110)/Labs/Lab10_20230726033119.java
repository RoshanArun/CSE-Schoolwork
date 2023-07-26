package Labs;

//-------------------------------------------------------------------------
// AUTHOR: Roshan Arun
// FILENAME: Lab10.java
// SPECIFICATION: Create a clas that sorts arrays
// FOR: CSE 110- Lab #10
// TIME SPENT: 20 min
//-------------------------------------------------------------------------
import java.util.Scanner;

public class Lab10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int arraySize = 0;
		double exchange;

		System.out.print("How many elements is in the array? ");
		arraySize = scan.nextInt();
		double[] array = new double[arraySize];

		for (int i = 0; i < arraySize; i++) {
			System.out.print("Please enter the next value: ");
			exchange = scan.nextDouble();
			array[i] = exchange;
		}

		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
				if (array[i] < array[j]) {
					double temp = 0;
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		System.out.println("\nThe array after SORT:");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n");

		for (int i = 0; i < arraySize - 1; i++) {
			array[i] = array[i + 1];
		}
		array[arraySize - 1] = 0;

		System.out.println("The array after shifting to the left:");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n");

		System.out.print("Enter the element to zero out in the array if found: ");
		double search_element = scan.nextDouble();
		double element_found_flag = 0.;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == search_element) {
				element_found_flag = 1;
				array[i] = 0;
				System.out.println("Search element(s) found - zeroing out.");
			}
		}

		if (element_found_flag == 0) {
			System.out.println("Search element not found.");
		}

		System.out.print("Final Array: ");
		for (int j = 0; j < arraySize; j++) {
			System.out.print(array[j] + ", ");
		}
		System.out.println();
		scan.close();
	}
}
