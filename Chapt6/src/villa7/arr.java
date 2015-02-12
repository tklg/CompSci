package villa7;

import java.util.*;

public class arr {
	
	public arr() {
		
	}
	public static String format(int[][] a) {
		String ret = "";
		for (int i = 0; i < a.length; i++) {
			for (int c = 0; c < a[0].length; c++) {
				if (c == a[0].length - 1) {
					ret += a[i][c] + "\n";
				} else {
					ret += a[i][c] + " ";
				}
			}
		}
		return ret;		
	}
	public static String format(String[][] a) {
		String ret = "";
		for (int i = 0; i < a.length; i++) {
			for (int c = 0; c < a[0].length; c++) {
				if (c == a[0].length - 1) {
					ret += a[i][c] + "\n";
				} else {
					ret += a[i][c] + " ";
				}
			}
		}
		return ret;		
	}
	public static String format(boolean[][] a) {
		String ret = "";
		for (int i = 0; i < a.length; i++) {
			for (int c = 0; c < a[0].length; c++) {
				if (c == a[0].length - 1) {
					ret += a[i][c] + "\n";
				} else {
					ret += a[i][c] + " ";
				}
			}
		}
		return ret;		
	}
	public static String format(double[][] a) {
		String ret = "";
		for (int i = 0; i < a.length; i++) {
			for (int c = 0; c < a[0].length; c++) {
				if (c == a[0].length - 1) {
					ret += a[i][c] + "\n";
				} else {
					ret += a[i][c] + " ";
				}
			}
		}
		return ret;		
	}
	public static String format(float[][] a) {
		String ret = "";
		for (int i = 0; i < a.length; i++) {
			for (int c = 0; c < a[0].length; c++) {
				if (c == a[0].length - 1) {
					ret += a[i][c] + "\n";
				} else {
					ret += a[i][c] + " ";
				}
			}
		}
		return ret;		
	}

}
