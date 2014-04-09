package GameLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
	private Game g;
	private File f;
	
	public SaveGame(Game game, File f) {
		g=game;
		this.f=f;
	}
	
	public void saveGame() throws IOException {
		ObjectOutputStream os = null; 
		try { 
			os = new ObjectOutputStream(new FileOutputStream(f)); 
			os.writeObject(g); 
		} 
		catch (IOException e) { } 
		finally { if (os != null) os.close(); } 
	}
	
	public void loadGame() throws IOException, ClassNotFoundException {
		Game g = new Game();
		ObjectInputStream is = null; 
		try { 
			is = new ObjectInputStream(new FileInputStream(f)); 
			g = (Game) is.readObject(); 
		} 
		catch (IOException e) {} 
		finally { if (is != null) is.close(); }
		
		this.g=g;
	}
	
	public Game getGame() {return g;}
	public File getFile() {return f;}
	public void setGame(Game game) {this.g=game;}
	public void setFile(File f) {this.f=f;}
}
