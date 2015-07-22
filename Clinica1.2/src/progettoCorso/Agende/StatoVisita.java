package progettoCorso.Agende;


/**
 * Enum StatoVisita.
 * @author Andrea Lorenzoni
 */
public enum StatoVisita {

	PRENOTATA ("Prenotata"),

	CONCLUSA ("Conclusa"),

	REFERTATA ("Refertata"),

	NON_PRENOTABILE ("Non prenotabile");

	private String stato;

	/**
	 * Instanzia un nuovo stato visita.
	 *
	 * @param stato della visita
	 */
	private StatoVisita(String stato){
		this.stato=stato;
	}

	/**
	 * ritorna lo stato.
	 *
	 * @return stato della visita
	 */
	public String getStato(){
		return stato;
	}

}
