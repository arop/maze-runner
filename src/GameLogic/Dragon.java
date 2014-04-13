package GameLogic;
/**
 * Dragon.java - Esta classe representa um dragão individual, podendo este movimentar-se e adormecer
 * Tem tambem a possibilidade de matar o Heroi do jogo
 * @author André Pires, Filipe Gama
 * @see Character
 */
public class Dragon extends Character {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8940307252439695340L;
	private static boolean isSleeping;
	/**
	 * 
	 * @return true se esta a dormir, false se nao
	 */
	public boolean getSleeping() {return isSleeping;}
	/**
	 * Modifica o estado do dragão, isto é se está a dormir ou não
	 */
	public void setSleeping() {isSleeping=!isSleeping; if(isSleeping) symbol="d"; else symbol="D";}

	/**
	 * Construtor da classe Dragon com coordenadas definidas
	 * @param X Coordenada X
	 * @param Y Coordenada Y
	 */
	public Dragon(int X,int Y) {
		super(X,Y);
		symbol = "D" ;
	}
	/**
	 * Construtor da classe Dragon com coordenadas aleatorias
	 */
	public Dragon() {
		super();
	}
	/**
	 * {@inheritDoc}
	 */
	public boolean nextPosition(Board board, int x, int y) {
		if(board.getCurrentState()[x][y].equals(" ") || board.getCurrentState()[x][y].equals("E")) 
			return true;
		return false;
	} 
	/**
	 * {@inheritDoc}
	 */
	public void move(Board b, String input) {
		if(input == null) {
			double a = Math.round((Math.random()*4));
			if (a == 0) MoveUp(b);
			else if (a == 1) MoveLeft(b);
			else if (a == 2) MoveRight(b);
			else if (a == 3) MoveDown(b);
		}

		else {
			if(input.equals("w")) MoveUp(b);
			else if(input.equals("a")) MoveLeft(b);
			else if(input.equals("d")) MoveRight(b);
			else if(input.equals("s")) MoveDown(b);
		}

	}
}
