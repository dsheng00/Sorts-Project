import java.io.IOException;

public class RadixSort 
{
	public static final int SIZE = 50;          // Size of array to be sorted
    private static int[] values = new int[SIZE];  // Values to be sorted
    
    private static void initValues()
    // Initializes the values array with random integers from 0 to 99
    {
        for (int index = 0; index < SIZE; index++)
            values[index] = (int) (Math.random() * 100) + 1;
    }
    
    
    
    public static void radixSort()
    {
    	
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
    		radixSort();
    		endTime += System.nanoTime() - startTime;
    	}
    	endTime /= 30;
    	System.out.println(endTime + " nanoseconds");
    }   
}
