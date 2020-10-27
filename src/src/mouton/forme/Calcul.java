package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public interface Calcul {
	
	/**
	 * 
	 * @return Perimetre		Le périmètre de la forme
	 */
	abstract public double perimetre();
	
	/**
	 * 
	 * @return Air				L'air de la forme
	 */
	abstract public double aire();
}
