package abstraction;

public class StringBoard extends AbstractBoard<String>
{
	//TODO: Some testing
	public StringBoard()
	{
		board = new String[7][7];
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				board[i][j] = "BlahBlahBlah";
			}
		}
	}
	
	public static void main(String[] args)
	{
		AbstractBoard b = new StringBoard();
		System.out.println(b);
	}
}
