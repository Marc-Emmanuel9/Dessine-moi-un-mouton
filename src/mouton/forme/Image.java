package mouton.forme;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Image implements Iterable<Forme>, Comparable<Image>, Serializable {

	List<Forme> formes;
	
	/**
	 * 
	 * @param formes
	 * 
	 */
	public Image(final List<Forme> formes) {
		this.formes = formes;
	}
	
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
	 * @return double : la somme du perimetre des formes qui compose l'image
	 */
	public double getPerimetre() {
		double totalPerimetre = 0;
		for(Forme forme: this) {
			totalPerimetre += forme.getPerimetre();
		}
		
		return totalPerimetre;
	}
	
	/**
	 * 
	 * @return double : la somme de l'aires des formes qui compose l'image
	 */
	public double getAire() {
		double totalAire = 0;
		for(Forme forme: this) {
			totalAire += forme.getAir();
		}
		
		return totalAire;
	}
	
	/**
	 * 
	 * @param seuil
	 * @return int: le nombre de forme dont le périmetre est inferieur à seuil
	 */
	public int perimetreInferieurA(double seuil) {
		int cpt = 0;
		
		for(Forme forme: this) if(forme.getPerimetre() < seuil) cpt++;
		
		return cpt;
	}
	
	public void tri() {
		Collections.sort(formes);
	}
	
	@Override
	public int compareTo(Image image) {
		return (int) (this.getAire() - image.getAire());
	}
	//Transformation
	public void homothétie(final int rapport) {
		for(Forme forme: this) forme.homothétie(rapport);
	}
	public void translation(final int dx, final int dy) {
		for(Forme forme: this) forme.translation(dx, dy);
	}
	public void rotation() {
		for(Forme forme: this) forme.rotation();
	}
	public void symétrieCentrale() {
		for(Forme forme: this) forme.symétrieCentrale();
	}
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
