// Program written in collaboration with Luis Ayala

import java.io.*;
import java.util.*;

public class MyDate implements DateInterface
{
	// I doubt we're the only ones to play the Jonas Brothers' Year 3000 on repeat for this project. A little revelation: "not much has changed but they lived under water" ...
	// you know what else lives under water? Well played, Sorenson.
	
	// data members / variables
	int month;
	int day;
	int year;
	int dayofWeek;
	boolean isLeapYear;
	int numDays;
	
	// methods
	public void MyDate(){};
	
	// constructor
	/**
     @param m the month of the year (1-12)
     @param d the day of the month (1-31)
     @param y the year (four digits)
     @param dow the day of the week (0-6)
	*/
	
	/** @return the day of the month */
	public int getDay() { return day; }
	/** @return the day of the week */
	public int getDow() { return dayofWeek; }
	/** @return the month # */
	public int getMonth() { return month; }
	/** @return the year */
	public int getYear() { return year; }
	
	
	// determining a leap year.. takes in integer year & returns boolean true or false
	public boolean leapYear(int year)
	{
		if (((year % 4) == 0) && ((year % 100 != 0) || ((year % 400) == 0))) // someone had fun figuring this out.
			isLeapYear = true;
		else
			isLeapYear = false;
		return isLeapYear;
	}
	
	// determining number of days in a given month,, leap years included.. takes in integer corresponding to month & returns number of days in said month
	public int numberDays(int month)
	{
		if((month == 1) ||(month == 3) ||(month == 5) ||(month == 7) ||(month == 8) ||(month == 10) ||(month == 12)) // months with 31 days
			numDays = 31;
		else if (month == 4 || month == 6 || month == 9 || month == 11) // months with 30 days
			numDays = 30;
		else // february
			if(isLeapYear)
				numDays = 29;
			else
				numDays = 28;
		return numDays;
	}
	
	// date was set in the main program.. storing for use in this program
	public void set(int m,int d,int y,int dow)
	{
		month = m;
		day = d;
		year = y;
		dayofWeek = dow;
	}	

	// accessor methods/functions
	public void tomorrow()
	{
		boolean isLeapYear = leapYear(year); // returns boolean value for leap year or no
		int numDays = numberDays(month); // returns integer value of number of days within a particular month
		day++; // tomorrow will always be one day more than today
		
		// progresses the day of the week count each time tomorrow() is called. loops around too.
		if(dayofWeek == 6)
			dayofWeek = 0;
		else
			dayofWeek++;
		
		// moving to the next month, loops around too. 
		if((day>numDays) && month!=12) // every month EXCEPT for December (we'll need a new year some time..)
		{
			month++;
			day = 1;
		}
		else // December
		{
			if(day>numDays)
			{
				month = 1;
				day = 1;
			}
		}

		// moving to the next year (when it's jan 1)
		if((month ==1)&&(day ==1))
			year++; // happy new year!
	}
	/**
	@return date as a string. I.E. "Monday, March 18, 2002" --> 1, 3 18, 2002
	*/
	public String toString() 
	{ 
		// this conversion really messed up my line count... thought we'd be finished in 110 lines :/ 
		String[] monthsofYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String months;
		if(month==1)
			months = monthsofYear[0];
		else if (month==2)
			months = monthsofYear[1];
		else if (month==3)
			months = monthsofYear[2];
		else if (month==4)
			months = monthsofYear[3];
		else if (month==5)
			months = monthsofYear[4];
		else if (month==6)
			months = monthsofYear[5];
		else if (month==7)
			months = monthsofYear[6];
		else if (month==8)
			months = monthsofYear[7];
		else if (month==9)
			months = monthsofYear[8];
		else if (month==10)
			months = monthsofYear[9];
		else if (month==11)
			months = monthsofYear[10];
		else 
			months = monthsofYear[11];
		
		String[] daysofWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String days;
		if(dayofWeek==0)
			days=daysofWeek[0];
		else if(dayofWeek==1)
			days=daysofWeek[1];
		else if(dayofWeek==2)
			days=daysofWeek[2];
		else if(dayofWeek==3)
			days=daysofWeek[3];
		else if(dayofWeek==4)
			days=daysofWeek[4];
		else if(dayofWeek==5)
			days=daysofWeek[5];
		else
			days=daysofWeek[6];
		return days+", "+months+" "+day+", "+year; 
	}
	
	// Extra credit that we haven't gotten to yet.
	public void today() {};
	public void yesterday() {};
}