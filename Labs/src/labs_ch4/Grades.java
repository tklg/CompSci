package labs_ch4;
import villa7.Print;
//****************************************************************
//Grades.java
//
//Use Student class to get test grades for two students
//and compute averages
//
//****************************************************************

public class Grades {
	private static Print p = new Print();

	public static void main(String[] args) {
		Student student1 = new Student("Mary");
		//create student2, "Mike"
		Student student2 = new Student("Mike");
		
		//input grades for Mary
		student1.inputGrades();
		//print average for Mary
		student1.getAverage();

		System.out.println();

		//input grades for Mike
		student2.inputGrades();
		//print average for Mike
		student2.getAverage();
		
		p.nl("Student 1: \n" + student1.toString());
		p.nl("Student 2: \n" + student2.toString());
	}

}
