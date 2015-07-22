/**
 * 
 */
package enoteca.unibs.it;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Andrea
 *
 */
public class MagazzinoTest {

	/**
	 * @throws java.lang.Exception
	 */
	
/**
 * Test aggiunta vino nel magazzino
 */
	@Test
	public void testAggiungiVino() {
		final Magazzino magazzino = new Magazzino();
		Vino v1 = new Vino("Barolo", "ViniGildo", 2010, 10, 1.75);
		Vino v2 = new Vino("Lugana", "ViniGildo", 2010, 20, 1.50);
		Vino v3 = new Vino("Barolo", "ViniGildo", 1990, 7, 10.60);
		magazzino.aggiungiVino(v1);
		magazzino.aggiungiVino(v2);
		magazzino.aggiungiVino(v3);
		
		assertEquals(3, magazzino.getNumeroVini());
		assertTrue(magazzino.vinoPresente(v2));
	}
	
/**
 * Test aggiungi bottiglie di vino a vini pre-esistenti
 */
	@Test
	public void testCompraQuantitaVino() {
		final Magazzino magazzino = new Magazzino();
		Vino v1 = new Vino("Barolo", "ViniGildo", 2010, 10, 1.75);
		Vino v2 = new Vino("Lugana", "ViniGildo", 2010, 20, 1.50);
		Vino v3 = new Vino("Barolo", "ViniGildo", 1990, 7, 10.60);
		magazzino.aggiungiVino(v1);
		magazzino.aggiungiVino(v2);
		magazzino.aggiungiVino(v3);
		magazzino.aggiungiQta(v1, 40);
		magazzino.aggiungiQta(v3, 100);
		
		assertEquals(50, v1.getQuantità());
		assertEquals(107, v3.getQuantità());
	}

/**
 * Test vendita vini	
 */
	@Test
	public void testVendiQuantitaVino() {
		final Magazzino magazzino = new Magazzino();
		Vino v1 = new Vino("Barolo", "ViniGildo", 2010, 10, 1.75);
		Vino v2 = new Vino("Lugana", "ViniGildo", 2010, 20, 1.50);
		Vino v3 = new Vino("Barolo", "ViniGildo", 1990, 7, 10.60);
		magazzino.aggiungiVino(v1);
		magazzino.aggiungiVino(v2);
		magazzino.aggiungiVino(v3);
		double prezzo = magazzino.acquistaBottiglie(v2, 10);
		
		assertEquals(v2.getQuantità(), 10);
		assertEquals(prezzo, 15.0, 00);
	}
	
	/**
	 * Test per verficare che funzioni il metodo che ritorna l'indice di un vino
	 */
	@Test
	public void testIndiceVino() {
		final Magazzino magazzino = new Magazzino();
		Vino v1 = new Vino("Barolo", "ViniGildo", 2010, 10, 1.75);
		Vino v2 = new Vino("Lugana", "ViniGildo", 2010, 20, 1.50);
		Vino v3 = new Vino("Barolo", "ViniGildo", 1990, 7, 10.60);
		magazzino.aggiungiVino(v1);
		magazzino.aggiungiVino(v2);
		
		assertEquals(-1, magazzino.getIndiceVino(v3));
		assertEquals(1, magazzino.getIndiceVino(v2));
	}
		
}
