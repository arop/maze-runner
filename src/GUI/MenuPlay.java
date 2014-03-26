//package GUI;
//
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//
//import javax.swing.JTextArea;
//import javax.swing.JPanel;
//import javax.swing.border.TitledBorder;
//
//public class MenuPlay extends JPanel {
//	
//	private JButton back_button;
//	private JButton quit_button;
//	private String b=g1.getBoard().toString();//.replace("\n", "<br/>"); //not working
//	private final JTextArea textArea = new JTextArea(b, g1.getSize(), g1.getSize());
//	private JPanel panel;
//	
//	
//	public MenuPlay() {
//		frame = new JFrame("Menu Play");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(new GridLayout(3,3));
//		
//		panel = new JPanel();
//		panel.setBorder(new TitledBorder(null, "Maze", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		frame.getContentPane().add(panel);
//		panel.add(textArea);
//		textArea.setEditable(false);
//		textArea.setVisible(true);
//		
//		createWidgets();
//		addWidgets(frame.getContentPane());
//		
//		
//		frame.setPreferredSize(new Dimension(WIDTH,HEIGHT)); //change values
//		
//		frame.pack();
//		
//		frame.setVisible(true);
//	}
//	
//	@Override
//	public void createWidgets() {
//		back_button = new JButton("Back");
//		quit_button = new JButton("Quit");
//
//		quit_button.addActionListener(new MenuPlayListener());
//		back_button.addActionListener(new MenuPlayListener());
//	}
//
//	@Override
//	public void addWidgets(Container cont) {
//		cont.add(back_button);
//		cont.add(quit_button);
//	}
//
//	
//	public class MenuPlayListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			if(arg0.getSource()==quit_button) {
//				frame.setVisible(false);
//				System.exit(0);
//			}
//			if(arg0.getSource()==back_button) {
//				frame.setVisible(false);
//				new MainMenu();
//			}
//		}
//
//	}
//
//}
