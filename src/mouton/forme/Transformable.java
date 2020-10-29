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
	abstract public void homoth�tie(final int rapport);
	
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
	 * Sym�trie par rapport au point de coordonn�es x, y
	 * @param centre 
	 */
	abstract public void sym�trieCentrale(final Point centre);
	
	/**
	 * 
	 */
	abstract public void sym�trieAxiale();
}
