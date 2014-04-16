package Tests;

import static org.junit.Assert.*;

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
	}
	
	@Test
	public void EagleCommanded() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		
		assertFalse(jogo.getBoard().getEg().getStatus());
		
		jogo.Play("f"); //lanca aguia
		
		assertTrue(jogo.getBoard().getEg().getStatus());
	}
	
	@Test
	public void EagleEatenByDragon() {
		Game jogo = new Game(); // DEFAULT BOARD
		jogo.setBoard();
		
		jogo.Play("f"); //lanca aguia
		
		assertTrue(jogo.getBoard().getEg().getStatus());
		
		for(int i=0; i<2;i++)
			jogo.Play("");
		
		assertFalse(jogo.getBoard().getEg().getStatus()); //dies
	}
	
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
