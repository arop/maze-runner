package GUI;

import java.awt.*;

import javax.swing.*;

import GameLogic.Game;

import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
/**
 * OptionsMenu.java - Esta classe representa o menu de opções, sendo que é possivel alterar o tamanho do labirinto,
 * o numero de dragoes, a possibilidade dos dragoes adormecerem/moverem, e a mudança dos controlos do jogo
 * @author André Pires, Filipe Gama
 *
 */
public class OptionsMenuOld extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263198567267112200L;
	private JButton back_button;
	private JLabel sizeLabel;
	private JLabel numDragonsLabel;
	private JCheckBox movingOption;
	private JCheckBox sleepingOption;

	private int size = 11;
	private int numberDrags = 1;

	private Game g1;
	private MazeGameGUI frame;
	private JSpinner spinner_1;

	public OptionsMenuOld(Game currentGame,MazeGameGUI window) {
		setBackground(Color.GRAY);
		g1 = currentGame;
		frame = window;
		createWidgets();
		addWidgets(this);

		JLabel OPTIONS = new JLabel("OPTIONS");
		OPTIONS.setFont(new Font("Tahoma", Font.PLAIN, 23));
		OPTIONS.setBounds(172, 11, 103, 36);
		add(OPTIONS);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.disableAll();
				frame.getMainMenu().setVisible(true);	
			}
		});

		btnCancel.setBounds(296, 216, 114, 42);
		add(btnCancel);

		final JSpinner spinner = new JSpinner();
		spinner.setBackground(Color.LIGHT_GRAY);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				size = (int) spinner.getValue();
			}
		});
		spinner.setModel(new SpinnerNumberModel(11, 5, 51, 2));
		spinner.setBounds(252, 69, 56, 20);
		add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setBackground(Color.LIGHT_GRAY);
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				numberDrags = (int) spinner_1.getValue();
			}
		});

		spinner_1.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		spinner_1.setBounds(252, 94, 56, 20);
		add(spinner_1);

		JButton btnDefault = new JButton("Default");
		btnDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.disableAll();
				g1.setNumber_dragons(1);
				g1.setSize(1);
				frame.getMainMenu().setVisible(true);


			}
		});
		btnDefault.setBounds(172, 216, 114, 42);
		add(btnDefault);
	}

	public void createWidgets(){ 
		back_button = new JButton("Save & Back");
		back_button.setBounds(52, 216, 114, 42);
		back_button.addActionListener(new BackListener());
		sizeLabel = new JLabel("Size of maze");
		sizeLabel.setBounds(112, 72, 126, 14);
		numDragonsLabel = new JLabel("Number of dragons");
		numDragonsLabel.setBounds(112, 97, 130, 14);
		movingOption = new JCheckBox("Moving dragons");
		movingOption.setBackground(Color.GRAY);
		movingOption.setBounds(112, 128, 174, 23);
		sleepingOption = new JCheckBox("Sleeping dragons");
		sleepingOption.setBackground(Color.GRAY);
		sleepingOption.setBounds(112, 154, 174, 23);
		movingOption.addItemListener(new OptionsListener());
		sleepingOption.addItemListener(new OptionsListener());
	}


	public void addWidgets (Container cont) {
		setLayout(null);
		cont.add(sizeLabel);
		cont.add(numDragonsLabel);
		cont.add(movingOption);
		cont.add(sleepingOption);
		cont.add(back_button);
	}

	public class BackListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.disableAll();
			g1.setNumber_dragons(numberDrags);
			g1.setSize(size+2);
			frame.getMainMenu().setVisible(true);
		}
	}

	public class OptionsListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			if(arg0.getSource()==movingOption) { 
				g1.setMovingDragons();
			}
			if(arg0.getSource()==sleepingOption) { 
				g1.setSleepingDragons();
			}
		}
	}
}