
public class AsciiChars {
//    // TODO: print valid numeric input
//for (int i=48; i<58; i++) { //or (i=0; i<='9'; ++i)
//	System.out.println(i);
	
	
	//functions have to be STATIC to call from MAIN
	//can be before main, after main, both, whatever
	
	//MAIN is where the code starts running, so declaring
	//methods outside of it is just like building functions
	//in JS before the one you ultimately call
	
	//DO NOT nest methods in Main, put them outside in the
	//containing Class
	
	//easily determine ascii: char x = X; int xNum = charAt(x);
	
	  public static void printNumbers()
	  {	System.out.println("Valid ASCII numbers are: \n");
		  for (int i = 48; i<58; i++) {
			   System.out.println(Character.toString(i)+ " : "+i);
		  }
	  }

	  public static void printLowerCase()
	  {	System.out.println("\nValid ASCII lowercase characters are: \n");
	  		for (int i = 97; i<123; i++) {
			   System.out.println(Character.toString(i)+ " : "+i);
	  		}
	  	
	  }
	  	
	  public static void printUpperCase()
	  {System.out.println("\nValid ASCII uppercase characters are: \n");
		for (int i = 65; i<91; i++) {
		   System.out.println(Character.toString(i)+ " : "+i);
  		}
  	
	  }
	
	  public static void main(String[] args) {
		printNumbers();
		printLowerCase();
		printUpperCase();
	}

}

//one line:
//public static void printNumbers() {
//	for (char i = '0'; i<='9'; i++){
//		System.out.print(i);
//		}
//		System.out.println();
//}