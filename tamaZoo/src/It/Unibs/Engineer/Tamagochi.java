package It.Unibs.Engineer;

import MyClass.MyVarie;

/**
 * Questa classe simula un semplice Tamagochi con due semplici parametri vitali: fame e felicità.
 * 
 * @author Tiziano Fapanni, Andrea Simaz & Andrea Lorenzoni
 *
 */
public class Tamagochi {
	public final static double MAX_FELICITA=100, MAX_SAZIETA=100, MIN_FELICITA=0, MIN_SAZIETA=0, LIMITE_INF=30, LIMITE_SUP=90;
	private final static String TAMA="TamaBase";
	private String tipoTama;
	private double sazieta, felicita;		// parametri vitali
	private String nome;					//nome della creatura
	protected boolean inVita;		        // controlli di stato VITALE
	protected boolean benessere;
	
		
	/**
	 * COSTRUTTORE
	 */
	public Tamagochi(){
		inVita = true;
		sazieta = MyVarie.interoCasuale((int)MAX_SAZIETA, (int)MIN_SAZIETA);
		felicita = MyVarie.interoCasuale((int)MAX_FELICITA, (int)MIN_FELICITA);
		this.setTipoTama(TAMA);
	}
	
	/**
	 * Metodo che modifica i parametri di soddisfazione in relazione alle carezze ricevute
	 * @param carezze numero di carezze ricevute
	 */
	public void riceviCarezze(int carezze){
		felicita = felicita + carezze;
		sazieta = sazieta - (carezze/4);
			
		if(felicita>MAX_FELICITA)
			felicita=MAX_FELICITA;
	}
	
	/**
	 * metodo che modifica i parametri di soddisfazione in realazione ai biscotti ricevuti
	 * @param biscotti numero di biscotti ricevuti
	 */
	public void riceviBiscotti(int biscotti){
		sazieta = sazieta + (sazieta/10) * biscotti;
		felicita = felicita - (biscotti/2);
	}

	/**
	 * 
	 * @return il livello di sazietà
	 */
	public double getSazieta() {
		return sazieta;
	}
	
	/**
	 * 
	 * @return il livello di felicità
	 */
	public double getFelicita() {
		return felicita;
	}
	
	/**
	 * 
	 * @return true se il tamagochi è vivo, false altrimenti
	 */
	public boolean isInVita() {
		this.setInVita();
		return inVita;
	}

	/**
	 * 
	 * @return true se il tamagochi è felice, false altrimenti
	 */
	public boolean isBenessere() {
		this.setBenessere();
		return benessere;
	}
	
	/**
	 * imposta lo stato vitale
	 */
	private void setInVita(){
		if(felicita<MIN_FELICITA || sazieta<MIN_SAZIETA || sazieta>MAX_SAZIETA){
			inVita=false;
		}
		else inVita=true;
	}
	
	/**
	 * imposta il benessere
	 */
	private void setBenessere(){
		if(felicita<LIMITE_INF || sazieta<LIMITE_INF || sazieta>LIMITE_SUP){
			benessere=false;
		}
		else benessere=true;
		
	}

	/**
	 * 
	 * @param sazieta
	 */
	public void setSazieta(double sazieta) {
		this.sazieta=sazieta;
	}

	/**
	 * 
	 * @param felicita
	 */
	public void setFelicita(double felicita) {
		this.felicita=felicita;
	}

	/**
	 * 
	 * @return il nome del tamagochi
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * permette di modificare il nome di un tamagochi impostandolo come tipo del tamagochi seguito da un numero identificativo
	 * @param nTama: indica il numero identificativo del tamagochi
	 */
	public void setNome(int nTama){
		nome = this.getTipoTama() + " " + nTama;
	}
	
	/**
	 * modifica il nome del tamagochi con la stringa passata come parametro.
	 * @param nome 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String toString(){
		String str= nome + "(" + tipoTama + " )";
		if(this.isBenessere()) str= str+" è felice!";
		else str=str+" è triste!";
		double felApprox = Math.round(felicita);
		double sazApprox = Math.round(sazieta);
		
		str=str + "\n\t- Soddisfazione: " + felApprox +"\n\t- Sazietà: " + sazApprox;
		return str;
	}

	/**
	 * @return il tipo di Tamagochi
	 */
	public String getTipoTama() {
		return tipoTama;
	}
	
	/**
	 * permette di modificare il tipo del tamagochi.
	 * @param tipoTama
	 */
	protected void setTipoTama(String tipoTama) {
		this.tipoTama = tipoTama;
	}
	 
}
