package GameLogic;

import java.io.Serializable;
import java.util.Arrays;

public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5843035626760272684L;
	private MazeBuilder builder ;
	private String[][] currentState ;
	private  Hero h;
	private  Dragon[] dragons;
	private  Sword s;
	private  Eagle eg;
	private static int Sx ;
	private static int Sy ;


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
	public void generateObject(GameObject object) {
		int tempx,tempy;

		do {
			System.out.println("PRESO NO WHILE");
			tempx = (int) (1 + (Math.random()*(builder.getField().length-2)));
			tempy =  (int) (1 + (Math.random()*(builder.getField().length-2)));
		}while(!validPos(tempx,tempy));

		object.setX(tempx);
		object.setY(tempy);
	}

	public void drawObject(GameObject object) {
		currentState[object.getX()][object.getY()] = object.getSymb();
	}

	// UPDATE AND SHOW BOARD

	public void UpdateBoard() {
		currentState = copy(builder.getField());
		if(eg.getStatus())
			drawObject(eg);
		drawObject(h);
		if(s.getStatus())
			drawObject(s);

		for (int i = 0; i < dragons.length ; i++) {
			if(dragons[i].getStatus())
				drawObject(dragons[i]);
		}
	}

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

	public boolean validPos(int x, int y) { // CHECKS IF POSITION IS VALID
		if(x <= 1 || x >= builder.getField().length-1 || y <=1 || y >= builder.getField().length-1) return false ;
		if (currentState[x][y].equals(" ")) return true;
		return false;
	}

	public String[][] copy(String[][] input) { // DEEP COPY FUNCTION (double array of strings)
		String[][] target = new String[input.length][];
		for (int i=0; i <input.length; i++) {
			target[i] = Arrays.copyOf(input[i], input[i].length);
		}
		return target;
	}


	//SETTERS AND GETTERS

	public String[][] getCurrentState() {
		return currentState;
	}

	public String[][] getOriginalMaze() {
		return builder.getField();
	}

	public Character getH() {
		return h;
	}
	public void setH(Hero h) {
		this.h = h;
	}

	public Sword getS() {
		return s;
	}
	public void setS(Sword s) {
		this.s = s;
	}
	public Eagle getEg() {
		return eg;
	}
	public void setEg(Eagle eg) {
		this.eg = eg;
	}
	public int getSx() {
		return Sx ;
	}
	public int getSy() {
		return Sy ;
	}
	public Dragon[] getDragons() {
		return dragons;
	}
	public void setDragons(Dragon[] dragons) {
		this.dragons = dragons;
	}
}
