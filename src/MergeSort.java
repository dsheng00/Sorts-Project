import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class MergeSort
{
	public static final int SIZE = 50;          // Size of array to be sorted
	private static int[] values = new int[SIZE];  // Values to be sorted
 
	private static void initValues()
	// Initializes the values array with random integers from 0 to 99
	{
		Random rand = new Random(560);
		for (int index = 0; index < SIZE; index++)
			values[index] = Math.abs(rand.nextInt()) % 100;
	}
 
	public static boolean isSorted()
	// Determine whether the array values are sorted
	{
		boolean sorted = true;
		for (int i = 0; i < values.length - 1; i++)
			if (values[i] > values[i + 1])
				sorted = false;
		return sorted;   
	}
 
	public static void swap(int index1, int index2)
	// Swaps the integers at locations index1 and index2 of array values
	// Precondition:  index1 and index2 are less than size
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}
 	
 	public static void mergeSort(int startIndex, int endIndex)
 	{
 		if (startIndex < endIndex)
        {
            int index = (startIndex + endIndex) / 2;
            mergeSort(startIndex, index);
            mergeSort(index + 1, endIndex);
            merge(startIndex, index, index + 1, endIndex);
        }
 	}
 	
 	public static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
 	{
 		int[] temp = new int[SIZE];
 		int saveFirst = leftFirst;
 		int index = leftFirst;
 		
 		while (leftLast - leftFirst >= 0 && rightLast - rightFirst >= 0)
 		{
 			if (values[leftFirst] < values[rightFirst]) 
 			{
 				temp[index] = values[leftFirst];
 				leftFirst++;
 			}
 			else
 			{
 				temp[index] = values[rightFirst];
 				rightFirst++;
 			}
 			index++;
 		}
 		
 		while (leftFirst <= leftLast)
 	    {
 	        temp[index] = values[leftFirst];
 	        leftFirst++;
 	        index++;
 	    }
 	   
 		while (rightFirst <= rightLast)
 	    {
 	        temp[index] = values[rightFirst];
 	        rightFirst++;
 	        index++;
 	    }
 		
 		for (int i = saveFirst; i <= rightLast; i++)
 	        values[i] = temp[i];
 	}
 
	public static void printValues()
	// Prints all the values integers
	{
		int value;
		DecimalFormat fmt = new DecimalFormat("00");
		System.out.println("the values array is:");
		for (int index = 0; index < SIZE; index++)
		{
			value = values[index];
			if (((index + 1) % 10) == 0)
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");
		}
		System.out.println();
	}
 
	public static void main(String[] args) throws IOException
	{
		long startTime = 0;
    	long endTime = 0;
    	for (int i = 0; i < 30; i++)
    	{
    		initValues();
    		startTime = System.nanoTime();
    		mergeSort(0, SIZE - 1);
    		long temp = System.nanoTime() - startTime;
    		System.out.println(temp + " nanoseconds");
    		endTime += temp;
    	}
    	endTime /= 30;
    	System.out.println("The average was " + endTime + " nanoseconds");
	}   
}
