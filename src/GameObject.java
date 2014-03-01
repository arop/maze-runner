
public class GameObject {

	protected int X = 1;
	protected int Y = 1 ;
	protected  String symbol ;
	
	public GameObject(String[][] board) {
		int tempx;
		int tempy;
		do {
			 tempx = (int) (3 + (Math.random()*(board.length-6)));
			 tempy =  (int) (3 + (Math.random()*(board.length-6)));

		}while(!validPos(tempx,tempy,board));
	
		X = tempx ;
		Y = tempy ;

	}
	
	public boolean validPos(int x, int y, String[][] labirinto) {
		if(x <= 1 || x >= labirinto.length-2 || y <=1 || y >= labirinto.length-2) return false ;
		if (labirinto[x][y] == " ") return true;
		return false;
	}
	

	
	public int getX() { return X; } 
	public int getY() { return Y;}
	public void setX(int a) { X= a;} 
	public void setY(int a) { Y= a ;}
	public void setSymb(String a) { symbol = a ;}
	public String getSymb() { return symbol;}

}