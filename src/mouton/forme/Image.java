package mouton.forme;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Image implements Iterable<Forme>, Comparable<Image>, Serializable, Transformable, Calcul {

	private static final long serialVersionUID = 8860160605916574856L;
	List<Forme> formes;
	
	/**
	 * 
	 * @param formes
	 * 
	 */
	public Image(final List<Forme> formes) {
		this.formes = formes;
	}
	
	/**
	 * 
	 * @param image
	 */
	public Image(final Image image) {
		this(image.formes);
	}


	@Override
	public Iterator<Forme> iterator() {
		// TODO Auto-generated method stub
		return this.formes.iterator();
	}
	
	/**
	 * 
	 * @return totalPerimetre		la somme du perimetre des formes qui compose l'image
	 * @see Calcul
	 */
	@Override
	public double perimetre() {
		double totalPerimetre = 0;
		for(Forme forme: this) {
			totalPerimetre += forme.perimetre();
		}
		
		return totalPerimetre;
	}
	
	/**
	 * 
	 * @return totalAire		la somme de l'aires des formes qui compose l'image
	 * @see Calcul
	 */
	@Override
	public double air() {
		double totalAire = 0;
		for(Forme forme: this) {
			totalAire += forme.air();
		}
		
		return totalAire;
	}
	
	/**
	 * 
	 * @param seuil		Le périmètre servant de comparaison.
	 * @return cpt		Le nombre d'image ayant un périmètre inferieur à seuil.
	 */
	public int perimetreInferieurA(double seuil) {
		int cpt = 0;
		
		for(Forme forme: this) if(forme.perimetre() < seuil) cpt++;
		
		return cpt;
	}
	
	public void tri() {
		Collections.sort(formes);
	}
	
	@Override
	public int compareTo(Image image) {
		return (int) (this.air() - image.air());
	}
	//Transformation
	
	/**
	 * @see Transformable
	 */
	@Override
	public void homothétie(final int rapport) {
		for(Forme forme: this) forme.homothétie(rapport);
	}
	
	/**
	 * @see Transformable
	 */
	@Override
	public void translation(final int dx, final int dy) {
		for(Forme forme: this) forme.translation(dx, dy);
	}
	
	/**
	 * @see Transformable
	 */
	@Override
	public void rotation() {
		for(Forme forme: this) forme.rotation();
	}
	
	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieCentrale() {
		for(Forme forme: this) forme.symétrieCentrale();
	}
	
	/**
	 * @see Transformable
	 */
	@Override
	public void symétrieAxiale() {
		for(Forme forme: this) forme.symétrieAxiale();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formes == null) ? 0 : formes.hashCode());
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
		Image other = (Image) obj;
		if (formes == null) {
			if (other.formes != null)
				return false;
		} else if (!formes.equals(other.formes))
			return false;
		return true;
	}
}
