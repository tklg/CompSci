package labs_ch5;
public class PigLatin {
	public static void main(String[] args) {
		String sentence, result, another;
		PigLatinTranslator translator = new PigLatinTranslator();
		do {
			System.out.println();
			System.out.println("Enter a sentence (no punctuation):");
			sentence = Keyboard.readString();
			System.out.println();
			result = PigLatinTranslator.translate(sentence);
			System.out.println("That sentence in Pig Latin is:");
			System.out.println(result);
			System.out.println();
			System.out.print("Translate another sentence (y/n)? ");
			another = Keyboard.readString();
		}
		while (another.equalsIgnoreCase("y"));
	}
}