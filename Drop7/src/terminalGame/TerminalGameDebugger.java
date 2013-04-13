package terminalGame;

import gameObjects.BoardBase;
import gameObjects.Piece;
import java.util.ArrayList;
import utilities.PublicFunctions;

public class TerminalGameDebugger extends TerminalGame
{
	Piece testPiece;
	public TerminalGameDebugger()
	{
		super();
		board.pieceAt(5, 2).setValue(5);
		testPiece = board.pieceAt(6, 2);
	}
	
	public void GravityCheck()
	{
		System.out.println(board);
		
		ArrayList<Piece> column = board.getAllInColumn(testPiece);
		
		for(Piece p : column)
		{
			Piece bottom = board.getDownPiece(p);
			if(bottom != null)
			{
				board.move(p, BoardBase.Direction.DOWN);
			}
		}

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
		TerminalGameDebugger g = new TerminalGameDebugger();
		g.GravityCheck();
		//g.menu();
	}
}
