package It.Unibs.Engineer;

import java.util.Scanner;

public class Util {
	
	final static String ERROR ="Invalid Input ";
	
	private static Scanner lettore = new Scanner(System.in);

	/**
	 * This method is used to read an integer
	 * @param message
	 * @return
	 */
	public static int readInt (String message)
	{
		System.out.print(message);
		return lettore.nextInt();
	}
	/**
	 * This method is used to read a String
	 * @param message
	 * @return
	 */
	public static String readString (String message)
	{
		System.out.print(message);
		return lettore.nextLine();
	}
	
	/**
	 * show a number
	 * @param message
	 */
	public static void showInt(int message ){
		System.out.println(message);
	}
	
	
	/**
	 * Show a message
	 */
	public static void show(String message ){
		System.out.println(message);
	}
	
	/**
	 * This method is used to read a single character
	 * @param message
	 * @return
	 */
	public static String readChar (String message){
		System.out.println(message);
		return lettore.next();
	}
	
/**
 * Control if a parameter is into a specific range
 * @param middle
 * @param MIN
 * @param MAX
 * @return
 */
	public static boolean valid(int middle, int MIN, int MAX){
		if(middle<= MIN || middle >= MAX){
			System.out.println(ERROR);
			return false;
			}
		else return true;
	}
	
	
	
	public static void goodFace(){
		System.out.println("   ******");
		System.out.println(" *        * ");
		System.out.println("*  +    +  *");
		System.out.println("*          *");
		System.out.println(" *    U   *");
		System.out.println("   ******");
	}
	
	public static void badFace(){
		System.out.println("   ******");
		System.out.println(" *        * ");
		System.out.println("*  x    x  *");
		System.out.println("*          *");
		System.out.println(" *    -   *");
		System.out.println("   ******");
	}
	
	
	
}


