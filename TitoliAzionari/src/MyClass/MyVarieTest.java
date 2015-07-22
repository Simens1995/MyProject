/**
 * 
 */
package MyClass;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * @author Simaz Andrea
 *
 */
public class MyVarieTest {

	/**
	 * Test method for {@link MyClass.MyVarie#validCodFiscale(java.lang.String)}.
	 */
	@Test
	public void testValidCodFiscale() {
		String codGiusto = "smzndr95a16b157u";
		String codSbagliato = "sasdfefrewfksdkf";
		assertTrue(MyVarie.validCodFiscale(codGiusto));
		assertFalse(MyVarie.validCodFiscale(codSbagliato));
	}

	/**
	 * Test method for {@link MyClass.MyVarie#toStringData(java.time.LocalDate)}.
	 */
	@Test
	public void testToStringData() {
		LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		assertEquals("16/JANUARY/1995", MyVarie.toStringData(date));
	}
	
	@Test
	public void testStringheUguali() {
		String str1="qwerty78a15b963e";	//riferimento
		String str2="qwertz78a15b963e"; //cambia una lettera
		String str3="qwerty78a15b963e"; //uguale
		String str4="qwerty68a15b963e"; //cambia un numero
		String str5="qwerty78b15b964e"; //cambia lettera e numero
		
		assertTrue(MyVarie.stringheUguali(str1, str3));
		assertFalse(MyVarie.stringheUguali(str1, str2));
		assertFalse(MyVarie.stringheUguali(str1, str4));
		assertFalse(MyVarie.stringheUguali(str1, str5));
	}

}
