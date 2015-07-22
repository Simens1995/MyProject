package progettoCorso.Agende;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import progettoCorso.GestioneUtenze.Genere;
import progettoCorso.GestioneUtenze.PersonaleMedico;
import progettoCorso.GestioneUtenze.TipologiaMedico;
import progettoCorso.GestioneUtenze.Vino;

public class GiornoVisitaTest {
	
	private static final LocalDate GIORNO=LocalDate.of(2015, 6, 8), GIORNO_NASCITA=LocalDate.of(2000, 12, 3);
	private static final LocalTime ORA=LocalTime.of(9, 30), ORA_FINE=LocalTime.of(15, 00), ORARIO=LocalTime.of(11, 30);
	private static final String MOTIVO="Frattura scomposta all'omero destro";
	private static final Vino PAZIENTE=new Vino("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8), Genere.MASCHIO,
			"qwerty98j98v157t", 25100 );
	private static final Vino PAZIENTE2=new Vino("Pietro", "Bianchi", "Bergamo", "222444555",LocalDate.of(2015, 6, 3), Genere.MASCHIO,
			"qperty98j98v157t", 25100 );
	private static final PersonaleMedico MEDICO=new PersonaleMedico("Piero", "Rossi", "brescia", "333444555",LocalDate.of(2015, 6, 8),
			Genere.MASCHIO, "qwerty98j98v157t", 25100, TipologiaMedico.GENERICO ); 

	
	@Test
	public void testAddVisitaVisita() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		giorno.addVisita(vis);
		assertTrue(giorno.containsKey(ORA));
		assertFalse(giorno.isPrenotato());
		assertEquals(giorno.getVisita(ORA), vis);
		
		vis=new Visita(GIORNO, ORA.plusHours(2), MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		giorno.addVisita(vis);
		assertTrue(giorno.containsKey(ORA.plusHours(2)));
		assertEquals(giorno.getVisita(ORA.plusHours(2)), vis);
		assertTrue(giorno.isPrenotato());
	}

	@Test
	public void testAddVisitaLocalTime() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		giorno.addVisita(ORARIO);
		assertEquals(giorno.getVisita(ORARIO).getOraInizio(), ORARIO);
		assertFalse(giorno.isPrenotato());
	}

	@Test
	public void testGetData() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		assertEquals(giorno.getData(), GIORNO);
	}

	@Test
	public void testGetVisita() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		giorno.addVisita(vis);
		assertEquals(giorno.getVisita(ORA), vis);
	}

	@Test
	public void testGetOraInizio() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		assertEquals(ORA, giorno.getOraInizio());
	}

	@Test
	public void testGetOraFine() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		assertEquals(ORA_FINE, giorno.getOraFine());
	}

	@Test
	public void testContainsKey() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		assertTrue(giorno.containsKey(ORA));
		assertTrue(giorno.containsKey(ORARIO));
	}

	@Test
	public void testIsPrenotato() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		giorno.addVisita(vis);
		assertFalse(giorno.isPrenotato());
		
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		giorno.addVisita(vis);
		assertTrue(giorno.isPrenotato());
		
		
	}
	
	@Test
	public void testCercaVisitePerPaziente() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		vis.prenotaVisita(PAZIENTE, MOTIVO);
		Visita vis1=new Visita(GIORNO, ORA.plusHours(1), MEDICO);
		vis1.prenotaVisita(PAZIENTE2, MOTIVO);
		
		giorno.addVisita(vis1);
		giorno.addVisita(vis);
		
		for(int i=0; i<giorno.cercaVisitePerPaziente(PAZIENTE).size(); i++){
			if(!giorno.cercaVisitePerPaziente(PAZIENTE).get(i).isPrenotabile())
				assertEquals(giorno.cercaVisitePerPaziente(PAZIENTE).get(i), vis);
		}

		
	}

	@Test
	public void testGetVisite() {
		GiornoVisita giorno=new GiornoVisita(GIORNO, ORA, ORA_FINE,MEDICO);
		Visita vis=new Visita(GIORNO, ORA, MEDICO);
		Visita vis1=new Visita(GIORNO, ORARIO, MEDICO);
		giorno.addVisita(vis1);
		giorno.addVisita(vis);
		
		
		assertTrue(giorno.getVisite().contains(vis1));
		assertTrue(giorno.getVisite().contains(vis));
			
		
	}

}
