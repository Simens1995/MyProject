package progettoCorso.Agende;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import progettoCorso.GestioneUtenze.Genere;
import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.TipologiaMedico;
import progettoCorso.GestioneUtenze.Vino;

public class AgendaMedicoTest1 {
	private static final LocalDate GIORNO=LocalDate.of(2015, 6, 5), GIORNO_FINE=LocalDate.of(2015, 6, 15), GIORNO_ELIMINA=LocalDate.of(2015, 6, 10);
	private static final LocalTime ORA=LocalTime.of(9, 30), ORA_FINE=LocalTime.of(15, 00), ORARIO=LocalTime.of(11, 30);
	private static final String MOTIVO="Frattura scomposta all'omero destro";
	private static final Vino PAZIENTE=new Vino("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8), Genere.MASCHIO,
			"qwerty98j98v157t", 25100 );
	private static final PersonaleMedico MEDICO=new PersonaleMedico("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8),
			Genere.MASCHIO, "qwerty98j98v157t", 25100, TipologiaMedico.GENERICO ); 
	
	@Test
	public void testGeneraOrarioVisita() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		int n=agenda.getNumeroGiorni();
		
		assertTrue(agenda.containsKey(GIORNO));
		assertTrue(agenda.containsKey(GIORNO_ELIMINA));
	}

	@Test
	public void testEliminaGiornoVisita() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		agenda.eliminaGiornoVisita(GIORNO_ELIMINA);
		assertFalse(agenda.containsKey(GIORNO_ELIMINA));
	}
	

	@Test
	public void testGetMedico() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		assertEquals(agenda.getMedico(), MEDICO);
	}


	@Test
	public void testGetGiornoVisita() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		assertTrue(agenda.getGiornoVisita(GIORNO_ELIMINA)!=null);
		assertEquals(agenda.getGiornoVisita(GIORNO_ELIMINA).getData(), GIORNO_ELIMINA);
	}

	@Test
	public void testGetNumeroGiorni() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(LocalDate.of(2015, 6, 9 ), LocalDate.of(2015, 6, 12), ORA, ORA_FINE);
		assertEquals(agenda.getNumeroGiorni(), 3);
		
	}


	@Test
	public void testContainsKey() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		assertTrue(agenda.containsKey(GIORNO));
		assertFalse(agenda.containsKey(GIORNO_FINE));
		assertTrue(agenda.containsKey(GIORNO_ELIMINA));
	}

	@Test
	public void testCercaVisitePerPaziente() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(GIORNO, GIORNO_FINE, ORA, ORA_FINE);
	}

	@Test
	public void testGetVisite() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		Visita vis1=new Visita(GIORNO_ELIMINA, ORA.plusHours(1), MEDICO);
		vis1.prenotaVisita(PAZIENTE, MOTIVO);
		
		agenda.collocaVisita(vis);
		agenda.collocaVisita(vis1);
		
		assertTrue(agenda.getVisite().get(0)!= null);
		assertTrue(agenda.getVisite().get(1)!= null);
		
	}

	@Test
	public void testCollocaVisita() {
		AgendaMedico agenda=new AgendaMedico(MEDICO);
		agenda.generaOrarioVisita(GIORNO, GIORNO_FINE, ORA, ORA_FINE);
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		agenda.collocaVisita(vis);
		assertTrue(agenda.containsKey(GIORNO));
	}

}
