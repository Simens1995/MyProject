package it.ing.unibs.TestProfessore;

import static org.junit.Assert.*;
import it.ing.unibs.Lotto;
import it.ing.unibs.Titolo;

import org.junit.Test;

public class LottoTest {
	@Test
	public void calculateLottoValue() throws Exception {
		Titolo titolo = new Titolo("XYZ", 10.1);
		Lotto lotto = new Lotto(titolo, 15);
		assertEquals(151.5, lotto.getValore(), 0.0001);
	}
}
