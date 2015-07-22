package It.Unibs.Engineer;

public class Pedone extends Elemento{
	private final static String NOME = "Uomo";
	private final static char CH='*';
	
	public Pedone(int velocit�, int posX, int posY){
		super(NOME, velocit�, posX, posY, CH);
	}
	
	
	public int calcolaSpostamento(int tempo) {
		return tempo * getVelocit�();
	}


	@Override
	public void spostamento() {
		setPosY(getPosY() + calcolaSpostamento(T));
	}

}
