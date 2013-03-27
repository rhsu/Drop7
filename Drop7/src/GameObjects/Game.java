package GameObjects;

/**
 * The class to play to play the game.
 */
public class Game 
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	/**
	 *The game base class
	 */
	protected Board board;
	//</editor-fold>
	
	/**
	 * The base class for playing the game.
	 */
	public Game()
	{
		board = new Board();
	}
	
	/**
	 *Main Method for testing
	 * @param args
	 */
	public static void main(String[] args)
	{
		Game g = new Game();
	}
}
