package chatbot3;

import villa7.Print;

/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		Print p = new Print();
		String sample = "The quick brown fox jumped over the lazy dog.";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		p.nl("sample.indexOf(\"quick\") = " + position);
		
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
		
		int pos = sample.indexOf("fox", 20);
		System.out.println("sample.indexOf(\"fox\") = " + pos);
		//  Try other methods here:

	}

}

