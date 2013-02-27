package GameObjects;

/**
 * @author RHsu
 */
//Creates a board where the game can be played
public class Board extends BoardBase
{	
	public Board()
	{
		super();
	}
		
	/**
	 * Given a position, this function will create a new piece and update the piece
	 * @param position the column that the piece should be inserted
	 * @return true if the insert was successful, else false
	 */
	public boolean Insert(int position, int value)
	{
		if((position <= 0) || (position > 7) || (value > 7))
		{
			throw new IllegalArgumentException();
		}
		
		//subtracting one to calibrate the position to work with array indexes
		position--;
		
		for (int index = 6; index >= 0; index--)
		{
			Piece current = board[index][position];
			if(current.getType() == Piece.Type.EMPTY)
			{
				current.setType(Piece.Type.NEW);
				current.setValue(value);
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{		
		Board b = new Board();
		b.Insert(1,3);
		System.out.print(b)
;	}
}

