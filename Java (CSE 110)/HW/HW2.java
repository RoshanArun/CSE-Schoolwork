package HW;
// STUDENT NAME: Roshan Arun 
// FILENAME: HW2.java
// SPECIFICATION: Write a program that asks for 3 user input strings, and returns them in alphabetical order (lexigraphically)
// FOR: CSE 110- Homework Assignment #2
// TIME SPENT: 30 minutes
// DATE: 9/21/2021

import java.util.Scanner;

public class HW2 {
	public static void main(String[] ar

		 
		//create a Scanner object to get input

				 
		//declare variables
		String str1 = "";
		String str2 = "";

		 
		//get user inputs
		System.out.println("Ent

				
		System.out.println("Ent

				
		System.out.println("Ent

		 
		// Comparing strings lexographically using compareTo funciton
		if( str1.compareTo(str2) < 0) {
				f(str1.compareTo(str3) < 0) {				
				Sy stem.out.println(str1);
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
		els e if(str2.compareTo(str1) < 0) {
			if(str2.compareTo(str3) < 0) {
				Sy stem.out.println(str2);
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
