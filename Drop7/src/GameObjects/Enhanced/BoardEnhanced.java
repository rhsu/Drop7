package GameObjects.Enhanced;

import GameObjects.Board;

/**
 *
 * @author RHsu
 */
public class BoardEnhanced extends Board
{
	public BoardEnhanced()
	{
		super();
	}
	
	public PieceEnhanced PieceAt(int i, int j)
	{
		return (PieceEnhanced) board[i][j];
	}
}
