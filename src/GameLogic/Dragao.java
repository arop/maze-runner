package GameLogic;



public class Dragao extends Personagem {

	private static boolean isSleeping;
	
	public boolean getSleeping() {return isSleeping;}
	public void setSleeping() {isSleeping=!isSleeping; if(isSleeping) symbol="d"; else symbol="D";}
	
	public Dragao(String[][] board) {
		super(board);
		symbol = "D" ;
	}

	public boolean nextPosition(mazeBuilder board, int x, int y) {
		if(board.getMaze()[x][y] == " " || board.getMaze()[x][y] == "E") 
			return true;
		return false;
	} 

	public void move(mazeBuilder b, String input) {
		double a = Math.round((Math.random()*4));
		if (a == 0) MoveUp(b);
		else if (a == 1) MoveLeft(b);
		else if (a == 2) MoveRight(b);
		else if (a == 3) MoveDown(b);
	}


}
