package unibs.es.tama;

/**
 * 
 * @author tiziano
 *
 */
public class TamaMain {

	private final static String FRASE_NOME = "inserisci il nome del tuo tamagochi: ", FRASE_SCELTA="biscotti o carezze?";
	private final static int QUANT_MAX=8, QUANT_MIN=1;
	
	public static void main(String[] args) {
		Tamagochi tama=new Tamagochi(QUANT_MAX, QUANT_MIN);
		
		//inizializzazione del Tamagochi
		tama.setNome(MyUtility.leggiParola(FRASE_NOME));
		tama.setFelicita();
		tama.setSazieta();
		
	
		//ciclo di gioco
		do{	
			//stampa dati del tamagochi
			System.out.println(tama.getNome()+": ");
			System.out.println("\t-FELICITA': " + tama.getFelicita());
			System.out.println("\t-SAZIETA':" + tama.getSazieta() );
	
			if(tama.isBenessere()==false) System.out.println(tama.getNome()+" è infelice! \n");
			else System.out.println("");
			// scelta multipla
			String scelta=MyUtility.leggiParola(FRASE_SCELTA);
			scelta=scelta.toLowerCase();
			switch (scelta){
				case "biscotti":
					tama.riceviBiscotti(MyUtility.interoCasuale(QUANT_MAX, QUANT_MIN));
					break;
				case "carezze":
					tama.riceviCarezze(MyUtility.interoCasuale(QUANT_MAX,QUANT_MIN));
					break;
			}
		}while(tama.isInVita()==true);
		
		System.out.println(tama.getNome()+" è morto!");
	}

}
