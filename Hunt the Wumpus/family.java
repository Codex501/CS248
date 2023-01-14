import java.util.*;
import java.io.*;

public class family
{
	
	// determines if any obstacles or grandma are in adjacent rooms & prints appropriate warnings.
	public static void checkRooms(int grandma, int aunt, int uncle, int gossipers1, int gossipers2, room [] roomArray, int curRoom)
	{
		if(isAdjacent(grandma, roomArray, curRoom))
			{ System.out.println("Grandma's perfume is growing stronger & stronger." ); }
		
		if((isAdjacent(aunt, roomArray, curRoom)) && (isAdjacent(uncle, roomArray, curRoom)))
			{ System.out.println("Your aunt & uncle have their vacation photos ready to share." ); }
		else if(isAdjacent(aunt, roomArray, curRoom))
			{ System.out.println("Your Aunt Trudy is ready and waiting to tell you how dumb you are."); }
		else if(isAdjacent(uncle, roomArray, curRoom))
			{ System.out.println("Your uncle Steve is about to ask if you've seen his conservative Facebook memes."); }
		else {System.out.print("");}
		
		if((isAdjacent(gossipers1, roomArray, curRoom)) && (isAdjacent(gossipers2, roomArray, curRoom)))
			{ System.out.println("Your nosey cousins are closing in."); }
		else if(isAdjacent(gossipers1, roomArray, curRoom))
			{ System.out.println("Would you like to relive some childhood trauma? Your second-cousin thrice removed is standing by."); }
		else if(isAdjacent(gossipers2, roomArray, curRoom))
		{ System.out.println("Hope you weren't expecting an important call on this landline. Aunt Esther is yapping nearby."); }
		else {System.out.println("");}
	}
		
		
	// checks to see if any of our pre-determined obstacles are in an adjacent room
	public static boolean isAdjacent(int obstacle, room [] roomArray, int curRoom)
	{
		boolean Adjacent= false; // default
		if(obstacle == roomArray[curRoom].leftroom || obstacle == roomArray[curRoom].middleroom || obstacle == roomArray[curRoom].rightroom)
			{ Adjacent = true; }
		else 
			{ Adjacent = false; }	
		return Adjacent;
	}	


	public static boolean playGame(boolean endGame)
	throws IOException
	{
		// setting up all of the obstacles.
		int gossipers1, aunt, gossipers2, uncle, grandma, hugs;
		grandma = aunt = uncle = gossipers1 = gossipers2 = hugs = (int)(2+9*Math.random());
		while(aunt == grandma) { aunt = (int)(2+9*Math.random()); }
		while((uncle==grandma)||(uncle==aunt)) { uncle = (int)(2+9*Math.random()); }
		while((gossipers1==grandma)||(gossipers1==aunt)||(gossipers1==uncle)) { gossipers1 = (int)(2+9*Math.random());}
		while((gossipers2==grandma)||(gossipers2==aunt)||(gossipers2==uncle)||(gossipers2==gossipers1)) { gossipers2 = (int)(2+9*Math.random());}
		while((hugs==grandma)||(hugs==aunt)||(hugs==uncle)||(hugs==gossipers1)||(hugs==gossipers2)) { hugs = (int)(2+9*Math.random());}
		
		int roomSelect = 0; int s = 3; int curRoom = 0; // s is hug count
		Scanner file = new Scanner(new FileReader("familyReunion.txt"));
		int maxroom = file.nextInt();
		room [] roomArray = new room[maxroom];
		
		for(int i = 0; i < roomArray.length; i++) // storing the deets of the rooms
			{ roomArray[i] = new room(file); }
		
		System.out.println(roomArray[curRoom]);
		while(endGame == false)
		{
			System.out.println("\nYou have " + s + " hugs left to give.");
			checkRooms(grandma, aunt, uncle, gossipers1, gossipers2, roomArray, curRoom); // on the lookout for adjacent rooms
		
			System.out.println("\nWhat are you going to do (M)ove Rooms or (S)urprise Hug?");
	
			Scanner cin = new Scanner(System.in);
			char theMove = cin.next().charAt(0);
	
			while((theMove != 'm')&&(theMove != 'M')&&(theMove != 's')&&(theMove != 'S')) // catch all
			{
				System.out.println("What a buffoon.. trying to break our game. \nWhat are you going to do (M)ove or (S)hoot?");
				theMove = cin.next().charAt(0);
			}
	
			if ((theMove == 'm') || (theMove=='M'))
			{
				// move rooms function
				System.out.println("Which room would you like to go to? ");
				roomSelect = cin.nextInt();
				while((roomSelect !=roomArray[curRoom].leftroom) && (roomSelect !=roomArray[curRoom].middleroom) && (roomSelect !=roomArray[curRoom].rightroom))
				{
					System.out.println("Select one of the adjacent rooms.");
					System.out.println("Which room would you like to go to? ");
					roomSelect = cin.nextInt();
				}
				// options of moving into different rooms
				if(roomSelect==grandma) {endGame = true; System.out.println("Your grandmother still loves you - even without a hug. Amazing.");}
				else if((roomSelect == aunt) || (roomSelect == uncle) || (roomSelect == gossipers1) || (roomSelect == gossipers2))
				{
					endGame = true;
					System.out.println("Congrats, you walked into a dangerous room. You became distracted, and now Grandma's mad.");
				}
				else if(roomSelect == hugs) { s = 3; System.out.println("You're feeling generous & have refueled your hugging capacity!");} // bonus
				else { System.out.println(roomArray[--roomSelect]);	curRoom=roomSelect; } // moving rooms
			}
			else
			{
				// surprise hugs function
				System.out.println("Which room would you like to aggressively lunge/hug at? ");
				roomSelect=cin.nextInt();
		
				while((roomSelect !=roomArray[curRoom].leftroom) && (roomSelect !=roomArray[curRoom].middleroom) && (roomSelect !=roomArray[curRoom].rightroom))
				{
					System.out.println("Select one of the adjacent rooms.");
					System.out.println("Which room would you like to aggressively lunge/hug at? ");
					roomSelect = cin.nextInt();
				}
				// we have a limit of three hugs to give, sorry phyllis
				if (s >=1) { s--;}
				else {s=0;}
				if (s == 0) { System.out.println("Congrats, you wasted all your hugs. Why would you do this to Grandma?");}
				else if(roomSelect == grandma ) // we hit grams with that hug
				{
					endGame = true;
					System.out.println("Congrats, you hugged Grandma!!");
				}
				else
				{
					System.out.println("You missed with a hug... this is awkward.\n");
					System.out.println(roomArray[curRoom]);
				}
			}
		}
		return endGame;
	}

	public static void main(String [] args)
	throws IOException
	{
		System.out.println("Welcome to Your Family Reunion! \nYou'd better find your Grandma to give her a hug. Can't waste any of those! \n");
		boolean endGame = false;
		playGame(endGame);
		System.out.println("Nice of you to show up this year.");
	}	
}