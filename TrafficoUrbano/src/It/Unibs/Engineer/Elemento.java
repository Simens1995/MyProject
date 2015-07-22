package It.Unibs.Engineer;

public abstract class Elemento {

	private String nome;
	private int velocit�;
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
	
	public Elemento(String nome, int velocit�, int posX, int posY, char ch) {
		this.nome = nome;
		this.velocit� = velocit�;
		this.posX = posX;
		this.posY = posY;
		this.ch= ch;
	}

	public abstract int calcolaSpostamento(int tempo);
	public abstract void spostamento();
	
	public int getVelocit�() {
		return velocit�;
	}

	public void setVelocit�(int velocit�) {
		this.velocit� = velocit�;
	}

	public String getNome() {
		return nome;
	}


		
	
}

