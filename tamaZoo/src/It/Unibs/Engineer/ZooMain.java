package It.Unibs.Engineer;

import MyClass.MyMenu;
import MyClass.MyScelta;
import MyClass.MyIO.MyIOconsole;
/**
 * PROGETTO TAMAZOO
 * @author  Tiziano Fapanni, Andrea Simaz & Andrea Lorenzoni
 *
 */

public class ZooMain {
	private final static String TITOLO_SCELTA="Cosa vuoi fare?", FRASE_INS="Inserisci il numero di Tamagochi con cui vuoi giocare: ";
	private final static String[] SCELTE_GIOCO={"Dai Carezze",
												"Dai Biscotti"
												};
	private final static String FRASE_DUE_VIE="Sicuro di voler uscire (s/n)? ";
	private final static String SCELTA_NOMI="Vuoi assegnare un nome a ogni tamagochi (s/n)? ";
	private final static String IMMISSIONE_NOMI="Inserisci il nome del tamagochi: ";
	private final static String FRASE_BENVENUTO="Benvenuto al TamaZoo!\n";
	private final static String FRASE_USCITA="Arrivederci e a Presto!";
	private final static String TUTTI_MORTI="Tutti i tuoi tamagochi sono morti!!";
	
	public static void main(String[] args) {
		MyMenu menu=new MyMenu(TITOLO_SCELTA, SCELTE_GIOCO);		
		int n;
		boolean finito=false;
		MyScelta assegnaNomi= new MyScelta('s', 'n', SCELTA_NOMI);
		
		//Frase di benvenuto
		System.out.println(FRASE_BENVENUTO);
		
		//creazione dello ZOO
		do{
			n=MyIOconsole.leggiIntero(FRASE_INS);
		}while(n<0);
		
		TamaZoo tamaZoo=new TamaZoo(n);
		
		if(assegnaNomi.sceltaDueVie()){
			String[] nomi= new String[tamaZoo.getNEsemplari()];
			for(int i=0; i<tamaZoo.getNEsemplari(); i++){
				nomi[i]=MyIOconsole.leggiParola(IMMISSIONE_NOMI);
			}
			tamaZoo.setNomi(nomi);
		}
		
		//ciclo di gioco
		do{
			int scelta=menu.scegli(true);
			
			switch(scelta){
				//esci
				case 0:
					MyScelta sceltaDue= new MyScelta('s', 'n', FRASE_DUE_VIE);
					if(sceltaDue.sceltaDueVie()) finito=true;
					break;
				//dai Carezze
				case 1:
					tamaZoo.distribuisciCarezze();
					break;
				//dai Biscotti
				case 2:
					tamaZoo.distribuisciBiscotti();
			}
			
			System.out.println(tamaZoo.toString());
		}while(!finito && tamaZoo.getNEsemplari()!=0);
		
		if(tamaZoo.getNEsemplari()==0){
			System.out.println(TUTTI_MORTI);
		}
		System.out.println(FRASE_USCITA);
	}

	
}