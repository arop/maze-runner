package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GameLogic.Game;

public class MazePanel extends JPanel {

	private JPanel GraphicBoard[][];
	private Game g1;
	
	public MazePanel(Game currentGame) {

		g1 = currentGame;
		
		GraphicBoard = new JPanel[g1.getSize()-2][g1.getSize()-2];

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(g1.getSize()-2,g1.getSize()-2));
	

		for (int i = 0 ; i < g1.getSize()-2; i++) {
			for (int j = 0; j < g1.getSize()-2; j++) {
				GraphicBoard[i][j] = new JPanel() ;
				this.add(GraphicBoard[i][j]);

			}
		}
		
		Play();
		UpdateGraphicBoard();
	}
	
	

	public void Play() {
		KeyListener listener = new MyKeyListener();
		this.addKeyListener(listener);
	}
	
	public class MyKeyListener implements KeyListener {
		private int output ;
		@Override
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				output = g1.Play("d");
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP){
				output = g1.Play("w");
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				output = g1.Play("s");
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT){
				output = g1.Play("a");
			}
			else if(e.getKeyCode() == KeyEvent.VK_F) {
				output = g1.Play("f");
			}
			
			UpdateGraphicBoard();

			switch(output) {
			case 2:
				
				
			}
			
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

	public void UpdateGraphicBoard() {

		for (int i = 0, k = 2 ; i < g1.getSize()-2; i++, k++) {
			for (int j = 0 , l = 2; j < g1.getSize()-2; j++, l++) {
				
				if(g1.getBoard().getCurrentState()[k][l].equals("X")) {
					GraphicBoard[i][j].setBackground(Color.DARK_GRAY);
				}
				
				
				else if (g1.getBoard().getCurrentState()[k][l].equals("E")) {
					GraphicBoard[i][j].setBackground(Color.YELLOW);
				}
				

				else if (g1.getBoard().getCurrentState()[k][l].equals("H") || g1.getBoard().getCurrentState()[i][j].equals("A")) {
					GraphicBoard[i][j].setBackground(Color.BLUE);
				}
								

				else if (g1.getBoard().getCurrentState()[k][l].equals("D")) {
					GraphicBoard[i][j].setBackground(Color.RED);
				}
				
				else if(g1.getBoard().getCurrentState()[k][l].equals("v") || g1.getBoard().getCurrentState()[k][l].equals("V")) {
					GraphicBoard[i][j].setBackground(Color.GREEN);
				}

				else GraphicBoard[i][j].setBackground(Color.WHITE);


			}
		}
	}



}

