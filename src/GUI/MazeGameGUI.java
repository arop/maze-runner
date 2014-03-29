package GUI;

import GUI.MazePanel.MyKeyListener;
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

	private JPanel lol;
	JPanel GraphicBoard[][];

	private MazePanel mazePanel;
	private MainMenu mainMenu;
	public Game g1; 	

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
		
		lol = new JPanel();
		g1 = new Game() ;
		g1.setBoard();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		this.getContentPane().setLayout(new CardLayout());
		
		setBounds(100, 100, 500, 500);
		lol.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lol.setLayout(new GridLayout(10,10));
	
		
		
		this.add(lol);
	
//		mainMenu = new MainMenu(g1);
//		this.getContentPane().add(mainMenu);
//		mainMenu.setVisible(true);
		
		lol.requestFocusInWindow();
		CreateGraphicBoard();
		UpdateGraphicBoard();
		lol.setVisible(true);
		Play() ;
		
//		

		
//		mazePanel = new MazePanel(g1);
	
//		mazePanel.requestFocusInWindow();
//		
//		mazePanel.setVisible(true);
//
//		this.getContentPane().add(mazePanel);

		

			
	}
	
	public void Play() {
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
			
		
	}
	
	public class MyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				g1.Play("d");
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP){
				g1.Play("w");
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				g1.Play("s");
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT){
				g1.Play("a");
			}
			
			UpdateGraphicBoard();

			
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
		
	
	public void CreateGraphicBoard() {
		GraphicBoard = new JPanel[10][10];
	
		for (int i = 0 ; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				GraphicBoard[i][j] = new JPanel() ;
				lol.add(GraphicBoard[i][j]);
				
			}
		}
	}
	
	public void UpdateGraphicBoard() {
	
		for (int i = 0 ; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				if(g1.getBoard().getCurrentState()[i][j].equals("X")) {
					GraphicBoard[i][j].setBackground(Color.BLUE);
				}
				

				else if (g1.getBoard().getCurrentState()[i][j].equals("E")) {
					GraphicBoard[i][j].setBackground(Color.YELLOW);
				}
				
				else if (g1.getBoard().getCurrentState()[i][j].equals("H") || g1.getBoard().getCurrentState()[i][j].equals("A")) {
					GraphicBoard[i][j].setBackground(Color.BLACK);
				}
				
				else if (g1.getBoard().getCurrentState()[i][j].equals("D")) {
					GraphicBoard[i][j].setBackground(Color.RED);
				}
				else GraphicBoard[i][j].setBackground(Color.WHITE);

			
			}
		}
	}
	
	

}


	
	
