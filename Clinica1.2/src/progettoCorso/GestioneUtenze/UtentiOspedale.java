package progettoCorso.GestioneUtenze;

import java.io.Serializable;
import java.util.ArrayList;

public class UtentiOspedale implements Serializable{

	/**
	 * Classe UtentiOspedale 
	 * @author Andrea Simaz
	 * Gestione degli utenti dell'ospedale
	 */
	private static final long serialVersionUID = 1L;  
	private final String PRESENTE = "L'utente che stai cercando di aggiungere, esiste già";
	private final String OBBLIGATORIO = "I campi richiesti all'utente sono tutti obbligatori";
	private final String NON_PRESENTE = "L'utente non è presente nella lista degli utenti dell'Ospedale";
	private final String COD_NON_PRESENTE = "Il codice immesso non è presente";
	private final int NON_ESISTE = -1;
	final static String SURE = "Sicuro di uscire ? ";
	
	/**
	 * VARIABILI INIZIALI
	 */
	private ArrayList<Vino> utenti;
	/**
	 * COSTRUTTORE
	 */
	public UtentiOspedale(){
		utenti = new ArrayList<Vino>();
	}
	
	/**
	 * Questo metodo permette di aggiungere un utente alla lista di utenti: _Se è già contenuto viene lanciata una eccezione;
	 * 																		_Se è un valore nullo viene lanciata una eccezione;
	 * @author Simaz Andrea
	 * @param utente : Oggetto di tipo utente
	 */
	public void aggiungiUtente(Vino utente){
		boolean valido = true;
		codicePresente(utente.getCodiceFiscale());
		if((utenti.contains(utente))){
			valido = false;
			throw new IllegalArgumentException(PRESENTE);
		}
		else if(utenti.contains(null)){
			valido = false;
			throw new IllegalArgumentException(OBBLIGATORIO);
		}
		if(valido == true){
			utenti.add(utente);
		}
	}
	
	/**
	 * Verifica se il codice fiscale è già stato immesso precedentemente
	 * @author Andrea Simaz
	 * @param utente
	 * @return true : _Se esiste;
	 *         false: _Se non esiste
	 */
	public boolean codicePresente(String codice){
		boolean valid = false;
		for(int i = 0; i < utenti.size(); i++){
			if(utenti.get(i).getCodiceFiscale().equals(codice)) 
				return valid = true;
		}
		return valid;
	}
	
	/**
	 * Questo metodo permette di cercare un utente all'interno della lista di utenti, usando tutti i parametri.
	 * @author Simaz Andrea
	 * @param utente
	 * @return indice :  _Se esiste ritorna l'indice;
	 *  				 _Se non esiste torna viene lanciata una eccezione;
	 */
	public int cercaUtenteNoCod(Vino utente) throws IllegalArgumentException{
		int indice = NON_ESISTE;
		for(int i = 0; i < utenti.size(); i++){
			if(utente.equals(utenti.get(i))){
				return indice = utenti.indexOf(utente);
			}
		}
		return indice;
	}
	
	/**
	 * Cerca un utente presente nella lista utilizzando il suo codice fiscale
	 * @author Simaz Andrea
	 * @param codiceFisc  : codice fiscale dell'utente
	 * @return indice     : _Se esiste ritorna l'indice;
	 *  				    _Se non esiste torna viene lanciata una eccezione;
	 */
	public int cercaUtenteCod(String codiceFisc){
		int indice = NON_ESISTE;
		int zero = 0;
		for(int i = 0; i < utenti.size(); i++){
		 if(zero == utenti.get(i).getCodiceFiscale().compareTo(codiceFisc))
			 indice = utenti.indexOf(utenti.get(i));
		}
		if(indice == NON_ESISTE){
			throw new IllegalArgumentException(COD_NON_PRESENTE);
		}
		return indice;  
	}
	
	/**
	 * Questo metodo permette di rimuovere un utente all'interno della lista utenti
	 * @Author Lorenzoni Andrea
	 * @param utente
	 */
	public void eliminaUtenteNoCod(Vino utente){
		boolean trovato = false;
		for(int i = 0; i < utenti.size(); i++){
			if(utente.equals(utenti.get(i))){
				int indice = utenti.indexOf(utente);
				utenti.remove(indice);
				trovato = true;
			}
		}
		if(!trovato){
			throw new IllegalArgumentException(NON_PRESENTE);
		}
	}
	
	/**
	 * Questo metodo permette di rimuovere un utente all'interno della lista utenti utilizzando il suo relativo codice.
	 * @Author Simaz Andrea
	 * @param utente
	 */
	public void eliminaUtenteCod(String codice){
        int indice = NON_ESISTE;
		
		for(int i = 0; i < utenti.size(); i++){
			if(utenti.get(i).getCodiceFiscale().equals(codice)){
				indice = utenti.indexOf(utenti.get(i));
				utenti.remove(indice);
			}
			}
		if(indice == NON_ESISTE){
			throw new IllegalArgumentException(COD_NON_PRESENTE);
		}
	}
	
	/**
	 * restituisce l'iesimo utente 
	 * @Author Lorenzoni Andrea
	 * @param i posizione dell'utente
	 * @return l'utente in posizione i
	 */
	public Vino getUtente(int i){
		return utenti.get(i);
	}
	
	/**
	 * Ritorna il numero di utenti presenti nella lista utenti.
	 * @Author Simaz Andrea
	 * @return n = numeri medici.
	 */
	public int getNumeroUtenti(){
		@SuppressWarnings("unused")
		int n;
		return n = utenti.size();
	}
	
	/**
	 * Stampa tutti gli utenti presenti nella lista con le descrizioni complete.
	 * @author Simaz Andrea
	 * @return elencoUtenti : elenco utenti con descrizione completa.
	 */
	public String toString(){
		String elencoUtenti = "";
		for(Vino utente : utenti){
			elencoUtenti = elencoUtenti + utente + "\n";
		}
		return elencoUtenti;
	}
	
	/**
	 * Stampa i dati significativi di tutti gli utenti nella lista.
	 * @Author Simaz Andrea
	 * @return elencoUtentiShort : elenco utenti con descrizione abbreviata.
	 */
	public String toStringDati(){
		String elencoUtentiShort = "";
		for(Vino utente : utenti){
			elencoUtentiShort = elencoUtentiShort + utente.toStringDati() + "\n";
		}
		return elencoUtentiShort;
	}
	
	/**
	 * Aggiornamento di un utente con uno nuovo
	 * @author Simaz Andrea
	 * @param utente
	 */
	public void inserisciUtente(Vino utente){
		for(int i=0; i<utenti.size(); i++){
			if(utente.getCodiceFiscale().equals(utenti.get(i).getCodiceFiscale())){
				utenti.remove(i);
			}
		}
		
		utenti.add(utente);
	}
	
	/**
	 * Overriding metodi equals e hashCode
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((utenti == null) ? 0 : utenti.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UtentiOspedale))
			return false;
		UtentiOspedale other = (UtentiOspedale) obj;
		if (utenti == null) {
			if (other.utenti != null)
				return false;
		} else if (!utenti.equals(other.utenti))
			return false;
		return true;
	}
	
}
