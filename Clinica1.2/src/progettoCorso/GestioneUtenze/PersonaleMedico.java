
package progettoCorso.GestioneUtenze;

import java.io.Serializable;
import java.time.LocalDate;

import static progettoCorso.GestioneUtenze.Costanti.*;
/**
 * Classe PersonaleMedico (eredita da Utenti).
 *@author Simaz Andrea
 */

public class PersonaleMedico extends Vino implements Serializable{
	/**
	 * COSTANTI CLASSE
	 */
	private static final long serialVersionUID = 1L;
	private final int LUNGH_COD_CASUALE = 3;
	private static final String CASUAL_NUMERIC_STRING = "0123456789";

	/**
	 * VARIABILI
	 */
	private String codAlfanumerico;
	private TipologiaMedico tipologia;
	
	/**
	 * COSTRUTTORE
	 * @param nome
	 * @param cognome
	 * @param luogoNascita
	 * @param telefono
	 * @param data
	 * @param genere
	 * @param codiceFiscale
	 * @param Cap
	 * @param tipologia
	 */
	public PersonaleMedico(String nome, String cognome, String luogoNascita,
			String telefono, LocalDate data, Genere genere, String codiceFiscale, int Cap, TipologiaMedico tipologia) {
		super(nome, cognome, luogoNascita, telefono, data, genere, codiceFiscale, Cap);
		this.codAlfanumerico = generaCodice();
		this.tipologia = tipologia;
	}

	//--------------GETTER & SETTER------------------
	/**
	 * @return codAlfanumerico : ritorna il codice alfanumerico di un medico.
	 */
	public String getCodAlfanumerico() {
		return codAlfanumerico;
	}
	
	/**
	 * @return tipologia : ritorna la tipologia di un medico.
	 */
	public TipologiaMedico getTipologia() {
		return tipologia;
	}

	/**
	 * Setta la tipologia di un medico.
	 * @param tipologia
	 */
	public void setTipologia(TipologiaMedico tipologia) {
		this.tipologia = tipologia;
	}

	//---------------METODI-------------------
	/**
	 * Questo metodo genera un codice alfanumerico semi-casuale che dipende da:
	 * _Prime tre lettere del nome;
	 * _Prime due lettere del cognome;
	 * _Il CAP dove risiede il medico;
	 * _"/";
	 * _3 numeri casuali.
	 * @Author Simaz Andrea
	 * @return Stringa codice AlfaNumerico
	 */
	private String generaCodice(){
		String nomeMedico = super.getNome();
        String cognMedico = super.getCognome();
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(nomeMedico.substring(0, 3)).append(cognMedico.substring(0, 2)).append(this.getCap() + "/");
		
		for(int i = 0; i < LUNGH_COD_CASUALE; i++){
			int character = (int)(Math.random()*CASUAL_NUMERIC_STRING.length());
			stringBuilder.append(CASUAL_NUMERIC_STRING.charAt(character));
		}
		return stringBuilder.toString();
	}
	
	/**
	 * @Author Simaz Andrea
	 * @return descrMedico : ritorna tutti i dati del medico inserito nella lista.
	 * @overriding
	 */
	public String toString(){
		String descrMedico = "";
		descrMedico = (super.toString() + COD_MED + getCodAlfanumerico() + TIPOLOG + tipologia);
		return descrMedico;
	}
	
	/**
	 * Dati da stampare nel caso di richiesta visualizzazione dati contraddistinvi del medico.
	 * @return datiMedico : raccolta dati importanti del medico comprendente di nome, cognome e codice alfaNumerico.
	 */
	public String toStringDati(){
		String datiMedico = "";
		datiMedico = (NOME_MED + super.getNome() + COGNOME_MED + super.getCognome() + COD_MED + getCodAlfanumerico());
		return datiMedico;
	}

	/**
	 * Overriding dei metodi equals e hashcode
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((tipologia == null) ? 0 : tipologia.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PersonaleMedico))
			return false;
		PersonaleMedico other = (PersonaleMedico) obj;
		if (tipologia != other.tipologia)
			return false;
		return true;
	}

	
}
