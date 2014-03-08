package GameLogic;
import java.util.Scanner;

public class Game {

	private Board board;
	private int size ;
	private int number_dragons = 1 ;
	
	public Game() { size = 1; }
	
	public Game(int s) {
		size = s ;
	}
	
	public void Play() {
		board = new Board(size,number_dragons); 

		do {
			board.UpdateBoard();
			board.showBoard();

			
			if(board.getH().getX() == board.getS().getX() && board.getH().getY() == board.getS().getY() || board.getH().getX() == board.getEg().getX() && board.getH().getY() == board.getEg().getY() && board.getEg().getStatus() ) {
				board.getH().setSymb("A") ;
				board.getS().disable() ;
				board.getEg().disable() ;
			}

			
			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();
			if(endGame()) {myScanner.close(); return; }

			if(input.equals("f")) {
				board.getEg().reenable ();
				board.getEg().setdX(board.getS().getX()) ;
				board.getEg().setdY(board.getS().getY());
			}
			
			else if (input.equals("q")) { return ; }

			board.getH().move(board,input);

			if(board.getEg().getStatus() ) board.getEg().move(board, input);
			else {
				board.getEg().setX(board.getH().getX());
				board.getEg().setY(board.getH().getY()) ;
			}

			if(board.getEg().getX() == board.getS().getX() && board.getEg().getY() == board.getS().getY()) {
				board.getS().disable() ;
				board.getEg().setSymb("V") ;
				board.getEg().setdX(board.getEg().getiX());
				board.getEg().setdY(board.getEg().getiY());
			}

			for(int i = 0 ; i < board.getDragons().length ; i++) {
				int x= (int) Math.round(Math.random());
				if(x == 0) board.getDragons()[i].setSleeping();
				if(!board.getDragons()[i].getSleeping()) board.getDragons()[i].move(board,input);

			}
		} while(!won());

	}
	
	public boolean endGame() {
		for(int i = 0 ; i < board.getDragons().length ; i++){
		if(Math.sqrt(Math.pow(board.getH().getY()-board.getDragons()[i].getY(),2) + Math.pow(board.getH().getX()-board.getDragons()[i].getX(),2))<=Math.sqrt(2)) {
			if(board.getH().getSymb() == "H" && board.getDragons()[i].getSymb()=="D")
				return true;
			else if(board.getH().getSymb() == "A")
				board.getDragons()[i].disable() ;
		}
		}
		return false;
	}


	public boolean won() {
		if(board.getH().getSymb()=="A" && board.getH().getX()==board.getSx() && board.getH().getY()==board.getSy())
			return true;
		return false;
	}

	public int getNumber_dragons() {
		return number_dragons;
	}

	public void setNumber_dragons(int number_dragons) {
		this.number_dragons = number_dragons;
	}
}