package GameObjects;

import PublicLibrary.PublicFunctions;

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
		if(value == 8) 
		{
                    this.value =  MYSTERY_STAGE_1;
		}
		this.value = value;
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
	}
	
	public int getHorizontal()
	{
		return this.horizontal;
	}
	
	public int getVertical()
	{
		return this.vertical;
	}
	//</editor-fold>
	
	/**
	 * An enumeration representing the type that a piece can be
	 */
	public enum Type
	{
		MYSTERY1,
		MYSTERY2,
		NEW,
		EMPTY
	}
	
	/**
	 * Constructs a piece object
	 * @param type The type of the piece 
	 * @param horizontal The horizontal index
	 * @param vertical The vertical index
	 */
	public Piece(Type type, int i, int j)
	{
		this.type = type;
		this.horizontal = i;
		this.vertical = j;
		switch(type)
		{
			case MYSTERY1:
				value = MYSTERY_STAGE_1;
				break;
			case MYSTERY2:
				value = MYSTERY_STAGE_2;
				break;
			case NEW:
				value = PublicFunctions.getRandomNumber();
				break;
			case EMPTY:
				value = EMPTY;
				break;
		}
	}
	
	@Override
	/**
	 * returns a text representation of the piece.
	 */
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

