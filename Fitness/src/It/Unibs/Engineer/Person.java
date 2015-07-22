package It.Unibs.Engineer;

/**
 * 
 * @author Andrea
 * This class set biographic information 
 */
public class Person {

	private String name, surname;
	private int age;
	private double weight;
	private double height;
	
	public Person(String name, String surname, int age, double height, double weight){
		this.name = name;
		this.surname = surname;
		this.age = age;	
		this.weight = weight;
		this.height = height;
	}

/**
 * Set name of person
 * @param name
 */
	public void setName(String name){
	    this.name = name;
	}
/**
 * Get name of person
 * @return name
 */
	public String getName() {
		return name;
	}
/**
 * Set surname of person	
 * @param surname
 */
	public void setSurname(String surname){
	    this.surname = surname;
	}
/**
 * Get surname of person
 * @return surname
 */
	public String getSurname() {
		return surname;
	}
/**
 * Set age of person
 * @param age
 */
	public void setAge(int age){
	    this.age = age;
	}
/**
 * Get age of person
 * @return age
 */
	public int getAge() {
		return age;
    }
/**
* Get weight of person
* @return weight
*/
	public double getWeight() {
		return weight;
	}
/**
 * Set weight of person
 * @param weight
 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
/**
* Get height of person
* @return height
*/
	public double getHeight() {
		return height;
	}
/**
 * Set height of person
 * @param height
 */
	public void setHeight(double height) {
		this.height = height;
	}

	
}
