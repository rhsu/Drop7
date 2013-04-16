package utilities;

/**
 *
 * @author RHsu
 */
public class PublicFunctions 
{
	/**
	* Usage: For creating a new SET piece
	* @return A random number between 1 and 7
	*/
	public static int getRandomNumber()
	{
		return (int)(Math.random()*7)+1;
	}
	
	/**
	* @return A random number between 1 and 8. The 8 denotes a mystery piece should generated
	*/
	public static int getRandomNumberPiece()
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
	* Usage: In the prompt since the user input is of type string
	* @return True if the position of valid
	*/
	public static boolean isValidPosition(String position)
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
	
	public static boolean isValidIndex(int i)
	{
		if((i < 0) || (i > 6))
		{
			return false;
		}
		return true;
	}
	
	/**
	* Checks if the user inputted position is valid
	* @return True if the position of valid
	*/
	public static boolean isValidPosition(int position)
	{
		return ((position >= 0) && (position < 7));
	}
		
	/**
	* Creates a matrix to make envisioning indices easier
	*/
	public static void testMatrix()
	{
		int[][] matrix = new int[5][5];
		int ctr = 1;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				matrix[i][j] = ctr++;
			}
		}
		
		System.out.println("done allocating");
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0 ; j < 5; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Hold i constant: get all vertical");
		for (int i = 0; i < 5; i++)
		{
			System.out.print(matrix[i][0] + " ");
		}
		System.out.println();
		System.out.println("Hold j constant: get all horizontal");
		for (int j = 0; j < 5; j++)
		{
			System.out.print(matrix[0][j] + " ");
		}
	}
	
	public static void main(String[] args)
	{
		testMatrix();
	}
}
