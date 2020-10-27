package mouton;

import mouton.forme.*;
import java.util.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public class Main {

	public static void main(String[] args) {
		Fresque f = genererUneFresque();
		scenario(f);
	}
	
	public static void scenario(Fresque fresque) {
		Fresque fresqueDeCopie;
		Random rd = new Random();
		String[] transformation = {"Translation", "Homothétie", "Rotation", "Symetrie Axiale"
							, "Symetrie Centrale"};
		
		
		System.out.println("Application de transformation aléatoire sur les formes de la fresque : ");
		for(Dessin dessin: fresque) {
			switch(rd.nextInt(transformation.length)) {
				case 0:
					dessin.translation(rd.nextInt(90), rd.nextInt(90));
					break;
				case 1:
					dessin.homothétie(rd.nextInt(90));
					break;
				case 2:
					dessin.rotation();
					break;
				case 3:
					dessin.symétrieAxiale();
					break;
				case 4:
					dessin.symétrieCentrale();
					break;
			}
		}
		
		System.out.println(fresque);
		System.out.println();
		System.out.println("Trie des formes de la fresque de copie en fonction de leur perimetre : ");
		fresqueDeCopie = new Fresque(fresque);
		for(Dessin dessin: fresqueDeCopie) {
			for (Image image: dessin) {
				image.sort();
			}
		}
		System.out.println(fresqueDeCopie);
		System.out.println();
		System.out.println("Trie des images de la fresque de copie en fonction de leur aire : ");
		for(Dessin dessin: fresqueDeCopie) {
			dessin.sort();
		}
		
		System.out.println(fresqueDeCopie);
		System.out.println();
		int seuil = rd.nextInt(100);
		System.out.println("Nombre de forme ayant un périmètre inférieur à " + seuil + " : ");
		int nbFormePerimetreInferieurASeuil = 0;
		int cpt = 1;
		for(Dessin dessin: fresque) {
			for(Image image: dessin) {
				nbFormePerimetreInferieurASeuil = image.perimetreInferieurA(seuil);
				System.out.println("Image "+ (cpt++)+ " -> " + nbFormePerimetreInferieurASeuil);
			}
		}
		System.out.println();
		//
		seuil = rd.nextInt(100);
		System.out.println("Nombre d'image ayant une aire inférieure à " + seuil + " : ");
		int nbImageAireInferieurASeuil = 0;
		cpt = 1;
		for(Dessin dessin: fresque) {
				nbImageAireInferieurASeuil = dessin.airInferieurA(seuil);
				System.out.println("Dessin "+ (cpt++)+ " -> " + nbImageAireInferieurASeuil);

		}
		System.out.println();
		System.out.println("Périmètre de chaque image de la fresque : ");
		cpt = 1;
		for(Dessin dessin: fresque) {
			for(Image image: dessin) {
				System.out.println("Image " + (cpt++) + " -> "+ image.perimetre());
			}
		}
		System.out.println();
		System.out.println("Aire de chaque dessin de la fresque : ");
		cpt = 1;
		for(Dessin dessin: fresque) {
				System.out.println("Aire " + (cpt++) + " -> "+ dessin.aire());
		}
		System.out.println();
		System.out.println("Aire total de la fresque de copie : " + fresqueDeCopie.aire());
		System.out.println();
		System.out.println("Perimetre total de la fresque de copie : " + fresqueDeCopie.perimetre());
		System.out.println();
		System.out.println("Au revoir !!");		
	}

	public static Fresque genererUneFresque() {
		Set<Forme> formes1 = new HashSet<Forme>(); 
		Set<Forme> formes2 = new HashSet<Forme>(); 
		Set<Forme> formes3 = new HashSet<Forme>(); 
		Set<Forme> formes4 = new HashSet<Forme>(); 
		Set<Image> images1 = new HashSet<Image>();
		Set<Image> images2 = new HashSet<Image>();
		Set<Dessin> dessins = new HashSet<Dessin>();
		
		Ligne[] sommetP1 = {new Ligne(new Point(1, 2), new Point(5, 4), 1)
					, new Ligne(new Point(5, 4), new Point(8, 10), 1)
					, new Ligne(new Point(8, 10), new Point(12, 4), 1)
					, new Ligne(new Point(12, 4), new Point(1, 2), 1)};
		
		
		Ligne[] sommetP2 = {new Ligne(new Point(12, 5), new Point(1, 4), 1)
				, new Ligne(new Point(1, 4), new Point(18, 10), 1)
				, new Ligne(new Point(18, 10), new Point(4, 4), 1)
				, new Ligne(new Point(4, 4), new Point(12, 5), 1)};;
		
		
		formes1.add(new Cercle(new Point(1, 2), 5));
		formes1.add(new Polygone(new Point(1, 5), sommetP1));
		images1.add(new Image(formes1));
		
		formes2.add(new Ellipse(new Point(0, 2), 8, 6));
		formes2.add(new Ligne(new Point(1, 6), new Point(8, 14), 5));
		images1.add(new Image(formes2));
		
		formes3.add(new Cercle(new Point(7, 5), 10));
		formes3.add(new Polygone(new Point(5, 12), sommetP2));
		images2.add(new Image(formes3));
		
		formes4.add(new Ellipse(new Point(10, 8), 12, 5));
		formes4.add( new Ligne(new Point(41, 6), new Point(58, 14), 1));
		images2.add(new Image(formes4));
		
		dessins.add(new Dessin(images1));
		dessins.add(new Dessin(images2));
		
		return new Fresque(dessins);
	}
}
