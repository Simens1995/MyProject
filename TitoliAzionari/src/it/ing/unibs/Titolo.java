package it.ing.unibs;

import java.io.Serializable;

import MyClass.MyVarie;
import MyClass.MyIO.MyIOconsole;

/**
 * Classe Titolo
 */
public class Titolo implements Serializable{
	
	
	private String nomeTitolo;
	
	
	private double valore;
	
	
	/**
	 * Instantiates a new titolo.
	 *
	 * @param nomeTitolo il nome del titolo
	 * @param valore del titolo
	 */
	public Titolo(String nomeTitolo, double valore) {
		this.nomeTitolo = nomeTitolo;
		this.valore = valore;
	}

	/**
	 * Restituisce il nome del titolo.
	 *
	 * @return il nome del titolo
	 */
	public String getNomeTitolo() {
		return nomeTitolo;
	}
	
	
	/**
	 * Imposta il nome del titolo.
	 *
	 * @param nomeTitolo il nuovo nome del titolo
	 */
	public void setNomeTitolo(String nomeTitolo) {
		this.nomeTitolo = nomeTitolo;
	}

	/**
	 * Restituisce il valore.
	 *
	 * @return il valore
	 */
	public double getValore() {
		return valore;
	}

	/**
	 * Imposta il valore.
	 *
	 * @param valore: il nuovo valore
	 * @throws Exception 
	 */
	public void setValore(double valore) throws IllegalArgumentException {
		if(valore>=0){
			this.valore = valore;
		}else throw new IllegalArgumentException();
	}

	/*@Override
	public String toString() {
		double valoreApp= (Math.round(getValore()*10000));
		valoreApp/=10000;
		return "Titolo: " + nomeTitolo + ", " + valoreApp + " $;";
	}*/

	public void registraVariazione(double d) throws IllegalArgumentException {
		setValore(valore+d);
	}

	@Override
	public String toString() {
		return nomeTitolo + " [" + MyIOconsole.stampaDouble(valore, 3) + "]";
	}
	
		
}
