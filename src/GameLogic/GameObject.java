package GameLogic;

import java.io.Serializable;

public class GameObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9003288141673197317L;
	protected int X ;
	protected int Y ;
	protected  String symbol ;
	protected boolean active = true ;
	/**
	 * Construtor da classe GameObject
	 * Cria um objeto na posicao [1,1]
	 */
	public GameObject() {
		X = 1 ;
		Y = 1 ;
	}
	/**
	 * Construtor da classe GameObject
	 * Cria um objeto na posicao [x,y]
	 * @param x coordenada X
	 * @param y coordenada Y
	 */
	public GameObject(int x, int y) { 
		X = x ;
		Y = y ;
	};
	/**
	 * 
	 * @return Coordenada X
	 */
	public int getX() { return X; }
	/**
	 * 
	 * @return Coordenada Y
	 */
	public int getY() { return Y;}
	/**
	 * Modifica a coordenada X
	 * @param a Coordenada X
	 */
	public void setX(int a) { X= a;}
	/**
	 * Modifica a coordenada Y
	 * @param a Coordenada Y
	 */
	public void setY(int a) { Y= a ;}
	/**
	 * Modifica o simbolo do objeto
	 * @param a Novo simbolo
	 */
	public void setSymb(String a) { symbol = a ;}
	/**
	 * 
	 * @return simbolo do objeto
	 */
	public String getSymb() { return symbol;}
	/**
	 * Torna o objeto inativo  
	 */
	public void disable()  { active = false ; }
	/**
	 * Torna o objeto ativo
	 */
	public void reenable() { active = true ; }
	/**
	 * 
	 * @return true se o objeto esta ativo, false se nao
	 */
	public boolean getStatus() { return active ; }
}