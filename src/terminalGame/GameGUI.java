package terminalGame;

import rhsu.board.testObjects.gameObjects.overhaul.Drop7Board;

/**
 * An abstract class for creating a GUI for playing the game.
 */
public abstract class GameGUI 
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	/**
	 * The board object for the Drop7 Game to be played on
	 */
	protected Drop7Board board;
	//</editor-fold>
	
	/**
	 * This constructor allocates a new Board Object
	 */
	public GameGUI()
	{
		board = new Drop7Board(7,7);
	}
	
	/**
	 * Overridable method to display the menu
	 */
	public void menu()
	{
		
	}
}
