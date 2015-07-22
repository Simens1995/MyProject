package it.ing.unibs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TitoloTest {

	@Test
	public void testGetNomeTitolo() {
		Titolo t=new Titolo("petrolio", 12);
		assertTrue(t.getNomeTitolo()=="petrolio");
	}

	@Test
	public void testSetNomeTitolo() {
		Titolo t=new Titolo("petrolio", 12);
		t.setNomeTitolo("banca");
		
		assertTrue(t.getNomeTitolo()=="banca");

	}

	@Test
	public void testGetValore() {
		Titolo t=new Titolo("petrolio", 12);
		assertTrue(t.getValore()==12);
	}

	@Test
	public void testSetValore() {
		Titolo t=new Titolo("petrolio", 12);
		t.setValore(10);
		assertTrue(t.getValore()==10);
	}

}
