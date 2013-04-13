/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalGame;

import gameObjects.Game;
import java.util.Scanner;

public class TerminalGameMain 
{
	public static void main(String[] args)
	{
		Game g;
		System.out.println("Which terminal Game do you want to use?");
		System.out.println("Press 1: for TerminalGame");
		System.out.println("Press 2: for GameDebugger");
		System.out.println("Press 3: for Simple Terminal Game");
		
		Scanner sc = new Scanner(System.in);
		
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
