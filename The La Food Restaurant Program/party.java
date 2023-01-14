import java.util.*;
import java.io.*;

public class party extends food

{
	// data members
	int time;
	int partySize;
	String partyName; 
	
	// constructor method
	/**
	@param t the time at any given point
	@param pNo the number of members in the party
	@param pNa the party name
	*/
	public party(int t, int pNo, String pNa )
	{
		 time = t;
		 partySize = pNo;
		 partyName = pNa;
	}

	/**
	@param file Scanner attached to party info
	*/
	public party(Scanner file)
	{
		time = file.nextInt();
		partySize = file.nextInt();
		partyName = file.nextLine();
	}
	
	// accessor methods
	/**
	@return String representation of the room
	*/
	public String toString()
	{
		return partyName + ", party of " + partySize + ".";
	}
	
	/** @return the time */
	public int getTime() { return time; }
	/** @return the number of members of a given party */
	public int getPartyNum() { return partySize; }
	/** @return the name of the party */
	public String getPartyName() { return partyName; }
}