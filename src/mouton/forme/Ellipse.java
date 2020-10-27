package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public final class Ellipse extends Forme implements Comparable<Forme>{


	private final int demiGrandAxe, demiPetitAxe;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param demiGrandAxe
	 * @param demiPetitAxe
	 */
	public Ellipse(final Point point, final int demiGrandAxe, final int demiPetitAxe) {
		super(point);
		this.demiGrandAxe = demiGrandAxe;
		this.demiPetitAxe = demiPetitAxe;
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
	public double aire() {
		// TODO Auto-generated method stub
		return 0;
	}
	
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
		return new Ellipse(new Point(this.getCentre().getX() + dx, this.getCentre().getY() + dy)
				, demiGrandAxe, demiPetitAxe);
				
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + demiPetitAxe;
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
		if (demiPetitAxe != other.demiPetitAxe)
			return false;
		if (demiGrandAxe != other.demiGrandAxe)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Ellipse de centre " + super.getCentre() + " et, de demi grand axe " + this.demiGrandAxe 
				+ " et demi petit axe " + this.demiPetitAxe;
	}
}
