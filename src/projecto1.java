import java.util.Scanner ;


public class projecto1 {
	
	
	private static String[][] Board = {
		{"X","X","X","X","X","X","X","X","X","X"},
		{"X","H"," "," "," "," "," "," "," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," "," "," "," "," "," ","X"," ","S"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X"," ","X","X"," ","X"," ","X"," ","X"},
		{"X","E","X","X"," "," "," "," "," ","X"},
		{"X","X","X","X","X","X","X","X","X","X"},
	};
	
	
	/*
	private static int h.getX() = 1;
	private static int h.getX() = 1 ;
 */
	
	@SuppressWarnings("null")
	public static void main (String[] args) {
		Heroi h = new Heroi(1,1,"H") ; 	
		while(true) {
				showBoard() ; 
				
				Scanner myScanner = new Scanner(System.in);
				String input = myScanner.nextLine();
				
				if(input.equals("w")){
					if (Board[h.getX()-1][h.getY()] == " "){
						Board[h.getX()][h.getY()] = " " ;
						h.setX(h.getX()-1) ;
						Board[h.getX()][h.getY()] = "H" ;
					}
					else if (Board[h.getX()-1][h.getY()] == "S") break ;
				}
				
				else if(input.equals("s")){
					if (Board[h.getX()+1][h.getY()] == " "){
						Board[h.getX()][h.getY()] = " " ;
						h.setX(h.getX()+1);
						Board[h.getX()][h.getY()] = "H" ;
					}
				
					else if (Board[h.getX()+1][h.getY()] == "S") break ;
				}
				
				else if(input.equals("d")){
					if (Board[h.getX()][h.getY()+1] == " "){
						Board[h.getX()][h.getY()] = " " ;
						h.setY(h.getY()+1) ;
						Board[h.getX()][h.getY()] = "H" ;
					}
					else if (Board[h.getX()][h.getY()+1] == "S") break ;
				}
				
				else if(input.equals("a")){
					if (Board[h.getX()][h.getY()-1] == " "){
						Board[h.getX()][h.getY()] = " " ;
						h.setY(h.getY()-1);
						Board[h.getX()][h.getY()] = "H" ;
					}
					else if (Board[h.getX()][h.getY()-1] == "S") break ;
				}
				
				else System.out.println("ERRO");
				
		}
	}

	private static void showBoard() {
		// TODO Auto-generated method stub
		for (String[] line: Board){
			for (String elem: line){
				System.out.print(elem);
			}
			System.out.println();
		}
	}

}
