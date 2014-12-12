package pack;

public class BigLetters {
	
	//private static String t = "T";
	//private static String k = "K";
	private static String sp = " ";
	//private static final int WIDTH = 9;
	private static String[] t = {
		"TTTTTTTTTTTT",
		"TTTTTTTTTTTT",
		"TTTTTTTTTTTT",
		"    TTTT    ",
		"    TTTT    ",
		"    TTTT    ",
		"    TTTT    ",
		"    TTTT    ",
		"    TTTT    ",
	};
	private static String[] k = {
		"KKKK     KKK",
		"KKKK    KKK ",
		"KKKK   KKK  ",
		"KKKKKKKKK   ",
		"KKKKKKKK    ",
		"KKKKKKKKK   ",
		"KKKK   KKK  ",
		"KKKK    KKK ",
		"KKKK     KKK",
	};

	public static void main(String[] args) {
		for (int i = 0; i < t.length; i++) {
			pr(t[i], false);
			pr(sp, false);
			pr(k[i], true);
		}
	}
	
	private static void pr(String a, Boolean b) {
		if (b) {
			System.out.println(a);			
		} else {
			System.out.print(a);
		}
	}
}
