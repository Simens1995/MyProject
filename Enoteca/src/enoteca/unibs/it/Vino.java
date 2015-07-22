package enoteca.unibs.it;

/**
 * @author Simaz Andrea
 * Classe VINO.
 */

public class Vino {

	/**
	 *COSTANTI
	 */
	private final static String NOME = "Il nome del vino : " ;
	private final static String CASA = " La casa produttrice : ";
	private final static String ANNATA = " L'annata del vino : ";
	private final static String QTA = " quantità presente in cantina di quella annata : ";
	private final static String BOTT = " Bottiglie ";
	private final static String PREZZO = " Il prezzo del vino è (euro/bottiglia) : ";
	
	
	private String nomeVino, casaProd;
	private int annata, quantità;
	private double prezzo;
	
	/**
	 * COSTRUTTORE
	 * @param nomeVino
	 * @param casaProd
	 * @param annata
	 * @param quantità
	 * @param prezzo
	 */
	public Vino(String nomeVino, String casaProd, int annata, int quantità, double prezzo){
		this.nomeVino = nomeVino;
		this.casaProd = casaProd; 
		this.annata = annata;
		this.quantità = quantità;
		this.prezzo = prezzo;
	}

	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the annata
	 */
	public int getAnnata() {
		return annata;
	}

	/**
	 * @param annata the annata to set
	 */
	public void setAnnata(int annata) {
		this.annata = annata;
	}

	/**
	 * @return the quantità
	 */
	public int getQuantità() {
		return quantità;
	}

	/**
	 * @param quantità the quantità to set
	 */
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	/**
	 * @return the nomeVino
	 */
	public String getNomeVino() {
		return nomeVino;
	}

	/**
	 * @param nomeVino the nomeVino to set
	 */
	public void setNomeVino(String nomeVino) {
		this.nomeVino = nomeVino;
	}

	/**
	 * @return the casaProd
	 */
	public String getCasaProd() {
		return casaProd;
	}

	/**
	 * @param casaProd the casaProd to set
	 */
	public void setCasaProd(String casaProd) {
		this.casaProd = casaProd;
	}
	
	/**
	 * override metodo toString()
	 * @return String descrVino : descrizione del vino
	 */
	public String toString(){
		String descrVino = (NOME + nomeVino + CASA + casaProd + ANNATA + annata + "\n" + QTA + quantità + BOTT + PREZZO + prezzo);
		return descrVino;
	}
	
}
