package GameObjects.Tests;

import GameObjects.Board;
import GameObjects.Piece;
import Issue2.Board3;

/**
 *
 * @author RHsu
 */
public class TestBoard
{
	public static Board getConsecutiveBoard()
	{
		Board b = new Board();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		return b;
	}
	
	public static Board3 getConsecutiveBoard3()
	{
		Board3 b = new Board3();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		return b;
	}
	
	public static Board3 getConsecutiveBoard3v2()
	{
		Board3 b = new Board3();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		b.pieceAt(6, 0).setType(Piece.Type.EMPTY);
		b.pieceAt(6, 0).setValue(Piece.EMPTY);
		return b;
	}
	
	public static void main(String[] args)
	{
		Board b = TestBoard.getConsecutiveBoard();
		System.out.println(b);
	}
}