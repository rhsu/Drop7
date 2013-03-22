package test;

import GameObjects.Board;
import GameObjects.Piece;
import java.util.ArrayList;

/**
 *
 * @author RHsu
 */
public class TestBoard extends Board
{
	public TestBoard()
	{
		super();
	}
    
	public static TestBoard getConsecutiveBoard()
	{
		TestBoard b = new TestBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		return b;
	}
	
	public static TestBoard getTest1()
	{
		TestBoard b = new TestBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
                
		//set 5 - 6 to 3-SET
		b.pieceAt(5, 6).setValue(3);
            
		//set 6 - 0 to empty
		b.pieceAt(6,0).setType(Piece.Type.EMPTY);
                
                
		//set 6 - 2 to empty
		b.pieceAt(6,2).setType(Piece.Type.EMPTY);
		return b;
	}
	
	public void testCheck(Piece p)
	{
		ArrayList<Piece> rows = getAllInRow(p);
		ArrayList<Piece> columns = getAllInColumn(p);
		
		System.out.println("rows is : " + rows);
		System.out.println("columns is : " + columns);
		
		for(Piece item : rows)
		{
			System.out.println("This is item: " + item);			
			int value = item.getValue();
			System.out.println("The value is: " + value);			
			int column = getColumnAdjacent(item);
			System.out.println("The column adjacent is " + column);
			int row = getRowAdjacent(item);
			System.out.println("The row adjacent is: " + row);
			if((value == column) || (value == row))
			{
				item.setRemove();
			}
		}
	}
	
	public static void m1()
	{
		TestBoard b = TestBoard.getTest1();
		Piece p = b.pieceAt(6, 3);
		
		b.testCheck(p);
		
		System.out.println("Remove is: " + b.getAllRemove());
		
		b.checkForRemoval(p);
		
		System.out.println(b);
		System.out.println("Calling remove");
		b.removeMarked();	
		System.out.println(b);
	}
	
	public static void main(String[] args)
	{
		//create a board
		TestBoard b = TestBoard.getTest1();
		
		System.out.println(b);
		
		//insert at position 2 a value of 1
		/*
		 * Looks like this
		 * 
		 * 1
		 * 2
		 */
		
		b.insert(2, 1);
		b.removeMarked();
		//ArrayList<Piece> ListOfRemovedPieces = b.getAllRemove();
		
		
		System.out.println(b);
		
	}
}