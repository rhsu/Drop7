package migration;

/**
 *
 * @author RHsu
 */
public enum PieceType 
{
	/**
	 *Denotes a piece that is empty. The default status
	 */
	EMPTY,
	/**
	 *Denotes a piece that is in the first mystery stage.
	 *A piece in this stage transitions into mystery2
	 */
	MYSTERY1,
	/**
	 *The final stage of mystery. 
	 * A piece in this stage transitions into set.
	 */
	MYSTERY2,
	/**
	 *Denotes that a piece is in its set stage.
	 */
	SET
}
