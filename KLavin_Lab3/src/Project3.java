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
		RunTime timing = new RunTime();
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
			System.setOut(ps);
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
			int N = 0;
			try{
				N = Integer.parseInt(currentLine);
			}catch(Exception e){
				System.out.printf("ERROR: Unexpected input, attempting to continue reading file...\n");
				continue;
			}
			
			System.out.printf("\nNEW LINKED LIST MATRIX:\nN: %d\n", N);
			//Matrix loop
			
			LLDeterminant ll = new LLDeterminant(N);
//			System.out.println(ll);
//			for(int i = 0; i < N; i++){
//				for(int j = 0; j < N; j++){
//					ll.setValue(i, j, (i*N)+j);
//				}
//			}
//			ll.setValue(0, 1, -69);
//			ll.setValue(N, N, 69);
//			System.out.println(ll.getValue(0, 0));
//			System.out.println(ll.getValue(N, N));
//			System.out.println(ll);
			
			//Out of bounds test
			//System.out.println(ll.getValue(N, N+1));
			//int[][] A  = new int [N][N];
			boolean colError = false;
			for (int i = 0; i < N; ++i){
				String[] matrixLine = br.readLine().trim().split(" ");
				if(matrixLine.length != N){
					System.out.printf("ERROR: Incorrect input length. %d != %d\n", matrixLine.length, N);
					colError = true;
					break;
				}
				for (int j = 0; j < N; ++j){
					//A[i][j] = Integer.parseInt(matrixLine[j]);
					ll.setValue(i, j, Integer.parseInt(matrixLine[j]));
				}
			}
			
			if(colError){
				continue;
			}
			System.out.print(ll);
			long start = System.nanoTime(); 
			int det = ll.determinant();
			long end = System.nanoTime();
			timing.append(end - start, N);
			System.out.printf("Determinant: %d\n", det);
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