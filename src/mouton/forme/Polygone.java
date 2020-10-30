package mouton.forme;

import java.util.Arrays;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public final class Polygone extends Forme implements Comparable<Forme>{
	
	private final Ligne[] sommet;
	
	/**
	 * 
	 * @param centre	point représentant le centre du polygone
	 * @param sommet	tableau de ligne qui compose le polygone
	 */
	public Polygone(final Point centre, final Ligne[] sommet) {
		super(centre);
		this.sommet = sommet;
	}

	/**
	 * @see Calculable
	 */
	@Override
	public double perimetre() {
		int perimetre= 0;
		for(Ligne ligne: sommet) {
			perimetre += ligne.longueur();
		}
		return perimetre;
	}

	/**
	 * @see Calculable
	 */
	@Override
	public double aire() {
		double sum = 0;

		for (int i = 0; i < this.sommet.length - 1; i++) {
			if (i == 0)
				sum += this.sommet[i].getCentre().getX()
						* (this.sommet[i+1].getCentre().getY() - 
									this.sommet[this.sommet.length- 1].getCentre().getY());
			else
				sum += this.sommet[i].getCentre().getX()
				* (this.sommet[i+1].getCentre().getY() - 
							this.sommet[i- 1].getCentre().getY());

		}
		return 0.5 * Math.abs(sum);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void homothétie(int rapport) {
		for(Ligne ligne: sommet) {
			ligne.homothétie(rapport);
		}
		
		this.getCentre().setX(this.getCentre().getX() * rapport);
		this.getCentre().setY(this.getCentre().getY() * rapport);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void translation(int dx, int dy) {
		for(Ligne ligne: sommet) {
			ligne.translation(dx, dy);
		}
		
		this.getCentre().setX(this.getCentre().getX() + dx);
		this.getCentre().setY(this.getCentre().getY() + dy);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void rotation(final int angleDeRotation) {
		for(Ligne ligne: sommet) {
			ligne.rotation(angleDeRotation);
		}
		
		this.getCentre().setX( (int) (this.getCentre().getX()  * Math.cos(angleDeRotation) 
				- this.getCentre().getY() * Math.sin(angleDeRotation)));
		this.getCentre().setY( (int) (this.getCentre().getY()  * Math.cos(angleDeRotation) 
				- this.getCentre().getX() * Math.sin(angleDeRotation)));
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieCentrale(final Point centre) {
		for(Ligne ligne: sommet) {
			ligne.symétrieCentrale(centre);
		}
		
		this.getCentre().setX(2 * centre.getX() - this.getCentre().getX());
		this.getCentre().setY(2 * centre.getY() - this.getCentre().getY());
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieAxiale() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Polygone de centre " + super.getCentre() + " composé de "+this.sommet.length+" arrête.";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(sommet);
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
		Polygone other = (Polygone) obj;
		if (!Arrays.equals(sommet, other.sommet))
			return false;
		return true;
	}
	
}
