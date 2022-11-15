//-----------------------------------------------------------
// AUTHOR: Roshan
// FILENAME: Lab3.java 
// SPECIFICATION: create a program that calculates the final grade of the student, when given valid inputs 
// FOR: CSE 110- Lab #3 
// TIME SPENT: 30 minutes 
//-----------------------------------------------------------

import java.util.Scanner; 

public class Lab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declaring variables: 
		double finalexamGrade = 50.0; 
		double midtermGrade = 50.0; 
		double homeworkGrade = 0.0; 
		double finalGrade = 0.0; 
		
		// a character called letterGrade 
		char letterGrade = ' '; 
		
		// a variable scan of type Scanner 
		Scanner scan = new Scanner(System.in); 
		
		//Print a statement to the user asking for student's homework grade 
		System.out.println("Enter Homework grade: ");
		homeworkGrade = scan.nextDouble();
		
		System.out.println("Enter Midterm grade: ");
		midtermGrade = scan.nextDouble();
		
		System.out.println("Enter Final Exam grade: ");
		finalexamGrade = scan.nextDouble();
		
		if(homeworkGrade >= 0 && homeworkGrade <= 100 && midtermGrade >= 0 && midtermGrade <= 100 && finalexamGrade >= 0 && finalexamGrade <= 200) {
			finalGrade = 100 * (.5 * finalexamGrade/200 + midtermGrade * .25/100 + homeworkGrade * .25/100);
			if(finalGrade >= 50) {
				letterGrade = 'p';
				System.out.println("Overall score: " + finalGrade);
				System.out.println("Student Passed!");
			}else {
				letterGrade = 'f';
				System.out.println("Overall score: " + finalGrade);
				System.out.println("Student Failed.");
			}
			
		}else if(homeworkGrade < 0 || homeworkGrade > 100){
			System.out.println("INVALID input: Homework Grade should be between 0 and 100.");

			if(midtermGrade < 0 || midtermGrade > 100) {
				System.out.println("INVALID input: Midterm Grade should be between 0 and 100.");
			}
			if(finalexamGrade < 0 || finalexamGrade > 200) {
				System.out.println("INVALID input: Final Grade should be between 0 and 200.");
			}
			System.out.println("Exiting program.");
			
		}else if(midtermGrade < 0 || midtermGrade > 100){
			System.out.println("INVALID input: Midterm Grade should be between 0 and 100.");
			if(finalexamGrade < 0 || finalexamGrade > 200) {
				System.out.println("INVALID input: Final Grade should be between 0 and 200.");
			}
			System.out.println("Exiting program.");
			
		}else {
			System.out.println("INVALID input: Final Grade should be between 0 and 200.");
			System.out.println("Exiting program.");
		}
		scan.close();
	}
}