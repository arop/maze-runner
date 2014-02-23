
public class Board {
	private static String[][] Board ;
	
	public Board(int n) {
		Board = new String[n][n] ;
		for( int i = 0 ; i < Board.length ; i++){
			for (int k = 0 ; k < Board[i].length; k++){
				Board[i][k] = "X" ;
			}
					
		}
	}
	
	static void showBoard() {
		for( int i = 0 ; i < Board.length ; i++){
			for (int k = 0 ; k < Board[i].length; k++){
				System.out.print(Board[i][k]);
				System.out.print(" ") ;
			}
			System.out.println() ;
					
		}
	}
	
	

}
	