package LABS;

//-----------------------------------------------------------
// AUTHOR: Roshan Arun 
// FILENAME: Student.java 
// SPECIFICATION: Create a student, create multiple constructors, and functions for the student 
// FOR: CSE 110 - Lab #8
// TIME SPENT: 20 minutes 
//-----------------------------------------------------------
public class Lab8 {
	// declare instance variables...
	// a string called studentMajor
	String studentMajor;
	int studentCredits;
	int studentPoints;
	String firstName;
	String lastName;

	public Lab8(String fName, String lName) {
		firstName = fName;
		lastName = lName;
		this.studentMajor = "General Studies";
		this.studentPoints = 0;
		this.studentCredits = 0;
	}

	public Lab8(String major, int credits, int points, String fName, String lName) {
		studentMajor = major;
		studentCredits = credits;
		studentPoints = points;
		firstName = fName;
		lastName = lName;
	}

	public String getMajor() {
		return studentMajor;
	}

	public int getGradePoints() {
		return studentPoints;
	}

	public int getCredits() {
		return studentCredits;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void changeMajor(String newMajor) {
		studentMajor = newMajor;
	}

	public void loopHelper(int start, int end, int incBy) {
		int sum = 0;

		for (int i = start; i < end; i = i + incBy) {
			System.out.print(" " + i);
			sum = sum + i;
		}
		System.out.println("\nSum is " + sum);
	}
}
