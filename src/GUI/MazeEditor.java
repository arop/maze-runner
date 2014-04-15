package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import GameLogic.Game;
/**
 * MazePanel.java - Esta classe representa o painel utilizado para a visualização do jogo em si
 * Assim, é apresentado o Board com todos os seus componentes
 * @author André Pires, Filipe Gama
 * @see GameLogic.Board, GameLogic.Game
 */
public class MazeEditor extends JPanel {

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


	public MazeEditor(int size,MazeGameGUI window) {
		frame = window;
		realSize=size;
		g1 = new Game(size+2);
		g1.setBoard();

		for(int i=0; i<size;i++)
			for(int j=0; j<size;j++){
				g1.getBoard().changeCurrentMaze(i, j, "X");
			}

		this.setLayout(new GridLayout(size,size));
		this.setBackground(Color.BLACK);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int n = (int) (e.getPoint().getX()/(frame.getWidth()/(realSize)));
				int m = (int) (e.getPoint().getY()/(frame.getHeight()/(realSize+1)));

				if(g1.getBoard().getCurrentState()[m][n].equals("X"))
					g1.getBoard().changeCurrentMaze(m, n, " ");
				else g1.getBoard().changeCurrentMaze(m, n, "X");

				updateGraphicBoard();
			}
		});

		updateGraphicBoard();
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
			}
		}
	}

	private void updateGraphicBoard() {
		this.repaint();
	}
}
