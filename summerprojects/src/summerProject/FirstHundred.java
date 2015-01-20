package summerProject;

public class FirstHundred {
	
	public static void main(String[] args) {
		
		double sum = 0;
		double a;
		
		for (double i = 1; i <= 100; i++) {
			
			a = (1 / (i * (i + 1)));
			sum += a;
			//print(i + ": " + sum);
			
		}
		
		print("Sum = " + sum);
		//As i approaches infinity, sum grows nearer to 1
	}
	
	public static void print(String m) { //laziness
		System.out.println(m);
	}

}
