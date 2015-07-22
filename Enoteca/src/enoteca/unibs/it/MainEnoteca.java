package enoteca.unibs.it;

/**
 * @author Simaz Andrea
 * ENOTECA
 */

import MyClass.MyMenu;
import MyClass.MyIO.MyIOconsole;

public class MainEnoteca {

	/**
	 * COSTANTI
	 */
	private static final String TITOLO = "ENOTECA";
	private static final String[] SCELTE = {"Inserisci nuovo vino",
											"modifica un vino",
                                            "Visualizza elenco vini",
                                            "Acquisto nuova quantità di vino",
                                            "vendita vino",
                                            "Visualizza lista vino richiesto"};
	private static final String NO_VINI = "Non sono presenti vini nel magazzino";
	private static final String INS_NOME = "inserisci il nome del vino : ";
	private static final String INS_CASA = "inserisci la casa produttrice del vino : ";
	private static final String INS_ANNATA = "Inserisci l'annata del vino : ";
	private static final String INS_QTA = "Inserisci la quantità di vino presente nel magazzino (bottiglie) : ";
	private static final String INS_PREZZO = "Inserisci il prezzo del vino (euro/bottiglia) : ";
	private static final String COMANDO = "Comando non riconosciuto";
	private static final String INS_NEW_QTA = "Inserisci la quantità di vino da aggiungere : ";
	private static final String INS_QTA_COMP = "Inserisci la quantità di vino che vuoi comprare : ";
	private static final String EURO = " Euro";
	private static final String PREZZO_DA_PAGARE = "Il prezzo totale dell'acquisto è : ";
	private static final String NON_PRES = "Vino non presente. ";
	
	/**
	 * MAIN
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyMenu menuPrincipale = new MyMenu(TITOLO, SCELTE);
		boolean finito = false;
		Magazzino magazzino = new Magazzino();
				
		do{
			int scelta = menuPrincipale.scegli(true);
			
			switch(scelta){
			case 0:                                             //esci
				finito = true;
				break;
			case 1: 				                            //Inserisci vino
				try{
					 magazzino.aggiungiVino(new Vino(MyIOconsole.leggiStringa(INS_NOME), MyIOconsole.leggiStringa(INS_CASA), MyIOconsole.leggiIntero(INS_ANNATA), 
							 MyIOconsole.leggiIntero(INS_QTA), MyIOconsole.leggiDouble(INS_PREZZO)));
					}
					catch(IllegalArgumentException e){
						System.out.println(e.getMessage());
					}
				break;
			case 2: 											//Modifica vino preesistente
			    	Vino vino = inserisciVino();
			    	int i = magazzino.getIndiceVino(vino);
			    	if(i >= 0){
			    		magazzino.aggiornaVino(magazzino.getVino(i));
			    	}
			    	else System.out.println(NON_PRES);
				break;
			case 3: 											//Visualizza lista vini presenti in enoteca
				if(magazzino.getNumeroVini() != 0){
					System.out.println(magazzino.toString());
					}
					else System.out.println(NO_VINI);
			break;
			case 4: 											 //Acquista un vino per rifornire magazzino
				try{
					magazzino.aggiungiQta(inserisciVino(), MyIOconsole.leggiIntero(INS_NEW_QTA));
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 5:												  //vendita del vino
			try{
				double prezzoPagare = magazzino.acquistaBottiglie(inserisciVino(), MyIOconsole.leggiIntero(INS_QTA_COMP));
				System.out.println(PREZZO_DA_PAGARE + prezzoPagare + EURO);
			}
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
			break;
			case 6: 
				String nome = MyIOconsole.leggiParola(INS_NOME);
				System.out.println(magazzino.stringViniRichiesti(nome));
			break;
			default:                                              //in caso si inserisca un valore non riconosciuto (teoricamente mai applicato)
				System.out.println(COMANDO);
				break;
			}
		}while(!finito);
	}
			
	/**
	 * Inserimento dei parametri oggetto vino.
	 * @return Vino vino (oggetto vino)
	 */
	private static Vino inserisciVino(){
		Vino vino = new Vino(MyIOconsole.leggiStringa(INS_NOME), MyIOconsole.leggiStringa(INS_CASA), MyIOconsole.leggiIntero(INS_ANNATA), 0, 0);
		return vino;
	}
	
}


