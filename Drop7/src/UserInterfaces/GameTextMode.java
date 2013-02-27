package UserInterfaces;

import GameObjects.Game;
import PublicLibrary.PublicFunctions;
import java.util.Scanner;

/**
 *
 * @author RHsu
 */
public class GameTextMode extends Game
{
	private Scanner scanner;
	private StringBuilder builder;
	
	public GameTextMode()
	{
		super();
		builder = new StringBuilder();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * The main UI of the game.
	 */
	public void Menu()
	{
		while(true)
		{
		
			//Piece RandomPiece = Piece.CreateRandomPiece();
			int random = PublicFunctions.GetRandomNumberPiece();
			
			builder.setLength(0);
			builder.append("The new piece is ").append(random).append("\n");
			builder.append(board.toString());
			
			System.out.println(builder);
			
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
			else if(PublicFunctions.IsValidPosition(position))
			{
				if(!board.Insert(Integer.parseInt(position), random))
				{
					System.out.println("You lose");
					//dump statistics here
					System.exit(0);
				}
				System.out.println("Inserting piece...");
				System.out.println(board);
			}
			else
			{
				System.out.println("Invalid Entry");
			}
		}
	}
	
	public static void main(String[] args)
	{
		GameTextMode g = new GameTextMode();
		g.Menu();
	}
}
