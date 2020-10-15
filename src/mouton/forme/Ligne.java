package mouton.forme;

public class Ligne extends Forme implements Transformable, Calcul, Comparable<Forme>{
	

	private int longueur;
	private Point point;
	
	public Ligne(final int x1, final int y1, final int x2, final int y2, final int longueur) {
		super(new Point(x1, y1)); 
		this.point = new Point(x2, y2);
		this.longueur = longueur;
	}


	@Override
	public int compareTo(Forme arg0) {
		return (int) (this.perimetre() - arg0.perimetre());
	}

	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double air() {
		// TODO Auto-generated method stub
		return 0;
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


	@Override
	public void homothétie(int rapport) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void translation(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + longueur;
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
		if (longueur != other.longueur)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}



}
