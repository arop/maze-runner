package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import GameLogic.Game;

public class TestDragons {
	
	@Test
	public void MoveDragon() {
		
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		int posX = jogo.getBoard().getDragons()[0].getX();
		int posY = jogo.getBoard().getDragons()[0].getY();
		
		jogo.getBoard().getDragons()[0].MoveDown(jogo.getBoard());
		
		assertEquals(posX+1,jogo.getBoard().getDragons()[0].getX()); // MOVE PARA ESPAÇO EM BRANCO
		assertEquals(posY,jogo.getBoard().getDragons()[0].getY());
		
		jogo.getBoard().getDragons()[0].MoveRight(jogo.getBoard());  // NAO MOVE CONTRA PAREDE
		assertEquals(posX+1,jogo.getBoard().getDragons()[0].getX());
		assertEquals(posY,jogo.getBoard().getDragons()[0].getY());
	}
	
	
	
	
	

}
