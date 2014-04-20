package maze.gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import maze.logic.Board;
/**
 * PaintTools.java - Esta classe serve de "container" para todas as imagens usadas no GUI, sejam elas das paredes
 * do labirinto, do heroi ou outras. Cria as imagens e desenha-as no local correto
 * Esta classe foi feita estática pois serve unicamente como ferramenta não tendo logica ser instanciada
 * @author André Pires, Filipe Gama
 * @see MazePanel
 */
public class PaintTools {

	private static BufferedImage sword = createImage("imagens/sword.png");
	private static BufferedImage wall = createImage("imagens/lava.png");
	private static BufferedImage path = createImage("imagens/metal.jpg");
	private static BufferedImage hero = createImage("imagens/darkknight2.png");
	private static BufferedImage hero_sword = createImage("imagens/HeroSword.png");
	private static BufferedImage dragon_awake = createImage("imagens/dragonAwake.png");
	private static BufferedImage dragon_sleeping = createImage("imagens/DragonSleeping.png");
	private static BufferedImage dragon_sword = createImage("imagens/dragonSword.png");
	private static BufferedImage eagle = createImage("imagens/eagle_fly.gif");
	private static BufferedImage background = createImage("imagens/mainMenuBackground.jpg");
	private static BufferedImage dragonMainMenu = createImage("imagens/DragonMain.png");
	private static BufferedImage doorClosed = createImage("imagens/door2.png");
	
	private static BufferedImage eagle_animation[] = createSprite(10,"eagle");
	private static BufferedImage title_animation[] = createSprite(5,"title");
	private static BufferedImage door_animation[] = createSprite(4,"door");
	
	private static boolean openDoor = false;
	private static int door_sprite_frame = 0;
	private static int eagle_sprite_frame = 0;

	private static BufferedImage createImage(String path) {
		BufferedImage image = null;
		try {                
			image = ImageIO.read(new File(path));
		} catch (IOException ex) {
			// handle exception...
		}
		return image;
	}
	
	private static BufferedImage[] createSprite(int size, String string) {
		BufferedImage arrayOfImages[] = new BufferedImage[size];
		for(int i = 0; i < size; i++) {
			arrayOfImages[i] = createImage("imagens/" + string + i +".png");
		}

		return arrayOfImages;
	}

	private void paintGrid(Graphics arg0, BufferedImage image, float w, float h, int i,int j,Component label) {
		arg0.drawImage(image, (int) (label.getX()+w*i), (int)(label.getY()+h*j), (int)(label.getX()+w+w*i),(int) (label.getY()+h+h*j), 0, 0, 50, 50, null);
	}
	
