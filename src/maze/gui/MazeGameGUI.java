package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import maze.logic.Game;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/**
 * MazeGameGUI.java - Classe principal do package, representando a janela utilizada, com os menus inseridos na mesma 
 * @author André Pires, Filipe Gama
 *
 */
public class MazeGameGUI extends JFrame {

	private static final long serialVersionUID = 1271756560536221038L;
	private MazePanel mazePanel;
	private MainMenu mainMenu;
	private OptionsMenu options;
	private GameMenu paused;
	private MazeEditor editor;
	private ArrayList<Integer> controls;
	Game g1;

	/**
	 * 
	 * @return controlos escolhidos para o jogo
	 */
	public ArrayList<Integer> getControls() {
		return controls;
	}

	/**
	 * Modifica os controlos do jogo
	 * @param controls novos controlos
	 */
	@SuppressWarnings("unchecked")
	public void setControls(ArrayList<Integer> controls) {
		this.controls = (ArrayList<Integer>) controls.clone();
	}
	/**
	 * Funcao main do package
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MazeGameGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor da classe, criando a janela do programa e os diferentes paineis correspondentes aos 
	 * diferentes menus
	 */
	public MazeGameGUI() {
		this.setFocusable(true);

		controls = new ArrayList<Integer>() ;
		controls.add(KeyEvent.VK_RIGHT);
		controls.add(KeyEvent.VK_UP);
		controls.add(KeyEvent.VK_DOWN);
		controls.add(KeyEvent.VK_LEFT);
		controls.add(KeyEvent.VK_SPACE);

		g1 = new Game() ;
		
		GameSounds.load("sons/musica.wav", "musiquinha");
		GameSounds.play("musiquinha");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);

		this.getContentPane().setLayout(new CardLayout());
		setBounds(100, 100, 500, 500);
		setVisible(true);


		options = new OptionsMenu(g1, this) ;
		this.add(options);
		options.setVisible(false);

		paused = new GameMenu(g1, this) ;
		this.add(paused);
		paused.setVisible(false);

		mainMenu = new MainMenu(g1,this);
		this.add(mainMenu);
		mainMenu.setVisible(true);

		editor = new MazeEditor(g1,this);
		this.add(editor);
		editor.setVisible(false);
	}
	/**
	 * 
	 * @return menu de pause
	 */

	public GameMenu getPaused() {
		return paused;
	}

	/**
	 * Modifica o menu de pause
	 * @param paused novo menu
	 */
	public void setPaused(GameMenu paused) {
		this.paused = paused;
	}

	/**
	 * Muda a visibilidade dos menus para invisiveis
	 */
	public void disableAll() {
		
		mainMenu.setVisible(false);
		options.setVisible(false);
		editor.setVisible(false);
		paused.setVisible(false);
	}

	/**
	 * 
	 * @return menu de opçoes
	 */
	public OptionsMenu getOptions() {
		return options;
	}
	/**
	 * 
	 * @return menu do jogo
	 */
	public MazePanel getMazePanel() {
		return mazePanel;
	}
	/**
	 * Modifica o menu do jogo
	 * @param mazePanel novo menu
	 */
	public void setMazePanel(MazePanel mazePanel) {
		this.mazePanel = mazePanel;
	}
	/**
	 * 
	 * @return menu principal
	 */
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	/**
	 * Modifica o menu principal
	 * @param mainMenu novo menu
	 */
	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}
	/**
	 * Modifica o menu de opçoes
	 * @param options novo menu
	 */
	public void setOptions(OptionsMenu options) {
		this.options = options;
	}
	/**
	 * 
	 * @return menu de ediçao
	 */
	public MazeEditor getEditor() {
		return editor;
	}
	/**
	 * Modifica o menu de ediçao
	 * @param ed novo menu
	 */
	public void setMazeEditor(MazeEditor ed) {
		this.editor=ed;
	}
}