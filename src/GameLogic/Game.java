package GameLogic;
import java.util.Scanner;




public class Game {

	public static mazeBuilder b;
	

	public static void main (String[] args) {
		boolean validN=false;

		Scanner size = new Scanner(System.in);

		while(!validN) {
			System.out.println("Please insert size of maze (odd number, over 7) (1 for default maze): ");
			String n= size.nextLine();
			int n1=Integer.parseInt(n);

			if(n1==1 ||( n1>=7 && n1%2!=0)) {
				b= new mazeBuilder(n1); 
				validN= true; 
			}

			else  System.out.println("Not valid! Insert new one: ");
		}

		mazeBuilder.setEg(new Eagle (mazeBuilder.getH().getX(),mazeBuilder.getH().getY())) ;

	

		do {
			if(mazeBuilder.getH().getX() == mazeBuilder.getS().getX() && mazeBuilder.getH().getY() == mazeBuilder.getS().getY() || mazeBuilder.getH().getX() == mazeBuilder.getEg().getX() && mazeBuilder.getH().getY() == mazeBuilder.getEg().getY() && mazeBuilder.getEg().getStatus() ) {
				mazeBuilder.getH().setSymb("A") ;
				mazeBuilder.getS().disable() ;
				mazeBuilder.getEg().disable() ;
			}

			mazeBuilder.showBoard();

			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();
			if(mazeBuilder.endGame()) {myScanner.close(); return; }

			if(input.equals("f")) {
				mazeBuilder.getEg().reenable ();
				mazeBuilder.getEg().setdX(mazeBuilder.getS().getX()) ;
				mazeBuilder.getEg().setdY(mazeBuilder.getS().getY());
			}

			mazeBuilder.getH().move(b,input);

			if(mazeBuilder.getEg().getStatus() ) mazeBuilder.getEg().move(b, input);
			else {
				mazeBuilder.getEg().setX(mazeBuilder.getH().getX());
				mazeBuilder.getEg().setY(mazeBuilder.getH().getY()) ;
			}

			if(mazeBuilder.getEg().getX() == mazeBuilder.getS().getX() && mazeBuilder.getEg().getY() == mazeBuilder.getS().getY()) {
				mazeBuilder.getS().disable() ;
				mazeBuilder.getEg().setSymb("V") ;
				mazeBuilder.getEg().setdX(mazeBuilder.getEg().getiX());
				mazeBuilder.getEg().setdY(mazeBuilder.getEg().getiY());
			}

			int x= (int) Math.round(Math.random());
			if(x == 0) mazeBuilder.getD().setSleeping();
			if(!mazeBuilder.getD().getSleeping()) mazeBuilder.getD().move(b,input);
		} while(!won());

	}



	public static boolean won() {
		if(mazeBuilder.getH().getSymb()=="A" && mazeBuilder.getH().getX()==mazeBuilder.getSx() && mazeBuilder.getH().getY()==mazeBuilder.getSy())
			return true;
		return false;
	}
}