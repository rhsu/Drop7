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
		if((position < 1) || (position > 7) || (value > 8))
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
				if(value == 8) 
				{
					current.setType(Piece.Type.MYSTERY1);
				}
				else 
				{
					current.setType(Piece.Type.NEW);
				}
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

