package mouton.file;

import java.io.*;
import java.util.*;

import mouton.exception.EmptyFileException;
import mouton.forme.*;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class FileManager {

	private Object object;
	
	/**
	 * 
	 * @param object
	 */
	public FileManager(final Object object) {
		this.object = object;
	}
	
	public FileManager() {
	}
	
	/**
	 * 
	 * @param folderName              Prend en paramètre le nom du fichier où est stoqué la fresque.
	 * @return fresque                Retourne la fresque en question.
	 * @throws EmptyFileException	  Si jamais le fichier est vide
	 * @throws ClassNotFoundException Si jamais la class n'a pas été trouvée
	 * @throws IOException
	 */
	public Fresque getFresque(final String folderName) throws EmptyFileException, ClassNotFoundException, IOException {
		FileInputStream file = new FileInputStream(folderName + ".txt");
		Scanner sc = new Scanner(file);
		Fresque fresque = null;
		if(sc.hasNextLine()) {
			while(sc.hasNextLine()) {
				if(sc.nextLine() == "0") {
					ObjectInputStream ois = new ObjectInputStream(file);
					Fresque fresque2 = (Fresque) (ois.readObject());
					ois.close();
					return fresque2;
				}
				
			}
			return fresque;
		} else throw new EmptyFileException("Le fichier donnée en paramètre est vide");
		
	}
	
	/**
	 * 
	 * @param folderName              Prend en paramètre le nom du fichier où est stoqué la fresque.
	 * @throws FileNotFoundException  Si jamais le fichier n'est pas trouvée
	 * @throws IOException
	 */
	public void save(final String folderName) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderName+".txt"));
		oos.writeInt(0);
		oos.writeObject(this.object);
		oos.close();
	}
	
}
