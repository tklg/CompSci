package pack;

public class Knowledge {
	
	private static String[] knowledge = {"Knowledge ", "is ", "power "};
	private static String[] centerKnow = {"Knowledge ", "   is    ", "  power   "};
	private static String horizLine = "=====================";
	private static String vertLine = "|";

	public static void main(String[] args) {
		//1
		pr(knowledge[0], false);
		pr(knowledge[1], false);
		pr(knowledge[2], false);
		pr("\n", true);
		//2
		pr(centerKnow[0], true);
		pr(centerKnow[1], true);
		pr(centerKnow[2], true);
		pr("", true);
		//3
		pr(horizLine, true);
		pr(vertLine, false);
		pr(knowledge[0], false);
		pr(knowledge[1], false);
		pr(knowledge[2], false);
		pr(vertLine, true);
		pr(horizLine, false);
	}
	
	private static void pr(String a, Boolean b) {
		if (b) {
			System.out.println(a);			
		} else {
			System.out.print(a);
		}
	}
}
