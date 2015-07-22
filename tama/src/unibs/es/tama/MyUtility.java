package unibs.es.tama;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe di utilità generale:
 * 	- lettura di varie tipologie di dati da tastiera;
 * 	- scrittura formattata di alcuni tipi i dati;
 * 	- metodi di utilità (Random,...)
 * 
 * @author tiziano
 *
 */
 public class MyUtility {
	
	private MyUtility(){
	}
	
	/**
	 * 
	 * @param frase: frase che deve essere visualizzata al momento della richiesta di immissione da parte dell'utente.
	 * @return il numero immesso in input
	 */
	public static int leggiIntero(String frase){
		Scanner lettore=new Scanner(System.in);
		boolean termine=false;
		int numero=0;
		
		 
		do{
			System.out.print(frase);
			
			if(lettore.hasNextInt()==true){
				numero=lettore.nextInt();
				termine=true;
			}
			else lettore.next();
				
		}while(termine==false);
		
		return numero;
	}
	
	/**
	 * permette di ottenere @return un intero compreso fra due valori (@param min < intero < @param max)
	 * @param frase permette di modificare il messaggio che viene visualizzato prima dell'immissione
	 *  da parte dell'utente.
	 */
	public static int leggiIntero(String frase, int min, int max){
		int numero;
				
		do{
			numero=MyUtility.leggiIntero(frase);
		}while(numero>max || numero<min);
		
		return numero;
	}
	
	public static String leggiStringa(String frase){
		Scanner lettore=new Scanner(System.in);
		String str;
		
		System.out.println(frase);
		str=lettore.nextLine();
		
		return str;
		
	}
	
	public static String leggiParola(String frase){
		Scanner lettore=new Scanner(System.in);
		String str;
	
		System.out.println(frase);
		str=lettore.next();
	
		return str;
	}
	
	
	/**
	 * permette di ottenere @return un double compreso fra due valori (@param min < double < @param max).
	 * @param frase permette di modificare il messaggioche viene visualizzato prima dell'immissione
	 *  da parte dell'utente.
	 */
	public static double leggiDouble(String frase, double min, double max) {
		
		double numero;
		
		do{
			numero=MyUtility.leggiDouble(frase);
		}while(numero>max || numero<min);
		
		return numero;
	}
	
	/**
	 * 
	 * @param frase: frase che deve essere visualizzata al momento della richiesta di immissione da parte dell'utente.
	 * @return il numero immesso in input
	 */
	public static double leggiDouble(String frase){
		Scanner lettore=new Scanner(System.in);
		boolean termine=false;
		double numero=0;
		
		 
		do{
			System.out.print(frase);
			
			if(lettore.hasNextDouble()==true){
				numero=lettore.nextDouble();
				termine=true;
			}
			else lettore.next();
				
		}while(termine==false);
		
		return numero;
	}
	
	/**
	 * Metodo che consente di ottenere un numero intero compreso fra due valori
	 * @param max rappresenta l'estremo superiore dell'insieme da cui si estraggono i numeri
	 * @param min rappresenta invece l'estremo inferiore.
	 * @return il numero casuale estratto se min<max, altrimenti ritorna 0.
	 */
	public static int interoCasuale(int max, int min){
		Random cas=new Random();
		int num=0;
		
		if(max<min) return num;
		else num=cas.nextInt(max-min)+min;
		
		return num;
	}

	
	public static int sommatoria(int[] vettore) {
		int sommatoria=0;
		
		for(int i=0; i<vettore.length; i++)
			sommatoria+=vettore[i];
		return sommatoria;
	}
	
	public static double sommatoria(double[] vettore) {
		double sommatoria=0;
		
		for(int i=0; i<vettore.length; i++)
			sommatoria+=vettore[i];
		return sommatoria;
	}
	
	public static double media(double ...addendi){
		double media=MyUtility.sommatoria(addendi)/(addendi.length);
		return media;
	}
 }
