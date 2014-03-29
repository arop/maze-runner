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
import javax.swing.JLabel;

public class MazeGameGUI extends JFrame implements KeyListener {

	private MazePanel mazePanel;
	private MainMenu mainMenu;
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
				
		mazePanel = new MazePanel(g1);

		g1.setNumber_dragons(5);
		g1.setSleepingDragons();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		this.getContentPane().setLayout(new CardLayout());
		setBounds(100, 100, 500, 500);
		setVisible(true);
		
//			
//		mainMenu = new MainMenu(g1);
//		this.add(mainMenu);
//		mainMenu.setVisible(true);
//		mainMenu.requestFocusInWindow();

		
		getContentPane().add(mazePanel);
		mazePanel.setVisible(true);
		mazePanel.requestFocusInWindow();
		
	
			
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
	
	
}