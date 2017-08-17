
/*
 * Implementation of Heap Sort 
 * @Version 1.0 
 * @Author K. Lavin
 * Credit: 
 * Manish Bhojasia
 * http://www.sanfoundry.com/java-program-implement-heap-sort/
 */
public class HeapSort
{
	//Swap two numbers in an array
	private static void swap(int arr[], int x, int y)
	{
	    int tmp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = tmp; 
	}
	
	//Main heap sort function
    public void hSort(int[] arr, int n) {
		for (int idx = n/2 - 1; idx >= 0; idx--)
		    createHeap(arr, idx, n - 1);
		    
		swap(arr, 0, n - 1);
		  
		for (int lastIdx = n - 2; lastIdx > 0; lastIdx--) {
		    createHeap(arr, 0, lastIdx);
		    swap(arr, 0, lastIdx);
		}
    }    
    
    private static void createHeap(int[] heap, int mIdx, int endIndex) {
		boolean Done = false;
		int currInt = heap[mIdx];
		int lIdx = 2 * mIdx + 1;
		  
		while (!Done && (lIdx <= endIndex)) {
		    int lgrIdx = lIdx;
		    int rIdx = lIdx + 1;
		    
		    if ( (rIdx <= endIndex) && heap[rIdx] > heap[lgrIdx]) {
		    	lgrIdx = rIdx;
		    }
		    
		    if (currInt < heap[lgrIdx]) {
				heap[mIdx] = heap[lgrIdx];
				mIdx = lgrIdx;
				lIdx = 2 * mIdx + 1;
		    } 
		    else{
		    	Done = true;
		    }
			
		}
		  
		heap[mIdx] = currInt;
    }
}