package MyClass.MyIO;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyIOconsoleTest {

	@Test
	public void testStampaDouble() {
		System.out.println(MyIOconsole.stampaDouble(50D, 4));
		assertEquals("50,0000",MyIOconsole.stampaDouble(50D, 4));
		
	}

}
