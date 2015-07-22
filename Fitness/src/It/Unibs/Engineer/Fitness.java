package It.Unibs.Engineer;

/**
 * 
 * @author Andrea
 * This class get BMI and DailyCalorie
 */
public class Fitness {

	public Person person;
	public double BMI, DailyCalorie;
	final int CALORIE_GIORNO = 19;
	final double LIBBRA_KG = 2.2;
  
/**
 * Get a person
 * @return person
 */
    public Person getPerson() {
		  return person;
    }
/**
 * Set a person
 * @param person
 */
	public void setPerson(Person person) {
		this.person = person;
	}
/**
 * Get BMI (Body Mass Index)
 * @return BMI
 */
	public double getIMC(){
		BMI = person.getWeight() / (person.getHeight() * person.getHeight());
	    return BMI;
	}
/**
 * Get Daily Calorie for normal Athlete	
 * @return DailyCalorie
 */
	public double getDailyCalorie(){
		DailyCalorie = person.getWeight() * CALORIE_GIORNO * LIBBRA_KG;
		return DailyCalorie;
	}
	
}
