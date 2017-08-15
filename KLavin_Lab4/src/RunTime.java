/*----------------------------------------------------------------
 *  These methods determine the runtime metrics for Project2
 *  @version    1.0     2017-08-17
 *  @author     Kristi Lavin
 *----------------------------------------------------------------*/
public class RunTime {

	long[] time;
	int[] size;
	int initSize;
	int currentIdx;
	String[] files;
	
	public RunTime(){
		initSize = 50;//size of the array
		time = new long[initSize];//holds time for runtime metric
		size = new int[initSize];//holds size for runtime metric
		files = new String[initSize];
		currentIdx = 0;//index of the array
	}
	
	//Adds time and size to the current size and time counts
	public void append(long time, int size, String f){
		//If time and size array are full it doubles the size of both
		if (currentIdx == this.time.length){
			long[] temptime = new long[this.time.length*2];
			int[] tempsize = new int[this.size.length*2];
			String[] tempstr = new String[this.files.length*2];
			for(int i = 0; i< this.time.length; i ++){
				temptime[i] = this.time[i]; 
				tempsize[i] = this.size[i];
				tempstr[i] = this.files[i];
			}
			//temporarily holds time and size until
			this.time = temptime; 
			this.size = tempsize;
			this.files = tempstr;
		}
		//adds time and size to larger array
		this.time[currentIdx] = time;
		this.size[currentIdx] = size;
		this.files[currentIdx] = f;
		this.currentIdx++;
	}
	//Prints runtime metrics to output file
	public String toString(){
		StringBuilder met;
		met = new StringBuilder();
		met.append("\nRuntime Metrics \n");
		met.append("Size:\tTime:\tMethod+File:\n");
		for (int i = 0; i <currentIdx; i++) {
			met.append(String.format("%4d\t%10d\t%s\n", size[i], time[i], files[i]));
		}
		return met.toString();
	}
}
