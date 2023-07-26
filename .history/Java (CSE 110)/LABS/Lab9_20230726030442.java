package LABS;
//-------------------------------------------------------------------------

// AUTHOR: Roshan Arun
// FILENAME: Lab9.java
// SPECIFICATION: This implements the methods for the HW5.java file
// FOR: CSE 110- Lab #9
// TIME SPENT:  30 min
//-------------------------------------------------------------------------

import java.util.Scanner;

public class Lab9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		double value;
		double sum = 0.0;
		Scanner scan = new Scanner(System.in);

		System.out.print("How many elements in the array? ");
		size = scan.nextInt();

		double[] array = new double[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Please enter the next value. ");
			value = scan.nextDouble();
			array[i] = value;
		}

		for (int i = 0; i < size; i++) {
			if (i % 4 == 0 && i != 0) {
				System.out.println("");
			}
			System.out.printf("%.2f", array[size - 1 - i]);
			System.out.print(" ");

			sum = sum + array[size - 1 - i];
		}

		System.out.println("\nThe sum of the array's elements is: " + sum);
		scan.close();
	}
}
