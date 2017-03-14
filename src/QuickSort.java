import java.io.*;

public class QuickSort 
{
	public static final int SIZE = 50;          // Size of array to be sorted
    private static int[] values = new int[SIZE];  // Values to be sorted
    
    private static void initValues()
    // Initializes the values array with random integers from 0 to 99
    {
        for (int index = 0; index < SIZE; index++)
            values[index] = (int) (Math.random() * 100) + 1;
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
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
    
    public static void printValues()
    // Prints all the values integers
    {
        System.out.println("The Values array is:");
        for (int index = 0; index < SIZE; index++)
        {
            System.out.print(values[index] + " ");
        }
        System.out.println();
    }
	
	public static void quickSort(int from, int to)
	{
		if (from < to)
		{
			int p = split(from, to);
			quickSort(from, p - 1);
			quickSort(p + 1, to);
		}
	}
	
	public static int split(int from, int to)
	{
		int pivot = values[from];
		int first = from;
		int last = to;
		while (first < last)
		{
			first++;
			while (first < SIZE && values[first] < pivot)
			{
				first++;
			}
			while (values[last] > pivot)
			{
				last--;
			}
			if (first < last)
			{
				swap(first, last);
			}
		}
		swap(from, last);
		return last;
	}
	
    public static void main(String[] args) throws IOException
    // Tests the other methods of the Sorts class
    {
    	long startTime = 0;
    	long endTime = 0;
    	for (int i = 0; i < 30; i++)
    	{
    		initValues();
    		startTime = System.nanoTime();
    		quickSort(0, SIZE - 1);
    		System.out.println(System.nanoTime() - startTime + " nanoseconds");
    		endTime += System.nanoTime() - startTime;
    	}
    	endTime /= 30;
    	System.out.println("The average was " + endTime + " nanoseconds");
    }   
}
