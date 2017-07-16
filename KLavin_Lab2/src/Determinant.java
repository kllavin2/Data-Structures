
public class Determinant{
		public void getMinor(int A[][], int temp[][], int n, int p, int q){
			int i = 0; //row
			int j = 0; // column
			int value = 0; //value
			//Loop to get each element in the matrix
			for (int i1 = 0; i1 < n; i1++)
				for (int j1 = 0; j1 < n; j1++){
					//copy into temporary matrix which are give row or a column
					if (i1 != p && j1 !=q)
					temp[i][j++] = A[i1][j1];
					//Row is filled, increase the row reset the column
					if (j1 == n-1)
						j1 = 0;
						i ++;
					
				}
		}
		//Recursive function for finding determinant matrix
		public int determinant(int A[][], int n )
		{
			int det = 0;//Initialize the result
			//Store minors
			int temp[][] = null;
			int sign = 1;
			//Stop case: if the matrix only contains one item
			if (n == 1)
			{
				return A[0][0];
			}
			else if (n ==2)
			{
				det = ((A[0][0]*A[1][1])-(A[0][1]*A[1][0]));
			}
			else 
			{
				for (int f = 0; f < n; f++){
				//Getting minor of A[0][f]
				getMinor(A, temp, 0, f, n);
				det += sign * A[0][f]*determinant(temp, n-1);
				
				//Terms are added with alternate sign
				sign = -sign;
				}
			}				
			return det;
		}
		//Display the matrix
		public void display(int A[][], int i, int j ){
			for (int row = 0; row < i; i++){
					for (int col = 0; col < j; j++){
						System.out.println(A[col][row]);
					}
			}			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
