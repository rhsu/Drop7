package test;

import oldGameObjects.Board;
import oldGameObjects.Piece;


public class workspace 
{
	public static void main(String... args)
	{
		Board b = new Board();
		Piece p = b.pieceAt(1, 6);
		System.out.println(b);
		System.out.println(p);
	}
	
}
