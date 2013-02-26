package GameObjects.Enhanced;

import GameObjects.Board;
import GameObjects.Piece;

/**
 *
 * @author RHsu
 */
public class BoardEnhanced extends Board
{
	public BoardEnhanced()
	{
		board = new PieceEnhanced[7][7];
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				board[i][j] = (i < 6) ? new PieceEnhanced(Piece.Type.EMPTY, i, j) : new PieceEnhanced(Piece.Type.NEW, i, j);
			}
		}
	}
	
	public PieceEnhanced PieceAt(int i, int j)
	{
		return (PieceEnhanced) board[i][j];
	}
	
	public static void main(String[] args)
	{
		BoardEnhanced b  = new BoardEnhanced();
		b.PieceAt(0, 0).GetLeftPiece(b);
	}
}