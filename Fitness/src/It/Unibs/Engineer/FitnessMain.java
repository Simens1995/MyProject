package It.Unibs.Engineer;
import java.util.*;
/**
 * 
 * @author Andrea
 * Program that show IMC and DailyCalorie of a person
 */

public class FitnessMain {

		public static void main(String[] args) {
			
			@SuppressWarnings("resource")
			Scanner lettore = new Scanner(System.in);
			System.out.print("Insert height (in meter) : ");
			double height = lettore.nextDouble();
			System.out.print("Insert weight (in Kg) : ");
			double weight = lettore.nextDouble();
			Person p = new Person(null, null, 0, height, weight);
			Fitness f = new Fitness();
			f.setPerson(p);
			System.out.print("IMC ");
			System.out.printf("%.2f%n", f.getIMC());
			System.out.print("Daily Calorie ");
			System.out.printf("%.2f", f.getDailyCalorie());
		}

	}
