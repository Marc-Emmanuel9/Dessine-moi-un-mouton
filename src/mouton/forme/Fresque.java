package mouton.forme;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Fresque implements Serializable, Iterable<Dessin>, Transformable, Calcul {

	private static final long serialVersionUID = 6819328652744719573L;
	Set<Dessin> dessins = new TreeSet<Dessin>();
	
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
		String toString = "";
		int cptImg = 0;
		int cptDess = 0;
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
	public double air() {
		double totalAir = 0;
		
		for(Dessin dessin: this) totalAir += dessin.air();
		
		return totalAir;
	}

	@Override
	public void homothétie(int rapport) {
		for(Dessin dessin: this) dessin.homothétie(rapport);
	}

	@Override
	public void translation(int dx, int dy) {
		for(Dessin dessin: this) dessin.translation(dx, dy);;
		
	}

	@Override
	public void rotation() {
		for(Dessin dessin: this) dessin.rotation();;
		
	}

	@Override
	public void symétrieCentrale() {
		for(Dessin dessin: this) dessin.symétrieCentrale();
		
	}

	@Override
	public void symétrieAxiale() {
		for(Dessin dessin: this) dessin.symétrieAxiale();
	}
}
