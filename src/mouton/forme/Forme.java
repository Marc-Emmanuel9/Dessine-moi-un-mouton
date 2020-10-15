package mouton.forme;

public abstract class Forme implements Comparable<Forme>, Transformable, Calcul{
	
	private Point centre;
	
	public Forme(final Point centre) {
		this.centre = centre;
	}

	public Point getCentre() {return this.centre;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Forme other = (Forme) obj;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		return true;
	}
	


}
