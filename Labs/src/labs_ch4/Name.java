package labs_ch4;

public class Name {
	String f,
		   m,
		   l;
	
	public Name(String f, String m, String l) {
		this.f = f;
		this.m = m;
		this.l = l;
	}
	
	public String getFirst() {
		return f;
	}
	public String getMiddle() {
		return m;
	}
	public String getLast() {
		return l;
	}
	public String firstMiddleLast() {
		return (f + " " + m + " " + l);
	}
	public String lastFirstMiddle() {
		return (l + ", " + f + " " + m);
	}
	public boolean equals(Name oName) {
		return (firstMiddleLast().equalsIgnoreCase(oName.firstMiddleLast()));
	}
	public String initials() {
		String initial[] = new String[3];
		initial[0] = f.substring(0,1).toUpperCase();
		initial[1] = m.substring(0,1).toUpperCase();
		initial[2] = l.substring(0,1).toUpperCase();
		return (initial[0] + initial[1] + initial[2]);
	}
	public int length() {
		return firstMiddleLast().trim().length() - 2; //2 spaces for 3 names
	}
}
