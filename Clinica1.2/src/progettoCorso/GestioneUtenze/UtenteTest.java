package progettoCorso.GestioneUtenze;

import static org.junit.Assert.assertEquals;
import static progettoCorso.GestioneUtenze.Costanti.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import MyLib.MyVarie;
/**
 * 
 * @author Andrea Lorenzoni
 *
 */
public class UtenteTest {

	@Test
	public void testToStringDati() throws Exception {
		LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		final Vino utente = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, 
				"SMZNDR95A16B157U", 25080);
		assertEquals(NOME + "Andrea" + COGNOME + "Simaz" + COD + "SMZNDR95A16B157U", utente.toStringDati());

	}
	
	@Test
	public void testToString() {
		LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		final Vino utente = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO,
				"SMZNDR95A16B157U", 25080);
		assertEquals(NOME + "Andrea" + COGNOME + "Simaz" + LUOGO_NASC + "Brescia" + NUM_TEL + "03045677" +
				DATA_NASC + MyVarie.toStringData(date) + GENERE + "MASCHIO" + COD + "SMZNDR95A16B157U" + CAP + 25080
				, utente.toString());
	}
    
}
