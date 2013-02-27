package GameObjects;

import PublicLibrary.PublicFunctions;

public class BoardBase 
{
	protected Piece[][] board;

	public BoardBase()
	{
		board = new Piece[7][7];
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				board[i][j] = (i < 6) ? new Piece(Piece.Type.EMPTY, i, j) : new Piece(Piece.Type.NEW, i, j);
			}
		}
	}
	
	public Piece PieceAt(int i, int j)
	{
		if (PublicFunctions.IsValidPosition(i) && PublicFunctions.IsValidPosition(j)) 
		{
			return board[i][j];
		}
		return null;
	}
	
	public Piece GetLeftPiece(int i, int j)
	{		
		return PieceAt(i, j - 1);
	}
	
	public Piece GetRightPiece(int i, int j)
	{
		return PieceAt(i, j + 1);
	}
	
	public Piece GetUpPiece(int i, int j)
	{
		return PieceAt(i - 1, j);
	}
	
	public Piece GetDownPiece(int i, int j)
	{
		return PieceAt(i + 1, j);
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0 ; j < 7; j++)
			{
				builder.append(board[i][j].toString()).append(" ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
