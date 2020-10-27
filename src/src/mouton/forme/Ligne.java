package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Ligne extends Forme implements Comparable<Forme>{
	

	private final int epaisseur;
	private final Point point;
	
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param epaisseur
	 */
	public Ligne(final Point p1, final Point p2, final int epaisseur) {
		super(p1); 
		this.point = p2;
		this.epaisseur = epaisseur;
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
	
	public int longueur() {
		return (int) Math.sqrt(Math.pow(this.getCentre().getX() - this.point.getX(), 2) + 
					Math.pow(this.getCentre().getY() - this.point.getY(), 2));
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


	@Override
	public void homothétie(int rapport) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void translation(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void rotation() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void symétrieCentrale() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void symétrieAxiale() {
		// TODO Auto-generated method stub
		
	}
	
}
