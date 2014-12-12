package pack;

public class Favorites {

	private static String name = "Theodore Kluge";
	private static String bDay = "March 21 1997";
	//private static String[] hobbies = {"Art", "Building", "Programming"};
	private static String hobbies = "Art, building, programming";
	private static String favBook = "Tom Swift";
	private static String favMovie = "Despicable Me";
	
	public static void main(String[] args) {
		pr("Name: ", false);
		pr(name, true);
		pr("Birthday: ", false);
		pr(bDay, true);
		pr("Hobbies: ", false);
		pr(hobbies, true);
		pr("Favorite book: ", false);
		pr(favBook, true);
		pr("Favorite movie: ", false);
		pr(favMovie, true);		
	}
	
	private static void pr(String a, Boolean b) {
		if (b) {
			System.out.println(a);			
		} else {
			System.out.print(a);
		}
	}
}
