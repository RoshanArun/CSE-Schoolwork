//-------------------------------------------------------------------------
// AUTHOR: Roshan Arun
// FILENAME: GradeBook.java
// SPECIFICATION: This implements the methods for the HW8.java file
// FOR: CSE 110- HW #8
// TIME SPENT:  120 min
//-------------------------------------------------------------------------
import java.io.IOException;  
import java.io.File;
import java.util.Scanner;

public class GradeBook {
	
	public final int NUM_TESTS = 4;
	private int numStudents;
	private String[] names;
	private char[] letter;
	private double[][] scores;
	
	public GradeBook(String fileName) throws IOException{
		File one = new File(fileName);
		Scanner scan = new Scanner(one);
		
		//stores num of students 
		numStudents = scan.useDelimiter("[^0-9]+").nextInt();
		scan.close();
		
		//stores names into array 
		scan = new Scanner(one);
		names = new String[numStudents];
		String lineOfText = scan.nextLine();
		
		if(lineOfText.startsWith("Count")) {
			names[0] = names[0];
		}
		
		for(int i = 0; i < numStudents; i++) {
			String test = scan.useDelimiter("[^A-Za-z]+").next();;
			names[i] = test;	
		}
		
		scan.close();
		
			
		//2d array of size x NUM_TESTS
		scan = new Scanner(one);
		scores = new double[numStudents][NUM_TESTS];
		
		lineOfText = scan.nextLine();
		if(lineOfText.startsWith("Count")) {
			names[0] = names[0];
		}
		
		for(int i = 0; i < numStudents; i++) {
			for(int j = 0; j < NUM_TESTS * 2; j++) {
				double test = scan.useDelimiter("[^0-9]+").nextDouble();;
				if(j % 2 == 0) {
					scores[i][j / 2] = test;
				}
			}
		}		
		
		scan.close();
		
		//stores final grade letter of each student
		letter = new char[numStudents];
		assignGrades();
	
		}
		
		private double GetStudentAverage(int index) {
			double temp = 0;
			double avg = 0;;
			int i = 0;
			if(scores[index][i] < scores[index][i + 1] && scores[index][i] < scores[index][i + 2] && scores[index][i] < scores[index][i + 3]) {
				temp = scores[index][i];
			}else if (scores[index][i + 1] < scores[index][i + 2] && scores[index][i + 1] < scores[index][i + 3] && scores[index][i + 1] < scores[index][i]) {
				temp = scores[index][i + 1];
			}else if (scores[index][i + 2] < scores[index][i + 3] && scores[index][i + 2] < scores[index][i] && scores[index][i + 2] < scores[index][i + 1]) {
				temp = scores[index][i + 2];
			}else {
				temp = scores[index][3];
			}
			
			for(int j = 0; j < NUM_TESTS; j++) {
				if(scores[index][j] != temp) {
					avg = avg + scores[index][j];
				}
			}
			int scale = (int) Math.pow(10, 1);
			avg = avg / 3;
		    return (double) Math.round(avg * scale) / scale;
		}
		
		private void assignGrades() {
			char one = 'a';
			for(int i = 0; i < numStudents; i++) {
				if(GetStudentAverage(i) >= 90 && GetStudentAverage(i) <= 100) {
					one = 'A';
					letter[i] = one;
				}else if(GetStudentAverage(i) >= 80 && GetStudentAverage(i) < 90) {
					one = 'B';
					letter[i] = one;
				}else if(GetStudentAverage(i) >= 70 && GetStudentAverage(i) < 80) {
					one = 'C';
					letter[i] = one;
				}else if(GetStudentAverage(i) >= 60 && GetStudentAverage(i) < 70) {
					one = 'D';
					letter[i] = one;
				}else {
					one = 'F';
					letter[i] = one;
				}
			}
		}
//			
		public String getStudentName(int index){
			return names[index];
		}
		
		public char getLetterGrade(int index) {
			if(index != -1) {
				return letter[index];
			}else {
				return ' ';
			}
		}
		
		public int getIndex(String studentName) {
			int test = 0;
			for(int i = 0; i < numStudents; i++) {
				if(names[i].equals(studentName)) {
					test = i;
				}
			}
			if(test > 0) {
				return test;
			}else {
				return -1;
			}
		}
		
		public String toString() {
			String test = "";
			double num = 0.0;
			char let = 'a';
			String all = ""; 
			String space = "";
			
			
			
			for(int i = 0; i < numStudents; i++) {
				space = "";
				for(int j = 0 ; j < 14 - names[i].length(); j++) {
					space = space + " ";
				}
				test = names[i];
				num = GetStudentAverage(i);
				let = getLetterGrade(i);
				all = all + test + space + num + "  " + let + "\n";
			}
			return all;
		}
	
	}

