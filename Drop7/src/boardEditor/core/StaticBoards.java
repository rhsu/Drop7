package boardEditor.core;

import migration.GameBoard;
import migration.PieceType;

public class StaticBoards 
{
	/**
	 * Creates a board that is empty
	 * @return an empty board
	 */
	public static GameBoard getEmptyBoard()
	{
		GameBoard b = new GameBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setType(PieceType.EMPTY);
		}
		return b;
	}
	
	/**
	 * Creates a board that looks like this 1 2 3 4 5 6 7
	 * @return a board of consecutive values
	 */
	static GameBoard getConsecutiveBoard()
	{
		GameBoard b = new GameBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		return b;
	}
		
	/**
	 * This test was used to create a board but with a couple of values changed
	 * @return a board
	 */
	static GameBoard getTest1()
	{
		GameBoard b = new GameBoard();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
                
		//set 5 - 6 to 3-SET
		b.pieceAt(5, 6).setValue(3);
            
		//set 6 - 0 to empty
		b.pieceAt(6,0).setType(PieceType.EMPTY);
                
                
		//set 6 - 2 to empty
		b.pieceAt(6,2).setType(PieceType.EMPTY);
		return b;
	}
	
	/**
	 * This test was used to create a board of all 2s
	 * @return something here to stop warnings
	 */
	static GameBoard getTest2()
	{
		GameBoard b = new GameBoard();
		for (int i = 0; i< 7; i++)
		{
			b.pieceAt(6,i).setValue(2);
		}
		return b;
	}
}
