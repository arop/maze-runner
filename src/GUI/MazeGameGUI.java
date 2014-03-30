package GUI;

import GameLogic.Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class MazeGameGUI extends JFrame implements KeyListener {

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

		g1 = new Game(31) ;
		g1.setBoard();
		g1.setNumber_dragons(5);
		g1.setSleepingDragons();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		this.getContentPane().setLayout(new CardLayout());
		setBounds(100, 100, 500, 500);
		setVisible(true);
		
		mazePanel = new MazePanel(g1);
		this.add(mazePanel);
		mazePanel.setVisible(false);
		mazePanel.requestFocusInWindow();
		
		options = new OptionsMenu(g1, this) ;
		this.add(options);
		options.setVisible(false);
		options.requestFocusInWindow();
			
		mainMenu = new MainMenu(g1, this);
		this.add(mainMenu);
		mainMenu.setVisible(true);
		mainMenu.requestFocusInWindow();
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public OptionsMenu getOptions() {
		return options;
	}
	
	
	public void disableAll() {
		mazePanel.setVisible(false);
		mainMenu.setVisible(false);
		options.setVisible(false);
		
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