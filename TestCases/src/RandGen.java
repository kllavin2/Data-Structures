import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;


public class RandGen {
	public static void main(String[] args) 
	{
		try
		{
			//Writes to output file TestCases.txt
			PrintWriter wr = new PrintWriter("TestCases.txt");
			//loop to create 50 random matrices
			for(int i = 0; i <50; i++)
			{
				//create random n size for test matrices 1 to 50
				int randOrder = ThreadLocalRandom.current().nextInt(1,50);
				wr.println(randOrder+"\n");
				//nested for loop to create matrices based on size of n
				for (int j = 0; j < randOrder; ++j)
				{
					for (int k = 0; k < randOrder; ++k)
					{   
						//Creates Random elements inside the matrix
						int Rele = ThreadLocalRandom.current().
								nextInt(-9,9);
						//Prints out the input matrix to output text
						wr.print(Rele+ " ");
					}
					wr.println("\n");
				}	
				
			}
			//closes the writer
			wr.close();
		}
		catch(IOException e){
			System.out.println("Error");
			return;
		}
	}
}



