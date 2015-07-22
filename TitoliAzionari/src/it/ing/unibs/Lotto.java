package it.ing.unibs;

import java.io.Serializable;

/**
 * The Class Lotto.
 */
public class Lotto implements Serializable {

	private Titolo titolo;	
	private int numeroAzioni;
	
	
	/**
	 * Istanzia un nuovo lotto.
	 *
	 * @param titolo the titolo
	 * @param numeroAzioni the numero azioni
	 */
	public Lotto(Titolo titolo, int numeroAzioni) {
		this.titolo = titolo;
		this.numeroAzioni = numeroAzioni;
	
	}
	
	/**
	 * Gets the valore lotto.
	 *
	 * @return the valore lotto
	 */
	public double getValore(){
		return titolo.getValore()*numeroAzioni;
	}
	
	
	/**
	 * Imposta il valore.
	 *
	 * @param valore il nuovo valore
	 */
	public void setValore(double valore) {
		titolo.setValore(valore);
	}
	
	/**
	 * Restituisce titolo.
	 *
	 * @return il titolo richiesto
	 */
	public Titolo getTitolo(){
		return titolo;
	}

	@Override
	public String toString() {
		return "\n\t-" + titolo.toString() + " Azioni possedute: " + numeroAzioni + "";
	}
	
	
}
