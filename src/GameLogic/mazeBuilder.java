package GameLogic;

import java.util.Stack;

public class MazeBuilder {
	
	private int Sx ;
	private int Sy ;
	
	private String[][] finalField=	
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
	
	
	private String[][] field;
	
	
	MazeBuilder(int n) {
		if(n>5) {
			field = new String[n+2][n+2] ;
			for( int i = 0 ; i < field.length ; i++){
				for (int k = 0 ; k < field[i].length; k++){
					if((i % 2 != 0) && (k % 2 != 0))
						field[i][k] = "B" ;

					else field[i][k] = "X" ;

					if(i == 0 || i==1 || k==1 || k ==0 || i==n+1|| i == n || k==n+1||  k==n ){
						field[i][k] = " ";
					}
				}
			}
			makePath(n);
			makeExit(n);
			removeBorders(n);

		}
		
		makeExit(n);
	}

	public String[][] getField() {
		return finalField;
	}


	public void makePath(int n) {
		int iX = (int) (3+(Math.random()*(n-5))) ;
		int iY = (int) (3+(Math.random()*(n-5))) ;
		Stack<Integer> x = new Stack<Integer>() ;

		while(true)  {
			boolean flag = true ;
			double a = Math.round((Math.random()*4));
			if (field[iX+2][iY] == "B" || field[iX-2][iY] == "B" || field[iX][iY+2] == "B" || field[iX][iY-2] == "B") {
				x.push(iX) ;
				x.push(iY);
				if (a == 0) {
					if (field[iX+2][iY] == "B"){
						field[iX+1][iY] = " ";
						iX = iX+2 ;
					}}

				else if (a == 1){
					if (field[iX-2][iY] == "B"){
						field[iX-1][iY] = " ";
						iX = iX-2 ;
					}}

				else if (a == 2) {
					if (field[iX][iY+2] == "B"){
						field[iX][iY+1] = " ";
						iY = iY+2 ;
					}}

				else if (a == 3) {
					if (field[iX][iY-2] == "B"){
						field[iX][iY-1] = " ";
						iY = iY-2 ;
					}}

				field[iX][iY] = " ";
			}

			else if (!x.empty()) {
				iY = x.pop() ;
				iX = x.pop() ;
			}

			else {
				for( int i = 0 ; i < field.length ; i++){
					for (int k = 0 ; k < field[i].length; k++){
						if(field[i][k] == "B") {
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
	

	void makeExit(int n) {
		//"contrutor" do S(saida)
		if(n>=5) {
			int i,j, r1=2;
			boolean a=false;
			int r = (int) Math.round((Math.random()*4));

			while(!a) {
				while(r1==2 || r1==(n-1))
					r1 = (int) (2 + (Math.random()*(n-4)));

				if(r==0){i=n-1; j=r1; if(!field[i-1][j].equals("X")) a=true;}
				else if(r==1) {i=2; j=r1; if(!field[i+1][j].equals("X")) a=true;}
				else if(r==2) {i=r1; j=2; if(!field[i][j+1].equals("X")) a=true;}
				else {i=r1; j=n-1; if(!field[i][j-1].equals("X")) a=true;}
				
				Sx=i;
				Sy=j;
				
				field[Sx][Sy]= "S";
			}
		}
		
		else if(n==1) {
			Sx = 5;
			Sy = 9;
			finalField[Sx][Sy]= "S";
		}

		
	}
	
	public void removeBorders(int n) {
		finalField = new String[n-2][n-2];
		for(int i = 2, j = 0; i < n; i++, j++){
			for(int k = 2, l = 0; k < n; k++,l++) {
				finalField[j][l] = field[i][k];
			}
		}
	}
	

	public int getSx() {
		return Sx;
	}

	public void setSx(int sx) {
		Sx = sx;
	}

	public int getSy() {
		return Sy;
	}

	public void setSy(int sy) {
		Sy = sy;
	}

}
