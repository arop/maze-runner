import java.util.Stack;


public class Board {
	private static String[][] maze;
	public static int Sx ;
	public static int Sy ;


	public String[][] getMaze() { 
		return maze ;
	}


	public Board(int n) {
		maze = new String[n+2][n+2] ;
		for( int i = 0 ; i < maze.length ; i++){
			for (int k = 0 ; k < maze[i].length; k++){
				if((i % 2 != 0) && (k % 2 != 0))
					maze[i][k] = "B" ;

				else maze[i][k] = "X" ;

				if(i == 0 || i==1 || k==1 || k ==0 || i==n+1|| i == n || k==n+1||  k==n ){
					maze[i][k] = " ";
				}


			}
		}
		
		makePath(n);
		
		//mudar S para nao ficar numa parede
		int i,j;
		int r1=2;

		int r = (int) Math.round((Math.random()*4));
		
		
		while(r1==2 || r1==(n-1))
		r1 = (int) (2 + (Math.random()*(n-4)));

		if(r==0){i=n-1; j=r1; }
		else if(r==1) {i=2; j=r1;}
		else if(r==2) {i=r1; j=2;}
		else {i=r1; j=n-1;} 

		maze[i][j]= "S";
		Sx=i;
		Sy=j;

	}


	static void makePath(int n) {
		int iX = (int) (3+(Math.random()*(n-5))) ;
		int iY = (int) (3+(Math.random()*(n-5))) ;
		int visited = 1 ;
		int totalcells = Math.round(n/2) ; 
		Stack<Integer> x = new Stack() ;

		while(true)  {
			boolean flag = true ;
			double a = Math.round((Math.random()*4));
			if (maze[iX+2][iY] == "B" || maze[iX-2][iY] == "B" || maze[iX][iY+2] == "B" || maze[iX][iY-2] == "B") {

				if (a == 0) {
					if (maze[iX+2][iY] == "B"){
						x.push(iX) ;
						x.push(iY);
						maze[iX+1][iY] = " ";
						iX = iX+2 ;
						maze[iX][iY] = " ";
						visited ++;
					}

				}
				else if (a == 1){
					if (maze[iX-2][iY] == "B"){
						x.push(iX) ;
						x.push(iY);
						maze[iX-1][iY] = " ";
						iX = iX-2 ;
						maze[iX][iY] = " ";
						visited ++;
					}

				}
				else if (a == 2) {
					if (maze[iX][iY+2] == "B"){
						x.push(iX) ;
						x.push(iY);
						maze[iX][iY+1] = " ";
						iY = iY+2 ;
						maze[iX][iY] = " ";
						visited ++;
					}

				}
				else if (a == 3) {
					if (maze[iX][iY-2] == "B"){
						x.push(iX) ;
						x.push(iY);
						maze[iX][iY-1] = " ";
						iY = iY-2 ;
						maze[iX][iY] = " ";
						visited ++;
					}
				}
			}
			else if (!x.empty()) {
				iY = x.pop() ;
				iX = x.pop() ;
			}

			else {
				for( int i = 0 ; i < maze.length ; i++){
					for (int k = 0 ; k < maze[i].length; k++){
						if(maze[i][k] == "B") {
							iX = i ;
							iY = k ;
							flag = false ;
						}

					}
				}

				if(flag) {break; }
			}
		}
	}

	static void showBoard() {
		for( int i = 0 ; i < maze.length ; i++){
			for (int k = 0 ; k < maze[i].length; k++){
				System.out.print(maze[i][k]);
				System.out.print(" ") ;
			}
			System.out.println();

		}
	}

}
