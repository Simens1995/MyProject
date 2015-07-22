package MyLib;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;


/**
 * contiene metodi di varia utilità
 * 
 * @author Tiziano Fapanni & Andrea Simaz
 *
 */
public class MyVarie {

	/**
	 * Metodo che consente di ottenere un numero intero compreso fra due valori
	 * @param max rappresenta l'estremo superiore dell'insieme da cui si estraggono i numeri
	 * @param min rappresenta invece l'estremo inferiore.
	 * @return il numero casuale estratto se min<max, altrimenti ritorna 0.
	 * 
	 * @author Tiziano Fapanni
	 */
	public static int interoCasuale(int max, int min){
		Random cas=new Random();
		int num=0;
		
		if(max<min) return num;
		else num=cas.nextInt(max-min+1)+min;
		
		return num;
	}
	
	/**
	 * Questo metodo controlla se il codice fiscale immesso è valido
	 * @Author Simaz Andrea
	 * @return boolean: _TRUE  : codice valido;
	 *                  _FALSE : codice non valido;
	 */
	public static boolean validCodFiscale(String codFiscale){  
		if(codFiscale.length() == 16){
			String codCarattere = codFiscale.substring(0, 6) + codFiscale.substring(8, 9) + codFiscale.substring(11, 12)
					+ codFiscale.substring(15, 16);
			String codNumeri = codFiscale.substring(6, 7) + codFiscale.substring(9, 10) + codFiscale.substring(12, 14);
			if((codCarattere.matches("[a-zA-Z]+")) && (codNumeri.matches("[0-9]+"))){
				return true;
			}	
		}
		return false;
	} 
	
	/**
	 * Questo metodo permette di trasformare un oggetto LocalDate in una stringa giorno\MESE\anno
	 * @Author Simaz Andrea
	 * @param data
	 * @return String date data in formato stringa
	 */
	public static String toStringData(LocalDate data){
		int anno = data.getYear();
		Month mese = data.getMonth();
		int giorno = data.getDayOfMonth();
		String date = giorno + "/"+ mese.toString() +  "/" + anno; 
		return date;
	}
}
