package gravityTest;

import gameObjects.Piece;
import java.util.ArrayList;
import terminalGame.TerminalGame;
import utilities.PublicFunctions;

public class GravityTerminal extends TerminalGame
{
	Piece testPiece;
	public GravityTerminal()
	{
		super();
		board.pieceAt(5, 2).setValue(5);
		testPiece = board.pieceAt(6, 2);
	}
	
	public void GravityCheck()
	{
		System.out.println(board);
		
		ArrayList<Piece> column = board.getAllInColumn(testPiece);
		
		StringBuilder strbuilder = new StringBuilder();
		for(Piece p : column)
		{
			Piece bottom = board.getDownPiece(p);
			if(bottom != null)
			{
				System.out.println("Move the piece down");
			}
		}
		System.out.println(strbuilder);
	}
	
	@Override
	public void menu()
	{
		int random;

		while(true)
		{			
			builder.setLength(0);
			System.out.println(board);
			System.out.println("What piece do you want to insert?");
			random = scanner.nextInt();
			scanner.nextLine(); //advance the scanner because nextInt does not read \n
			System.out.println("Where do you want to place the piece?");
			
			String position = scanner.nextLine();
			
			if(position.equalsIgnoreCase("exit"))
			{
				System.out.println("Exiting...");
				System.exit(0);
			}
			else if(position.equalsIgnoreCase("help"))
			{
				System.out.println("Help here!");
			}
			else if(PublicFunctions.isValidPosition(position))
			{
				if(!board.insert(Integer.parseInt(position), random))
				{
					System.out.println("You lose");
					System.exit(0);
				}
				System.out.println("Inserting piece...");
			}
			else
			{
				System.out.println("Invalid Entry");
			}
		}
	}
	
	public static void main(String[] args)
	{
		GravityTerminal g = new GravityTerminal();
		g.GravityCheck();
		//g.menu();
	}
}
