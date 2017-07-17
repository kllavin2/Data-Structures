
public class MatrixArray {
	int[][] MA;//2D array to hold matrix
	int N;//element in the matrix
	
	/*assigns the values of the parameters MA and N 
	 * to the field of the same name
	 */
	public MatrixArray(int[][] MA){
		this.MA = MA;
		this.N = MA.length;
	}
	

	/*Prints out the matrix (loops tru row, then column) for the length of 
	the array
	*/
	public String toString(){
		String ret = "MatrixArray:\n";
		for (int i = 0; i < this.MA.length; i++) {
			for (int j = 0; j < this.MA[i].length; j++){
				if (j > 0) {
					ret += ", ";
		        }
		        ret += String.valueOf(this.MA[i][j]);
			}
			ret += "\n";
		}
		return ret;
	}
	
	/*Removes a column/row from the array above to create a 
	/*new array that holds the new minor.
	 */
	public MatrixArray minor(int col){		
		int newN = this.N - 1;
		int[][] matrix = new int[newN][newN];
		
		int i2 = 0;
		for(int i = 1; i < this.N; i++){						
			int j2 = 0;
			for (int j = 0; j < this.N; j++){
				if (j == col) continue;				
				matrix[i2][j2] = this.MA[i][j];
				j2++;
			}
			i2++;
		}		
		return new MatrixArray(matrix);
	}
	//Computes the determinant recursively 
	public int determinant(){
		int ret = 0;
		if (this.N == 1){
			ret = this.MA[0][0];
		}
		else{
			for (int j = 0; j < this.N; j++){
				ret += Math.pow(-1,  j) * this.MA[0][j] * 
						this.minor(j).determinant();
			}
		}
		return ret;
	}
}
