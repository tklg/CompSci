package lincoln;

public class lincoln {
	public static void main(String[] args) {
		lazyPrint("A quote by Abraham Lincoln:");
		lazyPrint("\"0Whatever you are, be a good one.\"");
	}
	
	static void lazyPrint(String msg) { //because System.out.println is too long to type a lot
		System.out.println(msg);
	}
}
