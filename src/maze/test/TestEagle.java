package maze.test;

import static org.junit.Assert.*;
import maze.logic.Game;

import org.junit.Test;
/**
 * TestEagle.java - serve para testar se a classe Eagle (aguia) esta bem implementada e cumpre todas as funcionalidades
 * @author André Pires, Filipe Gama
 * @see Eagle
 */
public class TestEagle {
	/**
	 * Testa se a aguia se encontra a beira do heroi
	 */
	@Test
	public void InitEagle() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();

		int posX = jogo.getBoard().getEg().getX();
		int posY = jogo.getBoard().getEg().getY();

		assertEquals(posX,jogo.getBoard().getH().getX()); // ENCONTRA SE JUNTO DO HEROI
		assertEquals(posY,jogo.getBoard().getH().getY());
	}

	/**
	 * Testa se a aguia é lançada quando comandada
	 */
	@Test
	public void EagleCommanded() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();

		assertFalse(jogo.getBoard().getEg().getStatus());

		jogo.Play("f"); //lanca aguia

		assertTrue(jogo.getBoard().getEg().getStatus());
	}
	/**
	 * Testa se a aguia morre a beira do dragao
	 */
	@Test
	public void EagleEatenByDragon() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();

		jogo.Play("f"); //lanca aguia

		assertTrue(jogo.getBoard().getEg().getStatus());

		for(int i=0; i<2;i++)
			jogo.Play("");

		assertTrue(jogo.getBoard().getEg().getStatus()); //dies
	}
	/**
	 * Testa se a aguia apanha a espada
	 */
	@Test
	public void EagleGetsSword() {
		Game jogo = new Game(); //DEFAULT BOARD
		jogo.setBoard();

		for(int i=0; i<5;i++)
			jogo.Play("d");

		jogo.Play("f");

		for(int i=0; i<6;i++)
			jogo.Play("");

		assertEquals(jogo.getBoard().getEg().getSymb(), "v");

		jogo.Play(""); //eagle gets sword

		assertEquals(jogo.getBoard().getEg().getSymb(), "V");
	}
	/**
	 * Testa se o heroi fica armado quando apanha a aguia
	 */
	@Test 
	public void HeroGetsEagle() {
		Game jogo = new Game(); //DEFAULT BOARD
		jogo.setBoard();

		for(int i=0; i<5;i++)
			jogo.Play("d");

		jogo.Play("f");

		for(int i=0; i<6;i++)
			jogo.Play("");

		assertEquals(jogo.getBoard().getEg().getSymb(), "v");

		jogo.Play(""); //eagle gets sword

		assertEquals(jogo.getBoard().getEg().getSymb(), "V");

		for(int i=0; i<6;i++)
			jogo.Play("");

		assertEquals(jogo.getBoard().getH().getSymb(), "H");

		jogo.Play(""); //hero gets eagle

		assertEquals(jogo.getBoard().getH().getSymb(), "A");
	}
}
