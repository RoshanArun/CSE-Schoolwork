
// ------------------------------------------------------------
// AUTHOR: Roshan Arun 
// FILENAME: Lab6.java
// SPECIFICATION: write a method in order to create a Person class
// FOR: CSE 110- Lab #6 
// TIME SPENT: 30 minutes
//-------------------------------------------------------------
import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String f;
		String l;
		int y;
		int z;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the first name of the person: ");
		f = scan.nextLine();

		System.out.print("Enter the last name of the person: ");
		l = scan.nextLine();

		System.out.print("Enter the birth year of the person: ");
		y = scan.nextInt();

		System.out.print("Enter a year: ");
		z = scan.nextInt();

		Person one;
		one = new Person(f, l, y);

		System.out.println("\n" + one.getFirstName() + " " + one.getLastName() + " \nYear of birth: "
				+ one.getBirthYear() + "\nAge in year " + z + ": " + one.getAge(z) + " years");
		scan.close();
	}

	static class Person {

		String firstName;
		String lastName;
		int birthYear;

		public Person(String fname, String lname, int year) {
			firstName = fname;
			lastName = lname;
			birthYear = year;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public int getBirthYear() {
			return birthYear;
		}

		public int getAge(int year) {
			year = year - birthYear;
			return year;
		}

	}
}
