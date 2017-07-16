/*
 * Calculates the determine of a matrix 6x6 or smaller.
 */
public class Determinant
{
	int A [][];
	int M[][];
	int N;
		int start;
		int last;
		public Determinant(int A[][], int N, int start, int last)
		{
			this.A = A;
			this.N = N;
			this.start = start;
			this.last = last;
		}
		public int[][] SubArray (int[][] A, int N, int j)
		{
			M = new int[N-1][];
			for (int k = 0; k < (N-1); k++)
					M[k] = new int [N-1];
			for(int i = 1; i < N; i ++)
			{
				int j1 = 0;
				for(int j2 = 0; j2< N; j2++ )
				{
					if(j2 ==j)
						continue;
					M[i-1][j1] = (int) A[i][j2];
					j1++;
				}
			}
			return M;
		}
	//Calculate determinant recursively
	public int determinant(int A[][], int N)
	{
		int cofactor;
		//For 1x1 Matrix
		if (N == 1)
			cofactor = A[0][0];
		//For 2x2 Matrix
		else if (N == 2)
			cofactor = A[0][0]*A[1][1]-A[1][0]*A[0][1];
		//NxN matrix
		else
		{
			cofactor = 0;
			for(int j = 0; j < N; j++)
			{
				M = SubArray(A, N, j);
				cofactor += Math.pow(-1, 1+j+1)*A[0][j]*determinant(M,N-1);
			}
		}
		return cofactor; 
	}
}