	static void resetFrames() {
		 door_sprite_frame = 0;
		 eagle_sprite_frame = 0;
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
				else if (b.getCurrentState()[j][i].equals("F")) paintGrid(arg0,dragon_sword,w,h,i,j,label);
				else if (b.getCurrentState()[j][i].equals("D")) paintGrid(arg0,dragon_awake,w,h,i,j,label);
				else if (b.getCurrentState()[j][i].equals("v") || b.getCurrentState()[j][i].equals("V")) {
					if(b.getOriginalMaze()[j][i].equals(" "))paintGrid(arg0,path,w,h,i,j,label);
					else if (b.getOriginalMaze()[j][i].equals("X"))paintGrid(arg0,wall,w,h,i,j,label);
					paintGrid(arg0,eagle_animation[eagle_sprite_frame],w,h,i,j,label);
				}

				else if(b.getCurrentState()[j][i].equals("s")){
					paintGrid(arg0,path,w,h,i,j,label);
					paintGrid(arg0,door_animation[door_sprite_frame],w,h,i,j,label);
				}
				else if(b.getCurrentState()[j][i].equals("S")) {
					openDoor = true;
					paintGrid(arg0,path,w,h,i,j,label);
					paintGrid(arg0,door_animation[door_sprite_frame],w,h,i,j,label);
				}

				else if (b.getCurrentState()[j][i].equals("d")) paintGrid(arg0,dragon_sleeping,w,h,i,j,label);
			}
		}

		refreshScreen();
	}

	private void refreshScreen() {
		if(eagle_sprite_frame >= eagle_animation.length-1) {
			eagle_sprite_frame = 0;
		}
		eagle_sprite_frame++;
		
		if(openDoor) {
			if(door_sprite_frame == 0) {
				GameSounds.loadSound("sons/BladeDragged.wav", "blade");
				GameSounds.playSound("blade");
			}
			if(door_sprite_frame >= door_animation.length-1) {
				openDoor = false;
			}
			else door_sprite_frame++;
		}

	}

	static BufferedImage getSword() {
		return sword;
	}

	static void setSword(BufferedImage sword) {
		PaintTools.sword = sword;
	}

	static BufferedImage getWall() {
		return wall;
	}

	static void setWall(BufferedImage wall) {
		PaintTools.wall = wall;
	}

	static BufferedImage getPath() {
		return path;
	}

	static void setPath(BufferedImage path) {
		PaintTools.path = path;
	}

	static BufferedImage getHero() {
		return hero;
	}

	static void setHero(BufferedImage hero) {
		PaintTools.hero = hero;
	}

	static BufferedImage getHero_sword() {
		return hero_sword;
	}

	static void setHero_sword(BufferedImage hero_sword) {
		PaintTools.hero_sword = hero_sword;
	}

	static BufferedImage getDragon_awake() {
		return dragon_awake;
	}

	static void setDragon_awake(BufferedImage dragon_awake) {
		PaintTools.dragon_awake = dragon_awake;
	}

	static BufferedImage getDragon_sleeping() {
		return dragon_sleeping;
	}

	static void setDragon_sleeping(BufferedImage dragon_sleeping) {
		PaintTools.dragon_sleeping = dragon_sleeping;
	}

	static BufferedImage getDragon_sword() {
		return dragon_sword;
	}

	static void setDragon_sword(BufferedImage dragon_sword) {
		PaintTools.dragon_sword = dragon_sword;
	}

	static BufferedImage getEagle() {
		return eagle;
	}

	static void setEagle(BufferedImage eagle) {
		PaintTools.eagle = eagle;
	}

	static BufferedImage getBackground() {
		return background;
	}

	static void setBackground(BufferedImage background) {
		PaintTools.background = background;
	}

	static BufferedImage getDragonMainMenu() {
		return dragonMainMenu;
	}

	static void setDragonMainMenu(BufferedImage dragonMainMenu) {
		PaintTools.dragonMainMenu = dragonMainMenu;
	}

	static BufferedImage getDoorClosed() {
		return doorClosed;
	}

	static void setDoorClosed(BufferedImage doorClosed) {
		PaintTools.doorClosed = doorClosed;
	}

	static BufferedImage[] getEagle_animation() {
		return eagle_animation;
	}

	static void setEagle_animation(BufferedImage[] eagle_animation) {
		PaintTools.eagle_animation = eagle_animation;
	}

	static BufferedImage[] getTitle_animation() {
		return title_animation;
	}

	static void setTitle_animation(BufferedImage[] title_animation) {
		PaintTools.title_animation = title_animation;
	}

	static BufferedImage[] getDoor_animation() {
		return door_animation;
	}

	static void setDoor_animation(BufferedImage[] door_animation) {
		PaintTools.door_animation = door_animation;
	}

	static boolean isOpenDoor() {
		return openDoor;
	}

	static void setOpenDoor(boolean openDoor) {
		PaintTools.openDoor = openDoor;
	}

	static int getDoor_sprite_frame() {
		return door_sprite_frame;
	}

	static void setDoor_sprite_frame(int door_sprite_frame) {
		PaintTools.door_sprite_frame = door_sprite_frame;
	}

	static int getEagle_sprite_frame() {
		return eagle_sprite_frame;
	}

	static void setEagle_sprite_frame(int eagle_sprite_frame) {
		PaintTools.eagle_sprite_frame = eagle_sprite_frame;
	}

	
	
}



