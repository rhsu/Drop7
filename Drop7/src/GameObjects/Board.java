package GameObjects;

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
	public boolean Insert(int position, int value)
	{
		if((position < 1) || (position > 7) || (value > 8))
		{
			throw new IllegalArgumentException();
		}
		
		//subtracting one to calibrate the position to work with array indexes
		position--;
		
		for (int index = 6; index >= 0; index--)
		{
			Piece current = PieceAt(index, position);
			if(current.getType() == Piece.Type.EMPTY)
			{				
				current.setType(value == 8 ? Piece.Type.MYSTERY1 : Piece.Type.NEW);	
				current.setValue(value);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{		
		Board b = new Board();
		b.Insert(7,8);
		System.out.println(b)
;	}
}

