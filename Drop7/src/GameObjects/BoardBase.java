package GameObjects;

import PublicLibrary.PublicFunctions;

public class BoardBase 
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	protected Piece[][] board;
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="ACCESSORS">
	
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece to the left of the given index
	 */
	public Piece getLeftPiece(int i, int j)
	{		
		return pieceAt(i, j - 1);
	}
	
	public Piece getLeftPiece(Piece p)
	{
		return pieceAt(p.getHorizontal(), p.getVertical() - 1);
	}
	
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece to the right of the given index
	 */
	public Piece getRightPiece(int i, int j)
	{
		return pieceAt(i, j + 1);
	}
	
	public Piece getRightPiece(Piece p)
	{
		return pieceAt(p.getHorizontal(), p.getVertical() + 1);
	}
	
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece above the given index
	 */
	public Piece getUpPiece(int i, int j)
	{
		return pieceAt(i - 1, j);
	}
	
	public Piece getUpPiece(Piece p)
	{
		return pieceAt(p.getHorizontal() - 1, p.getVertical());
	}
	
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece below the given index
	 */
	public Piece getDownPiece(int i, int j)
	{
		return pieceAt(i + 1, j);
	}
	
	public Piece getDownPiece(Piece p)
	{
		return pieceAt(p.getHorizontal() + 1, p.getVertical());
	}
	
	//</editor-fold>
	
	/**
	 * The base constructor for building a Drop7 board.
	 * @see Board Recommended to use this class when constructing a board 
	 *			  since it contains the necessary functions for playing the Drop7 Game
	 */
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
	
	/**
	 * Retrieves a Piece from the board with the given indexes
	 * @param i index
	 * @param j index
	 * @return The piece from the board. Null if no piece exists
	 */
	public Piece pieceAt(int i, int j)
	{
		if (PublicFunctions.isValidPosition(i) && PublicFunctions.isValidPosition(j)) 
		{
			return board[i][j];
		}
		return null;
	}
		
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0 ; j < 7; j++)
			{
				builder.append(pieceAt(i,j).toString()).append(" ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public static void main(String[] args)
	{
		Board b = new Board();
		System.out.println(b);
		System.out.println(b.pieceAt(6, 6));
	}
}
