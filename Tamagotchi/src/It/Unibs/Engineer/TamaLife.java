package It.Unibs.Engineer;

public class TamaLife {

	final static int TAMA_MIN_DIE = 0, TAMA_MAX_DIE = 100;
	final static int SATISF_MIN = 30, SATISF_MAX = 90, SATIET_MIN = 30, SATIET_MAX = 90, SATISF_MAX_VALUE = 100;
	final static double BISC_PERCENT = 0.1;
	final static String DIE = " is died :'(";
    final static String WRONG = "Wrong input";
    final static String UNHAPPY_SATY = " is unhappy, beacuse his level of satiety is ";
    final static String UNHAPPY_SATN = " is unhappy, beacuse his level of satisfaction is ";
    int caresses, biscuits;
    
    
    static String tamaName;
    static int satisfaction = 0, satiety = 0;
    
 	/**Initial state of TAMAGOTCHI
 	 * 
 	 * @param tamaName
 	 * @param satisfaction
 	 * @param satiety
 	 */
 	@SuppressWarnings("static-access")
	public TamaLife(String tamaName, int satisfaction, int satiety){
 		this.tamaName = tamaName;
 		this.satisfaction = satisfaction;
 		this.satiety = satiety;	
 	}
    
 
 	/**
     * updates satisfaction and satiety with caresses
     * @param caresses
     */
    public static void giveCaresses(int caresses){
    	satisfaction += caresses;
    	maxSatisfaction();
        satiety -= (caresses/2);
        showState();
        tamaUnhappy();
        tamaDie();
               
    }
    
    /**
     * updates satisfaction and satiety with biscuits
     * @param biscuits
     * @return
     */
    public static void giveBiscuits(int biscuits){
    	for(int i = 0; i < biscuits; i++){
    		satiety += (satiety*BISC_PERCENT);
    	}
    	satisfaction += biscuits/4;
    	showState();
    	tamaUnhappy();
    	tamaDie();
    }
    
	/**
	 * Control if satasfaction go over a certain limit (100)
	 * @param satisfaction
	 */
    public static void maxSatisfaction(){
    	if(satisfaction > SATISF_MAX_VALUE){
    		satisfaction = SATISF_MAX_VALUE;
    	}
    }
    
    /**
     * Control if Tama is unhappy
     * @return
     */  
	public static void tamaUnhappy(){
		if((satiety < SATIET_MIN && satiety > TAMA_MIN_DIE) || (satiety > SATIET_MAX && satiety < TAMA_MAX_DIE)){
			System.out.println(tamaName + UNHAPPY_SATY + satiety);
			
		}
		else if(satisfaction < 30 && satisfaction > 0){
			System.out.println(tamaName + UNHAPPY_SATN + satisfaction);
		}
	}
	
	/**
	 * Tamagotchi will die, if one of this variables is out of the range. If it's false, tamagotchi died.
	 * @return boolean
	 */
	public static boolean tamaDie(){
		if(satiety <= TAMA_MIN_DIE || satisfaction <= TAMA_MIN_DIE || satiety >= TAMA_MAX_DIE){
		   return false;
		}
		else return true;
	}
	
	/**
	 * This method is create to show the actual state of tamagotchi.
	 */
	public static void showState(){
		Util.show("Level satisfaction : ");
		Util.showInt(satisfaction);
		Util.show("Level satiety : ");
		Util.showInt(satiety);
	}
	
}
