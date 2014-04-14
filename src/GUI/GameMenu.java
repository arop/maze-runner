package GUI;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameLogic.Game;
import GameLogic.SaveGame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
/**
 * GameMenu.java - Esta classe representa o menu de "pause" durante o jogo; é invocado quando esta a decorrer
 * um jogo e o utilizador pressiona a tecla 'Esc'. Este menu contem 4 opçoes, 1- "Resume game" continuar o jogo,
 * 2-"Save game" guardar o jogo (abrindo uma janela para escolher o nome e sitio onde guardar o ficheiro),
 * 3-"Return to main menu" volta para o menu principal, 4-"Exit Game" termina o programa
 * Esta classe servira como um painel inserido na classe principal MazeGameGUI
 * @author André Pires, Filipe Gama
 * @see MazeGameGUI
 */
public class GameMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3085160492446725384L;
	private Game g1;
	private MazeGameGUI frame;
	private JFileChooser fc;
	public SaveGame sg;
	/**
	 * Construtor da classe GameMenu
	 * @param currentGame do tipo Game, representa o jogo que esta a ser jogado naquele momento
	 * @param window o menu pause é inserido neste parametro 
	 */
	public GameMenu(Game currentGame,MazeGameGUI window) {
		sg = new SaveGame(null, null);
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		setBackground(Color.BLACK);
		frame = window;
		g1 = currentGame;
		createWidgets();
		addWidgets(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("GAME PAUSED");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(146, 11, 199, 58);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("Resume Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.getMazePanel().setVisible(true);
				frame.getMazePanel().requestFocusInWindow();
			}
		});
		btnNewButton.setBounds(161, 80, 141, 30);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save Game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(161, 119, 141, 30);
		add(btnNewButton_1);

		JButton btnReturnToMain = new JButton("Return to main menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.getMainMenu().setVisible(true);
			}
		});
		btnReturnToMain.setBounds(161, 160, 141, 30);
		add(btnReturnToMain);

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(161, 201, 141, 30);
		add(btnExitGame);

		this.setVisible(true);
	}

	public void createWidgets(){

	}


	public void addWidgets (Container cont) {
	}
}
