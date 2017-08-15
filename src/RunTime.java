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
	
	public RunTime(){
		initSize = 50;//size of the array
		time = new long[initSize];//holds time for runtime metric
		size = new int[initSize];//holds size for runtime metric
		currentIdx = 0;//index of the array
	}
	
	//Adds time and size to the current size and time counts
	public void append(long time, int size){
		//If time and size array are full it doubles the size of both
		if (currentIdx == this.time.length){
			long[] temptime = new long[this.time.length*2];
			int[] tempsize = new int[this.size.length*2];
			for(int i = 0; i< this.time.length; i ++){
				temptime[i] = this.time[i]; 
				tempsize[i] = this.size[i];
			}
			//temporarily holds time and size until
			this.time = temptime; 
			this.size = tempsize;
		}
		//adds time and size to larger array
		this.time[currentIdx] = time;
		this.size[currentIdx] = size;
		this.currentIdx++;
	}
	//Prints runtime metrics to output file
	public String toString(){
		StringBuilder met;
		met = new StringBuilder();
		met.append("\n Runtime Metrics \n");
		met.append("Size:		Time: \n");
		for (int i = 0; i <currentIdx; i++) {
			//Add "size = time\n" to "met" 
			met.append(size[i] + " 			" + time[i] + "\n");
		}
		return met.toString();
	}
}
