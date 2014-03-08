package Interface;

import java.util.Scanner;

import GameLogic.Game;

public class MazeGameCLI { 

	public static Game g1;

	public static void main (String[] args) {
		mainMenu() ;

	}

	public static void mainMenu() {
		System.out.println(">>> MAZE GAME <<<");
		System.out.println() ;
		System.out.println("1. Play Game");
		System.out.println("2. Options") ;
		System.out.println("3. Quit") ;

		Scanner option = new Scanner(System.in);
		String n = option.nextLine();
		int a = Integer.parseInt(n);
		switch(a) {
		case 1:
			if(g1 == null) {
			System.out.println("Do you want to play with default map? (y for yes)") ;
			Scanner option2 = new Scanner(System.in);
			String opt2 = option.nextLine();
			if(opt2.equals("y")) g1 = new Game() ;
			else mainMenu(); }
			break;
		case 2: 
			optionsMenu() ;
			mainMenu() ;
			break;
		case 3:
			return ;
		}

		g1.Play();

	}

	private static int optionsMenu() {
		System.out.println("> OPTIONS <");
		System.out.println() ;
		System.out.println("1. Random maze, choose size");
		System.out.println("2. Multiple dragons") ;
		System.out.println("3. Sleeping dragons") ;
		System.out.println("4. Back to main menu") ;

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
			System.out.println("You must have a maximum ");

		case 4: 
			return 1;

		}
		return 1 ;





	}}