package It.Unibs.Engineer;

public class Auto extends Elemento{
	private final static String NOME = "Auto";
	private final static char CH='>';
	
	public Auto(int velocit�, int posX, int posY){
		super(NOME, velocit�, posX, posY, CH);
	}
	
	
	public int calcolaSpostamento(int tempo){
		return (tempo * getVelocit�());
	}
	
	@Override
	public void spostamento() {
		setPosX(getPosX()+ calcolaSpostamento(T));
	}
	
}
