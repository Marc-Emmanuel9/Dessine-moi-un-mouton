package mouton.forme;

import java.io.Serializable;
import java.util.*;

public class Fresque implements Serializable, Iterable<Dessin> {
	
	Set<Dessin> dessins = new HashSet<Dessin>();
	
	public Fresque(final Set<Dessin> dessins) {
		this.dessins = dessins;
	}
	
	public Fresque(final Fresque fresque) {
		this(fresque.dessins);
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
			toString += "\tDessin "+cptDess+"\n";
			for(Image image: dessin) {
				toString += "\tImage "+cptImg+"\n";
				for(Forme forme: image) {
					toString += forme + "\n";
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
	

}
