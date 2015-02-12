package arrays;

public class SortGrades {
	public static void main(String[] args) {
		int[] grades = {
			89, 94, 69, 80, 97, 85, 73, 91, 77, 85, 93
		};
		int[] g2 = {1,34,46,45,7,2,23,5,6,3,45,2};
		Sorts.selectionSort(grades);
		for (int g : grades)
		System.out.print(g + " ");
		System.out.println();
		Sorts.insertionSort(g2);
		for (int g : g2)
		System.out.print(g + " ");
		
	}
}
