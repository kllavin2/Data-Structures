/*
 * Project 2
 * @author		Kristi Lavin
 * @version		1.0				7/17/2017
 * 
 * Entry Point of the application. It outlines the solution of the
 * project and handles input and output files. Evaluates multiple
 * matrices up to order 6 and computes the determinant of the 
 * matrices in a recursive manner. 
 */


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class Project2 {
	
	public static void main(String[] args) throws IOException 
	{
		RunTime R = new RunTime();//Run time 
		BufferedReader 	    br; //Used for input file
		FileReader     	    fr; //Used for input file
		PrintStream    		ps; //Used for output file
		FileOutputStream 	fos; //Used for output file	
			
		//Check for command line arguments
		if(args.length != 2)
		{
			System.out.println(
					"Usage: Java Project 2 [input file pathname]"
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
			System.setOut(ps);
		}
		catch(Exception ioExcept)
		{
			System.err.println(ioExcept.toString());
			return;
		}
		
		//Notify user via console
		System.err.println("Running Project2");
		System.err.println(">All output redirected from console to :\n"
				+ args[1]);
		System.out.println("Running Project2");
		System.out.println("All output redirected from console to:\n"
				+ args[1]);
		
		//Process the input file
		String currentLine;
		//Main file in loop
		while ((currentLine = br.readLine()) != null){
			int N = Integer.parseInt(currentLine);
			//Matrix loop
			int[][] A  = new int [N][N];
			for (int i = 0; i < N; ++i){
				String[] matrixLine = br.readLine().trim().split(" ");
				for (int j = 0; j < N; ++j){
					A[i][j] = Integer.parseInt(matrixLine[j]);
				}
			}
			//
			MatrixArray currMat = new MatrixArray(A);
			//Prints out the input matrix
			System.out.println(currMat);
			//Start time 
			long start =System.nanoTime();
			//Prints out the determinant
			System.out.println("Determinant: " 
								+ currMat.determinant() 
								+ "\n");
			//end time 
			long end = System.nanoTime();
			//Record N and time
			R.append(end-start,N);	
		}
		//Prints Runtime metrics
		System.out.println(R);
		//Close reader stream
		br.close();
		//Close writer stream
		ps.close();
		
		
		//Notify of completion
		System.err.println("Finished running Project2!");
		System.out.println("Finished running Project2!");
	}
	
	/*
	 * Temporary print string array function for testing purposes
	 */
	private static void printArr(String[] sArr) {
		for (int i = 0; i < sArr.length; i++) {
			if (i > 0) {
				System.out.print(", ");
	        }
	        System.out.print(sArr[i]);
		}
	}


}
