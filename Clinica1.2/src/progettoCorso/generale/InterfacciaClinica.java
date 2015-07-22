package progettoCorso.generale;

import static progettoCorso.GestioneUtenze.Costanti.*;

import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import progettoCorso.Agende.AgendaClinica;
import progettoCorso.Agende.GiornoVisita;
import progettoCorso.Agende.Visita;
import progettoCorso.GestioneUtenze.Genere;
import progettoCorso.GestioneUtenze.MediciOspedale;
import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.TipologiaMedico;
import progettoCorso.GestioneUtenze.Vino;
import progettoCorso.GestioneUtenze.UtentiOspedale;
import progettoCorso.eccezioni.InvalidDateException;
import MyLib.MyMenu;
import MyLib.MyScelta;
import MyLib.MyVarie;
import MyLib.MyIO.MyIOFile;
import MyLib.MyIO.MyIOconsole;

/**
 * The Class InterfacciaClinica.
 */
public class InterfacciaClinica {

	/** The clinica. */
	private Clinica clinica;

	/**
	 * Instantiates a new interfaccia clinica.
	 */
	public InterfacciaClinica(){
		clinica = new Clinica();
	}


	/**
	 * menu principale delle agende permette di:
	 * 	-uscire (per andare a un livello superiore)
	 * 	-gestire le visite
	 * 	-gestire gli orari di visita.
	 *
	 * @author Tiziano Fapanni
	 */
	public void menuAgende(){
		MyMenu menuPrincipale= new MyMenu(TITOLO_PRINCIPALE, SCELTE_PRINCIPALI);
		boolean finito=false;

		do{
			int scelta=menuPrincipale.scegli(true);

			switch(scelta){
			case 0: 
				finito=true;
				break;
			case 1:						//visite
				gestisciVisite();
				break;
			case 2:						//orari di visita
				gestisciOrarioVisita();
				break;
			}
		}while(!finito);
	}

