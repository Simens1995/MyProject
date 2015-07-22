package GestioneNoleggio;


import java.io.File;
import java.io.IOException;



import MyClass.MyMenu;
import MyClass.MyScelta;
import MyClass.MyIO.MyIOconsole;


public class MainNoleggio {

	private static final String TITOLO = "Gestione automezzi";
	private static final String[] SCELTE = {"Visualizza lista automezzi",
											"Aggiungi automezzo",
                                            "Elimina automezzo",
                                            "Noleggia automezzo",
                                            "Conlcudi noleggio"};
	private static final String INS_CAR_MAX = "inserisci carico massimo sollevabile dalla gru (in kg) : ";
	private static final String INS_COSTO_NOL = "inserisci il costo del noleggio della gru ad ora ($/h) : ";
	private static final String INS_NUM_SERIE = "Inserisci numero di serie : ";
	private static final String INS_CAR_MIN = "Inserisci il carico che dovrà sollevare la tua gru : ";
	private static final String INS_DURATA_NOLEGGIO = "Inserisci la durata in giorni (gg) del noleggio : ";
	private static final String NO_PRENOTATO = "Mezzo non prenotato.";
	private static final String PRENOTATO = "Il tuo mezzo è stato prenotato.";
	private static final String PREZZO_DA_PAGARE = "Il prezzo da pagare per la fine del noleggio è : ";
	private static final String COMANDO = "Comando non riconosciuto";
	private static final String NO_MEZZI = "Mezzi non presenti nel parco";
	
	
	public static void main(String[] args) {
		MyMenu menuPrincipale= new MyMenu(TITOLO, SCELTE);
		boolean finito = false;
		Magazzino parcoMezzi = new Magazzino();
				
		do{
			int scelta=menuPrincipale.scegli(true);
			
			switch(scelta){
			case 0:                                             //esci
				finito=true;
				break;
			case 1: 				                            //visualizza parcoMezzi.
				if(parcoMezzi.getNumeroMezzi() != 0){
						System.out.println(parcoMezzi.toString());
				}
				else System.out.println(NO_MEZZI);
				break;
			case 2: 											//Inserisci nuovo mezzo al parcoMezzi
				try{
					 parcoMezzi.addMezzo(new Mezzo(MyIOconsole.leggiIntero(INS_CAR_MAX), 
						MyIOconsole.leggiIntero(INS_COSTO_NOL)));
					}
					catch(IllegalArgumentException e){
						System.out.println(e.getMessage());
					}
				break;
			case 3: 											//Elimina un mezzo dal parcoMezzi
				try{
					parcoMezzi.eliminaMezzo(MyIOconsole.leggiStringa(INS_NUM_SERIE));
					}
					catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
					}
				break;
			case 4: 											 //Prenota un mezzo
				try{
				   boolean prenotato = parcoMezzi.mezzoPrenotabile(MyIOconsole.leggiIntero(INS_CAR_MIN), MyIOconsole.leggiIntero(INS_DURATA_NOLEGGIO));
				   if(prenotato){
					   System.out.println(PRENOTATO);
				   }
				   else{
					   System.out.println(NO_PRENOTATO);
				   }
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 5:												//Riporta un mezzo
			try{
				System.out.println(parcoMezzi.toStringNoleggiato());
				int prezzoDaPagare = parcoMezzi.concludiNoleggio(MyIOconsole.leggiStringa(INS_NUM_SERIE));
				System.out.println(PREZZO_DA_PAGARE + prezzoDaPagare + " $");
			}
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
			break;
			default:                                              //in caso si inserisca un valore non riconosciuto (teoricamente mai applicato)
				System.out.println(COMANDO);
				break;
			}
		}while(!finito);
	}
/**
	public void gestisciIO(){
		MyScelta sceltaIOFile = new MyScelta('c', 's', CARICA_SALVA);
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
		*/
}



	