
public class ShellSort {
 
	//SS using Knuth's sequence
	void sort0(int arr[]){
		int[] gaps = {29524, 9841, 3280, 1093, 364, 121, 40, 13, 4, 1};
		sort(arr, gaps);
	}
	
	
	void sort1(int arr[]){
		int[] gaps = {30341, 10111, 3371, 1123, 373, 149, 53, 17, 5, 1};
		sort(arr, gaps); 
	}
	void sort2(int arr[]){
		int[] gaps = {29160, 9720, 3240, 1080, 360, 120, 60, 30, 10, 1};
		sort(arr, gaps); 
	}
	
	//My shell sort, determines gap based on size of array
	void sort3(int arr[])
    {
		int n = arr.length;
		for (int gap = n/2; gap > 0; gap /= 2)
		{
			for (int i = gap; i < n; i += 1)
			{
				int temp = arr[i]; 
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
			}
		}
		return;
    }
	
	private void sort(int[] arr, int[] gaps){
		for(int gap : gaps){
			if(gap > arr.length){
				continue;
			}
			for (int i = gap; i < arr.length; i++){
				int temp = arr[i];
				int j;
				for(j = i; j >= gap && arr[j-gap] > temp; j -= gap){
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}
	}
}
