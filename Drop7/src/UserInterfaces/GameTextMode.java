package UserInterfaces;

import GameObjects.Game;
import PublicLibrary.PublicFunctions;
import java.util.Scanner;

public class GameTextMode extends Game
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	private Scanner scanner;
	private StringBuilder builder;
	//</editor-fold>
	
	/**
	 * A terminal GUI of the Drop7 game
	 */
	public GameTextMode()
	{
		super();
		builder = new StringBuilder();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * The main UI of the GameTextMode class
	 */
	public void Menu()
	{
		while(true)
		{
		
			int random = PublicFunctions.GetRandomNumberPiece();
			
			builder.setLength(0);
			
			if(random == 8)
			{
				builder.append("The new piece is mystery piece").append("\n");
			}
			else
			{
				builder.append("The new piece is ").append(random).append("\n");
			}

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
				//TODO: Should not generate a new piece
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
				//TODO: Should not generate a new piece
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
