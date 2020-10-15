package mouton.file;

import java.io.*;
import mouton.forme.*;

public class FileManager {
	

	private enum TYPE {DESSIN, IMAGE, FRESQUE};
	
	private FileInputStream file;
	private Dessin dessin;
	private Image image;
	private Fresque fresque;
	private TYPE type;
	
	public FileManager(final Dessin dessin) {
		this.dessin = dessin;
		this.type = TYPE.DESSIN;
	}
	
	public FileManager(final Fresque fresque) {
		this.fresque = fresque;
		this.type = TYPE.FRESQUE;
	}
	
	public FileManager(final Image image) {
		this.image = image;
		this.type = TYPE.IMAGE;
	}
	
	public FileManager(final FileInputStream file) {
		this.file = file;
	}
	
	public Dessin getDessin() throws IOException, ClassNotFoundException{
		return (Dessin) (new ObjectInputStream(this.file).readObject());
	}

	public Image getImage() throws IOException, ClassNotFoundException{
		return (Image) (new ObjectInputStream(this.file).readObject());
		
	}
	
	public Fresque getFresque() throws IOException, ClassNotFoundException{
		return (Fresque) (new ObjectInputStream(this.file).readObject());
		
	}
	public void save(final String folderName) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderName+".data"));
		if(this.type == TYPE.DESSIN) oos.writeObject(this.dessin);
		else if (this.type == TYPE.IMAGE) oos.writeObject(this.image);
		else if (this.type == TYPE.FRESQUE) oos.writeObject(this.fresque);
		oos.close();
	}
	public void reset() throws IOException {this.file.reset();}
	
}
