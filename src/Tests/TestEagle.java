package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import GameLogic.Game;

public class TestEagle {
	//TODO
	@Test
	public void InitEagle() {

		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		
		int posX = jogo.getBoard().getEg().getX();
		int posY = jogo.getBoard().getEg().getY();

		assertEquals(posX,jogo.getBoard().getH().getX()); // ENCONTRA SE JUNTO DO HEROI
		assertEquals(posY,jogo.getBoard().getH().getY());

		jogo.getBoard().getH().MoveRight(jogo.getBoard());
		
		posX = jogo.getBoard().getEg().getX();
		posY = jogo.getBoard().getEg().getY();

		assertEquals(posX,jogo.getBoard().getH().getX()); // ENCONTRA SE JUNTO DO HEROI
		assertEquals(posY,jogo.getBoard().getH().getY());
	}
}
