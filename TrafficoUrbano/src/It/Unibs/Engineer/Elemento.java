package It.Unibs.Engineer;

public abstract class Elemento {

	private String nome;
	private int velocitÓ;
	private int posX, posY;
	private char ch;
	public final static int T = 1;
	
	public int getPosX() {
		return posX;
	}

	public char getCh() {
		return ch;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public Elemento(String nome, int velocitÓ, int posX, int posY, char ch) {
		this.nome = nome;
		this.velocitÓ = velocitÓ;
		this.posX = posX;
		this.posY = posY;
		this.ch= ch;
	}

	public abstract int calcolaSpostamento(int tempo);
	public abstract void spostamento();
	
	public int getVelocitÓ() {
		return velocitÓ;
	}

	public void setVelocitÓ(int velocitÓ) {
		this.velocitÓ = velocitÓ;
	}

	public String getNome() {
		return nome;
	}


		
	
}

