package maze.cli;

import java.util.Scanner;

import maze.logic.Game;
/**
 * MazeGameCLI.java - Esta classe tem como função mostrar o jogo na linha de comandos e estabelecer a ligação 
 * entre o jogo e o utilizador através da interface mencionada
 * @author André Pires, Filipe Gama
 * @see Game
 */
public class MazeGameCLI { 

	private Game g1;
	private Scanner scanner_input;


	public static void main (String[] args) {
		new MazeGameCLI();
	}

	MazeGameCLI() {
		mainMenu();
	}

	/**
	 * Representa o menu principal do jogo, tendo a possibilidade de iniciar um novo jogo, de mudar de menu (para o
	 * menu de opções) ou terminar o programa
	 */
	public void mainMenu() {
		System.out.println(">>> MAZE GAME <<<");
		System.out.println();
		System.out.println("1. Play Game");
		System.out.println("2. Options");
		System.out.println("3. Quit");

		scanner_input = new Scanner(System.in);
		String n = scanner_input.nextLine();
		int a = Integer.parseInt(n);
		switch(a) {
		case 1:
			if(g1 == null) {
				System.out.println("Do you want to play with default map? (y/n)") ;
				String opt2 = scanner_input.nextLine();
				if(opt2.equals("y")) g1 = new Game();
				else mainMenu(); }
			break;
		case 2: 
			optionsMenu();
			mainMenu();
			break;
		case 3:
			System.exit(0) ;
		
		default: mainMenu();
		}

		play();

		System.exit(0);
	}
	/**
	 * Representa o jogo em si, fazendo as alterações necessárias consoante a interação com o utilizador
	 */
	private void play() {
		g1.setBoard();
		scanner_input = new Scanner(System.in);
		while(true) {
			System.out.println(g1.getBoard());
			String input = scanner_input.nextLine();
			int a = g1.Play(input);
			System.out.println(g1.getBoard());

			switch(a) {
			case 0: 
				break;
			case 1:
				System.out.println("Are you sure you want to quit? (y/n)");
				String input2 = scanner_input.nextLine();
				if(input2.equals("y")) return;
				break;
			case 2:
				System.out.println("You lost!"); 
				return;
			case 3:
				System.out.println("You won!") ;
				return;
			}
		}
	}
	/**
	 * Representa o menu de opções, sendo elas a alteração do tamanho do labirinto, a quantidade de dragões,
	 * a possibilidade destes se mexerem ou adormecerem
	 * @return 
	 */
	private int optionsMenu() {
		System.out.println("> OPTIONS <");
		System.out.println();
		System.out.println("1. Random maze, choose size");
		System.out.println("2. Multiple dragons");
		System.out.println("3. Moving dragons");
		System.out.println("4. Sleeping dragons");
		System.out.println("5. Back to main menu");

		scanner_input = new Scanner(System.in);
		String b = scanner_input.nextLine();
		int a = Integer.parseInt(b);

		switch(a) {
		case 1:
			boolean validN=false;
			scanner_input = new Scanner(System.in);

			while(!validN) {
				System.out.println("Please insert size of maze (7 or bigger): ");
				String n= scanner_input.nextLine();
				int n1=Integer.parseInt(n);

				if( n1>=5 && n1%2!=0){
					validN= true; 
					System.out.println("Your maze has been generated.");
					System.out.println();
					g1 = new Game(n1);
					break;
				}

				else  System.out.println("Not valid! Insert new one: ");
			}

			optionsMenu();
			break;

		case 2:
			if(g1 == null) {
				System.out.println("You haven't chosen a board size yet!");
			}

			else { 
				System.out.println("Enter the number of dragons desired: ");
				scanner_input = new Scanner(System.in);

				String n= scanner_input.nextLine();
				int n1=Integer.parseInt(n);

				while(n1>(g1.getSize()/7)) {
					System.out.println("Not valid, please enter a number between [1, size/7]: ");
					n= scanner_input.nextLine();
					n1=Integer.parseInt(n);
				}

				g1.setNumber_dragons(n1);
			}

			optionsMenu();
			break;

		case 3:
			if(g1 == null) {
				System.out.println("You haven't chosen a board size yet!");
			}
			else {
				g1.setMovingDragons();
				if(!g1.getMovingDragons())
					System.out.println("Dragons' moving mode is now disabled!\n");
				else
					System.out.println("Dragons' moving mode is now enabled!\n");
			}
			break;

		case 4:
			if(g1 == null) {
				System.out.println("You haven't chosen a board size yet!");
			}
			else {
				g1.setSleepingDragons();
				if(!g1.getSleepingDragons())
					System.out.println("Dragons' sleeping mode is now disabled!\n");
				else
					System.out.println("Dragons' sleeping mode is now enabled!\n");
			}
			break;

		case 5: 	
			return 1;
		}
		return 1;
	}

}

