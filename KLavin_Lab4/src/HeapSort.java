// Java program for implementation of Heap Sort
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
    public void heapSort(int[] arr, int n) {
		for (int idx = n/2 - 1; idx >= 0; idx--)
		    makeHeap(arr, idx, n - 1);
		    
		swap(arr, 0, n - 1);
		  
		for (int lastIdx = n - 2; lastIdx > 0; lastIdx--) {
		    makeHeap(arr, 0, lastIdx);
		    swap(arr, 0, lastIdx);
		}
    }    
    
    private static void makeHeap(int[] heap, int mainIdx, int lastIndex) {
		boolean isDone = false;
		int currInt = heap[mainIdx];
		int lIdx = 2 * mainIdx + 1;
		  
		while (!isDone && (lIdx <= lastIndex)) {
		    int lgrIdx = lIdx;
		    int rIdx = lIdx + 1;
		    
		    if ( (rIdx <= lastIndex) && heap[rIdx] > heap[lgrIdx]) {
		    	lgrIdx = rIdx;
		    }
		    
		    if (currInt < heap[lgrIdx]) {
				heap[mainIdx] = heap[lgrIdx];
				mainIdx = lgrIdx;
				lIdx = 2 * mainIdx + 1;
		    } 
		    else{
		    	isDone = true;
		    }
			
		}
		  
		heap[mainIdx] = currInt;
    }
}