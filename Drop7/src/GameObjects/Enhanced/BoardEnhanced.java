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
	
	private BoardEnhanced(boolean b)
	{
		board = new PieceEnhanced[7][7];
		int ctr = 0;
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				board[i][j] = (i < 6) ? new PieceEnhanced(Piece.Type.EMPTY, i, j) : new PieceEnhanced(Piece.Type.NEW, i, j, ++ctr);
			}
		}
	}
	
	public PieceEnhanced PieceAt(int i, int j)
	{
		return (PieceEnhanced) board[i][j];
	}
	
	public PieceEnhanced GetLeftPiece(int i, int j)
	{		
		return (i == 0 ? null : PieceAt(i, j-1));
	}
	
	public static void main(String[] args)
	{
		BoardEnhanced b = new BoardEnhanced(false);
		System.out.println(b);
		Piece p = b.GetLeftPiece(6, 3);
		System.out.println(p);
	}
}