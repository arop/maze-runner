package GUI;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLogic.Board;
/**
 * PaintTools.java - Esta classe serve de "container" para todas as imagens usadas no GUI, sejam elas das paredes
 * do labirinto, do heroi ou outras. Cria as imagens e desenha-as no local correto
 * @author André Pires, Filipe Gama
 * @see MazePanel
 */
public class PaintTools {

	private BufferedImage sword = createImage("imagens/sword.jpg");
	private BufferedImage wall =  createImage("imagens/muralhaTemp.jpg");
	private BufferedImage water =  createImage("imagens/Water.gif");
	private BufferedImage hero =  createImage("imagens/hero.jpg");
	private BufferedImage hero_sword =  createImage("imagens/HeroSword.jpg");
	private BufferedImage dragon_awake  =  createImage("imagens/dragonAwake.png");
	private BufferedImage dragon_sleeping = createImage("images/DragonSleeping.jpg");
	private BufferedImage Eagle  =  createImage("imagens/eagle.jpg");
//	private BufferedImage Title[] = createSprite(5,"title");

	BufferedImage createImage(String path) {
		BufferedImage image = null;
		try {                
			image = ImageIO.read(new File(path));
		} catch (IOException ex) {
			// handle exception...
		}
		return image;
	}

//	private BufferedImage[] createSprite(int size, String string) {
//		BufferedImage arrayOfImages[] = new BufferedImage[size];
//		for(int i = 0; i < Title.length; i++) {
//			arrayOfImages[i] = createImage("imagens/" + string + i +".jpg");
//		}
//		
//		return arrayOfImages;
//	}

	private void paintGrid(Graphics arg0, BufferedImage image, float w, float h, int i,int j,Component label) {
		arg0.drawImage(image, (int) (label.getX()+w*i), (int)(label.getY()+h*j), (int)(label.getX()+w+w*i),(int) (label.getY()+h+h*j), 0, 0, 50, 50, null);

	}

	void drawGraphicBoard(Graphics arg0,int realSize,int width,int height, Board b, Component label) {
		float w = width/realSize;
		float h = height/realSize;

		for(int i = 0; i < realSize; i++) {
			for(int j= 0; j < realSize; j++) {

				if(b.getCurrentState()[j][i].equals(" ")) paintGrid(arg0,water,w,h,i,j,label);
				else if(b.getCurrentState()[j][i].equals("X")) paintGrid(arg0,wall,w,h,i,j,label);
				else if (b.getCurrentState()[j][i].equals("E")) paintGrid(arg0,sword,w,h,i,j,label);
				else if (b.getCurrentState()[j][i].equals("H")) paintGrid(arg0,hero,w,h,i,j,label);
				else if (b.getCurrentState()[j][i].equals("A")) paintGrid(arg0,hero_sword,w,h,i,j,label);
				else if (b.getCurrentState()[j][i].equals("D")) paintGrid(arg0,dragon_awake,w,h,i,j,label);
				else if(b.getCurrentState()[j][i].equals("v") || b.getCurrentState()[j][i].equals("V")) paintGrid(arg0,Eagle,w,h,i,j,label);
				else paintGrid(arg0,dragon_sleeping,w,h,i,j,label);

			}
		}
	}


}



