package progettoCorso.GestioneUtenze;

/**
 * Classe COSTANTI, utilizzate nelle interfacce e nelle classi medico/utente.
 * @author Fapanni Tiziano, Lorenzoni Andrea & Simaz Andrea
 *
 */
public final class Costanti {

	public static final String VUOTA = "";
	/**
	 * COSTANTI INSERIMENTO CONDIVISE MEDICO - PAZIENTE
	 */
	public static final String INS_NOME = "\nInserisci nome : ";
	public static final String INS_COG = "\nInserisci cognome : ";
	public static final String INS_LUOGO_NAS = "\nInserisci luogo nascita : ";
	public static final String INS_TEL = "\nInserisci numero telefonico : ";
	public static final String INS_DATA_NAS = "\nInserisci data di nascita : ";
	public static final String INS_GENERE = "\nInserisci genere ";
	public static final String INS_COD_FISC = "\nInserisci codice fiscale : ";
	public static final String INS_CAP = "\nInserisci CAP : \n";
	public static final String INS_ANNO_NASC = "\nInserisci l'anno di nascita \t: \n";
	public static final String INS_MESE_NASC = "\nInserisci il mese di nascita \t: \n";
	public static final String INS_GIORNO_NASC = "\nInserisci il giorno di nascita \t: \n";
	public static final String MASC_O_FEMM = "\nMaschio (m) o Femmina (f) : \n";
	public static final String GEN_O_SPEC = "\nGenerico (g) o Specialista (s) : \n";
	/**
	 * COSTANTI INSERIMENTO MEDICO
	 */
	public static final String INS_TIPOLOGIA = "\nInserisci tipologia del medico : ";
	/**
	 * COSTANTI GESTIONE UTENZE
	 */
	public static final String TITOLO_UTENZE = "GESTIONE UTENZE";
	public static final String[] SCELTE_UTENZE = {"Gestione medici",
												  "Gestione utenti"};
	/**							
	 * COSTANTI GESTIONE MEDICI
	 */
	public static final String TITOLO_MEDICI = "GESTIONE MEDICI";
	public static final String[] SCELTE_MEDICI = {"Visualizza lista medici con dati essenziali",
												   "Aggiungi medico",
												   "Cerca medico (usando codice)",
												   "Licenzia medico (usando codice)",
												   "Aggiorna medico (usando codice)",
												   "Licenzia medico (senza codice, operazione avanzata)",
												   "Visualizza lista medici completa"};
	public static final String NO_MEDICI = "Medici non presenti nella lista dell'ospedale";
	public static final String IMMETTI_COD_A = "\nImmetti codice alfaNumerico del medico : ";
	/**
	 * COSTANTI GESTIONE UTENTI
	 */
	public static final String TITOLO_UTENTI = "GESTIONE UTENTI";
	public static final String[] SCELTE_UTENTI = {"Visualizza lista utenti",
												   "Aggiungi utente",
												   "Cerca utente (usando codice)",
												   "Rimuovi utente (usando codice)",
												   "Aggiorna utente (usando codice)",
												   "Rimuovi utente (senza codice, operazione avanzata)",
												   "Visualizza lista utentu completa"};
	public static final String NO_UTENTI = "Utenti non presenti nella lista utenti";
	/**
	 * COSTANTI AGGIORNAMENTO MEDICO
	 */
	public static final String TITOLO_AGG = "Cosa vuoi aggiornare al medico?";
	public static final String[] SCELTE_AGG = {"nome",
		                                        "cognome",
		                                        "Luogo nascita",
		                                        "Data di nascita",
												"Numero telefonico",
		 										"CAP",
		 										"tipologia del medico",
		 										"genere"};
	/**
	 * COSTANTI AGGIORNAMENTO UTENTE
	 */
	public static final String TITOLO_AGG_UTENTE = "Cosa vuoi aggiornare all'utente?";
	public static final String[] SCELTE_AGG_UTENTE = {"nome",
													  "cognome",
													  "Luogo nascita",
													  "Data di nascita",
													  "Numero telefonico",
													  "CAP",
		 											  "genere"};
	/**
	 * COSTANTI USCITA
	 */
	public static final String SICURO = "Sei sicuro ? ";
	/**
	 * COSTANTI CARICAMENTO/SALVATAGGIO FILE
	 */
	
	public static final String RIUSCITA = "\nOperazione riuscita con successo!";
	public static final String CARICA_SALVA = "\nVuoi caricare (c) o salvare (s) il file? ";
	public static final String FALLITA="\nATTENZIONE: Operazione fallita!";
	/**
	 * COSTANTI UTENTE
	 */
	public static final String COD = "\nCodice fiscale \t\t: ";
	public static final String NOME = "\nNome \t\t\t: ";
	public static final String COGNOME = "\nCognome \t\t: ";
	public static final String NON_VALIDO = "\nCodice fiscale non valido, reimmettine uno valido : ";
	/**
	 * COSTANTI CONDIVISE MEDICO-UTENTE 
	 */
	public static final String LUOGO_NASC = "\nluogo di nascita \t: ";
	public static final String NUM_TEL = "\nnum. telefonico \t: ";
	public static final String DATA_NASC = "\ndata di nascita \t: ";
	public static final String GENERE = "\nGenere \t\t\t: ";
	public static final String CAP = "\nCAP \t\t\t: ";
	/**
	 * COSTANTI REIMMISSIONE NUOVI DATI
	 */
	public static final String NEW_NOME = "\nInserire il nome aggiornato : ";
	public static final String NEW_COGN = "\nInserire il cognome aggiornato : ";
	public static final String NEW_DATA_NASC = "\nInserisci la data di nascita aggiornata : ";
	public static final String NEW_TEL = "\nInserire il nuovo numero di telefono : ";
	public static final String NEW_CAP = "\nInserire il nuovo CAP : ";
	public static final String NEW_TIPOLOGIA = "\nInserire nuova tipologia medico : ";
	/**
	 * COSTANTI MEDICO
	 */
	public static final String COD_MED = "\nCodice medico \t\t: ";
	public static final String NOME_MED = "\nNome medico \t\t: ";
	public static final String COGNOME_MED = "\nCognome medico \t\t: ";
	public static final String TIPOLOG = "\nTipologia medico \t: ";
	/**
	 * TITOLO_PRINCIPALE
	 */
	public static final String TITOLO_PRINCIPALE = "Gestione Agende";
	
