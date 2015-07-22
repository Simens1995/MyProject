package It.Unibs.Engineer;

import java.util.ArrayList;

/**
 * Questa classe offre alcune funzionalità fra le quali:
 * _Aggiungere una nazione, controllando che essa non sia già presente o non sia nulla;
 * _Scegliere una nazione, controllando che essa sia presente nell'elenco nazioni;
 * _Visualizzare il medagliere completo;
 * _Visualizza il medagliere olimpionico ordinato;
 * _Conoscere il numero di nazioni iscritte
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */

public class ElencoNazioni{
    private final String PRESENTE = "Nazione già presente nell'elenco";
    private final String NULLO = "Hai inserito una stringa nulla";
    private final String NON_PRESENTE = "La nazione che hai cercato non è presente nell'elenco nazioni";
	
	private ArrayList<Nazione> nazioni;
	
	/**
	 * COSTRUTTORE
	 */
	public ElencoNazioni(){
		nazioni = new ArrayList<>();
	}
	
	/**
	 * Questo metodo ti permette di aggiungere una nazione nell'elenco nazioni
	 * @param nazione - oggetto di tipo nazione
	 * 
	 * @thorws IllegalArgumentException nel caso in cui:
	 * _La nazione sia già presente
	 * _La nazione digitata sia nulla
	 */
	public void aggiungiNazione(Nazione nazione){
		
		boolean esiste = false;
		
		for(int i = 0; i < nazioni.size(); i++){
			   if(nazione.getNazione().equalsIgnoreCase(nazioni.get(i).getNazione())){
				   esiste = true;
				   throw new IllegalArgumentException(PRESENTE);
			   }
			   else if(nazione.getNazione() == null){
				   esiste = true;
				   throw new IllegalArgumentException(NULLO);
			   }
		}	
		
		if(esiste == false){
			nazioni.add(nazione);
			
		}		
	}
	/**
	 * Questo metodo permette di conoscere se la nazione cercata esiste nell'elenco
	 * @param nazione
	 * @return indice della nazione, se esiste
	 */
	
	public int esiste(String nazione) {
		int esiste=-1;
		for(int i=0; i<nazioni.size(); i++){
			if(nazione.equals(nazioni.get(i).getNazione())){
				esiste=i;
			}
		}
		return esiste;
	}
	
	/**
	 * 
	 * @param nazione
	 * @return indice nazione cercata, se esiste
	 * @throws IllegalArgumentException nel caso in cui:
	 * _La nazione cercata non esista
	 */
	public Nazione scegliNazione(String nazione) throws IllegalArgumentException {
		 int indice = esiste(nazione);
			if(indice >= 0) return nazioni.get(indice);
		else
			throw new IllegalArgumentException(NON_PRESENTE);		
	}

	/**
	 * Visualizza il medagliere
	 */
	public void visualizzaMedagliere(){
		String descrizione = "RISULTATI OLIMPICI : \n";
		for(int i = 0; i < nazioni.size(); i++){
			descrizione = descrizione + "\t - " + nazioni.get(i).toString();
		}
		
		System.out.println(descrizione);
	}
	
	/**
	 * Questo metodo indica il numero di nazioni presenti registrate
	 * @return numeroNazioni registrate
	 */
	public int getNumeroNazioni(){
		int numeroNazioni = nazioni.size();
		return numeroNazioni;
	}
	
	/**
	 * Visualizza il medagliere olimpionico ordinato utilizzando :
	 * _Il metodo meglioDi e un QuickSort
	 */
	public void visualizzaMedagliereOrdinato(){
		for(int i = 0; i < nazioni.size() - 1; i++){
			Nazione max = nazioni.get(i);
			for(int j = i + 1; j < nazioni.size(); j++){
				if(!max.meglioDi(nazioni.get(j))){
					Nazione tmp = max;
					max = nazioni.get(j);
					nazioni.set(j, tmp);
				}	
			}
			nazioni.set(i, max);
		}
		this.visualizzaMedagliere();
	}

}
	
