package boardEditor.core;

import rhsu.board.testObjects.gameObjects.overhaul.Drop7Board;
import rhsu.board.testObjects.gameObjects.overhaul.Drop7Piece;

public class StaticBoards 
{
	/**
	 * Creates a board that is empty
	 * @return an empty board
	 */
	public static Drop7Board getEmptyBoard()
	{
		Drop7Board b = new Drop7Board(7,7);
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(Drop7Piece.EMPTY);
			
		}
		return b;
	}
	
	/**
	 * Creates a board that looks like this 1 2 3 4 5 6 7
	 * @return a board of consecutive values
	 */
	static Drop7Board getConsecutiveBoard()
	{
		Drop7Board b = new Drop7Board(7,7);
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).getValue().setPieceValue(i + 1);
		}
		return b;
	}
}
