package abstraction;

/**
 * The abstract piece class to compliment the abstract board class.
 * This class is adds two index properties to a given object for easy
 * access in the AbstractBoard object
 * @param <T> Generic Type (any valid object)
 */
public abstract class AbstractPiece<T>
{
	//<editor-fold  defaultstate="collpased" desc="MEMBER VARIABLES">
	/**
	 * The horizontal index of the abstract piece
	 */
	private int horizontal;
	/**
	 * The vertical index of the abstract piece
	 */
	private int vertical;
	/**
	 * The object itself
	 */
	protected T t;
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="ACCESSORS">
	/**
	* @return the horizontal index
	*/
	public int getHorizontal()
	{
		return this.horizontal;
	}
	
	/**
	 * 
	 * @return the vertical index
	 */
	public int getVertical()
	{
		return this.vertical;
	}
	
	/**
	 * 
	 * @return the object itself
	 */
	public T getType()
	{
		return t;
	}
	
	/**
	 * Modifies the object to be the same as the parameter
	 * @param t the value to change into
	 */
	public void setType(T t)
	{
		this.t = t;
	}
	
	
	//</editor-fold>
	
	/**
	 * When implementing an abstract piece
	 * @param i the horizontal index
	 * @param j the vertical index
	 */
	public AbstractPiece(int i, int j)
	{
		//piece = (T) new Object(); //commenting out because method is unsafe
		this.horizontal = i;
		this.vertical = j;
	}
	
	/**
	 * @return a string representation of the generic type
	 */
	@Override
	public String toString()
	{
		return t.toString();
	}
}
