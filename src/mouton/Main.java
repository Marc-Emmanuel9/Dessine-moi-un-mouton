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
		String[] transformation = {"Translation", "Homoth�tie", "Rotation", "Symetrie Axiale"
							, "Symetrie Centrale"};
		
		
		// Application des transformations.
		System.out.println("Application de transformation al�atoire sur les formes de la fresque : ");
		for(Dessin dessin: fresque) {
			switch(rd.nextInt(transformation.length)) {
				case 0:
					dessin.translation(rd.nextInt(90), rd.nextInt(90)); 
					break;
				case 1:
					dessin.homoth�tie(rd.nextInt(90));
					break;
				case 2:
					dessin.rotation(rd.nextInt(361));
					break;
				case 3:
					dessin.sym�trieAxiale();
					break;
				case 4:
					dessin.sym�trieCentrale(new Point(0, 0));
					break;
			}
		}
		System.out.println(fresque);
		
		// Trie des formes de la fresque copie en fonction de leur p�rim�tre. 
		System.out.println();
		System.out.println("Trie des formes de la fresque de copie en fonction de leur perimetre : ");
		fresqueDeCopie = new Fresque(fresque);
		for(Dessin dessin: fresqueDeCopie) {
			for (Image image: dessin) {
				image.sort();
			}
		}
		System.out.println(fresqueDeCopie);
		
		// Trie des formes de la fresque copie en fonction de leur aire.
		System.out.println();
		System.out.println("Trie des images de la fresque de copie en fonction de leur aire : ");
		for(Dessin dessin: fresqueDeCopie) {
			dessin.sort();
		}
		System.out.println(fresqueDeCopie);
		
		// Nombre de forme ayant un p�rim�tre inf�rieur � un seuil.
		System.out.println();
		int seuil = rd.nextInt(100);
		System.out.println("Nombre de forme ayant un p�rim�tre inf�rieur � " + seuil + " : ");
		int nbFormePerimetreInferieurASeuil = 0;
		int cpt = 1;
		for(Dessin dessin: fresque) {
			for(Image image: dessin) {
				nbFormePerimetreInferieurASeuil = image.perimetreInferieurA(seuil);
				System.out.println("Image "+ (cpt++)+ " -> " + nbFormePerimetreInferieurASeuil);
			}
		}
		
		
		// Nombre d'image ayant une aire inf�rieur � un seuil.
		System.out.println();
		seuil = rd.nextInt(1000);
		System.out.println("Nombre d'image ayant une aire inf�rieure � " + seuil + " : ");
		int nbImageAireInferieurASeuil = 0;
		cpt = 1;
		for(Dessin dessin: fresque) {
				nbImageAireInferieurASeuil = dessin.airInferieurA(seuil);
				System.out.println("Dessin "+ (cpt++)+ " -> " + nbImageAireInferieurASeuil);

		}
		
		
		// P�rim�trec de chaque image de la fresque.
		System.out.println();
		System.out.println("P�rim�tre de chaque image de la fresque : ");
		cpt = 1;
		for(Dessin dessin: fresque) {
			for(Image image: dessin) {
				System.out.println("Image " + (cpt++) + " -> "+ image.perimetre());
			}
		}
		
		// Aire de chaque dessin de la fresque.
		System.out.println();
		System.out.println("Aire de chaque dessin de la fresque : ");
		cpt = 1;
		for(Dessin dessin: fresque) {
				System.out.println("Aire " + (cpt++) + " -> "+ dessin.aire());
		}
		
		// Calcul aire total de la fresque de copie.
		System.out.println();
		System.out.println("Aire total de la fresque de copie : " + fresqueDeCopie.aire());
		
		//Calcul p�rim�tre total de la fresque de copie.
		System.out.println();
		System.out.println("Perimetre total de la fresque de copie : " + fresqueDeCopie.perimetre());
		
		//Fin du programme.
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
