package GameLogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Board.java - Esta classe simboliza o board do jogo, isto é, o labirinto com todos os objetos do jogo;
 * sendo eles o heroi, os dragoes, a espada e a aguia
 * @author André Pires, Filipe Gama
 *
 */
public class Board implements Serializable {
	private static final long serialVersionUID = -5843035626760272684L;
	private MazeBuilder builder ;
	private String[][] currentState;
	private  Hero h;
	private  Dragon[] dragons;
	private  Sword s;
	private  Eagle eg;
	private static int Sx;
	private static int Sy;

	/** Construtor da classe Board;
	 * 
	 * @param n tamanho do labirinto
	 * @param nDragons número de dragões
	 */
	public Board(int n, int nDragons) {
		builder = new MazeBuilder(n);
		dragons = new Dragon[nDragons] ;	
		currentState = copy(builder.getField()); 

		if(n>1) {
			h = new Hero(0,0) ;
			generateObject(h);
			drawObject(h);

			for(int i = 0; i < dragons.length; i++) {
				dragons[i] = new Dragon(0,0);
				generateObject(dragons[i]);
				drawObject(dragons[i]);
			}

			s = new Sword(0,0) ;
			generateObject(s);
			drawObject(s);
		}

		else if(n==1) {
			h= new Hero(1,1);
			drawObject(h);
			s= new Sword(8,1);
			drawObject(s);
			dragons[0] = new Dragon(3,1);
			drawObject(dragons[0]);
		}

		Sx = builder.getSx();
		Sy = builder.getSy() ;
		eg = new Eagle (h.getX(),h.getY());
	}

	//SET POSITIONS FOR OBJECTS AND ADD THEM
	/**
	 * Gera os objetos do jogo numa posição válida
	 * @param object objeto a ser gerado
	 */
	public void generateObject(GameObject object) {
		int tempx,tempy;

		do {
			tempx = (int) (1 + (Math.random()*(builder.getField().length-2)));
			tempy =  (int) (1 + (Math.random()*(builder.getField().length-2)));
		}while(!validPos(tempx,tempy));

		object.setX(tempx);
		object.setY(tempy);
	}

	/**
	 * Desenha o objeto no Board
	 * @param object Objeto a ser desenhado
	 */
	public void drawObject(GameObject object) {
		currentState[object.getX()][object.getY()] = object.getSymb();
	}

	// UPDATE AND SHOW BOARD
	/**
	 * Atualiza do board e desenha-o 
	 */
	public void UpdateBoard() {
		currentState = copy(builder.getField());
		if(eg.getStatus())
			drawObject(eg);
		drawObject(h);

		for (int i = 0; i < dragons.length ; i++) {
			if(dragons[i].getStatus())
				drawObject(dragons[i]);
		}
		if(s.getStatus())
			drawObject(s);
	}

	/**
	 * Cria uma String com o formato pretendido para o display do Board
	 */
	public String toString() { 
		String s="";
		for (String[] line : currentState) {
			for (String cell : line)
				s+=cell + " ";
			s+="\n";
		}
		return s;
	}

	// TOOLS 
	/**
	 * Verifica se a posição é válida
	 * @param x	Coordenada x
	 * @param y	Coordenada y
	 * @return	true se for válido, false se inválido
	 */
	public boolean validPos(int x, int y) { // CHECKS IF POSITION IS VALID
		if(x <= 1 || x >= builder.getField().length-1 || y <=1 || y >= builder.getField().length-1) return false ;
		if (currentState[x][y].equals(" ")) return true;
		return false;
	}
	/**
	 * Faz uma cópia do array do Board (deep copy) 
	 * @param input board em questão
	 * @return retorna a cópia
	 */
	public String[][] copy(String[][] input) { // DEEP COPY FUNCTION (double array of strings)
		String[][] target = new String[input.length][];
		for (int i=0; i <input.length; i++) {
			target[i] = Arrays.copyOf(input[i], input[i].length);
		}
		return target;
	}


	//SETTERS AND GETTERS
	/**
	 * 
	 * @return Board no estado correto no momento em que é invocada a função
	 */
	public String[][] getCurrentState() {
		return currentState;
	}
	/**
	 * 
	 * @return Labirinto sem os objetos
	 */
	public String[][] getOriginalMaze() {
		return builder.getField();
	}
	/**
	 * 
	 * @return Heroi
	 */
	public Character getH() {
		return h;
	}
	/**
	 * Muda o heroi
	 * @param h Heroi
	 */
	public void setH(Hero h) {
		this.h = h;
	}
	/**
	 * 
	 * @return Espada
	 */
	public Sword getS() {
		return s;
	}
	/**
	 * Muda a espada
	 * @param s Espada
	 */
	public void setS(Sword s) {
		this.s = s;
	}
	/**
	 * 
	 * @return Aguia
	 */
	public Eagle getEg() {
		return eg;
	}
	/**
	 * Muda a aguia
	 * @param eg Aguia
	 */
	public void setEg(Eagle eg) {
		this.eg = eg;
	}
	/**
	 * 
	 * @return coordenada x da Saida
	 */
	public int getSx() {
		return Sx ;
	}
	/**
	 * 
	 * @return coordenada y da saida
	 */
	public int getSy() {
		return Sy ;
	}
	/**
	 * 
	 * @return array dos dragões
	 */
	public Dragon[] getDragons() {
		return dragons;
	}
	/**
	 * Muda o array de dragões
	 * @param dragons array de dragões
	 */
	public void setDragons(Dragon[] dragons) {
		this.dragons = dragons;
	}

	/**
	 * Esta funcao cria um novo board, com todas as suas componentes, atraves duma string[][] (o currentState)
	 */
	public void createBoardFromString() {
		ArrayList<Dragon> dragons = new ArrayList<Dragon>();

		for(int i=0; i<currentState.length;i++)
			for(int j=0; j<currentState.length;j++){
				if(currentState[i][j].equals("H"))
					setH(new Hero(i,j));
				else if(currentState[i][j].equals("E"))
					setS(new Sword(i,j));
				else if(currentState[i][j].equals("D"))
					dragons.add(new Dragon(i,j));
				else if(currentState[i][j].equals("S")) {
					Sx=j;
					Sy=i;
				}
			}

		setDragons(dragons.toArray(new Dragon[dragons.size()]));
	}
}
