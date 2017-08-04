/*
 * Calculates the determinate of a sparse matrix using linked list.
 * @Version 1.0 
 * @Author K. Lavin
 */
public class LLDeterminant
{
	Node head;	//Head node
	int N; 		//Number of rows / cols
		
		public LLDeterminant(int N)
		{
			this.head = new Node(-1,-1, 0, null);
			this.N = N;
			
			Node current = this.head;
			for(int r = 0; r < this.N; r++){
				for(int c = 0; c < this.N; c++){
					current.next = new Node(r, c, 0, null);
					current = current.next;
				}				
			}			
		}
		
		public String toString(){
			String ret = "LLDeterminant Object:\n";
			Node current = head;
			
			for (int i = 0; i < this.N; i++) {
				for (int j = 0; j < this.N; j++){
					if (j > 0) {
						ret += ", ";
			        }				
			        ret += String.valueOf(current.next.value);
			        current = current.next;
				}
				ret += "\n";
			}
			return ret;
		}
		
		//getElement returns the integer value stored at the coordinate
		public int getValue(int row, int col)
		{
			//Bounds checking
			if(row > this.N || col > this.N){
				throw new IndexOutOfBoundsException(String.format("Node (%d, %d) is out of bounds!", row, col));				
			}
			int retVal = this.head.value;
			Node current = this.head; // the node that will traverse the matrix
			for(int i = 0; i < this.N; i++){
				for(int j = 0; j < this.N; j++){
					current = current.next;
					if(current.row == row && current.col == col){
						retVal = current.value;
					}
				}
			}
			return retVal;
		}
		
		//Set a value to a particular coordinate in the matrix to a certain value
		public void setValue(int row, int col, int newValue)
		{
			//Bounds checking
			if(row > this.N || col > this.N){
				throw new IndexOutOfBoundsException(String.format("Node (%d, %d) is out of bounds!", row, col));				
			}
			
			Node current = this.head; // the node that will traverse the matrix
			for(int i = 0; i < this.N; i++){
				for(int j = 0; j < this.N; j++){
					current = current.next;
					if(current.row == row && current.col == col){
						current.value = newValue;
					}
				}
			}
			return;
		}
		
		/*Removes a column/row from this object to create a 
		/*new object that holds the new minor.
		 */
		private LLDeterminant minor(int col){		
			int newN = this.N - 1;
			//int[][] matrix = new int[newN][newN];
			LLDeterminant ll = new LLDeterminant(newN);
			
			int i2 = 0;
			for(int i = 1; i < this.N; i++){						
				int j2 = 0;
				for (int j = 0; j < this.N; j++){
					if (j == col) continue;				
					//matrix[i2][j2] = this.MA[i][j];
					ll.setValue(i2, j2, this.getValue(i, j));
					j2++;
				}
				i2++;
			}		
			//return new MatrixArray(matrix);
			return ll;
		}
		

		//Computes the determinant recursively 
		public int determinant(){
			int ret = 0;
			if (this.N == 1){
				//ret = this.MA[0][0];
				ret = this.getValue(0, 0);
			}
			else if(this.N == 2){
				ret = this.getValue(0, 0) * this.getValue(1, 1) 
						- this.getValue(1,0) * this.getValue(0, 1);
			}
			else{
				for (int j = 0; j < this.N; j++){
					//ret += Math.pow(-1,  j) * this.MA[0][j] * this.minor(j).determinant();
					ret += Math.pow(-1,  j) * this.getValue(0, j) * this.minor(j).determinant();
				}
			}
			return ret;
		}
}
