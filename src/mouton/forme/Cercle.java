package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public class Cercle extends Forme implements Transformable, Calcul, Comparable<Forme>{
	

	private int rayon;
	
	public Cercle(final int x, final int y, final int rayon) {
		super(new Point(x, y));
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
	public double air() {
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
		return "Cercle de centre ("+super.getCentre().getX()+","+super.getCentre().getX()+") et de rayon "+this.getRayon();
	}
	//Tansformation 
	
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
	
	@Override
	public int compareTo(Forme arg0) {
		// TODO Auto-generated method stub
		return (int) (this.perimetre() - arg0.perimetre());
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
