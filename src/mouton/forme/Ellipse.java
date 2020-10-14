package mouton.forme;

public class Ellipse extends Forme implements Dessinable, Comparable<Forme>{

	private int demiGrandAxe, DemiPetitAxe;
	
	public Ellipse(final int x, final int y, final int demiGrandAxe, final int demiPetitAxe) {
		super(x, y);
		this.demiGrandAxe = demiGrandAxe;
		this.DemiPetitAxe = demiPetitAxe;
	}

	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Forme arg0) {
		return (int) (this.getPerimetre() - arg0.getPerimetre());
	}

	@Override
	public double getPerimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAir() {
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


}
