package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import GameLogic.Game;

public class TestHero {

	@Test
	public void MoveHero() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		int posX = jogo.getBoard().getH().getX();
		int posY = jogo.getBoard().getH().getY();
		
		jogo.getBoard().getH().MoveRight(jogo.getBoard());
		
		assertEquals(posX,jogo.getBoard().getH().getX()); // MOVE PARA ESPAÇO EM BRANCO
		assertEquals(posY+1,jogo.getBoard().getH().getY());
		
		jogo.getBoard().getH().MoveUp(jogo.getBoard());  // NAO MOVE CONTRA PAREDE
		assertEquals(posX,jogo.getBoard().getH().getX());
		assertEquals(posY+1,jogo.getBoard().getH().getY());
	}
	
	@Test
	public void HeroGetSword() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();	
		
		String [] moves = {"d","d","d","s","s","s","s","a","a","a","s","s","s"};
		jogo.getBoard().getDragons()[0].disable(); // SEM DRAGAO
		
		for(int i = 0; i < moves.length; i++) {
			jogo.Play(moves[i]);
		}
		
		assertEquals("A", jogo.getBoard().getH().getSymb());
	}
	
	@Test
	public void EatenByDragon() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		
		jogo.Play("s");	// anda para a casa abaixo adjacente ao dragão

		assertFalse(jogo.getBoard().getH().getStatus());
	}
	
	@Test
	public void killDragon() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		jogo.getBoard().getH().setSymb("A");
		String [] moves = {"s","s","s"};
				
		for(int i = 0; i < moves.length; i++) {
			jogo.Play(moves[i]);
		}
		
		assertFalse(jogo.getBoard().getDragons()[0].getStatus());
	}
	
	@Test
	public void Wins() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		jogo.getBoard().getH().setSymb("A");
		int a = 0 ;
		
		String [] moves = {"d","d","d","d","d","d","d","s","s","s","s","d"};
		
		for(int i = 0; i < moves.length; i++) {
			a = jogo.Play(moves[i]);
		}
		
		assertEquals(3,a);
	}
	
	@Test
	public void CantEscape() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		int a = 0 ;
		
		String [] moves = {"d","d","d","d","d","d","d","s","s","s","s","d"};
		
		for(int i = 0; i < moves.length; i++) {
			a = jogo.Play(moves[i]);
		}
		
		assertEquals(0,a);
	}
	

}
