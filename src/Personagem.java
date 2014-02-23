public abstract class Personagem {
	private int X = 1;
	private int Y = 1 ;
	private String Hsymbol = "H" ;

	public Personagem(int a, int b, String c) { X = a ; Y= b; Hsymbol = c; }
	public int getX() { return X; } 
	public int getY() { return Y;}
	public String getSymb() { return Hsymbol;}
	public void setX(int a) { X= a;} 
	public void setY(int a) { Y= a ;}
	public void setSymb(String a) { Hsymbol = a ;}
	public abstract boolean isHero () ;
	public void MoveUp () { X-- ; }
	public void MoveDown() {X++ ; }
	public void MoveLeft() {Y--; }
	public void MoveRight() {Y++ ; }
}