package progettoCorso.generale;

import java.io.Serializable;

import progettoCorso.Agende.AgendaClinica;
import progettoCorso.GestioneUtenze.MediciOspedale;
import progettoCorso.GestioneUtenze.UtentiOspedale;

public class Clinica implements Serializable{
	public static final int ORA_APERTURA = 8, ORA_CHIUSURA=18 ;
	private AgendaClinica agenda;
	private MediciOspedale elencoMedici;
	private UtentiOspedale elencoUtenti;
	
	public Clinica(){
		agenda = new AgendaClinica();
		elencoMedici = new MediciOspedale();
		elencoUtenti = new UtentiOspedale();
	}
	
	public AgendaClinica getAgenda(){
		return agenda;
	}

	public MediciOspedale getElencoMedici() {
		
		return elencoMedici;
	}
	
	public UtentiOspedale getElencoUtenti(){
		return elencoUtenti;
	}

	public void setAgenda(AgendaClinica agenda) {
		this.agenda = agenda;
	}

	public void setElencoMedici(MediciOspedale elencoMedici) {
		this.elencoMedici = elencoMedici;
	}

	public void setElencoUtenti(UtentiOspedale elencoUtenti) {
		this.elencoUtenti = elencoUtenti;
	}
	
	

}
