package it.ing.unibs;

import static org.junit.Assert.*;

import org.junit.Test;

public class PortafoglioTest {

	@Test
	public void testAggiungiTitolo() {
		Portafoglio p=new Portafoglio("Giovanni");
		Lotto l=new Lotto(new Titolo("petrolio", 12), 10);
		p.addLotto(l);
		assertTrue(l.equals(p.get(0)));
	}

	@Test
	public void testGetValore() {
		Portafoglio p=new Portafoglio("Giovanni");
		Lotto l=new Lotto(new Titolo("petrolio", 12), 10);
		p.addLotto(l);
		assertTrue(p.getValore()==12*10);
	}

	@Test
	public void testGetNTitoli() {
		Portafoglio p=new Portafoglio("Giovanni");
		Lotto l=new Lotto(new Titolo("petrolio", 12), 10);
		p.addLotto(l);
		
		assertTrue(p.getNTitoli()==1);
	}

	@Test
	public void testGet() {
		Portafoglio p=new Portafoglio("Giovanni");
		Lotto l=new Lotto(new Titolo("petrolio", 12), 10);
		p.addLotto(l);
		
		assertTrue(p.get(0)==l);
	}

	@Test
	public void testRemove() {
		Portafoglio p=new Portafoglio("Giovanni");
		Lotto l=new Lotto(new Titolo("petrolio", 12), 10);
		p.addLotto(l);
		p.remove(l);
		assertTrue(p.getNTitoli()==0);
	}

}
