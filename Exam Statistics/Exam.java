import java.io.*;
import java.util.*;
import java.util.Arrays;

class Exam
{
	
	public static void main(String[] args)
	throws IOException
	{
		System.out.println(" \n Welcome to the Program for Exam Statistics! \n");
		
		//open the stream for a user-selected file.
		System.out.print("Please enter the name of your file: ");
		Scanner inputFile = new Scanner(System.in);
		String fileName = inputFile.nextLine();
			
		Scanner file=new Scanner(new FileReader(fileName));	
		
		// reading in the first line (how many scores will be within the file)
		int numberofGrades = 0;
		numberofGrades = file.nextInt();
	
		// allocating the correct number of spaces within our array
		int [] grapes=new int[numberofGrades];
		
		// preparing for an iteration of storing the read-in values to our array.
		int i = 0;
		
		while(file.hasNextInt())
		{	
			grapes[i++] = file.nextInt();
		}
		
		// we're at the eof, sooo
		inputFile.close();
		
		// Calling our calculating functions
		double gradeAverage = average(grapes);
		double max = maximum(grapes);
		double min = minimum(grapes);
		double med = median(grapes);
		
		// Relaying the results of our functions
		System.out.println("\n Average score: " + gradeAverage);
		System.out.println("Maximum score: " + max);
		System.out.println("Minimum score: " + min);
		System.out.println("Median score: " + med);
		
		// initializing variables for our fun functions
		int As = 0;
		int Bs = 0;
		int Cs = 0;
		int Ds = 0;
		int Fs = 0;
		//double average = 0;
		//double maximum =0;
		//double minimum =0;
		
		// Results broken down by letter grade
		//System.out.println(Arrays.toString(grapes));
		for(int j = 0; j < numberofGrades; j++){
			if (grapes[j] > 90 )
				As ++;
			else if (grapes[j] < 90 && grapes[j] > 80 )
				Bs ++;
			else if (grapes[j] < 80 && grapes[j] > 70 )
				Cs ++;
			else if (grapes[j] < 70 && grapes[j] > 60 )
				Ds ++;
			else
				Fs ++;
	 	}	
	
		System.out.println("\n Number of scores by letter grade: ");
		System.out.println("A: " + As);
		System.out.println("B: " + Bs);
		System.out.println("C: " + Cs);
		System.out.println("D: " + Ds);
		System.out.println("F: " + Fs);
		System.out.println("There are " + numberofGrades + " grades in this file. \n");
		
		
	}

	// calculating the average score
	public static double average(int [] scores)
	{
		double avg = 0.0;
		int sum = 0;
		for (int i = 0; i< scores.length; i++)
			sum+= scores[i];
		avg =((double)sum/scores.length);
		return avg;
	}

	// determining the maximum score
	public static double maximum( int [] scores)
	{
		double max = 0.0;
		for( int i =0;i< scores.length;i++)
		{
			if(scores[i] > max)
				max = scores[i];
		}
		return max;
	}

	// determining the minimum score
	public static double minimum( int [] scores)
	{
		double min = 10000;
		for( int i =0;i< scores.length;i++)
		{
			if(scores[i] < min)
				min = scores[i];
		}
		return min;
	}

	// determining the median score
	public static double median( int [] scores)
	throws IOException
	{
		int x = scores.length;
		double med = 0;
		Arrays.sort(scores); // sorts the array
		
		int y = 0;
		if(x % 2 == 1){
			y = x/2;
			med = scores[y];
		}
		else
			y = x/2;
			med = (scores[y]+scores[y-1])/2;
		return med;
	}	
	
}	