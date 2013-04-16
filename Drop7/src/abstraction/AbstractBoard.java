package abstraction;

import abstraction.miscellaneous.PublicFunctions;

/**
 * The Abstract Board class is a custom made data-structure, which allows easy
 * access of "pieces" by retrieval functions.
 * @param <T> Generic Type. The type must extend Abstract Piece
 */
public abstract class AbstractBoard <T extends AbstractPiece>
{
	/**
	 * the board object to allocate in the constructor
	 */
	protected T[][] board;
		
	//<editor-fold defaultstate="collapsed" desc="RETRIEVAL FUNCTIONS">
        
	/**
	 * 
	 * @param i horizontal index
	 * @param j vertical index
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
	 * @param i horizontal index
	 * @param j vertical index
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
	 * @param i horizontal index
	 * @param j vertical index
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
	 * @param i horizontal index
	 * @param j vertical index
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
	 * Retrieves a Piece from the board with the given indices
	 * @param i horizontal index
	 * @param j vertical index
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
	 * To utilize this constructor, allocate a 2-dimensional array of objects that
	 * extends abstract piece. 
	 * 
	 * Example usage:
	 * 
	 * for(int i = 0; i < 7; i++)
	 * {
	 *		for(int j = 0; j < 7; j++)
	 *		{
	 *			board = new GamePiece(PieceType.EMPTY, i, j);
	 *		}
	 * }
	 */
	public AbstractBoard()
	{
		//TODO: Research how to do generic array allocation seems complicated
	}
	
	/**
	 * @return a string representation of the AbstractBoard object
	 */
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
