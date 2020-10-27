package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public final class Cercle extends Forme implements Comparable<Forme>{
	

	private  final int rayon;
	
	public Cercle(final Point point, final int rayon) {
		super(point);
		this.rayon = rayon;
	}
	
	/**
	 * @see Calcul
	 */
	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0.0;
	}
	
	/**
	 * @see Calcul
	 */
	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 
	 * @return rayon		Le rayon du cercle
	 */
	public int getRayon() {
		return rayon;
	}
	
	@Override
	public String toString() {
		return "Cercle de centre "+super.getCentre()+" et de rayon "+this.getRayon();
	}
	//Tansformation 
	
	/**
	 * @see Transformable
	 */
	@Override
	public Forme rotation() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme symétrieCentrale() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme symétrieAxiale() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme homothétie(int rapport) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme translation(int dx, int dy) {
		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + rayon;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cercle other = (Cercle) obj;
		if (rayon != other.rayon)
			return false;
		return true;
	}
	
}
