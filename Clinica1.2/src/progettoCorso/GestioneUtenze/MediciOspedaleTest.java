package progettoCorso.GestioneUtenze;

import static org.junit.Assert.*;
import static progettoCorso.GestioneUtenze.Costanti.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
/**
 * @author Simaz Andrea
 */

public class MediciOspedaleTest {
	
	/**
	 * TEST MediciOspedale
	 */
	    LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
	    LocalDate date2 = LocalDate.parse("01-07-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		@Test
		public void testAggiuntaMedicoCercaMedico() throws Exception {
			final MediciOspedale medici = new MediciOspedale();
			PersonaleMedico doc1 = new PersonaleMedico("Massimo", "Baudo", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157Z", 25080, TipologiaMedico.GENERICO);
			PersonaleMedico doc2 = new PersonaleMedico("Pippo", "Rossi", "Milano", "030456432", date2, Genere.MASCHIO, "PIPROS65A01B158S", 25100, TipologiaMedico.SPECIALISTA);
			medici.aggiungiMedico(doc1);
			medici.aggiungiMedico(doc2);
			String cod1 = doc1.getCodAlfanumerico();
			String cod2 = doc2.getCodAlfanumerico();
			assertEquals(0, medici.cercaMedicoNoCod(doc1));
		    assertEquals(1, medici.cercaMedicoNoCod(doc2));
			assertEquals(0, medici.cercaMedicoCod(cod1));
			assertEquals(1, medici.cercaMedicoCod(cod2));
			assertEquals(2, medici.getNumeroMedici());
		}
	
		/**
		 * Verifica che i medici immessi possano essere eliminati sia utilizzando il codice che immettendo ogni dato
		 * @throws Exception
		 */
		@Test
		public void testEliminaMedico() throws Exception {
			final MediciOspedale medici = new MediciOspedale();
			PersonaleMedico doc1 = new PersonaleMedico("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080, TipologiaMedico.GENERICO);
			PersonaleMedico doc2 = new PersonaleMedico("Tiziano", "Fapanni", "Brescia", "030456432", date2, Genere.MASCHIO, "FAPONZ95A01B158U", 25080, TipologiaMedico.SPECIALISTA);
			PersonaleMedico doc3 = new PersonaleMedico("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080, TipologiaMedico.GENERICO);
			String cod1 = doc1.getCodAlfanumerico();
			medici.aggiungiMedico(doc1);
			medici.aggiungiMedico(doc2);
			assertTrue(doc1.equals(doc3));
			medici.eliminaMedicoCod(cod1);
			assertEquals(1, medici.getNumeroMedici());
			assertEquals(0, medici.cercaMedicoNoCod(doc2));
			medici.aggiungiMedico(doc3);
			assertEquals(2, medici.getNumeroMedici());
			medici.eliminaMedicoNoCod(doc1);
			assertEquals(1, medici.getNumeroMedici());
			PersonaleMedico doc4 = medici.getMedico(0);
			assertTrue(doc2.equals(doc4));
			
		}
		
		/**
		 * Verifica il corretto aggiornamento di un medico (in sostanza lo sostituisce con il medico preesistente)
		 * @throws Exception
		 */
		@Test
		public void testInserisciMedico() throws Exception {
			final MediciOspedale medici = new MediciOspedale();
			PersonaleMedico doc1 = new PersonaleMedico("Andreawqrwefresf", "Simazasxdasd", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080, TipologiaMedico.GENERICO);
			PersonaleMedico doc2 = new PersonaleMedico("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080, TipologiaMedico.SPECIALISTA);
			PersonaleMedico docRiferimento = new PersonaleMedico("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080, TipologiaMedico.SPECIALISTA);
			medici.aggiungiMedico(doc1);
			medici.inserisciMedico(doc2);
			assertEquals(doc2, docRiferimento);
			assertEquals(1, medici.getNumeroMedici());
		}

		/**
		 * Verifica il corretto funzionamento del toString()
		 * @throws Exception
		 */
		@Test
		public void testToStringDati() throws Exception {
			final String DATI =  NOME_MED + "Andrea" + COGNOME_MED + "Simaz" + COD_MED;
			@SuppressWarnings("unused")
			final MediciOspedale medici = new MediciOspedale();
			PersonaleMedico doc1 = new PersonaleMedico("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080, TipologiaMedico.GENERICO);
			StringBuilder cod1 = new StringBuilder(doc1.getCodAlfanumerico());
			assertEquals(DATI + cod1, doc1.toStringDati());
		}

}
