package GUI;

import java.awt.*;

import javax.swing.*;

import GameLogic.Game;
import GameLogic.SaveGame;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
/**
 * MainMenu.java - Esta classe representa o menu principal do jogo, tendo como opçoes: 1-"New game" que inicia
 * um novo jogo, 2-"Load game" que da a possibilidade ao utilizador de retomar um jogo previamente guardado sendo 
 * que abre uma nova janela onde o utilizador escolhe o ficheiro
 * @author André Pires, Filipe Gama
 *
 */
public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7979274358212876062L;
	private JButton new_game_button;
	private JButton load_button;
	private JButton options_button;
	private JButton quit_button;
	private JFileChooser fc;
	private Game g1;
	private MazeGameGUI frame;
	private JLabel lblMazeGame;
	public SaveGame sg;

	public MainMenu(Game currentGame,MazeGameGUI window) {
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		sg=new SaveGame(null,null);

		setBackground(Color.BLACK);
		frame = window;
		g1 = currentGame;
		createWidgets();
		addWidgets(this);

		this.setPreferredSize(new Dimension(440, 357)); //change values

		lblMazeGame = new JLabel("MAZE GAME");
		lblMazeGame.setForeground(Color.RED);
		lblMazeGame.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMazeGame.setBounds(141, 11, 194, 58);
		add(lblMazeGame);

		this.setVisible(true);
	}

	public void createWidgets(){ 
		new_game_button = new JButton("New Game");
		new_game_button.setBounds(153, 88, 149, 53);
		new_game_button.setFocusable(false);
		load_button = new JButton("Load Game");
		load_button.setBounds(153, 166, 149, 53);
		load_button.setFocusable(false);
		options_button = new JButton("Options");
		options_button.setBounds(153, 244, 149, 53);
		options_button.setFocusable(false);
		quit_button = new JButton("Quit");
		quit_button.setBounds(153, 322, 149, 53);
		quit_button.setFocusable(false);

		quit_button.addActionListener(new MainMenuListener());
		options_button.addActionListener(new MainMenuListener());
		new_game_button.addActionListener(new MainMenuListener());
		load_button.addActionListener(new MainMenuListener());
	}


	public void addWidgets (Container cont) {
		setLayout(null);
		cont.add(new_game_button);
		cont.add(load_button);
		cont.add(options_button);
		cont.add(quit_button);
	}

	public class MainMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean x = false;
			if(arg0.getSource()==quit_button) {
				setVisible(false);
				System.exit(0);
			}
			if(arg0.getSource()==options_button) {
				frame.disableAll();
				frame.getOptions().setVisible(true);
			}
			if(arg0.getSource()==load_button) {
				try {
					int returnVal = fc.showOpenDialog(MainMenu.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						sg.setFile(file);
						sg.loadGame();
						g1=(Game) sg.getGame();
						x=true;
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(x) {
					frame.disableAll();
					frame.setMazePanel(new MazePanel(g1,frame));
					frame.add(frame.getMazePanel());
					frame.getMazePanel().setVisible(true);
					frame.getMazePanel().requestFocusInWindow();
				}
			}
			if(arg0.getSource()==new_game_button) {
				if(g1.getBoard() == null) {
					g1.setBoard();
				}				
				frame.disableAll();
				frame.setMazePanel(new MazePanel(g1, frame));
				frame.add(frame.getMazePanel());
				frame.getMazePanel().setVisible(true);
				frame.getMazePanel().requestFocusInWindow();								
			}
		}
	}
}
