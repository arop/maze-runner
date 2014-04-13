package GameLogic;
/**
 * Hero.java - Esta classe pretende representar o heroi do jogo, sendo esta a personagem principal do jogo
 * controlada pelo utilizador
 * @author André Pires, Filipe Gama
 * @see Character
 */
public class Hero extends Character {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5627871862645940010L;
	/**
	 * Construtor da classe Hero, cria um heroi com coordenadas definidas
	 * @param X Coordenada x
	 * @param Y Coordenada y
	 */
	public Hero(int X,int Y) {
		super(X,Y);
		symbol = "H" ;
	}
	/**
	 * Construtor da classe Hero, cria um heroi com coordenadas aleatorias
	 */
	public Hero() {
		super();
	}
	/**
	 * {@inheritDoc}
	 */
	public boolean nextPosition(Board board, int x, int y) {
		if(board.getOriginalMaze()[x][y].equals(" ") || board.getCurrentState()[x][y].equals( "E")) 
			return true;
		if(board.getOriginalMaze()[x][y].equals(" ") && board.getCurrentState()[x][y].equals("V"))
			return true;

		if(board.getCurrentState()[x][y].equals("S") && symbol.equals("A"))
			return true;

		return false;
	} 
	/**
	 * {@inheritDoc}
	 */
	public void move(Board b, String input) {
		if(input.equals("w")) MoveUp(b);
		else if(input.equals("a")) MoveLeft(b);
		else if(input.equals("d")) MoveRight(b);
		else if(input.equals("s")) MoveDown(b);
	}
}