package summerProject;

public class StringSwitcher {

	public static void main(String[] args) {
		
		long num = Math.round(Math.random() * 1000000 + 1); //random is more interesting
		
		print("" + num + "\n"); //print original
		while (num != 0) {
			print(num%10 + ""); //print reversed
			num = num / 10;
		}

	}
	public static void print(String m) { //laziness
		System.out.print(m);
	}

}
