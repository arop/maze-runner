package GameLogic;
import java.util.Scanner;

public class Game {

	public static mazeBuilder b;
	public static Personagem h;
	public static Dragao d;
	public static Sword s;
	public static Eagle eg;
	public static boolean EagleReleased = false;

	public static void main (String[] args) {
		boolean validN=false;

		Scanner size = new Scanner(System.in);

		while(!validN) {
			System.out.println("Please insert size of maze (odd number, over 7) (1 for default maze): ");
			String n= size.nextLine();
			int n1=Integer.parseInt(n);

			if(n1==1) {
				b= new mazeBuilder(n1); 
				validN= true; 
				h= new Heroi(1,1);
				s= new Sword(8,1);
			}

			else if(n1>=7 && n1%2!=0) {
				b=new mazeBuilder(n1); 
				validN=true; 
				h= new Heroi(b.getMaze());
				s= new Sword(b.getMaze());
			}
			else  System.out.println("Not valid! Insert new one: ");
		}

		eg = new Eagle (h.getX(),h.getY());

		do {
			d = new Dragao(b.getMaze());
		} while(endGame());

		do {
			if(h.getX() == s.getX() && h.getY() == s.getY() || h.getX() == eg.getX() && h.getY() == eg.getY() && EagleReleased ) {
				h.setSymb("A") ;
				s.disable() ;
				eg.disable() ;
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
			if(!d.getSleeping()) d.move(b,input);
		} while(!won());

	}

	private static boolean endGame() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2) && d.getStatus()) {
			if(h.getSymb() == "H" && d.getSymb()=="D")
				return true;
			else if(h.getSymb() == "A")
				d.disable() ;
		}
		return false;
	}


	public static boolean won() {
		if(h.getSymb()=="A" && h.getX()==b.getSx() && h.getY()==b.getSy())
			return true;
		return false;
	}
}