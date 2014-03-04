package GameLogic;

import java.util.Stack;

public class mazeBuilder {

	private static String[][] maze;
	private static Personagem h;
	private static Dragao d;
	private static Sword s;
	private static Eagle eg;
	private static int Sx ;
	private static int Sy ;


	public static int getSx() {return Sx;}
	public static int getSy() {return Sy;}
	
	public static String[][] getMaze() {return maze ;}

	public static String[][] defaultMaze=	
		{{"X","X","X","X","X","X","X","X","X","X"},
		{"X"," "," "," "," "," "," "," "," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," "," "," "," "," "," ","X"," ","S"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," "," "," "," "," ","X"},
		{"X","X","X","X","X","X","X","X","X","X"}};



	public mazeBuilder(int n) {
		if(n>1) {
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


			//"contrutor" do S(saida)
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

				Sx=i;
				Sy=j;
			}
			
			maze[Sx][Sy]= "S";
			
			h= new Heroi(maze);
			s= new Sword(maze);
			
			do {
				d = new Dragao(maze);
			} while(endGame());
			
		}

		else if(n==1) {
			maze=defaultMaze; 
			Sx=5;
			Sy=9;
			h= new Heroi(1,1);
			s= new Sword(8,1);
			d = new Dragao(3,1);
		}
	}


	public static Personagem getH() {
		return h;
	}
	public static void setH(Personagem h) {
		mazeBuilder.h = h;
	}
	public static Dragao getD() {
		return d;
	}
	public static void setD(Dragao d) {
		mazeBuilder.d = d;
	}
	public static Sword getS() {
		return s;
	}
	public static void setS(Sword s) {
		mazeBuilder.s = s;
	}
	public static Eagle getEg() {
		return eg;
	}
	public static void setEg(Eagle eg) {
		mazeBuilder.eg = eg;
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
	
	public static boolean endGame() {
		if(Math.sqrt(Math.pow(mazeBuilder.getH().getY()-mazeBuilder.getD().getY(),2) + Math.pow(mazeBuilder.getH().getX()-mazeBuilder.getD().getX(),2))<=Math.sqrt(2)) {
			if(mazeBuilder.getH().getSymb() == "H" && mazeBuilder.getD().getSymb()=="D")
				return true;
			else if(mazeBuilder.getH().getSymb() == "A")
				mazeBuilder.getD().disable() ;
		}
		return false;
	}


	public static void showBoard() {
		for( int i = 0 ; i < maze.length ; i++){
			for (int k = 0 ; k < maze[i].length; k++){
				if(h.getX() == i && h.getY()== k && h.getStatus()) {
					System.out.print(h.getSymb());
				}
				else if (d.getX() == i && d.getY()== k && d.getStatus()){
					System.out.print(d.getSymb());
				}

				else if (eg.getX() == i && eg.getY()== k && eg.getStatus()){
					System.out.print(eg.getSymb());
				}			

				else if (s.getX() == i && s.getY() == k && s.getStatus() ) {
					System.out.print(s.getSymb());
				}

				else System.out.print(maze[i][k]);

				System.out.print(" ") ;				
			}
			System.out.println();

		}
	}

}
