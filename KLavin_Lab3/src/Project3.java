/*
 * Project 3
 * @author		Kristi Lavin
 * @version		1.0				8/5/2017
 * 
 * Entry Point of the application. It outlines the solution of the
 * project and handles input and output files. Evaluates multiple
 * matrices up to order 6 and computes the determinant of the 
 * matrices in a recursive manner using an linked list.
 */


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Project3 {


	public static void main(String[] args) throws IOException 
	{
		BufferedReader 	    br; //Used for input file
		FileReader     	    fr; //Used for input file
		PrintStream    		ps; //Used for output file
		FileOutputStream 	fos; //Used for output file
				
		
		//Check for command line arguments
		if(args.length != 2)
		{
			System.out.println(
					"Usage: Java Project 3 [input file pathname]"
					+ "[Output file pathname]");
			System.exit(1);
		}
		
		//Attempt to open file IO
		try
		{
			//Open Reader
			fr = new FileReader(args[0]);
			br = new BufferedReader(fr);
			//Open writer
			fos = new FileOutputStream(args[1]);
			ps = new PrintStream(fos);
			//System.setOut(ps);
		}
		catch(Exception ioExcept)
		{
			System.err.println(ioExcept.toString());
			return;
		}
		
		//Notify user via console
		System.err.println("Running Project3");
		System.err.println(">All output redirected from console to :\n"
				+ args[1]);
		System.out.println("Running Project3");
		System.out.println("All output redirected from console to:\n"
				+ args[1]);
		
		//Process the input file
		String currentLine;
		//Main file in loop
		while ((currentLine = br.readLine()) != null){
			int N = Integer.parseInt(currentLine);
			//System.out.println(N);
			//Matrix loop
			int A [][] = new int [N][N];
			for (int i = 0; i < N; i++){
				String matrixLine = br.readLine();
				System.out.println(matrixLine);
			}
			
			
			
		}
		//Close reader stream
		br.close();
		//Close writer stream
		ps.close();		
		//Notify of completion
		System.err.println("Finished running Project3!");
		System.out.println("Finished running Project3!");
	}

}