package GUI;
import javax.swing.*; 

import java.awt.*;
import java.awt.FlowLayout;

import GameLogic.Game;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


public class MazeGameGUI  {
	
	public static Game g1 = new Game();


	
	private JFrame frame;
	private JButton btnPlayGame;
	private JButton Quit;
	private JButton btnOptions;
	
	public MazeGameGUI() {
		g1.setBoard();

		frame = new JFrame("Maze Game");
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPlayGame = new JButton("Play Game");
		frame.getContentPane().add(btnPlayGame);
		
		btnOptions = new JButton("Options");
		frame.getContentPane().add(btnOptions);
		
		Quit = new JButton("Quit");
		frame.getContentPane().add(Quit);
		
		String b = g1.getBoard().toString();
		
	}
	
	
	public static void main(String[] args) {
		new MazeGameGUI();
	}
	
	
	
	
}
