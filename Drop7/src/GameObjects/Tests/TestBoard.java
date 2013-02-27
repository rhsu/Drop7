package GameObjects.Tests;

import GameObjects.Board;

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
	
	public static void main(String[] args)
	{
		Board b = TestBoard.getConsecutiveBoard();
		System.out.println(b);
	}
}