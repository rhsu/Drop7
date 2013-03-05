package test;

import GameObjects.Board;
import GameObjects.Piece;

/**
 *
 * @author RHsu
 */
public class TestBoard extends Board
{
	public TestBoard()
	{
		super();
	}
    
	public static TestBoard getConsecutiveBoard()
	{
		TestBoard b = new TestBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		return b;
	}
	
	public static TestBoard getConsecutiveBoard3v2()
	{
		TestBoard b = new TestBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
                
		//set 5 - 6 to 3-SET
		b.pieceAt(5, 6).setValue(3);
            
		//set 6 - 0 to empty
		b.pieceAt(6,0).setType(Piece.Type.EMPTY);
                
                
		//set 6 - 2 to empty
		b.pieceAt(6,2).setType(Piece.Type.EMPTY);
		return b;
	}
	
	public static void main(String[] args)
	{
		TestBoard b = TestBoard.getConsecutiveBoard3v2();
		System.out.println(b);
	}
}