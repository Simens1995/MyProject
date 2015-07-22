package progettoCorso.Agende;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.Vino;
import MyLib.MyVarie;

/*
 * formato della chiave: LocalDate= data
 */

/**
 * singolo giorno di visita di un medico.
 *
 * @author Tiziano Fapanni
 */
public class GiornoVisita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The Constant DURATA_VISITA. */
	public final static int DURATA_VISITA=30;

	/** The data. */
	private LocalDate data;

	/** The ora fine. */
	private LocalTime oraInizio, oraFine;

	/** The giornata. */
	private HashMap<LocalTime, Visita> giornata;

	/** The medico. */
	private PersonaleMedico medico;

	/** indica se almeno una visita è prenotata */
	private boolean prenotato;

	/**
	 * Istanzia un nuovo oggetto GiornoVisita.
	 *
	 * @param dInizio data
	 * @param hInizio2 ora inizio servisio
	 * @param hFine2 ora fine servizio
	 * @param medico medico che deve prestare servizio
	 */
	public GiornoVisita(LocalDate dInizio, LocalTime hInizio2,
			LocalTime hFine2, PersonaleMedico medico) {
		giornata=new HashMap<>();
		this.data = dInizio;
		this.oraInizio = hInizio2;	
		this.oraFine = hFine2;		
		this.medico = medico;
		prenotato=false;

		do{
			addVisita(hInizio2);
			hInizio2= hInizio2.plusMinutes(DURATA_VISITA);
		}while(hInizio2.isBefore(hFine2));
	}


	/**
	 * Aggiunge una visita.
	 *
	 * @param vis: nuova visita da inserire
	 * @author Tiziano Fapanni
	 */
	//non funziona
	public void addVisita(Visita vis){
		LocalTime oraVisita=vis.getOraInizio();
		giornata.put(oraVisita, vis);

		prenotato=isPrenotato();
	}

	/**
	 * Aggiunge una visita.
	 *
	 * @author Tiziano Fapanni
	 * @param hInizio ora di inizio della visita
	 */
	public void addVisita(LocalTime hInizio){
		giornata.put(hInizio, new Visita(data, hInizio, medico));
		prenotato=isPrenotato();
	}

	/**
	 * Gets the data.
	 *
	 * @author Tiziano Fapanni
	 * @return la data
	 */
	public LocalDate getData() {
		return data;
	}


	/**
	 * restituisce la visita.
	 *
	 * @author Tiziano Fapanni
	 * @param ora di inizio della visita
	 * @return la visita
	 */
	public Visita getVisita(LocalTime ora){
		return giornata.get(ora);
	}

	/**
	 * Gets the ora inizio.
	 *
	 * @return l'ora di inizio
	 * @author Tiziano Fapanni
	 */
	public LocalTime getOraInizio() {
		return oraInizio;
	}

	/**
	 * Gets the ora fine.
	 *
	 * @return l'ora di fine
	 * @author Tiziano Fapanni
	 */
	public LocalTime getOraFine() {
		return oraFine;
	}


	//**************************************************************************************************************************
	//														TOSTRING!
	//**************************************************************************************************************************

	@Override
	public String toString() {
		return MyVarie.toStringData(data) + " Inizio Servizio ore " + oraInizio
				+ ", fine servizio ore " + oraFine;
	}


	/**
	 * To string visite.
	 *
	 * @return una string contenente tutte le visite disponibili 
	 * @author Tiziano Fapanni
	 */
	public String toStringVisite(){
		StringBuffer str=new StringBuffer();

		for(Visita vis: giornata.values()){
			str.append("\n\t- " + vis.toString());
		}

		return str.toString();
	}

	/**
	 * To string delle visite prenotabili.
	 *
	 * @return una string contenente tutte le visite prenotabili
	 * @author Tiziano Fapanni
	 */
	public String toStringPrenotabili() {
		StringBuffer str=new StringBuffer();
		LocalTime ora= oraInizio;
		int n=0;

		str.append(toString());
		while(n<giornata.size()){
			if(giornata.containsKey(ora) && giornata.get(ora).isPrenotabile()){
				str.append("\n\t- " + giornata.get(ora).toString());
				n++;
			}
			ora=ora.plusMinutes(DURATA_VISITA);
		}

		return str.toString();
	}


	/**
	 * Esiste una visita che inizia a un ora specificata
	 *
	 * @param ora di inizio della visita
	 * @return true, se esiste una data corrispondente all'orario scelto
	 * @author Tiziano Fapanni
	 */
	public boolean containsKey(LocalTime ora) {
		return giornata.containsKey(ora);
	}


	/**
	 * Controlla se esiste almeno una visita prenotata.
	 *
	 * @return true, if is prenotato
	 * @author Tiziano Fapanni
	 */
	public boolean isPrenotato() {
		for (Visita vis : giornata.values()) {
			if(!vis.isPrenotabile()){
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo per la ricerca delle visite di un paziente
	 * @param paziente di cui cercare le visite
	 * @return un ArrayList di visite  relative al paziente
	 * @author Tiziano Fapanni
	 */
	public ArrayList<Visita> cercaVisitePerPaziente(Vino paziente){
		ArrayList<Visita> elencoVisite=new ArrayList<>();
		elencoVisite.addAll(giornata.values());
		int n=giornata.values().size();
		for(int i=0; i<n; i++){
			if(elencoVisite.get(i)!=null){
				if(elencoVisite.get(i).getPaziente()!=null &&
						!elencoVisite.get(i).getPaziente().getCodiceFiscale()
						.equals(paziente.getCodiceFiscale())){
					elencoVisite.remove(i);
					i--;
					n--;
				}
			}
		}

		return elencoVisite;
	}

	/**
	 * restituisce tutte le visite (svolte, prenotate e disponibili) del medico
	 * @return un ArrayList contenente tutte le visite
	 * @author Tiziano Fapanni
	 */
	public ArrayList<Visita> getVisite() {
		ArrayList<Visita> elencoVisite=new ArrayList<>();
		elencoVisite.addAll(giornata.values());
		return elencoVisite;
	}

	
	/**
	 * To string delle visite prenotate prenotate.
	 *
	 * @return una String contenente l'elenco delle visite prenotate
	 * @author Tiziano Fapanni
	 */
	public String toStringPrenotate() {
		StringBuffer str=new StringBuffer();
		if(giornata.values().size()>0){
			for(Visita visita: giornata.values()){
				if(!visita.isPrenotabile()){
					str.append("\n\t-"+visita.toString());
				}
			}
		}
		return str.toString();

	}

}