	/**
	 * menu per gestire gli orari di visita
	 * permette di:
	 * 	-uscire
	 * 	-visualizzare le visite (ordinate per medico)
	 * 	-visualizzare le visite prenotate (ordinate per medico)
	 * 	-prenotare una visita
	 * 		+selezionando un medico
	 * 		+selezionando una data e un ora (in caso non ci siano disponibilità propone la prima data successiva disponibile)
	 * 	-modificare una prenotazione.
	 *  -cancella la visita
	 *  - ricerca visite prenotate
	 *  	+per medico
	 *  	+per utente
	 *
	 * @author Tiziano Fapanni
	 */
	private void gestisciVisite() {
		MyMenu menuVisite= new MyMenu(TITOLO_VISITE, SCELTE_VISITE);
		boolean finito=false;
		AgendaClinica agenda;

		do{
			int scelta=menuVisite.scegli(true);

			switch(scelta){
			case 0: 						//esci
				finito=true;
				break;
			case 1:							 //visualizza visite
				if(clinica.getAgenda().getNumeroMedici()>0){
					System.out.println(clinica.getAgenda().toStringVisitePerMedico());
				}else{
					System.out.println(VISITE_NON_DISPONIBILI);
				}

				break;
			case 2: 						//visualizza visite prenotate
				if(clinica.getAgenda().getNumeroMedici()>0){
					System.out.println(clinica.getAgenda().toStringVisitePrenotatePerMedico());
				}else{
					System.out.println(VISITE_NON_DISPONIBILI);
				}
				break;
			case 3:							 //prenota visita
				if(clinica.getElencoUtenti().getNumeroUtenti()>0){
					MyScelta sceltaDue=new MyScelta(M, D, SCELTA_METODO_PRENOTAZIONE);
					if(clinica.getAgenda().getNumeroMedici()>0){
						if(sceltaDue.sceltaDueVie()){
							//selezione in base al medico
							ArrayList<Visita> visiteDisponibili=clinica.getAgenda().cercaDisponibilita(selezionaMedicoAgenda());

							if(visiteDisponibili.size()!=0){							
								Visita tmp=selezionaVisita(visiteDisponibili);
								tmp.prenotaVisita(selezionaPaziente(), inserisciMotivo());
								agenda=clinica.getAgenda();
								agenda.collocaVisita(tmp);
								clinica.setAgenda(agenda);

							}
							else{
								System.out.println(VISITE_NON_DISPONIBILI);
							}

						}
						else{
							//selezione in base alla data e all'ora;
							LocalDate dataVisita=inserisciDataFutura();
							LocalTime oraVisita= inserisciOra();
							ArrayList<Visita> visiteDisponibili=clinica.getAgenda().cercaDisponibilita(dataVisita, oraVisita);

							if(visiteDisponibili.size()!=0){							
								Visita tmp=selezionaVisita(visiteDisponibili);
								tmp.prenotaVisita(selezionaPaziente(), inserisciMotivo());
								agenda=clinica.getAgenda();
								agenda.collocaVisita(tmp);
								clinica.setAgenda(agenda);
							}
							else{
								System.out.println(NON_DISPONIBILI);
								Visita visiteDisponibiliDopo;

								visiteDisponibiliDopo=clinica.getAgenda().cercaPrimaDisponibilita(dataVisita, oraVisita);
								MyScelta accettaNuovaVisita=new MyScelta(S, N, visiteDisponibiliDopo.toString() + DISPONIBILE);

								if(accettaNuovaVisita.sceltaDueVie()){
									agenda=clinica.getAgenda();
									visiteDisponibiliDopo.prenotaVisita(selezionaPaziente(), inserisciMotivo());
									agenda.collocaVisita(visiteDisponibiliDopo);
									clinica.setAgenda(agenda);
									System.out.println(RIUSCITA);
								}
							}
						}		
					}
					else{
						System.out.println(ERRORE_NO_MEDICI);
					}
				}else{
					System.out.println(ERRORE_NO_PAZIENTI);
				}
				
				break;
			case 4:				//modifica prenotazioni
				if(clinica.getAgenda().getNumeroMedici()>0){
					Visita vis=ricercaVisitaPrenotata();
					agenda=clinica.getAgenda();
					vis=modificaVisita(vis);
					agenda.collocaVisita(vis);
					clinica.setAgenda(agenda);
				}
				break;
			case 5:				//elimina visita
				if(clinica.getAgenda().getNumeroMedici()>0){
					Visita visita=ricercaVisitaPrenotata();
					MyScelta richiestaConferma=new MyScelta(S, N, SICURO + SI_NO);
					if(visita!=null && richiestaConferma.sceltaDueVie() )
						visita.eliminaPrenotazioneVisita();
					agenda=clinica.getAgenda();
					agenda.collocaVisita(visita);
					clinica.setAgenda(agenda);
				}
				break;
			case 6: 				//ricerca visite
				if(clinica.getAgenda().getNumeroMedici()>0){
					Visita visitaCercata=ricercaVisitaPrenotata();

					if(visitaCercata!=null){
						System.out.println(visitaCercata.toStringCompleto());
					}else{
						System.out.println(ERRORE_MEDICO);
					}
				}
				break;
			case 7: //concludi visita
				Visita visitaDaConcludere=ricercaVisitaPrenotata();
				visitaDaConcludere.concludiVisita(MyIOconsole.leggiStringa(INS_REFERTO),
						MyIOconsole.leggiStringa(INS_PRESCRIZIONE));
				agenda=clinica.getAgenda();
				agenda.collocaVisita(visitaDaConcludere);
				clinica.setAgenda(agenda);
				break;

			}
		}while(!finito);
	}

	
	/**
	 * Modifica visita.
	 *
	 * @param vis the vis
	 * @return the visita
	 * @author Andrea Lorenzoni
	 */
	private Visita modificaVisita(Visita vis) {

		MyMenu menuModifica=new MyMenu(TITOLO_MODIFICA_VISITA, SCELTE_MODIFICA_VISITA);
		boolean finito=false;

		do{
			int scelta=menuModifica.scegli(true);

			switch(scelta){
			case 0: //uscita
				finito=true;
				break;
			case 1: //elimina prenotazione
				vis.eliminaPrenotazioneVisita();
				break;
			case 2: //cambia paziente
				vis.eliminaPrenotazioneVisita();
				vis.prenotaVisita(selezionaPaziente(), inserisciMotivo());
				break;
			}
		}while(!finito);

		return vis;
	}


