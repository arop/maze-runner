package GUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import GameLogic.Game;
/**
 * MazePanel.java - Esta classe representa o painel utilizado para a visualização do jogo em si
 * Assim, é apresentado o Board com todos os seus componentes
 * @author André Pires, Filipe Gama
 * @see GameLogic.Board, GameLogic.Game
 */
public class MazePanel extends JPanel implements ActionListener {

	private Game g1;
	private MazeGameGUI frame;
	private int realSize;
	private PaintTools paintObj = new PaintTools();
	private Timer animation;
	private int delay = 50, totalFrames = 10, currentFrame = 0;

	private static final long serialVersionUID = 7836117138272018391L;


	public MazePanel(Game currentGame, MazeGameGUI window){
		g1 = currentGame;
		frame = window;
		
		animation = new Timer(delay,this);
		animation.start();

		if(g1.getSize()-2 < 5) realSize = 10;
		else realSize = g1.getSize()-2;

		System.out.println(g1.getBoard());
		Play();
		UpdateGraphicBoard();

	}

	public class MyKeyListener implements KeyListener {
		private int output ;
		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == frame.getControls().get(0)){
				output = g1.Play("d");
			}
			else if (e.getKeyCode() == frame.getControls().get(1)){
				output = g1.Play("w");
			}
			else if (e.getKeyCode() == frame.getControls().get(2)){
				output = g1.Play("s");
			}
			else if (e.getKeyCode() == frame.getControls().get(3)){
				output = g1.Play("a");
			}
			else if(e.getKeyCode() == frame.getControls().get(4)) {
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
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {}
	}


	public void Play() {
		KeyListener listener = new MyKeyListener();
		this.addKeyListener(listener);
	}

	private void UpdateGraphicBoard() {
		this.repaint();

	}


	@Override
	protected void paintComponent(Graphics arg0) {

		super.paintComponent(arg0);
		paintObj.drawGraphicBoard(arg0,realSize, getWidth(), getHeight(), g1.getBoard(),this);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}