package abstractionTest;

import boardEditor.core.StaticBoards;
import newGameObjects.GameBoard;
import newGameObjects.GamePiece;

public class TestGameBoard 
{
	public static void main(String... args)
	{
		//Let's use abstract board and see where it breaks
		GameBoard b = StaticBoards.getEmptyBoard();
		
		b.pieceAt(1, 1).setValue(1);
		b.pieceAt(2, 1).setValue(2);
		b.pieceAt(3, 1).setValue(3);
		b.pieceAt(4, 1).setValue(4);
		b.pieceAt(5, 1).setValue(5);
		b.pieceAt(6, 1).setValue(6);
		
		System.out.println(b);
		
		GamePiece p = b.pieceAt(6,1);
		
		System.out.println(p);
		System.out.println(b.getAllInColumn(p));
	}
}
