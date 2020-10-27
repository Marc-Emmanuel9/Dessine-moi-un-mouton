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
	abstract public Forme homoth�tie(final int rapport);
	
	/**
	 * 
	 * @param dx			
	 * @param dy
	 */
	abstract public Forme translation(final int dx, final int dy);
	
	/**
	 * 
	 */
	abstract public Forme rotation();
	
	/**
	 * 
	 */
	abstract public Forme sym�trieCentrale();
	
	/**
	 * 
	 */
	abstract public Forme sym�trieAxiale();
}
