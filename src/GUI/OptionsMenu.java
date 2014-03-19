package GUI;

import java.awt.*;

import javax.swing.*;

import GameLogic.Game;

import java.awt.event.*;

public class OptionsMenu extends MazeGameGUI implements Menu {

	private JFrame frame;
	private JButton back_button;
	private JTextField sizeField;
	private JLabel sizeLabel;
	private JTextField numDragonsField;
	private JLabel numDragonsLabel;
	private JCheckBox movingOption;
	private JCheckBox sleepingOption;

	private boolean validSize = true;
	private boolean validNumDragons = true;

	public OptionsMenu() {
		frame = new JFrame("Options Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(5,5));
		createWidgets();
		addWidgets(frame.getContentPane());
		
		frame.setPreferredSize(new Dimension(WIDTH,HEIGHT)); //change values
		
		frame.pack();
		frame.setVisible(true);
	}

	public void createWidgets(){ 
		back_button = new JButton("Back");
		back_button.addActionListener(new BackListener());
		sizeField = new JTextField();
		sizeLabel = new JLabel("Size of maze");
		numDragonsField  = new JTextField();
		numDragonsLabel = new JLabel("Number of dragons");
		movingOption = new JCheckBox("Moving dragons");
		sleepingOption = new JCheckBox("Sleeping dragons");

		sizeField.addActionListener(new NumberListener());
		numDragonsField.addActionListener(new NumberListener());
		movingOption.addItemListener(new OptionsListener());
		sleepingOption.addItemListener(new OptionsListener());
	}


	public void addWidgets (Container cont) {
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
			//TODO this
			//if(!validSize) pop up size not changed
			//if(!validNumDragons) pop up
			frame.setVisible(false);
			g1.setBoard();
			new MainMenu();
		}
	}

	public class NumberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s;
			if(arg0.getSource()==sizeField) {
				s = sizeField.getText();
				int n1=Integer.parseInt(s);

				if( n1>=5 && n1%2!=0){
					validSize= true;
					g1 = new Game(n1+2);
				}

				else  validSize=false;
			}

			if(arg0.getSource()==numDragonsField) {
				s= numDragonsField.getText();
				int n1=Integer.parseInt(s);

				if(n1<(g1.getSize()/7)) {
					validNumDragons=true;
					g1.setNumber_dragons(n1);
				}
				else validNumDragons=false;				
			}

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



