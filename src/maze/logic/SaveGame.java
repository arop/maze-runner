package maze.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * SaveGame.java - Esta classe tem como função a gravação/carregamento dum jogo num ficheiro  
 * @author André Pires, Filipe Gama
 * @see Game
 */
public class SaveGame {
	private Game g;
	private File f;

	/**
	 * Construtor da classe SaveGame
	 * @param game jogo a guardar
	 * @param f ficheiro onde guardar
	 */
	public SaveGame(Game game, File f) {
		g=game;
		this.f=f;
	}
	/**
	 * Grava o jogo no ficheiro especificado
	 * @throws IOException
	 */
	public void saveGame() throws IOException {
		ObjectOutputStream os = null; 
		try { 
			os = new ObjectOutputStream(new FileOutputStream(f)); 
			os.writeObject(g); 
		} 
		catch (IOException e) { } 
		finally { if (os != null) os.close(); } 
	}
	/**
	 * Carrega o jogo a partir do ficheiro selecionado
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * 
	 * @return jogo
	 */
	public Game getGame() {return g;}
	/**
	 * 
	 * @return ficheiro
	 */
	public File getFile() {return f;}
	/**
	 * Muda o jogo a ser guardado
	 * @param game Jogo a ser guardado
	 */
	public void setGame(Game game) {this.g=game;}
	/**
	 * Muda o ficheiro a ser guardado
	 * @param f Ficheiro a ser guardado 
	 */
	public void setFile(File f) {this.f=f;}
}
