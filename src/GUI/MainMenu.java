package GUI;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class MainMenu implements Menu {
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
		frame.pack();
		frame.setVisible(true);
		
			
	}
	
	public void createWidgets(){ 
		play_button = new JButton("Play");
		options_button = new JButton("Options");
		quit_button = new JButton("Quit");
		
		quit_button.addActionListener(new QuitListener());
		options_button.addActionListener(new OptionsListener());

	}
	
	
	public void addWidgets (Container cont) {
		cont.add(play_button);
		cont.add(options_button);
		cont.add(quit_button);
	}

	public class QuitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			System.exit(0);

		}
	}

	public class OptionsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			OptionsMenu a = new OptionsMenu();

		}
	}


	


}
