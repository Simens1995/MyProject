package progettoCorso.GestioneUtenze;

import java.io.Serializable;
import java.util.*;

/**
 * Classe che gestisce i medici dell'ospedale
 * @author Simaz Andrea
 */
public class MediciOspedale implements Serializable{

	/**
	 * COSTANTI 
	 */
	private static final long serialVersionUID = 1L;                       
	private final String PRESENTE = "\nIl medico che stai cercando di aggiungere, esiste già";
	private final String OBBLIGATORIO = "\nI campi richiesti all'utente sono tutti obbligatori";
	private final String NON_PRESENTE = "\nIl medico non è presente nella lista dei medici dell'Ospedale";
	private final String COD_NON_PRESENTE = "\nCodice medico non presente nell'albo";
	private final String A_CAPO = "\n";
	private final int NON_ESISTE = -1;
	final static String SURE = "Sicuro di uscire ? ";

	/**
	 * VARIABILI
	 */
	private ArrayList<PersonaleMedico> medici;
	//private ListIterator<PersonaleMedico> iter = medici.listIterator();

	public MediciOspedale(){
		medici = new ArrayList<PersonaleMedico>();
	}

	/**
	 * Questo metodo permette di aggiungere un medico alla lista di medici: _Se è già contenuto viene lanciata una eccezione;
	 * 																		_Se è un valore nullo viene lanciata una eccezione;
	 * @author Simaz Andrea
	 * @param medico : Oggetto di tipo medico
	 */
	public void aggiungiMedico(PersonaleMedico medico){
		boolean valido = true;
		if(medici.contains(medico) && codicePresente(medico)){
			valido = false;
			throw new IllegalArgumentException(PRESENTE);
		}
		else if(medici.contains(null)){
			valido = false;
			throw new IllegalArgumentException(OBBLIGATORIO);
		}
		if(valido == true){
			medici.add(medico);
		}
	}
	
	/**
	 * Verifica se il codice fiscale è già stato immesso precedentemente
	 * @author Andrea Simaz
	 * @param utente
	 * @return true : _Se esiste;
	 *         false: _Se non esiste
	 */
	public boolean codicePresente(PersonaleMedico medico){
		for(int i = 0; i < medici.size(); i++){
			if(medico.getCodiceFiscale().equals(medici.get(i).getCodiceFiscale()))
					return true;
		}
		return false;
	}
	


	//Metodo inutilizzato - Funzionante.
	/**
	 * Questo metodo permette di cercare un medico all'interno della lista di medici, usando tutti i parametri.
	 * @author Simaz Andrea
	 * @param medico
	 * @return indice :  _Se esiste ritorna l'indice;
	 *  				_Se non esiste torna viene lanciata una eccezione;
	 */
	public int cercaMedicoNoCod(PersonaleMedico medico){
		if(medici.contains(medico)){
			int indice = medici.indexOf(medico);
			return indice;
		}
		else{
			throw new IllegalArgumentException(NON_PRESENTE);
		}
	}

	/**
	 * Cerca un medico presente nella lista utilizzando il suo codice alfanumerico
	 * @author Simaz Andrea
	 * @param codice : codice alfaNumerico del medico
	 * @return indice : _Se esiste ritorna l'indice;
	 *  				_Se non esiste torna viene lanciata una eccezione;
	 */
	public int cercaMedicoCod(String codice){
		int indice = NON_ESISTE;

		for(int i = 0; i < medici.size(); i++){
			if(medici.get(i).getCodAlfanumerico().equals(codice))
				indice = medici.indexOf(medici.get(i));
		}
		if(indice == NON_ESISTE){
			throw new IllegalArgumentException(COD_NON_PRESENTE);
		}
		return indice;  
	}

	/**
	 * Questo metodo permette di rimuovere un medico all'interno della lista medici
	 * @Author Simaz Andrea
	 * @param medico
	 */
	public void eliminaMedicoNoCod(PersonaleMedico medico){
		if(medici.contains(medico)){
			@SuppressWarnings("unused")
			int indice = medici.indexOf(medico);
			medici.remove(medico);
		}
		else{
			throw new IllegalArgumentException(NON_PRESENTE);
		}
	}

	/**
	 * Questo metodo permette di rimuovere un medico all'interno della lista medici utilizzando il suo relativo codice.
	 * @Author Simaz Andrea
	 * @param medico
	 */
	public void eliminaMedicoCod(String codice){
		int indice = NON_ESISTE;

		for(int i = 0; i < medici.size(); i++){
			if(medici.get(i).getCodAlfanumerico().equals(codice)){
				indice = medici.indexOf(medici.get(i));
				medici.remove(indice);
			}
		}
		if(indice == NON_ESISTE){
			throw new IllegalArgumentException(NON_PRESENTE);
		}
	}

	/**
	 * retituisce l' i-esimo medico
	 * @Author Lorenzoni Andrea
	 * @param i posizione del medico
	 * @return il medico in posizione i
	 */
	public PersonaleMedico getMedico(int i){
		return medici.get(i);
	}


	/**
	 * Ritorna il numero di medici presenti nella lista medici.
	 * @Author Lorenzoni Andrea
	 * @return n = numeri medici.
	 */
	public int getNumeroMedici(){
		@SuppressWarnings("unused")
		int n;
		return n = medici.size();
	}

	/**
	 * Stampa tutti i medici presenti nella lista con tle descrizioni complete.
	 * @Author Lorenzoni Andrea
	 * @return elencoMedici : elenco medici con descrizione completa.
	 */
	public String toString(){
		String elencoMedici = "";
		for(PersonaleMedico medico : medici){
			elencoMedici = elencoMedici + medico + A_CAPO;
		}
		return elencoMedici;
	}

	/**
	 * Stampa i dati significativi di tutti i medici nella lista.
	 * @Author Lorenzoni Andrea
	 * @return elencoMediciShort : elenco medici con descrizione abbreviata.
	 */
	public String toStringDati(){
		String elencoMediciShort = "";
		for(PersonaleMedico medico : medici){
			elencoMediciShort = elencoMediciShort + medico.toStringDati() + A_CAPO;
		}
		return elencoMediciShort;
	}

	/**
	 * Serve per l'aggiornamento di un medico. Se è presente, il medico viene aggiornato e poi scambiato con il vecchio oggetto
	 * medico che viene eliminato.
	 * @Author Simaz Andrea
	 * @param medico
	 */
	public void inserisciMedico(PersonaleMedico medico){
		for(int i=0; i<medici.size(); i++){
			if(medico.getCodiceFiscale().equals(medici.get(i).getCodiceFiscale())){
				medici.remove(i);
			}
		}
		medici.add(medico);
	}
	//L'overriding mi è servito sostanzialmente per poter confronare due oggetti, uno pre-esistente e uno creato 
	//in un momento successivo per poter eliminare un medico pre-esistente con gli stessi paramentri dell'oggetto pre-esistente.
	/**
	 * Overriding dei metodi hashCode e equals per poter confrontare un oggetto PersonaleMedico, con un nuovo oggetto
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * @Author Simaz Andrea
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((medici == null) ? 0 : medici.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @Author Simaz Andrea
	 */
	//@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MediciOspedale))
			return false;
		MediciOspedale other = (MediciOspedale) obj;
		if (medici == null) {
			if (other.medici != null)
				return false;
		} else if (!medici.equals(other.medici))
			return false;
		return true;
	}

}
