package GUI;

import GameLogic.Game;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazeGameGUI extends JFrame {

	private MazePanel mazePanel;
	private MainMenu mainMenu;
	private OptionsMenu options;
	public Game g1; 	

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
		
		g1 = new Game() ;
		g1.setBoard();
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		this.getContentPane().setLayout(new CardLayout());
		setBounds(100, 100, 500, 500);
		setVisible(true);
		
		options = new OptionsMenu(g1, this) ;
		this.add(options);
		options.setVisible(false);
		
		mainMenu = new MainMenu(g1, this);
		this.add(mainMenu);
		mainMenu.setVisible(true);
	
		
	}

	
	public void disableAll() {
//		mazePanel.setVisible(false);
		mainMenu.setVisible(false);
		options.setVisible(false);

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
}