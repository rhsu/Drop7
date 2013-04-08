package abstraction;

public abstract class AbstractPiece<T>
{
	//<editor-fold  defaultstate="collpased" desc="MEMBER VARIABLES">
	private int horizontal;
	private int vertical;
	protected T t;
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
	
	public T getType()
	{
		return t;
	}
	
	public void setType(T t)
	{
		this.t = t;
	}
	
	
	//</editor-fold>
	
	public AbstractPiece(int i, int j)
	{
		//piece = (T) new Object(); //commenting out because method is unsafe
		this.horizontal = i;
		this.vertical = i;
	}
	
	@Override
	public String toString()
	{
		return t.toString();
	}
}
