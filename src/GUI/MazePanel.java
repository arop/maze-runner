package GUI;

import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GameLogic.Game;
/**
 * MazePanel.java - Esta classe representa o painel utilizado para a visualização do jogo em si
 * Assim, é apresentado o Board com todos os seus componentes
 * @author André Pires, Filipe Gama
 * @see GameLogic.Board, GameLogic.Game
 */
public class MazePanel extends JPanel {


	private Game g1;
	private MazeGameGUI frame;
	private int realSize;

	private static final long serialVersionUID = 7836117138272018391L;

	private BufferedImage sword = creatImage("imagens/sword.jpg");
	private BufferedImage Wall =  creatImage("imagens/muralhaTemp.jpg");
	private BufferedImage Water =  creatImage("imagens/Water.gif");
	private BufferedImage Hero =  creatImage("imagens/hero.jpg");
	private BufferedImage Hero_sword =  creatImage("imagens/HeroSword.jpg");
	private BufferedImage Dragon_awake  =  creatImage("imagens/dragonAwake.png");
	private BufferedImage Dragon_sleeping = creatImage("images/DragonSleeping.jpg");
	private BufferedImage Eagle  =  creatImage("imagens/eagle.jpg");

	public MazePanel(Game currentGame, MazeGameGUI window){
		g1 = currentGame;
		frame = window;

		if(g1.getSize()-2 < 5) realSize = 10;
		else realSize = g1.getSize()-2;

		Play();
		UpdateGraphicBoard();

	}

	private BufferedImage creatImage(String path) {
		BufferedImage image = null;
		try {                
			image = ImageIO.read(new File(path));
		} catch (IOException ex) {
			// handle exception...
		}
		return image;
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

		float w = this.getWidth()/realSize;
		float h = this.getHeight()/realSize;

		for(int i = 0; i < realSize; i++) {
			for(int j= 0; j < realSize; j++) {
				if(g1.getBoard().getCurrentState()[j][i].equals(" ")) {
					arg0.drawImage(Water, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);
				}

				else if(g1.getBoard().getCurrentState()[j][i].equals("X")) {
					arg0.drawImage(Wall, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);
				}

				else if (g1.getBoard().getCurrentState()[j][i].equals("E")) {
					arg0.drawImage(sword, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50,50,null);
				}

				else if (g1.getBoard().getCurrentState()[j][i].equals("H")) {
					arg0.drawImage(Hero, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);
				}

				else if (g1.getBoard().getCurrentState()[j][i].equals("A")) {
					arg0.drawImage(Hero_sword, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);
				}

				else if (g1.getBoard().getCurrentState()[j][i].equals("D")) {
					arg0.drawImage(Dragon_awake, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);
				}

				else if (g1.getBoard().getCurrentState()[j][i].equals("t")) {
					arg0.drawImage(Dragon_sleeping, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);
				}

				else if(g1.getBoard().getCurrentState()[j][i].equals("v") || g1.getBoard().getCurrentState()[j][i].equals("V")) {
					arg0.drawImage(Eagle, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);
				}
			}
		}

	}

}

