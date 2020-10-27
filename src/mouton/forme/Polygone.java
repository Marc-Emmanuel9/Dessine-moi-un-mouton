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
		return 0;
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme rotation() {
		Ligne[] sommetBis = new Ligne[sommet.length];
		for(int i = 0; i < sommet.length; i++) {
			sommetBis[i] = (Ligne) sommet[i].rotation();
		}
		return new Polygone(new Point(this.getCentre().getX(), this.getCentre().getY())
							, sommetBis);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme symétrieCentrale() {
		Ligne[] sommetBis = new Ligne[sommet.length];
		for(int i = 0; i < sommet.length; i++) {
			sommetBis[i] = (Ligne) sommet[i].symétrieCentrale();
		}
		return new Polygone(new Point(this.getCentre().getX() , this.getCentre().getY())
							, sommetBis);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme symétrieAxiale() {
		Ligne[] sommetBis = new Ligne[sommet.length];
		for(int i = 0; i < sommet.length; i++) {
			sommetBis[i] = (Ligne) sommet[i].symétrieAxiale();
		}
		return new Polygone(new Point(this.getCentre().getX() , this.getCentre().getY())
							, sommetBis);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme homothétie(final int rapport) {
		Ligne[] sommetBis = new Ligne[sommet.length];
		for(int i = 0; i < sommet.length; i++) {
			sommetBis[i] = (Ligne) sommet[i].homothétie(rapport);
		}
		return new Polygone(new Point(this.getCentre().getX()*rapport, this.getCentre().getY()*rapport)
							, sommetBis);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public Forme translation(final int dx, final int dy) {
		Ligne[] sommetBis = new Ligne[sommet.length];
		for(int i = 0; i < sommet.length; i++) {
			sommetBis[i] = (Ligne) sommet[i].translation(dx, dy);
		}
		return new Polygone(new Point(this.getCentre().getX() + dx, this.getCentre().getY() + dy)
							, sommetBis);
	}
	
	@Override
	public String toString() {
		return "Polygone de centre " + super.getCentre() + " composé de "+this.sommet.length+" arrête.";
	}
}
