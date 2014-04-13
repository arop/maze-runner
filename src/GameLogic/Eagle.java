package GameLogic;
/**
 * Eagle.java - Esta classe representa a aguia do jogo, sendo que esta permanece junto do heroi ate ser 
 * lançada por comando do mesmo, movimentando-se então em direção da espada, voltando, de seguida, para a posição
 * onde foi lançada
 * @author André Pires, Filipe Gama
 * @see Character
 */
public class Eagle extends Character {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3257329955375489783L;
	private int dX = 0 ;
	private int dY = 0 ;
	private int iX = 0 ;
	private int iY = 0 ;
	/**
	 * Construtor da classe Eagle com coordenadas definidas
	 * @param x Coordenada X
	 * @param y Coordenada Y
	 */
	public Eagle(int x, int y) {
		super(x,y);
		iX = x ;
		iY = y ;
		symbol = "v";
		active = false ;
	}

	public int getdX() { return dX;}
	public int getdY() { return dY;}
	public int getiY() { return iY;}
	public int getiX() { return iX;}
	public void setdX(int x) { dX = x;}
	public void setdY(int y) { dY = y;}
	public void setiX(int x) { iX = x;}
	public void setiY(int y) { iY = y;}

	/**
	 * {@inheritDoc}
	 */
	public boolean nextPosition(Board board, int x, int y) {
		return true ;
	}
	/**
	 * Move automaticamente a aguia, desde o heroi ate a espada e vice-versa 
	 */
	public void move(Board b, String input) {

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