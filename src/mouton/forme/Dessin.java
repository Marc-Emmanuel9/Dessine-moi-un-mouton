package mouton.forme;

import java.util.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Dessin implements Iterable<Image>, Calcul {
	
	/**
	 * 
	 */
	private Set<Image> images;
	
	/**
	 * 
	 * @param images
	 */
	public Dessin(final Set<Image> images) {
		this.images = images;
	}
	
	/**
	 * 
	 * @param dessin
	 */
	public Dessin(final Dessin dessin) {
		this(dessin.images);
	}

	@Override
	public Iterator<Image> iterator() {
		// TODO Auto-generated method stub
		return this.images.iterator();
	}
	
	/**
	 * 
	 * @param seuil		L'air servant de comparaison.
	 * @return cpt		Le nombre d'image ayant une air inferieur � seuil.
	 */
	public int airInferieurA(double seuil) {
		int cpt = 0;
		
		for(Image image: this) if(image.aire() < seuil) cpt++;
		
		return cpt;
	}
	
	public void sort() {
		List<Image> imagesBis = new ArrayList<Image>(images);
		Collections.sort(imagesBis);
		this.images = new HashSet<>(imagesBis);
	}
	
	/**
	 * @see Calcul		Interface listant toute ces fonction.
	 */
	@Override
	public double perimetre() {
		double totalPerimetre = 0;
		for(Image image: this) {
			totalPerimetre += image.perimetre();
		}
		
		return totalPerimetre;
	}
	
	/**
	 * @see Calcul		Interface listant toute ces fonction.
	 */
	@Override
	public double aire() {
		double totalAire = 0;
		for(Image image: this) {
			totalAire += image.aire();
		}
		
		return totalAire;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((images == null) ? 0 : images.hashCode());
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
		Dessin other = (Dessin) obj;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		return true;
	}


}
