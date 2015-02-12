package arrays;
import villa7.*;
import cs1.*;

import java.text.DecimalFormat;
import java.util.*;

public class QuizGrader {
	
	private static Scanner s = new Scanner(System.in);
	private static DecimalFormat fmt = new DecimalFormat("#.##");
	private static ArrayList<Double> grades = new ArrayList<Double>();
	
	public static void main(String[] args) {
		//p.nl("How many questions are in the quiz?");
		//int qNum = s.nextInt();
		p.nl("Enter the key pls");
		String[] key = kb.readString().trim().split(" ");
		
		do {
			p.nl("Enter answers pls");
			String[] ans = kb.readString().trim().split(" ");
			boolean[] correct = new boolean[key.length]; 
			
			int i = 0;
			for (String s : key) {
				if (s.equals(ans[i])) {
					correct[i] = true;
				}
				i++;
			}
			
			int cor = 0;
			for (boolean a : correct) {
				if (a) cor++;
			}
			
			p.nl("Number correct: " + cor + "/" + key.length + " (" + fmt.format(((double)cor / key.length) * 100) + "%)");
			grades.add(((double)cor / key.length) * 100);
			p.nl("Grade moar?");
		} while (s.next().toLowerCase().equals("y"));
		p.nl("All grades: ");
		Collections.sort(grades);
		for (Double g : grades) {
			p.l(fmt.format(g) + " ");
		}
		p.nl("\nAverage grade:");
		double to = 0.0;
		for (Double g : grades) {
			to += g;
		}
		p.nl((to / grades.size()) + "%");
	}

}
