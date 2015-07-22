package It.Unibs.Engineer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchivioCdTest {
	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De Andr�"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De Andr�"));
		assertEquals(2, archivio.getNumeroCd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De Andr�"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De Andr�"));
		assertTrue(archivio.cercaCd("Anime salve")==null ? false : true);
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De Andr�"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De Andr�"));
		assertFalse(archivio.cercaCd("La buona novella")==null ? false : true);
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De Andr�"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De Andr�"));
		assertEquals(2, archivio.getNumeroCd());
		archivio.eliminaCd("Anime salve");
		assertEquals(1, archivio.getNumeroCd());
		assertFalse(archivio.cercaCd("Anime salve")==null ? false : true);
	}
}
