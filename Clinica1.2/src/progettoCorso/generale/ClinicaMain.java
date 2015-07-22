package progettoCorso.generale;

import MyLib.MyMenu;
import MyLib.MyScelta;

public class ClinicaMain {
	private static final String[] SCELTE_PRINCIPALI={
		"gestione agenda",
		"gestione medici",
		"gestione pazienti",
		"salvataggio/caricamento dei dati"
	};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterfacciaClinica clinica = new InterfacciaClinica();
		MyMenu menuPrincipale = new MyMenu("Gestione clinica", SCELTE_PRINCIPALI);
		boolean finito = false;
				
		do{
			int scelta=menuPrincipale.scegli(true);
			
			switch(scelta){
			case 0: //esci
				finito=true;
				break;
			case 1: //gestione agenda
				clinica.menuAgende();
				break;
			case 2: //gestisci medici
				clinica.gestisciMedici();
				break;
			case 3: //gestisci pazienti
				clinica.gestisciUtenti();
				break;
			case 4: //IO file
				clinica.gestisciIO();
				break;
			default: //in caso si inserisca un valore non riconosciuto (teoricamente mai applicato)
				System.out.println("comando non riconosciuto");
				break;
			}
		}while(!finito);
	}

}
