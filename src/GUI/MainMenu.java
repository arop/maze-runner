package GUI;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class MainMenu extends MazeGameGUI implements Menu {

	private JFrame frame;
	private JButton play_button;
	private JButton options_button;
	private JButton quit_button;

	public MainMenu() {
		frame = new JFrame("Main Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3,3));
		createWidgets();
		addWidgets(frame.getContentPane());
		
		frame.setPreferredSize(new Dimension(WIDTH,HEIGHT)); //change values
		
		frame.pack();
		frame.setVisible(true);
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
				frame.setVisible(false);
				System.exit(0);
			}
			if(arg0.getSource()==options_button) {
				frame.setVisible(false);
				new OptionsMenu();
			}
			if(arg0.getSource()==play_button) {
				frame.setVisible(false);
				new MenuPlay();
			}
		}
	}

}
