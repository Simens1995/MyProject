package It.Unibs.Engineer;

/**
 * Implementazione del TamaTriste
 * @author  Tiziano Fapanni, Andrea Simaz & Andrea Lorenzoni
 *
 */
public class TamaTriste extends Tamagochi{
	protected final static String TAMA_TRISTE="TamaTriste";
	
	/**
	 * COSTRUTTORE
	 */
	public TamaTriste() {
		super();
		this.inVita=true;
		this.benessere=false;
		this.setFelicita(MIN_FELICITA);
		this.setTipoTama(TAMA_TRISTE);
	}
	
	/**
	 * 
	 * imposta la felicità del tamagochi, in questo caso è sempre false.
	 */
	private void setBenessere(){
		benessere=false;
	}
	
	/**
	 * imposta lo stato vitale  del tamagochi
	 */
	private void setInVita(){
		if(this.getSazieta()<=MIN_SAZIETA || this.getSazieta()>MAX_SAZIETA){
			inVita=false;
		}
		else inVita=true;
	}
	
	/**
	 * Metodo che modifica i parametri di soddisfazione in relazione alle carezze ricevute
	 * @param carezze numero di carezze ricevute
	 */
	public void riceviCarezze(int carezze){
		this.setSazieta(this.getSazieta()-carezze/2);
	}
	
	/**
	 * metodo che modifica i parametri di soddisfazione in realazione ai biscotti ricevuti
	 * @param biscotti numero di biscotti ricevuti
	 */
	public void riceviBiscotti(int biscotti){
		this.setSazieta(this.getSazieta()*(1+biscotti/10.0));
		
	}
	

}
