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

	public MainMenu(Game currentGame) {
		g1 = currentGame;
		createWidgets();
		addWidgets(this);
		
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT)); //change values
		
		this.setVisible(true);
	}

	public void createWidgets(){ 
		play_button = new JButton("Play");
		options_button = new JButton("Options");
		quit_button = new JButton("Quit");

		quit_button.addActionListener(new MainMenuListener());
		options_button.addActionListener(new MainMenuListener());
		play_button.addActionListener(new MainMenuListener());
	}


	public void addWidgets (Container cont) {
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
				setVisible(false);
				new OptionsMenu(g1);
			}
			if(arg0.getSource()==play_button) {
				setVisible(false);
				
			}
		}
	}

}
