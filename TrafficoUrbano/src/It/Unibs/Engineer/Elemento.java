package It.Unibs.Engineer;

public abstract class Elemento {

	private String nome;
	private int velocità;
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
	
	public Elemento(String nome, int velocità, int posX, int posY, char ch) {
		this.nome = nome;
		this.velocità = velocità;
		this.posX = posX;
		this.posY = posY;
		this.ch= ch;
	}

	public abstract int calcolaSpostamento(int tempo);
	public abstract void spostamento();
	
	public int getVelocità() {
		return velocità;
	}

	public void setVelocità(int velocità) {
		this.velocità = velocità;
	}

	public String getNome() {
		return nome;
	}


		
	
}

