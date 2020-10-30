package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public abstract class Forme implements Comparable<Forme>, Transformable, Calculable{
	
	private Point centre;
	
	/**
	 * 
	 * @param centre  centre  de la forme
	 */
	public Forme(final Point centre) {
		this.centre = centre;
	}
	
	/**
	 * 
	 * @return Centre	Retourne le point qui sert de centre à la forme.
	 */
	public Point getCentre() {return this.centre;}
	
	public int getOrdonneeOrigine(final Point[] axeDeSymetrie) {
		for(Point point: axeDeSymetrie) {
			if(point.getY() == 0) {
				return point.getX();
			}
		}
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		return result;
	}
	
	@Override
	public int compareTo(Forme arg0) {
		return (int) (this.perimetre() - arg0.perimetre());
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
