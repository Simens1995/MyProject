package It.Unibs.Engineer;

import java.util.Random;

public class TamaMain {

    final static String GREETING = "Hello my friend!";
    final static String GIVE_NAME = "What is my name ? ";
    final static String GIVE_SATY = "Insert initial satiety : ";
    final static String GIVE_SATN = "Insert initial satisfaction : ";
    final static String GIVE_CHAR = "b for biscuits, c for caresses and q for exit : ";
    final static String ERROR = "Error";
    final static String DIE = " is die.";
    final static int SATISF_MIN = 30, SATISF_MAX = 90, SATIET_MIN = 30, SATIET_MAX = 90;
    
	public static void main(String[] args) {
		
		Util.show(GREETING);
		Util.goodFace();
		String name = Util.readString(GIVE_NAME);
		int satiety = Util.readInt(GIVE_SATY);
		boolean retry = Util.valid(satiety, SATIET_MIN, SATIET_MAX);
		
		while (retry == false){
			satiety = Util.readInt(GIVE_SATY);
			retry = Util.valid(satiety, SATIET_MIN, SATIET_MAX);
		}
		
		
		int satisfaction = Util.readInt(GIVE_SATN);
		retry = Util.valid(satisfaction, SATISF_MIN, SATISF_MAX);

		while (retry == false){
			satisfaction = Util.readInt(GIVE_SATN);
			retry = Util.valid(satisfaction, SATISF_MIN, SATISF_MAX);
		}
		
		@SuppressWarnings("unused")
		TamaLife tama = new TamaLife(name, satiety, satisfaction);
		
		@SuppressWarnings("unused")
		boolean life = true;	
		
		while((life = TamaLife.tamaDie()) != false){                   // MANCANO AGGIUSTAMENTI	
		String s = Util.readChar(GIVE_CHAR);   //for read a char
		char p = s.charAt(0);
		Random generator = new Random();
			
		switch(p){
		case 'b': int biscuits = 1 + generator.nextInt(5); //Util.readInt("Biscuits : ");
		          TamaLife.giveBiscuits(biscuits);
				  break; //Give biscuits to your little monster
		case 'c': int caresses = 1 + generator.nextInt(8); //Util.readInt("Caresses : "); 
		          TamaLife.giveCaresses(caresses);	
		          break; //Give caresses to your little monster
		case 'q': life = false;					            
		          break; //Life is over. Game over
		default : Util.show(ERROR); 
		          break;
			}
	
		}
	Util.show(name + DIE);
	Util.badFace();
		

	}

}
