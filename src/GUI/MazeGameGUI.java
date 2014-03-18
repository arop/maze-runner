package GUI;
import javax.swing.*; 
import java.awt.*;

import GameLogic.Game;

public class MazeGameGUI  {
	
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel lab ;
	
	public MazeGameGUI() {
		frame = new JFrame("Maze Game");
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.blue);
		
		button = new JButton("Test");
		
		lab = new JLabel("This is a test label");
		
		panel.add(button);
		panel.add(lab);
		
		frame.add(panel);
		
	}
	
	
	public static void main(String[] args) {
		new MazeGameGUI();
	}
	
	
	
	
}
