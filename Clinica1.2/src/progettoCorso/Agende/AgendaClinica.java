package progettoCorso.Agende;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.Vino;
import progettoCorso.eccezioni.InvalidDateException;



/**
 *  Classe AgendaClinica.
 */
public class AgendaClinica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The agenda. */
	private HashMap<String, AgendaMedico> agenda;

	/** The elenco medici. */
	private ArrayList<PersonaleMedico> elencoMedici;


	/**
	 * Instantiates a new agenda clinica.
	 */
	public AgendaClinica() {
		agenda = new HashMap<>();
		elencoMedici=new ArrayList<>();
	}

	/**
	 * Permette di cercare tutte le visite prenotabili in un dato giorno e a una data ora.
	 *
	 * @author Tiziano Fapanni
	 * @param data the data
	 * @param ora the ora
	 * @return un ArrayList<Visita> che contiene tutti i medici disponibili la data e l'ora specificata
	 */
	public ArrayList<Visita> cercaDisponibilita(LocalDate data, LocalTime ora){
		ArrayList<Visita> visiteDisponibili= new ArrayList<>();

		for(int i=0; i<elencoMedici.size(); i++){

			if(agenda.get(elencoMedici.get(i).getCodAlfanumerico()).containsKey(data)
					&& agenda.get(elencoMedici.get(i).getCodAlfanumerico()).
					getGiornoVisita(data).containsKey(ora)
					&& agenda.get(elencoMedici.get(i).getCodAlfanumerico())
					.getGiornoVisita(data).getVisita(ora).isPrenotabile())
				visiteDisponibili.add(agenda.get(elencoMedici.get(i).getCodAlfanumerico()).getGiornoVisita(data).getVisita(ora));
		}


		return visiteDisponibili;
	}

	/**
	 * permette di cercare le disponibilità di un dato medico.
	 *
	 * @author Tiziano Fapanni
	 * @param medico the medico
	 * @return un ArrayList<Visita> che contiene tutte le visite disponibili del medico specificato
	 */
	public ArrayList<Visita> cercaDisponibilita(PersonaleMedico medico){
		LocalDate fine=LocalDate.now();
		fine.plusMonths(1);
		ArrayList<Visita> visite=new ArrayList<>();

		visite.addAll(agenda.get(medico.getCodAlfanumerico()).getVisite());

		for(int i=0; i<visite.size(); i++){
			if(!visite.get(i).isPrenotabile()){
				visite.remove(i);
				i--;
			}
		}

		return visite;
	}

	/**
	 * Cerca la prima disponibilita.
	 *
	 * @author Tiziano Fapanni
	 * @param data the data
	 * @param ora the ora
	 * @return the visita
	 */
	public Visita cercaPrimaDisponibilita(LocalDate data, LocalTime ora){
		Visita vis=new Visita(data, ora, null);
		ArrayList<Visita> visite=new ArrayList<>();
		boolean accettabile=false;

		for(int i=0; i<elencoMedici.size(); i++){
			visite.addAll(cercaDisponibilita(getMedico(i)));
		}

		for(int i=0; i<visite.size(); i++){
			if(!visite.get(i).getData().isBefore(data)){
				if(!accettabile){
					vis=visite.get(i);
					accettabile=true;
				}
				else if(!visite.get(i).getData().isAfter(vis.getData()) && visite.get(i).getOraInizio().isBefore(vis.getOraInizio())){
					vis=visite.get(i);
				}
			}
		}

		return vis;
	}

	/**
	 * genera orario visita per singolo giorno.
	 *
	 * @author Tiziano Fapanni
	 * @param medico di cui si sta generando l'orario di visita
	 * @param dInizio the d inizio
	 * @param hInizio the h inizio
	 * @param hFine the h fine
	 */
	public void generaGiorniVisitaGiorno(PersonaleMedico medico, LocalDate dInizio, LocalTime hInizio, LocalTime hFine){
		generaGiorniVisita(medico, dInizio, dInizio, hInizio, hFine);
	}

	/**
	 * genera orario visita per intervallo temporale.
	 *
	 * @author Tiziano Fapanni
	 * @param medico di cui si sta generando l'orario di visita
	 * @param dInizio the d inizio
	 * @param dFine the d fine
	 * @param hInizio the h inizio
	 * @param hFine the h fine
	 */
	public void generaGiorniVisita(PersonaleMedico medico, LocalDate dInizio, LocalDate dFine, LocalTime hInizio, LocalTime hFine ){

		if(agenda.containsKey(medico.getCodAlfanumerico())){
			AgendaMedico orarioVisita=agenda.get(medico.getCodAlfanumerico());
			orarioVisita.generaOrarioVisita(dInizio, dFine, hInizio, hFine);
			agenda.put(medico.getCodAlfanumerico(), orarioVisita);
		}
		else{
			elencoMedici.add(medico);
			AgendaMedico orarioVisita=new AgendaMedico(medico);
			orarioVisita.generaOrarioVisita(dInizio, dFine, hInizio, hFine);
			agenda.put(medico.getCodAlfanumerico(), orarioVisita);
		}
	}

	//modifica orario visita per singolo giorno
	/**
	 * Modifica giorni visita  di un singolo giorno.
	 *
	 * @author Tiziano Fapanni
	 * @param medico il medico di cui si mnodifica l'orario
	 * @param data da modificare
	 * @param nuovoInizio il nuovo orario d'inizio
	 * @param nuovaFine la nuova ora fine
	 * @throws InvalidDateException the invalid date exception
	 */
	public void modificaGiorniVisitaGiorno(PersonaleMedico medico, LocalDate data, LocalTime nuovoInizio, LocalTime nuovaFine) throws InvalidDateException{
		modificaGiorniVisita(medico, data, data, nuovoInizio, nuovaFine);
	}

	/**
	 * modifica orario visita su un periodo.
	 *
	 * @author Tiziano Fapanni
	 * @param medico di cui si sta modificando l'orario di visita
	 * @param dInizio the d inizio
	 * @param dFine the d fine
	 * @param hInizio the h inizio
	 * @param hFine the h fine
	 * @throws InvalidDateException indica che una delle date inserite è problematica
	 * @throws IllegalArgumentException nel caso il medico selezionato non ha ancora predisposto dei giorni di visita
	 */
	public void modificaGiorniVisita(PersonaleMedico medico, LocalDate dInizio, LocalDate dFine, LocalTime hInizio, LocalTime hFine) 
			throws InvalidDateException, IllegalArgumentException{

		if(agenda.containsKey(medico.getCodAlfanumerico())){
			do{

				if(agenda.get(medico.getCodAlfanumerico()).containsKey(dInizio)){
					if(!agenda.get(medico.getCodAlfanumerico()).getGiornoVisita(dInizio).isPrenotato()){
						agenda.get(medico.getCodAlfanumerico()).eliminaGiornoVisita(dInizio); //forse è necessario un controllo che non siano state prenotate visite in quei giorni!!
						agenda.get(medico.getCodAlfanumerico()).generaOrarioVisita(dInizio, dInizio, hInizio, hFine);
					}			
				}

				dInizio=dInizio.plusDays(1);
			}while(dInizio.isBefore(dFine) || dInizio.isEqual(dFine));
		}
		else throw new IllegalArgumentException("Attenzione, il medico presente non ha predisposto orari di visita!");

	}

	/**
	 * To string visite per medico.
	 *
	 * @author Tiziano Fapanni
	 * @return una String contenente tutte le visite Di un medico
	 */
	public String toStringVisitePerMedico(){
		StringBuffer str=new StringBuffer();

		for(PersonaleMedico medico: elencoMedici){
			str.append("\n\n"+agenda.get(medico.getCodAlfanumerico()).toString());
		}

		return str.toString();
	}

	/**
	 * To string visite prenotate per medico.
	 *
	 * @author Tiziano Fapanni
	 * @return the string
	 */
	public String toStringVisitePrenotatePerMedico(){
		StringBuffer str=new StringBuffer();

		for(PersonaleMedico medico: elencoMedici){
			str.append("\n"+medico.toStringDati() +"\n\t"+ agenda.get(medico.getCodAlfanumerico()).toStringPrenotate());
		}

		return str.toString();
	}

	/**
	 * To string elenco medici.
	 *
	 * @author Tiziano Fapanni
	 * @return the string
	 */
	public String toStringElencoMedici(){
		StringBuffer str=new StringBuffer();
		int i=1;
		str.append("\n");
		for(PersonaleMedico medico: elencoMedici){
			str.append(i + ")" + medico.toStringDati() + "\n");
			i++;
		}

		return str.toString();
	}

	/**
	 * Gets the numero medici.
	 *
	 * @author Tiziano Fapanni
	 * @return il numero di medici in servizio alla clinica
	 */
	public int getNumeroMedici() {
		return elencoMedici.size();
	}

	/**
	 * permette di ottenere un Medico.
	 *
	 * @author Tiziano Fapanni
	 * @param i posizione del medico nell'ArrayList
	 * @return il Medico posto in i-esima posizione nell'elencoMedici
	 */
	public PersonaleMedico getMedico(int i) {
		return elencoMedici.get(i);

	}

	/**
	 * To string dei giorni visita di tutti i medici  ordinata per data.
	 *
	 * @author Tiziano Fapanni
	 * @return the string
	 */
	public String toStringGiorniVisita() {
		StringBuffer str=new StringBuffer();

		for(PersonaleMedico medico : elencoMedici){
			str.append("\n\t-"+toStringGiorniVisita(medico));
		}

		return str.toString();
	}


	/**
	 * To string dei giorni visita  futuri di un medico.
	 *
	 * @author Tiziano Fapanni
	 * @param medico che deve svolgere tali giorni di visita
	 * @return la stringa.
	 */
	public String toStringGiorniVisita(PersonaleMedico medico){
		StringBuffer str=new StringBuffer();

		if(agenda.containsKey(medico.getCodAlfanumerico())){
			AgendaMedico agendaMedico=agenda.get(medico.getCodAlfanumerico());
			str.append(agendaMedico.toString());
		}else str.append("Il medico non ha ancora predisposto un orario di visita");

		return str.toString();
	}

	/**
	 * Metodo per la ricerca delle visite di un paziente.
	 *
	 * @author Tiziano Fapanni
	 * @param paziente di cui cercare le visite
	 * @return un ArrayList di visite  relative al paziente
	 */
	public ArrayList<Visita> cercaVisitePerPaziente(Vino paziente){
		ArrayList<Visita> elencoVisite=new ArrayList<>();

		for(AgendaMedico ag: agenda.values()){
			elencoVisite.addAll(ag.cercaVisitePerPaziente(paziente));
		}

		return elencoVisite;
	}

	/**
	 * Metodo per la ricerca delle visite (anche già svolte) di un medico.
	 *
	 * @author Tiziano Fapanni
	 * @param medico di cui cercare le visite
	 * @return un ArrayList di visite  relative al medico
	 */
	public ArrayList<Visita> cercaVisitePerMedico(PersonaleMedico medico){
		ArrayList<Visita> elencoVisite=new ArrayList<>();

		if(agenda.get(medico.getCodAlfanumerico())!=null)
			elencoVisite.addAll(agenda.get(medico.getCodAlfanumerico()).getVisite());
		return elencoVisite;

	}

	/**
	 * Metodo per la ricerca delle visite prenotate (anche già svolte) di un medico.
	 *
	 * @author Tiziano Fapanni
	 * @param medico di cui cercare le visite
	 * @return un ArrayList di visite  relative al medico
	 */
	public ArrayList<Visita> cercaVisitePrenotatePerMedico(PersonaleMedico medico){
		ArrayList<Visita> elencoVisite=new ArrayList<>();
		elencoVisite=cercaVisitePerMedico(medico);

		if(elencoMedici.contains(medico)){
			for(int i=0; i<elencoVisite.size(); i++){
				if(elencoVisite.get(i).isPrenotabile()){
					elencoVisite.remove(i);
					i--;
				}
			}
		}

		return elencoVisite;

	}

	/**
	 * Colloca una visita nell'agenda opportuna.
	 *
	 * @param vis: la visita da collocare
	 * @author Tiziano Fapanni
	 */
	public void collocaVisita(Visita vis){
		if(vis!=null){
			AgendaMedico ag= getAgendaMedico(vis.getMedico().getCodAlfanumerico());
			ag.collocaVisita(vis);
			agenda.put(vis.getMedico().getCodAlfanumerico(), ag);
		}
	}


	/**
	 * ritorna l'agenda di un medico.
	 *
	 * @param codAlfanumerico il codice alfanumerico del medico
	 * @return l'agenda medico
	 * @author Tiziano Fapanni
	 */
	private AgendaMedico getAgendaMedico(String codAlfanumerico) {
		return agenda.get(codAlfanumerico);
	}

	public ArrayList<Visita> cercaVisitePrenotatePerPaziente(
			Vino paziente) {
		ArrayList<Visita> elencoVisite=new ArrayList<>();

		elencoVisite=cercaVisitePerPaziente(paziente);

		for(int i=0; i<elencoVisite.size(); i++){
			if(elencoVisite.get(i).isPrenotabile()){
				elencoVisite.remove(i);
				i--;
			}
		}

		return elencoVisite;
	}
}
