package GameLogic;


public abstract class Personagem extends GameObject {
	
	public Personagem(String[][] board) {
		super(board);
	}
	
	public Personagem(int x, int y) {
		super(x,y);
	}
	
	public abstract boolean nextPosition(mazeBuilder board, int x, int y); 
	
	public void move(mazeBuilder b, String input) {	}
	
	public void MoveUp (mazeBuilder board) {
		if(nextPosition(board,X-1,Y))	X-- ;	}
	public void MoveDown(mazeBuilder board) {
		if(nextPosition(board,X+1,Y)) X++ ; 	}
	public void MoveLeft(mazeBuilder board) {
		if(nextPosition(board,X,Y-1)) Y--; }
	public void MoveRight(mazeBuilder board) {
		if(nextPosition(board,X,Y+1)) Y++ ; }
}