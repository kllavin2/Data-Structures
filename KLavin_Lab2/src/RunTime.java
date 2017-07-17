
public class RunTime {
	long[] time;
	int[] size;
	int initSize;
	int currentIdx;
	
	public RunTime(){
		initSize = 50;
		time = new long[initSize];
		size = new int[initSize];
		currentIdx = 0;
	}
	
	public void append(long time, int size){
		if (currentIdx == this.time.length){
			long[] temptime = new long[this.time.length*2];
			int[] tempsize = new int[this.size.length*2];
			for(int i = 0; i< this.time.length; i ++){
				temptime[i] = this.time[i]; 
				tempsize[i] = this.size[i];
			}
			this.time = temptime; 
			this.size = tempsize;
		}
		this.time[currentIdx] = time;
		this.size[currentIdx] = size;
		this.currentIdx++;
	}
	public String toString(){
		StringBuilder met;
		met = new StringBuilder();
		met.append("\n Runtime Metrics: \n");
		met.append("Size:		Time: \n");
		for (int i = 0; i <currentIdx; i++) {
			//Add "size = time\n" to "met" 
			met.append(size[i] + " 			" + time[i] + "\n");
		}
		return met.toString();
	}
}
