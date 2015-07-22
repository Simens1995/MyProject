package it.ing.unibs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import MyClass.MyMenu;
import MyClass.MyScelta;
import MyClass.MyIO.MyIOFile;
import MyClass.MyIO.MyIOconsole;
/*import MyLib.MyIO.*;
import MyLib.*;*/

/*import MyClass.MyMenu;
import MyClass.MyScelta;
import MyClass.MyIO.MyIOFile;
import MyClass.MyIO.MyIOconsole;*/

public class TitoliMain {
	
	private final static String FRASE="cosa vuoi fare?", METTI_NOME="Inserisci il nome del proprietario del portafoglio: ";
	private final static String[] SCELTE=	{"gestisci Titoli",				//1
											 "gestisci portafoglio",		//2
											 "simula passare del tempo",	//3
											 "salva dati",					//4
											 "carica dati",					//5
											 };
	private final static String E_CARICAMENTO="Caricamento non completato, ", 
			E_MANCA_FILE="non è stato possibile trovare il file; ",
			E_SALVATAGGIO="Salvataggio non avvenuto, ",
			E_GENERICO="si è varificato un errore; ", 
			SUCCESSO="Operazione avvenuta con successo!";
	private static final String MSG_ERRORE = "Inserimento non corretto", T_PORTAFOGLIO="Gestione Portafoglio: ";
	private static final String[] S_PORTAFOGLIO={
		"Visualizza Portafoglio",
		"Aggiungi Titolo",
		"Rimuovi Titolo"
	};
	
	private static final String T_BORSA="Gestione Borsa: ", PRE_ELIMINAZIONE="Quale Titolo vuoi eliminare?\n";
	private static final String[] S_BORSA={
		"Visualizza Titoli disponibili",
		"Aggiungi Titolo",
		"Rimuovi Titolo"
	};
	private static final String T_SIMULAZIONE = "Vuoi continuare la simulazione borsistica? (y/n)";
	private static final String PATH_BORSA = "borsa.txt";
	private static final String PATH_PORTAFOGLIO = "portafoglio.txt";

	
	public static void main(String[] args) {
		MyMenu menu= new MyMenu(FRASE, SCELTE);
		boolean finito=false;
		//inizializzazione portafoglio
		Portafoglio portafoglio= new Portafoglio(MyIOconsole.leggiParola(METTI_NOME));
		ElencoTitoli borsa=new ElencoTitoli();
		
		File borsaF= new File(PATH_BORSA);
		File portafoglioF= new File(PATH_PORTAFOGLIO);
		
		 
		do{
		int scelta=menu.scegli(true);
		
		switch(scelta){
			
			case 1: //gestisci titoli
				MyMenu mBorsa= new MyMenu(T_BORSA, S_BORSA);
				
				boolean finito2=false;
				
				do{
					int scelta2=mBorsa.scegli(true);
					
					switch(scelta2){
						case 0: //torna indietro
							finito2=true;
							break;
						case 1: //visualizza Titoli
							System.out.println(borsa.toString());
							break;
						case 2: //aggiungi titolo
							borsa.aggiungiTitoli(new Titolo(MyIOconsole.leggiParola("inserisci nome titolo: "), 
								MyIOconsole.leggiDouble("inserisci il valore iniziale del titolo: ")));
							break;
						case 3: //eliminazione titolo
							int n=MyIOconsole.leggiIntero(PRE_ELIMINAZIONE + borsa.toString(), borsa.getNTitoli(), 1)-1;
							borsa.remove(borsa.get(n));
					}
				}while(!finito2);
				break;
				
			case 2: //gestione portafoglio
				MyMenu mPortafoglio= new MyMenu(T_PORTAFOGLIO, S_PORTAFOGLIO);
		
				boolean finito1=false;
				
				do{
					int sceltaP=mPortafoglio.scegli(true);
					
					switch(sceltaP){
						case 0: //torna indietro
							finito1=true;
							break;
						case 1: //visualizza portafoglio
							System.out.println(portafoglio.toStringCompleto());
							break;
						
						case 2: //aggiungi titolo
							if(borsa.getNTitoli()>0){
							int n=MyIOconsole.leggiIntero("Scegli uno dei seguenti titoli da aggiungere al tuo portafoglio:\n " 
									+ borsa.toString(),1, borsa.getNTitoli());
							 portafoglio.addLotto(new Lotto(borsa.get(n-1), MyIOconsole.leggiIntero("inserisci un numero positivo", 1, 9999)));
							}
							else System.out.println("Non sono disponibili titoli");
							break;
						case 3: //eliminazione titolo
							int n=MyIOconsole.leggiIntero(PRE_ELIMINAZIONE + portafoglio.toString(), portafoglio.getNTitoli(), 1)-1;
							portafoglio.remove(portafoglio.get(n));
							break;
					}
					}while(!finito1);
					break;
					
			case 3://simulazione andamento giorni
				//MyMenu mSimulazione= new MyMenu(T_SIMULAZIONE, T_SCELTA);
				MyScelta sceltaDue=new MyScelta('y', 'n', T_SIMULAZIONE);
				boolean finito3=false;
				
				do{
					if(sceltaDue.sceltaDueVie()){
						borsa.nuovoGiorno(portafoglio);
						System.out.println(portafoglio.toStringCompleto());
					}
					else finito3=true;
				
				}while(!finito3);
				break;
			
			case 4: //salva dati
				try{
					borsaF.createNewFile();
					portafoglioF.createNewFile();				
					
					MyIOFile.scriviOggetto(borsaF, borsa);
					MyIOFile.scriviOggetto(portafoglioF, portafoglio);
					//aggiungi una parte per dire cvhe l'operazione è avvenuta con successo
					System.out.println(SUCCESSO);
				}
				catch ( FileNotFoundException e){
					System.out.println(E_SALVATAGGIO + E_MANCA_FILE);
					
				}
				catch (IOException e){
					System.out.println(E_SALVATAGGIO + E_GENERICO);
				}			
				break;
				
			case 5: //carica dati
				try{		
					borsa=(ElencoTitoli)MyIOFile.leggiOggetto(borsaF);
					portafoglio=(Portafoglio)MyIOFile.leggiOggetto(portafoglioF);
					
					//aggiungi una parte per dire cvhe l'operazione è avvenuta con successo
					System.out.println(SUCCESSO);
				}
				catch ( FileNotFoundException e){
					System.out.println(E_CARICAMENTO + E_MANCA_FILE);
				}
				catch (IOException e){
					System.out.println(E_CARICAMENTO + E_GENERICO);
				} catch (ClassNotFoundException e) {
					System.out.println(E_CARICAMENTO + E_GENERICO);
				}
				break;
				
			case 0: //conclude il programma
				finito=true;
				break;
				
			default:
				System.out.println(MSG_ERRORE);
		}
			
		}while(!finito);

	}
	
}
