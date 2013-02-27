package GameObjects.Enhanced;

import GameObjects.Board;
import GameObjects.Piece;
import PublicLibrary.PublicFunctions;

/**
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
		if (PublicFunctions.IsValidPosition(i) && PublicFunctions.IsValidPosition(j)) 
		{
			return (PieceEnhanced) board[i][j];
		}
		return null;
	}
	
	public PieceEnhanced GetLeftPiece(int i, int j)
	{		
		return PieceAt(i, j - 1);
	}
	
	public PieceEnhanced GetRightPiece(int i, int j)
	{
		return PieceAt(i, j + 1);
	}
	
	public PieceEnhanced GetUpPiece(int i, int j)
	{
		return PieceAt(i - 1, j);
	}
	
	public PieceEnhanced GetDownPiece(int i, int j)
	{
		return PieceAt(i + 1, j);
	}
	
	public static void main(String[] args)
	{
		BoardEnhanced b = new BoardEnhanced(false);
		System.out.println(b);
		//PieceEnhanced w = b.PieceAt(6, 3);
		//System.out.println("horizontal is " + w.GetHorizontal());
		//System.out.println("vertical is " + w.GetVertical());
		Piece p = b.GetDownPiece(6, 3); //4
		System.out.println(p);
	}
}