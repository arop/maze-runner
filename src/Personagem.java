public abstract class Personagem {
	protected int X = 1;
	protected int Y = 1 ;
	protected  String Hsymbol = "H" ;

	public Personagem(String[][] lol) {
		int tempx;
		int tempy;
		do {
			 tempx = (int) (3 + (Math.random()*(lol.length-6)));
			 tempy =  (int) (3 + (Math.random()*(lol.length-6)));

		}while(!validPos(tempx,tempy,lol));
	
		X = tempx ;
		Y = tempy ;


	}
	
	public boolean validPos(int x, int y, String[][] labirinto) {
		if(x <= 1 || x == labirinto.length-1 || x == labirinto.length-2 || y <=1 || y == labirinto.length-1 || y == labirinto.length-2) return false ;
		if (labirinto[x][y] == " ") return true;
		return false;
	}
	
	
	public int getX() { return X; } 
	public int getY() { return Y;}
	public void setX(int a) { X= a;} 
	public void setY(int a) { Y= a ;}
	public void setSymb(String a) { Hsymbol = a ;}
	public String getSymb() { return Hsymbol;}

	public abstract boolean isHero () ;

	
	public abstract boolean nextPosition(Board board, int x, int y); 
	
	public abstract void move(Board b);
	
	public void MoveUp (Board board) {
		if(nextPosition(board,X-1,Y))	X-- ;	}
	public void MoveDown(Board board) {
		if(nextPosition(board,X+1,Y)) X++ ; 	}
	public void MoveLeft(Board board) {
		if(nextPosition(board,X,Y-1)) Y--; }
	public void MoveRight(Board board) {
		if(nextPosition(board,X,Y+1)) Y++ ; }
}