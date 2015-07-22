package It.Unibs.Engineer;
import MyClass.MyVarie;

/**
 * Classe per la gestione grafica della strada
 * @author Fapanni Tiziano, Lorenzoni Andrea & Simaz Andrea
 *
 */
public class StradaGrafica {
	
	private char[][] strada;
	private final static String CORNICE= "------------------------------------------------------------------------\n";
	public static final int R = 4, C = 16;
	private Strada sullaStrada;
	
	/**
	 * COSTRUTTORE StradaGrafica
	 */
	public StradaGrafica(){
		sullaStrada = new Strada(C, R);
		strada = new char[R][C];
		for(int y = 0; y < R; y++){
			for(int x = 0; x < C; x++)
				strada[y][x]=' ';
		}
	}
	
	/**
	 * Crea una strada nuova con pedoni e auto (gestione pedoni e auto)
	 * @param pedoni
	 * @param auto
	 */
	public StradaGrafica(int pedoni, int auto){
		sullaStrada = new Strada(pedoni, auto, C, R);
		strada = new char[R][C];
		for(int y = 0; y < R; y++){
			for(int x=0; x < C; x++)
				strada[y][x] = ' ';
		}
	}
		
	
	/**
	 * permette di restituire lo stato della strada
	 * @return un matrice sotto forma di stringhe che rappresenta la strada
	 */
	public String stampaStrada(){
		String str = "";
		for(int y = 0; y < R; y++){
			str += CORNICE + CORNICE;
			str += (y+1) +" |";
			for(int x = 0; x < C; x++){
				str += " " + strada[y][x] + " ";
			}
			
			str += "\n";
		}
		
		str += CORNICE;
		return str;
	}
	
	/**
	 * Svuota la strada
	 */
	private void svuotaStrada(){
		for(int y=0; y<R; y++)
			for(int x=0; x<C; x++)
				strada[y][x]=' ';
	}
	/**
	 * Aggiorna la strada, controllando che l'elemento passato sia all'interno della matrice
	 * @param el elemento (pedone o auto)
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void aggiornaStrada(Elemento el) throws ArrayIndexOutOfBoundsException{
		try{
			strada[el.getPosY()][el.getPosX()] = el.getCh();
		}
		catch(ArrayIndexOutOfBoundsException e){
			sullaStrada.fineCorsa(el);
		}
	}
	
	/**
	 * Aggiorna la strada, creando macchine e pedoni, e li posiziona mediante il metodo aggiornaStrada(Elemento el)
	 * @return stringa strada
	 */
	public String aggiornaStrada(){
		String str = sullaStrada.avanzamento();
		
		sullaStrada.generaMacchine();
		sullaStrada.generaPedoni();
		
		svuotaStrada();
		
		for(int i=0; i<sullaStrada.getSize(); i++){
			aggiornaStrada(sullaStrada.getElemento(i));
		}
		
		return str;
	}

}
