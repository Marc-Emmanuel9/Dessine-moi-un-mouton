package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public final class Ligne extends Forme{
	

	private final int epaisseur;
	private Point point;
	
	/**
	 * 
	 * @param p1	point du début de la ligne.
	 * @param p2	point de fin de la ligne.
	 * @param epaisseur	epaisseur de la ligne.
	 */
	public Ligne(final Point p1, final Point p2, final int epaisseur) {
		super(p1); 
		this.point = p2;
		this.epaisseur = epaisseur;
	}


	/**
	 * @see Calculable
	 */
	@Override
	public double perimetre() {
		return this.longueur() + 2 * this.epaisseur;
	}

	/**
	 * @see Calculable
	 */
	@Override
	public double aire() {
		return this.longueur()*this.epaisseur;
	}
	
	/**
	 * 
	 * @return longueur		la longueur de la ligne
	 */
	public int longueur() {
		return (int) Math.sqrt(Math.pow(this.getCentre().getX() - this.point.getX(), 2) + 
					Math.pow(this.getCentre().getY() - this.point.getY(), 2));
	}
	
	/**
	 * 
	 * @return Point	retourne l'extrémité de la ligne
	 */
	public Point getEnd() {
		return this.point;
	}
	
	/**
	 * @see Transformable
	 */
	@Override
	public void homothétie(int rapport) {
		this.getCentre().setX(this.getCentre().getX() * rapport);
		this.getCentre().setY(this.getCentre().getY() * rapport);
		
		this.point.setX(this.point.getX() * rapport);
		this.point.setY(this.point.getY() * rapport);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void translation(int dx, int dy) {
		this.getCentre().setX(this.getCentre().getX() + dx);
		this.getCentre().setY(this.getCentre().getY() + dy);
		
		this.point.setX(this.point.getX() + dx);
		this.point.setY(this.point.getY() + dy);
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
		
		this.point.setX( (int) (this.point.getX()  * Math.cos(angleDeRotation) 
				- this.point.getY() * Math.sin(angleDeRotation)));
		this.point.setY( (int) (this.point.getY()  * Math.cos(angleDeRotation) 
				- this.point.getX() * Math.sin(angleDeRotation)));
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieCentrale(final Point centre) {
		this.getCentre().setX(2 * centre.getX() - this.getCentre().getX());
		this.getCentre().setY(2 * centre.getY() - this.getCentre().getY());
		
		this.point.setX(2 * centre.getX() - this.getCentre().getX());
		this.point.setY(2 * centre.getY() - this.getCentre().getY());
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieAxiale() {
		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + epaisseur;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
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
		Ligne other = (Ligne) obj;
		if (epaisseur != other.epaisseur)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ligne allant des coordonnées " + super.getCentre() + " à " + this.point +
				" et d'epaisseur " + this.epaisseur;
	}

}
