package enoteca.unibs.it;


import java.util.ArrayList;

import MyClass.MyMenu;
import MyClass.MyScelta;
import MyClass.MyIO.MyIOconsole;


/**
 * Classe MAGAZZINO.
 *
 * @author Simaz Andrea
 */
public class Magazzino{
	
	/** COSTANTI. */
	private final static String NULL = "Non hai inserito nessun vino";
	private final static String VINO_PRESENTE = "Il vino è già presente nell'enoteca";
	private final static String VINO_NON_PRES = "Il vino non è presente nell'enoteca";
	private final static String VINI_PRESENTI = "Tutti i vini presenti in enoteca sono i seguenti : \n";
	private final static String VINI_PRESENTI_NOME = "I vini presenti con quel nome sono : \n";
	private final static String TITOLO_AGG = "Aggiornamento vini";
	private final static String[] SCELTE_AGG = {"nome del vino",
												"nome della casa produttrice",
												"annata del vino",
												"prezzo del vino"
												};
	private static final char S = 's', N = 'n';
	private static final String SI_NO=" (s\\n) ";
	private static final String SURE = "Sicuro di uscire ? ";
	private static final String INS_NEW_NOME = "Inserisci nuovo nome del vino : ";
	private static final String INS_NEW_CASA = "Inserisci nuova casa produttrice del vino : ";
	private static final String INS_NEW_ANN = "Inserisci nuova annata del vino : ";
	private static final String INS_NEW_PREZZO = "Inserisci nuovo prezzo del vino : ";
	private static final String QTA_NON = "quantità non prelevabile";
	
	/** The magazzino. */
	private ArrayList<Vino> magazzino;
	
	/**
	 * COSTRUTTORE.
	 */
	public Magazzino(){
		magazzino = new ArrayList<>();
	}
	
	/**
	 * Gets the magazzino.
	 *
	 * @return the magazzino
	 */
	public ArrayList<Vino> getMagazzino() {
		return magazzino;
	}

	/**
	 * Sets the magazzino.
	 *
	 * @param magazzino the magazzino to set
	 */
	public void setMagazzino(ArrayList<Vino> magazzino) {
		this.magazzino = magazzino;
	}

	/**
	 * Aggiunge un vino all'enoteca controllando se l'inserimento non sia nullo e se il vino che si stia inserendo non è già presente (parametri controllati sono
	 * -nome, casa produttrice e annata)
	 * @param vino the vino
	 */
	public void aggiungiVino(Vino vino){
		boolean valido = true;
		if(magazzino.contains(null)){
			valido = false;
			throw new IllegalArgumentException(NULL);
		}
		for(int i = 0; i < magazzino.size(); i++){
			if(magazzino.get(i).getNomeVino().equals(vino.getNomeVino()) && magazzino.get(i).getCasaProd().equals(vino.getCasaProd())){
				int annata = magazzino.get(i).getAnnata();
				int annataVinoSel = vino.getAnnata();
				if(annata == annataVinoSel){
				valido = false;
				throw new IllegalArgumentException(VINO_PRESENTE);
				}
			}
		}
		if(valido){
			magazzino.add(vino);
		}
	}
	
	/**
	 * Aggiungi una quantità di bottiglie definita ad un certo vino di una certa annata.
	 * @param vino the vino
	 * @param quantita the quantita
	 */
	public void aggiungiQta(Vino vino, int quantita){
		boolean valido = true;
		for(int i = 0; i < magazzino.size(); i++){
			if(stringheUguali(magazzino.get(i).getNomeVino(),(vino.getNomeVino())) && stringheUguali(magazzino.get(i).getCasaProd(),(vino.getCasaProd()))){
				int annata = magazzino.get(i).getAnnata();
				int annataVinoSel = vino.getAnnata();
				if(annata == annataVinoSel){
					int qtaVino = magazzino.get(i).getQuantità();
					int newqta = (qtaVino + quantita);
					magazzino.get(i).setQuantità(newqta);
					valido = false;
				}	
			}
		}
		if(valido){
			throw new IllegalArgumentException(VINO_NON_PRES);
		}	
	}
	
	/**
	 * ritorna l'indice di un vino selezionato.
	 * @param vino the vino
	 * @return the indice vino
	 */
	public int getIndiceVino(Vino vino){
		int indice = -1;
		for(int i = 0; i < magazzino.size(); i++){
			if(stringheUguali(magazzino.get(i).getNomeVino(),(vino.getNomeVino())) && stringheUguali(magazzino.get(i).getCasaProd(),(vino.getCasaProd()))){
				int annata = magazzino.get(i).getAnnata();
				int annataVinoSel = vino.getAnnata();
				if(annata == annataVinoSel){
					indice = i;
				}	
			}
		}
		return indice;
	}
	
