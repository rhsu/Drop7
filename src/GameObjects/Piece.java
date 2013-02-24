package GameObjects;

import Core.PublicFunctions;

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
	
	//<editor-fold defaultstate="collapsed" desc="PRIVATE">
	private int value;
	private Type type;
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
	 * Creates a new piece based off of the type
	 * @param type
	 */
	public Piece(Type type)
	{
		this.type = type;
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
	
	private Piece(Type type, int value)
	{
		this.type = type;
		this.value = value;
	}
	
	public static Piece CreateRandomPiece()
	{
		int random = PublicFunctions.GetRandomNumberPiece();
		switch(random)
		{
			case 8:
				return new Piece(Type.MYSTERY1);
			default:
				return new Piece(Type.NEW, random);
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
		Piece p1 = new Piece(Type.MYSTERY1);
		Piece p2 = new Piece(Type.NEW);
		System.out.println(p1 + " " + p2);
	}
}

