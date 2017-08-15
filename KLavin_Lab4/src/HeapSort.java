// Java program for implementation of Heap Sort
public class HeapSort
{
	  private static int N;
	    /* Sort Function */
	    public static void sort(int j[])
	    {       
	        heapify(j);        
	        for (int i = N; i > 0; i--)
	        {
	            swap(j,0, i);
	            N = N-1;
	            maxheap(j, 0);
	        }
	    }     
	    /* Function to build a heap */   
	    public static void heapify(int arr[])
	    {
	        N = arr.length-1;
	        for (int i = N/2; i >= 0; i--)
	            maxheap(arr, i);        
	    }
	    /* Function to swap largest element in heap */        
	    public static void maxheap(int arr[], int i)
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
	            maxheap(arr, max);
	        }
	        //OB-FEW-SKATE
	    }    
	    /* Function to swap two numbers in an array */
	    public static void swap(int arr[], int i, int j)
	    {
	        int tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp; 
	    } 
}