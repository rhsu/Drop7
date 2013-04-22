package test;

import boardEditor.core.StaticBoards;
import newGameObjects.GameBoard;
import newGameObjects.GamePiece;

public class testMove 
{
	public static void main(String... args)
	{
		GameBoard b = StaticBoards.getEmptyBoard();
		
		b.pieceAt(0, 2).setValue(1);
		b.pieceAt(1, 2).setValue(2);
		//b.pieceAt(2, 2).setValue(3);
		b.pieceAt(3, 2).setValue(4);
		//b.pieceAt(4, 2).setValue(5);
		b.pieceAt(5, 2).setValue(6);
		b.pieceAt(6, 2).setValue(7);
		
		System.out.println(b);
				
		System.out.println(b.getAllInColumn(b.pieceAt(4,2)));
		
		for(GamePiece p : b.getAllInColumn(b.pieceAt(4, 2)))
		{
			/*if(p.getValue() == 2)
			{
				System.out.println("Tracing piece " + p);
				System.out.println(p.getType());
				System.out.println(b.getDownPiece(p));
			}*/
			//b.move(p, BoardBase.Direction.DOWN);
		}
		
		System.out.println(b);
	}
}
