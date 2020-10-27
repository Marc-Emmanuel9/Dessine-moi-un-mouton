package mouton.forme;

import java.util.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Fresque implements Iterable<Dessin>, Calcul {

	private Set<Dessin> dessins;
	
	/**
	 * 
	 * @param dessins
	 */

	
	public Fresque(final Set<Dessin> dessins) {
		this.dessins = dessins;
	}
	
	/**
	 * 
	 * @param fresque
	 */
	public Fresque(final Fresque fresque) {
		this(fresque.dessins);
	}
	
	public void sortImageByAir(){
		for(Dessin dessin: this) {
			dessin.sort();
		}
	}
	
	public void sortFormeByPerimetre() {
		for(Dessin dessin: this) {
			for(Image image: dessin) {
				image.sort();
			}
		}
	}
	@Override
	public Iterator<Dessin> iterator() {
		return this.dessins.iterator();
	}
	
	@Override
	public String toString() {
		String toString = "Fresque\n";
		int cptImg = 1;
		int cptDess = 1;
		for(Dessin dessin: this) {
			toString += "\t+Dessin "+(cptDess++)+"\n";
			for(Image image: dessin) {
				toString += "\t\t+Image "+(cptImg++)+"\n";
				for(Forme forme: image) {
					toString += "\t\t\t+"+forme + "\n";
				}
			}
		}
		return toString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dessins == null) ? 0 : dessins.hashCode());
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
		Fresque other = (Fresque) obj;
		if (dessins == null) {
			if (other.dessins != null)
				return false;
		} else if (!dessins.equals(other.dessins))
			return false;
		return true;
	}

	@Override
	public double perimetre() {
		double totalPerimetre = 0;
		
		for(Dessin dessin: this) totalPerimetre += dessin.perimetre();
		
		return totalPerimetre;
	}

	@Override
	public double aire() {
		double totalAir = 0;
		
		for(Dessin dessin: this) totalAir += dessin.aire();
		
		return totalAir;
	}

}
