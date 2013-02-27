package Issue2;

import GameObjects.Board;
import GameObjects.Piece;
import GameObjects.Tests.TestBoard;

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
	
	public static void printPiece(Piece current)
	{
		System.out.println("We are at " + current);
		//System.out.println("current's horizontal " + current.getHorizontal());
		//System.out.println("current's vertical " + current.getVertical());
		//System.out.println("Going left...");
	}
	
	public void calculateHorizontalAdjacent(Piece p)
	{
		Piece current = p;
printPiece(current);
		
		int ctr = 0;
		
		while(current.getVertical() > 0)
		{
			ctr++;
			current = getLeftPiece(current);
			if(current.getType() == Piece.Type.EMPTY) 
			{
				break;
			}
			printPiece(current);
		}
		
System.out.println("This ran " + ctr + " times");
		//current = getLeftPiece(current);
		//System.out.println(current);
		
		//current = getLeftPiece(current);
		//System.out.println(current);
	}
	
	public void testCalculateHorizontalAdjacent()
	{
		int j = 6; 
		calculateHorizontalAdjacent(pieceAt(6,j)); //6
	}
	
	public static void main(String[] args)
	{
		Board3 b = TestBoard.getConsecutiveBoard3v2();
		System.out.println(b);
		
		b.testCalculateHorizontalAdjacent();
	}
}
