package c3;
import villa7.Print;
import java.util.*;

public class Stars {
	
	private static String lines = "10";
	private static String width = "10";
	private static String starchar = "*";
	private static String align;
	private static String order;
	
	private static String[] a = {"left","10","10","*","asc"};
	
	private static Print p = new Print();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		p.nl("Enter a triangle config string: [align] [numLines] [width] [character] [order]");
		
		a[0] = sc.next();
		a[1] = sc.next();
		a[2] = sc.next();
		a[3] = sc.next();
		a[4] = sc.next();
		/*p.nl("Building triangle :: align: " + align + "; numLines: " + lines + "; width: " + width + "; character: " + starchar + "; order: " + order);*/
		p.nl("Building triangle :: align: " + a[0] + "; numLines: " + a[1] + "; width: " + a[2] + "; character: " + a[3] + "; order: " + a[4]);
		p.nl();
		
		//buildTriangle(align, lines, width, starchar, order);
		buildTriangle(args);
		
		
		
	}
	
	
	private static void buildTriangle(String[] args) { /*String align, String lines, String width, String character, String order*/
		
		int spaces;
		String space = " ";
		
		switch (a[0]) {
		case "left":
			for (int i = 0; i <= getInt(a[1]); i++) {
				for (int c = 0; c <= i; c++) {
					p.l(a[3]);
				}
				p.nl();
			}
			break;
		case "right":
			for (int i = 0; i <= getInt(a[1]); i++) {
				getSpaces(getInt(a[2]), i, a[0]);
				for (int c = 0; c <= i; c++) {
					p.l(a[3]);
				}
				p.nl();
			}
			break;
		case "center":
			for (int i = 0; i <= getInt(a[1]); i++) {
				getSpaces(getInt(a[2]), (i * 2) - 1, a[0]);
				for (int c = 0; c <= (i * 2) - 2; c++) {
					p.l(a[3]);
					if (c > getInt(a[2])) {
						break;
					}
				}
				p.nl();
			}
			break;
		default:
			break;
		}
	}
	
	private static int getInt(String string) {
		return Integer.parseInt(string);
	}
	private static void getSpaces(int width, int numChar, String type) {
		int w = width - numChar;
		String numSpaces,
			   space = " ";
		switch (type) {
		case "right":
			for (int i = 0; i < w; i++) {
				p.l(space);
			}
			break;
		case "center":
			w /= 2;
			w--;
			for (int i = 0; i < w; i++) {
				p.l(space);
			}
			break;
		default:
			for (int i = 0; i < w; i++) {
				p.l(space);
			}
			break;
		}
	}

}
