package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Ellipse extends Forme implements Transformable, Calcul, Comparable<Forme>{


	private int demiGrandAxe, DemiPetitAxe;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param demiGrandAxe
	 * @param demiPetitAxe
	 */
	public Ellipse(final int x, final int y, final int demiGrandAxe, final int demiPetitAxe) {
		super(new Point(x, y));
		this.demiGrandAxe = demiGrandAxe;
		this.DemiPetitAxe = demiPetitAxe;
	}

	@Override
	public int compareTo(Forme arg0) {
		return (int) (this.perimetre() - arg0.perimetre());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + DemiPetitAxe;
		result = prime * result + demiGrandAxe;
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
		Ellipse other = (Ellipse) obj;
		if (DemiPetitAxe != other.DemiPetitAxe)
			return false;
		if (demiGrandAxe != other.demiGrandAxe)
			return false;
		return true;
	}

}