	/**SCELTE_PRINCIPALI. */
	public static final String [] SCELTE_PRINCIPALI={"Visite",
													  "Orari di Visita",
													 };
	/** TITOLO_VISITE. */
	public static final String TITOLO_VISITE="Gestione Visite";
	/**SCELTE_VISITE. */
	public static final String [] SCELTE_VISITE={"Visualizza Visite",
												  "Visualizza Visite prenotate",
												  "Prenota Visita",
												  "Modifica Prenotazioni",
												  "Cancella visita",
												  "Ricerca Visite",
												  "Concludi visite"
												 };

	/** T_ORARIO_VISITE. */
	public static final String T_ORARIO_VISITE="Gestione Orario Visite";
	
	/** S_ORARIO_VISITE. */
	public static final String[] S_ORARIO_VISITE={"Visualizza Orari di visita",
												  "imposta un nuovo orario di visita",
												   "modifica orario di visita",
												   };
	
	/** ANNO_MAX. */
	public static final int ANNO_MAX = 2050;
	
	/** QUARTO_ORA. */
	public static final int QUARTO_ORA = 15; 
	

	/**
	 * COSTANTI PER LA GESTIONE DELLE AGENDE
	 */
	public static final char S='s', P='p', G='g', M='m', N='n', D='d', C='c', F='f';
	public static final String INSERISCI_DATA_INIZIO="Inserisci la data di inizio servizio: ";
	public static final String INSERISCI_DATA_FINE="Inserisci la data di fine servizio: ";
	public static final String INSERISCI_ORA_INIZIO="Inserisci l'ora di inizio servizio";
	public static final String INSERISCI_ORA_FINE="Inserisci l'ora di fine servizio";
	public static final String SCELTA_SINGOLO_PERIODO="Vuoi processare un singolo giorno di visita (s) o un periodo di disponibilità (p)? ";
	public static final String ERRORE="Si è verificato un errore imprevisto, provare a ripetere l'operazione in seguito";
	public static final String OP_IMPOSSIBILE_VISITE_GIA_PRENOTATE="impossibile completare l'operazione dal momento che in una data sono state già prenotate delle visite;\nSi provveda prima a spostare gli appuntamenti già prenotati prima di eliminare la data";
	public static final String ERRORE_ORARIO_1="orario non valido: si provvede a spostarlo all' a mezz'ora più vicina";
	public static final String INS_ORA= "Inserisci l'ora: ";
	public static final String INS_MINUTO="Inserisci il minuto: ";
	public static final String ERRORE_ORARIO="ATTENZIONE: orario impossibile";
	public static final String ERRORE_DATA="ATTENZIONE: data impossibile";
	public static final String INS_ANNO="Inserisci l'anno: ";
	public static final String INS_MESE="Inserisci il mese: ";
	public static final String INS_GIORNO="Inserisci il giorno: ";
	public static final String SCEGLI_MEDICO="Scegli il medico: ";
	public static final String RICERCA_MEDICO_PAZIENTE="come vuoi effettuare la ricerca? per medico (m) o per paziente (p)?";
	public static final String INS_PRESCRIZIONE="Inserire la prescrizione medica: ";
	public static final String INS_REFERTO="Inserire il referto medico: ";
	public static final String SI_NO=" (s\\n) ";
	public static final String SCELTA_EFFETTUATA="\n\tScelta effettuata: ";
	public static final String SELEZIONA_VISITA="Seleziona una visita: ";
	public static final String SCELTA_MEDICO_GENERALE="Vuoi visualizzare per singolo medico (m) o generale (g)";
	public static final String ERRORE_NO_PAZIENTI="Non sono presenti pazienti, non è possibile prenotare alcuna visita";
	public static final String ERRORE_NO_MEDICI="Non sono presenti medici che abbiano organizzato un orario di visita, non è possibile prenotare alcuna visita";
	public static final String DISPONIBILE="\n è disponibile: è accettabile (s/n)? ";
	public static final String NON_DISPONIBILI="Non sono disponibili visite per la data e l'ora indicata; Vengono proposte le prime visite disponibili";
	public static final String SCELTA_METODO_PRENOTAZIONE="Come vuoi prenotare la visita?\n\tm)seleziona un medico;\n\td)Seleziona una data";
	public static final String VISITE_NON_DISPONIBILI="Non sono disponibili visite";
	public static final String DATA_IMPOSSIBILE = "ATTENZIONE: data impossibile";
	public static final String ERRORE_MEDICO="Non è stato ancora predisposto un orario di visita";
	public static final String TITOLO_MODIFICA_VISITA="Modifica Visita";
	public static final String[] SCELTE_MODIFICA_VISITA={"Elimina Prenotazione",
		"Cambia Paziente"
	};
}


