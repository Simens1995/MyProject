package It.Unibs.Engineer;
/**
 * Classe NAZIONE
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */
public class Nazione {
	
    private final int NUM_MEDAGLIE = 3;

	private String nomeNazione;
	private int [] medaglie;
	/**
	 * COSTRUTTORE classe Nazione
	 * _nome della nazione
	 * _array contenente le medaglie della nazione
	 * @param nomeNazione
	 */
	public Nazione(String nomeNazione){
		this.nomeNazione = nomeNazione;
		medaglie = new int[NUM_MEDAGLIE];
	}

	/**
	 * Ritorna il nome della nazione
	 * @return
	 */
	public String getNazione(){
		return nomeNazione;
	}
	
	public int getOro(){
		return medaglie[0];
	}
	public int getArgento(){
		return medaglie[1];
	}
	public int getBronzo(){
		return medaglie[2];
	}
	/**
	 * Confronta due nazioni fra loro. Se la nazione passata è migliore della nazione
	 * presa in considerazione, allora ritorna true, altrimenti false.
	 * @param nazione
	 * @return boolean : _TRUE = se la nazione su cui la chiamo è migliore della nazione presa in considerazione
	 *                   _FALSE = se la nazione su cui la chiamo è peggiore della nazione presa in considerazione
	 */
	
	public boolean meglioDi(Nazione nazione){
		if(this.getOro() > nazione.getOro()){
			return true;
		}
		if(this.getOro() < nazione.getOro()){
			return false;
		}
		if(this.getArgento() > nazione.getArgento()){
			return true;
		}
		if(this.getArgento() < nazione.getArgento()){
			return false;
		}
		if(this.getBronzo() > nazione.getBronzo()){
			return true;
		}
		if(this.getBronzo() < nazione.getBronzo()){
			return false;
		}
		return true;
	}
	/**
	 * Incrementa il numero di medaglie di una nazione
	 * @param numMedaglia
	 */
	public void aggiungiMedaglia(int numMedaglia){
		medaglie[numMedaglia]++;	
	}
	
	
	/**
	 * Ritorna il numero di medaglie di una nazione
	 */
	
	public String toString(){
		String risultato = " [ORO, ARGENTO, BRONZO] ";
		for(int i = 0; i < 3; i++){
			risultato = risultato + medaglie[i] + " ";  //DA METTERE A POSTO
		}
		risultato = nomeNazione + risultato + "\n";
		return risultato;
	}
	
	
}
