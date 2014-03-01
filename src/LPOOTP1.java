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

		do {
			if(h.getX() == s.getX() && h.getY() == s.getY()) {
				h.setSymb("A") ;
				s.setSymb(" ") ;
			}
			
			b.showBoard(h,d,s);
			
			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();
				
			if(endGame()) {myScanner.close(); return; }
			
			h.move(b,input);
		
			int x= (int) Math.round(Math.random());
			if(x==0) d.setSleeping();
			if(!d.getSleeping())
			d.move(b,input);
		} while(!won());

	}

	private static boolean endGame() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2)) {
			if(h.getSymb() == "H" && d.getSymb()=="D")
				return true;
			else if(h.getSymb() == "A")
				d.setSymb(" ");
		}
		return false;
	}

	
	public static boolean won() {
		if(h.getSymb()=="A" && h.getX()==b.getSx() && h.getY()==b.getSy())
		return true;
		return false;
	}

}