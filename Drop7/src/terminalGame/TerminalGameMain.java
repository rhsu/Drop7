package terminalGame;

import oldGameObjects.GameGUI;
import java.util.Scanner;

public class TerminalGameMain 
{
	/**
	 * The main routine. Prompts the user between the three possible guis
	 * If the user enters an incorrect input, then the default of TerminalGame
	 * will be instatiated
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		GameGUI g;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Which terminal Game do you want to use?");
		System.out.println("Press 1: for TerminalGame");
		System.out.println("Press 2: for GameDebugger");
		System.out.println("Press 3: for Simple Terminal Game");
		
		String i = sc.nextLine();
		switch(i)
		{
			case "1":
				g = new TerminalGame();
				break;
			case "2":
				g = new TerminalGameDebugger(); 
				break;
			case "3":
				g= new SimpleTerminalGame();
				break;
			default:
				System.out.println("Invalid entry!");
				System.out.println("Using the default of Terminal Game");
				g = new TerminalGame();
				break;
		}
		g.menu();
	}
}
