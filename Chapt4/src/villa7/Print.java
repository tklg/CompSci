/*
 * Print.java
 * http://villa7.github.io
 *
 * Copyright (C) 2014-2014 Theodore Kluge
 */

package villa7;

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void l(String args) {
		System.out.print(args);
	}
	public void l(int args) {
		System.out.print(args);
	}
	public void l(double args) {
		System.out.print(args);
	}
	public void l(boolean args) {
		System.out.print(args);
	}
	//--------------------------
	public void nl(String args) {
		System.out.println(args);
	}
	public void nl(int args) {
		System.out.println(args);
	}
	public void nl(double args) {
		System.out.println(args);
	}
	public void nl(boolean args) {
		System.out.println(args);
	}
	public void nl() {
		nl("");
	}
	//--------------------------
	public void e(String args) {
		System.err.print(args);
	}
	public void e(int args) {
		System.err.print(args);
	}
	public void e(double args) {
		System.err.print(args);
	}
	public void e(boolean args) {
		System.err.print(args);
	}
	//--------------------------
	public void ne(String args) {
		System.err.println(args);
	}
	public void ne(int args) {
		System.err.println(args);
	}
	public void ne(double args) {
		System.err.println(args);
	}
	public void ne(boolean args) {
		System.err.println(args);
	}
}

