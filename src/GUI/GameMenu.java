package GUI;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameLogic.Game;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameMenu extends JPanel {
		private Game g1;
		private MazeGameGUI frame;
		private JLabel lblMazeGame;

		public GameMenu(Game currentGame,MazeGameGUI window) {
			setBackground(Color.BLACK);
			frame = window;
			g1 = currentGame;
			createWidgets();
			addWidgets(this);
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("GAME PAUSED");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(146, 11, 199, 58);
			add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Resume Game");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					frame.getMazePanel().setVisible(true);
					frame.getMazePanel().requestFocusInWindow();
				}
			});
			btnNewButton.setBounds(161, 80, 141, 30);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Save Game");
			btnNewButton_1.setBounds(161, 119, 141, 30);
			add(btnNewButton_1);
			
			JButton btnReturnToMain = new JButton("Return to main menu");
			btnReturnToMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					frame.getMainMenu().setVisible(true);
			}
			});
			btnReturnToMain.setBounds(161, 160, 141, 30);
			add(btnReturnToMain);
			
			JButton btnExitGame = new JButton("Exit Game");
			btnExitGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnExitGame.setBounds(161, 201, 141, 30);
			add(btnExitGame);
		
		
			
			this.setVisible(true);
		}

		public void createWidgets(){

		}


		public void addWidgets (Container cont) {
		}
}
