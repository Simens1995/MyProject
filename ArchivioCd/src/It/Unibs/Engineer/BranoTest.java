package It.Unibs.Engineer;

import static org.junit.Assert.*;

import org.junit.Test;

public class BranoTest {
	private static final String TITOLO = "Il pescatore";
	private static final int DURATA = 286;

	@Test
	public void testToString() throws Exception {
		assertEquals("Il pescatore [04:46]\n", new Brano(TITOLO, DURATA).toString());
	}
}