	/**
	 * permette di cercare una visita da processare
	 * @return una visita selezionata
	 * @author Tiziano Fapanni
	 */
	private Visita ricercaVisita(){
		MyScelta sceltaRicerca=new MyScelta(M, P, RICERCA_MEDICO_PAZIENTE);
		Visita visita;
		if(sceltaRicerca.sceltaDueVie()){
			//per medico
			visita=selezionaVisita(clinica.getAgenda().cercaVisitePerMedico(selezionaMedicoAgenda()));
		}
		else{
			//per utente
			visita=selezionaVisita(clinica.getAgenda().cercaVisitePerPaziente(selezionaPaziente()));
		}
		//NB sono presentate anche le visite già svolte!
		return visita;
	}

	/**
	 * permette di cercare una visita prenotata da processare
	 * @return una visita selezionata
	 * @author Tiziano Fapanni & Andrea Lorenzoni
	 */
	private Visita ricercaVisitaPrenotata(){	

		MyScelta sceltaRicerca=new MyScelta(M, P, RICERCA_MEDICO_PAZIENTE);
		Visita visita=null;
		if(sceltaRicerca.sceltaDueVie()){
			//per medico
			PersonaleMedico medico=selezionaMedicoAgenda();
			ArrayList<Visita> elencoVisite=clinica.getAgenda().cercaVisitePrenotatePerMedico(medico);
			if(elencoVisite.size()>0){
				visita=selezionaVisita(elencoVisite);
			}
		}
		else{
			//per utente
			ArrayList<Visita> elencoVisite=clinica.getAgenda().cercaVisitePrenotatePerPaziente(selezionaPaziente());
			if(elencoVisite.size()>0){
				visita=selezionaVisita(elencoVisite);
			}
		}
		//NB sono presentate anche le visite già svolte!

		return visita;
		
	}

	/**
	 * metodo per la richiesta di immissione di un motivo di richiesta di una visita.
	 *
	 * @author Tiziano Fapanni
	 * @return il motivo della visita
	 */
	private String inserisciMotivo() {
		String str=MyIOconsole.leggiStringa("inserisci il motivo della visita");
		return str;
	}

	/**
	 * permette di inserire un paziente che richiede una visita.
	 *
	 * @author Andrea Lorenzoni
	 * @return l'utente specificato.
	 */
	private Vino selezionaPaziente() {
		int scelta=MyIOconsole.leggiIntero(("Seleziona il paziente: " + clinica.getElencoUtenti().toStringDati()), 1, clinica.getElencoUtenti().getNumeroUtenti());
		return clinica.getElencoUtenti().getUtente(scelta-1);
	}

	/**
	 * permette di selezionare una visita fra alcune immesse come input.
	 *
	 * @author Tiziano Fapanni
	 * @param visite the visite
	 * @return la visita selezionata.
	 */
	private Visita selezionaVisita(ArrayList<Visita> visite) {
		StringBuffer str=new StringBuffer();

		for(int i=0; i<visite.size(); i++){
			str.append("\n\t-" + (i+1) + ")" + visite.get(i).toString() +";");
		}

		return visite.get(MyIOconsole.leggiIntero(SELEZIONA_VISITA + str.toString() + SCELTA_EFFETTUATA, 1, visite.size())-1);
	}


