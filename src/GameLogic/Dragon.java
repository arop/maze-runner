package GameLogic;

public class Dragon extends Character {

	private static boolean isSleeping;
	
	public boolean getSleeping() {return isSleeping;}
	public void setSleeping() {isSleeping=!isSleeping; if(isSleeping) symbol="d"; else symbol="D";}

	public Dragon(int X,int Y) {
		super(X,Y);
		symbol = "D" ;
	}

	public Dragon() {
		super();
	}
	
	public boolean nextPosition(Board board, int x, int y) {
		if(board.getCurrentState()[x][y] == " " || board.getCurrentState()[x][y] == "E") 
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


}
