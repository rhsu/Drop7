package abstraction.migration;

import abstraction.AbstractPiece;
import abstraction.miscellaneous.PublicFunctions;

/**
 *An implementation of AbstractPiece using PieceType as the Generic type
 */
public class GamePiece extends AbstractPiece<PieceType>
{
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	private boolean remove;
	private int value;
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="CONSTANTS">
	/**
	 *Used to indicate a piece value when it's in the Mystery 1 stage
	 */
	public static final int MYSTERY1_VALUE = -1;
	/**
	 * The mystery 2 stage follows the Mystery 1 stage.
	 *Used to indicate a piece value when it's in the Mystery 2 stage
	 */
	public static final int MYSTERY2_VALUE = -2;
	/**
	 *Used to indicate a piece value when it's in the Empty stage
	 */
	public static final int EMPTY_VALUE = 0;
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="ACCESSORS">
	/**
	 * @return the pieces value
	 */
	public int getValue()
	{
            return value;
	}
	
	/**
	* @param value the value to set
	*/
	public void setValue(int value)
	{
		switch(value)
		{
			//makes the piece a mystery piece
			case 8:
				this.t = PieceType.MYSTERY1;
				this.value = MYSTERY1_VALUE;
			//makes the piece an empty piece
			case EMPTY_VALUE:
				this.t = PieceType.EMPTY;
				this.value = MYSTERY1_VALUE;
				break;
			//makes the piece a set piece
			default:
				this.t = PieceType.SET;
				this.value = value;
		}
	}
	
	/**
	 * 
	 * @return the remove boolean
	 */
	public boolean getRemove()
	{
		return this.remove;
	}
    
	/**
	 *
	 * @param b
	 */
	public void setRemove(boolean b)
	{
		this.remove = b;
	}
	//</editor-fold>
	
	/**
	 * Constructor 
	 * @param t the type
	 * @param i the horizontal index
	 * @param j the vertical index
	 */
	public GamePiece(PieceType t, int i, int j)
	{
		super(i, j);
		this.t = t;
		
		switch(t)
		{
			case MYSTERY1:
				value = MYSTERY1_VALUE;
				break;
			case MYSTERY2:
				value = MYSTERY2_VALUE;
				break;
			case SET:
				value = PublicFunctions.getRandomNumber();
				break;
			case EMPTY:
				value = EMPTY_VALUE;
				break;
				
		}
	}
	
	/**
	 * This does not call toString on PieceType. The returned string is " " for 
	 * empty, "#" for MYSTERY1, and "@" for MYSTERY2
	 * @return a string representation of a GamePiece
	 */
	@Override
	public String toString()
	{
		switch(t)
		{
			case EMPTY:
				return " ";
			case MYSTERY1:
				return "#";
			case MYSTERY2:
				return "@";
			default:
				return Integer.toString(this.getValue());
		}
	}
}
