package GameObjects.Tests;

import GameObjects.Board;
import GameObjects.Piece;

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
	
	public static Board getConsecutiveBoard3()
	{
		Board b = new Board();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		return b;
	}
	
	public static Board getConsecutiveBoard3v2()
	{
		Board b = new Board();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
                b.pieceAt(5, 6).setType(Piece.Type.NEW);
                b.pieceAt(5, 6).setValue(3);
		b.pieceAt(6, 0).setType(Piece.Type.EMPTY);
		b.pieceAt(6, 0).setValue(Piece.EMPTY);
                b.pieceAt(6, 2).setType(Piece.Type.EMPTY);
                b.pieceAt(6, 2).setValue(Piece.EMPTY);
		return b;
	}
	
	public static void main(String[] args)
	{
		Board b = TestBoard.getConsecutiveBoard3v2();
		System.out.println(b);
	}
}