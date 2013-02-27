package Tests;

public class TestMatrix 
{
	public static void main(String[] args)
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
}
