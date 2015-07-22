package MyClass;

import MyClass.MyIO.MyIOconsole;



/**
 * Scelta a due vie che accetta come risposte due caratteri ch1 o ch2;
 * 
 * @author tiziano
 *
 */
public class MyScelta {
	private char ch1, ch2;
	private String frase;
	
	/**
	 * scelta a due vie, COSTRUTTORE
	 * @param frase: stringa che viene presentata a schermo al momento della richiesta d'immissione
	 * @param ch1: carattere che indica la prima risposta 
	 * @param ch2: carattere che indica la seconda risposta
	 *
	 */
	public MyScelta(char ch1, char ch2, String frase) {
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.frase = frase;
	}
	
	/**
	 * 
	 * @return false se si digita il carattere ch2, true se si digita il carattere ch1
	 * 
	 */
	public boolean sceltaDueVie(){
		boolean finito=false;
		char ch=' ';
		do{
			ch=MyIOconsole.leggiChar(frase);
			if(ch==ch1) return true;
			else if(ch==ch2) return false;
		}while(!finito);
		return true;			//questo return non verrà mai eseguito perchè il ciclo9 è pensato infinito fino al momento che non si inserisca un carattere accettabile.
	}
	
	
	
}
