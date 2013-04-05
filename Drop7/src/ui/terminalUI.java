package ui;

/**
 *The terminal UI for the Drop7 Board Editor
 */
public class terminalUI 
{
	public static void main(String[] args)
	{
		System.out.println("Enter data in by columns or rows");
		
		for (int i = 0; i < 7; i++)
		{
			System.out.println("Row: \t" + i);
		}
		
		System.out.println("You have entered... blah blah blah");
		System.out.println("Is this correct?");
	}
}
