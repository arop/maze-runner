package GameLogic;

public class Sword extends GameObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6936583830730831124L;
	/**
	 * Construtor da classe Sword, cria uma espada nas coordenadas especificadas
	 * @param X coordenada x
	 * @param Y coordenada y
	 */
	public Sword(int X, int Y) {
		super(X,Y);
		setSymb("E");
	}
	/**
	 * Construtor da classe Sword, cria uma espada com coordenadas aleatorias
	 */
	public Sword() {
		super();
	}
}

