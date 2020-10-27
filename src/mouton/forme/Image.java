package mouton.forme;

import java.util.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Image implements Iterable<Forme>, Comparable<Image>, Calcul {


	Set<Forme> formes;
	
	/**
	 * 
	 * @param formes
	 * 
	 */
	public Image(final Set<Forme> formes) {
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
	public double aire() {
		double totalAire = 0;
		for(Forme forme: this) {
			totalAire += forme.aire();
		}
		
		return totalAire;
	}
	
	/**
	 * 
	 * @param seuil		Le p�rim�tre servant de comparaison.
	 * @return cpt		Le nombre d'image ayant un p�rim�tre inferieur � seuil.
	 */
	public int perimetreInferieurA(double seuil) {
		int cpt = 0;
		
		for(Forme forme: this) if(forme.perimetre() < seuil) cpt++;
		
		return cpt;
	}
	
	
	public void sort() {
		List<Forme> formesBis = new ArrayList<>(formes);
		Collections.sort(formesBis);
		this.formes = new HashSet<>(formesBis);
	}
	
	@Override
	public int compareTo(Image image) {
		return (int) (this.aire() - image.aire());
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
