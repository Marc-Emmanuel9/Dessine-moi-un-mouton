package mouton.forme;

public abstract class Forme implements Comparable<Forme>{
	
	private double air;
	private double perimetre;
	private int x;
	private int y;
	
	public Forme(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	abstract public double getAir();
	abstract public double getPerimetre();
	
	//Transformation
	public void homothétie(final int rapport) {
		this.x *= rapport;
		this.y *= rapport;
	}
	public void translation(final int dx, final int dy) {
		this.x += dx;
		this.y += dy;
	}
	abstract public void rotation();
	abstract public void symétrieCentrale();
	abstract public void symétrieAxiale();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(air);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(perimetre);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Forme other = (Forme) obj;
		if (Double.doubleToLongBits(air) != Double.doubleToLongBits(other.air))
			return false;
		if (Double.doubleToLongBits(perimetre) != Double.doubleToLongBits(other.perimetre))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
