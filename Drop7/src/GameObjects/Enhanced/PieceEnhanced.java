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
	
	public PieceEnhanced GetLeftPiece(BoardEnhanced board)
	{
		if(this.horizontal == 0) 
		{
			return null;
		}
		else 
		{
			return board.PieceAt(this.horizontal, this.vertical - 1);
		}
	}
	
	public PieceEnhanced GetRightPiece()
	{
		if(this.vertical == 0) 
		{
			return null;
		}
		else 
		{
			return null;
		}
	}
	
	public PieceEnhanced GetUpPiece()
	{
		if(this.vertical == 0) 
		{
			return null;
		}
		else 
		{
			return null;
		}
	}
	
	public PieceEnhanced GetDownPiece()
	{
		if(this.vertical == 0) 
		{
			return null;
		}
		else 
		{
			return null;
		}
	}
}
