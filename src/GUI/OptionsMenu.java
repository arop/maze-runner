package GUI;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class OptionsMenu {

	private JFrame frame;
	private JButton back_button;
	private JTextField sizeField;
	private JLabel sizeLabel;
	private JTextField numDragonsField;
	private JLabel numDragonsLabel;
	private JLabel movingDragonsLabel;
	private JLabel sleepingDragonsLabel;


	public OptionsMenu() {
		frame = new JFrame("Options Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(5,5));
		createWidgets();
		addWidgets(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);


	}

	private void createWidgets(){ 
		back_button = new JButton("Back");
		back_button.addActionListener(new BackListener());
		sizeField = new JTextField();
		sizeLabel = new JLabel("Size");
		numDragonsField  = new JTextField();
		numDragonsLabel = new JLabel("Number of dragons");
		movingDragonsLabel = new JLabel("Moving dragons:");
		sleepingDragonsLabel = new JLabel("Sleeping dragons:");
		
		
		
	}


	private void addWidgets (Container cont) {

		cont.add(sizeField);
		cont.add(sizeLabel);
		cont.add(numDragonsField);
		cont.add(numDragonsLabel);
		cont.add(movingDragonsLabel);
		cont.add(sleepingDragonsLabel);
		cont.add(back_button);
	}



	public class BackListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			return ;

		}
	}






}


