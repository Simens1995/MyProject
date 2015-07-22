package It.Unibs.Engineer;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author  Tiziano Fapanni, Andrea Simaz & Andrea Lorenzoni
 *
 */
public class TamaTristeTest {
	private static double EPSILON= 1E14;
	
	@Test
	public void testRiceviCarezze() {
		TamaTriste tama=new TamaTriste();
		tama.setSazieta(50.0);
		tama.riceviCarezze(8);
		assertEquals(tama.MIN_FELICITA, tama.getFelicita(), EPSILON);
		assertEquals(0.2*50, tama.getSazieta(), EPSILON);
	}

	@Test
	public void testRiceviBiscotti() {
		TamaTriste tama=new TamaTriste();
		tama.setSazieta(50.0);
		tama.riceviCarezze(3);
		assertEquals(65, tama.getSazieta(), EPSILON);
	}

	@Test
	public void testSetBenessere() {
		TamaTriste tama=new TamaTriste();
		tama.setSazieta(50.0);
		assertEquals(false, tama.isBenessere());
		tama.setSazieta(5);
		assertEquals(false, tama.isBenessere());
		tama.setSazieta(95);
		assertEquals(false, tama.isBenessere());
	}

	@Test
	public void testSetInVita() {
		TamaTriste tama=new TamaTriste();
		tama.setSazieta(50.0);
		assertEquals(true, tama.isInVita());
		tama.setSazieta(-8);
		assertEquals(false, tama.isInVita());
		tama.setSazieta(108);
		assertEquals(false, tama.isInVita());
	}

}
