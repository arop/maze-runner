import java.util.Scanner;

public class LPOOTP1 {

	public static Board b = new Board(11);
	public static Personagem h = new Heroi(b.getMaze());
	public static Dragao d ;
	public static Sword s = new Sword(b.getMaze());

	public static void main (String[] args) {
		do {
			d = new Dragao(b.getMaze());
		} while(endGame());

		while(true) {
			if(h.getX() == s.getX() && h.getY() == s.getY()) {
				h.setSymb("A") ;
				s.setSymb(" ") ;
			}
			
			b.showBoard(h,d,s);
			
			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();
				
			
			if(endGame()) return;
			h.move(b,input);
			d.move(b,input);
		} 

	}

	private static boolean endGame() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2)) {
			if(h.getSymb() == "H")
				return true;
			else if(h.getSymb() == "A")
				d.setSymb(" ");
		}
		else if(b.getSx() == h.getX() && b.getSy() == h.getY())
			return true;

		return false;
	}

}