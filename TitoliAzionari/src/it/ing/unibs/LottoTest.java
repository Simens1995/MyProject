package it.ing.unibs;

import static org.junit.Assert.*;

import org.junit.Test;

public class LottoTest {

	@Test
	public void testGetValoreLotto() {
		Lotto l=new Lotto(new Titolo("petrolio", 12), 10);
		assertTrue(l.getValore()==12*10);
	}

	@Test
	public void testSetValore() {
		Titolo t=new Titolo("petrolio", 12);
		Lotto l=new Lotto(t, 10);
		
		t.setValore(12);
		l.setValore(12);
		
		assertTrue(t.getValore()==l.getTitolo().getValore());
	}

	@Test
	public void testGetTitolo() {
		Titolo t=new Titolo("petrolio", 12);
		Lotto l=new Lotto(t, 10);
		
		assertTrue(t.equals(l.getTitolo()));
	}

}
