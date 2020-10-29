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
		return 2 * Math.PI * this.rayon;
	}
	
	/**
	 * @see Calcul
	 */
	@Override
	public double aire() {
		return Math.PI * Math.pow(this.rayon, 2);
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

	@Override
	public void homothétie(int rapport) {
		this.getCentre().setX(this.getCentre().getX() * rapport);
		this.getCentre().setY(this.getCentre().getY() * rapport);
	}

	@Override
	public void translation(int dx, int dy) {
		this.getCentre().setX(this.getCentre().getX() + dx);
		this.getCentre().setY(this.getCentre().getY() + dy);
	}

	@Override
	public void rotation(final int angleDeRotation, final Point origine) {
		int r = (int) Math.sqrt(Math.pow(this.getCentre().getX() - origine.getX(), 2) + 
				Math.pow(this.getCentre().getY() - origine.getY(), 2));
		
		this.getCentre().setX( (int) (this.getCentre().getX()  * Math.cos(angleDeRotation) 
				- this.getCentre().getY() * Math.sin(angleDeRotation)));
		this.getCentre().setY( (int) (this.getCentre().getY()  * Math.cos(angleDeRotation) 
				- this.getCentre().getX() * Math.sin(angleDeRotation)));
	}

	@Override
	public void symétrieCentrale(final Point centre) {
		this.getCentre().setX(2 * centre.getX() - this.getCentre().getX());
		this.getCentre().setY(2 * centre.getY() - this.getCentre().getY());
	}

	@Override
	public void symétrieAxiale() {
		// TODO Auto-generated method stub
		
	}
	
}
