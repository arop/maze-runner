package GUI;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;

import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import GameLogic.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.FlowLayout;

public class OptionsMenu extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Game g1;
	private MazeGameGUI frame;
	private int size = 11;
	private int numberDrags = 1;
	
	public OptionsMenu(Game currentGame,MazeGameGUI window) {
		g1 = currentGame;
		frame = window;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("OPTIONS MENU");
		lblNewLabel_11.setFont(new Font("Trajan Pro", Font.PLAIN, 25));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_11);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.disableAll();
				frame.getMainMenu().setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Default");
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.disableAll();
				g1.setNumber_dragons(1);
				g1.setSize(1);
				frame.getMainMenu().setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Custom");
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.disableAll();
				frame.getEditor().setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.disableAll();
				g1.setNumber_dragons(numberDrags);
				g1.setSize(size+2);
				frame.getMainMenu().setVisible(true);
				
			}
		});
		panel_1.add(btnNewButton);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_5 = new JButton("Windowed");
		panel_8.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Fullscreen");
		panel_8.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame.setExtendedState(frame.MAXIMIZED_BOTH);  
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame.setUndecorated(false);
				frame.setVisible(true);
			}
		});
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		JLabel lblNewLabel_5 = new JLabel("Size of Maze");
		panel_9.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JSpinner spinner = new JSpinner();
		panel_9.add(spinner);
		spinner.setModel(new SpinnerNumberModel(11, 7, 51, 2));
		
		JLabel lblNewLabel_4 = new JLabel("Number of Dragons");
		panel_9.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JSpinner spinner_1 = new JSpinner();
		panel_9.add(spinner_1);
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				numberDrags = (int) spinner_1.getValue();
			}
		});
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				size = (int) spinner.getValue();
			}
		});
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 2, 0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sleeping Dragons");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Moving Dragons");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_7.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.setMovingDragons();
			}
		});
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.setSleepingDragons();
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 5, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("RIGHT");
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("UP");
		panel_5.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("LEFT");
		panel_5.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("DOWN");
		lblNewLabel_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				frame.getControls().set(4, e.getKeyCode());
			}
		});
		panel_5.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Eagle");
		panel_5.add(lblNewLabel_10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				frame.getControls().set(0, arg0.getKeyCode());
				
			}
		});
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				frame.getControls().set(1, arg0.getKeyCode());
			}
		});
		panel_5.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				frame.getControls().set(3, arg0.getKeyCode());
			}
		});
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel_5.add(textField_4);
		textField_4.setColumns(10);
	}

}
