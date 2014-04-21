package maze.gui;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import maze.logic.Game;
import maze.logic.SaveGame;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
/**
 * GameMenu.java - Esta classe representa o menu de "pause" durante o jogo; é invocado quando esta a decorrer
 * um jogo e o utilizador pressiona a tecla 'Esc'. Este menu contem 4 opçoes, 1- "Resume" continuar o jogo,
 * 2-"Save" guardar o jogo (abrindo uma janela para escolher o nome e directorio onde guardar o ficheiro),
 * 3-"Return to main menu" volta para o menu principal, 4-"Exit" termina o programa
 * Esta classe servira como um painel inserido na classe principal MazeGameGUI
 * @author André Pires, Filipe Gama
 * @see MazeGameGUI
 */

public class GameMenu extends JLabel implements ActionListener {
	private static final long serialVersionUID = 3085160492446725384L;
	private Game g1;
	private MazeGameGUI frame;
	private JFileChooser fc;
	private SaveGame sg;

	@SuppressWarnings("unused")
	private JPanel panel_5 = new JPanel();

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
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		add(panel, BorderLayout.CENTER);

		GridLayout gridlayout = new GridLayout(6,3);
		gridlayout.setVgap(20);
		panel.setLayout(gridlayout);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setForeground(Color.WHITE);
		panel.add(panel_5);

		JLabel lblNewLabel = new JLabel("GAME PAUSED");
		lblNewLabel.setFont(new Font("Trajan Pro", Font.PLAIN, 27));
		lblNewLabel.setForeground(Color.RED);
		panel_5.add(lblNewLabel);


		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		panel_2.add(new JLabel(""));

		JButton Resume = new JButton("Resume");
		Resume.setForeground(Color.RED);
		Resume.setBackground(Color.BLACK);
		Resume.setActionCommand("Resume");
		Resume.addActionListener(this);
		panel_2.add(Resume);

		panel_2.add(new JLabel(""));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);

		JButton Save = new JButton("Save");
		Save.setForeground(Color.RED);
		Save.setBackground(Color.BLACK);
		Save.setActionCommand("Save");
		Save.addActionListener(this);
		panel_3.add(Save);

		JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("");
		panel_1.add(lblNewLabel_4);

		JButton Return = new JButton("Return to Main Menu");
		Return.setForeground(Color.RED);
		Return.setBackground(Color.BLACK);
		Return.setActionCommand("Return");
		Return.addActionListener(this);
		panel_1.add(Return);

		panel_1.add(new JLabel(""));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		panel_4.add(new JLabel(""));

		JButton Exit = new JButton("Exit");
		Exit.setForeground(Color.RED);
		Exit.setBackground(Color.BLACK);
		Exit.setActionCommand("Exit");
		Exit.addActionListener(this);
		panel_4.add(Exit);

		panel_4.add( new JLabel(""));
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()){
		case ("Resume"): 
			GameSounds.playSound("button");
			setVisible(false);
			frame.enablePanel(frame.getMazePanel());
			frame.getMazePanel().requestFocusInWindow();
			break;

		case("Save"): 
			GameSounds.playSound("button");
		try {
			File file = null;
			int returnVal = fc.showSaveDialog(GameMenu.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				sg.setFile(file);
				sg.setGame(g1);
				sg.saveGame();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		break;

		case("Return"):
			GameSounds.playSound("button");
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to main menu?");
		if (resposta == JOptionPane.YES_OPTION) {
			setVisible(false);
			frame.getMainMenu().getGame().setBoard();
			frame.enablePanel(frame.getMainMenu());
		}
		break;

		case("Exit"):
			GameSounds.playSound("button");
		int resposta1;
		resposta1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
		if (resposta1 == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		}
	}
}