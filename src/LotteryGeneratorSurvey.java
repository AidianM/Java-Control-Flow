import java.util.Random;
import java.util.Scanner;

//req: Control Flow - PROJECT.md (exc.2)

//see: Control Flow - (NumberClamp, RandomNumberExample)

public class LotteryGeneratorSurvey {

	public static int handleOutOfRangeNumber(int number, int minValue, int maxValue) {
		
		int rangeOfValues = (maxValue-minValue)+1;
		
		while (number<minValue) {
			number+=rangeOfValues;
		}
		
		while (number>maxValue) {
			number -= rangeOfValues;
		}
		return number;
		
		//number = Math.floorMod(number-MinValue, rangeofValues) + minValue;
		//this will clamp the number in an out of range number
		//(see below, comprehension dubious)
	}
	//inelegant, as it can take a while for ###################, but it works for this
	//better with clamping:
	//#between 0-31: X%32;
	//The modulus operator only works to clamp a value between 1 and quotient(inclusive)
	//
	//for 1-75:
	//range needs to be 0-74
	//%75
	
	//So: number-= (number-minValue)%rangeOfValues+minValue;
	//Roughly: (number - 1) % 75+1 +1;
	
	//Time to learn something esoteric for junior programming:
	/* HOW TO DIVIDE INTEGERS
	 * 
	 * You think you know, but only to an extent.
	 * 
	 * What's -7/3? (survey: -2, seems to make logical sense)
	 * Python: -7//3 = -3
	 * 
	 * What's the remainder of -7%3? 
	 * int remainder = -7%3;
	 * 		if the answer is above -2, then remainder should be -1
	 * 
	 * q=a/n (q = value, a=-7, n=3)
	 * r = a % n (r=remainder)
	 * a = nq+r
	 * 
	 * -7 = 3*(-2)+r
	 * -7=-6+r
	 *
	 *God helps all of us who went to public school,
	 *there are multiple ways of defining integer division.
	 *
	 *They all work the same when you have two positive numbers.
	 *
	 *When negative numbers are involved, there are several(4 total) 
	 *different definitions that can be used for integer division.
	 *
	 *-------------------
	 *TRUNCATED DIVISION:
	 *-------------------
	 *value = -2
	 *remainder = -1
	 *
	 *Called truncated because the way division works is by taking the
	 *floating point representation of the division, chopping it off
	 *(truncating it), and this rounds out result towards 0.
	 *
	 *There's an issue with this:
	 *If you use this with modulus, 
	 *
	 *listofItems["a", "b", "c","d","e","f","g"];
	 *
	 *index = 3;                 ^
	 *
	 *Scenario: perations holds a number, and for every 3 operations 
	 *I've done, I want to go forward 1 spot in the index.
	 *
	 *index += operations/3;
	 *Seems viable.
	 *
	 *What is listOfItems[index] with different values for operations?
	 *operations = 0-2 == 'd';
	 *operations = 3-5 == 'e';
	 *operations = 6-8 == 'f';
	 *operations = 9-11 == 'g';
	 *
	 *But when negative numbers come into play...
	 *
	 *operations = -1 to -2 == 'd';
	 *operations = -3 to -5 == 'c'
	 *
	 *But operations 2 and -2 gives us 'd' still.
	 *
	 *-2 to +2 = 0 steps
	 *
	 *So we have to define our division differently.
	 *
	 *-----------------
	 *FLOORED DIVISION:
	 *-----------------
	 *
	 *Let's always round division down:
	 *
	 *-7/3 = -2.33333 = -3
	 *
	 *0/1/2=0
	 *3/4/5=+1
	 *6/7/8=+2
	 *
	 *-3/-2/-1 = -1
	 *-4/-5/-6 = -2
	 *-7/-8/-9 = -3
	 *
	 *Creates an even stair step instead of flat-lining around 0 point.
	 *
	 *Floored Division will give far fewer errors when utilized in
	 *programs.
	 *
	 *Different computer languages use different division forms, usually
	 *defined by OS, most often truncated.
	 *
	 *JAVA IS DEFINED TO USE TRUNCATED DIVISION.
	 *
	 *So:
	 *-7/3 = -2
	 *
	 *Modulus also works off of truncation, so we CANNOT use the
	 *modulus operator with negatives and trust it.
	 *
	 *To use floored division for the modulus:
	 *Math.floorMod(a,b) = a%b (floored)
	 *
	 *Math.floorDiv also exists for division.
	 *
	 *
	 *
	 */

	
	
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your name?");   
		String name = input.nextLine();

