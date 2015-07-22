package It.Unibs.Engineer;
/**
 * Classe GARA
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */
public class Gara {
    private final int NUM_MEDAGLIA = 3;
	
	private String nomeGara;
	private Nazione [] premiate;
	private boolean eseguita = false;
	
	/**
	 * COSTRUTTORE classe Gara
	 * _Nome della gara
	 * _array contenente il numero di medaglia vinta dalla nazione
	 * @param nomeGara
	 */
	public Gara(String nomeGara){
		this.nomeGara = nomeGara;
		premiate = new Nazione[NUM_MEDAGLIA];
	}
	
	/**
	 * Ritorna il nome di una gara
	 * @return nomeGara
	 */
	public String getGara(){
		return nomeGara;
	}
	/**
	 * Questo metodo ritorna un boolean: _TRUE se una nazione è già stata premiata in quella gara
	 *           						 _FALSE se una nazione non è stata ancora premiata in quella gara
	 * @return eseguita 
	 */
	 public boolean giaPremiata()
		{
		 return eseguita;
		}
	/**
	 * Imposta true se la nazione è già stata premiata
	 */
	 public void setEseguita()
		{
		 eseguita = true;
		}
	/**
	 * Questo metodo aggiunge alla nazione premiata la medaglia (Oro, argento o bronzo)
	 * @param medagliata
	 * @param posizione
	 */
	public void aggiungiPremiata(Nazione medagliata, int posizione){
		premiate[posizione] = medagliata;
	}
}
