package GameObjects.Enhanced;

import GameObjects.Piece;

/**
 *
 * @author RHsu
 */
public class PieceEnhanced extends Piece
{	
	protected int horizontal;
	protected int vertical;
	
	public PieceEnhanced(Type type)
	{
		super(type);
	}
	
	public PieceEnhanced(Type type, int horizontal, int vertical)
	{
		super(type);
		this.horizontal = horizontal;
		this.vertical = vertical;
	}
	
	public PieceEnhanced(Type type, int horizontal, int vertical, int value)
	{
		super(type, value);
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.value = value;
	}
	
	public int GetHorizontal()
	{
		return this.horizontal;
	}
	
	public int GetVertical()
	{
		return this.vertical;
	}
}
