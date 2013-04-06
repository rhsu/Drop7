package abstraction;

public abstract class AbstractPiece<T>
{
	//<editor-fold  defaultstate="collpased" desc="MEMBER VARIABLES">
	private int horizontal;
	private int vertical;
	protected T piece;
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="ACCESSORS">
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
	//</editor-fold>
	
	public AbstractPiece(T t,int i, int j)
	{
		//piece = (T) new Object(); //commenting out because method is unsafe
		this.horizontal = i;
		this.vertical = i;
	}
		
}
