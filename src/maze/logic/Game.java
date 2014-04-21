package maze.logic;

import java.io.*;
/**
 * Game.java - Esta classe simboliza o jogo, tendo como principais atributos um board, e o estado do proprio jogo, 
 * nomeadamente, a quantidade de dragoes e se estes se podem movimentar/adormecer
 * Esta classe contem a "função principal" do jogo [Play] que determina o que acontece no jogo dependendo da 
 * interação do utilizador
 * Sendo assim, o utilizador pode ganhar o jogo (quando, tendo a espada, chegar à saída) e perder o jogo (quando, não tendo 
 * a espada, se aproxima dum dragão) 
 * @author André Pires, Filipe Gama
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

	private boolean dragonsDead = false;

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
	 * @param input2 Movimento para o dragao (util para testes, em que se pode mover o dragão tal como se move o herói
	 * @return 0- Continua o jogo, 1- Acaba o jogo por opcao do utilizador, 2- Heroi morreu, 3- Heroi venceu, 4-Porta abriu
	 * 
	 * NOTA IMPORTANTE: O método play é overloaded. O método com 2 parâmetros serve para caso se deseje mover o dragão
	 * com um determinado input, tal como se move o herói. Utilizámos este método para realizar testes relativos ao dragão,
	 * em vez de criar uma interface como sugerido.
	 * 
	 * O método Play com apenas um parametro chama este, sendo que o input2 é passado como null. 
	 * Na função move do dragão (chamada no Play), caso o input2 seja null, o movimento é gerado aleatoriamente, caso contrário é efectuado o movimento desejado
	 */
	public int Play(String input, String input2) {

		//sair do jogo
		if (input.equals("q")) return 1;

		//mover heroi
		board.getH().move(board,input);

		//morrer aguia?
		if((board.getEg().getX() == board.getEg().getiX() && board.getEg().getY() == board.getEg().getiY()) || (board.getEg().samePos(board.getS()))) {
			if(board.getEg().getStatus()){
				if(characterDies(board.getEg())){
					board.getS().setX(board.getEg().getX());
					board.getS().setY(board.getEg().getY());
					board.getS().reenable();
				};
				
			}
		}

		//mover aguia
		if(board.getEg().getStatus() ) board.getEg().move(board, input);
		else {
			board.getEg().setX(board.getH().getX());
			board.getEg().setY(board.getH().getY());
		}

		if(board.getEg().samePos(board.getS())) {
			board.getS().disable() ;
			board.getEg().setSymb("V") ;
			board.getEg().setdX(board.getEg().getiX());
			board.getEg().setdY(board.getEg().getiY());
		}

		//verificar se heroi apanhou a espada/aguia
		if(board.getH().samePos(board.getS()) || board.getH().samePos(board.getEg()) && board.getEg().getStatus() ) {
			board.getH().setSymb("A");
			board.getS().disable();
			board.getEg().disable();

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
			if(board.getDragons()[i].samePos(board.getS())){
				board.getS().setSymb("F");
				sProtected = true;
				break;
			}
		}

		if(!sProtected) board.getS().setSymb("E");

		// verifica se dragons morreram todos -> heroi pode ganhar
		if(!dragonsDead)
			if(board.dragonsDead() && board.getH().getSymb().equals("A")){
				board.getOriginalMaze()[board.getSx()][board.getSy()] = "S";
				dragonsDead=true;
				board.UpdateBoard();
				return 4;
			}

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
	 * @param p Personagem em questão
	 * @return true se a personagem morre, false se nao
	 * 
	 * NOTA: Para verificar se um dragão se encontra nas vizinhanças de um objecto,
	 * verificamos se a distancia (modulo do vector) é menor que sqrt(2)
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
		if(board.getH().getSymb().equals("A") &&  board.dragonsDead() &&
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
		board = new Board(size,number_dragons); 
		dragonsDead = board.dragonsDead();
	}

	public void setBoard(Board board) {
		this.board = board;
		dragonsDead = this.board.dragonsDead();
	}
	/**
	 * Modifica o tamanho do board, alterando o board de acordo
	 * @param size tamanho do board
	 */
	public void setSize(int size) {this.size=size; setBoard();}
	
	public void setDragonsDead(boolean x) {
		dragonsDead=x;
	}
}