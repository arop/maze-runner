package GameLogic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
	private Game g;
	
	public SaveGame(Game game) {
		g=game;
	}
	
	public void saveGame() throws IOException {
		ObjectOutputStream os = null; 
		try { 
			os = new ObjectOutputStream(new FileOutputStream("saveFile.dat")); 
			os.writeObject(g); 
		} 
		catch (IOException e) { } 
		finally { if (os != null) os.close(); } 
	}
	
	public void loadGame() throws IOException, ClassNotFoundException {
		Game g = new Game();
		ObjectInputStream is = null; 
		try { 
			is = new ObjectInputStream(new FileInputStream("saveFile.dat")); 
			g = (Game) is.readObject(); 
		} 
		catch (IOException e) {} 
		finally { if (is != null) is.close(); }
		
		this.g=g;
	}
	
	public Game getGame() {return g;}
	public void setGame(Game game) {this.g=game;}
}
