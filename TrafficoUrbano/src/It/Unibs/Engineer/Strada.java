package It.Unibs.Engineer;
import java.util.ArrayList;

import MyClass.MyVarie;


/**
 * Classe per la gestione della strada
 * @author Fapanni Tiziano, Lorenzoni Andrea & Simaz Andrea
 *
 */
public class Strada {
	private static final int ZERO = 0, V_PEDONE = 1, V_AUTO = 3, V_VUOTO = 0;
	private int colonne, righe;
	
	
	private ArrayList<Elemento> sullaStrada;
	
	/**
	 * COSTRUTTORE: genera una strada vuota
	 */
	public Strada(int c, int r){
		sullaStrada = new ArrayList<Elemento>();
		this.colonne = c;
		this.righe = r;
	}
	
	/**
	 * COSTRUTTORE: genera una strada con
	 * @param pedoni: numero di pedoni
	 * @param auto: numero di automobili
	 * @param r: 
	 * @param c:
	 */
	public Strada(int pedoni, int auto, int c, int r){
		this(c, r);
		
		do{
			int x=MyVarie.interoCasuale(righe-1, ZERO);
			int y=MyVarie.interoCasuale(colonne-1, ZERO);
			Pedone el=new Pedone(V_PEDONE, x, y);
			if(!pariCoordinate(el)){
				sullaStrada.add(el);
				pedoni--;
			}
		}while(pedoni>0);
		
		do{
			int x=MyVarie.interoCasuale(righe-1, ZERO);
			int y=MyVarie.interoCasuale(colonne-1, ZERO);
			Auto el=new Auto(V_AUTO, x, y);
			
			if(!pariCoordinate(el)){
				sullaStrada.add(el);
				auto--;
			}
		}while(auto>0);
		
	}
	
	private boolean pariCoordinate(Elemento el){
		for(int i=0; i<sullaStrada.size(); i++){
			if(el.getPosX()==sullaStrada.get(i).getPosX() && el.getPosX()==sullaStrada.get(i).getPosX())
				return true;
			else return false;
		}
		return false;
	}
	
	private int indicePariCoordinate(Elemento el){
		for(int i=0; i<sullaStrada.size(); i++){
			if(el.getPosX()==sullaStrada.get(i).getPosX() && el.getPosX()==sullaStrada.get(i).getPosX())
				return i;
		}
		return -1;
	}
	
	/**
	 * Metodo che genera casualmente n macchine (con 0 < n < R) e 
	 * le fa partire dall'inizio della strada
	 */
	public void generaMacchine(){
		int n=MyVarie.interoCasuale(righe, righe);
		
		for(int i=0; i<n; i++){
			int y=MyVarie.interoCasuale(righe-1, ZERO);
			Auto el= new Auto(V_AUTO, ZERO, y);
			
			if(!pariCoordinate(el)){
				sullaStrada.add(el);
			}
		}		
	}

	/**
	 * Metodo che genera casualmente n pedoni (con 0 < n < C) e 
	 * le fa partire dall'inizio della strada
	 */
	public void generaPedoni(){
		int n=MyVarie.interoCasuale(colonne, ZERO);
		
		for(int i=0; i<n; i++){
			int x=MyVarie.interoCasuale(colonne-1, ZERO);
			Pedone el=new Pedone(V_PEDONE, x, ZERO);
			
			if(!pariCoordinate(el)){
				sullaStrada.add(el);
			}
		}		
	}
	
	
	/**
	 * metodo che controlla se una casella è occupata da un oggetto Vuoto
	 * @param el elemento da controllare 
	 * @return true se la case ìlla è Vuoto, false altrimenti
	 */
	/*public boolean isVuoto(Elemento el){
		if(el.getNome().equals("Vuoto")) return true;
		else return false;
	}*/
	
	/**
	 * metodo che controlla se una casella è occupata da un oggetto Pedone
	 * @param el elemento da controllare 
	 * @return true se la case ìlla è Vuoto, false altrimenti
	 */
	public boolean isPedone(Elemento el){
		if(el.getNome().equals("Uomo")) return true;
		else return false;
	}
	
	/**
	 * metodo che controlla se una casella è occupata da un oggetto Auto
	 * @param el elemento da controllare 
	 * @return true se la case ìlla è Vuoto, false altrimenti
	 */
	public boolean isAuto(Elemento el){
		if(el.getNome().equals("Auto")) return true;
		else return false;
	}
	
	/**
	 * permette di far avanzare lo stato del programma
	 * @return la segnalazioen di eventuali scontri.
	 */
	public String avanzamento(){
		String str="";
		boolean strIniziata=false;
				
		for(int i=0; i<sullaStrada.size(); i++){
			sullaStrada.get(i).spostamento();
		}
		
		//controllo incidenti
		for(int i=0; i<sullaStrada.size(); i++){
			for(int j=i+1; j<sullaStrada.size(); j++){
				if(sullaStrada.get(i).getPosX()==sullaStrada.get(j).getPosX() && 
					sullaStrada.get(i).getPosY()==sullaStrada.get(j).getPosY()){
					if(!strIniziata){
						str="Rapporto spostamento: ";
						strIniziata=true;
					}
					str += "\n\t- Incidente alle coordinate " + sullaStrada.get(j).getPosX() + " ; " + 
					sullaStrada.get(j).getPosY();
					
					if(isAuto(sullaStrada.get(i)) && isPedone(sullaStrada.get(j)))
						sullaStrada.remove(i);
					else if(isAuto(sullaStrada.get(j)) && isPedone(sullaStrada.get(i))) 
						sullaStrada.remove(j);		 
				}
			}
		}
		
		return str;
	}
	
	public Elemento getElemento(int index){
		return sullaStrada.get(index);
	}
	
	public int getSize(){
		return sullaStrada.size();
	}
	
	public boolean fineCorsa(Elemento el){
		return sullaStrada.remove(el);
	}
}
