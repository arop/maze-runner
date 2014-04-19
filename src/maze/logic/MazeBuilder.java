package maze.logic;

import java.io.Serializable;
import java.util.Stack;
/**
 * MazeBuilder.java - Esta classe tem como objetivo a construção de um labirinto com um determinado tamanho
 * podendo ser utilizado o labirinto pre-definido 
 * @author André Pires, Filipe Gama
 */
public class MazeBuilder implements Serializable, Builder {
	private static final long serialVersionUID = -8487919861009006442L;
	private int Sx ;
	private int Sy ;

	private String[][] finalField=	
		{{"X","X","X","X","X","X","X","X","X","X"},
			{"X"," "," "," "," "," "," "," "," ","X"},
			{"X"," ","X","X"," ","X"," ","X"," ","X"},
			{"X"," ","X","X"," ","X"," ","X"," ","X"},
			{"X"," ","X","X"," ","X"," ","X"," ","X"},
			{"X"," "," "," "," "," "," ","X"," ","s"},
			{"X"," ","X","X"," ","X"," ","X"," ","X"},
			{"X"," ","X","X"," ","X"," ","X"," ","X"},
			{"X"," ","X","X"," "," "," "," "," ","X"},
			{"X","X","X","X","X","X","X","X","X","X"}};


	private String[][] field;

	/**
	 * Cria um tabuleiro da seguinte forma: 
	 * - Matriz de (size+4)x(size+4)
	 * - Dois rebordos a toda a volta com objectivo de reduzir o numero de if clauses na função MakePath 
	 * - preenche todas as celulas pares com "B" (significa "não visitado") -> evitar a criação de um array auxiliar de bools
	 * - preenche as restantes com parede, e os rebordos com espaço em branco que será posteriomente removido (removeBorders()
	 * 
	 * @param n Tamanho do labirinto
	 */
	public MazeBuilder(int n) {
		if(n>=5) {
			n+=2;
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
			removeBorders(n);
		}
		makeExit(n);
	}
	/**
	 * 
	 * @return Labirinto
	 */
	public String[][] getField() {
		return finalField;
	}

	/**
	 * Geração de um labirinto aleatorio (algoritmo Recursive backtracker)
	 * 
	 *- Escolhe a posição inicial 
	 *- Enquanto houver celulas não visitadas (marcadas com "B"), escolhe uma de 4 direcções 
	 *- Caso na direcção sorteada o vizinho não tenha sido visitado , então remove-se a parede entre a posição actual e a do vizinho
	 *- Actualiza-se a posição do vizinho como posição atual e repete-se o processo
	 *- Quando chegar a um beco sem saída, isto é não ha celulas vizinhas com "B", vai para o else if, que vê por sua vez se a stack não está vazia.
	 *- Nao estando vazia faz pop e começa novamente daí
	 *- Se estiver vazia pega numa posição aleatoria não visitada e começa a partir daí
	 *- Tendo todas as celulas sido visitadas (Não haver "B" no tabuleiro), é ativada uma flag e termina a funçao makePath
	 *
	 * 
	 * @param n Tamanho do labirinto
	 */
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

	/**
	 * Cria a saida do labirinto num local aleatorio  
	 * @param n Tamanho do labirinto
	 */
	public void makeExit(int n) {
		//"contrutor" do S(saida)
		if(n>=5) {
			n-=2;
			int i,j, r1=0;
			boolean a=false;
			int r;

			while(!a) {
				r = (int) Math.round((Math.random()*4));
				while(r1 == 0 || r1 == (n-1)) 
					r1 = (int) (Math.random()*(n-1));

				if(r==0){i=n-1; j=r1; if(!finalField[i-1][j].equals("X")) a=true;}
				else if(r==1) {i=0; j=r1; if(!finalField[i+1][j].equals("X")) a=true;}
				else if(r==2) {i=r1; j=0; if(!finalField[i][j+1].equals("X")) a=true;}
				else {i=r1; j=n-1; if(!finalField[i][j-1].equals("X")) a=true;}

				Sx=i;
				Sy=j;		
			}
		}

		else if(n==1) {
			Sx = 5;
			Sy = 9; 
		}

		finalField[Sx][Sy]= "s";
	}
	/**
	 * Remove as bordas do labirinto (criadas na funcao MakePath)
	 * @param n Tamanho do labirinto
	 */
	public void removeBorders(int n) {
		finalField = new String[n-2][n-2];
		for(int i = 2, j = 0; i < n; i++, j++){
			for(int k = 2, l = 0; k < n; k++,l++) {
				finalField[j][l] = field[i][k];
			}
		}
	}

	/**
	 * 
	 * @return coordenada x da saida
	 */
	public int getSx() {
		return Sx;
	}
	/**
	 * Modifica a coordenada x da saida 
	 * @param sx
	 */
	public void setSx(int sx) {
		Sx = sx;
	}
	/**
	 * 
	 * @return coordenada y da saida
	 */
	public int getSy() {
		return Sy;
	}
	/**
	 * Modifica a coordenada y da saida
	 * @param sy coordenada y da saida
	 */
	public void setSy(int sy) {
		Sy = sy;
	}
}
