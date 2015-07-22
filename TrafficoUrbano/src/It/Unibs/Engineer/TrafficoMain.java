package It.Unibs.Engineer;
import MyClass.MyScelta;

/**
 * PROGETTO TRAFFICO URBANO
 * @author Fapanni Tiziano, Lorenzoni Andrea & Simaz Andrea
 *
 */

public class TrafficoMain {

	final static String CONTINUA = "vuoi continuare la simulazione? ";
	
	public static void main(String[] args) {
		
		StradaGrafica st = new StradaGrafica(0, 12);
		MyScelta sDue = new MyScelta('y', 'n', CONTINUA);
		boolean scelta;
		
		System.out.println(st.stampaStrada());
		scelta = sDue.sceltaDueVie();
		
		while(scelta){
			String str = st.aggiornaStrada();
			System.out.println(st.stampaStrada());
			System.out.println(str);
			scelta = sDue.sceltaDueVie();
		}
		
	}

}