		System.out.println("Hello, "+name);
		
		System.out.println("Do you wish to continue?");
		String answer = input.nextLine();
		answer = answer.toLowerCase(); //set lowercase for answer
		
		boolean surveyCompleted = false;
		while (answer.equals("yes") || answer.equals("y")) {
			System.out.println("What is the name of your favorite pet?");
			String petName = input.nextLine();
			
			System.out.println("What is the age of your favorite pet?");
			int petAge = Integer.parseInt(input.nextLine());
			
			System.out.println("What is your lucky number?");
			int luckyNumber = Integer.parseInt(input.nextLine());
			
			System.out.println("Do you have a favorite quarterback?");
			String response = input.nextLine().toLowerCase();
			boolean hasFavoriteQB = (response.equals("yes") || response.equals("y"));
			
			int jerseyNumber = 0;
			
			if(hasFavoriteQB) {
				System.out.println("What is their jersey number?");
				jerseyNumber = Integer.parseInt(input.nextLine());
			}
			
			System.out.println("What is the two-digit model year of your car?");
			int carYear = Integer.parseInt(input.nextLine());
			
			System.out.println("What is the first name of your favorite actor or actress?");
			String favoriteThespian = (input.nextLine());
			
			System.out.println("Enter a random number between 1 and 50:");
			int randomNumber = Integer.parseInt(input.nextLine());
			
			//END SURVEY
			//BEGIN MAGIC BALL:
			
			final int MIN_MAGIC_BALL = 1;
			final int MAX_MAGIC_BALL = 75;
			final int MIN_NORMAL_BALL = 1;
			final int MAX_NORMAL_BALL = 65;
			
			
			Random random = new Random();
			int[] randomIntegers = new int[3]; //3 indices
			for (int i = 0; i<randomIntegers.length; i++) {
				
				//this will generate a random number between 1-65, inclusive
				randomIntegers[i] = random.nextInt(MAX_NORMAL_BALL-MIN_NORMAL_BALL+1);
			}
			
			

			
			//generate magic ball:
			//user's favorite QB jersey# OR lucky number*random number
			
			int magicBall;
			
			if(hasFavoriteQB) {
				magicBall = jerseyNumber*randomIntegers[0];
			} else {
				magicBall = luckyNumber*randomIntegers[0];
			}
			//and now, a problem: the magicBall can be >MAX_MAGIC_BALL
			
			//spec says "IF", but "WHILE" is appropriate for larger numbers
			//see top methods
			
			magicBall = handleOutOfRangeNumber(magicBall, MIN_MAGIC_BALL, MAX_MAGIC_BALL);
			
			int[] balls = new int[5];
			balls[0] = handleOutOfRangeNumber(petName.charAt(2), MIN_NORMAL_BALL, MAX_NORMAL_BALL);
			balls[1] = handleOutOfRangeNumber(carYear+luckyNumber, MIN_NORMAL_BALL, MAX_NORMAL_BALL);
			balls[2] = handleOutOfRangeNumber(randomNumber-randomIntegers[1], MIN_NORMAL_BALL, MAX_NORMAL_BALL);
			balls[3] = handleOutOfRangeNumber(favoriteThespian.charAt(0), MIN_NORMAL_BALL, MAX_NORMAL_BALL);
			balls[4] = handleOutOfRangeNumber(favoriteThespian.charAt(favoriteThespian.length()-1), MIN_NORMAL_BALL, MAX_NORMAL_BALL);
			
			System.out.printf("Lottery Numbers: %d, %d, %d, %d, %d\n", 
					balls[0], balls[1], balls[2], balls[3], balls[4], magicBall);
			
	
			surveyCompleted = true;
			System.out.println("Would you like to play again?");
			answer = input.nextLine().toLowerCase();
		}
		
		if(!surveyCompleted) {
			System.out.println("Please return later to complete the survey.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
