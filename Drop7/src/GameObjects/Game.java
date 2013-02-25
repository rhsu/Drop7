package GameObjects;

import Core.PublicFunctions;
import java.util.Scanner;

/**
 * The class to play to play the game.
 */
public class Game 
{
	//<editor-fold defaultstate="collapsed" desc="PRIVATE">
	private Board board;
	private Scanner scanner;
	private StringBuilder builder;
	//</editor-fold>
	
	/**
	 * Constructs a board to play the game on
	 */
	public Game()
	{
		builder = new StringBuilder();
		board = new Board();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * The main UI of the game.
	 */
	public void Menu()
	{
		while(true)
		{
		
			Piece RandomPiece = Piece.CreateRandomPiece();
			
			builder.setLength(0);
			builder.append("The new piece is ").append(RandomPiece.toString()).append("\n");
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
				if(!board.Insert(Integer.parseInt(position), RandomPiece.getValue()))
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
		Game g = new Game();
		g.Menu();
	}
}
