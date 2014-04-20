package maze.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

import maze.logic.Game;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
/**
 * OptionsMenu.java - Esta classe representa o menu de opções, sendo que é possivel alterar o tamanho do labirinto,
 * o numero de dragoes, a possibilidade dos dragoes adormecerem/moverem, e a mudança dos controlos do jogo
 * Adicionalmente, pode ser alternado o modo de visualizaçao do programa (fullscreen/windowed)
 * @author André Pires, Filipe Gama
 *
 */
public class OptionsMenu extends JPanel {
	private static final long serialVersionUID = 4486102490208999655L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Game g1;
	private MazeGameGUI frame;
	private int size = 11;
	private int numberDrags = 1;

	private ArrayList<Integer> controls1;

	@SuppressWarnings("unchecked")
	public OptionsMenu(Game currentGame,MazeGameGUI window) {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);

		controls1 = (ArrayList<Integer>) window.getControls().clone();

		g1 = currentGame;
		frame = window;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_12 = new JLabel("");
		panel.add(lblNewLabel_12);

		JLabel lblNewLabel_11 = new JLabel("OPTIONS MENU");
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setFont(new Font("Trajan Pro", Font.PLAIN, 25));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_13 = new JLabel("");
		panel.add(lblNewLabel_13);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.BLACK);
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(4, 2, 0, 0));

		JPanel lblNewLabel = new JPanel();
		lblNewLabel.setBackground(Color.BLACK);
		panel_1.add(lblNewLabel);

		JPanel lblNewLabel_1 = new JPanel();
		lblNewLabel_1.setBackground(Color.BLACK);
		panel_1.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.disableAll();
				frame.enablePanel(frame.getMainMenu());
			}
		});

		JButton btnNewButton_2 = new JButton("Default");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(Color.BLACK);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setControls(controls1);
				frame.disableAll();
				g1.setNumber_dragons(1);
				g1.setSize(1);
				frame.enablePanel(frame.getMainMenu());
			}
		});

		JButton btnNewButton_3 = new JButton("Custom");
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBackground(Color.BLACK);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setControls(controls1);
				frame.disableAll();
				frame.getEditor().setHasChanged(false);
				frame.getEditor().setVisible(true);
			}
		});

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setControls(controls1);
				frame.disableAll();
				g1.setNumber_dragons(numberDrags);
				g1.setSize(size);
				frame.enablePanel(frame.getMainMenu());

			}
		});
		panel_1.add(btnNewButton);
		panel_1.add(btnNewButton_1);

		JPanel lblNewLabel_2 = new JPanel();
		lblNewLabel_2.setBackground(Color.BLACK);
		panel_1.add(lblNewLabel_2);

		JPanel lblNewLabel_3 = new JPanel();
		lblNewLabel_3.setBackground(Color.BLACK);
		panel_1.add(lblNewLabel_3);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBorder(null);
		add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBorder(null);
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setForeground(Color.BLACK);
		panel_8.setBackground(Color.BLACK);
		panel_4.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton_5 = new JButton("Windowed");
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.setBackground(Color.BLACK);
		panel_8.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("Fullscreen");
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setBackground(Color.BLACK);
		panel_8.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame.setExtendedState(Frame.MAXIMIZED_BOTH);  
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
		panel_9.setBackground(Color.BLACK);
		panel_4.add(panel_9);

		JLabel lblNewLabel_5 = new JLabel("Size of Maze");
		lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_5.setForeground(Color.RED);
		panel_9.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);

		final JSpinner spinner = new JSpinner();
		panel_9.add(spinner);
		spinner.setModel(new SpinnerNumberModel(11, 7, 51, 2));

		JLabel lblNewLabel_4 = new JLabel("Number of Dragons");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4.setForeground(Color.RED);
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
		chckbxNewCheckBox.setVerticalAlignment(SwingConstants.TOP);
		chckbxNewCheckBox.setForeground(Color.RED);
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Moving Dragons");
		chckbxNewCheckBox_1.setVerticalAlignment(SwingConstants.TOP);
		chckbxNewCheckBox_1.setForeground(Color.RED);
		chckbxNewCheckBox_1.setBackground(Color.BLACK);
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

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_4.add(panel_2);

		JToggleButton tglbtnNewToggleButton = new JToggleButton("Sound ON/OFF");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameSounds.toggleSound();
			}
		});
		tglbtnNewToggleButton.setForeground(Color.RED);
		tglbtnNewToggleButton.setBackground(Color.BLACK);
		tglbtnNewToggleButton.setSelected(true);
		panel_2.add(tglbtnNewToggleButton);

		final JSlider slider = new JSlider();
		slider.setMaximum(5);
		slider.setMinimum(-50);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				GameSounds.adjustVolume("MainMenu", slider.getValue());
			}
		});
		slider.setForeground(Color.RED);
		slider.setBackground(Color.BLACK);
		panel_2.add(slider);

		JLabel lblNewLabel_14 = new JLabel("CONTROLS");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setForeground(Color.RED);
		panel_4.add(lblNewLabel_14);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 5, 0, 0));

		JLabel lblNewLabel_6 = new JLabel("RIGHT");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBackground(Color.BLACK);
		lblNewLabel_6.setOpaque(true);
		panel_5.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("UP");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBackground(Color.BLACK);
		lblNewLabel_7.setOpaque(true);
		panel_5.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("LEFT");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBackground(Color.BLACK);
		lblNewLabel_8.setOpaque(true);

		panel_5.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("DOWN");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBackground(Color.BLACK);
		lblNewLabel_9.setOpaque(true);

		panel_5.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Eagle");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBackground(Color.BLACK);
		lblNewLabel_10.setOpaque(true);

		panel_5.add(lblNewLabel_10);

		// RIGHT
		textField_1 = new JTextField();
		textField_1.setForeground(Color.RED);
		textField_1.setBackground(Color.BLACK);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				textField_1.setText(KeyEvent.getKeyText(arg0.getKeyCode()));
				controls1.set(0, arg0.getKeyCode());
			}
		});
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		// UP
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setBackground(Color.BLACK);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				textField.setText(KeyEvent.getKeyText(arg0.getKeyCode()));
				controls1.set(1, arg0.getKeyCode());
			}
		});
		panel_5.add(textField);
		textField.setColumns(10);

		// LEFT
		textField_2 = new JTextField();
		textField_2.setForeground(Color.RED);
		textField_2.setBackground(Color.BLACK);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				textField_2.setText(KeyEvent.getKeyText(arg0.getKeyCode()));
				controls1.set(3, arg0.getKeyCode());
			}
		});
		panel_5.add(textField_2);
		textField_2.setColumns(10);

		// DOWN
		textField_3 = new JTextField();
		textField_3.setForeground(Color.RED);
		textField_3.setBackground(Color.BLACK);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				textField_3.setText(KeyEvent.getKeyText(arg0.getKeyCode()));
				controls1.set(2, arg0.getKeyCode());
			}
		});
		panel_5.add(textField_3);
		textField_3.setColumns(10);

		// EAGLE
		textField_4 = new JTextField();
		textField_4.setForeground(Color.RED);
		textField_4.setBackground(Color.BLACK);
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				textField_4.setText(KeyEvent.getKeyText(arg0.getKeyCode()));
				controls1.set(4, arg0.getKeyCode());
			}
		});
		panel_5.add(textField_4);
		textField_4.setColumns(10);
	}

}
