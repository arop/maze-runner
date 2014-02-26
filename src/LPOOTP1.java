
public class LPOOTP1 {
	public static Board b = new Board(7);
	public static Personagem h = new Heroi(b.getMaze()) ; 
	public static Personagem d = new Dragao(b.getMaze()); 

	public static void main (String[] args) {

		while(true) {
			b.showBoard(h,d);
			if(endGame()) return;
			h.move(b);
			d.move(b);
		} 

	}

	private static boolean endGame() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2)) {
			if(h.getSymb() == "H")
				return true;
			else if(h.getSymb() == "A")
				d.setSymb(" ");
		}
		else if(h.getSymb()=="S")
			return true;
		return false;
	}




}