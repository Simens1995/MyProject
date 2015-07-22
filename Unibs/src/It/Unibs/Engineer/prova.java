package It.Unibs.Engineer;

public class prova{
	
	private int m;

	prova(int m){
		this.m = m;
	}
	
	public static void myPrint2(int n) 
	{
	   if (n < 10)
	      System.out.print(n);
	   else 
	   {
	      myPrint2(n/10);
	      int m = n % 10;
	      System.out.print(m);
	   }
	}

 

}