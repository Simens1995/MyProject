package It.Unibs.Engineer;

import java.util.ArrayList;
import MyClass.*;
/**
 * Questa classe setta un Cd con dei brani e offre alcune funzionalità fra cui:
 * _Aggiunge un brano in un lista di brani (che formano il Cd);
 * _Get un brano a caso del Cd;
 * _Get titolo Cd;
 * _Selezione di un brano del Cd;
 * _Get descrizione completa del Cd (con i relativi brani);
 * _Get descrione parziale del Cd (senza brani);
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */

public class Cd {
	
		private String titoloAlbum, autore;
		private ArrayList<Brano> brani;
		
	/**
	 * Costruttore della classe Cd
	 * @param titoloAlbum
	 * @param autore
	 */
		public Cd(String titoloAlbum, String autore){
			this.titoloAlbum = titoloAlbum;
			this.autore = autore;
			brani = new ArrayList<>();
		}
		
		/**
		 * Riceve in ingresso un oggetto di tipo Brano e lo aggiunge all'array di brani. Se esiste già un brano 
		 * con lo stesso nome, non lo aggiunge.
		 * @param canzone arraylist contenente titolo e durata del brano.
		 */
		public void aggiungiBrano(Brano canzone){
			
			boolean esiste = false;
			
			for(int i = 0; i < brani.size(); i++){
				   if(canzone.getTitolo().equals(brani.get(i).getTitolo())){
					   esiste = true;
				   }
			}	
			
			if(esiste == false){
				brani.add(canzone);
			}		
		}
		
		/**
		 * Ritorna un brano a caso del Cd.
		 * @return branoRandom ritorna il titolo e la durata di un brano a caso del Cd
		 */
		public Brano branoCasuale(){
			int indice = MyVarie.interoCasuale(brani.size() - 1, 0);
			Brano branoRandom = brani.get(indice);
			return branoRandom;
			
		}

		/**
		 * Ritorna il titolo del Cd.
		 * @return titoloCd
		 */
		public String getTitolo() {
			return titoloAlbum;
		}
		
	/**
	 * Seleziona un brano del Cd
	 * @param n Brano selezionato
	 * @return branoSelezionato se valido, null se inserimento invalido
	 */
		public Brano selezionaBrano(int n) throws IndexOutOfBoundsException{
				Brano branoSelezionato = brani.get(n - 1);
			    return branoSelezionato;
		
		}

	/**
	 * 
	 * @return Descrizione completa del Cd con autore e brani
	 */
	     public String toString(){
	    	 String inizio = (titoloAlbum + " - " + autore + "\n");
	         String listaBrani = "";
	    	 for(int i = 0; i < brani.size(); i++){
	    		 listaBrani = listaBrani + brani.get(i).toString();
	    	 }
	    	 return (inizio + listaBrani);
	     }
	     
	     
	 /**
	  * Descrizione parziale del Cd senza titoli dei brani    
	  * @return breve descrizipone parziale Cd
	  */
	     
	     public String toStringBreve(){
	    	 String breve = (titoloAlbum + " - " + autore + "\n");
	    	 return breve;
	     }
		
	}