	/**
	 * metodo per la gestione degli orari di visita
	 * 	-uscire
	 * 	-visualizza orario visita 
	 * 		+generale (tutti i medici)
	 * 		+di un singolo medico
	 * 	-imposta nuovo orario visita (dato un medico)
	 * 	-modifica orario visita (di un dato medico).
	 *
	 * @author Tiziano Fapanni
	 */
	private void gestisciOrarioVisita() {
		MyMenu menu= new MyMenu(T_ORARIO_VISITE, S_ORARIO_VISITE); 

		boolean finito=false;
		AgendaClinica agenda;

		do{
			int scelta=menu.scegli(true);
			switch (scelta){
			case 0: //esci
				finito=true;
				break;
			case 1: //visualizza orario visita
				MyScelta sceltaVisualizza=new MyScelta(G, M, SCELTA_MEDICO_GENERALE);

				if(sceltaVisualizza.sceltaDueVie()){//visualizza generale
					System.out.println(clinica.getAgenda().toStringGiorniVisita());
				}
				else{//visualizza per medico
					System.out.println(clinica.getAgenda().toStringGiorniVisita(selezionaMedicoAgenda()));
				}
				break;

			case 2: //imposta un nuovo orario di visita
				MyScelta sceltaGenera=new MyScelta(S, P, SCELTA_SINGOLO_PERIODO);
				if(clinica.getElencoMedici().getNumeroMedici()>0){
					if(!sceltaGenera.sceltaDueVie()){//periodo
						agenda=clinica.getAgenda();
						PersonaleMedico mdc=selezionaMedico();

						System.out.println(INSERISCI_DATA_INIZIO);
						LocalDate dInizio=inserisciDataFutura();
						System.out.println(INSERISCI_DATA_FINE);
						LocalDate dFine=inserisciDataFutura();
						System.out.println(INSERISCI_ORA_INIZIO);
						LocalTime hInizio=inserisciOra();
						LocalTime hFine;

						do{
							System.out.println(INSERISCI_ORA_FINE);
							hFine=inserisciOra();
						}while(hFine.isBefore(LocalTime.of(Clinica.ORA_CHIUSURA, 00)));

						agenda.generaGiorniVisita(mdc,dInizio , dFine, hInizio, hFine);
						clinica.setAgenda(agenda);
					}
					else{ //singolo giorno
						agenda=clinica.getAgenda();
						PersonaleMedico mdc=selezionaMedico();

						System.out.println(INSERISCI_DATA_INIZIO);
						LocalDate dInizio=inserisciDataFutura();
						System.out.println(INSERISCI_ORA_INIZIO);
						LocalTime hInizio=inserisciOra();
						System.out.println(INSERISCI_ORA_FINE);
						LocalTime hFine=inserisciOra();

						agenda.generaGiorniVisitaGiorno(mdc, dInizio, hInizio, hFine);
						clinica.setAgenda(agenda);
					}
				}
				break;

			case 3: //modifica orario visita
				MyScelta sceltaModifica=new MyScelta(S, P, SCELTA_SINGOLO_PERIODO);
				if(sceltaModifica.sceltaDueVie()){ //singolo giorno
					try {
						agenda=clinica.getAgenda();
						PersonaleMedico mdc=selezionaMedico();
						if(agenda.cercaDisponibilita(mdc).size()>0){

							System.out.println(INSERISCI_DATA_INIZIO);
							LocalDate dInizio=inserisciDataFutura();
							System.out.println(INSERISCI_ORA_INIZIO);
							LocalTime hInizio=inserisciOra();
							System.out.println(INSERISCI_ORA_FINE);
							LocalTime hFine=inserisciOra();
							agenda.modificaGiorniVisitaGiorno(mdc, dInizio, hInizio, hFine);
							clinica.setAgenda(agenda);
						}else{
							System.out.println(ERRORE_MEDICO);
						}
					} catch (InvalidDateException e) {
						System.out.println(OP_IMPOSSIBILE_VISITE_GIA_PRENOTATE);
					} catch (IllegalArgumentException e){
						System.out.println(ERRORE);
					} catch (NullPointerException e){
						System.out.println(ERRORE);
					}
				}
				else{ //periodo di disponibilità
					try {
						agenda=clinica.getAgenda();

						PersonaleMedico mdc=selezionaMedico();
						System.out.println(INSERISCI_DATA_INIZIO);
						LocalDate dInizio=inserisciDataFutura();
						System.out.println(INSERISCI_DATA_FINE);
						LocalDate dFine=inserisciDataFutura();
						System.out.println(INSERISCI_ORA_INIZIO);
						LocalTime hInizio=inserisciOra();
						System.out.println(INSERISCI_ORA_FINE);
						LocalTime hFine=inserisciOra();
						agenda.modificaGiorniVisita(mdc,dInizio , dFine, hInizio, hFine);
						clinica.setAgenda(agenda);
					} catch (InvalidDateException e) {//da finire di mettere a posto!
						System.out.println(OP_IMPOSSIBILE_VISITE_GIA_PRENOTATE);
					} catch (IllegalArgumentException e){
						System.out.println(ERRORE);
					}
				}
				break;
			}
		}while(!finito);
	}


	/**
	 * Seleziona medico fra quelli che lavorano alla clinica.
	 *
	 * @author Tiziano Fapanni
	 * @return un medico
	 */
	private PersonaleMedico selezionaMedico() {
		int scelta=MyIOconsole.leggiIntero((SCEGLI_MEDICO + clinica.getElencoMedici().toStringDati() + SCELTA_EFFETTUATA), 0, clinica.getElencoMedici().getNumeroMedici());
		return clinica.getElencoMedici().getMedico(scelta-1);
	}


