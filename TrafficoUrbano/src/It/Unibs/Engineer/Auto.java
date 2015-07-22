package It.Unibs.Engineer;

public class Auto extends Elemento{
	private final static String NOME = "Auto";
	private final static char CH='>';
	
	public Auto(int velocità, int posX, int posY){
		super(NOME, velocità, posX, posY, CH);
	}
	
	
	public int calcolaSpostamento(int tempo){
		return (tempo * getVelocità());
	}
	
	@Override
	public void spostamento() {
		setPosX(getPosX()+ calcolaSpostamento(T));
	}
	
}
