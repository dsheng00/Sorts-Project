public class MergeSort 
{
	public static final int SIZE = 50;				// Size of array to be sorted
    private static int[] values = new int[SIZE];  	// Values to be sorted
    
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
			int middleIndex = (startIndex + endIndex) / 2;
			mergeSort(startIndex, middleIndex);
			mergeSort(middleIndex + 1, endIndex);
			merge(startIndex, middleIndex, middleIndex + 1, endIndex);
		}
	}
	
	public static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
	{
		int saveFirst = leftFirst;
		int index = leftFirst;
		int[] tempArray = new int[SIZE];
		
		while (leftFirst <= leftLast && rightFirst <= rightLast)
		{
			if (values[leftFirst] < values[rightFirst])
			{
				tempArray[index] = values[leftFirst];
				leftFirst++;
			}
			else
			{
				tempArray[index] = values[rightFirst];
				rightFirst++;
			}
			index++;
		}
		
		while (leftFirst <= leftLast)
		{
			tempArray[index] = values[leftFirst];
			leftFirst++;
			index++;
		}
		
		while (rightFirst <= rightLast)
		{
			tempArray[index] = values[rightFirst];
			rightFirst++;
			index++;
		}
		
		for (int i = saveFirst; i <= rightLast; i++)
		{
			values[i] = tempArray[i];
		}
	}
}
