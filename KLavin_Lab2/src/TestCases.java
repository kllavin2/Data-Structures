import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;


public class TestCases {
	
	private long order;
	private long mat;
	public TestCases(long n, long m)
	{
		order = n;
		mat = m; 
	}
	
	
	private static void MatrixGen() throws IOException
	{
		Writer wr;
		try {
			wr = new FileWriter("Input.txt");
			Random gen = new Random();
			int  n = gen.nextInt(50) + 1;
			wr.write(n+System.getProperty("line.separator"));
			wr.close();	
		} 
		
		catch (IOException e) 
		{
			System.err.println("Cannot Write to text file");
			return;
		}	
	}
}
