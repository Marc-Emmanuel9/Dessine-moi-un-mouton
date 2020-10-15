package mouton.forme;

public class Polygone extends Forme implements Transformable, Calcul, Comparable<Forme>{

	
	public Polygone(final int x, final int y) {
		super(new Point(x, y));
	}

	@Override
	public int compareTo(Forme forme) {
		return (int) (this.perimetre() - forme.perimetre());
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

}
