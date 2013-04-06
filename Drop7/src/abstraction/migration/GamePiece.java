package abstraction.migration;

import abstraction.AbstractPiece;

public class GamePiece extends AbstractPiece<PieceType>
{
	private boolean remove;
	private int value;
	
	//<editor-fold defaultstate="collapsed" desc="CONSTANTS">
	/**
	 *Used to indicate a piece value when it's in the Mystery 1 stage
	 */
	public static final int MYSTERY_STAGE_1 = -1;
	/**
	 * The mystery 2 stage follows the Mystery 1 stage.
	 *Used to indicate a piece value when it's in the Mystery 2 stage
	 */
	public static final int MYSTERY_STAGE_2 = -2;
	/**
	 *Used to indicate a piece value when it's in the Empty stage
	 */
	public static final int EMPTY = 0;
	//</editor-fold>
	
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
				this.value = MYSTERY_STAGE_1;
				break;
			//makes the piece an empty piece
			case EMPTY:
				this.t = PieceType.EMPTY;
				this.value = EMPTY;
				break;
			//makes the piece a set piece
			default:
				this.t = PieceType.SET;
				this.value = value;
		}
	}

	/**
	 * @return the type of the piece
	 */
	public PieceType getType()
	{
		return t;
	}

	/**
	 * @param type the type of the piece to set
	 */
	public void setType(PieceType type)
	{
		this.t = type;
                
		switch(type)
		{
			case EMPTY:
				setValue(EMPTY);
				break;
			case MYSTERY1:
				setValue(MYSTERY_STAGE_1);
				break;
			case MYSTERY2:
				setValue(MYSTERY_STAGE_2);
				break;
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
	
	public GamePiece(PieceType t, int i, int j)
	{
		super(i, j);
		this.t = t;
	}
}
