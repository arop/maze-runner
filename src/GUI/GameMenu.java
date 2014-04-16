package GUI;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import GameLogic.Game;
import GameLogic.SaveGame;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import java.awt.Color;
/**
 * GameMenu.java - Esta classe representa o menu de "pause" durante o jogo; é invocado quando esta a decorrer
 * um jogo e o utilizador pressiona a tecla 'Esc'. Este menu contem 4 opçoes, 1- "Resume game" continuar o jogo,
 * 2-"Save game" guardar o jogo (abrindo uma janela para escolher o nome e sitio onde guardar o ficheiro),
 * 3-"Return to main menu" volta para o menu principal, 4-"Exit Game" termina o programa
 * Esta classe servira como um painel inserido na classe principal MazeGameGUI
 * @author André Pires, Filipe Gama
 * @see MazeGameGUI
 */

public class GameMenu extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3085160492446725384L;
	private Game g1;
	private MazeGameGUI frame;
	private JFileChooser fc;
	public SaveGame sg;
	
	private JPanel panel_5 = new JPanel();
	private PaintTools paintObj = new PaintTools();
	
	private BufferedImage title = paintObj.creatImage("imagens/Title.gif");
	private BufferedImage background = paintObj.creatImage("imagens/mainMenuBackground.jpg");
	/**
	 * Construtor da classe GameMenu
	 * @param currentGame do tipo Game, representa o jogo que esta a ser jogado naquele momento
	 * @param window o menu pause é inserido neste parametro 
	 */
	public GameMenu(Game currentGame,MazeGameGUI window) {
		
		sg = new SaveGame(null, null);
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		frame = window;
		g1 = currentGame;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		
		GridLayout gridlayout = new GridLayout(6,3);
		gridlayout.setVgap(20);
		panel.setLayout(gridlayout);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.WHITE);
		panel.add(panel_5);

		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Resume");
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Save");
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Return to Main Menu");
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_4.add(lblNewLabel_6);
		
		JButton btnNewButton_3 = new JButton("Exit");
		panel_4.add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel_4.add(lblNewLabel_7);
	
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(background,0,0,this.getWidth(),this.getHeight(), 0, 0, background.getWidth(),background.getHeight(), null);
		arg0.drawImage(title,this.getWidth()/4,this.getHeight()/12,this.getWidth()-this.getWidth()/4,panel_5.getY()+panel_5.getHeight(), 0, 0, title.getWidth(),title.getHeight(), null);
	}
	
	
}
