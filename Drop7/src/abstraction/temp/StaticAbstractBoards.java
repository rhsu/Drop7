package abstraction.temp;

import migration.GameBoard;
import migration.PieceType;

public class StaticAbstractBoards 
{
	/**
	 * Creates a board that is empty
	 * @return an empty board
	 */
	public static GameBoard getEmptyBoard()
	{
		GameBoard b = new GameBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setType(PieceType.EMPTY);
		}
		return b;
	}
}
