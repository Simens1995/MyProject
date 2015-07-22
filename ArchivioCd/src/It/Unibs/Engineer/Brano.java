package It.Unibs.Engineer;
/**
 * Questa classe setta un brano e ha le seguenti funzionalità:
 * _Converte un intero in minuti e secondi;
 * _Get titolo;
 * _Get descrizione del brano.
 * @author Fapanni Tiziano & Simaz Andrea
 */


public class Brano {

	private String titolo;
	private int totalSec;
	
/**
 * Costruttore della classe Brano
 * @param titolo titolo del brano
 * @param duration durata del brano
 */
	public Brano(String titolo, int totalSec){
		this.titolo = titolo;
		this.totalSec= totalSec;
	}	

/**
 * converte un intero in una stringa formato minuti e secondi
 * @return timeString stringa formata da minuti e secondi
 */
	public String timeBrano(){
		int minutes = (totalSec % 3600) / 60;
		int seconds = totalSec % 60;
		return String.format("%02d:%02d", minutes, seconds);
	}
/**
 * Ritorna il titolo del brano
 * @return titolo
 */
	public String getTitolo() {
		return titolo;
	}

/**
 * Descrizione brano.
 * @return String descrizione della canzone con nome del brano e durata.
 */
	public String toString(){
		return (titolo +" [" + timeBrano() + "]" + "\n");
	}
}
