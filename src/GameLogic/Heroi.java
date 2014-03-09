package GameLogic;


public class Heroi extends Personagem {

/*	public Heroi(String[][] board) {
		super(board);
		symbol = "H" ;
	}
	*/
	
	

	public Heroi(int X,int Y) {
		super(X,Y);
		symbol = "H" ;
	}

	public Heroi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean nextPosition(Board board, int x, int y) {
		if(board.getCurrentState()[x][y] == " " || board.getCurrentState()[x][y] == "E") 
			return true;
		if(board.getCurrentState()[x][y] == "S" && symbol.equals("A"))
			return true;
		if(board.getCurrentState()[x][y] == "V")
			return true;
		return false;
	} 

	public void move(Board b, String input) {
		if(input.equals("w")) MoveUp(b);
		else if(input.equals("a")) MoveLeft(b);
		else if(input.equals("d")) MoveRight(b);
		else if(input.equals("s")) MoveDown(b);
	}

}