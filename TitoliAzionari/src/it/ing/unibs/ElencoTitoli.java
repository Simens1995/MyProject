package it.ing.unibs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import MyClass.MyVarie;
/*import MyLib.MyIO.*;
import MyLib.*;*/

/**
 * The Class ElencoTitoli.
 */
public class ElencoTitoli implements Serializable{

	
	private static final String NO_TITOLI = "Non sono presenti titoli disponibili";
	private ArrayList<Titolo> elenco= new ArrayList<>();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
	
	private LocalDate giorno;
	private static final int VARIAZIONE=10;
	
	/**
	 * Instanzia un nuovo elenco titoli.
	 */
	public ElencoTitoli() {
		giorno=LocalDate.now();
	}
	
	/**
	 * Aggiungi titoli.
	 *
	 * @param t: titolo da aggiungere
	 */
	public void aggiungiTitoli(Titolo t){
		elenco.add(t);
	}

	@Override
	public String toString(){
		StringBuffer str=new StringBuffer();
		
		if(elenco.size()>0){
			str.append("Titoli azionari disponibili al " + giorno.format(formatter) +": \n");
		
			for(int i=0; i<elenco.size(); i++){
				str.append( i+1 +") " + elenco.get(i).toString()+"\n");
			}
		}
		else str.append(NO_TITOLI);
	
		return str.toString();
	}

	/**
	 * ritorna il numero titoli.
	 *
	 * @return numero dei titoli
	 */
	public int getNTitoli() {
		return elenco.size();
	}

	/**
	 * Gets the.
	 *
	 * @param i: posizione dell'elemento da restituire
	 * @return titolo: oggetto all'i-esima posizione
	 */
	public Titolo get(int i) {
		 return  elenco.get(i);
	}
	
	/**
	 * Simulazione di un Nuovo giorno
	 */
	public void nuovoGiorno(){
		giorno.plusDays(1);
		
		//aggiornamento dei valori dei vari titoli
		for(int i=0; i<elenco.size(); i++){
			elenco.get(i).setValore(MyVarie.interoCasuale(VARIAZIONE, -VARIAZIONE));
		}
	}
	
	
	/**
	 * Simulazione di un Nuovo giorno
	 *
	 * @param portafoglio che si vuole aggiornare
	 */
	public void nuovoGiorno(Portafoglio portafoglio){
		giorno.plusDays(1);
		
		//aggiornamento dei valori dei vari titoli
		for(int i=0; i<elenco.size(); i++){
			//fa variare di una percentuale casuale fra + o - 10% del valore iniziale;
			elenco.get(i).setValore(elenco.get(i).getValore()+elenco.get(i).getValore()*MyVarie.interoCasuale(VARIAZIONE, -VARIAZIONE)/100);
			for(int j=0; j<portafoglio.getNTitoli(); j++){
				if(portafoglio.get(j).getTitolo().getNomeTitolo().equals(elenco.get(i).getNomeTitolo())){
					portafoglio.get(j).getTitolo().setValore(elenco.get(i).getValore());
				}
			}
		}
		
	}
	
	/**
	 * Rimuove un oggetto Titolo  @param titolo 
	 */
	public void remove(Titolo titolo){
		elenco.remove(titolo);
	}
}
             