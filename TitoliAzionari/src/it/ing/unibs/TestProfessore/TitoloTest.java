package it.ing.unibs.TestProfessore;

import static org.junit.Assert.*;
import it.ing.unibs.Titolo;

import org.junit.Test;

public class TitoloTest {
	@Test
	public void stringRepresentationShouldContainNameAndValue() throws Exception {
		assertEquals("Goofie LTD [50,000]", new Titolo("Goofie LTD", 50.0D).toString());
	}
	
	@Test
	public void stringRepresentationShouldContainAtLeastOneIntegerCharacterForValue() throws Exception {
		assertEquals("Goofie LTD [0,550]", new Titolo("Goofie LTD", 0.55D).toString());
	}
	
	@Test
	public void stringRepresentationShouldChangeAsEffectOfValueChanges() throws Exception {
		Titolo titolo = new Titolo("Donald Duck, INC.", 100);
		titolo.registraVariazione(1.331);
		assertEquals("Donald Duck, INC. [101,331]", titolo.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void valueCantGoUnderZero() throws Exception {
		Titolo titolo = new Titolo("Scrooge, INC", 10);
		titolo.registraVariazione(-11);
	}
}
