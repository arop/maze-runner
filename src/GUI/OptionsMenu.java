package GUI;

import java.awt.*;

import javax.swing.*;

import GameLogic.Game;

import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class OptionsMenu extends JPanel {

	private JButton back_button;
	private JLabel sizeLabel;
	private JLabel numDragonsLabel;
	private JCheckBox movingOption;
	private JCheckBox sleepingOption;
	
	private int size = 10;
	private int numberDrags = 1;

	private Game g1;
	private MazeGameGUI frame;
	private JSpinner spinner_1;

	public OptionsMenu(Game currentGame,MazeGameGUI window) {
		setBackground(Color.CYAN);
		g1 = currentGame;
		frame = window;
		createWidgets();
		addWidgets(this);

		JLabel OPTIONS = new JLabel("OPTIONS");
		OPTIONS.setFont(new Font("Tahoma", Font.PLAIN, 23));
		OPTIONS.setBounds(167, 11, 103, 36);
		add(OPTIONS);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnCancel.setBounds(242, 200, 119, 42);
		add(btnCancel);
		
		final JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				size = (int) spinner.getValue();
				g1.setSize(size+2);
		}
		});
		spinner.setModel(new SpinnerNumberModel(11, 5, 51, 2));
		spinner.setBounds(252, 69, 56, 20);
		add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_1.setBounds(252, 94, 56, 20);
		add(spinner_1);
	}

	public void createWidgets(){ 
		back_button = new JButton("Save & Back");
		back_button.setBounds(100, 200, 126, 42);
		back_button.addActionListener(new BackListener());
		sizeLabel = new JLabel("Size of maze");
		sizeLabel.setBounds(112, 72, 126, 14);
		numDragonsLabel = new JLabel("Number of dragons");
		numDragonsLabel.setBounds(112, 97, 130, 14);
		movingOption = new JCheckBox("Moving dragons");
		movingOption.setBackground(Color.CYAN);
		movingOption.setBounds(112, 128, 174, 23);
		sleepingOption = new JCheckBox("Sleeping dragons");
		sleepingOption.setBackground(Color.CYAN);
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
			frame.getMainMenu().setVisible(true);
		}
	}

	public class OptionsListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			if(arg0.getSource()==movingOption) { 
				g1.setMovingDragons();
				g1.setBoard();
			}
			if(arg0.getSource()==sleepingOption) { 
				g1.setSleepingDragons();
				g1.setBoard();
			}
		}

	}
}



