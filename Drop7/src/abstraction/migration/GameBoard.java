package abstraction.migration;

import abstraction.AbstractBoard;
import abstraction.AbstractPiece;
import java.util.ArrayList;

public class GameBoard extends AbstractBoard<AbstractPiece>
{
	//<editor-fold defaultstate="collapsed" desc="RETRIEVAL FUNCTIONS">
	/**
	* calculates the number of adjacent pieces in the same (horizontal) row as a
	* given parameter piece (Including itself: e.g. A piece with no pieces next to it
	* will return a value of 1)
	* @param p the parameter piece to perform the calculation on
	* @return the number of pieces that are in the same row as the parameter piece.
	*/
	public int getRowAdjacent(AbstractPiece p)
	{
		if((p == null) || (p.getType() == PieceType.EMPTY))
		{
			return 0;
		}
                
		AbstractPiece current = p;
		int numAdjacent = 0;
		while((getLeftPiece(current) != null) && (getLeftPiece(current).getType() != PieceType.EMPTY))
		{
			numAdjacent++;
			current = getLeftPiece(current);
		}
                
		current = p;
                
		while((getRightPiece(current) != null) && (getRightPiece(current).getType() != PieceType.EMPTY))
		{
			numAdjacent++;
			current = getRightPiece(current);
		}

		numAdjacent++; //increment to include self;
                
		return numAdjacent;     
	}
	
	/**
	* calculates the number of adjacent pieces in the same (vertical) column as a
	* given parameter piece (Including itself: e.g. A piece with no pieces next to it
	* will return a value of 1)
	* @param p the parameter piece to perform the calculation on
	* @return the number of pieces that are in the same column as the parameter piece.
	*/
	public int getColumnAdjacent(AbstractPiece p)
	{
		if((p == null) || (p.getType() == PieceType.EMPTY))
		{
			return 0;
		}
            
		AbstractPiece current = p;
		int numAdjacent = 0;

		//get the pieces below
		while((getUpPiece(current) != null) && (getUpPiece(current).getType() != PieceType.EMPTY))
		{
			numAdjacent++;
			current = getUpPiece(current);
		}
                
		current = p; //reset current: need to count the down pieces
                
		//get the pieces above
		while((getDownPiece(current) != null) && (getDownPiece(current).getType() != PieceType.EMPTY))
		{
			numAdjacent++;
			current = getDownPiece(current);
		}
                
		numAdjacent++; //include self
                
		return numAdjacent;
	}
        
	/**
	* @param p The piece to perform the method on
	* @return A list of pieces that are in the same row as the parameter piece
	*/
	public ArrayList<AbstractPiece> getAllInRow(AbstractPiece p)
	{
		if (p == null)
		{
			throw new NullPointerException();
		}
		int row = p.getHorizontal();
		ArrayList<AbstractPiece> list = new ArrayList<>();
		for(int j = 0; j < 7; j++)
		{
			AbstractPiece temp = pieceAt(row, j);
			if((temp != null) && (temp.getType() != PieceType.EMPTY))
			{
				list.add(temp);
			}
		}
		return list;
	}
        
	/**
	* @param p The piece to perform the method on
	* @return A list of pieces that are in the same column as the parameter piece
	*/
	public ArrayList<AbstractPiece> getAllInColumn(AbstractPiece p)
	{
		if (p == null)
		{
			throw new NullPointerException();
		}
		int column = p.getVertical();
            ArrayList<AbstractPiece> list = new ArrayList<>();
            for(int i = 0; i < 7; i++)
            {
                //System.out.println(pieceAt(row, i));
                AbstractPiece temp = pieceAt(i, column);
                if((temp != null) && (temp.getType() != PieceType.EMPTY))
                {
                    list.add(temp);
                }
            }
            return list;
        }
        
	/**
	* @return A list of pieces that are marked as remove
	*/
	public ArrayList<AbstractPiece> getAllRemove()
	{
		ArrayList<AbstractPiece> list = new ArrayList<>();
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				GamePiece p = (GamePiece) pieceAt(i, j);
				if(p.getRemove())
				{
					list.add(p);
				}
			}
		}
		return list;
	}
        
	//</editor-fold>
	
	public GameBoard()
	{
		board = new AbstractPiece[7][7];
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				board[i][j] = (i < 6) ? new GamePiece(PieceType.EMPTY, i, j) 
						: new GamePiece(PieceType.SET, i, j);
			}
		}
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
			GamePiece current = (GamePiece)pieceAt(index, position);
			if(current.getType() == PieceType.EMPTY)
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
	protected void checkForRemoval(AbstractPiece p)
	{
		//TODO: Clean this up. This is very risk prone.
		ArrayList<AbstractPiece> rows = getAllInRow(p);
		ArrayList<AbstractPiece> columns = getAllInColumn(p);
				
		for(AbstractPiece item : rows)
		{	
			GamePiece gamepiece = (GamePiece) item;
			int value = gamepiece.getValue();
			if((value == getColumnAdjacent(item)) || (value == getRowAdjacent(item)))
			{
				gamepiece.setRemove(true);
			}
		}
		
		for(AbstractPiece item: columns)
		{
			GamePiece gamepiece = (GamePiece) item;
			int value = gamepiece.getValue();
			if((value == getColumnAdjacent(item)) || (value == getRowAdjacent(item)))
			{
				gamepiece.setRemove(true);
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
		ArrayList<AbstractPiece> marked = getAllRemove();
		for(AbstractPiece item : marked)
		{
			GamePiece gamepiece = (GamePiece)item;
			gamepiece.setType(PieceType.EMPTY);
			gamepiece.setRemove(false);
		}
	}

}
