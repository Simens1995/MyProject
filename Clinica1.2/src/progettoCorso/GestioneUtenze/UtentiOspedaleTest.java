package progettoCorso.GestioneUtenze;

import static org.junit.Assert.*;
import static progettoCorso.GestioneUtenze.Costanti.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import MyLib.MyVarie;
/**
 * 
 * @author Andrea Lorenzoni & Andrea Simaz
 *
 */
public class UtentiOspedaleTest {
	
	    LocalDate date = LocalDate.parse("16-01-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
	    LocalDate date2 = LocalDate.parse("01-07-1995", DateTimeFormatter.ofPattern("dd-MM-uuuu"));
		@Test
		/**
		 * Questo test è utilizzato per verificare l'aggiunta di un utente e la sua relativa ricerca all'interno della lista utenti
		 * @throws Exception
		 */
		public void testAggiuntaMedicoCercaMedico() throws Exception {
			final UtentiOspedale utenti = new UtentiOspedale();
			Vino ut1 = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080);
			Vino ut2 = new Vino("Tiziano", "Fapanni", "Brescia", "030456432", date2, Genere.MASCHIO, "FAPONZ95A01B158U", 25080);
			utenti.aggiungiUtente(ut1);
			utenti.aggiungiUtente(ut2);
			String cod1 = ut1.getCodiceFiscale();
			String cod2 = ut2.getCodiceFiscale();
			
			assertEquals(0, utenti.cercaUtenteNoCod(ut1));
			assertEquals(1, utenti.cercaUtenteNoCod(ut2));
			assertEquals(0, utenti.cercaUtenteCod(cod1));
			assertEquals(1, utenti.cercaUtenteCod(cod2));
			assertEquals(2, utenti.getNumeroUtenti());
		}
		/**
		 * Questo test serve per verificare se un utente viene eliminato dalla lista utenti (sia metodo con e senza codice)
		 * @throws Exception
		 */
		@Test
		public void testEliminaMedico() throws Exception {
			final UtentiOspedale utenti = new UtentiOspedale();
			Vino ut1 = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080);
			Vino ut2 = new Vino("Tiziano", "Fapanni", "Brescia", "030456432", date2, Genere.MASCHIO, "FAPONZ95A01B158U", 25080);
			Vino ut3 = new Vino("Tiziano", "Fapanni", "Brescia", "030456432", date2, Genere.MASCHIO, "FAPONZ95A01B158U", 25080);
		    utenti.aggiungiUtente(ut1);
			utenti.aggiungiUtente(ut2);
			utenti.eliminaUtenteNoCod(ut1);
			assertEquals(1, utenti.getNumeroUtenti());
			assertEquals(0, utenti.cercaUtenteNoCod(ut2));
			utenti.eliminaUtenteNoCod(ut3);
			assertEquals(0, utenti.getNumeroUtenti());
			//Verifica se funziona il metodo equals
			assertTrue(ut2.equals(ut3));
			assertFalse(ut1.equals(ut3));
		}
		
		/**
		 * Questo test serve a testare il funzionamento della descrizione breve dei dati di un utente.
		 * @throws Exception
		 */
		@Test
		public void testToStringDati() throws Exception {
			final String DATI = NOME + "Andrea" + COGNOME + "Simaz" + COD;
			@SuppressWarnings("unused")
			final UtentiOspedale utenti = new UtentiOspedale();
			Vino ut1 = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080);
			StringBuilder cod1 = new StringBuilder(ut1.getCodiceFiscale());
			assertEquals(DATI + cod1, ut1.toStringDati());
		}
		
		/**
		 * Questo test serve a testare il funzionamento della descrizione totale dei dati di un utente.
		 * @throws Exception
		 */
		@Test
		public void testToString() throws Exception {
			final String DATI = NOME + "Andrea" + COGNOME + "Simaz"  + LUOGO_NASC + "Brescia" +
					NUM_TEL + "03045677" + DATA_NASC + MyVarie.toStringData(date) + GENERE + "maschio" + 
					COD +  "SMZNDR95A16B157U" + CAP + 25080;
			@SuppressWarnings("unused")
			final UtentiOspedale utenti = new UtentiOspedale();
			Vino ut1 = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO , "SMZNDR95A16B157U", 25080);
			assertEquals(DATI, ut1.toString());
		}
		
		/**
		 * Serve a testare il metodo getUtente.
		 * @throws Exception
		 */
		@Test
		public void testGetUtente() throws Exception {
			final UtentiOspedale utenti = new UtentiOspedale();
			Vino ut1 = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080);
			Vino ut2 = new Vino("Tiziano", "Fapanni", "Brescia", "030456432", date2, Genere.MASCHIO, "FAPONZ95A01B158U", 25100);
			Vino ut3 = new Vino("Marco", "Simaz", "Brescia", "030456432", date2, Genere.MASCHIO, "MRCONZ98A01B158U", 25080);
			utenti.aggiungiUtente(ut1);
			utenti.aggiungiUtente(ut2);
			utenti.aggiungiUtente(ut3);
			Vino utente = utenti.getUtente(2);
			assertEquals(utente, ut3);
			
		}
		
		/**
		 * Test per verificare se aggiorna l'utente, ad esempio variando il nome.
		 * @throws Exception
		 */
		@Test
		public void testInserisciUtente() throws Exception {
			final UtentiOspedale utenti = new UtentiOspedale();
			Vino ut1 = new Vino("Andreweqfsefaref", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080);
			Vino ut2 = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080);
			Vino utriferimento = new Vino("Andrea", "Simaz", "Brescia", "03045677", date, Genere.MASCHIO, "SMZNDR95A16B157U", 25080);
			utenti.aggiungiUtente(ut1);
			utenti.inserisciUtente(ut2);
			assertEquals(ut2, utriferimento);
			assertEquals(1, utenti.getNumeroUtenti());
		}
		

}
