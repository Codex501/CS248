

import java.io.*;
import java.util.*;

public class food
{
	public static void main(String[] args)
	throws IOException
	{
		// declaring appropriate variables (save these mystery mouse-ka-tools for later)
		double totalMins = 0; double totalSeated = 0; int partySize = 0; int toa = 0; int tos = 0;

		System.out.println("Welcome to the La Food Restaurante Simulator!\n");
		System.out.print("Enter data file name: ");
		
		Scanner inputFile = new Scanner(System.in);
		String fileName = inputFile.nextLine();
		Scanner file=new Scanner(new FileReader(fileName));	// scanner for input file is created
		System.out.println("");
		
		Queue waitList =new QueueLL(); // queue with linkedlists is created
		String process = file.next(); // should get the very first value in document & goes through it item by item
		
		while(!process.equals("Q")) // continue reading while there's something to be read
		{
			if (process.equals("A"))
			{
				toa = file.nextInt();
				partySize = file.nextInt();
				String partyName = file.nextLine();
				party guests = new party(toa, partySize, partyName); // new object!
				System.out.println("Please wait at the bar," + guests);
				waitList.enqueue(guests); // new object on the bbqueue
			}	
			else if(process.equals("T"))
			{
				tos = file.nextInt(); 
				// buffer party variable to get data along with front-most party
				party temp = (party)waitList.dequeue();
				System.out.println("Table Up! Calling " + temp);
				totalMins += temp.partySize*(tos - temp.time);
				totalSeated += temp.partySize;
			}
			else
				System.out.println("That must have been an invalid input file. Sorry!");
			
			process = file.next(); // get the next command!	
		}
		System.out.println("* Simulation Terminated *");
		
		// Displaying the average waiting time
		System.out.println("\nThe average waiting time was: " + Math.round((totalMins/totalSeated)*100.0)/100.0);
		
		//Narrating those who were not seated & emptying the queue accordingly
		System.out.println("The following parties were never seated: ");
		while(!waitList.isEmpty())
			System.out.println(waitList.dequeue());
		
		System.out.println("Enjoy your meal (or not)!");
	}	
}