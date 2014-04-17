package GUI;


import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.Timer;

import GameLogic.Game;
import GameLogic.SaveGame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
/**
 * MainMenu.java - Esta classe representa o menu principal do jogo, tendo como opçoes: 1-"Start" que inicia
 * um novo jogo, 2-"Load" que da a possibilidade ao utilizador de retomar um jogo previamente guardado sendo 
 * que abre uma nova janela onde o utilizador escolhe o ficheiro, 3-"Options" podendo aqui o utilizador mudar 
 * alguns aspetos do jogo, 4-"Editor" onde se pode criar um labirinto, 5-"Exit" para sair do programa
 * Esta classe servira como um painel inserido na classe principal MazeGameGUI
 * @author André Pires, Filipe Gama
 * @see MazeGameGUI
 */
public class MainMenu extends JLabel implements ActionListener {
	private static final long serialVersionUID = -7979274358212876062L;
	private JLabel panel_6;
	private JFileChooser fc;
	private Game g1;
	private MazeGameGUI frame;
	private SaveGame sg;
	
	private PaintTools paintObj = new PaintTools();

	private Timer animation;
	private int delay = 50, currentFrame = 0;

	public MainMenu(Game currentGame,MazeGameGUI window) {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		fc = new JFileChooser();
		sg = new SaveGame(null,null);

		animation = new Timer(delay,this);
		animation.start();

		setLayout(new BorderLayout(0, 0));

		frame = window;
		g1 = currentGame;

		JLabel panel = new JLabel();
		panel.setBackground(Color.BLACK);
		GridLayout gridlayout = new GridLayout(8,3);
		gridlayout.setVgap(20);
		panel.setLayout(gridlayout);

		JLabel panel_7 = new JLabel();
		panel.add(panel_7);

		panel_6 = new JLabel();
		panel_6.setOpaque(false);
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(1,3));


		JLabel panel_1 = new JLabel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 3));

		JLabel label_9 = new JLabel();
		panel_1.add(label_9);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(g1.getBoard() == null) {
					g1.setBoard();
				}				
				frame.disableAll();
				frame.setMazePanel(new MazePanel(g1, frame));
				frame.getContentPane().add(frame.getMazePanel());
				frame.getMazePanel().setVisible(true);
				frame.getMazePanel().requestFocusInWindow();	
			}
		});
		panel_1.add(btnNewButton);

		JLabel label_10 = new JLabel();
		panel_1.add(label_10);

		add(panel, BorderLayout.CENTER);

		JLabel panel_2 = new JLabel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3));

		JLabel label = new JLabel();
		label.setOpaque(false);
		panel_2.add(label);

		JButton btnLoad = new JButton("Load");
		btnLoad.setForeground(Color.RED);
		btnLoad.setBackground(Color.BLACK);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean x = false;
				try {
					int returnVal = fc.showOpenDialog(MainMenu.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						sg.setFile(file);
						sg.loadGame();
						g1=(Game) sg.getGame();
						x=true;
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(x) {
					frame.disableAll();
					frame.setMazePanel(new MazePanel(g1,frame));
					frame.getContentPane().add(frame.getMazePanel());
					frame.getMazePanel().setVisible(true);
					frame.getMazePanel().requestFocusInWindow();
				}
			}
		});
		panel_2.add(btnLoad);

		JLabel label_1 = new JLabel();
		panel_2.add(label_1);

		JLabel panel_3 = new JLabel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 3));

		JLabel label_2 = new JLabel();
		panel_3.add(label_2);

		JButton button_6 = new JButton("Options");
		button_6.setForeground(Color.RED);
		button_6.setBackground(Color.BLACK);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.disableAll();
				frame.getOptions().setVisible(true);
			}
		});
		panel_3.add(button_6);

		JLabel label_3 = new JLabel();
		panel_3.add(label_3);

		JLabel panel_4 = new JLabel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 3));

		JLabel label_4 = new JLabel();
		panel_4.add(label_4);

		JButton button_7 = new JButton("Editor");
		button_7.setForeground(Color.RED);
		button_7.setBackground(Color.BLACK);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.disableAll();
				frame.getEditor().setVisible(true);
			}
		});
		panel_4.add(button_7);

		JLabel label_5 = new JLabel();
		panel_4.add(label_5);

		JLabel panel_5 = new JLabel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 3));

		JLabel label_6 = new JLabel();
		panel_5.add(label_6);


		JButton button_8 = new JButton("Exit");
		button_8.setForeground(Color.RED);
		button_8.setBackground(Color.BLACK);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		panel_5.add(button_8);

		JLabel label_7 = new JLabel();
		panel_5.add(label_7);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(paintObj.getBackground(),0,0,this.getWidth(),this.getHeight(), 0, 0, paintObj.getBackground().getWidth(),paintObj.getBackground().getHeight(), null);
		if(currentFrame >= paintObj.getTitle().length-1) {
			currentFrame = 0;
		}
		currentFrame++;
		arg0.drawImage(paintObj.getTitle()[currentFrame],this.getWidth()/4,this.getHeight()/12,this.getWidth()-this.getWidth()/4,panel_6.getY()+panel_6.getHeight(), 0, 0, paintObj.getTitle()[currentFrame].getWidth(),paintObj.getTitle()[currentFrame].getHeight(), null);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	public Game getGame() {
		return g1;
	}

	public void setGame(Game g1) {
		this.g1 = g1;
	}
}