import java.util.Scanner ;

public class LPOOTP1 {

	public static Personagem h = new Heroi(1,1,"H") ; 
	public static Personagem d = new Dragao(7,1,"D") ;
//	public static Board b = new Board(10) ;
	public static int SwordX = 8 ;
	public static int SwordY = 1 ;
	
	private static String[][] Board = {
		{"X","X","X","X","X","X","X","X","X","X"},
		{"X"," "," "," "," "," "," "," "," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," "," "," "," "," "," ","X"," ","S"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X","E","X","X"," "," "," "," "," ","X"},
		{"X","X","X","X","X","X","X","X","X","X"},
	}; 

	public static void main (String[] args) {

		while(true) {
			showBoard() ;

			Scanner myScanner = new Scanner(System.in);
			String input = myScanner.nextLine();

			
			if(move(h,input,h.getX(),h.getY())){
				return ;
			}
			
			double a = Math.round((Math.random()*4));
			if (a == 0) input = "d" ;
			if (a == 1) input = "a" ;
			if (a == 2) input = "w" ;
			if (a == 3) input = "s" ;
			move(d,input,d.getX(),d.getY()) ; 

		} 

	}

	 private static boolean nextPosition(int x, int y) {
		if(Board[x][y] == " " || Board[x][y] == "E" || Board[x][y] == "S") 
			return true;
		return false;
	} 
	
	
	private static boolean dragon() {
		if(Math.sqrt(Math.pow(h.getY()-d.getY(),2) + Math.pow(h.getX()-d.getX(),2))<=Math.sqrt(2))
			if(h.getSymb() == "H")
				return true;
			else if(h.getSymb() == "A")
				d.setSymb(" ");
		return false;
	}
		
	
  private static boolean move(Personagem p, String comando, int x, int y) {
		  if(Board[x][y] == "S" || dragon())
		   return true;
			
		if(comando.equals("w"))
			if(nextPosition(x-1,y))
				p.MoveUp();

		if(comando.equals("s"))
			if(nextPosition(x+1,y)) 
				p.MoveDown();

		if(comando.equals("a"))
			if(nextPosition(x,y-1)) 
				p.MoveLeft();

		if(comando.equals("d"))
			if(nextPosition(x,y+1)) 
				p.MoveRight();

		if(Board[x][y]== "E" && p.isHero()) {
			Board[x][y] = " ";
			h.setSymb("A");
		}

		
		return false;
	} 

	
	private static void showBoard() {
		// TODO Auto-generated method stub

		for( int i = 0 ; i < Board.length ; i++){
			for (int k = 0 ; k < Board[i].length; k++){
				if( i == h.getX() && k == h.getY())
					System.out.print(h.getSymb());
				else if( i == d.getX() && k == d.getY())
				{
					if(i == SwordX && k == SwordY)
						System.out.print("F");
					else System.out.print(d.getSymb());
				}

				else System.out.print(Board[i][k]);
			}
			System.out.println() ;
		}
	}
	
	


}