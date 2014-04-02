package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GameLogic.Game;

public class MazePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4524861054188045761L;
	private JPanel GraphicBoard[][];
	private Game g1;
	private MazeGameGUI frame;
	private int realSize;

	public MazePanel(Game currentGame, MazeGameGUI window) {

		g1 = currentGame;
		frame = window;

		if(g1.getSize()-2 < 5) realSize = 10;
		else realSize = g1.getSize()-2;

		GraphicBoard = new JPanel[realSize][realSize];

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridLayout(realSize,realSize));


		for (int i = 0 ; i < realSize; i++) {
			for (int j = 0; j < realSize; j++) {
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
			else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				frame.disableAll();
				setVisible(false);
				frame.getPaused().setVisible(true);
			}

			UpdateGraphicBoard();

			switch(output) {
			case 1: //quit
				frame.disableAll();
				frame.getMainMenu().setVisible(true);
				break;
			case 2: //dead
				JOptionPane.showMessageDialog(frame, "You died!");

				frame.disableAll();
				frame.getMainMenu().setVisible(true);
				break;
			case 3: //won
				JOptionPane.showMessageDialog(frame, "You won!");

				frame.disableAll();
				frame.getMainMenu().setVisible(true);
				break;
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

	//TODO change color of specials (armado, sleeping dragons, etc)
	public void UpdateGraphicBoard() {

		for (int i = 0 ; i < realSize; i++) {
			for (int j = 0; j < realSize; j++) {

				if(g1.getBoard().getCurrentState()[i][j].equals("X")) {
					GraphicBoard[i][j].setBackground(Color.DARK_GRAY);
				}


				else if (g1.getBoard().getCurrentState()[i][j].equals("E")) {
					GraphicBoard[i][j].setBackground(Color.YELLOW);
				}


				else if (g1.getBoard().getCurrentState()[i][j].equals("H") || g1.getBoard().getCurrentState()[i][j].equals("A")) {
					GraphicBoard[i][j].setBackground(Color.BLUE);
				}


				else if (g1.getBoard().getCurrentState()[i][j].equals("D")) {
					GraphicBoard[i][j].setBackground(Color.RED);
				}

				else if(g1.getBoard().getCurrentState()[i][j].equals("v") || g1.getBoard().getCurrentState()[i][j].equals("V")) {
					GraphicBoard[i][j].setBackground(Color.GREEN);
				}

				else GraphicBoard[i][j].setBackground(Color.WHITE);
			}
		}
	}



}

