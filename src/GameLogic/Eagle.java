package GameLogic;

public class Eagle extends Personagem {
	private int dX = 0 ;
	private int dY = 0 ;
	private int iX = 0 ;
	private int iY = 0 ;

	public Eagle(int x, int y) {
		super(x,y);
		iX = x ;
		iY = y ;
		symbol = "v";
		active = false ;
	}

	public int getdX() { return dX ; }
	public int getdY() { return dY ; }
	public int getiY() { return iY ; }
	public int getiX() { return iX ; }
	public void setdX(int x) { dX = x; }
	public void setdY(int y) { dY = y; }

	public boolean nextPosition(mazeBuilder board, int x, int y) {
		return true ;
	}

	public void move(mazeBuilder b, String input) {
	/*	if (Y < dY) MoveRight(b) ;
		if (Y > dY) MoveLeft(b) ;
		if (X < dX) MoveDown(b) ;
		if (X > dX) MoveUp(b);	*/
		
		float deltax=Math.abs(X-dX);
		float deltay=Math.abs(Y-dY);
		
		float error=deltax-deltay;
		int sx,sy;
		
		if(Y<dY) sy=1;
		else sy=-1;

	
		if(X<dX) sx=1;
		else sx=-1;
			
		if(error*2>-deltay){
			error-=deltay;
			X+=sx;
		}
		
		if(error*2<deltax){
			error+=deltax;
			Y+=sy;
		}
	
	}
}



