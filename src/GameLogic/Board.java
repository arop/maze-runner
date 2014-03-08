package GameLogic;

import java.util.Arrays;

public class Board {
	
	private MazeBuilder builder ;
	private String[][] currentState ;
	private String[][] OriginalMaze;
	private  Heroi h;
	private  Dragao d;
	private  Sword s;
	private  Eagle eg;
	private static int Sx ;
	private static int Sy ;

	
	public Board(int n) {
		builder = new MazeBuilder(n);
				
		if(n>1) {
			h = new Heroi(0,0) ;
			addObjectToBoard(h);
			d = new Dragao(0,0) ;
			addObjectToBoard(d);
			s = new Sword(0,0) ;
			addObjectToBoard(s);
		}
			
		else if(n==1) {
			h= new Heroi(1,1);
			s= new Sword(8,1);
			d = new Dragao(3,1);
		}
		
		Sx = MazeBuilder.getSx();
		Sy = MazeBuilder.getSy() ;
		eg = new Eagle (h.getX(),h.getY());

	}
	
	//SET POSITIONS FOR OBJECTS
	public void addObjectToBoard(GameObject object) {
		int tempx;
		int tempy;
		do {
			tempx = (int) (3 + (Math.random()*(builder.getField().length-6)));
			tempy =  (int) (3 + (Math.random()*(builder.getField().length-6)));

		}while(!validPos(tempx,tempy));
		
		object.setX(tempx);
		object.setY(tempy);
		
	}
	
	public boolean validPos(int x, int y) {
		if(x <= 1 || x >= builder.getField().length-2 || y <=1 || y >= builder.getField().length-2) return false ;
		if (OriginalMaze[x][y] == " ") return true;
		return false;
	}
	
	public String[][] copy(String[][] input) { // DEEP COPY FUNCTION (double array of strings)
	      String[][] target = new String[input.length][];
	      for (int i=0; i <input.length; i++) {
	        target[i] = Arrays.copyOf(input[i], input[i].length);
	      }
	      return target;
	}

	
	// DRAW IN BOARD AND SHOW BOARD 
	
	public void showBoard() { 
		currentState = copy(builder.getField()); 
		currentState[eg.getX()][eg.getY()] = eg.getSymb() ;
		currentState[h.getX()][h.getY()] = h.getSymb() ;
		currentState[d.getX()][d.getY()] = d.getSymb() ;
		currentState[s.getX()][s.getY()] = s.getSymb() ;
		
		
		for (String[] line : currentState) {
			for (String cell : line)
				System.out.print(cell + " ");
			System.out.println();
		}

	}
	
	//SETTERS AND GETTERS
	
	public String[][] getCurrentState() {
		return currentState;
	}

	public String[][] getOriginalMaze() {
		return builder.getField();
	}

	public Personagem getH() {
		return h;
	}
	public void setH(Heroi h) {
		this.h = h;
	}
	public Dragao getD() {
		return d;
	}
	public void setD(Dragao d) {
		this.d = d;
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



	

	
//	public boolean endGame() {
//		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2)) {
//			if(h.getSymb() == "H" && d.getSymb()=="D")
//				return true;
//			else if(h.getSymb() == "A")
//				d.disable() ;
//		}
//		return false;
//	}


//	public void showBoard() {
//		for( int i = 0 ; i < OriginalMaze.length ; i++){
//			for (int k = 0 ; k < OriginalMaze[i].length; k++){
//				if(h.getX() == i && h.getY()== k && h.getStatus()) {
//					System.out.print(h.getSymb());
//				}
//				else if (d.getX() == i && d.getY()== k && d.getStatus()){
//					System.out.print(d.getSymb());
//				}
//
//				else if (eg.getX() == i && eg.getY()== k && eg.getStatus()){
//					System.out.print(eg.getSymb());
//				}			
//
//				else if (s.getX() == i && s.getY() == k && s.getStatus() ) {
//					System.out.print(s.getSymb());
//				}
//
//				else System.out.print(OriginalMaze[i][k]);
//
//				System.out.print(" ") ;				
//			}
//			System.out.println();
//
//		}
//	}

}
