package progettoCorso.GestioneUtenze;

import static progettoCorso.GestioneUtenze.Costanti.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import MyLib.MyVarie;
/**
 * 
 * @author Andrea Lorenzoni
 *
 */
public class PersonaleMedicoTest {

	/**
	 * Verifica funzionamento dei toString()
	 */
	@Test
	public void testToStringDati() {
		LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		final PersonaleMedico medico = new PersonaleMedico("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, 
				"SMZNDR95A16B157U", 25080, TipologiaMedico.GENERICO);
		assertEquals(NOME_MED + "Andrea" + COGNOME_MED + "Simaz" + COD_MED + medico.getCodAlfanumerico(), 
				medico.toStringDati());

	}

	@Test
	public void testToString() {
		LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		final PersonaleMedico medico = new PersonaleMedico("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO,
				"SMZNDR95A16B157U", 25080, TipologiaMedico.GENERICO);
		assertEquals(NOME + "Andrea" + COGNOME + "Simaz" + LUOGO_NASC + "Brescia" + NUM_TEL + "03045677" +
				DATA_NASC + MyVarie.toStringData(date) + GENERE + "MASCHIO" + COD + "SMZNDR95A16B157U" + CAP + 25080 + COD_MED + 
				medico.getCodAlfanumerico() + TIPOLOG + "GENERICO", medico.toString());
	}

}
