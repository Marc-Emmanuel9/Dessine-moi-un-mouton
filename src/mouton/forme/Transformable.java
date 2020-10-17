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
	public void homoth�tie(final int rapport);
	
	/**
	 * 
	 * @param dx			
	 * @param dy
	 */
	public void translation(final int dx, final int dy);
	
	/**
	 * 
	 */
	abstract public void rotation();
	
	/**
	 * 
	 */
	abstract public void sym�trieCentrale();
	
	/**
	 * 
	 */
	abstract public void sym�trieAxiale();
}
