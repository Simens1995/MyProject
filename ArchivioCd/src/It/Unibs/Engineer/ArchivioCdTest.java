package It.Unibs.Engineer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchivioCdTest {
	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertEquals(2, archivio.getNumeroCd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertTrue(archivio.cercaCd("Anime salve")==null ? false : true);
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertFalse(archivio.cercaCd("La buona novella")==null ? false : true);
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.inserisciCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.inserisciCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertEquals(2, archivio.getNumeroCd());
		archivio.eliminaCd("Anime salve");
		assertEquals(1, archivio.getNumeroCd());
		assertFalse(archivio.cercaCd("Anime salve")==null ? false : true);
	}
}
