package GestioneNoleggio;

import java.util.ArrayList;

public class Magazzino {

	private final static String NON_PRESENTE = "Mezzo non presente nel parco mezzi";
	private final static String NON_NOLEGGIATO = "Il mezzo non è stato noleggiato o non è presente";
	private final static String NULL = "Non hai inserito nulla, cretino!";
	
	private ArrayList<Mezzo> parcoMezzi;
	
	public Magazzino(){
		parcoMezzi = new ArrayList<>();
	}
	
	/**
	 * Aggiunta di un mezzo al ParcoMezzi.
	 * @param mezzo
	 */
	public void addMezzo(Mezzo mezzo){
		boolean valido = true;
		if(parcoMezzi.contains(null)){
			valido = false;
			throw new IllegalArgumentException(NULL);
		}
		for(int i = 0; i < parcoMezzi.size(); i++){
			if(parcoMezzi.get(i).getNumSerie().equals(mezzo.getNumSerie())){
				mezzo.setNumSerie(mezzo.generaNumSerie());
				parcoMezzi.add(mezzo);
				valido = false;
			}
		}
		if(valido){
			parcoMezzi.add(mezzo);
		}
	}
	
	/**
	 * metodo per noleggiare un mezzo. 
	 * @param caricoSollevabile
	 * @param durata
	 * @return
	 */
	public boolean mezzoPrenotabile(int caricoSollevabile, int durata){
		boolean trovato = false;
		for(int i = 0; i < parcoMezzi.size(); i++){
			if((parcoMezzi.get(i).getCaricoMax() >= caricoSollevabile) && (trovato == false)){
				if(parcoMezzi.get(i).getNoleggiato() == false){
					parcoMezzi.get(i).setNoleggiato();
					parcoMezzi.get(i).setDurataNoleggio(durata);
					trovato = true;
				}
			}
		}
		if(trovato == false) trovato = false;
		return trovato;
		
	}
	
	/**
	 * Concludi il noleggio
	 * @param numSerie
	 * @return
	 */
	public int concludiNoleggio(String numSerie){
		boolean trovato = false;
		int prezzo = 0;
		for(int i = 0; i < parcoMezzi.size(); i++){
			if(stringheUguali(parcoMezzi.get(i).getNumSerie(), numSerie) && (parcoMezzi.get(i).getNoleggiato() == true)){
				parcoMezzi.get(i).setRiportato();
				prezzo = parcoMezzi.get(i).getDurataNoleggio() * parcoMezzi.get(i).getCostoNoleggio();
				trovato = true;
				return prezzo;
			}
		}
		if(trovato == false) throw new IllegalArgumentException(NON_NOLEGGIATO);
		return 0;
	}
	
	/**
	 * Ricerca di un mezzo nel parco mezzi.
	 * @param numSerie
	 * @return
	 */
	public Mezzo cercaMezzo(String numSerie){
		for(int i = 0; i < parcoMezzi.size(); i++){
			if(parcoMezzi.get(i).generaNumSerie() == numSerie){
				return parcoMezzi.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Elimina un mezzo presente nel ParcoMezzi
	 * @param numSerie
	 */
	public void eliminaMezzo(String numSerie){
		boolean trovato = false;
		for(int i = 0; i < parcoMezzi.size(); i++){
			if(parcoMezzi.get(i).getNumSerie().equals(numSerie)){
				trovato = true;
				parcoMezzi.remove(i);
			}
		}
		if(!trovato){
			throw new IllegalArgumentException(NON_PRESENTE);
		}
	}
	
	/**
	 * @return the parcoMezzi
	 */
	public ArrayList<Mezzo> getParcoMezzi() {
		return parcoMezzi;
	}

	/**
	 * Ovverride del metodo toString
	 */
	public String toString(){
		String elencoMezzi = "";
		for(Mezzo mezzo : parcoMezzi){
			elencoMezzi = elencoMezzi + mezzo.toString() + "\n";
		}
		return elencoMezzi;
	}
	
	
	public int getNumeroMezzi(){
		@SuppressWarnings("unused")
		int n;
		return n = parcoMezzi.size();
	}

	/**
	 * Confronta se due stringhe sono uguali o meno
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean stringheUguali(String str1, String str2){
		if(str1.equals(str2)) return true;
		else return false;
	}
	
	public String toStringNoleggiato(){
		String noleggiato = "";
		String mezziNoleggiati = "I mezzi noleggiati sono i seguenti : \n";
		for(int i = 0; i < parcoMezzi.size(); i++){
			if(parcoMezzi.get(i).getNoleggiato() == true){
				noleggiato = noleggiato + parcoMezzi.get(i).toString() + "\n";
			}
		}
		return (mezziNoleggiati + noleggiato);
	}
}
