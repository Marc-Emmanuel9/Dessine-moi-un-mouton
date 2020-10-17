package mouton;

import mouton.exception.EmptyFileException;
import mouton.exception.NoFresqueException;
import mouton.file.FileManager;
import mouton.forme.*;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("ckfcejdf");
		System.out.println("CLS");
	}
	
	public static void scenario() throws IOException, ClassNotFoundException, EmptyFileException
															,FileNotFoundException, NoFresqueException{
		//
		Scanner sc = new Scanner(System.in);
		FileManager fm = new FileManager();
		FileManager fm2;
		Fresque fresqueUtilisateur;
		Fresque fresqueDeCopie;
		int choixFichier = 0;
		int choix = 0;
		boolean condition = true;
		
		do {
			// Première partie on affiche les fresques déjà existante
			System.out.println("Fresque présente dans le fichier : ");
			if (getFichierPresent().length == 0) {
				throw new NoFresqueException("Aucune fresque n'est présent dans le fichier.");
			}else {
				afficherContenue(getFichierPresent());
			}
			
			//Deucième partie on choisie la fresque
			String[] listFichier = getFichierPresent();
			int nombreFichierPresent = listFichier.length;
			int choixUtilisateur;
			int choixUtilisateur2;
			do {
				
				System.out.print("Veuillez choisir la fresque à éditer en tapant \nson indice de 1 à "
						+ (nombreFichierPresent-1) + " --> ");
				choixUtilisateur = sc.nextInt();
				System.out.println();
				if(!(choixUtilisateur > (nombreFichierPresent - 1) && choixUtilisateur < 0))
						condition = false;
			}while(condition);
			fresqueUtilisateur = fm.getFresque(listFichier[choixUtilisateur]);
			do {
				//Troisième partie on affiche la fresque 
				System.out.println("Voici la fresque : \n"+listFichier[choixUtilisateur] + "\nFresque\n" 
									+ fresqueUtilisateur);
				
				//Quatrième partie on affiche le menu des actions et transformation
				System.out.println("Veulliez selectionner une transformation ou un action en tapant \n"
						+ "son indice de 1 à 12 : \n");
				System.out.println(getMenuAction());
				
				//Cinquième partie on applique les choix de l'utilisateur
				do {
					System.out.print("--> ");
					choixUtilisateur2 = sc.nextInt();
					System.out.println();
					if(!(choixUtilisateur2 > (12) && choixUtilisateur2 < 0))
							condition = false;
				}while(condition);
				
				switch (choixUtilisateur2){
					case 1:
						int dx, dy;
						System.out.println("Veuillez choisir votre dx et dy :");
						System.out.print("dx --> ");
						dx = sc.nextInt();
						System.out.println();
						System.out.print("dy --> ");
						dy = sc.nextInt();
						fresqueUtilisateur.translation(dx, dy);
						System.out.println(fresqueUtilisateur);
						fm.save(listFichier[choixUtilisateur], fresqueUtilisateur);
						break;
					case 2:
						int rapport;
						System.out.println("Veuillez choisir votre rapport :");
						System.out.print("rapport --> ");
						rapport = sc.nextInt();
						System.out.println();
						fresqueUtilisateur.homothétie(rapport);
						System.out.println(fresqueUtilisateur);
						fm.save(listFichier[choixUtilisateur], fresqueUtilisateur);
						break;
					case 3:
						System.out.println(fresqueUtilisateur);
						break;
					case 4:
						System.out.println(fresqueUtilisateur);
						break;
					case 5:
						System.out.println(fresqueUtilisateur);
						break;
					case 6:
						fresqueUtilisateur.sortImageByAir();
						System.out.println(fresqueUtilisateur);
						fm.save(listFichier[choixUtilisateur], fresqueUtilisateur);
						break;
					case 7:
						fresqueUtilisateur.sortFormeByPerimetre();
						System.out.println(fresqueUtilisateur);
						fm.save(listFichier[choixUtilisateur], fresqueUtilisateur);
						break;
					case 8:
						String nom;
						System.out.print("Nom de la nouvelle fresque : ");
						nom = sc.nextLine();
						System.out.println();
						fresqueDeCopie = new Fresque(fresqueUtilisateur);
						System.out.println(fresqueDeCopie);
						fm.save(nom + ".txt", fresqueDeCopie);
						break;
					case 9:
						System.out.println(fresqueUtilisateur);
						System.out.println("Périmètre total de la fresque : " + fresqueUtilisateur.perimetre());
						break;
					case 10:
						System.out.println("Air total de la fresque : " + fresqueUtilisateur.air());
						break;
					case 11:
						int totalAir = 0;
						int seuilAir;
						
						System.out.print("Veuillez choisir le seuil --> ");
						seuilAir = sc.nextInt();
						System.out.println();
						for(Dessin dessin: fresqueUtilisateur) {
							totalAir += dessin.airInferieurA(seuilAir);
						}
						System.out.println(fresqueUtilisateur);
						System.out.println("Voici le nombre d'image ayant une air inferieur à " 
													+ seuilAir + " : " + totalAir);
						break;
					case 12:
						int totalPerimetre = 0;
						int seuilPerimetre;
						
						System.out.print("Veuillez choisir le seuil --> ");
						seuilPerimetre = sc.nextInt();
						System.out.println();
						for(Dessin dessin: fresqueUtilisateur) {
							for(Image image: dessin) {
								totalPerimetre += image.perimetreInferieurA(seuilPerimetre);	
							}
						}
						System.out.println(fresqueUtilisateur);
						System.out.println("Voici le nombre de forme ayant un périmètre inferieur à " 
																+ seuilPerimetre + " : " + totalPerimetre);
						break;
				}
				
				System.out.print("Voulez-vous faire autre chose ? (0 pour non / 1 pour oui) --> ");
				choix = sc.nextInt();
				System.out.println();
			}while(choix == 1);
			System.out.print("Voulez-vous choisir un autre fichier ? (0 pour non / 1 pour oui) --> ");
			choixFichier = sc.nextInt();
			System.out.println();
		}while(choixFichier == 1);
		System.out.println("Aurevoir !!");		
	}
	
	/**
	 * 
	 * @return menu			Renvoie le menu avec toute les actions que peut selectionner l'utilisateur.
	 */
	public static String getMenuAction() {
		String[] transformations = {"Translation", "Homothétie", "Rotation", "Symétrie Centrale"
					, "Symétrie Axiale"};
		String[] actions = {"Trie des images selon l'air", "Trie des formes selon le périmètre"
				, "Copie de la fresque"};
		
		String[] calculs = {"Périmètre total", "Air total", "Nombre d'image ayant une air inférieur"
				+ " à un seuil", "Nombre de forme ayant un périmètre inférieur à un seuil"};
		
		String menu = "";
		int indice = 1;
		for(String transformation: transformations) {
			menu += (indice++) + " - " + transformation + "\n";
		}
		
		for(String action: actions) {
			menu += (indice++) + " - " + action + "\n";
		}
		
		for(String calcul: calculs) {
			menu += (indice++) + " - " + calcul + "\n";
		}
		
		return menu;
	}
	

	/**
	 * 
	 * @return Tableau de String comptenant la liste des fichier dans Fresque
	 * @throws FileNotFoundException   Si le fichier n'est pas trouvée.
	 */
	public static String[] getFichierPresent() throws FileNotFoundException {
		File file = new File("Fresque");
		return file.list();
	}
	
	public static String afficherContenue(String[] elements) {
		String contenue = "";
		int cpt = 1;
		
		for(String element: elements) {
			contenue += (cpt++) + " - " + element + "\n";
		}
		return contenue;
	}
}
