package terminalGame;

import boardEditor.core.StaticBoards;
import java.util.ArrayList;
import rhsu.board.BoardPiece;
import rhsu.board.testObjects.gameObjects.overhaul.Drop7Piece;
import utilities.PublicFunctions;

/**
 *A drop7 terminal game for debugging
 * Generates an empty board for simple game play
 * Prompts the user what type of piece to generate for easy debugging
 * Previously known as Gravity Terminal
 */
public class TerminalGameDebugger extends TerminalGame
{
	BoardPiece<Drop7Piece> testPiece;
	public TerminalGameDebugger()
	{
		super();
		board = StaticBoards.getEmptyBoard();
		board.pieceAt(5, 2).getValue().setPieceValue(5);
		testPiece = board.pieceAt(6, 2);
	}
	
	/**
	 * Currently in progress function for testing gravity features
	 */
	public void GravityCheck()
	{
		System.out.println(board);
		
		ArrayList<BoardPiece<Drop7Piece>> column = board.getAllPiecesInColumn(testPiece);
		
		for(BoardPiece<Drop7Piece> p : column)
		{
			BoardPiece<Drop7Piece> bottom = board.getDownPiece(p);
			if(bottom != null)
			{
				//board.move(p, BoardBase.Direction.DOWN);
			}
		}

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
