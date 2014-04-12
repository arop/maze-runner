package GameLogic;


public abstract class Character extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 756100146373153204L;
	/**
	 * Construtor da classe Character com coordenadas definidas
	 * @param x coordenada x da personagem
	 * @param y coordenada y da personagem
	 */
	public Character(int x, int y) {
		super(x,y);
	}
	/**
	 * Construtor da classe Character com coordenadas aleatorias
	 */
	public Character() {
		super();
	}

	/**
	 * Verifica se a proxima posição é valida
	 * @param board Board em questão
	 * @param x	proxima coordenada x
	 * @param y proxima coordenada y
	 * @return true se é valida, false se nao
	 */
	public abstract boolean nextPosition(Board board, int x, int y); 
	/**
	 * Move a personagem em questão
	 * @param b Board em questão
	 * @param input Movimento a executar
	 */
	public void move(Board b, String input) {}
	/**
	 * Decrementa coordenada X
	 * @param board 
	 */
	public void MoveUp (Board board) {
		if(nextPosition(board,X-1,Y)) X--;}
	/**
	 * Incrementa coordenada X
	 * @param board
	 */
	public void MoveDown(Board board) {
		if(nextPosition(board,X+1,Y)) X++;}
	/**
	 * Decrementa coordenada Y
	 * @param board
	 */
	public void MoveLeft(Board board) {
		if(nextPosition(board,X,Y-1)) Y--;}
	/**
	 * Incrementa coordenada Y
	 * @param board
	 */
	public void MoveRight(Board board) {
		if(nextPosition(board,X,Y+1)) Y++;}
}