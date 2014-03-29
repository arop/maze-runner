package GUI;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GameLogic.Game;

public class MazePanel extends JPanel {
	

		JPanel GraphicBoard[][];
		Game g1;
		
		public MazePanel(Game currentGame) {
			
			g1 = currentGame;
			
			setBounds(100, 100, 500, 500);
			this.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			this.setLayout(new GridLayout(10,10));
			
			
			CreateGraphicBoard();
			UpdateGraphicBoard();
			Play() ;


					
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
					this.add(GraphicBoard[i][j]);
					
				}
			}
		}
		
		public void UpdateGraphicBoard() {
		
			for (int i = 0 ; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					if(g1.getBoard().getCurrentState()[i][j].equals("X")) {
						GraphicBoard[i][j].setBackground(Color.BLACK);
					}
					
					else if (g1.getBoard().getCurrentState()[i][j].equals("H") || g1.getBoard().getCurrentState()[i][j].equals("A")) {
						GraphicBoard[i][j].setBackground(Color.GREEN);
					}
					
					else if (g1.getBoard().getCurrentState()[i][j].equals("D")) {
						GraphicBoard[i][j].setBackground(Color.RED);
					}
					
					else if (g1.getBoard().getCurrentState()[i][j].equals("E")) {
						GraphicBoard[i][j].setBackground(Color.YELLOW);
					}
					else GraphicBoard[i][j].setBackground(Color.WHITE);

				
				}
			}
		}
		
		

	}


