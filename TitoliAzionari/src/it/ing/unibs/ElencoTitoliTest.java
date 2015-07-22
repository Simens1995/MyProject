package it.ing.unibs;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElencoTitoliTest {

	@Test
	public void testAggiungiTitoli() {
		ElencoTitoli e=new ElencoTitoli();
		Titolo t=new Titolo("petrolio", 12);
		e.aggiungiTitoli(t);
		assertTrue(e.getNTitoli()==1);
		assertTrue(e.get(0).equals(t));
	}

	
	@Test
	public void testGetNTitoli() {
		ElencoTitoli e=new ElencoTitoli();
		Titolo t=new Titolo("petrolio", 12);
		Titolo t2=new Titolo("olio", 10);
		e.aggiungiTitoli(t2);
		e.aggiungiTitoli(t);
		
		assertTrue(e.getNTitoli()==2);
		
	}

	@Test
	public void testGet() {
		ElencoTitoli e=new ElencoTitoli();
		Titolo t=new Titolo("petrolio", 12);
		e.aggiungiTitoli(t);
		assertTrue(e.get(0).equals(t));
	}

	@Test
	public void testNuovoGiorno() {
		ElencoTitoli e=new ElencoTitoli();
		Titolo t=new Titolo("petrolio", 12);
		Titolo t2=new Titolo("olio", 10);
		e.aggiungiTitoli(t2);
		e.aggiungiTitoli(t);
		
		e.nuovoGiorno();
		assertFalse(e.get(0).getValore()==12);
		assertFalse(e.get(1).getValore()==10);
		
	}

	@Test
	public void testNuovoGiornoPortafoglio() {
		ElencoTitoli e=new ElencoTitoli();
		Portafoglio p=new Portafoglio("Giovanni");
		Titolo t=new Titolo("petrolio", 12);
		Titolo t2=new Titolo("olio", 10);
		e.aggiungiTitoli(t2);
		e.aggiungiTitoli(t);
		p.addLotto(new Lotto(t, 15));
		
		assertFalse(e.get(0).getValore()==12);
		assertFalse(e.get(1).getValore()==10);
		
		assertTrue(e.get(1).getValore()==p.get(0).getTitolo().getValore());
		
	}

	@Test
	public void testRemove() {
		ElencoTitoli e=new ElencoTitoli();
		Titolo t=new Titolo("petrolio", 12);
		Titolo t2=new Titolo("olio", 10);
		e.aggiungiTitoli(t2);
		e.aggiungiTitoli(t);
		
		e.remove(t2);
		assertTrue(e.getNTitoli()==1);
	}

}
