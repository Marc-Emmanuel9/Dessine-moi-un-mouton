package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public interface Transformable {
	
	/**
	 * 
	 * @param rapport		rapport avec lequel on va multipler les coordonnées d'un point
	 */
	abstract public void homothétie(final int rapport);
	
	/**
	 * 
	 * @param dx	dx a rajouter au coordonnées x du point à translater		
	 * @param dy	dy a rajouter au coordonnées y du point à translater
	 */
	abstract public void translation(final int dx, final int dy);
	
	/**
	 * 
	 * @param angleDeRotation angle de rotation
	 */
	abstract public void rotation(final int angleDeRotation);
	
	/**
	 *
	 * @param centre  Symétrie par rapport au point de coordonnées x, y
	 */
	abstract public void symétrieCentrale(final Point centre);
	
	/**
	 * 
	 */
	abstract public void symétrieAxiale();
}
