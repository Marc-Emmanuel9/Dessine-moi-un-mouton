package mouton.forme;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Dessin implements Iterable<Image>, Serializable {
	
	private List<Image> images;
	
	public Dessin(final List<Image> images) {
		this.images = images;
	}
	
	
	public Dessin(final Dessin dessin) {
		this(dessin.images);
	}

	@Override
	public Iterator<Image> iterator() {
		// TODO Auto-generated method stub
		return this.images.iterator();
	}
	
	public int airInferieurA(double seuil) {
		int cpt = 0;
		
		for(Image image: this) {
			
			if(image.getAire() < seuil) cpt++;
		}
		
		return cpt;
	}
	
	public void sort() {
		Collections.sort(images);
	}
	
	//Transformation
	public void homothétie(final int rapport) {
		for(Image image: this) image.homothétie(rapport);
	}
	public void translation(final int dx, final int dy) {
		for(Image image: this) image.translation(dx, dy);
	}
	public void rotation() {
		for(Image image: this) image.rotation();
	}
	public void symétrieCentrale() {
		for(Image image: this) image.symétrieCentrale();
	}
	public void symétrieAxiale() {
		for(Image image: this) image.symétrieAxiale();
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
