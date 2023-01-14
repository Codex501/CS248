import java.io.*;
import java.util.*;

class Sorting
{
	 public static void Intarray(Integer [] list,int size)
	 {
		 for(int i =0; i<size;i++)
		{
			list[i] =(int)(1+list.length*Math.random());
			if(size <= 0) System.out.print(list[i]);
		}
		 
	 }
	 public static void Bubblesorts(Integer [] list,int size)
	 {
		long startTime = System.currentTimeMillis();
		//Bubble sort
		Sorts.bubble(list);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		if(size <= 100)
		{
		System.out.println("Bubble Sort:");
			for(int j=0; j<size; j++)
			{
				System.out.print(list[j]+" ");
			}
		}
		System.out.println("");
		System.out.println("It took the Bubble Sort " + (endTime - startTime) + " milliseconds"); 
	 }
	 public static void Insertionsorts(Integer [] list,int size)
	 {
		 long startTime = System.currentTimeMillis();
		//Insertion sort
		Sorts.insertion(list);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		if(size <= 100)
		{
		System.out.println("Insertion Sort:");
			for(int j=0; j<size; j++)
			{
				System.out.print(list[j]+" ");
			}
		}
	
		System.out.println("");
		System.out.println("It took the Insertion Sort " + (endTime - startTime) + " milliseconds"); 
	 }
	 public static void Selectionsorts(Integer [] list,int size)
	 {
		 System.out.println("");
		long startTime = System.currentTimeMillis();
		//Selection sort
		Sorts.selection(list);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		if(size <= 100)
		{
		System.out.println("Selection Sort:");
			for(int j=0; j<size; j++)
			{
				System.out.print(list[j]+" ");
			}
		}
		
		System.out.println("");
		System.out.println("It took the Selection Sort " + (endTime - startTime) + " milliseconds");
	 }
	 public static void Quicksorts(Integer [] list,int size)
	 {
		long startTime = System.currentTimeMillis();
		//Quick sort
		Sorts.quick(list);
		 long endTime = System.currentTimeMillis();
		 System.out.println("");
		if(size <= 100)
		{
		System.out.println("Quick Sort:");
			for(int j=0; j<size; j++)
			{
				System.out.print(list[j]+" ");
			}
		}
	
		System.out.println("");
		System.out.println("It took the Quick Sort " + (endTime - startTime) + " milliseconds"); 
	 }
	 public static void Shellsorts(Integer [] list,int size)
	 {
		 long startTime = System.currentTimeMillis();
		//Shell sort
		Sorts.shell(list);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		if(size <= 100)
		{
		System.out.println("Shell Sort:");
			for(int j=0; j<size; j++)
			{
				System.out.print(list[j]+" ");
			}
		}
		System.out.println("");
		System.out.println("It took the Shell Sort " + (endTime - startTime) + " milliseconds");
	 }
	
	public static void main(String [] args)
	{
		int size;
		Scanner cin = new Scanner(System.in);
		System.out.print("Please enter the number of numbers you'd like to sort: ");
		size=cin.nextInt();
		
		Integer [] OGsort = new Integer[size];
		Intarray(OGsort,size);
		Integer [] lilGsort = Arrays.copyOf(OGsort, size);
		
		Selectionsorts(lilGsort,size);
			lilGsort = Arrays.copyOf(OGsort, size);
		Bubblesorts(lilGsort,size);
			lilGsort = Arrays.copyOf(OGsort, size);
		Insertionsorts(lilGsort,size);
			lilGsort = Arrays.copyOf(OGsort, size);
		Shellsorts(lilGsort,size);
			lilGsort = Arrays.copyOf(OGsort, size);
		Quicksorts(lilGsort,size);
		
			
			
	}

}