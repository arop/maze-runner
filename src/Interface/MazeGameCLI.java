package Interface;

import java.util.Scanner;

import GameLogic.Game;

public class MazeGameCLI { 

	public static Game g1;

	public static void main (String[] args) {
		mainMenu() ;
		return;
	}

	public static void mainMenu() {
		System.out.println(">>> MAZE GAME <<<");
		System.out.println() ;
		System.out.println("1. Play Game");
		System.out.println("2. Options");
		System.out.println("3. Quit");

		Scanner option = new Scanner(System.in);
		String n = option.nextLine();
		int a = Integer.parseInt(n);
		switch(a) {
		case 1:
			if(g1 == null) {
				System.out.println("Do you want to play with default map? (y/n)") ;
				String opt2 = option.nextLine();
				if(opt2.equals("y")) g1 = new Game();
				else mainMenu(); }
			break;
		case 2: 
			optionsMenu();
			mainMenu();
			break;
		case 3:
			System.exit(0) ;
		}

		play();
		
		option.close();
		System.exit(0);
	}

	private static void play() {
		g1.setBoard();
		Scanner myScanner = new Scanner(System.in);
		while(true) {
			System.out.println(g1.getBoard());
			String input = myScanner.nextLine();
			int a = g1.Play(input);
			System.out.println(g1.getBoard());

			switch(a) {
			case 0: 
				break;
			case 1:
				System.out.println("Are you sure you want to quit? (y/n)");
				String input2 = myScanner.nextLine();
				if(input2.equals("y")) return;
				break;
			case 2:
				System.out.println("You lost!"); 
				myScanner.close();
				return;
			case 3:
				System.out.println("You won!") ;
				myScanner.close();
				return;
			}
			
		}
		
	}

	private static int optionsMenu() {
		System.out.println("> OPTIONS <");
		System.out.println();
		System.out.println("1. Random maze, choose size");
		System.out.println("2. Multiple dragons");
		System.out.println("3. Moving dragons");
		System.out.println("4. Sleeping dragons");
		System.out.println("5. Back to main menu");

		Scanner option = new Scanner(System.in);
		String b = option.nextLine();
		int a = Integer.parseInt(b);

		switch(a) {
		case 1:
			boolean validN=false;
			Scanner size = new Scanner(System.in);

			while(!validN) {
				System.out.println("Please insert size of maze (5 or bigger): ");
				String n= size.nextLine();
				int n1=Integer.parseInt(n);

				if( n1>=5 && n1%2!=0){
					validN= true; 
					System.out.println("Your maze has been generated.");
					System.out.println();
					g1 = new Game(n1+2);
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
				Scanner noDrag = new Scanner(System.in);

				String n= noDrag.nextLine();
				int n1=Integer.parseInt(n);

				while(n1>(g1.getSize()/7)) {
					System.out.println("Not valid, please enter a number between [1, size/7]: ");
					n= noDrag.nextLine();
					n1=Integer.parseInt(n);
				}

				g1.setNumber_dragons(n1);
			}

			optionsMenu() ;
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