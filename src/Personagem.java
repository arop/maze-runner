public abstract class Personagem {
	protected int X = 1;
	protected int Y = 1 ;
	protected  String Hsymbol = "H" ;

	public Personagem(int a, int b, String c) { X = a ; Y= b; Hsymbol = c; }
	public int getX() { return X; } 
	public int getY() { return Y;}
	public void setX(int a) { X= a;} 
	public void setY(int a) { Y= a ;}
	public void setSymb(String a) { Hsymbol = a ;}
	public String getSymb() { return Hsymbol;}

	public abstract boolean isHero () ;
	public abstract boolean nextPosition(Board board, int x, int y); 
	
	public void MoveUp (Board board) {
		if(nextPosition(board,X-1,Y))	X-- ;	}
	public void MoveDown(Board board) {
		if(nextPosition(board,X+1,Y)) X++ ; 	}
	public void MoveLeft(Board board) {
		if(nextPosition(board,X+1,Y)) Y--; }
	public void MoveRight(Board board) {
		if(nextPosition(board,X+1,Y)) Y++ ; }
}