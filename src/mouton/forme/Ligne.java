package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Ligne extends Forme implements Transformable, Calcul, Comparable<Forme>{
	

	private int epaisseur;
	private Point point;
	
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param epaisseur
	 */
	public Ligne(final int x1, final int y1, final int x2, final int y2, final int epaisseur) {
		super(new Point(x1, y1)); 
		this.point = new Point(x2, y2);
		this.epaisseur = epaisseur;
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



}
