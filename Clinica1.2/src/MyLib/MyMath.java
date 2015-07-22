package MyLib;

/**
 * classe statica per metodi matematici di utilità generale.
 * 
 * @author Tiziano Fapanni, Andrea Simaz
 *
 */

public class MyMath {

	private MyMath(){
	}
	
	/**
	 * restituisce la sommatoria dei valori degli argomenti di un vettore
	 * @param vettore 
	 * @return la sommatoria degli argomenti dello stesso tipo dl vettore usato come input
	 */
	public static int sommatoria(int ...vettore) {
		int sommatoria=0;
		
		for(int i=0; i<vettore.length; i++)
			sommatoria+=vettore[i];
		return sommatoria;
	}
	
	public static double sommatoria(double ...vettore){
		double sommatoria=0;
		
		for(int i=0; i<vettore.length; i++)
			sommatoria+=vettore[i];
		return sommatoria;
	}
	
	/**
	 * metodo per il calcolo della media aritmetica (non pesata)
	 * @param addendi sono i vari elementi di cui si vuole calcolare la media.
	 * @return la media aritmetica dei vari elementi del vettore
	 */
	public static double media(double ...addendi){
		double media=MyMath.sommatoria(addendi)/(addendi.length);
		return media;
	}
	
	/**
	 * 
	 * @return restituisce il valore in una data base.
	 * @param base: base del logaritmo;
	 * @param argomento: argomento del logaritmo;
	 * 
	 */
	public static double logBaseGenerica(double base, double argomento){
		double log=Math.log(argomento)/Math.log(base);
		
		return log;
	}
}
