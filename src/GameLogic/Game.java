package GameLogic;
import java.util.Scanner;




public class Game {

	private mazeBuilder b;
	private int size ;
	
	public Game() { size = 1; }
	
	public Game(int s) {
		size = s ;
	}
	

	public void Play() {
		b= new mazeBuilder(size); 

		b.setEg(new Eagle (b.getH().getX(),b.getH().getY())) ;

		do {
			if(b.getH().getX() == b.getS().getX() && b.getH().getY() == b.getS().getY() || b.getH().getX() == b.getEg().getX() && b.getH().getY() == b.getEg().getY() && b.getEg().getStatus() ) {
				b.getH().setSymb("A") ;
				b.getS().disable() ;
				b.getEg().disable() ;
			}

			b.showBoard();

			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();
			if(b.endGame()) {myScanner.close(); return; }

			if(input.equals("f")) {
				b.getEg().reenable ();
				b.getEg().setdX(b.getS().getX()) ;
				b.getEg().setdY(b.getS().getY());
			}

			b.getH().move(b,input);

			if(b.getEg().getStatus() ) b.getEg().move(b, input);
			else {
				b.getEg().setX(b.getH().getX());
				b.getEg().setY(b.getH().getY()) ;
			}

			if(b.getEg().getX() == b.getS().getX() && b.getEg().getY() == b.getS().getY()) {
				b.getS().disable() ;
				b.getEg().setSymb("V") ;
				b.getEg().setdX(b.getEg().getiX());
				b.getEg().setdY(b.getEg().getiY());
			}

			int x= (int) Math.round(Math.random());
			if(x == 0) b.getD().setSleeping();
			if(!b.getD().getSleeping()) b.getD().move(b,input);
		} while(!won());

	}



	public boolean won() {
		if(b.getH().getSymb()=="A" && b.getH().getX()==b.getSx() && b.getH().getY()==b.getSy())
			return true;
		return false;
	}
}