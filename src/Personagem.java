
public abstract class Personagem extends GameObject {
	
	public Personagem(String[][] board) {
		super(board);
	}


	public abstract boolean isHero () ;

	
	public abstract boolean nextPosition(Board board, int x, int y); 
	
	public void move(Board b, String input) {	}
	
	public void MoveUp (Board board) {
		if(nextPosition(board,X-1,Y))	X-- ;	}
	public void MoveDown(Board board) {
		if(nextPosition(board,X+1,Y)) X++ ; 	}
	public void MoveLeft(Board board) {
		if(nextPosition(board,X,Y-1)) Y--; }
	public void MoveRight(Board board) {
		if(nextPosition(board,X,Y+1)) Y++ ; }
}