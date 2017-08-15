// Java program for implementation of Heap Sort
public class HeapSort
{
	private static int N;

	//Sort
	public void sort(int j[])
	{       
	    heapify(j);        
	    for (int i = N; i > 0; i--)
	    {
	        swap(j,0, i);
	        N = N-1;
	        swapLargest(j, 0);
	    }
	}     

	//Build a heap
	public static void heapify(int arr[])
	{
	    N = arr.length-1;
	    for (int i = N/2; i >= 0; --i)
	        swapLargest(arr, i);        
	}
	
	//Swap largest element in heap
    public static void swapLargest(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            swapLargest(arr, max);
        }        
    }
	//Swap two numbers in an array
	public static void swap(int arr[], int x, int y)
	{
	    int tmp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = tmp; 
	} 
	// HEAP SORT
    public void heapSort(int[] array, int n) {
		// create first heap
		for (int rootIndex = n/2 - 1; rootIndex >= 0; rootIndex--)
		    reheap(array, rootIndex, n - 1);
		    
		swap(array, 0, n - 1);
		  
		for (int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
		    reheap(array, 0, lastIndex);
		    swap(array, 0, lastIndex);
		} // end for
    }
    
    private static void reheap(int[] heap, int rootIndex, int lastIndex) {
		boolean done = false;
		int orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex + 1;
		  
		while (!done && (leftChildIndex <= lastIndex)) {
		    int largerChildIndex = leftChildIndex;
		    int rightChildIndex = leftChildIndex + 1;
		    if ( (rightChildIndex <= lastIndex) && 
		         heap[rightChildIndex] > heap[largerChildIndex]) {
			largerChildIndex = rightChildIndex;
		    } // end if
		    
		    if (orphan < heap[largerChildIndex]) {
			heap[rootIndex] = heap[largerChildIndex];
			rootIndex = largerChildIndex;
			leftChildIndex = 2 * rootIndex + 1;
		    } 
		    else
			done = true;
		} // end while
		  
		heap[rootIndex] = orphan;
    }
}