package GUI;

import GameLogic.Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class MazeGameGUI extends JFrame{

	private MazePanel mazePanel;
	private MainMenu mainMenu;
	private Game g1; 	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeGameGUI frame = new MazeGameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MazeGameGUI() {
		
				
		g1 = new Game() ;
		g1.setBoard();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		this.getContentPane().setLayout(new CardLayout());
		
		
//		mainMenu = new MainMenu(g1);
//		this.getContentPane().add(mainMenu);
//		
//		mainMenu.setVisible(false);
//		
//		mainMenu.requestFocusInWindow();

		mazePanel = new MazePanel(g1);
		mazePanel.requestFocusInWindow();
		this.getContentPane().add(mazePanel);

		

			
	}
	
	
	
	

}
