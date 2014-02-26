
public class Heroi extends Personagem {


	public Heroi(String[][] lol) {
		super(lol);
		
	}

	public boolean isHero (){ return true; }
			

	public boolean nextPosition(Board board, int x, int y) {
		if(board.getMaze()[x][y] == " " || board.getMaze()[x][y] == "E" || board.getMaze()[x][y] == "S") 
			return true;
		return false;
	} 
	
	
}