package GUI;

import GameLogic.Game;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/**
 * MazeGameGUI.java - Classe principal do package, representando a janela utilizada com os menus inseridos nesta 
 * @author André Pires, Filipe Gama
 *
 */
public class MazeGameGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1271756560536221038L;
	private MazePanel mazePanel;
	private MainMenu mainMenu;
	private OptionsMenu options;
	private GameMenu paused;
	private MazeEditor editor;
	private ArrayList<Integer> controls;
	
	public ArrayList<Integer> getControls() {
		return controls;
	}


	public void setControls(ArrayList<Integer> controls) {
		this.controls = controls;
	}

	Game g1;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeGameGUI frame = new MazeGameGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MazeGameGUI() {
		this.setFocusable(true);
		
		controls = new ArrayList<Integer>() ;
		controls.add(KeyEvent.VK_RIGHT);
		controls.add(KeyEvent.VK_UP);
		controls.add(KeyEvent.VK_DOWN);
		controls.add(KeyEvent.VK_LEFT);
		controls.add(KeyEvent.VK_BACK_SPACE);

		g1 = new Game() ;


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


	public GameMenu getPaused() {
		return paused;
	}


	public void setPaused(GameMenu paused) {
		this.paused = paused;
	}


	public void disableAll() {
		//		mazePanel.setVisible(false);
		mainMenu.setVisible(false);
		options.setVisible(false);
		editor.setVisible(false);
		paused.setVisible(false);
	}



	public OptionsMenu getOptions() {
		return options;
	}

	public MazePanel getMazePanel() {
		return mazePanel;
	}

	public void setMazePanel(MazePanel mazePanel) {
		this.mazePanel = mazePanel;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public void setOptions(OptionsMenu options) {
		this.options = options;
	}
	
	public MazeEditor getEditor() {
		return editor;
	}
	
	public void setMazeEditor(MazeEditor ed) {
		this.editor=ed;
	}
}