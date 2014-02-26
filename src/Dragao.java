
public class Dragao extends Personagem {

	public Dragao(String[][] lol) {
		super(lol);
		
	}

	public boolean isHero (){ return false; }
	
	public boolean nextPosition(Board board, int x, int y) {
		if(board.getMaze()[x][y] == " " || board.getMaze()[x][y] == "E") 
			return true;
		return false;
	} 


}
