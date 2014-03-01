
public class Heroi extends Personagem {

	public Heroi(String[][] board) {
		super(board);
		Hsymbol = "H" ;
		
	}

	public boolean isHero (){ return true; }

	public boolean nextPosition(Board board, int x, int y) {
		if(board.getMaze()[x][y] == " " || board.getMaze()[x][y] == "E" || board.getMaze()[x][y] == "S") 
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