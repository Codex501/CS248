import java.io.*;
import java.util.*;
import java.util.Random;
class randnum
{
	
	//keeps the insults in an array
	public static String randomword()
	{
		//array of insults
		String[] insult = {"nimrod", "idiot" , "dummy" , "loser" , "dimit"};
		Random ran = new Random();
		//picks an insult from the array
		int randominsult = ran.nextInt(insult.length);
		return insult[randominsult];
	}
	
	public static void main(String []args)
	{
		int answer = 1;
		//while loop to keep game going
		while(answer != 0)
		{
		
		System.out.println("Welcome to the guessing game");
		System.out.println("I have a number from 1 - 100 can you guess it?");
		//code that reads what the user put
		Scanner cin = new Scanner(System.in);
		//gets a random number from 1-100
		int number;
		number = (int)(1+100*Math.random());
		int n;
		System.out.print("Enter your guess:");
		n= cin.nextInt();
		
		//while loop until the guess equal the random number 
		while(n != number)
		{
			
			if (n < number)
			{
				System.out.println("Too low "+ randomword());
				System.out.print("Enter your guess:");
				n= cin.nextInt();
			}
			
			else if (n > number)
			{
				System.out.println("Too high "+ randomword());
				System.out.print("Enter your guess:");
				n= cin.nextInt();
			}
			
			
		}
			
		System.out.println("You got it!");
		
		System.out.println("Would you like to play again 1/0?");
		answer = cin.nextInt();
		
		}
		
	}
}