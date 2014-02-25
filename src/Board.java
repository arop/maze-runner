
public class Board {
	private static String[][] maze ;
	
	
	public String[][] getMaze() { 
		return maze ;
	}
	
	public Board(int n) {
		maze = new String[n][n] ;
		for( int i = 0 ; i < maze.length ; i++){
			for (int k = 0 ; k < maze[i].length; k++){
				maze[i][k] = "X" ;
			}
					
		}
	}
	
	static void showBoard() {
		for( int i = 0 ; i < maze.length ; i++){
			for (int k = 0 ; k < maze[i].length; k++){
				System.out.print(maze[i][k]);
				System.out.print(" ") ;
			}
			System.out.println() ;
					
		}
	}
	
	

}
	