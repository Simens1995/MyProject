package It.Unibs.Engineer;

import java.util.ArrayList;

/**
 * Questa classe offre le seguenti funzionalità:
 * _Aggiungere una gara, controllando che essa non sia già presente o non sia nulla;
 * _Scegliere una gara, controllando che essa sia presente nell'elenco gare;
 * _Conoscere il numero di gare registrate;
 * _Visualizzazione gare dell'elenco
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */
public class ElencoGare {
	private final String PRESENTE = "Gara già presente nell'elenco gare";
	private final String NULLO = "Hai inserito una stringa nulla";
	private final String NON_PRESENTE = "La gara cercata non è presente nell'elenco gare";

	private ArrayList<Gara> gare;
	
	/**
	 * COSTRUTTORE
	 */
	public ElencoGare(){
		gare = new ArrayList<>();
	}
	
	/**
	 * Questo metodo ti permette di aggiungere una gara nell'elenco gare
	 * @param gara - oggetto di tipo gara
	 * 
	 * @thorws IllegalArgumentException nel caso in cui:
	 * _La gara sia già presente
	 * _La gara digitata sia nulla
	 */
	public void aggiungiGara(Gara gara){
		
		boolean esiste = false;
		
		for(int i = 0; i < gare.size(); i++){
			   if(gara.getGara().equalsIgnoreCase(gare.get(i).getGara())){
				   esiste = true;
				   throw new IllegalArgumentException(PRESENTE);
			   }
			   else if(gara.getGara() == null){
				   esiste = true;
				   throw new IllegalArgumentException(NULLO);
			   }
		}	
		
		if(esiste == false){
			gare.add(gara);			
		}		
	}
	
	/**
	 * Questo metodo permette di conoscere se la gara cercata esiste nell'elenco
	 * @param gara
	 * @return esiste (indice della gara nell'elenco, se esiste)
	 */
	public int esiste(String gara) {		
		int esiste=-1;
		for(int i=0; i<gare.size(); i++){
			if(gara.equals(gare.get(i).getGara())){
				esiste=i;
			}
		}
		return esiste;
	}
	
	/**
	 * Questo metodo permette di cercare una gara nell'elenco gare
	 * @param gara
	 * @return indice della gara
	 * @throws IllegalArgumentException nel caso in cui:
	 * _Se non esiste la gara nell'elenco, viene lanciata l'eccezione
	 */
	public Gara cercaGara(String gara) throws IllegalArgumentException {
        int indice = esiste(gara);
		if(indice >= 0) return gare.get(indice);
		else
			throw new IllegalArgumentException(NON_PRESENTE);
	}	
	
	/**
	 * Ritorna il numero di gare presenti nell'elenco
	 * @return numeroGare
	 */
	public int getNumeroGare(){
		int numeroGare = gare.size();
		return numeroGare;
	}	
	/**
	 * Stampa le gare presenti nell'elenco gare
	 */
	public String toString(){
		String garette = "Le gare presenti nell'elenco sono : \n";
		String tutteGare = "";
		for(int i = 0; i < gare.size(); i++){
			tutteGare = tutteGare + gare.get(i).toString();
	     }
		return (garette + tutteGare);
	}
}
