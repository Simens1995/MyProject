package progettoCorso.GestioneUtenze;
import java.io.Serializable;
//import java.text.DateFormat;
//import java.text.Format;
//import java.text.SimpleDateFormat;
import java.time.*;

import MyLib.MyVarie;
import static progettoCorso.GestioneUtenze.Costanti.*;

/**
 * SuperClasse Utenti che estende PersonaleMedico.
 * @author Simaz Andrea 
 */
public class Vino implements Serializable{

	/** VARIABILI INIZIALI. */
	private static final long serialVersionUID = 1L;         
	private String nome, cognome, luogoNascita, telefono, codiceFiscale;
	private LocalDate dataNascita;
	private Genere genere;
	private int Cap;
	
	
	
	/**
	 * COSTRUTTORE.
	 * @param nome il nome
	 * @param cognome il cognome
	 * @param luogoNascita il luogo di nascita
	 * @param telefono il numero di telefono
	 * @param data la data
	 * @param genere il genere
	 * @param codiceFiscale il codice fiscale
	 * @param Cap il cap
	 */
	public Vino(String nome, String cognome, String luogoNascita,
			String telefono, LocalDate data, Genere genere, String codiceFiscale, int Cap) {
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogoNascita;
		this.telefono = telefono;
		this.dataNascita = data;
		this.genere = genere;
		this.codiceFiscale = codiceFiscale;
		this.Cap = Cap;
	}
	 
	//----------------SETTER & GETTER----------------------
	
	/**
	 * Gets Nome.
	 * @return nome.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Setta il Nome.
	 * @param nome the new nome
	 */
	public void setNome(String nome){
		this.nome = nome;
	}
	
	/**
	 * Gets il Cognome.
	 * @return cognome.
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Setta il Cognome
	 * @param cognome Cognome da settare
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Gets il luogo di nascita.
	 * @return LuogoNascita.
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}

	/**
	 * Setta il luogo di Nascita
	 * @param luogoNascita 
	 */
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	
	/**
	 * Gets numero di telefono.
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Setta il numero di telefono.
	 * @param telefono il nuovo numero di telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Gets il codice fiscale.
	 * @return the codice fiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * Gets la data di nascita.
	 * @return the data
	 */
	public LocalDate getData() {
		return dataNascita;
	}

	/**
	 * Setta la data di nascita
	 * @param dataNascita
	 */
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * Gets il genere della persona
	 * @return il genere
	 */
	public Genere getGenere() {
		return genere;
	}

	/**
	 * Gets il CAP della città.
	 * @return the cap
	 */
	public int getCap() {
		return Cap;
	}

	/**
	 * Setta il  cap.
	 * @param Cap il nuovo CAP
	 */
	public void setCap(int Cap){
		this.Cap = Cap;
	}
	
	/**
	 * Setta il genere della persona
	 * @param genere
	 */
	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	//-------------------METODI---------------------


	/**
	 * Descrizione dell'utente completa. Override toString()
	 * @author Simaz Andrea
	 * @return descrizioneUtente 
	 */
	@Override
	public String toString(){
		//String str = dataNascita.format(f);
		String descrizioneUtente = (NOME + nome + COGNOME + cognome + LUOGO_NASC + luogoNascita +
				NUM_TEL + telefono + DATA_NASC + MyVarie.toStringData(dataNascita) + GENERE + genere + 
				COD +  codiceFiscale.toUpperCase() + CAP + Cap);
		return descrizioneUtente;
	}
	
	/**
	 * Descrizione comprendente i dati più importanti dell'utente (nome, cognome e codice fiscale)
	 * @Author Simaz Andrea
	 * @return string datiUtente
	 */
	public String toStringDati(){
		String datiUtente = "";
		datiUtente = (NOME + getNome() + COGNOME + getCognome() + COD + getCodiceFiscale().toUpperCase());
		return datiUtente;
	}
	
	/**
	 * Overriding metodi hashCode e equals
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Cap;
		result = prime * result
				+ ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result
				+ ((dataNascita == null) ? 0 : dataNascita.hashCode());
		result = prime * result + ((genere == null) ? 0 : genere.hashCode());
		result = prime * result
				+ ((luogoNascita == null) ? 0 : luogoNascita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
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
		if (!(obj instanceof Vino))
			return false;
		Vino other = (Vino) obj;
		if (Cap != other.Cap)
			return false;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataNascita == null) {
			if (other.dataNascita != null)
				return false;
		} else if (!dataNascita.equals(other.dataNascita))
			return false;
		if (genere != other.genere)
			return false;
		if (luogoNascita == null) {
			if (other.luogoNascita != null)
				return false;
		} else if (!luogoNascita.equals(other.luogoNascita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
}
