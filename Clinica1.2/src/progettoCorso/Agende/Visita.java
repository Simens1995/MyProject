package progettoCorso.Agende;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.Vino;
import MyLib.MyVarie;


/*
 * formato chiave LocalTime= ora
 */

/**
 * singola visita.
 *
 * @author Tiziano Fapanni
 */
public class Visita implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/** The data. */
	private LocalDate data;
	
	/** The ora inizio. */
	private LocalTime oraInizio;
	
	/** The paziente. */
	private Vino paziente; 	//verrà inizializzato con il nome del paziente
	
	/** The motivo. */
	private String motivo;		//motivo della visita
	
	/** The medico. */
	private PersonaleMedico medico;		//identificativo del medico
	
	/** The referto. */
	private String referto;		//referto, disponibile solo dopo la conclusione della visita.
	
	/** The prenotabile. */
	private boolean prenotabile; //permette di verificare se la visita è già stata prenotata o è ancora
	
	/** The stato visita. */
	private StatoVisita statoVisita;
	
	/** The prescrizione. */
	private String prescrizione;
	
	/** The formatter giorni. */
	private static DateTimeFormatter formatterGiorni = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	/** The formatter ora. */
	private static DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("hh:mm");
	
	
	/**
	 * Instanzia una nuova visita.
	 *
	 * @author Tiziano Fapanni
	 * @param anno di svolgimento della visita
	 * @param mese di svolgimento della visita
	 * @param giorno di svolgimento della visita
	 * @param ora di inizio della visita
	 * @param minuto di inizio della visita
	 */
	public Visita(int anno, int mese, int giorno, int ora, int minuto){
		oraInizio=LocalTime.of(ora, minuto);
		data=LocalDate.of(anno, mese, giorno);
		prenotabile=true;
	}
	
	/**
	 * Instanzia una nuova visita.
	 *
	 * @author Tiziano Fapanni
	 * @param data di svolgimento della visita
	 * @param hInizio ora di inizio della visita
	 * @param medico 
	 */
	public Visita(LocalDate data, LocalTime hInizio, PersonaleMedico medico){
		this.data=data;
		this.oraInizio=hInizio;
		this.medico=medico;
		prenotabile=true;
	}

	/**
	 * Instanzia una nuova visita.
	 *
	 * @author Tiziano Fapanni
	 * @param anno di svolgimento della visita
	 * @param mese di svolgimento della visita
	 * @param giorno di svolgimento della visita
	 * @param ora di inizio della visita
	 * @param minuto di inizio della visita
	 * @param paziente da visitare
	 * @param motivo della visita
	 * @param medico che deve effettuare la visita
	 * @param referto compilato dal medico
	 */
	public Visita(int anno, int mese, int giorno, int ora, int minuto, Vino paziente, String motivo,
		PersonaleMedico medico, String referto) {
		this(anno, mese, giorno, ora, minuto);
		this.paziente = paziente;
		this.motivo = motivo;
		this.medico = medico;
		this.prenotabile = false;
	}
	

	/**
	 * Gets the prescrizione.
	 *
	 * @return the prescrizione
	 */
	public String getPrescrizione() {
		return prescrizione;
	}

	/**
	 * Sets the prescrizione.
	 *
	 * @param prescrizione the new prescrizione
	 */
	private void setPrescrizione(String prescrizione) {
		this.prescrizione = prescrizione;
	}

	
	@Override
	public String toString() {
		StringBuffer str=new StringBuffer();
		str.append("Visita del " + MyVarie.toStringData(data) + ", ore " + oraInizio);
		
		if(!isPrenotabile()){
			str.append("Motivo: " + motivo);
		}
		
		return str.toString();
	}
	
	/**
	 * Prenota visita.
	 *
	 * @author Tiziano Fapanni
	 * @param paziente da visitare
	 * @param motivo della visita
	 */
	public void prenotaVisita(Vino paziente, String motivo){
		prenotabile=false;
		this.paziente=paziente;
		this.motivo=motivo;
		statoVisita=StatoVisita.PRENOTATA;
	}
	
	/**
	 * Gets the paziente.
	 *
	 * @author Tiziano Fapanni
	 * @return il paziente
	 */
	public Vino getPaziente() {
		return paziente;
	}

	/**
	 * Sets the paziente.
	 *
	 * @author Tiziano Fapanni
	 * @param paziente the new paziente
	 */
	private void setPaziente(Vino paziente) {
		this.paziente = paziente;
	}

	/**
	 * Gets the motivo.
	 *
	 * @author Tiziano Fapanni
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Sets the motivo.
	 *
	 * @author Tiziano Fapanni
	 * @param motivo the new motivo
	 */
	private void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * Gets the referto.
	 *
	 * @author Tiziano Fapanni
	 * @return the referto
	 */
	public String getReferto() {
		return referto;
	}

	/**
	 * Sets the referto.
	 *
	 * @author Tiziano Fapanni
	 * @param referto the new referto
	 */
	private void setReferto(String referto) {
		this.referto = referto;
	}

	/**
	 * Gets the stato visita.
	 *
	 * @author Tiziano Fapanni
	 * @return the stato visita
	 */
	public StatoVisita getStatoVisita() {
		return statoVisita;
	}

	/**
	 * Sets the stato visita.
	 *
	 * @author Tiziano Fapanni
	 * @param statoVisita the new stato visita
	 */
	private void setStatoVisita(StatoVisita statoVisita) {
		this.statoVisita = statoVisita;
	}

	/**
	 * controlla se la visita è prenotabile.
	 *
	 * @author Tiziano Fapanni
	 * @return true, se è prenotabile
	 */
	public boolean isPrenotabile(){
		return prenotabile;
	}

	/**
	 * Gets the ora inizio.
	 *
	 * @author Tiziano Fapanni
	 * @return l'ora di inizio
	 */
	public LocalTime getOraInizio() {
		return oraInizio;
	}
	
	/**
	 * permette di eliminare la prenotazione di una visita.
	 *
	 * @author Tiziano Fapanni
	 */
	public void eliminaPrenotazioneVisita(){
		this.setPaziente(null);
		this.setMotivo(null);
		this.setStatoVisita(null);
		this.setPrescrizione(null);
		this.setReferto(null);
		this.prenotabile=true;
	}

	/**
	 * ritorna il medico.
	 *
	 * @author Tiziano Fapanni
	 * @return medico che deve svolgere la visita
	 */
	public PersonaleMedico getMedico() {
		return medico;
	}
	
	/**
	 * Gets the data.
	 *
	 * @author Tiziano Fapanni
	 * @return data della visita
	 */
	public LocalDate getData() {
		return data;
	}
	
	
	/**
	 * Conclude la visita.
	 * 
	 * @author Tiziano Fapanni
	 * @param referto  il referto
	 * @param prescrizione la prescrizione fatta dal medico.
	 */
	public void concludiVisita(String referto, String prescrizione){
		setReferto(referto);
		setPrescrizione(prescrizione);
		statoVisita=StatoVisita.CONCLUSA;
	}

	public String toStringCompleto() {
		StringBuffer str=new StringBuffer();
		
		str.append(MyVarie.toStringData(data) + ", " + oraInizio + "\n\t-Paziente: " + paziente.toStringDati() +
				"\n\t-Medico: " + medico.toStringDati()+"\n-Motivo: " + motivo);
		if(getStatoVisita().equals(StatoVisita.CONCLUSA)){
			str.append("\n-Referto: "+ referto);
			str.append("\n-Prescrizione: "+ prescrizione);
		}
		
		return str.toString();
	}
}
