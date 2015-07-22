package It.Unibs.Engineer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElencoNazioniTest {
	@Test
	public void testAggiuntaNazione() throws Exception {
		final ElencoNazioni nazioni = new ElencoNazioni();
		nazioni.aggiungiNazione(new Nazione("Italia"));
		nazioni.aggiungiNazione(new Nazione("Spagna"));
		nazioni.aggiungiNazione(new Nazione("Giappone"));
		assertEquals(3, nazioni.getNumeroNazioni());
	}
	
	@Test
	public void testRicercaNazionePresente() throws Exception {
		final ElencoNazioni nazioni = new ElencoNazioni();
		nazioni.aggiungiNazione(new Nazione("Italia"));
		nazioni.aggiungiNazione(new Nazione("Spagna"));
		nazioni.aggiungiNazione(new Nazione("Giappone"));
	    assertEquals(1, nazioni.esiste("Spagna"));
	}
	
	@Test
	public void testRicercaNazioneNonPresente() throws Exception {
		final ElencoNazioni nazioni = new ElencoNazioni();
		nazioni.aggiungiNazione(new Nazione("Italia"));
		nazioni.aggiungiNazione(new Nazione("Spagna"));
		nazioni.aggiungiNazione(new Nazione("Giappone"));
	    assertEquals(-1, nazioni.esiste("Olanda")); // ritorna -1 se non esiste la nazione nell'elenco
	}
}
