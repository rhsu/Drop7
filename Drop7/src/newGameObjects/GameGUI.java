package newGameObjects;

/**
 * An abstract class for creating a GUI for playing the game.
 */
public abstract class GameGUI 
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	/**
	 * The board object for the Drop7 Game to be played on
	 */
	protected GameBoard board;
	//</editor-fold>
	
	/**
	 * This constructor allocates a new Board Object
	 */
	public GameGUI()
	{
		board = new GameBoard();
	}
	
	/**
	 * Overridable method to display the menu
	 */
	public void menu()
	{
		
	}
}
