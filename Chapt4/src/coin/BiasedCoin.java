package coin;

public class BiasedCoin {

	private String face;
	
	private double val;
	private double bias = 0.5;
	
	public BiasedCoin() {
		flip();
	}
	public BiasedCoin(double bias) {
		setBias(bias);
		flip();
	}
	
	public void flip() {
		val = Math.random();
		if (val < bias) {
			face = "Heads";
		} else {
			face = "Tails";
		}
	}
	public boolean isHeads() {
		if (face.equals("Heads")) {
			return true;
		} else {
			return false;
		}
	}
	private void setBias(double b) {
		if (b >= 0 && b <= 1) {
			bias = b;
		} else {
			bias = 0.5;
		}
	}
}

