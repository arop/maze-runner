package GameLogic;

public class GameObject {

	protected int X ;
	protected int Y ;
	protected  String symbol ;
	protected boolean active = true ;

	public GameObject() {
		X = 1 ;
		Y = 1 ;
	}

	public GameObject(int x, int y) { 
		X = x ;
		Y = y ;
	};

	public int getX() { return X; } 
	public int getY() { return Y;}
	public void setX(int a) { X= a;} 
	public void setY(int a) { Y= a ;}
	public void setSymb(String a) { symbol = a ;}
	public String getSymb() { return symbol;}
	public void disable()  { active = false ; }
	public void reenable() { active = true ; }
	public boolean getStatus() { return active ; }
	
}