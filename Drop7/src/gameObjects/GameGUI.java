package gameObjects;

/**
 * An abstract class for creating a GUI for playing the game.
 */
public abstract class GameGUI 
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	/**
	 * The board object for the Drop7 Game to be played on
	 */
	protected Board board;
	//</editor-fold>
	
	/**
	 * This constructor allocates a new Board Object
	 */
	public GameGUI()
	{
		board = new Board();
	}
	
	/**
	 * An overridable 
	 */
	public void menu()
	{
		
	}
}
