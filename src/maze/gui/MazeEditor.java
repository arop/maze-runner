package maze.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;

import java.awt.Panel;
import java.awt.Choice;
import java.awt.GridLayout;

import javax.swing.JCheckBox;

import maze.logic.Board;
import maze.logic.Game;

import java.awt.Color;
import java.awt.Font;
/**
 * MazeEditor.java - Esta classe representa o editor do jogo, isto é, cria a possibilidade do utilizador
 * editar o labirinto do jogo, acrescentando, a seu gosto, os objetos (heroi, dragao, etc)
 * @author André Pires, Filipe Gama
 *
 */
public class MazeEditor extends JPanel implements MouseListener, ItemListener {

	private static final long serialVersionUID = 1L;

	private PaintTools paintObj = new PaintTools();
	private JLabel board_label;
	private Board customBoard;
	private Game g1;
	private MazeGameGUI frame;
	private String[] choose = {" ", "X", "S", "H", "D", "E"};
	private int choice=0;

	public MazeEditor(Game currentGame,MazeGameGUI window)  {
		setBackground(Color.BLACK);
		g1 = currentGame;
		frame = window;
		customBoard = new Board(7,0);

		setLayout(new BorderLayout(0, 0));

		JList<Object> list = new JList<Object>();
		add(list, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		add(panel_1, BorderLayout.SOUTH);

		JButton Play = new JButton("Play");
		Play.setBackground(Color.BLACK);
		Play.setForeground(Color.RED);
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g1.setSize(customBoard.getCurrentState().length+2);
				g1.setBoard(customBoard);
				customBoard.createBoardFromString();
				frame.disableAll();
				frame.setMazePanel(new MazePanel(g1, frame));
				frame.getContentPane().add(frame.getMazePanel());
				frame.getMazePanel().setVisible(true);
				frame.getMazePanel().requestFocusInWindow();	
			}
		});
		panel_1.add(Play);

		JButton Solve = new JButton("Solve");
		Solve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customBoard.resetVisited(customBoard.getCurrentState().length);
				customBoard.createBoardFromString();
				if(customBoard.solveMaze(customBoard.getH().getX(), customBoard.getH().getY())) {
					JOptionPane.showMessageDialog(frame, "Your maze is VALID!");
				}
				else JOptionPane.showMessageDialog(frame, "Your maze isn't solvable!");
								
			}
		});
		Solve.setForeground(Color.RED);
		Solve.setBackground(Color.BLACK);
		panel_1.add(Solve);

		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta;
				resposta = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to main menu?");
				if (resposta == JOptionPane.YES_OPTION) {
					setVisible(false);
					frame.getMainMenu().setVisible(true);
				}
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(Color.BLACK);
		panel_1.add(btnNewButton_2);

		board_label = new JLabel("");
		add(board_label, BorderLayout.CENTER);
		board_label.addMouseListener(this);

		Panel panel = new Panel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblNewLabel = new JLabel("Maze Editor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.BLACK);
		panel.add(lblNewLabel);

		final JSpinner spinner = new JSpinner();
		spinner.setForeground(Color.WHITE);
		spinner.setBackground(Color.DARK_GRAY);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				customBoard = new Board((int) spinner.getValue(),0);
				repaint();
			}
		});
		spinner.setModel(new SpinnerNumberModel(7, 5, 51, 2));
		panel.add(spinner);

		Choice choice = new Choice();
		panel.add(choice);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Sleeping Dragons");
		chckbxNewCheckBox_1.setForeground(Color.RED);
		chckbxNewCheckBox_1.setBackground(Color.BLACK);
		panel.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Moving Dragons");
		chckbxNewCheckBox.setForeground(Color.RED);
		chckbxNewCheckBox.setBackground(Color.BLACK);
		panel.add(chckbxNewCheckBox);
		choice.add("Path");
		choice.add("Dragon");
		choice.add("Wall");
		choice.add("Hero");
		choice.add("Sword");
		choice.add("Exit");
		choice.addItemListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintObj.drawGraphicBoard(g, customBoard.getCurrentState().length, board_label.getWidth(),board_label.getHeight(), customBoard,board_label);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int n= (int) (customBoard.getCurrentState().length*arg0.getPoint().getX()/(board_label.getWidth()));
		int m = (int) (customBoard.getCurrentState().length*arg0.getPoint().getY()/(board_label.getHeight()));

		//System.out.println(m + " " + n);
		//System.out.println(arg0.getPoint().getX() + " " + arg0.getPoint().getY());

		//so pode desenhar parede ou saidas nas bordas
		if(choice==1 || choice==2 || (m!=0 && m!=customBoard.getCurrentState().length-1 && n!=0 && n!=customBoard.getCurrentState().length-1))
			if(arg0.getButton() == MouseEvent.BUTTON1) {
				if(choice < 3) customBoard.getOriginalMaze()[m][n] = choose[choice];
				customBoard.getCurrentState()[m][n] = choose[choice];
			}

		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(((String) arg0.getItem()).equals("Path")) choice = 0;
		else if (((String) arg0.getItem()).equals("Wall")) choice = 1;
		else if(((String) arg0.getItem()).equals("Exit")) choice = 2;
		else if(((String) arg0.getItem()).equals("Hero")) choice = 3;
		else if(((String) arg0.getItem()).equals("Dragon")) choice = 4;
		else if(((String) arg0.getItem()).equals("Sword")) choice = 5;
	}
}