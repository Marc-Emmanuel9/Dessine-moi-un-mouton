package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public interface Transformable {
	
	/**
	 * 
	 * @param rapport
	 */
	abstract public void homothétie(final int rapport);
	
	/**
	 * 
	 * @param dx			
	 * @param dy
	 */
	abstract public void translation(final int dx, final int dy);
	
	/**
	 * 
	 * @param angleDeRotation
	 * @param origine
	 */
	abstract public void rotation(final int angleDeRotation, final Point origine);
	
	/**
	 * Symétrie par rapport au point de coordonnées x, y
	 * @param centre 
	 */
	abstract public void symétrieCentrale(final Point centre);
	
	/**
	 * 
	 */
	abstract public void symétrieAxiale();
}
