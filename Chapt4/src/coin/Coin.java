package coin;

public class Coin {

	private final int HEADS = 0;
	
	private int face;
	
	public Coin() {
		flip();
	}
	
	public void flip() {
		face = (int) (Math.random() * 2);
	}
	public boolean isHeads() {
		return (face == HEADS);
	}
	public String toString() {
		String fName;
		if (face == HEADS) {
			fName = "Heads";
		} else {
			fName = "Tails";
		}
		return fName;
	}
}
