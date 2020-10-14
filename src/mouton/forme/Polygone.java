package mouton.forme;

public class Polygone extends Forme implements Dessinable, Comparable<Forme>{

	public Polygone(final int x, final int y) {
		super(x, y);
	}

	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Forme forme) {
		return (int) (this.getPerimetre() - forme.getPerimetre());
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
