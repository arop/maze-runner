package GUI;

import java.awt.*;

import javax.swing.*;

import GameLogic.Game;

import java.awt.event.*;

public class OptionsMenu extends JPanel {

	private JButton back_button;
	private JTextField sizeField;
	private JLabel sizeLabel;
	private JTextField numDragonsField;
	private JLabel numDragonsLabel;
	private JCheckBox movingOption;
	private JCheckBox sleepingOption;

	private Game g1;
	private MazeGameGUI frame;

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
		btnCancel.setBounds(242, 200, 119, 42);
		add(btnCancel);
	}

	public void createWidgets(){ 
		back_button = new JButton("Save & Back");
		back_button.setBounds(100, 200, 126, 42);
		back_button.addActionListener(new BackListener());
		sizeField = new JTextField();
		sizeField.setBounds(283, 69, 34, 20);
		sizeLabel = new JLabel("Size of maze");
		sizeLabel.setBounds(112, 72, 126, 14);
		numDragonsField  = new JTextField();
		numDragonsField.setBounds(283, 94, 34, 20);
		numDragonsLabel = new JLabel("Number of dragons");
		numDragonsLabel.setBounds(112, 97, 130, 14);
		movingOption = new JCheckBox("Moving dragons");
		movingOption.setBackground(Color.CYAN);
		movingOption.setBounds(112, 128, 174, 23);
		sleepingOption = new JCheckBox("Sleeping dragons");
		sleepingOption.setBackground(Color.CYAN);
		sleepingOption.setBounds(112, 154, 174, 23);

		sizeField.addFocusListener(new SizeListener());
		numDragonsField.addFocusListener(new NumDragonsListener());
		movingOption.addItemListener(new OptionsListener());
		sleepingOption.addItemListener(new OptionsListener());
	}


	public void addWidgets (Container cont) {
		setLayout(null);
		cont.add(sizeLabel);
		cont.add(sizeField);		
		cont.add(numDragonsLabel);
		cont.add(numDragonsField);
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

	public class SizeListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			String s = sizeField.getText();
			int n1=Integer.parseInt(s);

			if( n1>=5 && n1%2!=0){
				g1.setSize(n1);
			}

			else  JOptionPane.showMessageDialog(frame, "Size of board not accepted, please enter an " +
					"odd number bigger than 5");
		}

	}

	public class NumDragonsListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void focusLost(FocusEvent arg0) {
			String s = numDragonsField.getText();
			int n1=Integer.parseInt(s);

			if(n1<(g1.getSize()/7)) {
				g1.setNumber_dragons(n1);
				g1.setBoard();
			}
			else JOptionPane.showMessageDialog(frame, "Number of dragons not valid, please enter " +
					"a smaller number (smaller than (size/7))");				
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



