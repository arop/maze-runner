
public class Board {
	private static String[][] Board;
	
	public Board(int n) {
		Board = new String[n][n] ;
		for( int i = 0 ; i < Board.length ; i++){
			for (int k = 0 ; k < Board[i].length; k++){
				Board[i][k] = "X" ;
			}
					
		}
	}
	
	
	static void makePath(int n) {
		int i=1; 
		int j=1;
		
		while(i<n && j<n) {
		int r=(int) Math.random();
		
		if(r==0) i++;
		else if(r==1) j++;
		}
				
	}
	
	static void showBoard() {
		for( int i = 0 ; i < Board.length ; i++){
			for (int k = 0 ; k < Board[i].length; k++){
				System.out.print(Board[i][k]);
				System.out.print(" ") ;
			}
			System.out.println();
					
		}
	}

}
	