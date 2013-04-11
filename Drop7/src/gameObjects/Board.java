package gameObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *A super class of Board Base, which contains methods having to do with the game.
 */
public class Board extends BoardBase
{    
	/**
	 * Constructs a board for playing the Drop7 game.
	 */
	public Board()
	{
		super();
	}
		
	/**
	 * Given a position, this function will create a new piece and update the piece
	 * If the insert is successful, then a check will be performed to determine if 
	 * @param position The column number to insert the piece. Do not use with array indexes
	 * @param value 
	 * @return True if the insert was successful, else returns false
	 * @throws IllegalArgumentException If an incorrect position or value is given+
	 */
	public boolean insert(int position, int value)
	{
		if((position < 1) || (position > 7) || (value > 8))
		{
			throw new IllegalArgumentException();
		}
		
		//subtracting one to calibrate the position to work with array indexes
		position--;
		
		for (int index = 6; index >= 0; index--)
		{
			Piece current = pieceAt(index, position);
			if(current.getType() == Piece.Type.EMPTY)
			{				
				current.setValue(value);
				checkForRemoval(current);				
				return true;
			}
		}
		return false;
	}
        

	/**
	 * Given a piece, this functions will check if a piece should be removed
	 * @param p The piece to perform the operation on
	 */
	protected void checkForRemoval(Piece p)
	{
		ArrayList<Piece> rows = getAllInRow(p);
		ArrayList<Piece> columns = getAllInColumn(p);
				
		for(Piece item : rows)
		{	
			int value = item.getValue();
			if((value == getColumnAdjacent(item)) || (value == getRowAdjacent(item)))
			{
				item.setRemove(true);
			}
		}
		
		for(Piece item: columns)
		{
			int value = item.getValue();
			if((value == getColumnAdjacent(item)) || (value == getRowAdjacent(item)))
			{
				item.setRemove(true);
			}
		}
		
		removeMarked();
	}
	
	/**
	 * Searches the entire board for all removed pieces.
	 * Removes all the removed pieces on the board.
	 */
	protected void removeMarked()
	{
		ArrayList<Piece> marked = getAllRemove();
		for(Piece item : marked)
		{
			item.setType(Piece.Type.EMPTY);
			item.setRemove(false);
		}
	}
	
	public boolean move(Piece p, Direction direction)
	{
		int value = p.getValue();
		Piece bottom = getDownPiece(p);
		if(bottom != null)
		{
			p.setType(Piece.Type.EMPTY);
			bottom.setValue(value);	
		}
		return false;
	}
	
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{		

	}
}
