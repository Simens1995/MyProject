package unibs.es.tama;
/**
 * Questa classe simula un semplice Tamagochi con due semplici parametri vitali: fame e felicità.
 * 
 * @author Tiziano
 *
 */
public class Tamagochi {
	private final static int DIM_STATI=10;
	private final static double MAX_FELICITA =100, MAX_SAZIETA=100, MIN_FELICITA=0, MIN_SAZIETA=0, LIMITE_INF=30, LIMITE_SUP=90;
	private final static String FRASE_INPUT="inserisci un numero compreso fra 0 e 100 esculsi", F_FELICITA=" come livello di felicità: ", F_SAZIETA=" come livello di fame: ";
	private double sazieta, felicita;		// parametri vitali
	private String nome;					//nome della creatura
	private boolean inVita, benessere;		// controlli di stato VITALE
	
	//estensione: far variare l'effetto degli stimoli in relazione allo stato (quantità e tipo di premi ricevuti negli ultimi DIM_STATI turni)
	private int turno=0, statoBiscotti[]= new int[DIM_STATI], statoCarezze[]=new int[DIM_STATI];
	
	
	public void riceviCarezze(int carezze){
		for(int i=0; i<carezze; i++){
			felicita=felicita+felicita/(MyUtility.sommatoria(statoCarezze));
			statoCarezze[turno%DIM_STATI]++;
		}
		sazieta= sazieta-(carezze/2);
		statoBiscotti[turno%DIM_STATI]=0;
		turno++;
		
		if(felicita>100)
			felicita=100;
			
	}
	
	public void riceviBiscotti(int biscotti){
		for(int i=0; i<biscotti; i++) {
			sazieta =sazieta+sazieta/(MyUtility.sommatoria(statoBiscotti));
			statoBiscotti[turno%DIM_STATI]++;
		}
	
		felicita=felicita-(felicita/MyUtility.sommatoria(statoBiscotti));
		statoCarezze[turno%DIM_STATI]=0;
		turno++;
	}



	public Tamagochi(int max, int min) {
		this.inVita = true;
		
		//generazione casuale dello stato interno al tamagochi al momento iniziale
		for(int i=0; i<DIM_STATI; i++){
			statoBiscotti[i]=MyUtility.interoCasuale(max, min);
			statoCarezze[i]=MyUtility.interoCasuale(max, min);
		}
	}

	public double getSazieta() {
		return sazieta;
	}

	public double getFelicita() {
		return felicita;
	}

	public boolean isInVita() {
		this.setInVita();
		return inVita;
	}

	public boolean isBenessere() {
		this.setBenessere();
		return benessere;
	}

	private void setInVita(){
		if(felicita<MIN_FELICITA || sazieta<MIN_SAZIETA || sazieta>MAX_SAZIETA){
			inVita=false;
		}
		else inVita=true;
		
	}
	
	private void setBenessere(){
		if(felicita<LIMITE_INF || sazieta<LIMITE_INF || sazieta>LIMITE_SUP){
			benessere=false;
		}
		else benessere=true;
		
	}

	public void setSazieta() {
		sazieta=MyUtility.leggiDouble(FRASE_INPUT + F_SAZIETA, MIN_SAZIETA, MAX_SAZIETA);
	}

	public void setFelicita() {
		felicita=MyUtility.leggiDouble(FRASE_INPUT + F_FELICITA, MIN_FELICITA, MAX_FELICITA);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	 
}
