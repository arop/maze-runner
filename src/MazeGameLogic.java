
public class MazeGameLogic {
	private static Board b = new Board(11);
	private static Personagem h = new Heroi(b.getMaze());
	private static Personagem d;

	public MazeGameLogic() {
		do {
			d = new Dragao(b.getMaze());
		} while(endGame());

	}

	private static boolean endGame() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2))
			if(h.getSymb() == "H")
				return true;
			else if(h.getSymb() == "A")
				d.setSymb(" ");

		return false;
	}

	public static boolean win() {
		if(b.getSx() == h.getX() && b.getSy() == h.getY())
			return true;
		return false;
	}
}
