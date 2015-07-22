package It.Unibs.Engineer;

import MyClass.MyMenu;
import MyClass.MyScelta;
import MyClass.MyIO.MyIOconsole;

/**
 * Progetto MEDAGLIERE OLIMPIONICO.
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */
public class MedagliereMain {

	final static String TITOLO = "MEDAGLIERE OLIMPICO";
	final static String[] SCELTE = {"Introduci nuova Nazione",
									"Introduci nuova gara",
									"Introduci risultati gare",
									"Visualizza medagliere ordinato"
									};
	final static String INS_NAZ = "Inserisci nuova nazione";
	final static String INS_GARA = "Inserisci nuova gara";
	final static String INS_GARA_CERCARE = "Inserisci gara da cercare nell'elenco di gare";
	final static String INS_NAZ_CERCARE = "Inserisci nazione da cercare nell'elenco nazioni";
	final static String NO_PRES = "Nessuna Nazione o Gara sono presenti nell'elenco";
	final static String NO_GARA = "Gara non presente nell'elenco";
	final static String NO_NAZ = "Non è presente nessuna nazione";
    final static String PREMIATA = "Gara già premiata";	
	final static String VINCITRICI = "° NAZIONE è ";
	final static String SURE = "Sicuro di uscire ? ";
	final static int NUM_MEDAGLIE = 3;
	
	
	private static ElencoNazioni elencoNazioni = new ElencoNazioni();
	private static ElencoGare elencoGare = new ElencoGare();
	
	public static void main(String[] args) {
	
		int scelta;
		boolean finito = false;
		boolean sceltaUscita = true;
		MyMenu menu = new MyMenu(TITOLO, SCELTE);
		MyScelta sceltaDue= new MyScelta('y', 'n', "(y/n)? ");
/**
 * Menù del Medagliere Olimpionico. Per ulteriori informazioni, guardare le classi utilizzate.	
 */
		do{
			scelta = menu.scegli(sceltaUscita);
			
			switch(scelta){
				case 0 :
					System.out.println(SURE);
					if(sceltaDue.sceltaDueVie() == true)
						finito = true;
					break;
				case 1 : 
				    aggiungiNazione();
					break;
				case 2 :
					aggiungiGara();
					break;
				case 3 :
					premiazione();
					break;
				case 4 :
					if(elencoNazioni.getNumeroNazioni() != 0){
					elencoNazioni.visualizzaMedagliereOrdinato();
					}
					else System.out.println(NO_NAZ);
					break;
			}
				
				
				
		}while(!finito);
	}

	/**
	 * AGGIUNGE UNA NAZIONE
	 */
	private static void aggiungiNazione(){
		try{
			 elencoNazioni.aggiungiNazione(new Nazione(MyIOconsole.leggiParola(INS_NAZ)));
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * AGGIUNGE UNA GARA
	 */
	private static void aggiungiGara(){
		try{
			elencoGare.aggiungiGara(new Gara(MyIOconsole.leggiStringa(INS_GARA)));
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * PREMIAZIONE
	 */
	private static void premiazione(){
		if(elencoNazioni.getNumeroNazioni() == 0 || elencoGare.getNumeroGare() == 0){
			System.out.println(NO_PRES);
		}
		else{
			try{
			Gara scelta = elencoGare.cercaGara(MyIOconsole.leggiStringa(INS_GARA_CERCARE));
			
			if(scelta == null){
				System.out.println(NO_GARA);
			}
			if(scelta.giaPremiata()){
				System.out.println(PREMIATA);
			}
			else{
				scelta.setEseguita();
				  for (int i=0; i < NUM_MEDAGLIE; i ++)
				   {
					  Nazione medagliata;
					  do
					   {
						 medagliata = elencoNazioni.scegliNazione(MyIOconsole.leggiStringa("la " + (i+1) + VINCITRICI));
						 if (medagliata == null)
							 System.out.println("scelta obbligatoria"); 
					   } 
					  while (medagliata == null);
					  medagliata.aggiungiMedaglia(i);
					  scelta.aggiungiPremiata(medagliata,i);
				   }
			}
			}//SECONDO ELSE
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		}	//PRIMO ELSE	
	}       //CLASSE PREMIAZIONE
}           //MAIN





