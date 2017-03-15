import java.io.IOException;

public class ShellSort 
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
    
    public static void shellSort()
    {
    	int[] gapSize = {701, 301, 132, 57, 23, 10, 4, 1};
    	for (int gap : gapSize)
    	{
    		if (gap < SIZE)
    		{
    			for (int i = gap; i < SIZE; i++)
    			{
    				int temp = values[i];
    				int j;
    				for (j = i; j >= gap && values[j - gap] > temp; j -= gap)
    					values[j] = values[j - gap];
    				values[j] = temp;
    			}
    		}
    	}
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
    		shellSort();
    		long temp = System.nanoTime() - startTime;
    		System.out.println(temp + " nanoseconds");
    		endTime += temp;
    	}
    	endTime /= 30;
    	System.out.println("\nThe average was " + endTime + " nanoseconds");
    }   
}
