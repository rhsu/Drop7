package GameObjects;

import GameObjects.Tests.TestBoard;
import java.util.ArrayList;

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
	 * @param position The column number to insert the piece. Do not use with array indexes
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
				current.setType(value == 8 ? Piece.Type.MYSTERY1 : Piece.Type.SET);	
				current.setValue(value);
                                //int h = getHorizontalAdjacent(current); 
                                //int v = getColumnAdjacent(current);
                                //System.out.println("h is: " + h + " and v is : "+ v);
				return true;
			}
		}
		return false;
	}
        
        /**
         * calculates the number of adjacent pieces in the same (horizontal) row as a
         * given parameter piece (Including itself: e.g. A piece with no pieces next to it
         * will return a value of 1)
         * @param p the parameter piece to perform the calculation on
         * @return the number of pieces that are in the same row as the parameter piece.
         */
	public int getRowAdjacent(Piece p)
	{
                if((p == null) || (p.getType() == Piece.Type.EMPTY))
                {
                    return 0;
                }
                
		Piece current = p;
                int numAdjacent = 0;
                while((getLeftPiece(current) != null) && (getLeftPiece(current).getType() != Piece.Type.EMPTY))
                {
                    numAdjacent++;
                    current = getLeftPiece(current);
                }
                
                current = p;
                
                while((getRightPiece(current) != null) && (getRightPiece(current).getType() != Piece.Type.EMPTY))
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
	public int getColumnAdjacent(Piece p)
	{
                if((p == null) || (p.getType() == Piece.Type.EMPTY))
                {
                    return 0;
                }
            
		Piece current = p;
                int numAdjacent = 0;

                //get the pieces below
                while((getUpPiece(current) != null) && (getUpPiece(current).getType() != Piece.Type.EMPTY))
                {
                    numAdjacent++;
                    current = getUpPiece(current);
                }
                
                current = p; //reset current: need to count the down pieces
                
                //get the pieces above
                while((getDownPiece(current) != null) && (getDownPiece(current).getType() != Piece.Type.EMPTY))
                {
                    numAdjacent++;
                    current = getDownPiece(current);
                }
                
                numAdjacent++; //include self
                
                return numAdjacent;
	}
                
        //1. Get all in the same row as given piece
        public ArrayList<Piece> getAllInRow(Piece p)
        {
            if(p == null)
            {
                throw new NullPointerException();
            }
            
            Piece current = p;

            
            ArrayList<Piece> list = new ArrayList<>();
            
            while ((getLeftPiece(current) != null) && (getLeftPiece(current).getType() != Piece.Type.EMPTY))
            {
                list.add(current);
                current = getLeftPiece(current);
            }
            
            current = p;
            
            while((getRightPiece(current) != null) && (getRightPiece(current).getType() != Piece.Type.EMPTY))
            {
                list.add(current);
                current = getRightPiece(current);
            }
            
            return list;
        }
        
        //2. Get all in the same column as given piece
        public ArrayList<Piece> getAllInColumn(Piece p)
        {
            return new ArrayList<>();
        }
        //3. Get all where piece is marked as remove
        public ArrayList<Piece> GetAllRemove(Piece p)
        {
            return new ArrayList<>();
        }

	public static void main(String[] args)
	{		
		Board b = new Board();
                b = TestBoard.getConsecutiveBoard();
                System.out.println(b);
                
                ArrayList<Piece> list = b.getAllInRow(b.pieceAt(6, 6));
                
                System.out.println(list);
	}
}

