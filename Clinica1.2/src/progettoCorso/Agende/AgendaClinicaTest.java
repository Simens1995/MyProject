package progettoCorso.Agende;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import progettoCorso.GestioneUtenze.Genere;
import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.TipologiaMedico;
import progettoCorso.GestioneUtenze.Vino;

public class AgendaClinicaTest {
	private static final LocalDate GIORNO=LocalDate.of(2015, 6, 5), GIORNO_FINE=LocalDate.of(2015, 6, 15), GIORNO_ELIMINA=LocalDate.of(2015, 6, 10);
	private static final LocalTime ORA=LocalTime.of(9, 30), ORA_FINE=LocalTime.of(15, 00), ORARIO=LocalTime.of(11, 30);
	private static final String MOTIVO="Frattura scomposta all'omero destro";
	private static final Vino PAZIENTE=new Vino("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8), Genere.MASCHIO,
			"qwerty98j98v157t", 25100 );
	private static final PersonaleMedico MEDICO=new PersonaleMedico("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8),
			Genere.MASCHIO, "qwerty98j98v157t", 25100, TipologiaMedico.GENERICO );
	
	@Test
	public void testCercaDisponibilitaLocalDateLocalTime() {
		AgendaClinica agenda=new AgendaClinica();
		agenda.generaGiorniVisita(MEDICO, GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		ArrayList<Visita> visite=agenda.cercaDisponibilita(MEDICO);
		assertTrue(visite.size()!=0);
	}

	@Test
	public void testCercaDisponibilitaPersonaleMedico() {
		AgendaClinica agenda=new AgendaClinica();
		agenda.generaGiorniVisita(MEDICO, GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		
		ArrayList<Visita> visite=agenda.cercaDisponibilita(MEDICO);
		
		assertTrue(visite.size()>0);
	}

}
