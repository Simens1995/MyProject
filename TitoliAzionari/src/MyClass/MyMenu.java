package MyClass;

import MyClass.MyIO.MyIOconsole;



/**
 * permette di generare un menù
 * @author Tiziano Fapanni, Andrea Simaz
 *
 */
public class MyMenu {
	 private final static String VOCE_USCITA="0-Esci";
	 private final static String RICHIESTA_INSERIMENTO="digita il numero dell'opzione desiderata: ";
	private static final String CORNICE = "\n-------------------------------------------------------------";
			 
	 private String titolo;
	 private String [] voci;
	
	 public MyMenu(String titolo, String[] voci) {
		this.titolo = titolo;
		this.voci = voci;
	}
	
	 /**
	  * stampa dell'interfaccia
	  */
	private void stampa(boolean voceUscita){
		System.out.println(CORNICE);
		System.out.print(titolo);
		System.out.println(CORNICE);
		
		for(int i=0; i<voci.length; i++){
			System.out.println((i+1)+"-"+voci[i]);
		}
		
		if(voceUscita){
		System.out.println(VOCE_USCITA);
		}
		System.out.println();
	}
	
	/**
	 * ti permette di eseguire la scelta.
	 * @param voceUscita: true se è contemplata la presenza della voce di uscita, false altrimenti;
	 * @return il numero della scelta
	 */
	public int scegli(boolean voceUscita){
		stampa(voceUscita);
		int min= voceUscita ? 0 : 1;
		return MyIOconsole.leggiIntero(RICHIESTA_INSERIMENTO, min, voci.length);
	}
	 
}
