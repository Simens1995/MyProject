package GestioneNoleggio;

public class Mezzo {

	private final String SI = " Si", NO = " No";
	private final int LUNGH_COD_CASUALE = 3;
	private static final String CASUAL_NUMERIC_STRING = "0123456789";
	
	private int caricoMax, costoNoleggioGiorno;
	private String numSerie;
	private boolean noleggiato;
	private int durataNoleggio;
	
	public Mezzo(int caricoMax, int costoNoleggio){
		this.caricoMax = caricoMax;
		this.costoNoleggioGiorno = costoNoleggio;
		this.numSerie = generaNumSerie();
		noleggiato = false;
		durataNoleggio = 0;
	}

	/**
	 * @return the durataNoleggio
	 */
	public int getDurataNoleggio() {
		return durataNoleggio;
	}

	/**
	 * @param durataNoleggio the durataNoleggio to set
	 */
	public void setDurataNoleggio(int durataNoleggio) {
		this.durataNoleggio = durataNoleggio;
	}

	

	/**
	 * @return the caricoMax
	 */
	public int getCaricoMax() {
		return caricoMax;
	}

	/**
	 * @param caricoMax the caricoMax to set
	 */
	public void setCaricoMax(int caricoMax) {
		this.caricoMax = caricoMax;
	}

	/**
	 * @return the costoNoleggio
	 */
	public int getCostoNoleggio() {
		return costoNoleggioGiorno;
	}

	public boolean getNoleggiato(){
		return noleggiato;
	}
	/**
	 * @param costoNoleggio the costoNoleggio to set
	 */
	public void setCostoNoleggio(int costoNoleggio) {
		this.costoNoleggioGiorno = costoNoleggio;
	}

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie){
		this.numSerie = numSerie;
	}
	
	public void setNoleggiato(){
		noleggiato = true;
	}
	
	public void setRiportato(){
		noleggiato = false;
	}
	
	/**
	 * @param numSerie the numSerie to set
	 */
	public String generaNumSerie(){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < LUNGH_COD_CASUALE; i++){
			int character = (int)(Math.random()*CASUAL_NUMERIC_STRING.length());
			stringBuilder.append(CASUAL_NUMERIC_STRING.charAt(character));
		}
		return stringBuilder.toString();
	}
	
	/**
	 * overriding del metodo toString
	 */
	public String toString(){
		String descr = ("Numero di serie : " + numSerie + " Costo del noleggio : " + costoNoleggioGiorno + " Carico massimo : " + caricoMax + " Stato del noleggio : ");
		if(noleggiato){
			descr = descr + SI;
		}
		else descr = descr + NO;
		return descr;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + LUNGH_COD_CASUALE;
		result = prime * result + ((NO == null) ? 0 : NO.hashCode());
		result = prime * result + ((SI == null) ? 0 : SI.hashCode());
		result = prime * result + caricoMax;
		result = prime * result + costoNoleggioGiorno;
		result = prime * result + durataNoleggio;
		result = prime * result + (noleggiato ? 1231 : 1237);
		result = prime * result
				+ ((numSerie == null) ? 0 : numSerie.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Mezzo))
			return false;
		Mezzo other = (Mezzo) obj;
		if (LUNGH_COD_CASUALE != other.LUNGH_COD_CASUALE)
			return false;
		if (NO == null) {
			if (other.NO != null)
				return false;
		} else if (!NO.equals(other.NO))
			return false;
		if (SI == null) {
			if (other.SI != null)
				return false;
		} else if (!SI.equals(other.SI))
			return false;
		if (caricoMax != other.caricoMax)
			return false;
		if (costoNoleggioGiorno != other.costoNoleggioGiorno)
			return false;
		if (durataNoleggio != other.durataNoleggio)
			return false;
		if (noleggiato != other.noleggiato)
			return false;
		if (numSerie == null) {
			if (other.numSerie != null)
				return false;
		} else if (!numSerie.equals(other.numSerie))
			return false;
		return true;
	}
}
