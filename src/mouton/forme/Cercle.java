package mouton.forme;


public class Cercle extends Forme implements Dessinable, Comparable<Forme>{
	
	private int rayon;
	
	public Cercle(final int x, final int y, final int rayon) {
		super(x, y);
		this.rayon = rayon;
	}

	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public double getPerimetre() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public double getAir() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getRayon() {
		return rayon;
	}
	
	@Override
	public String toString() {
		return "Cercle de centre ("+super.getX()+","+super.getY()+") et de rayon "+this.getRayon();
	}
	//Tansformation 
	

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
	public int compareTo(Forme arg0) {
		// TODO Auto-generated method stub
		return (int) (this.getPerimetre() - arg0.getPerimetre());
	}

}
