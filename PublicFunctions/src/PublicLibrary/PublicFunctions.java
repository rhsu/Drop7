package PublicLibrary;



/**
 *
 * @author RHsu
 */
public class PublicFunctions 
{
	/**
	 * 
	 * @return A random number between 1 and 7
	 */
	public static int GetRandomNumber()
	{
		return (int)(Math.random()*7)+1;
	}
	
	public static int GetRandomNumberPiece()
	{
		return (int)(Math.random()*8)+1;
	}
	
	/**
	 * 
	 * @param s the string to check if its a valid integer.
	 * @return True if the string is a valid integer
	 */
	public static boolean isInteger(String s)
	{
		return s.matches("-?[0-9]+");
	}
	
	/**
	 * Checks if the user inputted position is valid
	 * @return True if the position of valid
	 */
	public static boolean IsValidPosition(String position)
	{
		if(!isInteger(position))
		{
			return false;
		}

		int numPosition = Integer.parseInt(position);

		if ((numPosition > 0) && (numPosition < 8))
		{
			return true;
		}
		return false;
	}
	
	public static boolean IsValidPosition(int position)
	{
		return ((position >= 0) && (position < 7));
	}
	
	/**
	 * Creates 100 random pieces and plots the frequency of each piece.
	 */
	@Deprecated
	public static void TestRandom()
	{
		int[] stats = new int[8];
		for (int i = 0 ; i < stats.length; i++) 
		{
			stats[i] = 0;
		}

		System.out.println("Test random: Creating 100 Pieces");
		for (int i = 0; i < 100; i++)
		{
			int r = PublicFunctions.GetRandomNumber();
			stats[r]++;
		}
		
		//dump stats
		System.out.println("The values of the pieces and they're frequencies");
		
		for (int i = 0; i < stats.length; i++)
		{
			System.out.println(i + " : " + stats[i]);	
		}	
	}
	
	public static void main(String[] args)
	{
		//System.out.println(GetRandomNumber());
		TestRandom();
	}
}
