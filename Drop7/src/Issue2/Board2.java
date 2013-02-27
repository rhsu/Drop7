package Issue2;

import GameObjects.Board;
import GameObjects.Piece;

/*
 * A subclass for testing out clear lines
 */
public class Board2 extends Board
{
	public Board2()
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
				
				CalculateHorizontalAdjacent(current);
				
				return true;
			}
		}
		return false;
	}
	
	public void CalculateHorizontalAdjacent(Piece p)
	{
		
		//int value = p.getValue();
		int horizontal = p.getHorizontal();
		int counter = 0;

		System.out.println("The parameter piece p is " + p.getValue());
		
		Piece current = p;
		System.out.println("Going left...");
		//Go Left: Caluclates the number of pieces that are to the left of the Given Piece
		System.out.println("horizontal is: " + horizontal);
		while(horizontal > 0)
		{
			current = board[p.getHorizontal()][--horizontal];
			System.out.println(current.getValue());
			//System.out.println(current);
			counter++;
		}
		System.out.println("counter is: " + counter);
		//return counter;
	}
	
	public void TestCaclculateHorizontalAdjacent()
	{
		//for the bottom row keep the first 6 constant and change the value of j;
		int j = 3;
		CalculateHorizontalAdjacent(board[6][j]);
	}
			
	public void CheckLines(Piece piece)
	{
		StringBuilder builder = new StringBuilder();
		
		//Horizonal Check: loop through all horizontal pieces

		//for tracking the number of new pieces in the horizontal row
		//TODO: Not using the horizontal counter anymore. 
		int horizontalCounter = 0;
		for(int j = 0; j < 7; j++)
		{
			if(board[piece.getHorizontal()][j].getType() == Piece.Type.NEW)
			{
				horizontalCounter++;
			}
			builder.append(board[piece.getHorizontal()][j]).append(" ");
		}
		System.out.println("Printing the builder -- for horizontal check " + builder.toString());
		System.out.println("The horizontal counter is " + horizontalCounter);
		//At this point a horizontal counter is calculated.
		/*if(piece.getValue() == horizontalCounter)
		{
			
		}*/
		
		builder.setLength(0);
		
		//Vertical Check: loop through all vertical pieces
		for(int i = 0; i < 7; i++)
		{
			builder.append(board[i][piece.getVertical()]).append(" ");
		}
		System.out.println("Printing the builder -- for vertical check " + builder.toString());
	
	}
	
	public static void main(String[] args)
	{
		Board2 b = new Board2();
		b.insert(1,1);
		System.out.println(b);
	}
}
