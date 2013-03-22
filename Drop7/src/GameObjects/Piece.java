package GameObjects;

import Utilities.PublicFunctions;

/**
 *
 * @author RHsu
 */
public class Piece
{
	//<editor-fold defaultstate="collapsed" desc="CONSTANTS">
	public static final int MYSTERY_STAGE_1 = -1;
	public static final int MYSTERY_STAGE_2 = -2;
	public static final int EMPTY = 0;
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="MEMBER VARIABLES">
	private int value;
	private Type type;
	private int horizontal;
	private int vertical;
	private boolean remove;
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
			//set the piece to be mystery. This happens during piece generation
			case 8:
				this.type = Type.MYSTERY1;
				this.value = MYSTERY_STAGE_1;
				break;
			case EMPTY:
				this.type = Type.EMPTY;
				this.value = EMPTY;
				break;
			default:
				this.type = Type.SET;
				this.value = value;
		}
	}

	/**
	 * @return the type of the piece
	 */
	public Type getType()
	{
		return type;
	}

	/**
	 * @param type the type of the piece to set
	 */
	public void setType(Type type)
	{
		this.type = type;
                
                switch(type)
                {
                    case EMPTY:
                        setValue(EMPTY);
                        break;
                    case MYSTERY1:
                        setValue(EMPTY);
                        break;
                    case MYSTERY2:
                        setValue(EMPTY);
                        break;
                }
	}
	
	/**
	 * @return the horizontal
	 */
	public int getHorizontal()
	{
		return this.horizontal;
	}
	
	/**
	 * 
	 * @return the vertical 
	 */
	public int getVertical()
	{
		return this.vertical;
	}
        
	/**
	 * 
	 * @return the remove boolean
	 */
	public boolean getRemove()
	{
            return this.remove;
	}
        
	public void setRemove()
	{
            this.remove = true;
        }
        
	//</editor-fold>
	
	/**
	 * An enumeration representing the type that a piece can be
	 */
	public enum Type
	{
		MYSTERY1,
		MYSTERY2,
		SET,
		EMPTY
	}
	
	/**
	 * Constructs a piece object
	 * @param type The type of the piece 
	 * @param i The horizontal index
	 * @param j The vertical index
	 */
	public Piece(Type type, int i, int j)
	{
		this.type = type;
		this.horizontal = i;
		this.vertical = j;
		this.remove = false;
		
		switch(type)
		{
			case MYSTERY1:
				value = MYSTERY_STAGE_1;
				break;
			case MYSTERY2:
				value = MYSTERY_STAGE_2;
				break;
			case SET:
				value = PublicFunctions.getRandomNumber();
				break;
			case EMPTY:
				value = EMPTY;
				break;
		}
	}
	
	@Override
	public String toString()
	{
		switch(type)
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

	public static void main(String[] args)
	{

	}
}

