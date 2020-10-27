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
	 */
	abstract public void rotation();
	
	/**
	 * 
	 */
	abstract public void symétrieCentrale();
	
	/**
	 * 
	 */
	abstract public void symétrieAxiale();
}
