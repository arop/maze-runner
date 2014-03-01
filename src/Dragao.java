

public class Dragao extends Personagem {

	public Dragao(String[][] board) {
		super(board);
		Hsymbol = "D" ;


	}

	public boolean nextPosition(Board board, int x, int y) {
		if(board.getMaze()[x][y] == " " || board.getMaze()[x][y] == "E") 
			return true;
		return false;
	} 

	public void move(Board b, String input) {
		double a = Math.round((Math.random()*4));
		if (a == 0) MoveUp(b);
		else if (a == 1) MoveLeft(b);
		else if (a == 2) MoveRight(b);
		else if (a == 3) MoveDown(b);
	}

	@Override
	public boolean isHero() {
		// TODO Auto-generated method stub
		return false;
	}

}
