package enoteca.unibs.it;

import static org.junit.Assert.*;

import org.junit.Test;

public class VinoTest {

	private final static String NOME = "Il nome del vino : " ;
	private final static String CASA = " La casa produttrice : ";
	private final static String ANNATA = " L'annata del vino : ";
	private final static String QTA = " quantità presente in cantina di quella annata : ";
	private final static String BOTT = " Bottiglie ";
	private final static String PREZZO = " Il prezzo del vino è (euro/bottiglia) : ";
	
	@Test 
	public void testToString() throws Exception {
		
		final Vino vino = new Vino("Barolo", "ViniGildo", 2010, 10, 1.75);
		assertEquals(NOME + "Barolo" + CASA + "ViniGildo" + ANNATA + 2010 + QTA + 10 + BOTT + PREZZO + 1.75, vino.toString());
	}
	
}
