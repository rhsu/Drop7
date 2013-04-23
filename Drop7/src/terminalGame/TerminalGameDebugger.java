package terminalGame;

import boardEditor.core.StaticBoards;
import java.util.ArrayList;
import newGameObjects.GameBoard;
import newGameObjects.GamePiece;
import utilities.PublicFunctions;

/**
 *A drop7 terminal game for debugging
 * Generates an empty board for simple game play
 * Prompts the user what type of piece to generate for easy debugging
 * Previously known as Gravity Terminal
 */
public class TerminalGameDebugger extends TerminalGame
{
	GamePiece testPiece;
	
	public GameBoard getBoard()
	{
		return board;
	}
	
	public TerminalGameDebugger()
	{
		super();
		board = StaticBoards.getEmptyBoard();
		board.pieceAt(5, 2).setValue(5);
		testPiece = board.pieceAt(6, 2);
	}
	
	public GamePiece setPiece(int i, int j, int v)
	{
		board.pieceAt(i, j).setValue(v);
		return board.pieceAt(i, j);
	}
		
	/**
	 * Menu function for the TerminalGameDebugger
	 */
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
}
