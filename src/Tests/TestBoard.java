package Tests;

import Core.PublicFunctions;
import GameObjects.Board;
import GameObjects.Piece;

public class TestBoard extends Board
{
	TestBoard()
	{
		board = new Piece[7][7];
	}
	
	//<editor-fold defaultstate="collapsed" desc="Test Case for Normal Board">
	private void createNormalBoard()
	{
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++) 
			{
				board[i][j] = (i < 6) ? new Piece(Piece.Type.EMPTY) : new Piece(Piece.Type.NEW);
			}
		}
	}

	public static void TestNormalBoard()
	{
		TestBoard b = new TestBoard();
		
		b.createNormalBoard();
		System.out.print(b);

		b.insertAndPrint(1);
		b.insertAndPrint(2);
		
		b.insertAndPrint(1);
		b.insertAndPrint(2);
		
		b.insertAndPrint(1);
		b.insertAndPrint(2);
		
		b.insertAndPrint(1);
		b.insertAndPrint(2);
		
		b.insertAndPrint(1);
		b.insertAndPrint(2);
		
		b.insertAndPrint(1);
		b.insertAndPrint(2);
		
		b.insertAndPrint(1);
		b.insertAndPrint(2);
	}
	//</editor-fold>
	
	private void createMyserty1Board()
	{
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++) 
			{
				board[i][j] = (i < 6) ? new Piece(Piece.Type.EMPTY) : new Piece(Piece.Type.MYSTERY1);
			}
		}
	}
	
	/**
	 * @param position The position to insert the new piece
	 * @return creates a random piece and inserts it into the given position
	 */
	public boolean InsertRandom(int position)
	{		
		for (int index = 6; index >= 0; index--)
		{
			Piece current = board[index][position];
			if(current.getType() == Piece.Type.EMPTY)
			{
				current.setType(Piece.Type.NEW);
				current.setValue(PublicFunctions.GetRandomNumber());
				return true;
			}
		}
		
		return false;
	}
	
	private static void TestMystery1Board()
	{
		TestBoard b = new TestBoard();
		b.createMyserty1Board();
		
		System.out.print(b);

		b.insertAndPrint(1);		
		b.insertAndPrint(2);
		
		b.insertAndPrint(1);		
		b.insertAndPrint(2);
	}
	
	private void createFullBoard()
	{
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++) 
			{
				Piece p = new Piece(Piece.Type.NEW);
				p.setValue(5);
				board[i][j] = p;
			}
		}
	}
	
	private void insertAndPrint(int i)
	{
		System.out.println(InsertRandom(i));
		System.out.print(this);
	}
		
	public static void main(String[] args)
	{
		TestMystery1Board();
	}
}
