package It.Unibs.Engineer;

public class Auto extends Elemento{
	private final static String NOME = "Auto";
	private final static char CH='>';
	
	public Auto(int velocitÓ, int posX, int posY){
		super(NOME, velocitÓ, posX, posY, CH);
	}
	
	
	public int calcolaSpostamento(int tempo){
		return (tempo * getVelocitÓ());
	}
	
	@Override
	public void spostamento() {
		setPosX(getPosX()+ calcolaSpostamento(T));
	}
	
}
