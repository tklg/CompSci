package labs_ch2;

public class GradeTable {
	
	private static String tabs;

	public static void main(String[] args) {

		pr("///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ ", true);
		pr("==\t    Student Points          ==", true);
		pr("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////", true);
		pr("Name"+tab(2)+"Lab"+tab(1)+"Bonus"+tab(1)+"Total", true);
		pr("----"+tab(2)+"---"+tab(1)+"-----"+tab(1)+"-----", true);
		pr("Joe"+tab(2)+"43"+tab(1)+"7"+tab(1)+"50", true);
		pr("William"+tab(2)+"50"+tab(1)+"8"+tab(1)+"58", true);
		pr("Mary Sue"+tab(1)+"39"+tab(1)+"10"+tab(1)+"49", true);
		pr("Bob"+tab(2)+ (10 * 4) +tab(1)+"20"+tab(1)+"60",true);
		pr("Joe"+tab(2)+(20 + 20)+tab(1)+"15"+tab(1)+"55", true);
		
	}
	
	private static void pr(String a, Boolean b) {
		if (b) {
			System.out.println(a);			
		} else {
			System.out.print(a);
		}
	}
	private static String tab(int times) {
		tabs = "";
		for (int i = 0; i < times; i++) {
			tabs += "\t";
		}
		return tabs;
	}

}
