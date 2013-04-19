package terminalGame;

import abstraction.temp.StaticAbstractBoards;
import utilities.PublicFunctions;

/**
 *The terminal game for simple game play.
 * Mystery pieces are not generated
 * The board that is created is set to be an empty board
 */
public class SimpleTerminalGame extends TerminalGame
{
	/**
	 * Constructor. Creates an empty board
	 */
	SimpleTerminalGame()
	{
		super();
		board = StaticAbstractBoards.getEmptyBoard();
	}
	
	/**
	 * The menu for the simple terminal game
	 */
	@Override
	public void menu()
	{
		int random = PublicFunctions.getRandomNumber();
		
		while(true)
		{			
			builder.setLength(0);
			
			//Print out the status
			builder.append("The new piece is ").append(random).append("\n");
			builder.append(board.toString());
			System.out.println(builder);
			
			//Prompt starts here
			System.out.println("Where do you want to place the piece?");
			
			String position = scanner.nextLine();
			
			if(position.equalsIgnoreCase("exit"))
			{
				System.out.println("Exiting...");
				//dump stats here
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
					//dump statistics here
					System.exit(0);
				}
				System.out.println("Inserting piece...");

				//Generate random number for next interation
				random = PublicFunctions.getRandomNumber();
			}
			else
			{
				System.out.println("Invalid Entry");
			}
		}
	}
}