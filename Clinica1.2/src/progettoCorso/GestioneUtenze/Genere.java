package progettoCorso.GestioneUtenze;

/**
 * The Enum Genere.
 * @author Andrea Lorenzoni
 */
public enum Genere {

	/** Maschio. */
	MASCHIO ("Maschio"),
	
	/** Femmina. */
	FEMMINA ("Femmina");
	
	/** il Genere. */
	private String genere;
	
	/**
	 * Instantianzia il genere della persona.
	 *
	 * @param genere the genere
	 */
	private Genere(String genere){
		this.genere = genere;
	}
		
	/**
	 * Gets il genere.
	 * @return il genere
	 */
	public String getGenere(){
		return genere;
	}
	
	
	public String toString(){
		String str=getGenere();
		str=str.toLowerCase();
		return str;
	}
}
