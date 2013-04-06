package abstraction;

import utilities.PublicFunctions;

public abstract class AbstractBoard <T extends AbstractPiece>
{
	protected T[][] board;
		
	//<editor-fold defaultstate="collapsed" desc="RETRIEVAL FUNCTIONS">
        
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece to the left of the given index
	 */
	public T getLeftPiece(int i, int j)
	{		
		return pieceAt(i, j - 1);
	}
	
	/**
	 * 
	 * @param p Piece
	 * @return The piece to the left of the given piece
	 */
	public T getLeftPiece(T p)
	{
		return pieceAt(p.getHorizontal(), p.getVertical() - 1);
	}
	
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece to the right of the given index
	 */
	public T getRightPiece(int i, int j)
	{
		return pieceAt(i, j + 1);
	}
	
	/**
	 * 
	 * @param p Piece
	 * @return The piece to the right of the given piece
	 */
	public T getRightPiece(T p)
	{
		return pieceAt(p.getHorizontal(), p.getVertical() + 1);
	}
	
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece above the given index
	 */
	public T getUpPiece(int i, int j)
	{
		return pieceAt(i - 1, j);
	}
	
	/**
	 * 
	 * @param p piece
	 * @return The piece above the given piece
	 */
	public T getUpPiece(T p)
	{
		return pieceAt(p.getHorizontal() - 1, p.getVertical());
	}
	
	/**
	 * 
	 * @param i index
	 * @param j index
	 * @return The piece below the given index
	 */
	public T getDownPiece(int i, int j)
	{
		return pieceAt(i + 1, j);
	}
	
	/**
	 * @param p piece
	 * @return The piece below the given piece
	 */
	public T getDownPiece(T p)
	{
		return pieceAt(p.getHorizontal() + 1, p.getVertical());
	}
	
	/**
	 * Retrieves a Piece from the board with the given indexes
	 * @param i index
	 * @param j index
	 * @return The piece from the board. Null if no piece exists
	 */
	public T pieceAt(int i, int j)
	{
		if (PublicFunctions.isValidPosition(i) && PublicFunctions.isValidPosition(j)) 
		{
			return board[i][j];
		}
		return null;
	}
	
	
	//</editor-fold>
	
	/**
	 * The constructor must contain a way 
	 */
	public AbstractBoard()
	{
		//TODO: Research how to do generic array allocation seems complicated
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("==============").append("\n");
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0 ; j < 7; j++)
			{
				builder.append(pieceAt(i,j).toString()).append(" ");
			}
			builder.append("\n");
		}
		builder.append("==============");
		return builder.toString();
	}
}
