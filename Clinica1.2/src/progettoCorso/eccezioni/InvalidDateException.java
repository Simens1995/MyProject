package progettoCorso.eccezioni;

/**
 * 
 * @author Andrea Lorenzoni
 */
public class InvalidDateException extends Exception {
	private String causa;
	private static final String DATA_NON_VALIDA="data non valida";
	
	public InvalidDateException(){
		causa=DATA_NON_VALIDA;
	}
	
	public InvalidDateException(String causa){
		this.causa=causa;
	}
}
