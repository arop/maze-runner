package maze.test;

import static org.junit.Assert.*;
import maze.logic.Game;

import org.junit.Test;
/**
 * TestDragons.java - serve para testar se a classe Dragon (dragao) esta bem implementada e cumpre todas as funcionalidades
 * @author Andr� Pires, Filipe Gama
 * @see Dragon
 */
public class TestDragons {

	/**
	 * Testa se o dragao se move corretamente
	 */
	@Test
	public void MoveDragon() {

		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		int posX = jogo.getBoard().getDragons()[0].getX();
		int posY = jogo.getBoard().getDragons()[0].getY();

		jogo.getBoard().getDragons()[0].MoveDown(jogo.getBoard());

		assertEquals(posX+1,jogo.getBoard().getDragons()[0].getX()); // MOVE PARA ESPA�O EM BRANCO
		assertEquals(posY,jogo.getBoard().getDragons()[0].getY());

		jogo.getBoard().getDragons()[0].MoveRight(jogo.getBoard());  // NAO MOVE CONTRA PAREDE
		assertEquals(posX+1,jogo.getBoard().getDragons()[0].getX());
		assertEquals(posY,jogo.getBoard().getDragons()[0].getY());
	}

	/**
	 * Testa se espada muda de simbolo quando dragao esta em cima da espada
	 */
	@Test
	public void DragonGetsSword() {

		Game jogo = new Game();
		jogo.setMovingDragons();

		jogo.setBoard();

		String DragonMoves = "sssss";

		for(int i = 0 ; i < DragonMoves.length(); i++) {
			jogo.Play("w",Character.toString(DragonMoves.charAt(i)));
		}

		assertEquals("F",jogo.getBoard().getS().getSymb());
	}
}