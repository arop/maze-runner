import java.util.Scanner ;

public class LPOOTP1 {

	public static Personagem h = new Heroi(1,1,"H") ; 
	public static Personagem d = new Dragao(7,1,"D") ;
	public static Board b = new Board(15);
	
	public static int swordX = 8 ;
	public static int swordY = 1 ;
	
	public static void main (String[] args) {

		while(true) {
			b.showBoard();
			//b.makePath(15);

			//b.makePath(15);
			System.out.println();
			b.showBoard();

			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();
			myScanner.close();
			
			if(input == "w") h.MoveUp(b);
			else if(input == "a") h.MoveLeft(b);
			else if(input == "d") h.MoveRight(b);
			else if(input == "s") h.MoveDown(b);
						
			double a = Math.round((Math.random()*4));
			if (a == 0) d.MoveUp(b);;
			if (a == 1) d.MoveLeft(b); ;
			if (a == 2) d.MoveRight(b) ;
			if (a == 3) d.MoveDown(b);;

		} 

	}

	private static boolean dragon() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2))
			if(h.getSymb() == "H")
				return true;
			else if(h.getSymb() == "A")
				d.setSymb(" ");
		return false;
	}
		
	


}