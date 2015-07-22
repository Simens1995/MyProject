package progettoCorso.Agende;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.Vino;
import progettoCorso.GestioneUtenze.*;

/*
 * formato chiave: stringa: codiceMedico 
 */

/**
 * Classe che contiene tutti i giorni di visita di un dato medico.
 *
 * @author Tiziano Fapanni
 */
public class AgendaMedico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The medico. */
	private PersonaleMedico medico;

	/** The agenda. */
	private HashMap<LocalDate, GiornoVisita> agenda;

	/** The formatter giorni. */
	private static DateTimeFormatter formatterGiorni = DateTimeFormatter.ofPattern("dd MM yyyy");

	/** The formatter ora. */
	private static DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("hh:mm");
	
	private static final String ERRORE_MEDICO_NO_GIORNI_VISITA="Questo medico non ha predisposto nessun giorno di visita!";
	


	/**
	 * Istanzia una nuova agenda medico.
	 *
	 * @author Tiziano Fapanni
	 * @param medico a cui fa riferimento l'agenda
	 */
	public AgendaMedico(PersonaleMedico medico) {
		this.medico = medico;
		agenda = new HashMap<>();
	}


	/**
	 * Per generare diversi giorni di visita contigui in tutti i giorni di apertura della clinica
	 * (ad eccezione del weekend quindi).
	 *
	 * @author Tiziano Fapanni
	 * @param dataDiInizio data di inizio servizio
	 * @param dataDiFine data di fine servizio
	 * @param oraDiInizio ora di inizio servizio
	 * @param oraDiFine l'ora di fine servizio
	 */
	public void generaOrarioVisita(LocalDate dataDiInizio, LocalDate dataDiFine, 
			LocalTime oraDiInizio, LocalTime oraDiFine ){
		//int i=0;
		do{
			if(dataDiInizio.getDayOfWeek()!=DayOfWeek.SUNDAY && dataDiInizio.getDayOfWeek()!=DayOfWeek.SATURDAY){
				agenda.put(dataDiInizio, new GiornoVisita(dataDiInizio, oraDiInizio, oraDiFine, medico));
			}
			dataDiInizio=dataDiInizio.plusDays(1);
		}while(dataDiFine.isAfter(dataDiInizio));
	}


	/**
	 * Elimina giorno visita.
	 *
	 * @author Tiziano Fapanni
	 * @param key the key
	 */
	public void eliminaGiornoVisita(LocalDate key){
		agenda.remove(key);
	}


	/**
	 * Gets the medico.
	 *
	 * @author Tiziano Fapanni
	 * @return il medico scelto
	 */
	public PersonaleMedico getMedico() {
		return medico;
	}

	@Override
	public String toString() {
		StringBuffer str=new StringBuffer();
		str.append(medico.getCognome() + ": ");

		if(agenda.size()>0){
			for(GiornoVisita giornata: agenda.values()){
				str.append("\n\t- " + giornata.toString());
			}
		}
		else {
			str.append(ERRORE_MEDICO_NO_GIORNI_VISITA);
		}
		return str.toString();
	}

	/**
	 * Gets the giorno visita.
	 *
	 * @author Tiziano Fapanni
	 * @param data di svolgimento della visita
	 * @return il giorno visita
	 */
	public GiornoVisita getGiornoVisita(LocalDate data){
		return agenda.get(data);
	}


	/**
	 * To string delle visite prenotabili.
	 *
	 * @author Tiziano Fapanni
	 * @return the string
	 */
	public String toStringPrenotabili() {
		StringBuffer str=new StringBuffer();
		str.append(medico.getNome() + ": ");

		for(GiornoVisita giornata: agenda.values()){
			str.append("\n\t- " + giornata.toStringPrenotabili());
		}

		return str.toString();

	}


	/**
	 * permette di ottenere il numero di giorni di visita.
	 *
	 * @author Tiziano Fapanni
	 * @return  il numero giorni di visita del medico
	 */
	public int getNumeroGiorni() {
		return agenda.size();
	}


	/**
	 * Contains key: verifica se l'agenda contiene un dato giorno di visita.
	 *
	 * @author Tiziano Fapanni
	 * @param giorno di visita di cui si vuole verificare l'esistenza
	 * @return true se il giorno di visita esiste
	 */
	public boolean containsKey(LocalDate giorno) {
		return agenda.containsKey(giorno);
	}

	/**
	 * Metodo per la ricerca delle visite di un paziente.
	 *
	 * @author Tiziano Fapanni
	 * @param paziente di cui cercare le visite
	 * @return un ArrayList di visite  relative al paziente
	 */
	public ArrayList<Visita> cercaVisitePerPaziente(Vino paziente) {
		ArrayList<Visita> elencoVisite=new ArrayList<>();

		for(GiornoVisita giornoVisita: agenda.values()){

			elencoVisite.addAll(giornoVisita.cercaVisitePerPaziente(paziente));
		}
		return elencoVisite;
	}

	/**
	 * restituisce tiutte le visite (svolte, prenotate e disponibili) del medico.
	 *
	 * @author Tiziano Fapanni
	 * @return un ArrayList contenente tutte le visite
	 * @throws NullPointerException se non  ci sono elementi nel vettore
	 */
	public ArrayList<Visita> getVisite() {
		ArrayList<Visita> elencoVisite=new ArrayList<>();

		for(GiornoVisita giornoVisita: agenda.values()){
			elencoVisite.addAll(giornoVisita.getVisite());
		}

		if(elencoVisite.size()>0){
			return elencoVisite;
		}
		else throw new NullPointerException();
	}


	/**
	 * Colloca una visita nel suo giorno di visita.
	 *
	 * @param vis: la visita da collocare
	 * @author Tiziano Fapanni
	 */
	public void collocaVisita(Visita vis) {
		GiornoVisita giorno=agenda.get(vis.getData());
		giorno.addVisita(vis);
		agenda.put(giorno.getData(), giorno);
	}

	

	/**
	 * To string delle sole visite prenotate.
	 *
	 * @return una string contenente tutte le visite prenotate
	 * @author Tiziano Fapanni
	 */
	public String toStringPrenotate() {
		StringBuffer str=new StringBuffer();

		for(GiornoVisita giornoVisita: agenda.values()){
			str.append(giornoVisita.toStringPrenotate());
		}
		return str.toString();
	}

}
