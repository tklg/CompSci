package villa7;

public class Maths {
	
	public double rng(int min, int max) {
		
		double ans = min + (Math.random() * max - (min));
		
		return ans;
	}
	public double rng(double min, double max) {
		
		double ans = min + (Math.random() * max - (min));
		
		return ans;
	}
	public double rng(int max) {
		
		double ans = (Math.random() * max);
		
		return ans;
	}
	public double rng(double max) {
		
		double ans = (Math.random() * max);
		
		return ans;
	}
	public double avg(int in[]) {
		double total = 0;
		for (int i = 0; i < in.length; i++) {
			total += in[i];
		}
		total /= in.length;
		return total;
	}
	public double avg(double in[]) {
		double total = 0;
		for (int i = 0; i < in.length; i++) {
			total += in[i];
		}
		total /= in.length;
		return total;
	}

}
