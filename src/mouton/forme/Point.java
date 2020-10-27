package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public final class Point{

	private final int x;
	private final int y;
	
	/**
	 *
	 * @param x
	 * @param y
	 */
	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return x	La coordonnée x du point
	 */
	public int getX() {return this.x;}
	
	/**
	 * 
	 * @return y	La coordonnée y du point
	 */
	public int getY() {return this.y;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
