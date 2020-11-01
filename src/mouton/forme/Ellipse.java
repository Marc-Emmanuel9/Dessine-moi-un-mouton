package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public final class Ellipse extends Forme{


	private final int demiGrandAxe, demiPetitAxe;
	
	/**
	 * 
	 * @param point		point centrale de la forme 
	 * @param demiGrandAxe	demi grand axe de l'ellipse
	 * @param demiPetitAxe 	demi petit axe de l'ellipse
	 */
	public Ellipse(final Point point, final int demiGrandAxe, final int demiPetitAxe) {
		super(point);
		this.demiGrandAxe = demiGrandAxe;
		this.demiPetitAxe = demiPetitAxe;
	}

	
	/**
	 * @see Calculable
	 */
	@Override
	public double perimetre() {
		return 2 * Math.PI 
				* Math.sqrt((Math.pow(this.demiGrandAxe, 2) + Math.pow(this.demiPetitAxe, 2))/2);
	}
	
	/**
	 * @see Calculable
	 */
	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return Math.PI * this.demiGrandAxe * this.demiPetitAxe;
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void homoth�tie(int rapport) {
		this.getCentre().setX(this.getCentre().getX() * rapport);
		this.getCentre().setY(this.getCentre().getY() * rapport);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void translation(int dx, int dy) {
		this.getCentre().setX(this.getCentre().getX() + dx);
		this.getCentre().setY(this.getCentre().getY() + dy);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void rotation(final int angleDeRotation) {
		this.getCentre().setX( (int) (this.getCentre().getX()  * Math.cos(angleDeRotation) 
				- this.getCentre().getY() * Math.sin(angleDeRotation)));
		this.getCentre().setY( (int) (this.getCentre().getY()  * Math.cos(angleDeRotation) 
				- this.getCentre().getX() * Math.sin(angleDeRotation)));
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void sym�trieCentrale(final Point centre) {
		this.getCentre().setX(2 * centre.getX() - this.getCentre().getX());
		this.getCentre().setY(2 * centre.getY() - this.getCentre().getY());
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void sym�trieAxiale() {

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
