package test;

import boardEditor.core.StaticBoards;
import gameObjects.Board;
import gameObjects.BoardBase;
import gameObjects.Piece;

public class testMove 
{
	public static void main(String... args)
	{
		Board b = StaticBoards.getEmptyBoard();
		b.pieceAt(5, 2).setValue(5);
		
		Piece p = b.pieceAt(5, 2);
		
		System.out.println(b);
		
		b.move(p, BoardBase.Direction.DOWN);
		
		System.out.println(b);
	}
}
