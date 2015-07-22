package It.Unibs.Engineer;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author  Tiziano Fapanni, Andrea Simaz & Andrea Lorenzoni
 *
 */
public class TamaGordoTest {
	private static double EPSILON= 1E14;
	
	@Test
	public void testRiceviCarezze() {
		TamaGordo tama=new TamaGordo();
		tama.setSazieta(50.0);
		tama.riceviCarezze(8);
		assertEquals(tama.MAX_FELICITA, tama.getFelicita(), EPSILON);
		assertEquals(0.0, tama.getSazieta(), EPSILON);
	}

	@Test
	public void testRiceviBiscotti() {
		TamaGordo tama=new TamaGordo();
		tama.setSazieta(50.0);
		tama.riceviCarezze(3);
		assertEquals(tama.MAX_FELICITA, tama.getFelicita(), EPSILON);
		assertEquals(65, tama.getSazieta(), EPSILON);
	}

	@Test
	public void testSetBenessere() {
		TamaGordo tama=new TamaGordo();
		tama.setSazieta(50.0);
		assertEquals(true, tama.isBenessere());
		tama.setSazieta(5);
		assertEquals(false, tama.isBenessere());
	}

	@Test
	public void testSetInVita() {
		TamaGordo tama=new TamaGordo();
		tama.setSazieta(50.0);
		assertEquals(true, tama.isInVita());
		tama.setSazieta(-8);
		assertEquals(false, tama.isInVita());
		tama.setSazieta(100);
		assertEquals(true, tama.isInVita());
	}

}
