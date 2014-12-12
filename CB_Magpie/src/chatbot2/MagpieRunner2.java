package chatbot2;

import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner2
{
	public static void main(String[] args)
	{
		Magpie2 mag = new Magpie2();
		
		System.out.println(" --- Magpie v2 --- ");
		System.out.println (mag.getGreeting());
		Scanner sc = new Scanner (System.in);
		String statement = sc.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (mag.getResponse(statement));
			statement = sc.nextLine();
		}
	}

}
