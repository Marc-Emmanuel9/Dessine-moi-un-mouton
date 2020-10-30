package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public interface Transformable {
	
	/**
	 * 
	 * @param rapport		rapport avec lequel on va multipler les coordonn�es d'un point
	 */
	abstract public void homoth�tie(final int rapport);
	
	/**
	 * 
	 * @param dx	dx a rajouter au coordonn�es x du point � translater		
	 * @param dy	dy a rajouter au coordonn�es y du point � translater
	 */
	abstract public void translation(final int dx, final int dy);
	
	/**
	 * 
	 * @param angleDeRotation angle de rotation
	 */
	abstract public void rotation(final int angleDeRotation);
	
	/**
	 *
	 * @param centre  Sym�trie par rapport au point de coordonn�es x, y
	 */
	abstract public void sym�trieCentrale(final Point centre);
	
	/**
	 * 
	 */
	abstract public void sym�trieAxiale();
}