	/**
	 * permette di inserire un orario (compreso nell'apertura della clinica e con minuti pari a 0 o 30).
	 *
	 * @author Tiziano Fapanni
	 * @return la data richiesta
	 */
	private LocalTime inserisciOra() {
		LocalTime rifApertura=LocalTime.of(Clinica.ORA_APERTURA, 0);
		LocalTime rifChiusura=LocalTime.of(Clinica.ORA_CHIUSURA, 0);
		LocalTime ora;

		do{
			try{
				do{
					ora=LocalTime.of(MyIOconsole.leggiIntero(INS_ORA, Clinica.ORA_APERTURA, Clinica.ORA_CHIUSURA), 
							MyIOconsole.leggiIntero(INS_MINUTO, 0, 59 ));
				}while(ora.isBefore(rifApertura) || ora.isAfter(rifChiusura));

				if(ora.getMinute()==0 || ora.getMinute()==30)
					return ora;
				else
				{
					System.out.println(ERRORE_ORARIO);
					if(ora.getMinute()<QUARTO_ORA){
						ora=LocalTime.of(ora.getHour(), 0);
					}
					else if(ora.getMinute()<2*QUARTO_ORA){
						ora=LocalTime.of(ora.getHour(), 2*QUARTO_ORA);
					}
					else if(ora.getMinute()<3*QUARTO_ORA){
						ora=LocalTime.of(ora.getHour(), 2*QUARTO_ORA);
					}
					else if(ora.getMinute()<59){
						ora=LocalTime.of(ora.getHour() + 1, 0);
					}
				}

				return ora;
			}
			catch (DateTimeException e){
				System.out.println(ERRORE_ORARIO);
			}
		}while(true);


	}

	/**
	 * permette di inserire una data collocata nel fututro rispetto al giorno segnalato dalla macchina.
	 *
	 * @author Tiziano Fapanni
	 * @return la data richiesta
	 */
	private LocalDate inserisciDataFutura() {
		LocalDate rif=LocalDate.now();
		LocalDate data;
		do{
			try{
				do{
					data=LocalDate.of(MyIOconsole.leggiIntero(INS_ANNO,
							rif.getYear(), ANNO_MAX ), MyIOconsole.leggiIntero(INS_MESE, 1, 12 ),
							MyIOconsole.leggiIntero(INS_GIORNO, 1, 31 ));
				}while(data.isBefore(rif));
				return data;
			}
			catch(DateTimeException e){
				System.out.println(ERRORE_DATA);
			}
		}while(true);

	}

	/**
	 * permette di inserire una data.
	 *
	 * @author Tiziano Fapanni
	 * @return la data richiesta
	 */
	private LocalDate inserisciData(){
		LocalDate data;

		do{
			try{
				data=LocalDate.of(MyIOconsole.leggiIntero(INS_ANNO,
						1900, ANNO_MAX ), MyIOconsole.leggiIntero(INS_MESE, 1, 12 ),
						MyIOconsole.leggiIntero(INS_GIORNO, 1, 31 ));

				return data;
			}
			catch(DateTimeException e){
				System.out.println(ERRORE_DATA);
			}
		}while(true);

	}



	/**
	 * permette di selezionare un medico presente in agenda.
	 *
	 * @author Tiziano Fapanni
	 * @return un medico
	 */
	private PersonaleMedico selezionaMedicoAgenda() {
		int scelta;
		do{
			scelta=MyIOconsole.leggiIntero((SCEGLI_MEDICO + 

					clinica.getAgenda().toStringElencoMedici() + SCELTA_EFFETTUATA), 
					1, clinica.getAgenda().getNumeroMedici());
		}while(scelta<0);

		return clinica.getAgenda().getMedico(scelta-1);
	}

	
	/*
	 * -------- PARTE SIMAZ -----------
	 */

	/**
	 * Menù principale per la gestione delle utenze permette di:
	 * _Uscire (per andare a un livello superiore);
	 * _Gestire i medici dell'ospedale;
	 * _Gestire gli utenti dell'ospedale;.
	 * @Author Simaz Andrea
	 */
	public void MenuUtenze(){

		MyMenu menuPrincipale= new MyMenu(TITOLO_UTENZE, SCELTE_UTENZE);
		boolean finito=false;

		do{
			int scelta=menuPrincipale.scegli(true);

			switch(scelta){
			case 0: 
				finito=true;
				break;
			case 1:            //Gestione Medici
				gestisciMedici();
				break;
			case 2:			   //Gestione Utenti
				gestisciUtenti();
				break;
			}
		}while(!finito);
	}

