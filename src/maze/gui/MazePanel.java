package maze.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import maze.logic.Game;
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
	private int delay = 50;
	

	private static final long serialVersionUID = 7836117138272018391L;


	public MazePanel(Game currentGame, MazeGameGUI window){
		this.setName("ambient");
		GameSounds.loadSound("sons/ambient.wav", "ambient");
		GameSounds.adjustVolume("ambient", 5);
		GameSounds.playSound("ambient");
		g1 = currentGame;
		frame = window;
		

		animation = new Timer(delay,this);
		animation.start();

		if(g1.getSize() < 5) realSize = 10;
		else realSize = g1.getSize();

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
				GameSounds.stop("ambient");
				frame.getPaused().setVisible(true);
			}

			UpdateGraphicBoard();

			switch(output) {
			case 1: //quit
				frame.disableAll();
				GameSounds.stop("ambient");
				frame.enablePanel(frame.getMainMenu());
				break;
			case 2: //dead
				GameSounds.loadSound("sons/DragonRoaring.wav", "dragon");
				GameSounds.adjustVolume("dragon", 5);
				GameSounds.playSound("dragon");
				JOptionPane.showMessageDialog(frame, "You died!");
				GameSounds.stop("ambient");
				frame.disableAll();
				setVisible(false);
				
				//create new game with same components		
				frame.getMainMenu().getGame().setBoard();

				frame.enablePanel(frame.getMainMenu());
				break;
			case 3: //won
				GameSounds.loadSound("sons/victory.wav", "win");
				GameSounds.adjustVolume("win", -10);
				GameSounds.playSound("win");
				JOptionPane.showMessageDialog(frame, "You won!");
				frame.disableAll();
				GameSounds.stop("ambient");
				setVisible(false);
				
				//create new game with same components	
				frame.getMainMenu().getGame().setBoard();
				
				frame.enablePanel(frame.getMainMenu());
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
		repaint();
	}

}