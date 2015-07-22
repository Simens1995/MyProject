package It.Unibs.Engineer;

import java.util.ArrayList;
import MyClass.MyVarie;

/**
 * Questa classe setta un archivio Cd e offre le seguenti funzionalità:
 * _Aggiunge un Cd, se non esiste già
 * _Cerca un Cd presente nella collezione dei Cd
 * _Elimina un Cd presente nella collezione dei Cd
 * _Prende un Cd a caso presente nella collezione dei Cd
 * _Ritorna una stringa contenente le informazioni del Cd
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */
public class ArchivioCD {
	private ArrayList<Cd> collezioneCd;
	
	/**
	 * COSTRUTTORE
	 * 
	 */
	public ArchivioCD() {
		collezioneCd = new ArrayList<Cd>();
	}
	
	/**
	 * permette di inserire un nuovo album (CD) in memoria.
	 * @param cd
	 */
	public boolean inserisciCd(Cd cd){		
		if(this.esisteIn(cd.getTitolo())==-1) {
			collezioneCd.add(cd);
			return true;
		}
		else return false;
	}
	
	/**
	 * metodo di ricerca interna
	 * @param titolo
	 * @return
	 */
	private int esisteIn(String titolo){
		int esiste=-1;
		for(int i=0; i<collezioneCd.size(); i++){
			if(titolo.equals(collezioneCd.get(i).getTitolo())){
				esiste=i;
			}
		}
		return esiste;
	}
	
	/**
	 * 
	 * @param titolo: stringa contenente il titolo della canzone da cercare
	 * @return l'Album corrispondente o null in caso non fiosse presente.
	 */
	public Cd cercaCd(String titolo){
		int indice=esisteIn(titolo);
		
		if(indice>=0) return collezioneCd.get(indice);
		else return null;
	}
	
	/**
	 * 
	 * @param titolo dell'Album da eliminare
	 * @return true se l'eliminazione avviene con successo, false altrimenti
	 */
	public boolean eliminaCd(String titolo){
		return collezioneCd.remove(this.cercaCd(titolo));
	}
	
	/**
	 * permette di estrarre casualmente un cd
	 * @return il cd estratto casualmente
	 */
	public Cd cdCasuale(){
		return collezioneCd.get(MyVarie.interoCasuale(collezioneCd.size() - 1, 0));
	}
	
	/**
	 * permette di ottenere informazioni riguardanti l'album.
	 * @return ritorno Dà informazioni riguardanti gli album nel Cd
	 */
	public String toString(){
		String ritorno = "Archivio CD";
		for(int i = 0; i < collezioneCd.size(); i++){
			ritorno = ritorno + "\n\t" + collezioneCd.get(i).toStringBreve();
		}
		return ritorno;
	}
    /**
     * @return collezioneCd.size() ritorna il numero del cd
     */
	public int getNumeroCd() {
		return collezioneCd.size();
	}
}