	/**
	 * Verifica che il vino selezionato sia presente nella lista vini.
	 * @param vino the vino
	 * @return true, if successful
	 */
	public boolean vinoPresente(Vino vino){
		boolean presente = false;
		for(int i = 0; i < magazzino.size(); i++){
			if(stringheUguali(magazzino.get(i).getNomeVino(),(vino.getNomeVino())) && stringheUguali(magazzino.get(i).getCasaProd(),(vino.getCasaProd()))){
				int annata = magazzino.get(i).getAnnata();
				int annataVinoSel = vino.getAnnata();
				if(annata == annataVinoSel){
					presente = true;
				}	
			}
		}
		return presente;
	}
	
	/**
	 * Acquista bottiglie presenti nell'enoteca, nel caso in cui non sia disponibile il vino, non viene venduto niente.
	 * @param vino the vino
	 * @param quantita the quantita
	 * @return the double
	 */
	public double acquistaBottiglie(Vino vino, int quantita){
		double prezzo = 0;
		int indiceVino = getIndiceVino(vino);
		if(indiceVino >= 0){
			int quantitàPres = magazzino.get(indiceVino).getQuantità();
			int newQta = quantitàPres - quantita;
			if(newQta >= 0){
				magazzino.get(indiceVino).setQuantità(newQta);
				prezzo = quantita * magazzino.get(indiceVino).getPrezzo();
				return prezzo;
			}
			else throw new IllegalArgumentException(QTA_NON);
		}
		else{
			throw new IllegalArgumentException(VINO_NON_PRES);
		}
	}
	
	/**
	 * Ritorna un oggetto di tipo Vino dato un indice.
	 * @param indice the indice
	 * @return Vino vino i-esimo
	 */
	public Vino getVino(int indice){
		return magazzino.get(indice);
	}
	
	/**
	 * Override toString().
	 * @return String elencoVini
	 */
	public String toString(){
		String elencoVini = "";
		String elenco = VINI_PRESENTI;
		for(Vino vino : magazzino){
			elencoVini = elencoVini + vino.toString() + "\n";
		}
		return (elenco + elencoVini);
	}
	
	/**
	 * Ritorna l'elenco di un vino scelto.
	 * @param nomeVino the nome vino
	 * @return the string
	 */
	public String stringViniRichiesti(String nomeVino){
		String elencoVini = "";
		String elenco = VINI_PRESENTI_NOME;
		for(int i = 0; i < magazzino.size(); i++){
			if(stringheUguali(magazzino.get(i).getNomeVino(),nomeVino))
					elencoVini = elencoVini + magazzino.get(i).toString();
		}
		return (elenco + elencoVini);
	}
	
	/**
	 * ritorna numero vini presenti in enoteca.
	 * @return numeroVini;
	 */
	public int getNumeroVini(){
		int n = magazzino.size();
		return n;
	}
	
	/**
	 * Confronta se due stringhe sono uguali o meno.
	 * @param str1 the str1
	 * @param str2 the str2
	 * @return true, if successful
	 */
	public static boolean stringheUguali(String str1, String str2){
		if(str1.equals(str2)) return true;
		else return false;
	}
	
	
	//INTERFACCIA PER AGGIORNAMENTO DEL VINO
	/**
	 * Aggiorna un vino presente in magazzino.
	 * @param vino the vino
	 */
	public void aggiornaVino(Vino vino){
		boolean esiste = true;
		boolean finito = false;
		boolean sceltaUscita = true;
		if(esiste){
			MyMenu menu = new MyMenu(TITOLO_AGG, SCELTE_AGG);
			MyScelta sceltaDue= new MyScelta(S, N, SI_NO);
			do{
				int scelta = menu.scegli(sceltaUscita);

				switch(scelta){
				case 0: 
					System.out.println(SURE);
					if(sceltaDue.sceltaDueVie() == true)
						finito = true;
					break;
				case 1 :
					vino.setNomeVino(MyIOconsole.leggiParola(INS_NEW_NOME));
					break;
				case 2 :
					vino.setCasaProd(MyIOconsole.leggiParola(INS_NEW_CASA));
					break;
				case 3 :
					vino.setAnnata(MyIOconsole.leggiIntero(INS_NEW_ANN));
					break;
				case 4 :
					vino.setPrezzo(MyIOconsole.leggiDouble(INS_NEW_PREZZO));
					break;
				}

			}while(!finito);	
		}
	}

}
