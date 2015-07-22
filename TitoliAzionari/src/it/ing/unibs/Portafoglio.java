package it.ing.unibs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe Portafoglio.
 */
public class Portafoglio implements Serializable {
	
	
	private String proprietario;
	
	
	private ArrayList<Lotto> portafoglio= new ArrayList<>();
	
	
	private double valore;
	
	/**
	 * Istanzia un nuovo portafoglio.
	 *
	 * @param proprietario il proprietario del portafoglio;
	 */
	public Portafoglio(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public Portafoglio() {
		proprietario=null;
	}

	/**
	 * Aggiunge un nuovo titolo sottoforma di Lotto.
	 *
	 * @param l il Lotto da aggiungere
	 */
	public void addLotto(Lotto l){
		portafoglio.add(l);
	}
	
	/**
	 * Calcola valore del portafoglio.
	 */
	private void calcolaValore(){
		valore=0;
		for(int i=0; i<portafoglio.size(); i++){
			valore += portafoglio.get(i).getValore(); 
		}
	}
	
	@Override
	public String toString() {
		double valoreApp= Math.round(getValore()*100);
		valoreApp/=100;
		return "Portafoglio di " + proprietario + ", $"
				+ valoreApp + "";
	}
	
	/**
	 * To string completo del dettaglio di tutti i pacchetti di azioni posseduti
	 *
	 * @return la descrizione completa del portafoglio
	 */
	public String toStringCompleto() {
		calcolaValore();
		String str = "\n" + toString();
		
		for(int i=0; i<portafoglio.size(); i++){
			str+= (portafoglio.get(i).toString());
		}
		
		return str;
	}

	/**
	 * Restituisce il valore del portafoglio
	 *
	 * @return il valore del portafoglio
	 */
	public double getValore(){
		calcolaValore();
		return valore;
	}
	

	/**
	 * Restituisce numero di titoli.
	 *
	 * @return il numero di titoli
	 */
	public int getNTitoli() {
		return portafoglio.size();
	}

	/**
	 * Restituisce l' n-esimo Lotto 
	 *
	 * @param n posizione del Lotto da restituire
	 * @return Lotto richiesto.
	 */
	public Lotto get(int n) {
		return portafoglio.get(n);
	}

	/**
	 * Rimuove un elemento di tipo Lotto
	 *
	 * @param lotto: elemento da eliminare
	 */
	public void remove(Lotto lotto) {
		portafoglio.remove(lotto);
		
	}
}
