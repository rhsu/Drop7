package GameObjects;

/**
 * The class to play to play the game.
 */
public class Game 
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	protected Board board;
	//</editor-fold>
	
	/**
	 * Constructs a board to play the game on
	 */
	public Game()
	{
		board = new Board();
	}
	
	public static void main(String[] args)
	{
		Game g = new Game();
	}
}
