package GameLogic;

import java.io.*;

public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3959183976630237955L;
	private Board board;
	private int size ;
	private int number_dragons = 1 ;
	private boolean movingDragons = false; //if true dragons can move
	private boolean sleepingDragons = false; //if true dragons can sleep

	public Game() { size = 1; }

	public Game(int s) {
		size = s ;
	}

	public Board getBoard() {return board;}

	// RETURN VALUES: 0-keeps playing, 1-quit, 2-dead, 3-won
	public int Play(String input, String input2) {
	
		//sair do jogo
		if (input.equals("q")) return 1;

		//mover heroi
		board.getH().move(board,input);
		
		//morrer aguia?
		if(board.getEg().getStatus()) characterDies(board.getEg());
		
		
		//mover aguia
		if(board.getEg().getStatus() ) board.getEg().move(board, input);
		else {
			board.getEg().setX(board.getH().getX());
			board.getEg().setY(board.getH().getY());
		}

		if(board.getEg().getX() == board.getS().getX() && board.getEg().getY() == board.getS().getY()) {
			board.getS().disable() ;
			board.getEg().setSymb("V") ;
			board.getEg().setdX(board.getEg().getiX());
			board.getEg().setdY(board.getEg().getiY());
		}
		
		//verificar se heroi apanhou a espada/aguia
		if(board.getH().getX() == board.getS().getX() && board.getH().getY() == board.getS().getY() || board.getH().getX() == board.getEg().getX() && board.getH().getY() == board.getEg().getY() && board.getEg().getStatus() ) {
			board.getH().setSymb("A") ;
			board.getS().disable() ;
			board.getEg().disable() ;
		}
	
		//lancar aguia
		if(input.equals("f") && board.getS().getStatus()  && !board.getEg().getStatus()) {
			board.getEg().reenable();

			board.getEg().setiX(board.getH().getX());
			board.getEg().setiY(board.getH().getY());

			board.getEg().setdX(board.getS().getX());
			board.getEg().setdY(board.getS().getY());
		}
		
		if(movingDragons) {
			// mover dragoes
			for(int i = 0 ; i < board.getDragons().length ; i++) {
				if(sleepingDragons) {
					int x= (int) Math.round(Math.random());
					if(x == 0) board.getDragons()[i].setSleeping();
				}
				if(!board.getDragons()[i].getSleeping()) board.getDragons()[i].move(board,input2);
			}
		}
		
		//dragon protecting sword
		boolean sProtected = false;
		for(int i = 0 ; i < board.getDragons().length ; i++) {
			if(board.getDragons()[i].getX() == board.getS().getX() && board.getDragons()[i].getY() == board.getS().getY()){
				board.getS().setSymb("F");
				sProtected = true;
				break;
			}
		}
		
		if(!sProtected) board.getS().setSymb("E");
		
				
		// update
		board.UpdateBoard();

		
		// terminar jogo 
		if(characterDies(board.getH())) {
			board.UpdateBoard();
			return 2;
		}
			
		if(won()) return 3;
		
		return 0;
	}
	
	public int Play(String input) {
		return Play(input,null);
	}

	public boolean characterDies(Character p) {
		for(int i = 0 ; i < board.getDragons().length ; i++){
			if(Math.sqrt(Math.pow(p.getY()-board.getDragons()[i].getY(),2) + Math.pow(p.getX()-board.getDragons()[i].getX(),2))<=Math.sqrt(2)) {
				if(p.getSymb() == "A") board.getDragons()[i].disable() ;
				else if(board.getDragons()[i].getSymb()=="D"){
					p.disable();
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean won() {
		if(board.getH().getSymb() == "A" && 
				board.getH().getX() == board.getSx() 
				&& board.getH().getY() == board.getSy())
			return true;
		return false;
	}

	//Getters and setters
	public int getNumber_dragons() {return number_dragons;}
	public void setNumber_dragons(int number_dragons) {this.number_dragons = number_dragons;}
	public boolean getSleepingDragons() {return sleepingDragons;}
	public boolean getMovingDragons() {return movingDragons; }
	public void setSleepingDragons() {sleepingDragons=!sleepingDragons;}
	public void setMovingDragons() {movingDragons=!movingDragons;}
	public int getSize() {return size;}
	public void setBoard() {board = new Board(size,number_dragons); }
	public void setSize(int size) {this.size=size; setBoard();}
	
	public void saveGame() throws IOException {
		FileOutputStream saveFile = new FileOutputStream("saveFile.sav");
		ObjectOutputStream save = new ObjectOutputStream(saveFile);
		save.writeObject(this);
		save.close();
	}
	
	public void loadGame() throws IOException, ClassNotFoundException {
		FileInputStream saveFile = new FileInputStream("saveFile.sav");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		Game g = new Game();
		g = (Game) restore.readObject();
		
		this.board = g.board;
		this.movingDragons=g.movingDragons;
		this.number_dragons=g.number_dragons;
		this.size=g.size;
		this.sleepingDragons=g.sleepingDragons;
		
		restore.close();
	}
}