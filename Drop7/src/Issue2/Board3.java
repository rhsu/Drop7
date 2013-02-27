package Issue2;

import GameObjects.Board;
import GameObjects.Piece;

public class Board3 extends Board
{
	public Board3()
	{
		super();
	}
	
	@Override
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
				current.setType(value == 8 ? Piece.Type.MYSTERY1 : Piece.Type.NEW);	
				current.setValue(value);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Board3 b = new Board3();
		System.out.println(b);
	}
}
