package boardEditorCore;

import gameObjects.Board;
import gameObjects.Piece;

/**
 *Static functions that the board editor returns
 */
public class StaticBoards 
{
	/**
	 * Creates a board that looks like this 1 2 3 4 5 6 7
	 * @return a board of consecutive values
	 */
	static Board getConsecutiveBoard()
	{
		Board b = new Board();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setValue(i + 1);
		}
		return b;
	}
	
	/**
	 * Creates a board that is empty
	 * @return an empty board
	 */
	public static Board getEmptyBoard()
	{
		System.out.println("here???");
		Board b = new Board();
		for(int i = 0; i < 7; i++)
		{
			b.pieceAt(6, i).setType(Piece.Type.EMPTY);
		}
		return b;
	}
	
	/**
	 * This test was used to create a board but with a couple of values changed
	 * @return a board
	 */
	static Board getTest1()
	{
		Board b = new Board();
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
	
	/**
	 * This test was used to create a board of all 2s
	 * @return 
	 */
	static Board getTest2()
	{
		Board b = new Board();
		for (int i = 0; i< 7; i++)
		{
			b.pieceAt(6,i).setValue(2);
		}
		return b;
	}	
}
