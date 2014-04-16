package GUI;

import javax.swing.JPanel;

import GameLogic.Board;
import GameLogic.Game;

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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;

import java.awt.Panel;
import java.awt.Choice;
import java.awt.GridLayout;

import javax.swing.JCheckBox;

public class MazeEditor extends JPanel implements MouseListener, ItemListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PaintTools paintObj = new PaintTools();
	private JLabel Board_label;
	private Board customBoard;
	private Game g1;
	private MazeGameGUI frame;
	private String[] choose = {" ", "X", "H", "D", "E"};
	private int choice=0;
	
	public MazeEditor(Game currentGame,MazeGameGUI window)  {
		g1 = currentGame;
		frame = window;
		customBoard = new Board(7,0);

		
		setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		add(list, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton Play = new JButton("Play");
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customBoard.createBoardFromString();
				g1.setSize(customBoard.getCurrentState().length+2);
				g1.setBoard(customBoard);
				frame.disableAll();
				frame.setMazePanel(new MazePanel(g1, frame));
				frame.getContentPane().add(frame.getMazePanel());
				frame.getMazePanel().setVisible(true);
				frame.getMazePanel().requestFocusInWindow();	
			}
		});
		panel_1.add(Play);
		
		JButton Save = new JButton("Save");
		panel_1.add(Save);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		panel_1.add(btnNewButton_2);
		
		Board_label = new JLabel("");
		add(Board_label, BorderLayout.CENTER);
		Board_label.addMouseListener(this);
		
		Panel panel = new Panel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Maze Editor");
		panel.add(lblNewLabel);
		
		final JSpinner spinner = new JSpinner();
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
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Moving Dragons");
		panel.add(chckbxNewCheckBox);
		choice.add("Dragon");
		choice.add("Wall");
		choice.add("Path");
		choice.add("Hero");
		choice.add("Sword");
		choice.addItemListener(this);

		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		paintObj.drawGraphicBoard(g, customBoard.getCurrentState().length, Board_label.getWidth(),Board_label.getHeight(), customBoard,Board_label);
		

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int n= (int) (customBoard.getCurrentState().length*arg0.getPoint().getX()/(Board_label.getWidth()));
		int m = (int) (customBoard.getCurrentState().length*arg0.getPoint().getY()/(Board_label.getHeight()));
		
		System.out.println(m + " " + n);
		System.out.println(arg0.getPoint().getX() + " " + arg0.getPoint().getY());
		
		if(arg0.getButton() == MouseEvent.BUTTON1) {
			if(choice < 2) customBoard.getOriginalMaze()[m][n] = choose[choice];
			
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
		// TODO Auto-generated method stub
		if(((String) arg0.getItem()).equals("Path")) choice = 0;
		else if (((String) arg0.getItem()).equals("Wall")) choice = 1;
		else if(((String) arg0.getItem()).equals("Dragon")) choice = 3;
		else if(((String) arg0.getItem()).equals("Hero")) choice = 2;
		else if(((String) arg0.getItem()).equals("Sword")) choice = 4;
		
	}
	
	
	

}