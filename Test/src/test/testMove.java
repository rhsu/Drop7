package test;

import boardEditor.core.StaticBoards;
import java.util.ArrayList;
import newGameObjects.*;
import terminalGame.TerminalGameDebugger;

public class testMove 
{	
	public static void main(String... args)
	{
		//TerminalGameDebugger terminal = new TerminalGameDebugger();
		//terminal.menu();
		
		GameBoard b = StaticBoards.getEmptyBoard();
		b.pieceAt(1, 3).setValue(5);
		//b.pieceAt(3, j)
		System.out.println(b);
		b.GravityCheck();
		System.out.println(b);
		//b.GravityCheck();
		//System.out.println(b);
		//b.GravityCheck();
		//System.out.println(b);
	}
}
