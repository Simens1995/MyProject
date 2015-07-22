package It.Unibs.Engineer;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CdTest {
	private static final String TITOLO = "Anime salve";
	private static final String AUTORE = "Fabrizio De Andr�";
	
	@Test
	public void testToStringSenzaBrani() throws Exception {
		assertEquals("Anime salve - Fabrizio De Andr�\n", new Cd(TITOLO, AUTORE).toString());
	}
	
	@Test
	public void testToStringConBrani() throws Exception {
		final Cd cd = new Cd(TITOLO, AUTORE);
		cd.aggiungiBrano(new Brano("Anime salve", 352)); //5.52
		cd.aggiungiBrano(new Brano("Le acciughe fanno il pallone", 287)); //4.47
		cd.aggiungiBrano(new Brano("Smisurata preghiera", 428 ));//7.08
		assertEquals("Anime salve - Fabrizio De Andr�\nAnime salve [05:52]\nLe acciughe fanno il pallone [04:47]\nSmisurata preghiera [07:08]\n", cd.toString());
	}
	
	@Test
	public void testHaTitoloTrue() throws Exception {
		final Cd cd = new Cd(TITOLO, AUTORE);
		assertTrue(cd.getTitolo()==TITOLO);
	}
	
	@Test
	public void testHaTitoloFalse() throws Exception {
		final Cd cd = new Cd(TITOLO, AUTORE);
		assertFalse(cd.getTitolo()=="La buona novella");
	}
	
	@Test
	public void testEstrazioneCasualeBrano() throws Exception {
		final Cd cd = new Cd("_A Title_", "_An Author_");
		final int numeroBrani = 10;
		for(int i = 0; i < numeroBrani; i++) {
			cd.aggiungiBrano(new Brano("Brano " + i, i));
		}
		final int numeroEstrazioni = 100;
		Set<String> titoliBraniEstratti = new HashSet<String>();
		for(int i = 0; i < numeroEstrazioni; i++) {
			Brano b = cd.branoCasuale();
			titoliBraniEstratti.add(b.getTitolo());
		}
		assertTrue(titoliBraniEstratti.size() >= 7);
	}
}
