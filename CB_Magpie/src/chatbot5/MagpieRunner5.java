package chatbot5;

import java.util.Scanner;
import villa7.Print;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner5
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{	
		Print p = new Print();
		Magpie5 maggie = new Magpie5();
		
		p.ne("--- Magpie v5 ---");
		
		Scanner in = new Scanner (System.in);
		p.nl(maggie.getGreeting());
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			p.nl(maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}

