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
 * @author Andr� Pires, Filipe Gama
 * @see MazePanel
 */
public class PaintTools {

	private BufferedImage sword = createImage("imagens/sword.png");
	private BufferedImage wall =  createImage("imagens/lava.png");
	private BufferedImage path =  createImage("imagens/metal.jpg");
	private BufferedImage hero =  createImage("imagens/hero.png");
	private BufferedImage hero_sword =  createImage("imagens/HeroSword.png");
	private BufferedImage dragon_awake  =  createImage("imagens/dragonAwake.png");
	private BufferedImage dragon_sleeping = createImage("images/DragonSleeping.png");
	private BufferedImage Eagle  =  createImage("imagens/eagle_fly.gif");
	private BufferedImage background = createImage("imagens/mainMenuBackground.jpg");

	private BufferedImage Title[] = createSprite(5,"title");

	BufferedImage createImage(String path) {
		BufferedImage image = null;
		try {                
			image = ImageIO.read(new File(path));
		} catch (IOException ex) {
			// handle exception...
		}
		return image;
	}

	private BufferedImage[] createSprite(int size, String string) {
		BufferedImage arrayOfImages[] = new BufferedImage[size];
		for(int i = 0; i < size; i++) {
			arrayOfImages[i] = createImage("imagens/" + string + i +".png");
		}

		return arrayOfImages;
	}


	private void paintGrid(Graphics arg0, BufferedImage image, float w, float h, int i,int j,Component label) {
		arg0.drawImage(image, (int) (label.getX()+w*i), (int)(label.getY()+h*j), (int)(label.getX()+w+w*i),(int) (label.getY()+h+h*j), 0, 0, 50, 50, null);

	}

	void drawGraphicBoard(Graphics arg0,int realSize,int width,int height, Board b, Component label) {
		float w = width/realSize;
		float h = height/realSize;

		for(int i = 0; i < realSize; i++) {
			for(int j= 0; j < realSize; j++) {
				if(b.getCurrentState()[j][i].equals(" ")) paintGrid(arg0,path,w,h,i,j,label);
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

	public BufferedImage[] getTitle() {
		return Title;
	}

	public void setTitle(BufferedImage[] title) {
		Title = title;
	}


	public BufferedImage getSword() {
		return sword;
	}

	public void setSword(BufferedImage sword) {
		this.sword = sword;
	}

	public BufferedImage getWall() {
		return wall;
	}

	public void setWall(BufferedImage wall) {
		this.wall = wall;
	}

	public BufferedImage getWater() {
		return path;
	}

	public void setWater(BufferedImage water) {
		this.path = water;
	}

	public BufferedImage getHero() {
		return hero;
	}

	public void setHero(BufferedImage hero) {
		this.hero = hero;
	}

	public BufferedImage getHero_sword() {
		return hero_sword;
	}

	public void setHero_sword(BufferedImage hero_sword) {
		this.hero_sword = hero_sword;
	}

	public BufferedImage getDragon_awake() {
		return dragon_awake;
	}

	public void setDragon_awake(BufferedImage dragon_awake) {
		this.dragon_awake = dragon_awake;
	}

	public BufferedImage getDragon_sleeping() {
		return dragon_sleeping;
	}

	public void setDragon_sleeping(BufferedImage dragon_sleeping) {
		this.dragon_sleeping = dragon_sleeping;
	}

	public BufferedImage getEagle() {
		return Eagle;
	}

	public void setEagle(BufferedImage eagle) {
		Eagle = eagle;
	}

	public BufferedImage getBackground() {
		return background;
	}

	public void setBackground(BufferedImage background) {
		this.background = background;
	}

	//	public BufferedImage[] getTitle() {
	//		return Title;
	//	}
	//
	//	public void setTitle(BufferedImage[] title) {
	//		Title = title;
	//	}



}



