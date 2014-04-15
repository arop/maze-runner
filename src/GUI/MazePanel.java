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
	private PaintTools paintObj = new PaintTools();

	private static final long serialVersionUID = 7836117138272018391L;

	private BufferedImage sword = paintObj.creatImage("imagens/sword.jpg");
	private BufferedImage Wall =  paintObj.creatImage("imagens/muralhaTemp.jpg");
	private BufferedImage Water =  paintObj.creatImage("imagens/Water.gif");
	private BufferedImage Hero =  paintObj.creatImage("imagens/hero.jpg");
	private BufferedImage Hero_sword =  paintObj.creatImage("imagens/HeroSword.jpg");
	private BufferedImage Dragon_awake  =  paintObj.creatImage("imagens/dragonAwake.png");
	private BufferedImage Dragon_sleeping = paintObj.creatImage("images/DragonSleeping.jpg");
	private BufferedImage Eagle  =  paintObj.creatImage("imagens/eagle.jpg");

	public MazePanel(Game currentGame, MazeGameGUI window){
		g1 = currentGame;
		frame = window;

		if(g1.getSize()-2 < 5) realSize = 10;
		else realSize = g1.getSize()-2;

		Play();
		UpdateGraphicBoard();

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
	
	private void paintGrid(Graphics arg0, BufferedImage image, float w, float h, int i,int j) {
		arg0.drawImage(image, (int) (0+w*i), (int)(0+h*j), (int)(w+w*i),(int) (h+h*j), 0, 0, 50, 50, null);

	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);

		float w = this.getWidth()/realSize;
		float h = this.getHeight()/realSize;

		for(int i = 0; i < realSize; i++) {
			for(int j= 0; j < realSize; j++) {
				
				if(g1.getBoard().getCurrentState()[j][i].equals(" ")) paintGrid(arg0,Water,w,h,i,j);
				else if(g1.getBoard().getCurrentState()[j][i].equals("X")) paintGrid(arg0,Wall,w,h,i,j);
				else if (g1.getBoard().getCurrentState()[j][i].equals("E")) paintGrid(arg0,sword,w,h,i,j);
				else if (g1.getBoard().getCurrentState()[j][i].equals("H")) paintGrid(arg0,Hero,w,h,i,j);
				else if (g1.getBoard().getCurrentState()[j][i].equals("A")) paintGrid(arg0,Hero_sword,w,h,i,j);
				else if (g1.getBoard().getCurrentState()[j][i].equals("D")) paintGrid(arg0,Dragon_awake,w,h,i,j);
				else if(g1.getBoard().getCurrentState()[j][i].equals("v") || g1.getBoard().getCurrentState()[j][i].equals("V")) paintGrid(arg0,Eagle,w,h,i,j);
				else paintGrid(arg0,Dragon_sleeping,w,h,i,j);
			}
		}

	}

}