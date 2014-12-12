package labs_ch1;

public class Poem {
	
	private static String[] poem = {
		"Roses are red",
		"Violets are blue",
		"Sugar is sweet",
		"And so are you!"
		};

	public static void main(String[] args) {
		for (int i = 0; i < poem.length; i++) {
			System.out.println(poem[i]);
		}
	}

}
