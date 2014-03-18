package GameLogic;


public class Hero extends Character {

	public Hero(int X,int Y) {
		super(X,Y);
		symbol = "H" ;
	}

	public Hero() {
		super();
	}

	public boolean nextPosition(Board board, int x, int y) {
		if(board.getOriginalMaze()[x][y] == " " || board.getCurrentState()[x][y] == "E") 
			return true;
		if(board.getOriginalMaze()[x][y] == " " && board.getCurrentState()[x][y] == "V")
			return true;
		
		if(board.getCurrentState()[x][y] == "S" && symbol.equals("A"))
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