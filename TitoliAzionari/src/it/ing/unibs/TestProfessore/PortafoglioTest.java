package it.ing.unibs.TestProfessore;

import static org.junit.Assert.*;
import it.ing.unibs.Lotto;
import it.ing.unibs.Portafoglio;
import it.ing.unibs.Titolo;

import org.junit.Test;

public class PortafoglioTest {
	@Test
	public void createPortafoglioWithASetOfLottoAndCalculateTheValue() throws Exception {
		Portafoglio p = new Portafoglio();
		p.addLotto(createLotto("XYZ", 10.0, 40));
		p.addLotto(createLotto("ABC", 20.0, 30));
		p.addLotto(createLotto("CBA", 30.0, 20));
		p.addLotto(createLotto("ZYX", 40.0, 10));
		assertEquals(2000.0, p.getValore(), 0.0001);
	}
	
	private Lotto createLotto(String name, double initialValue, int amount) {
		return new Lotto(new Titolo(name, initialValue), amount);
	}
}
