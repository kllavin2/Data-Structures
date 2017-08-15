/*
 * Project 4
 * @author		Kristi Lavin
 * @version		1.0				8/17/2017
 * 
 * Entry Point of the application. It outlines the solution of the
 * project and handles input and output files. Compares HeapSort 
 * and shell sorts iteratively 
 */
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Project4 {


	public static void main(String[] args) throws IOException 
	{
		RunTime timing = new RunTime();
		BufferedReader 	    br; //Used for input file
		FileReader     	    fr; //Used for input file
		PrintStream    		ps; //Used for output file
		FileOutputStream 	fos; //Used for output file
				
		//Check for command line arguments
		if(args.length != 1)
		{
			System.out.println(
					"Usage: Java Project 4 [input file pathname]"
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
		System.err.println("Running Project4");
		System.err.println(">All output redirected from console to :\n"
				+ args[1]);
		System.out.println("Running Project4");
		System.out.println("All output redirected from console to:\n"
				+ args[1]);
		
		//Process the input file
		HeapSort HS = new HeapSort();
		int n;
		int arr[ ] = new int[n];
		String line = br.readLine();//to read multiple integer line
		String[] strs = line.trim().split("\\s+");
		for(int i = 0; i < n; i++ )
		{
			HS.sort(Integer.parseInt(strs[i]));		
			System.out.print(HS);
			//Runtime metrics
			long start = System.nanoTime(); 
			long end = System.nanoTime();
			timing.append(end - start, n);
			//Display Determinant
			System.out.printf("Determinant: %d\n");
		}
		System.out.println(timing);
		//Close reader stream
		br.close();
		//Close writer stream
		ps.close();		
		//Notify of completion
		System.err.println("Finished running Project3!");
		System.out.println("Finished running Project3!");
	}

}
