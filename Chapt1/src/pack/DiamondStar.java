package pack;

public class DiamondStar {
	
	private static String[] diamond = 
	{
		"    *",
		"   ***",
		"  *****",
		" *******",
		"*********",
		" *******",
		"  *****",
		"   ***",
		"    *",
	};

	public static void main(String[] args) {
		for (int i = 0; i < diamond.length; i++) {
			pr(diamond[i], true);
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
