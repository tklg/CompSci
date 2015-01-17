package summerProject;

public class BDGift {

	public static void main(String[] args) {

		int amt = 10;
		int max = 1000;
		int age = 12;
		
		while (amt <= max) {
			amt = amt * 2;
			age++;
		}
		
		print(age); //print age when loop ends
	}
	
	public static void print(int m) { //laziness
		System.out.println(m);
	}

}
