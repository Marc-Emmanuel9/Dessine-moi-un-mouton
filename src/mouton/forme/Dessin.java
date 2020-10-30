package mouton.forme;

import java.util.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Dessin implements Iterable<Image>, Calculable, Transformable {
	
	
	private Set<Image> images;
	
	/**
	 * 
	 * @param images	Liste des images contenue dans le dessin
	 */
	public Dessin(final Set<Image> images) {
		this.images = images;
	}
	
	/**
	 * 
	 * @param dessin		Constructeur de copie
	 */
	public Dessin(final Dessin dessin) {
		this(dessin.images);
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
	 * @see Calculable
	 * @return totalPerimetre	la somme du p�rimetre des formes qui compose le dessin
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
	 * @see Calculable
	 * @return totalAire	la somme de l'aires des formes qui compose le dessin
	 */
	@Override
	public double aire() {
		double totalAire = 0;
		for(Image image: this) {
			totalAire += image.aire();
		}
		
		return totalAire;
	}
	
	/**
	 * @see Transformable
	 */
	@Override
	public void homoth�tie(final int rapport) {
		for(Image image: this) image.homoth�tie(rapport);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void translation(final int dx, final int dy) {
		for(Image image: this) image.translation(dx, dy);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void rotation(final int angleDeRotation) {
		for(Image image: this) image.rotation(angleDeRotation);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void sym�trieCentrale(final Point centre) {
		for(Image image: this) image.sym�trieCentrale(centre);
	}

	/**
	 * @see Transformable
	 */
	@Override
	public void sym�trieAxiale() {
		for(Image image: this) image.sym�trieAxiale();
	}

	@Override
	public Iterator<Image> iterator() {
		// TODO Auto-generated method stub
		return this.images.iterator();
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
