package mouton;

import mouton.file.FileManager;
import mouton.forme.*;
import java.io.IOException;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		System.out.println(Fresque.class.getSimpleName());
	}
	
	public static void scenario() throws IOException, ClassNotFoundException{
		FileManager fm;
		String[] listeForme = {"Cercle", "Ellipse", "Ligne", "Polygone"};
	}
}
