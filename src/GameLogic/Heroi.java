package GameLogic;


public class Heroi extends Personagem {

	public Heroi(String[][] board) {
		super(board);
		symbol = "H" ;
	}

	public Heroi(int X,int Y) {
		super(X,Y);
		symbol = "H" ;
	}

	public boolean nextPosition(mazeBuilder board, int x, int y) {
		if(board.getMaze()[x][y] == " " || board.getMaze()[x][y] == "E") 
			return true;
		if(board.getMaze()[x][y] == "S" && symbol.equals("A"))
			return true;
		return false;
	} 

	public void move(mazeBuilder b, String input) {
		if(input.equals("w")) MoveUp(b);
		else if(input.equals("a")) MoveLeft(b);
		else if(input.equals("d")) MoveRight(b);
		else if(input.equals("s")) MoveDown(b);
	}

}