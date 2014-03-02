package GameLogic;
import java.util.Scanner;

public class Game {


	public static mazeBuilder b = new mazeBuilder(31);
	public static Personagem h = new Heroi(b.getMaze());
	public static Dragao d ;
	public static Sword s = new Sword(b.getMaze());
	public static Eagle eg = new Eagle (h.getX(),h.getY()) ;
	public static boolean EagleReleased = false ;

	public static void main (String[] args) {
		do {
			d = new Dragao(b.getMaze());
		} while(endGame());

		do {
			if(h.getX() == s.getX() && h.getY() == s.getY() || h.getX() == eg.getX() && h.getY() == eg.getY() && EagleReleased ) {
				h.setSymb("A") ;
				s.disable() ;
				eg.disable(); 
			}

			b.showBoard(h,d,s,eg);

			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();
			if(endGame()) {myScanner.close(); return; }
			
			if(input.equals("f")) {
				EagleReleased = true ;
				eg.setdX(s.getX()) ;
				eg.setdY(s.getY());
			}
			
			h.move(b,input);
			
			if(EagleReleased) eg.move(b, input);
			else {
				eg.setX(h.getX());
				eg.setY(h.getY()) ;
			}
			
			if(eg.getX() == s.getX() && eg.getY() == s.getY()) {
				s.disable() ;
				eg.setSymb("V") ;
				eg.setdX(eg.getiX());
				eg.setdY(eg.getiY());
			}
	


			int x= (int) Math.round(Math.random());
			if(x == 0) d.setSleeping();
			if(!d.getSleeping())
				d.move(b,input);
		} while(!won());

	}

	private static boolean endGame() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2) && d.getStatus()) {
			if(h.getSymb() == "H" && d.getSymb()=="D")
				return true;
			else if(h.getSymb() == "A")
				d.disable();
		}
		return false;
	}


	public static boolean won() {
		if(h.getSymb()=="A" && h.getX()==b.getSx() && h.getY()==b.getSy())
			return true;
		return false;
	}

}