package It.Unibs.Engineer;

import static org.junit.Assert.*;

import org.junit.Test;

public class GaraTest {
	private static final String NOME = "salto in lungo";
	
	@Test
	public void testGaraNonEseguita() throws Exception {
		final Gara gara = new Gara(NOME);
		assertFalse(gara.giaPremiata());
	}
	
	@Test
	public void testGaraEseguita() throws Exception {
		final Gara gara = new Gara(NOME);
		gara.setEseguita();
		assertTrue(gara.giaPremiata());
	}
	
}
