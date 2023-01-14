import java.util.*;
import java.io.*;
public class room extends family

{
	int currentroom;// room youre in
	int leftroom;//second room
	int middleroom;//third room
	int rightroom;//fourth room
	String description; //descripes room
	
	/**
	@param d the description of the room
	@param f the room you're in
	@param s the room to the far left
	@param t the room in the middle
	@param r the room to the far right
	*/
	
	public room(int f, int s, int t, int r, String d )
	{
		 currentroom = f;
		 leftroom= s;
		 middleroom=t;
		 rightroom = r;
		 description = d;
	}

	/**
	@param file Scanner attached to room info
	*/
	public room(Scanner file)
	{
		currentroom = file.nextInt();
		leftroom = file.nextInt();
		middleroom = file.nextInt();
		rightroom = file.nextInt();
		//**tells scanner to go to next line *// 
		file.nextLine();
		description = file.nextLine();
	}
	
	/**
	@return String representation of the room
	*/
	public String toString()
	{
		System.out.println("You're in room: " + currentroom);
		System.out.println("The room to the left is room: "+ leftroom);
		System.out.println("The room straight ahead is room: "+ middleroom);
		System.out.println("The room to the right is room: "+ rightroom );
		return description;
	}
	
	/** @return the room you're in */
	public int getfroom() { return currentroom; }
	/** @return the 2nd rooom  */
	public int getsecrooms() { return leftroom; }
	/** @return the third room */
	public int gettreeroom() { return middleroom; }
	/** @return the fourth room */
	public int getforroom() { return rightroom; }
	/** @return the description */
	public String getdescrip() { return description; }
	
}