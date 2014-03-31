package GUI;

import java.awt.*;

import javax.swing.*;

import GameLogic.Game;

import java.awt.event.*;

public class MainMenu extends JPanel {

	private JButton play_button;
	private JButton options_button;
	private JButton quit_button;
	private Game g1;
	private MazeGameGUI frame;
	private JLabel lblMazeGame;

	public MainMenu(Game currentGame,MazeGameGUI window) {
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
		play_button = new JButton("Play");
		play_button.setBounds(153, 88, 149, 53);
		options_button = new JButton("Options");
		options_button.setBounds(153, 166, 149, 53);
		quit_button = new JButton("Quit");
		quit_button.setBounds(153, 244, 149, 53);

		quit_button.addActionListener(new MainMenuListener());
		options_button.addActionListener(new MainMenuListener());
		play_button.addActionListener(new MainMenuListener());
	}


	public void addWidgets (Container cont) {
		setLayout(null);
		cont.add(play_button);
		cont.add(options_button);
		cont.add(quit_button);
	}

	public class MainMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==quit_button) {
				setVisible(false);
				System.exit(0);
			}
			if(arg0.getSource()==options_button) {
				frame.disableAll();
				frame.getOptions().setVisible(true);
			}
			if(arg0.getSource()==play_button) {
				frame.disableAll();
				frame.setMazePanel(new MazePanel(g1, frame));
				frame.add(frame.getMazePanel());
				frame.getMazePanel().setVisible(true);
				frame.getMazePanel().requestFocusInWindow();								
			}
		}
	}
}
