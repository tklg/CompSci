package labs_ch4;

//****************************************************************
//Student.java
//
//Define a student class that stores name, score on test 1, and
//score on test 2. Methods prompt for and read in grades, 
//compute the average, and return a string containing student’s info. 
//****************************************************************

import java.util.Scanner;
import villa7.Print;

public class Student {

	//declare instance data 
	String name;
	int testScore[] = new int[2];
	private Scanner s = new Scanner(System.in);
	private Print p = new Print();
	
	public Student(String studentName) {
	
		name = studentName;
		
	}
	
	//-----------------------------------------------
	//inputGrades: prompt for and read in student's grades for test1 and test2.
	//Use name in prompts, e.g., "Enter's Joe's score for test1".
	//-----------------------------------------------
	
	public void inputGrades() {
	
		p.nl("Enter grades for " + getName() + " (2)");
		testScore[0] = s.nextInt();
		testScore[1] = s.nextInt();
	
	}
	
	//-----------------------------------------------
	//getAverage: compute and return the student's test average
	//-----------------------------------------------
	
	public void getAverage() {
		int score = 0;
		for (int i = 0; i < testScore.length; i++) {
			score += testScore[i];
		}
		
		score /= testScore.length;
		p.nl("The average for " + getName() + " is " + score);
	
	}
	
	//-----------------------------------------------
	//getName: print the student's name
	//-----------------------------------------------
	
	public String getName() {
	
		return name;
	
	}
	
	public String toString() {
		return ("Name: " + getName() + "\nTest 1: " + testScore[0] + "\nTest 2: " + testScore[1]);
	}

}