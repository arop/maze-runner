package GameLogic;

import java.util.Stack;


public class mazeBuilder {
	
	private static String[][] maze;
	private static int Sx ;
	private static int Sy ;
	
	public int getSx() {return Sx;}
	public int getSy() {return Sy;}
	public String[][] getMaze() {return maze ;}


	public mazeBuilder(int n) {
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
		int i,j, r1=2;
		boolean a=false;
		
		int r = (int) Math.round((Math.random()*4));
		
		
		while(!a) {
		while(r1==2 || r1==(n-1))
		r1 = (int) (2 + (Math.random()*(n-4)));

		if(r==0){i=n-1; j=r1; if(!maze[i-1][j].equals("X")) a=true;}
		else if(r==1) {i=2; j=r1; if(!maze[i+1][j].equals("X")) a=true;}
		else if(r==2) {i=r1; j=2; if(!maze[i][j+1].equals("X")) a=true;}
		else {i=r1; j=n-1; if(!maze[i][j-1].equals("X")) a=true;}
		
		//maze[i][j]= "S";
		Sx=i;
		Sy=j;
		}
		maze[Sx][Sy]= "S";
	}


	static void makePath(int n) {
		int iX = (int) (3+(Math.random()*(n-5))) ;
		int iY = (int) (3+(Math.random()*(n-5))) ;
		Stack<Integer> x = new Stack<Integer>() ;

		while(true)  {
			boolean flag = true ;
			double a = Math.round((Math.random()*4));
			if (maze[iX+2][iY] == "B" || maze[iX-2][iY] == "B" || maze[iX][iY+2] == "B" || maze[iX][iY-2] == "B") {
				x.push(iX) ;
				x.push(iY);
				if (a == 0) {
					if (maze[iX+2][iY] == "B"){
						maze[iX+1][iY] = " ";
						iX = iX+2 ;
				}}

				else if (a == 1){
					if (maze[iX-2][iY] == "B"){
						maze[iX-1][iY] = " ";
						iX = iX-2 ;
				}}
				
				else if (a == 2) {
					if (maze[iX][iY+2] == "B"){
						maze[iX][iY+1] = " ";
						iY = iY+2 ;
				}}
				
				else if (a == 3) {
					if (maze[iX][iY-2] == "B"){
						maze[iX][iY-1] = " ";
						iY = iY-2 ;
				}}
				
				maze[iX][iY] = " ";
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
	
	
	void showBoard(GameObject h, GameObject d, GameObject s, GameObject eg) {
		for( int i = 0 ; i < maze.length ; i++){
			for (int k = 0 ; k < maze[i].length; k++){
				if(h.getX() == i && h.getY()== k) {
					System.out.print(h.getSymb());
				}
				else if (d.getX() == i && d.getY()== k){
					System.out.print(d.getSymb());
				}
				
				else if (eg.getX() == i && eg.getY()== k){
					System.out.print(eg.getSymb());
				}			
								
				else if (s.getX() == i && s.getY() == k  ) {
					System.out.print(s.getSymb());
				}
				
				else System.out.print(maze[i][k]);
				
				System.out.print(" ") ;				
			}
			System.out.println();

		}
	}

}
