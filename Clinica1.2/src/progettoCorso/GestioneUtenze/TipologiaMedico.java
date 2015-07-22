package progettoCorso.GestioneUtenze;

/**
 * Enum TipologiaMedico.
 * @author Simaz Andrea
 */
public enum TipologiaMedico {

	/** Specialista. */
	SPECIALISTA ("Specialista"),
	
	/** Generico. */
	GENERICO ("Generico");
	
	/**
	 * VARIABILI
	 */
	private String tipologia;
	
	/**
	 * Instanzia una nuova tipologia di medico.
	 *
	 * @param tipologia the tipologia
	 */
	private TipologiaMedico(String tipologia){
		this.tipologia = tipologia;
	}
	
	/**
	 * Gets la tipologia del medico
	 *
	 * @return la tipologia
	 */
	public String getTipologia(){
		return tipologia;
	}
}
