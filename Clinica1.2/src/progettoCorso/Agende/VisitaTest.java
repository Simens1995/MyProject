package progettoCorso.Agende;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import progettoCorso.GestioneUtenze.Genere;
import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.Vino;

public class VisitaTest {
	
	private static final LocalDate GIORNO=LocalDate.of(2015, 6, 8), GIORNO_NASCITA=LocalDate.of(2000, 12, 3);
	private static final LocalTime ORA=LocalTime.of(9, 30);
	private static final String MOTIVO="Frattura scomposta all'omero destro";
	private static final Vino PAZIENTE=new Vino("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8), Genere.MASCHIO, "qwerty98j98v157t", 25100 );
	private static final String REFERTO="frattura multipla", PRESCRIZIONE="antimicotico 2 volte al dì";
	private static final PersonaleMedico MEDICO=new PersonaleMedico("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8), Genere.MASCHIO, "qwerty98j98v157t", 25100, null );
	
	@Test
	public void testPrenotaVisita() {
		
		Visita vis=new Visita(LocalDate.of(2015, 6, 8), LocalTime.of(9, 30), MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		assertEquals(vis.getPaziente(), PAZIENTE);
		assertEquals(vis.getMotivo(), MOTIVO);
		assertEquals(vis.getOraInizio(), LocalTime.of(9, 30));
	}

	@Test
	public void testGetPaziente() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		assertEquals(vis.getPaziente(), PAZIENTE);
	}

	@Test
	public void testGetMotivo() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		assertEquals(vis.getMotivo(), MOTIVO);
	}

	@Test
	public void testGetReferto() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		vis.concludiVisita(REFERTO, PRESCRIZIONE);
		assertEquals(vis.getReferto(), REFERTO);
	}

	@Test
	public void testGetStatoVisita() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		assertEquals(vis.getStatoVisita(), StatoVisita.PRENOTATA);
	}

	@Test
	public void testIsPrenotabile() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		assertTrue(vis.isPrenotabile());
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		assertFalse(vis.isPrenotabile());
	}

	@Test
	public void testGetOraInizio() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		assertEquals(vis.getOraInizio(), ORA);
	}
	
	@Test
	public void testGetPrescrizione() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		vis.concludiVisita(REFERTO, PRESCRIZIONE);
		assertEquals(vis.getPrescrizione(), PRESCRIZIONE);
	}

	
	@Test
	public void testEliminaPrenotazioneVisita() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		vis.concludiVisita(REFERTO, PRESCRIZIONE);
		vis.eliminaPrenotazioneVisita();
		assertEquals(vis.getOraInizio(), ORA);
		assertTrue(vis.isPrenotabile());
		assertTrue(vis.getMotivo()==null);
		assertTrue(vis.getReferto()==null);
		assertTrue(vis.getPrescrizione()==null);
	}

	@Test
	public void testGetMedico() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		assertEquals(vis.getMedico(), MEDICO);
	}

	@Test
	public void testGetData() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		assertEquals(vis.getData(), GIORNO);
	}

	@Test
	public void testConcludiVisita() {
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		vis.concludiVisita(REFERTO, PRESCRIZIONE);
		assertTrue(vis.getReferto()==REFERTO);
		assertTrue(vis.getPrescrizione()==PRESCRIZIONE);
	}

}
