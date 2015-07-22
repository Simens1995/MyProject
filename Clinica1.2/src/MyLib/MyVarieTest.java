/**
 * 
 */
package MyLib;

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
	 * Test method for {@link MyLib.MyVarie#validCodFiscale(java.lang.String)}.
	 */
	@Test
	public void testValidCodFiscale() {
		String codGiusto = "smzndr95a16b157u";
		String codSbagliato = "sasdfefrewfksdkf";
		assertTrue(MyVarie.validCodFiscale(codGiusto));
		assertFalse(MyVarie.validCodFiscale(codSbagliato));
	}

	/**
	 * Test method for {@link MyLib.MyVarie#toStringData(java.time.LocalDate)}.
	 */
	@Test
	public void testToStringData() {
		LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		assertEquals("16/JANUARY/1995", MyVarie.toStringData(date));
	}

}
