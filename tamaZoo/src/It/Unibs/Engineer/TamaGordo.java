package It.Unibs.Engineer;
/**
 * Implementazione del TamaGordo
 * @author  Tiziano Fapanni, Andrea Simaz & Andrea Lorenzoni
 *
 */
public class TamaGordo extends Tamagochi {
	protected final static String TAMA_GORDO="TamaGordo";
	
	/**
	 * COSTRUTTORE
	 */
	public TamaGordo() {
		super();	
		this.setFelicita(MAX_FELICITA);
		this.setTipoTama(TAMA_GORDO);
	}
	
	/**
	 * imposta la felicità del tamagochi.
	 */
	private void setBenessere(){
		if(this.getSazieta()<LIMITE_INF)
			benessere=false;
		else benessere=true;
	}
	/**
	 * 
	 * imposta lo stato vitale del tamagochi.
	 */
	private void setInVita(){
		if(this.getSazieta()<=MIN_SAZIETA){
			super.inVita=false;
		}
		else super.inVita=true;
	}
	
	/**
	 * Metodo che modifica i parametri di soddisfazione in relazione alle carezze ricevute
	 * @param carezze numero di carezze ricevute
	 */
	public void riceviCarezze(int carezze){
		this.setSazieta(this.getSazieta()-carezze/2.0);
	}
	
	/**
	 * metodo che modifica i parametri di soddisfazione in realazione ai biscotti ricevuti
	 * @param biscotti numero di biscotti ricevuti
	 */
	public void riceviBiscotti(int biscotti){
		this.setSazieta(this.getSazieta()*(1+biscotti/10.0));
		if(this.getSazieta()>MAX_SAZIETA) this.setSazieta(MAX_SAZIETA);
	}
	
}
