package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Polygone extends Forme implements Transformable, Calcul, Comparable<Forme>{

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Polygone(final int x, final int y) {
		super(new Point(x, y));
	}
	
	@Override
	public int compareTo(Forme forme) {
		return (int) (this.perimetre() - forme.perimetre());
	}

	/**
	 * @see Calcul
	 */
	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see Calcul
	 */
	@Override
	public double air() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void rotation() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieCentrale() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieAxiale() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void homothétie(int rapport) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void translation(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

}
