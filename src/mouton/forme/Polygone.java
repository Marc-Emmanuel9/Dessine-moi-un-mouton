package mouton.forme;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public final class Polygone extends Forme implements Comparable<Forme>{
	
	private final Ligne[] sommet;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Polygone(final Point centre, final Ligne[] sommet) {
		super(centre);
		this.sommet = sommet;
	}

	/**
	 * @see Calcul
	 */
	@Override
	public double perimetre() {
		int perimetre= 0;
		for(Ligne ligne: sommet) {
			perimetre += ligne.longueur();
		}
		return perimetre;
	}

	/**
	 * @see Calcul
	 */
	@Override
	public double aire() {
		double sum = 0;

		for (int i = 0; i < this.sommet.length - 1; i++) {
			if (i == 0)
				sum += this.sommet[i].getCentre().getX()
						* (this.sommet[i+1].getCentre().getY() - 
									this.sommet[this.sommet.length- 1].getCentre().getY());
			else
				sum += this.sommet[i].getCentre().getX()
				* (this.sommet[i+1].getCentre().getY() - 
							this.sommet[i- 1].getCentre().getY());

		}
		return 0.5 * Math.abs(sum);
	}
	
	@Override
	public String toString() {
		return "Polygone de centre " + super.getCentre() + " composé de "+this.sommet.length+" arrête.";
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
