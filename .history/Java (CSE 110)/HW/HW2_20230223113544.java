// STUDENT NAME: Roshan Arun 
// FILENAME: HW2.java
// SPECIFICATION: Write a program that asks for 3 user input strings, and returns them in alphabetical order (lexigraphically)
// FOR: CSE 110- Homework Assignment #2
// TIME SPENT: 30 minutes
// DATE: 9/21/2021

import java.util.Scanner;

public class HW2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create a Scanner object to get input from the keyboard
		Scanner scan = new Scanner(System.in);
				
		//declare variables
		String str1 = "";
		String str2 = "";
		String str3 = "";
		
		//get user inputs
		System.out.println("Enter string 1: ");
		str1 = scan.nextLine();
				
		System.out.println("Enter string 2: ");
		str2 = scan.nextLine();
				
		System.out.println("Enter string 3: ");
		str3 = scan.nextLine();
		
		//Comparing strings lexographically using compareTo funciton
		if(str1.compareTo(str2) < 0) {
			if(str1.compareTo(str3) < 0) {				
				System.out.println(str1);
				if(str2.compareTo(str3) < 0) {
					System.out.println(str2);
					System.out.println(str3);
				}else {
					System.out.println(str3);
					System.out.println(str2);
				}
			}else {
				System.out.println(str3);
				System.out.println(str1);
				System.out.println(str2);
			}
		}
		else if(str2.compareTo(str1) < 0) {
			if(str2.compareTo(str3) < 0) {
				System.out.println(str2);
				if(str1.compareTo(str3) < 0) {
					System.out.println(str1);
					System.out.println(str3);
				}else {
					System.out.println(str3);
					System.out.println(str1);
				}
			}else {
				System.out.println(str3);
				System.out.println(str2);
				System.out.println(str1);
			}
		}
		scan.close();
	}
}
