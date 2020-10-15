package mouton.forme;

public class Ellipse extends Forme implements Transformable, Calcul, Comparable<Forme>{


	private int demiGrandAxe, DemiPetitAxe;
	
	public Ellipse(final int x, final int y, final int demiGrandAxe, final int demiPetitAxe) {
		super(new Point(x, y));
		this.demiGrandAxe = demiGrandAxe;
		this.DemiPetitAxe = demiPetitAxe;
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
	public void sym�trieCentrale() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sym�trieAxiale() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void homoth�tie(int rapport) {
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
		result = prime * result + DemiPetitAxe;
		result = prime * result + demiGrandAxe;
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
		Ellipse other = (Ellipse) obj;
		if (DemiPetitAxe != other.DemiPetitAxe)
			return false;
		if (demiGrandAxe != other.demiGrandAxe)
			return false;
		return true;
	}

}
