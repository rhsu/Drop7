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
System.out.println("HERE???");
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
		
	public Piece(Type type, int horizontal, int vertical)
	{
		this.type = type;
		this.horizontal = horizontal;
		this.vertical = vertical;
		switch(type)
		{
			case MYSTERY1:
				value = MYSTERY_STAGE_1;
				break;
			case MYSTERY2:
				value = MYSTERY_STAGE_2;
				break;
			case NEW:
				value = PublicFunctions.GetRandomNumber();
				break;
			case EMPTY:
				value = EMPTY;
				break;
		}
	}
	
	@Override
	/**
	 * returns a textual representation of the piece.
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

