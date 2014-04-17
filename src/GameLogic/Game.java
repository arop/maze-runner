package GameLogic;

import java.io.*;
/**
 * Game.java - Esta classe simboliza o jogo, tendo como principais atributos um board, e o estado do proprio jogo, 
 * nomeadamente, a quantidade de dragoes e se estes se podem movimentar/adormecer
 * Esta classe contem a "fun��o principal" do jogo [Play] que determina o que acontece no jogo dependendo da 
 * intera��o do utilizador
 * Sendo assim, o utilizador pode ganhar o jogo (quando, tendo a espada, chegar � sa�da) e perder o jogo (quando, n�o tendo 
 * a espada, se aproxima dum drag�o) 
 * @author Andr� Pires, Filipe Gama
 * @see Board, GameObject
 */
public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3959183976630237955L;
	private Board board;
	private int size ;
	private int number_dragons = 1 ;
	private boolean movingDragons = false; //if true dragons can move
	private boolean sleepingDragons = false; //if true dragons can sleep

	/**
	 * Construtor da classe Game, sendo o board = default
	 */
	public Game() { size = 1; }
	/**
	 * Construtor da classe Game, com um board aleatorio de tamanho sxs
	 * @param s Tamanho do board
	 */
	public Game(int s) {
		size = s ;
	}
	/**
	 * 
	 * @return Board
	 */
	public Board getBoard() {return board;}

	// RETURN VALUES: 0-keeps playing, 1-quit, 2-dead, 3-won
	/**
	 * Funcao que simboliza a acao do jogo
	 * @param input Movimento para o heroi
	 * @param input2 Movimento para o dragao
	 * @return 0- Continua o jogo, 1- Acaba o jogo por opcao do utilizador, 2- Heroi morreu, 3- Heroi venceu
	 */
	public int Play(String input, String input2) {

		//sair do jogo
		if (input.equals("q")) return 1;

		//mover heroi
		board.getH().move(board,input);

		//morrer aguia?
		if(board.getEg().getStatus()) characterDies(board.getEg());


		//mover aguia
		if(board.getEg().getStatus() ) board.getEg().move(board, input);
		else {
			board.getEg().setX(board.getH().getX());
			board.getEg().setY(board.getH().getY());
		}

		if(board.getEg().getX() == board.getS().getX() && board.getEg().getY() == board.getS().getY()) {
			board.getS().disable() ;
			board.getEg().setSymb("V") ;
			board.getEg().setdX(board.getEg().getiX());
			board.getEg().setdY(board.getEg().getiY());
		}

		//verificar se heroi apanhou a espada/aguia
		if(board.getH().getX() == board.getS().getX() && board.getH().getY() == board.getS().getY() || board.getH().getX() == board.getEg().getX() && board.getH().getY() == board.getEg().getY() && board.getEg().getStatus() ) {
			board.getH().setSymb("A") ;
			board.getS().disable() ;
			board.getEg().disable() ;
		}

		//lancar aguia
		if(input.equals("f") && board.getS().getStatus()  && !board.getEg().getStatus()) {
			board.getEg().reenable();

			board.getEg().setiX(board.getH().getX());
			board.getEg().setiY(board.getH().getY());

			board.getEg().setdX(board.getS().getX());
			board.getEg().setdY(board.getS().getY());
		}

		if(movingDragons) {
			// mover dragoes
			for(int i = 0 ; i < board.getDragons().length ; i++) {
				if(sleepingDragons) {
					int x= (int) Math.round(Math.random());
					if(x == 0) board.getDragons()[i].setSleeping();
				}
				if(!board.getDragons()[i].getSleeping()) board.getDragons()[i].move(board,input2);
			}
		}

		else { //if not moving, can fall asleep
			for(int i = 0 ; i < board.getDragons().length ; i++)
				if(sleepingDragons) {
					int x= (int) Math.round(Math.random());
					if(x == 0) board.getDragons()[i].setSleeping();
				}
		}

		//dragon protecting sword
		boolean sProtected = false;
		for(int i = 0 ; i < board.getDragons().length ; i++) {
			if(board.getDragons()[i].getX() == board.getS().getX() && board.getDragons()[i].getY() == board.getS().getY()){
				board.getS().setSymb("F");
				sProtected = true;
				break;
			}
		}

		if(!sProtected) board.getS().setSymb("E");


		// update
		board.UpdateBoard();

		// terminar jogo 
		if(characterDies(board.getH())) {
			board.UpdateBoard();
			return 2;
		}

		if(won()) return 3;

		return 0;
	}
	/**
	 * Simboliza a acao do jogo, com movimento do dragao nao definido pelo utilizador
	 * @param input Movimento do heroi
	 * @return 0- Continua o jogo, 1- Acaba o jogo por opcao do utilizador, 2- Heroi morreu, 3- Heroi venceu
	 */
	public int Play(String input) {
		return Play(input,null);
	}
	/**
	 * Verifica se a personagem morre
	 * @param p Personagem em quest�o
	 * @return true se a personagem morre, false se nao
	 */
	public boolean characterDies(Character p) {
		for(int i = 0 ; i < board.getDragons().length ; i++){
			if(Math.sqrt(Math.pow(p.getY()-board.getDragons()[i].getY(),2) + Math.pow(p.getX()-board.getDragons()[i].getX(),2))<=Math.sqrt(2)) {
				if(p.getSymb().equals("A")) board.getDragons()[i].disable() ;
				else if(board.getDragons()[i].getSymb().equals("D")){
					p.disable();
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Verifica se o jogador ganhou
	 * @return true se ganhou, false se nao
	 */
	public boolean won() {
		if(board.getH().getSymb().equals("A") && 
				board.getH().getX() == board.getSx() 
				&& board.getH().getY() == board.getSy())
			return true;
		return false;
	}

	//Getters and setters
	/**
	 * 
	 * @return numero de dragoes
	 */
	public int getNumber_dragons() {return number_dragons;}
	/**
	 * Modifica o numero de dragoes
	 * @param number_dragons Numero de dragoes
	 */
	public void setNumber_dragons(int number_dragons) {this.number_dragons = number_dragons;}
	/**
	 * 
	 * @return true se os dragoes podem dormir, false se nao
	 */
	public boolean getSleepingDragons() {return sleepingDragons;}
	/**
	 * 
	 * @return true se os dragoes se podem mover, false se nao
	 */
	public boolean getMovingDragons() {return movingDragons; }
	/**
	 * Alterna a possibilidade dos dragoes dormirem
	 */
	public void setSleepingDragons() {sleepingDragons=!sleepingDragons;}
	/**
	 * Alterna a possibilidade dos dragoes se moverem
	 */
	public void setMovingDragons() {movingDragons=!movingDragons;}
	/**
	 * 
	 * @return Tamanho do board
	 */
	public int getSize() {return size;}
	/**
	 * Modifica o board
	 */
	public void setBoard() {
		//System.out.println("ENTROU NO SET BOARD");

		board = new Board(size,number_dragons); 
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * Modifica o tamanho do board
	 * @param size tamanho do board
	 */
	public void setSize(int size) {this.size=size; setBoard();}
}