	/**
	 * Menù per la  GESTIONE DI UN MEDICO:
	 * Essa permette di :
	 * _Stampare la lista dei medici (solo dati significativi);
	 * _Aggiungere un nuovo medico;
	 * _Cercare un medico mediante relativo codice alfaNumerico;
	 * _Licenziare un medico mediante relativo codice alfaNumerico;
	 * _Aggiornare un medico mediante relativo codice alfaNumerico;
	 * _Cercare un medico (inserimento completo dati);
	 * _Licenziare un medico (inserimento completo dati);
	 * _Stampare la lista dei medici (con tutti i dati).
	 * @Author Simaz Andrea
	 */
	public void gestisciMedici(){
		MyMenu menuMedici = new MyMenu(TITOLO_MEDICI, SCELTE_MEDICI);
		boolean finito=false;
		MediciOspedale medici;

		do{
			int scelta = menuMedici.scegli(true);

			switch(scelta){
			case 0:               //esci
				finito=true;
				break;
			case 1:               //Visualizza lista medici (solo dati fondamentali)
				if(clinica.getElencoMedici().getNumeroMedici() != 0){
					System.out.println(clinica.getElencoMedici().toStringDati());
				}
				else System.out.println(NO_MEDICI);
				break;
			case 2: //aggiungi medico
				try{
					PersonaleMedico nuovoMedico = aggiungiParametri();
					medici=clinica.getElencoMedici();
					medici.aggiungiMedico(nuovoMedico);	
					clinica.setElencoMedici(medici);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 3:                //Cerca Medico usando codice alfanumerico
				try{
					medici = clinica.getElencoMedici();
					int indice = (clinica.getElencoMedici().cercaMedicoCod(MyIOconsole.leggiStringa(IMMETTI_COD_A)));
					System.out.println(medici.getMedico(indice).toString());
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 4:                //Licenzia medico usando codice alfanumerico
				try{
					medici = clinica.getElencoMedici();
					medici.eliminaMedicoCod(MyIOconsole.leggiStringa(IMMETTI_COD_A));
					clinica.setElencoMedici(medici);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 5:   //Aggiorna Medico
				try{
					medici=clinica.getElencoMedici();
					PersonaleMedico medico=medici.getMedico(clinica.getElencoMedici().cercaMedicoCod(MyIOconsole.leggiStringa(IMMETTI_COD_A)));
					aggiornaMedico(medico);
					medici.inserisciMedico(medico);
					clinica.setElencoMedici(medici);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 6:                //elimina medico usando tutti i parametri
				try{
					medici = clinica.getElencoMedici();
					medici.eliminaMedicoNoCod(aggiungiParametri());
					clinica.setElencoMedici(medici);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 7:     		   //Stampa lista medici (completa)
				if(clinica.getElencoMedici().getNumeroMedici() != 0){     
					System.out.println(clinica.getElencoMedici().toString());
				}
				else System.out.println(NO_MEDICI);
				break;
			}
		}while(!finito);
	}

	/**
	 * Questo metodo permette di aggiungere i parametri richiesti da un oggetto di tipo PersonaleMedico.
	 * @Author Simaz Andrea e Lorenzoni Andrea
	 * @return PersonaleMedico medico (Istanza della classe PersonaleMedico)
	 */
	private PersonaleMedico aggiungiParametri(){  

		PersonaleMedico medico = new PersonaleMedico(MyIOconsole.leggiParola(INS_NOME), MyIOconsole.leggiParola(INS_COG),
				MyIOconsole.leggiStringa(INS_LUOGO_NAS), MyIOconsole.leggiStringa(INS_TEL), inserisciData(), scegliGen(),
				insCodice(), MyIOconsole.leggiIntero(INS_CAP), scegliTip());

		return medico;	

	}

	/**
	 * Inserimento del codice Fiscale.
	 *
	 * @author Andrea Simaz
	 * @return Codice fiscale: _Se l'immissione è avvenuta correttamente,
	 * 						   _Richiede il codice fiscale, se l'immissione non è avvenuta correttamente;
	 */
	private String insCodice(){
		boolean valido = true;
		do{
			String cod = MyIOconsole.leggiStringa(INS_COD_FISC);
			if(MyVarie.validCodFiscale(cod)){
				valido = false;
				return cod;
			}
			else{
				System.out.println(NON_VALIDO);
			}
		}while(valido);
		return VUOTA;
	}

	/**
	 * Scegli il genere della Persona.
	 * @return MASCHIO, se digiti m,
	 *    	   FEMMINA, se digiti f.
	 * @author Andrea Lorenzoni 
	 */
	private Genere scegliGen(){
		@SuppressWarnings("unused")
		Genere genere;
		MyScelta scelta = new MyScelta(M, F, MASC_O_FEMM);
		if(scelta.sceltaDueVie()){
			return genere = Genere.MASCHIO;
		}
		else return genere = Genere.FEMMINA;
	}

	/**
	 * Scegli la tipologia del Medico.
	 * @Author Lorenzoni Andrea
	 * @return GENERICO, se digiti g,
	 *         SPECIALISTA, se digiti s
	 */
	private TipologiaMedico scegliTip(){
		MyScelta scelta = new MyScelta('g', 's', GEN_O_SPEC);
		if(scelta.sceltaDueVie()){
			return TipologiaMedico.GENERICO;
		}
		else return TipologiaMedico.SPECIALISTA;
	}

	/** 
	 * Menù per la GESTIONE UTENTI
	 * Essa permette di :
	 * _Stampare la lista degli utenti (solo dati significativi);
	 * _Aggiungere un nuovo utente;
	 * _Cercare un utente mediante relativo codice Fiscale;
	 * _Rilasciare un utente mediante relativo codice Fiscale;
	 * _Aggiornare un utente mediante relativo codice Fiscale;
	 * _Cercare un utente (inserimento completo dati);
	 * _Rilasciare un utente (inserimento completo dati);
	 * _Stampare la lista degli utenti (con tutti i dati).
	 * @Author Simaz Andrea
	 */
	public void gestisciUtenti(){
		MyMenu menuUtenti= new MyMenu(TITOLO_UTENTI, SCELTE_UTENTI);
		boolean finito = false;
		UtentiOspedale utenti;
		do{
			int scelta = menuUtenti.scegli(true);

			switch(scelta){
			case 0:                      //esci
				finito=true;
				break;
			case 1:                      //Visualizza lista utenti
				if(clinica.getElencoUtenti().getNumeroUtenti() != 0){
					System.out.println(clinica.getElencoUtenti().toStringDati());
				}
				else System.out.println(NO_UTENTI);
				break;
			case 2:                       //aggiungi utente
				try{
					Vino nuovoUtente = aggiungiParametriUtenti();
					utenti = clinica.getElencoUtenti();
					utenti.aggiungiUtente(nuovoUtente);
					clinica.setElencoUtenti(utenti);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 3:                       //Cerca Utente usando codice
				try{
					utenti = clinica.getElencoUtenti();
					int indice = clinica.getElencoUtenti().cercaUtenteCod(MyIOconsole.leggiStringa(INS_COD_FISC));
					System.out.println(utenti.getUtente(indice).toString());
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 4:                        //Elimina utente usando codice 
				try{
					utenti = clinica.getElencoUtenti();
					utenti.eliminaUtenteCod(MyIOconsole.leggiStringa(INS_COD_FISC));
					clinica.setElencoUtenti(utenti);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 5:          //Aggiorna utente 
				try{
					Vino utente = clinica.getElencoUtenti().getUtente(clinica.getElencoUtenti().cercaUtenteCod(MyIOconsole.leggiStringa(INS_COD_FISC)));
					aggiornaUtente(utente);
					utenti = clinica.getElencoUtenti();
					utenti.inserisciUtente(utente);
					clinica.setElencoUtenti(utenti);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 6:                         //elimina utente usando tutto
				try{
					utenti = clinica.getElencoUtenti();
					utenti.eliminaUtenteNoCod(aggiungiParametriUtenti());
					clinica.setElencoUtenti(utenti);
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				if(clinica.getElencoUtenti().getNumeroUtenti() != 0){     
					System.out.println(clinica.getElencoUtenti().toString());
				}
				else System.out.println(NO_UTENTI);
				break;
			}
		}while(!finito);

	}

	/**
	 * Questo metodo permette di aggiungere i parametri richiesti da un oggetto di tipo Utente.
	 * @Author Simaz Andrea e Lorenzoni Andrea
	 * @return Utente utente (Istanza della classe Utente)
	 */
	private Vino aggiungiParametriUtenti(){

		Vino utente = new Vino(MyIOconsole.leggiParola(INS_NOME), MyIOconsole.leggiParola(INS_COG),
				MyIOconsole.leggiStringa(INS_LUOGO_NAS), MyIOconsole.leggiStringa(INS_TEL), inserisciData(),
				scegliGen(), insCodice(), MyIOconsole.leggiIntero(INS_CAP));

		return utente;
	}

	/**
	 * GESTIONE AGGIORNAMENTO MEDICI
	 * Questo metodo permette di aggiornare un medico, cercandolo fra la lista medici immessa tramite il suo codice Fiscale.
	 * @Author Simaz Andrea e Lorenzoni Andrea
	 * @param medico il medico
	 */
	public void aggiornaMedico(PersonaleMedico medico){
		boolean esiste = true;
		boolean finito = false;
		boolean sceltaUscita = true;
		if(esiste){
			MyMenu menu = new MyMenu(TITOLO_AGG, SCELTE_AGG);
			MyScelta sceltaDue= new MyScelta(S, N, SI_NO);
			do{
				int scelta = menu.scegli(sceltaUscita);

				switch(scelta){
				case 0: 
					System.out.println(SICURO);
					if(sceltaDue.sceltaDueVie() == true)
						finito = true;
					break;
				case 1 :
					medico.setNome(MyIOconsole.leggiParola(NEW_NOME));
					break;
				case 2 :
					medico.setCognome(MyIOconsole.leggiParola(NEW_COGN));
					break;
				case 3 :
					medico.setLuogoNascita(MyIOconsole.leggiParola(NEW_DATA_NASC));
					break;
				case 4 :
					medico.setDataNascita(inserisciData());
					break;
				case 5 :
					medico.setTelefono(MyIOconsole.leggiParola(NEW_TEL));
					break;
				case 6 :
					medico.setCap(MyIOconsole.leggiIntero(NEW_CAP));
					break;
				case 7 :
					medico.setTipologia(TipologiaMedico.valueOf(MyIOconsole.leggiStringa(NEW_TIPOLOGIA)));
					break;
				case 8 :
					medico.setGenere(scegliGen());
					break;
				}

			}while(!finito);
		}
	}

	/**
	 * AGGIORNAMENTO UTENTE
	 * Questo metodo permette di aggiornare un utente, cercandolo fra la lista utenti immessa tramite il suo codice fiscale.
	 *@Author Simaz Andrea e Lorenzoni Andrea
	 * @param utente l'utente
	 */
	public void aggiornaUtente(Vino utente){
		boolean esiste = true;
		boolean finito = false;
		boolean sceltaUscita = true;
		if(esiste){
			MyMenu menu = new MyMenu(TITOLO_AGG_UTENTE, SCELTE_AGG_UTENTE);
			MyScelta sceltaDue= new MyScelta(S, N, SI_NO);
			do{
				int scelta = menu.scegli(sceltaUscita);

				switch(scelta){
				case 0: 
					System.out.println(SICURO);
					if(sceltaDue.sceltaDueVie() == true)
						finito = true;
					break;
				case 1 :
					utente.setNome(MyIOconsole.leggiParola(NEW_NOME));
					break;
				case 2 :
					utente.setCognome(MyIOconsole.leggiParola(NEW_COGN));
					break;
				case 3 :
					utente.setLuogoNascita(MyIOconsole.leggiParola(NEW_DATA_NASC));
					break;
				case 4 :
					utente.setDataNascita(inserisciData());
					break;
				case 5 :
					utente.setTelefono(MyIOconsole.leggiParola(NEW_TEL));
					break;
				case 6 :
					utente.setCap(MyIOconsole.leggiIntero(NEW_CAP));
					break;
				case 7 :
					utente.setGenere(scegliGen());
					break;
				}

			}while(!finito);		
		}
	}

	/**
	 * Permette il salvataggio e il caricamento dei dati.
	 * @author Andrea Lorenzoni
	 */
	public void gestisciIO(){
		MyScelta sceltaIOFile = new MyScelta(C, S, CARICA_SALVA);
		File file = new File("IOClinica.txt");

		if(sceltaIOFile.sceltaDueVie()){
			try {
				clinica=(Clinica)MyIOFile.leggiOggetto(file);
				System.out.println(RIUSCITA);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				MyIOFile.scriviOggetto(file, clinica);
				System.out.println(RIUSCITA);
			} catch (IOException e) {
				System.out.println(FALLITA);
			}
		}
	}
}



